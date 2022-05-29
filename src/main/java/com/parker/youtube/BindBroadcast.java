package com.parker.youtube;

import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.LiveBroadcast;
import com.parker.ConfigManager;
import com.parker.Logger;
import com.parker.MainWindow.MainWindow;
import java.util.Arrays;

public class BindBroadcast {

    int timeOut;

    public void bind(String broadcastID, String streamID, String DevKey)
            throws Exception {
        try{
            YouTube youtubeService = new Authorize().getService();
            // Define and execute the API request
            YouTube.LiveBroadcasts.Bind request = youtubeService.liveBroadcasts()
                    .bind(broadcastID, "snippet");
            LiveBroadcast response = request.setKey(DevKey)
                    .setStreamId(streamID)
                    .setOauthToken(ConfigManager.YTAccessToken)
                    .execute();
            Logger.println(response);
        }catch (Exception e) {
            if (timeOut >= 20) {new MainWindow().errorCalled(Arrays.toString(e.getStackTrace())); e.printStackTrace(); return; }
            Thread.sleep(1000);
            e.printStackTrace();
            Logger.println("Error When Binding Broadcast Retrying and Ending in " + timeOut + " Out of 20 Retries");
            timeOut++;
            bind(broadcastID, streamID, DevKey);
        }
    }
}