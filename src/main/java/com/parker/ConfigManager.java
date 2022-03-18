package com.parker;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.parker.facebook.GetFacebookData;
import org.json.simple.JSONObject;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class ConfigManager {

    public static JsonObject config;
    public static JsonObject ytConfig;

    public static String chechArch() {
        return System.getProperty("user.home") + "\\Documents\\CHBC Livestream Macro\\";
    }

    public static boolean createContainer (String path) {
        File temp = new File(path);
        if (!temp.exists()) {
            if (temp.mkdirs()) {
                return true;
            }
        }

        return false;
    }

    public static void readConfig() throws IOException {
        File file = new File(App.osDir + "\\SavedData.json");
        if (file.exists()) {
            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get(App.osDir + "\\SavedData.json"));

            Gson gson = new Gson();
            JsonObject object = gson.fromJson(reader, JsonObject.class);

            config = object;
        } else {
            Logger.println("Config Doesn't Exist");

            writeDefaultConfig("Test Stream Title", "Test Stream Desc", "Capitol Hill Baptist", true, true, "public", false);

            readConfig();
        }
    }

    public static void writeDefaultConfig(String title, String desc, String pageName, boolean streamFBBox, boolean streamYTBox, String ytprivacy, boolean ytEnabled) {
        File file = new File(App.osDir + "\\SavedData.json");
        if (!file.exists()) {
            try {
                Map<String, Object> map = new HashMap<>();
                map.put("title", title);
                map.put("description", desc);
                map.put("pageName", pageName);
                map.put("streamFBBox", streamFBBox);
                map.put("streamYTBox", streamYTBox);
                map.put("ytprivacy", ytprivacy);
                map.put("ytEnabled", ytEnabled);

                GetFacebookData.streamFBBool = streamFBBox;
                GetFacebookData.streamYTBool = streamYTBox;

                Writer writer = new FileWriter(App.osDir + "\\SavedData.json");

                Gson gson = new Gson();

                gson.toJson(map, writer);

                writer.close();

                Logger.println("Wrote Config");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void writeConfig(String title, String desc, String pageName, boolean streamFBBox, boolean streamYTBox, String ytprivacy, boolean ytEnabled) {
        File file = new File(App.osDir + "\\SavedData.json");
        if (file.exists()) {
            try {
                Map<String, Object> map = new HashMap<>();
                map.put("title", title);
                map.put("description", desc);
                map.put("pageName", pageName);
                map.put("streamFBBox", streamFBBox);
                map.put("streamYTBox", streamYTBox);
                map.put("ytprivacy", ytprivacy);
                map.put("ytEnabled", ytEnabled);

                GetFacebookData.streamFBBool = streamFBBox;
                GetFacebookData.streamYTBool = streamYTBox;

                Writer writer = new FileWriter(App.osDir + "/SavedData.json");

                Gson gson = new Gson();

                gson.toJson(map, writer);

                writer.close();

                Logger.println("Wrote Config");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void readYTConfig(){
        try {
            InputStream in = new FileInputStream(App.osDir + "\\YoutubeData.json");

            String jsonString = new String(in.readAllBytes(), StandardCharsets.UTF_8);

            Gson gson = new Gson();

            JsonObject jsonObject = (JsonObject) gson.fromJson(jsonString, JsonObject.class);

            ytConfig = jsonObject;
        } catch (Exception e) {
            Logger.printlnOverride("Youtube Config Does Not Exist");
        }

    }

    public static void writeYTConfig(String streamID, String broadcastID, String streamURl, String streamKey) {
        try {
            Map<String, Object> map = new HashMap<>();
            map.put("streamID", streamID);
            map.put("broadcastID", broadcastID);
            map.put("streamURL", streamURl);
            map.put("streamKey", streamKey);

            Writer writer = new FileWriter(App.osDir + "\\YoutubeData.json");

            Gson gson = new Gson();

            gson.toJson(map, writer);

            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
