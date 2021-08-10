package com.parker;

import com.parker.MainWindow.MainWindow;
import com.parker.youtube.*;
import com.sun.tools.javac.Main;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.jar.JarFile;

public class App
{

  public static final String DevKey = "AIzaSyCuumDlKGiJJdHa5IIkp5FxydAjn7zUAhY";
  // App ID: 186968813458771

    // ISO 8601 Date and Time Format: 2021-07-31T20:37

  public static Integer port = 5000;

  public static void main(String[] args) throws Exception{
    new HTTPSServer().startServer();
  }
}