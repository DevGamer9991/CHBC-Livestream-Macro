package com.parker;

import com.parker.HTTPServer.HTTPServer;
import com.parker.MainWindow.MainWindow;

import java.awt.*;
import java.awt.datatransfer.*;
import java.io.*;

public class App
{
  // App ID: 186968813458771

  public static void main (String[] args) throws Exception{
    new HTTPServer().startServer();

    new GetFacebookData().openLoginPage();

    Thread.sleep(2000);
    new MainWindow().openMainWindow();
  }
}