package com.parker.youtube; /**
 * Sample Java code for youtube.liveStreams.insert
 * See instructions for running these code samples locally:
 * https://developers.google.com/explorer-help/guides/code_samples#java
 */

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;

import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.CdnSettings;
import com.google.api.services.youtube.model.LiveStream;
import com.google.api.services.youtube.model.LiveStreamContentDetails;
import com.google.api.services.youtube.model.LiveStreamSnippet;
import com.parker.MainWindow.MainWindow;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Collection;

public class CreateStream {

    int timeOut;

    public void create(String DevKey)
            throws GeneralSecurityException, IOException, GoogleJsonResponseException, InterruptedException {
        try {
            YouTube youtubeService = new Authorize().getService();

            // Define the LiveStream object, which will be uploaded as the request body.
            LiveStream liveStream = new LiveStream();

            // Add the cdn object property to the LiveStream object.
            CdnSettings cdn = new CdnSettings();
            cdn.setFrameRate("60fps");
            cdn.setIngestionType("rtmp");
            cdn.setResolution("1080p");
            liveStream.setCdn(cdn);

            // Add the contentDetails object property to the LiveStream object.
            LiveStreamContentDetails contentDetails = new LiveStreamContentDetails();
            contentDetails.setIsReusable(true);
            liveStream.setContentDetails(contentDetails);

            // Add the snippet object property to the LiveStream object.
            LiveStreamSnippet snippet = new LiveStreamSnippet();
            snippet.setTitle("Capitol Hill Baptist Stream");
            liveStream.setSnippet(snippet);

            // Define and execute the API request
            YouTube.LiveStreams.Insert request = youtubeService.liveStreams()
                    .insert("snippet,cdn,contentDetails,status", liveStream);
            LiveStream response = request.setKey(DevKey).execute();
            System.out.println(response.getId());
            System.out.println(response.getCdn().getIngestionInfo().getStreamName());
            System.out.println(response.getCdn().getIngestionInfo().getIngestionAddress());

            new ManageYoutubeData().setStreamID(response.getId());
            new ManageYoutubeData().setStreamKey(response.getCdn().getIngestionInfo().getStreamName());
            new ManageYoutubeData().setStreamURL(response.getCdn().getIngestionInfo().getIngestionAddress());
        }catch (Exception e) {
            if (timeOut > 20) new MainWindow().errorCalled(Arrays.toString(e.getStackTrace()));
            Thread.sleep(1000);
            System.out.println("Error When Creating Stream Retrying and Ending in " + timeOut + " Out of 20 Retries");
            timeOut++;
            create(DevKey);
        }
    }
}