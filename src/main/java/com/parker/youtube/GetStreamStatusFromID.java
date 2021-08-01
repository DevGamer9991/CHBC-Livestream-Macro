package com.parker.youtube; /**
 * Sample Java code for youtube.liveStreams.list
 * See instructions for running these code samples locally:
 * https://developers.google.com/explorer-help/guides/code_samples#java
 */

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;

import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.LiveStream;
import com.google.api.services.youtube.model.LiveStreamListResponse;

import javax.annotation.Nullable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class GetStreamStatusFromID {

    public static String data;

    public String get(String streamID)
            throws GeneralSecurityException, IOException, GoogleJsonResponseException {
        YouTube youtubeService = new Authorize().getService();
        // Define and execute the API request
        YouTube.LiveStreams.List request = youtubeService.liveStreams()
                .list("snippet,cdn,contentDetails,status");
        System.out.println(streamID);
        LiveStreamListResponse response = request.setId(streamID).execute();
        return response.getItems().get(0).getStatus().getHealthStatus().getStatus();
    }
}