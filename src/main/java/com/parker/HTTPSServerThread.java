package com.parker;

import com.parker.MainWindow.MainWindow;
import com.parker.facebook.GetFacebookData;
import com.sun.net.httpserver.*;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLParameters;
import java.io.*;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.security.KeyStore;

import static java.net.HttpURLConnection.HTTP_OK;

public class HTTPSServerThread extends Thread{

    public static boolean loginOpened = false;

    @Override
    public void run() {
        try {
            InetSocketAddress address = new InetSocketAddress("localhost",5000);

            startServer(address.getPort());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void startServer(int port) throws Exception {
        HttpsServer server = HttpsServer.create(new InetSocketAddress(port), 0);

        Path keystorePath = Path.of(App.osDir + "/keystore.jks");
        char[] keystorePass = "chbcmacro".toCharArray();

        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(new FileInputStream(keystorePath.toFile()), keystorePass);

        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("SunX509");
        keyManagerFactory.init(keyStore, keystorePass);

        SSLContext sslContext = SSLContext.getInstance("TLS");
        // Null means using default implementations for TrustManager and SecureRandom
        sslContext.init(keyManagerFactory.getKeyManagers(), null, null);

        server.setHttpsConfigurator(new HttpsConfigurator(sslContext) {
            public void configure(HttpsParameters params) {
                try {
                    // Initialise the SSL context
                    SSLContext c = SSLContext.getDefault();
                    SSLEngine engine = c.createSSLEngine();
                    params.setNeedClientAuth(false);
                    params.setCipherSuites(engine.getEnabledCipherSuites());
                    params.setProtocols(engine.getEnabledProtocols());

                    // Get the default parameters
                    SSLParameters defaultSSLParameters = c.getDefaultSSLParameters();
                    params.setSSLParameters(defaultSSLParameters);
                } catch (Exception ex) {
                    Logger.println("Error");
                }
            }
        });

        server.setExecutor(null);
        server.start();

        if(!loginOpened) {
            new GetFacebookData().openLoginPage(5000);
            loginOpened = true;
        }

        HttpHandler tokenHandler = new HttpHandler() {
            @Override
            public void handle(HttpExchange exchange) throws IOException {
                write(exchange, exchange.getResponseHeaders());

                if (!exchange.getRequestURI().getRawQuery().equals("")) {
                    Logger.println(exchange.getRequestURI().getRawQuery());

                    new GetFacebookData().checkStreamFBBox();
                    new GetFacebookData().checkStreamYTBox();

                    try {
                        new GetFacebookData().setAccessToken(exchange.getRequestURI().getRawQuery());

                        if (new GetFacebookData().getYTEnabled()) {
                            new CreateYoutubeStream().auth();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    Logger.printlnOverride("Connection Process Finished");

                    Logger.printlnOverride("Opening Main Window");

                    try {
                        if (!new MainWindow().getOpened()) {
                            new MainWindow().openMainWindow();
                        } else {
                            Logger.println("Already Opened");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    server.stop(1000);

                    Logger.println("Server Stopped");
                }
            }
        };

        server.createContext("/token", tokenHandler);
    }

    public void write(HttpExchange exchange, Headers headers) throws IOException {
        try (OutputStream os = exchange.getResponseBody()) {
            exchange.sendResponseHeaders(HTTP_OK, 0);
            headers.add("ContentType", "text/html");

            String html = null;

            html = getHTML();

            final String CRLF = "\n\r";

            String response = html;

            OutputStreamWriter doc = new OutputStreamWriter(os, StandardCharsets.UTF_8);

            doc.write(response);

            doc.flush();
        }
    }

    public String getHTML() {
        try {
            InputStream in = getClass().getResourceAsStream("/html/index.html");
            int bufferSize = 1024;
            char[] buffer = new char[bufferSize];
            StringBuilder out = new StringBuilder();
            InputStreamReader reader = new InputStreamReader(in, StandardCharsets.UTF_8);
            for (int numRead; (numRead = reader.read(buffer, 0, buffer.length)) > 0; ) {
                out.append(buffer, 0, numRead);
            }
            return out.toString();
        }catch (Exception e) {
            Logger.printlnOverride("Error reading FIle");
            e.printStackTrace();
            return null;
        }
    }
}
