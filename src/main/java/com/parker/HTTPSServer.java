package com.parker;

public class HTTPSServer {

    HTTPSServerThread thread;

    public void startServer() {
        Logger.printlnOverride("Server starting...");
        Logger.printlnOverride("Using Port: " + 5000);

        thread = new HTTPSServerThread();
        thread.start();
    }

    public void stopServer() {
        thread.stop();
    }

    public void restartServer() {
        stopServer();
        startServer();
    }
}
