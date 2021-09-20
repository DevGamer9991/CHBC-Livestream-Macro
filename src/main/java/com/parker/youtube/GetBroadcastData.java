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
import com.google.api.services.youtube.model.LiveBroadcastListResponse;
import com.parker.Logger.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Collection;

public class GetBroadcastData {

    public static String id;

    public String get() throws Exception {
        YouTube youtubeService = new Authorize().getService();
        // Define and execute the API request
        YouTube.LiveBroadcasts.List request = youtubeService.liveBroadcasts()
                .list("snippet,contentDetails,status");

        String ID = new ManageYoutubeData().getBroadcastIDFromFile();

        if (ID != null) {
            try {
                LiveBroadcastListResponse response = request.setId(new ManageYoutubeData().getBroadcastIDFromFile()).execute();
            } catch(GoogleJsonResponseException e) {
                e.printStackTrace();
                return get();
            }
            LiveBroadcastListResponse response = request.setId(new ManageYoutubeData().getBroadcastIDFromFile()).execute();
            Logger.println(response);

            try {
                String responseStatus = response.getItems().get(0).getStatus().getLifeCycleStatus();
                Logger.println(responseStatus);

                if (responseStatus.equals("ready")) {
                    new ManageYoutubeData().setBroadcastID(response.getItems().get(0).getId());
                    return responseStatus;
                } else {
                    return null;
                }
            } catch (IndexOutOfBoundsException e) {
                Logger.println("Broadcast Does Not Exist");
                return null;
            }
        } else {
            return null;
        }
    }

    public static String getID() {
        return id;
    }
}