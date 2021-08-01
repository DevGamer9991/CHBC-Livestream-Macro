package com.parker.youtube;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;

import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.LiveBroadcast;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class TransitionBroadcast {

    public void transition(String broadcastID, String DevKey)
            throws GeneralSecurityException, IOException, GoogleJsonResponseException {
        YouTube youtubeService = new Authorize().getService();
        // Define and execute the API request
        YouTube.LiveBroadcasts.Transition request = youtubeService.liveBroadcasts()
                .transition("live", broadcastID, "snippet,status");
        LiveBroadcast response = request.setKey(DevKey).execute();
        System.out.println(response);
    }
}