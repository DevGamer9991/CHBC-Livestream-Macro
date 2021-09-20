package com.parker.youtube;

import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.LiveStreamListResponse;
import com.parker.App;
import com.parker.Logger.Logger;
import com.parker.MainWindow.MainWindow;
import java.util.Arrays;

public class CheckStreamID {

    int timeOut;

    public boolean check(String id) throws Exception {
        try{
            YouTube youtubeService = new Authorize().getService();
            // Define and execute the API request
            YouTube.LiveStreams.List request = youtubeService.liveStreams()
                    .list("snippet,cdn,contentDetails,status");

            LiveStreamListResponse response = request.setId(id).execute();
            Logger.println(response);

            Logger.println(response.getItems().toString());

            if (response.getItems().toString().equals("[]")) {
                Logger.println("Stream Not Created");
                new ManageYoutubeData().deleteFile();
                return false;
            }

            Logger.println("Stream ID Is Valid");
            timeOut = 0;
            return true;
        } catch (Exception e) {
            if (timeOut > 20) new MainWindow().errorCalled(Arrays.toString(e.getStackTrace()));
            Thread.sleep(1000);
            Logger.println("Stream ID Is Not Valid Retrying and Ending in " + timeOut + " Out of 20 Retries");
            timeOut++;
            return check(id);
        }
    }
}