package com.parker;

import com.parker.MainWindow.MainWindow;
import com.parker.youtube.*;
import com.sun.tools.javac.Main;

public class App
{

  public static final String DevKey = "AIzaSyCuumDlKGiJJdHa5IIkp5FxydAjn7zUAhY";
  // App ID: 186968813458771

    // ISO 8601 Date and Time Format: 2021-07-31T20:37

  public static Integer port = 5000;

  public static void main (String[] args) throws Exception{
    new App().auth();

//    new HTTPSServer().startServer();
//    new GetFacebookData().openLoginPage(port);
  }

  public void auth() throws Exception {
    Authorize auth = new Authorize();
    auth.authorize();

    new CreateBroadcast().create("Test Title", "Test Desc", DevKey);

    if (new ManageYoutubeData().checkFile("Data Files/YoutubeData.json")) {

      if (new ManageYoutubeData().getStreamIDFromFile() != null) {
        System.out.println("Ran Check");
        new CheckStreamID().check(new ManageYoutubeData().getStreamIDFromFile());
      } else {
        System.out.println("Didn't Run Check");
        new CreateStream().create(DevKey);
        new ManageYoutubeData().saveFile();
      }

    } else {
      new CreateStream().create(DevKey);
      new ManageYoutubeData().saveFile();
    }

    ManageYoutubeData manageYoutubeData = new ManageYoutubeData();

    manageYoutubeData.setStreamKeyFromFile();

    System.out.println("Binding");

    new BindBroadcast().bind(manageYoutubeData.getBroadcastID(), manageYoutubeData.getStreamID(), DevKey);

    System.out.println(new ManageYoutubeData().getBroadcastID());
    System.out.println(new ManageYoutubeData().getStreamID());
    System.out.println(new ManageYoutubeData().getStreamURL());
    System.out.println(new ManageYoutubeData().getStreamKey());
  }
}