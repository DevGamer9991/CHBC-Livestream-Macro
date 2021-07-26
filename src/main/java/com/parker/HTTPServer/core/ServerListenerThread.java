package com.parker.HTTPServer.core;

import com.parker.MainWindow.MainWindow;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerListenerThread extends Thread {

    private int port;
    private ServerSocket serverSocket;

    //private final static Logger LOGGER = (Logger) LoggerFactory.getLogger(ServerListenerThread.class);

    public ServerListenerThread(int port) throws IOException{
        this.port = port;
        this.serverSocket = new ServerSocket(this.port);
    }

    @Override
    public void run() {
        try {
            while(serverSocket.isBound() && !serverSocket.isClosed()) {
                Socket socket = serverSocket.accept();

                System.out.println(" * Connection accepted: " + socket.getInetAddress());

                HttpConnectionWorkerThread worker = new HttpConnectionWorkerThread(socket);
                worker.run();
            }
        } catch(IOException e) {
            System.out.println("Problem With Setting Socket");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(serverSocket!=null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {}
            }
        }
    }
    
}
