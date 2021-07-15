package com.parker;

import com.parker.HTTPServer.HTTPServer;
import com.parker.MainWindow.MainWindow;

public class App
{
  // App ID: 703083304425017

  public static void main (String[] args) throws Exception{  

    new HTTPServer().startServer();

    new GetFacebookData().openLoginPage();

    Thread.sleep(2000);
    new MainWindow().openMainWindow();
  }
}