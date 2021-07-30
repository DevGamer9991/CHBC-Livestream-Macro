package com.parker.youtube; /**
 * Sample Java code for youtube.liveBroadcasts.list
 * See instructions for running these code samples locally:
 * https://developers.google.com/explorer-help/guides/code_samples#java
 */

import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.*;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class GetYoutubeData {

    public static final String DEVELOPER_KEY = "AIzaSyCuumDlKGiJJdHa5IIkp5FxydAjn7zUAhY";

    public static void getBroadcast() throws IOException, GeneralSecurityException {
        YouTube youtubeService = new Authorize().getService();
        // Define and execute the API request
        YouTube.LiveBroadcasts.List request = youtubeService.liveBroadcasts()
                .list("snippet,contentDetails,status");
        LiveBroadcastListResponse response = request.setBroadcastType("all")
                .setMine(true)
                .execute();
        System.out.println(response);
    }

    public static void updateBroadcast() throws GeneralSecurityException, IOException {
        YouTube youtubeService = new Authorize().getService();

        // Define the LiveBroadcast object, which will be uploaded as the request body.
        LiveBroadcast liveBroadcast = new LiveBroadcast();

        // Add the contentDetails object property to the LiveBroadcast object.
        LiveBroadcastContentDetails contentDetails = new LiveBroadcastContentDetails();
        contentDetails.setEnableClosedCaptions(true);
        contentDetails.setEnableContentEncryption(true);
        contentDetails.setEnableDvr(true);
        contentDetails.setEnableEmbed(true);
        MonitorStreamInfo monitorStream = new MonitorStreamInfo();
        monitorStream.setBroadcastStreamDelayMs(5L);
        monitorStream.setEnableMonitorStream(true);
        contentDetails.setMonitorStream(monitorStream);
        contentDetails.setRecordFromStart(true);
        contentDetails.setStartWithSlate(true);
        liveBroadcast.setContentDetails(contentDetails);

        // Add the id string property to the LiveBroadcast object.
        liveBroadcast.setId("L_LQViEsI9E");

        // Add the snippet object property to the LiveBroadcast object.
        LiveBroadcastSnippet snippet = new LiveBroadcastSnippet();
        snippet.setTitle("Parker's Test Stream");
        liveBroadcast.setSnippet(snippet);

        // Define and execute the API request
        YouTube.LiveBroadcasts.Update request = youtubeService.liveBroadcasts()
                .update("contentDetails,snippet", liveBroadcast);
        LiveBroadcast response = request.setKey(DEVELOPER_KEY).execute();
        System.out.println(response);
    }

    public void getStreams() throws GeneralSecurityException, IOException {
        YouTube youtubeService = new Authorize().getService();
        // Define and execute the API request
        YouTube.LiveBroadcasts.List request = youtubeService.liveBroadcasts()
                .list("snippet,contentDetails,status");
        LiveBroadcastListResponse response = request.setMine(true).execute();
    }
}