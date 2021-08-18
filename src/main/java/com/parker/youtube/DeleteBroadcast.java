package com.parker.youtube;

import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.services.youtube.YouTube;
import com.parker.App;
import java.io.IOException;
import java.security.GeneralSecurityException;

public class DeleteBroadcast {
    public void delete(String ID)
            throws GeneralSecurityException, IOException, GoogleJsonResponseException {
        YouTube youtubeService = new Authorize().getService();
        // Define and execute the API request
        YouTube.LiveBroadcasts.Delete request = youtubeService.liveBroadcasts()
                .delete(ID);
        request.setKey(App.DevKey).execute();
    }
}