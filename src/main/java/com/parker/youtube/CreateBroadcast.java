package com.parker.youtube; /**
 * Sample Java code for youtube.liveBroadcasts.insert
 * See instructions for running these code samples locally:
 * https://developers.google.com/explorer-help/guides/code_samples#java
 */

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.DateTime;

import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.LiveBroadcast;
import com.google.api.services.youtube.model.LiveBroadcastContentDetails;
import com.google.api.services.youtube.model.LiveBroadcastSnippet;
import com.google.api.services.youtube.model.LiveBroadcastStatus;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.time.Clock;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Collection;

public class CreateBroadcast {

    public void create(String DevKey)
            throws GeneralSecurityException, IOException, GoogleJsonResponseException {
        YouTube youtubeService = new Authorize().getService();

        // Define the LiveBroadcast object, which will be uploaded as the request body.
        LiveBroadcast liveBroadcast = new LiveBroadcast();

        // Add the contentDetails object property to the LiveBroadcast object.
        LiveBroadcastContentDetails contentDetails = new LiveBroadcastContentDetails();
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

        snippet.setScheduledStartTime(new DateTime(clock.instant().toString()));
        snippet.setTitle("Test broadcast");
        liveBroadcast.setSnippet(snippet);

        // Add the status object property to the LiveBroadcast object.
        LiveBroadcastStatus status = new LiveBroadcastStatus();
        status.setPrivacyStatus("unlisted");
        liveBroadcast.setStatus(status);

        // Define and execute the API request
        YouTube.LiveBroadcasts.Insert request = youtubeService.liveBroadcasts()
                .insert("snippet,contentDetails,status", liveBroadcast);
        LiveBroadcast response = request.setKey(DevKey).execute();
        System.out.println(response);
    }
}