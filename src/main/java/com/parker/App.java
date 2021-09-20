package com.parker;

import com.parker.Logger.Logger;
import com.parker.facebook.GetFacebookData;

import java.util.Arrays;

public class App
{
  public static final String DevKey = "AIzaSyCuumDlKGiJJdHa5IIkp5FxydAjn7zUAhY";
  // App ID: 186968813458771

  // ISO 8601 Date and Time Format: 2021-07-31T20:37

  /*
    THINGS TO ADD:

    • Livestream Preview
    • Add Togglable Console Logging
    • Web GUI ( Using Nodejs and/or React )

    DONE THINGS:

   */

  public static void main(String[] args) throws Exception {
    Logger.consoleEnabled = false;

    new GetFacebookData().checkDataFile();
    new HTTPSServer().startServer();
  }
}