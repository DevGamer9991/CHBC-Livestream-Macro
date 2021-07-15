package com.parker.HTTPServer;

import java.io.IOException;

import com.parker.HTTPServer.core.ServerListenerThread;

public class HTTPServer
{
    public int port = 5000;

    //private final static Logger LOGGER = (Logger) LoggerFactory.getLogger(HTTPServer.class);

    public void startServer()
    {
        System.out.println("Server starting...");
        System.out.println("Using Port: " + port);

        ServerListenerThread serverListenerThread;
        try {
            serverListenerThread = new ServerListenerThread(port);
            serverListenerThread.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
