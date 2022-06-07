package com.parker.youtube;

import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.services.youtube.YouTube;
import com.parker.App;
import com.parker.ConfigManager;
import com.parker.Logger;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class DeleteBroadcast {
    public void delete(String ID)
            throws GeneralSecurityException, IOException, GoogleJsonResponseException {
        YouTube youtubeService = new Authorize().getService();
        // Define and execute the API request
        YouTube.LiveBroadcasts.Delete request = youtubeService.liveBroadcasts()
                .delete(ID);
        Logger.println("Deleting Existing Broadcast");
        request.setKey(ConfigManager.DevKey).setOauthToken(ConfigManager.YTAccessToken).execute();
    }
}