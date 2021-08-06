package com.parker.youtube;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;

import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.LiveStreamListResponse;
import com.parker.MainWindow.MainWindow;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Collection;

public class CheckStreamID {

    int timeOut;

    public boolean check(String id) throws Exception {
        try{
            YouTube youtubeService = new Authorize().getService();
            // Define and execute the API request
            YouTube.LiveStreams.List request = youtubeService.liveStreams()
                    .list("snippet,cdn,contentDetails,status");

            LiveStreamListResponse response = request.setId(id).execute();
            System.out.println(response);

            System.out.println("Stream ID Is Valid");
            timeOut = 0;
            return true;
        } catch (Exception e) {
            if (timeOut > 20) new MainWindow().errorCalled(Arrays.toString(e.getStackTrace()));
            Thread.sleep(1000);
            System.out.println("Stream ID Is Not Valid Retrying and Ending in " + timeOut + " Out of 20 Retries");
            timeOut++;
            return check(id);
        }
    }
}