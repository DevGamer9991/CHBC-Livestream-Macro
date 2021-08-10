package com.parker.youtube;

import com.google.api.client.util.DateTime;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.LiveBroadcast;
import com.google.api.services.youtube.model.LiveBroadcastContentDetails;
import com.google.api.services.youtube.model.LiveBroadcastSnippet;
import com.google.api.services.youtube.model.LiveBroadcastStatus;
import com.parker.MainWindow.MainWindow;
import java.time.Clock;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;

public class CreateBroadcast {

    int timeOut;

    public void create(String streamName, String streamDesc, String DevKey)
            throws Exception {

        try{
            YouTube youtubeService = new Authorize().getService();

            // Define the LiveBroadcast object, which will be uploaded as the request body.
            LiveBroadcast liveBroadcast = new LiveBroadcast();

            // Add the contentDetails object property to the LiveBroadcast object.
            LiveBroadcastContentDetails contentDetails = new LiveBroadcastContentDetails();

            contentDetails.setEnableAutoStart(true);
            contentDetails.set("enableAutoStop", true);

            contentDetails.setEnableClosedCaptions(true);
            contentDetails.setEnableContentEncryption(true);
            contentDetails.setEnableDvr(true);
            contentDetails.setEnableEmbed(true);
            contentDetails.setRecordFromStart(true);
            contentDetails.setStartWithSlate(true);
            liveBroadcast.setContentDetails(contentDetails);

            // Add the snippet object property to the LiveBroadcast object.
            LiveBroadcastSnippet snippet = new LiveBroadcastSnippet();

            Clock clock = Clock.system(ZoneId.of("US/Pacific"));

            snippet.setScheduledStartTime(new DateTime(Date.from(clock.instant())));
            snippet.setTitle(streamName);
            snippet.setDescription(streamDesc);
            liveBroadcast.setSnippet(snippet);

            // Add the status object property to the LiveBroadcast object.
            LiveBroadcastStatus status = new LiveBroadcastStatus();
            status.setSelfDeclaredMadeForKids(false);
            status.setPrivacyStatus("public");
            liveBroadcast.setStatus(status);

            // Define and execute the API request
            YouTube.LiveBroadcasts.Insert request = youtubeService.liveBroadcasts()
                    .insert("snippet,contentDetails,status", liveBroadcast);
            LiveBroadcast response = request.setKey(DevKey).execute();
            System.out.println(response);

            new ManageYoutubeData().setBroadcastID(response.getId());
        }catch (Exception e) {
            if (timeOut > 20) new MainWindow().errorCalled(Arrays.toString(e.getStackTrace()));
            Thread.sleep(1000);
            System.out.println("Error When Creating Broadcast Retrying and Ending in " + timeOut + " Out of 20 Retries");
            timeOut++;
            create(streamName, streamDesc, DevKey);
        }
    }
}