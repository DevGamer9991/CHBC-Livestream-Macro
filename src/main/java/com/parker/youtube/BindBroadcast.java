package com.parker.youtube;

import com.google.api.client.googleapis.json.GoogleJsonResponseException;

import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.LiveBroadcast;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class BindBroadcast {
    public void bind(String broadcastID, String streamID, String DevKey)
            throws GeneralSecurityException, IOException {
        YouTube youtubeService = new Authorize().getService();
        // Define and execute the API request
        YouTube.LiveBroadcasts.Bind request = youtubeService.liveBroadcasts()
                .bind(broadcastID, "snippet");
        LiveBroadcast response = request.setKey(DevKey)
                .setStreamId(streamID)
                .execute();
        System.out.println(response);
    }
}