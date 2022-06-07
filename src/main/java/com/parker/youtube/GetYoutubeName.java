package com.parker.youtube;

import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.ChannelListResponse;
import com.parker.App;
import com.parker.ConfigManager;
import com.parker.Logger;
import com.parker.MainWindow.MainWindow;
import java.util.Arrays;

public class GetYoutubeName {

    int timeOut;

    public String get() throws Exception {
        try {
            YouTube youtubeService = new Authorize().getService();
            // Define and execute the API request
            YouTube.Channels.List request = youtubeService.channels()
                    .list("snippet,contentDetails,statistics");
            ChannelListResponse response = request.setMine(true).setKey(ConfigManager.DevKey).setOauthToken(ConfigManager.YTAccessToken).execute();

            String channelTitle = response.getItems().get(0).getSnippet().getTitle();

            Logger.println("Channel Title: " + channelTitle);

            return channelTitle;
        } catch(Exception e) {
            if (timeOut >= 20) {new MainWindow().errorCalled(Arrays.toString(e.getStackTrace())); e.printStackTrace(); return null; }
            Thread.sleep(1000);
            Logger.println("Error When Getting Name Retrying and Ending in " + timeOut + " Out of 20 Retries");
            timeOut++;
            return get();
        }
    }
}