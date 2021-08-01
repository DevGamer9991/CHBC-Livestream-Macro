package com.parker;

import com.parker.MainWindow.MainWindow;
import com.parker.youtube.*;

import java.awt.*;
import java.awt.datatransfer.*;
import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.security.GeneralSecurityException;
import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Scanner;

public class App
{

  public static final String DevKey = "AIzaSyCuumDlKGiJJdHa5IIkp5FxydAjn7zUAhY";
  // App ID: 186968813458771

    // ISO 8601 Date and Time Format: 2021-07-31T20:37

  public static Integer port = 5000;

  public static void main (String[] args) throws Exception{
    new App().firstAuth();

//    new HTTPSServer().startServer();
//    new GetFacebookData().openLoginPage(port);
  }

  public void firstAuth() throws GeneralSecurityException, IOException {
    Authorize auth = new Authorize();
    auth.authorize();
    new CreateBroadcast().create(DevKey);
    new CreateStream().create(DevKey);
//    new BindBroadcast().bind("lxHYRPhbWHI", "6_D5ml1dU4SaK6ilhkeqVA1627838454504229", DevKey);
    new GetStreamFromID().get("6_D5ml1dU4SaK6ilhkeqVA1627838454504229");
  }

  // 6_D5ml1dU4SaK6ilhkeqVA1627838454504229
  // lxHYRPhbWHI
}