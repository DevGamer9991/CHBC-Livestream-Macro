package com.parker;

import com.parker.facebook.GetFacebookData;
import com.parker.youtube.Authorize;
import com.parker.youtube.GetBroadcastData;

public class App
{

  public static final String DevKey = "AIzaSyCuumDlKGiJJdHa5IIkp5FxydAjn7zUAhY";
  // App ID: 186968813458771

    // ISO 8601 Date and Time Format: 2021-07-31T20:37

  public static Integer port = 5000;

  public static void main(String[] args) throws Exception{
    new GetFacebookData().checkDataFile();
    new HTTPSServer().startServer();
  }
}