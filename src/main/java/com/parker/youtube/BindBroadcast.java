package com.parker.youtube;

import com.google.api.client.googleapis.json.GoogleJsonResponseException;

import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.LiveBroadcast;
import com.parker.MainWindow.MainWindow;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Arrays;

public class BindBroadcast {

    int timeOut;

    public void bind(String broadcastID, String streamID, String DevKey)
            throws InterruptedException {
        try{
            YouTube youtubeService = new Authorize().getService();
            // Define and execute the API request
            YouTube.LiveBroadcasts.Bind request = youtubeService.liveBroadcasts()
                    .bind(broadcastID, "snippet");
            LiveBroadcast response = request.setKey(DevKey)
                    .setStreamId(streamID)
                    .execute();
            System.out.println(response);
        }catch (Exception e) {
            if (timeOut > 20) new MainWindow().errorCalled(Arrays.toString(e.getStackTrace()));
            Thread.sleep(1000);
            System.out.println("Error When Checking Stream ID Retrying and Ending in " + timeOut + " Out of 20 Retries");
            timeOut++;
            bind(broadcastID, streamID, DevKey);
        }
    }
}