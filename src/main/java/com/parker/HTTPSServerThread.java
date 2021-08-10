package com.parker;

import com.parker.MainWindow.MainWindow;
import com.parker.facebook.GetFacebookData;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.security.KeyStore;

public class HTTPSServerThread extends Thread{

    public static boolean loginOpened = false;

    @Override
    public void run() {
        InetSocketAddress address = new InetSocketAddress("localhost",5000);

        startServer(address);
    }

    public void startServer(InetSocketAddress address) {
        try {
            Path keystorePath = Path.of("Data Files/keystore.jks");
            char[] keystorePass = "chbcmacro".toCharArray();

            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(new FileInputStream(keystorePath.toFile()), keystorePass);

            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("SunX509");
            keyManagerFactory.init(keyStore, keystorePass);

            SSLContext sslContext = SSLContext.getInstance("TLS");
            // Null means using default implementations for TrustManager and SecureRandom
            sslContext.init(keyManagerFactory.getKeyManagers(), null, null);

            ServerSocket serverSocket = sslContext.getServerSocketFactory().createServerSocket(address.getPort(), 0, address.getAddress());

            if(!loginOpened) {
                new GetFacebookData().openLoginPage(5000);
                loginOpened = true;
            }

            while (true) {
                try {
                    Socket socket = serverSocket.accept();

                    System.out.println("Connection on " + socket.getInetAddress());

                    InputStream input = null;
                    OutputStream output = null;
                    try{
                        input = socket.getInputStream();
                        output = socket.getOutputStream();

                        String html = null;

                        html = getHTML();

                        final String CRLF = "\n\r";

                        String response =
                                "HTTP/1.1 200 OK" + CRLF +
                                        "Content-Length: " + html.getBytes().length + CRLF +
                                        CRLF +
                                        html +
                                        CRLF + CRLF ;

                        output.write(response.getBytes());

                        new GetFacebookData().setAccessToken(input);

                        new CreateYoutubeStream().auth();

//                        new MainWindow().setFBName(new GetFacebookData().getName());
//                        new MainWindow().setYTName(new GetYoutubeName().get());

                        System.out.println("Connection Process Finished");

                        System.out.println("Opening Main Window");

                        if (!new MainWindow().getOpened()) {
                            new MainWindow().openMainWindow();
                        } else {
                            System.out.println("Already Opened");
                        }

                        serverSocket.close();
                        stop();

                    }catch(IOException e){
                        System.out.println("Problem With Communication");
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        if (input!=null) {
                            try {
                                input.close();
                            } catch (IOException e) {
                            }
                        }
                        if (output!=null) {
                            try {
                                output.close();
                            } catch (IOException e) {
                            }
                        }
                        if (socket!=null) {
                            try {
                                socket.close();
                            } catch (IOException e) {
                            }
                        }
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
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
            System.out.print("Error reading FIle \n");
            e.printStackTrace();
            return null;
        }
    }


}
