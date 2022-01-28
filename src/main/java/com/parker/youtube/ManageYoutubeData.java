package com.parker.youtube;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.parker.App;
import com.parker.ConfigManager;
import com.parker.Logger;

import javax.annotation.Nullable;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class ManageYoutubeData {

    public static String broadcastID;
    public static String streamID;
    public static String streamKey;
    public static String streamURL;

    public void saveFile() {
        ConfigManager.writeYTConfig(getStreamID(), getBroadcastID(), getStreamURL(), getStreamKey());
    }

    public void setBroadcastID(String broadcastID) {
        this.broadcastID = broadcastID;
    }

    public void setStreamID(String streamID) {
        this.streamID = streamID;
    }

    public void setStreamKey(String streamKey) {
        this.streamKey = streamKey;
    }

    public void setStreamURL(String streamURL) {
        this.streamURL = streamURL;
    }

    public String getBroadcastID() {
        return broadcastID;
    }

    public String getStreamID() {
        return streamID;
    }

    public String getStreamKey() {
        return streamKey;
    }

    public String getStreamURL() {
        return streamURL;
    }

    @Nullable
    public String getStreamIDFromFile() throws Exception{
        JsonElement streamIDFromFile = ConfigManager.ytConfig.get("streamID");

        if (streamIDFromFile == null) {
            return null;
        }

        streamID = streamIDFromFile.getAsString();

        return streamIDFromFile.getAsString();
    }

    public String getBroadcastIDFromFile() throws Exception{
        JsonElement streamIDFromFile = ConfigManager.ytConfig.get("broadcastID");

        if (streamIDFromFile == null) {
            return null;
        }

        streamID = streamIDFromFile.getAsString();

        return streamIDFromFile.getAsString();
    }

    public String setStreamURLFromFile() throws Exception{
        JsonElement streamURLFromFile = ConfigManager.ytConfig.get("streamURL");

        if (streamURLFromFile == null) {
            return null;
        }

        streamURL = streamURLFromFile.getAsString();

        return streamURLFromFile.getAsString();
    }

    public void setStreamKeyFromFile() throws Exception{
        JsonElement streamKeyFromFile = ConfigManager.ytConfig.get("streamKey");

        if (streamKeyFromFile == null) {
            return;
        }

        streamKey = streamKeyFromFile.getAsString();
    }

    public boolean checkFile(String fileName) {
        File f = new File(fileName);
        if(f.exists() && !f.isDirectory()) {
            return true;
        }else {
            return false;
        }
    }

    public void deleteFile() {
        File file = new File(App.osDir + "/YoutubeData.json");

        if(file.delete()) {
            Logger.println("File Deleted");
        }
    }
}
