package com.parker;

import com.parker.HTTPServer.HTTPServer;
import com.parker.MainWindow.MainWindow;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

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