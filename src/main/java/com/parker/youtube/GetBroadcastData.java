package com.parker.youtube;

import com.google.api.client.googleapis.json.GoogleJsonResponseException;

import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.LiveBroadcastListResponse;
import com.parker.Logger;

public class GetBroadcastData {

    public static String id;

    public String get() throws Exception {
        YouTube youtubeService = new Authorize().getService();
        // Define and execute the API request
        YouTube.LiveBroadcasts.List request = youtubeService.liveBroadcasts()
                .list("snippet,contentDetails,status");

        String ID = new ManageYoutubeData().getBroadcastIDFromFile();

        if (ID != null) {
            try {
                LiveBroadcastListResponse response = request.setId(new ManageYoutubeData().getBroadcastIDFromFile()).execute();
            } catch(GoogleJsonResponseException e) {
                e.printStackTrace();
                return get();
            }
            LiveBroadcastListResponse response = request.setId(new ManageYoutubeData().getBroadcastIDFromFile()).execute();
            Logger.println(response);

            try {
                String responseStatus = response.getItems().get(0).getStatus().getLifeCycleStatus();
                Logger.println(responseStatus);

                if (responseStatus.equals("ready")) {
                    new ManageYoutubeData().setBroadcastID(response.getItems().get(0).getId());
                    return responseStatus;
                } else {
                    return null;
                }
            } catch (IndexOutOfBoundsException e) {
                Logger.println("Broadcast Does Not Exist");
                return null;
            }
        } else {
            return null;
        }
    }

    public static String getID() {
        return id;
    }
}