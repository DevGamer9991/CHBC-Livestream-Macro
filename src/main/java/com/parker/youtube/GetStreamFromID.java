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
import com.google.api.services.youtube.model.LiveStreamListResponse;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Collection;

public class GetStreamFromID {

    public void get(String streamID)
            throws GeneralSecurityException, IOException, GoogleJsonResponseException {
        YouTube youtubeService = new Authorize().getService();
        // Define and execute the API request
        YouTube.LiveStreams.List request = youtubeService.liveStreams()
                .list("snippet,cdn,contentDetails,status");
        LiveStreamListResponse response = request.setId(streamID).execute();
        System.out.println(response);
    }
}