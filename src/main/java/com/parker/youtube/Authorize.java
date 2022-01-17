package com.parker.youtube;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.auth.oauth2.TokenResponse;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.auth.oauth2.GoogleRefreshTokenRequest;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.youtube.YouTube;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.parker.App;
import com.parker.Logger;
import com.parker.MainWindow.MainWindow;
import com.parker.facebook.GetFacebookData;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Authorize {
    private static final String CLIENT_SECRETS = "/client_secret.json";
    private static final Collection<String> SCOPES =
            Arrays.asList("https://www.googleapis.com/auth/youtube");

    private static final String APPLICATION_NAME = "CHBC Livestream Macro Youtube";
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();

    public static String Devkey = App.DevKey;

    public static Credential credential;

    public static String refreshToken;

    int timeOut;

    public void authorize() throws Exception {
        final NetHttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();

        File file = new File(App.osDir + "/RefreshToken.json");
        if(!file.exists()) {
            try {
                // Load client secrets.
                InputStream in = Authorize.class.getResourceAsStream(CLIENT_SECRETS);
                GoogleClientSecrets clientSecrets =
                        GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));
                // Build flow and trigger user authorization request.
                GoogleAuthorizationCodeFlow flow =
                        new GoogleAuthorizationCodeFlow.Builder(httpTransport, JSON_FACTORY, clientSecrets, SCOPES)
                                .build();

                Credential credential =
                        new AuthorizationCodeInstalledApp(flow, new LocalServerReceiver()).authorize("user");

                saveRefreshToken(credential.getRefreshToken());
            } catch(Exception e) {
                e.printStackTrace();
                System.exit(1);
            }

        } else {
            credential = getCredentials(httpTransport);
        }

        MainWindow.INSTANCE.setYTName(new GetYoutubeName().get());
        MainWindow.INSTANCE.setYTConnected();
        new GetFacebookData().setYTEnabled();
    }

    public void saveRefreshToken(String refreshToken) {
        try {
            Map<String, Object> map = new HashMap<>();
            map.put("refreshToken", refreshToken);

            Writer writer = new FileWriter(App.osDir + "/RefreshToken.json");

            Gson gson = new Gson();

            gson.toJson(map, writer);

            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Credential getCredentials(NetHttpTransport httpTransport) throws Exception {
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();

        InputStream in = Authorize.class.getResourceAsStream(CLIENT_SECRETS);
        if (in == null) {
            throw new FileNotFoundException("Resource not found: /client_secrets.json");
        }
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

        String clientId = clientSecrets.getDetails().getClientId();
        String clientSecret = clientSecrets.getDetails().getClientSecret();

        GoogleCredential credential = new GoogleCredential.Builder()
                .setTransport(HTTP_TRANSPORT)
                .setJsonFactory(JSON_FACTORY)
                .setClientSecrets(clientId, clientSecret)
                .build();

        try {
            File file = new File(App.osDir + "/RefreshToken.json");
            if (file.exists()) {
                Logger.println("Found File");
                // create Gson instance
                Gson gson = new Gson();

                // create a reader
                Reader reader = Files.newBufferedReader(Paths.get(App.osDir + "/RefreshToken.json"));

                // convert JSON file to map
                JsonObject object = gson.fromJson(reader, JsonObject.class);

                String token = object.get("refreshToken").getAsString();

                Logger.println(token);

                // close reader
                reader.close();

                refreshToken = token;
            } else {
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
        try {
            credential.setAccessToken(useRefreshToken(refreshToken, httpTransport));
        }catch (Exception e){
            new MainWindow().errorCalled(Arrays.toString(e.getStackTrace()));
        }
        credential.setRefreshToken(refreshToken);

        return credential;
    }

    public String useRefreshToken(String refreshToken, NetHttpTransport httpTransport) throws Exception {
        try{
            TokenResponse tokenResponse = new GoogleRefreshTokenRequest(httpTransport, JacksonFactory.getDefaultInstance(), refreshToken, "895756277270-irp13i4jovn0codvnefgisu0k78draho.apps.googleusercontent.com", "flAkUj9xOcQeYItZPvqJpsPG").setGrantType("refresh_token").setScopes(SCOPES).execute();
            Logger.println(tokenResponse + "\n");

            Logger.println(tokenResponse.getAccessToken());

            return tokenResponse.getAccessToken();
        } catch (Exception e){
            if (timeOut == 20) new MainWindow().errorCalled(Arrays.toString(e.getStackTrace()));
            Thread.sleep(1000);
            Logger.println("Error When Authorizing Retrying and Ending in " + timeOut + " Out of 20 Retries");
            timeOut++;
            return useRefreshToken(refreshToken, httpTransport);
        }
    }

    public Credential getCredential() {
        return this.credential;
    }

    public YouTube getService() throws GeneralSecurityException, IOException {
        final NetHttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
        Credential credential = new Authorize().getCredential();
        return new YouTube.Builder(httpTransport, JSON_FACTORY, credential)
                .setApplicationName(APPLICATION_NAME)
                .build();
    }
}
