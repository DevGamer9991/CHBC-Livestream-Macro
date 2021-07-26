package com.parker;

import com.parker.MainWindow.MainWindow;

import java.awt.*;
import java.awt.datatransfer.*;
import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.util.Scanner;

public class App
{
  // App ID: 186968813458771

  public static Integer port = 5000;

  public static void main (String[] args) throws Exception{

    new HTTPSServer().startServer();
    new GetFacebookData().openLoginPage(port);

    Thread.sleep(2000);
    new MainWindow().openMainWindow();
  }
}