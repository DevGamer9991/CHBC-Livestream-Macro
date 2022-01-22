package com.parker;

import com.parker.facebook.GetFacebookData;

import javax.swing.*;
import java.io.IOException;

public class App
{
  public static final String DevKey = "AIzaSyCuumDlKGiJJdHa5IIkp5FxydAjn7zUAhY";
  // App ID: 186968813458771

  // ISO 8601 Date and Time Format: 2021-07-31T20:37

  public static String osDir;

  public static void main(String[] args) throws Exception {
    Run(args);

//    openGUI();
  }

  public static void openGUI () {
    JFrame frame = new JFrame("Main GUI Form");
    frame.setContentPane(new MainGUIWindow().panel);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(420, 420);
    frame.setResizable(false);
    frame.pack();
    frame.setVisible(true);
  }

  public static void Run(String[] args) throws IOException {
    try {
      for (Object o : args) {
        if (o.toString().equals("-l")) {
          Logger.consoleEnabled = true;
          Logger.println("Debug Logging Enabled");
        }
      }
    } catch (IndexOutOfBoundsException e) {
      e.printStackTrace();
    }

    osDir = ConfigManager.chechArch();
    Logger.println(osDir);

    ConfigManager.createContainer(osDir);

    new GetFacebookData().checkDataFile();
    new GetFacebookData().checkKeystore("keystore.jks");
    new HTTPSServer().startServer();
  }
}