package com.parker.youtube;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

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

    public void checkStreamID(String streamID) {



    }

    public void saveFile() {
        try {
            Map<String, Object> map = new HashMap<>();
            map.put("streamID", getStreamID());
            map.put("broadcastID", getBroadcastID());
            map.put("streamURL", getStreamURL());
            map.put("streamKey", getStreamKey());

            Writer writer = new FileWriter("Data Files/YoutubeData.json");

            Gson gson = new Gson();

            gson.toJson(map, writer);

            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
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

        InputStream in = new FileInputStream("Data Files/YoutubeData.json");

        String jsonString = new String(in.readAllBytes(), StandardCharsets.UTF_8);

        Gson gson = new Gson();

        JsonObject jsonObject = (JsonObject) gson.fromJson(jsonString, JsonObject.class);

        JsonElement streamIDFromFile = jsonObject.get("streamID");

        if (streamIDFromFile == null) {
            return null;
        }

        return streamIDFromFile.getAsString();
    }

    public boolean checkFile(String fileName) {
        File f = new File(fileName);
        if(f.exists() && !f.isDirectory()) {
            return true;
        }else {
            return false;
        }
    }
}
