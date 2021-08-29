package com.parker;

import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.parker.facebook.GetFacebookData;
import com.sun.net.httpserver.*;
import org.slf4j.LoggerFactory;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLParameters;
import java.io.*;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.sql.SQLSyntaxErrorException;

import static java.net.HttpURLConnection.HTTP_OK;

public class App
{

  public static final String DevKey = "AIzaSyCuumDlKGiJJdHa5IIkp5FxydAjn7zUAhY";
  // App ID: 186968813458771

  // ISO 8601 Date and Time Format: 2021-07-31T20:37

  public static void main(String[] args) throws Exception {
    new GetFacebookData().checkDataFile();
    new HTTPSServer().startServer();
  }
}