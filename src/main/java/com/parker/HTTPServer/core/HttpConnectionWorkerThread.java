package com.parker.HTTPServer.core;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import com.parker.GetFacebookData;
import com.parker.MainWindow.MainWindow;
import com.sun.net.httpserver.HttpsServer;

public class HttpConnectionWorkerThread extends Thread {

    private Socket socket;

    //private final static Logger LOGGER = (Logger) LoggerFactory.getLogger(HttpConnectionWorkerThread.class);

    public HttpConnectionWorkerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
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

            new GetFacebookData().saveAccessToken(input);

            System.out.println("Connection Process Finished");
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
