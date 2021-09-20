package com.parker;

import com.parker.facebook.GetFacebookData;

public class App
{
  public static final String DevKey = "AIzaSyCuumDlKGiJJdHa5IIkp5FxydAjn7zUAhY";
  // App ID: 186968813458771

  // ISO 8601 Date and Time Format: 2021-07-31T20:37

  /*
    THINGS TO ADD:

      • Web GUI ( Using Nodejs or JS )
        •) Livestream Preview

   */

  public static void main(String[] args) throws Exception {
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

    new GetFacebookData().checkDataFile();
    new HTTPSServer().startServer();
  }
}