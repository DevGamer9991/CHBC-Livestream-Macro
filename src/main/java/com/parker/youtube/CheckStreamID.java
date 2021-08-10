package com.parker.youtube;

import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.LiveStreamListResponse;
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