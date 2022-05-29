package com.parker.youtube;

import com.parker.ConfigManager;
import com.parker.Logger;

import java.io.*;

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
        ConfigManager.config.put("broadcastID", broadcastID);
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

    public String getStreamIDFromFile() throws Exception{
        String streamIDFromConfig = ConfigManager.config.get("streamID");

        if (streamIDFromConfig == null) {
            return null;
        }

        streamID = streamIDFromConfig;

        return streamIDFromConfig;
    }

    public String getBroadcastIDFromFile() throws Exception{
        String streamIDFromConfig = ConfigManager.config.get("broadcastID");

        if (streamIDFromConfig == null) {
            return null;
        }

        streamID = streamIDFromConfig;

        return streamIDFromConfig;
    }

    public String setStreamURLFromFile() throws Exception{
        String streamURLFromConfig = ConfigManager.config.get("streamURL");

        if (streamURLFromConfig == null) {
            return null;
        }

        streamURL = streamURLFromConfig;

        return streamURLFromConfig;
    }

    public void setStreamKeyFromFile() throws Exception{
        String streamKeyFromConfig = ConfigManager.config.get("streamKey");

        if (streamKeyFromConfig == null) {
            return;
        }

        streamKey = streamKeyFromConfig;
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
        File file = new File(ConfigManager.YoutubeData);

        if(file.delete()) {
            Logger.println("File Deleted");
        }
    }
}
