package com.parker;

public class HTTPSServer {

    public void startServer() {
        System.out.println("Server starting...");
        System.out.println("Using Port: " + 5000);

        HTTPSServerThread thread = new HTTPSServerThread();
        thread.start();
    }
}
