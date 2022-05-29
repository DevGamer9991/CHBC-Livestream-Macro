package com.parker;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.parker.facebook.GetFacebookData;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class ConfigManager {

    public static HashMap<String, String> config = new HashMap<>();
    public static HashMap<String, Boolean> checkBoxes = new HashMap<>();

    public static String clientID = "663670141634016";
//    public static String clientID = "186968813458771";

    private static String OS = System.getProperty("os.name").toLowerCase();

    public static String SavedData;
    public static String YTAccessToken;
    public static String RefreshToken;
    public static String YoutubeData;

    public static String chechArch() {
        String configPath = "/Documents/CHBC Livestream Macro/";
        String osDir = System.getProperty("user.home") + configPath;

        if (OS.contains("win")) {
            configPath = "\\Documents\\CHBC Livestream Macro\\";

            RefreshToken = osDir + "\\RefreshToken.json";
            YoutubeData = osDir + "\\YoutubeData.json";
            SavedData = osDir + "\\SavedData.json";
        } else {
            RefreshToken = osDir + "/RefreshToken.json";
            YoutubeData = osDir + "/YoutubeData.json";
            SavedData = osDir + "/SavedData.json";
        }

        return System.getProperty("user.home") + configPath;
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
        File file = new File(SavedData);
        Logger.println(SavedData);
        if (file.exists()) {
            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get(SavedData));

            Gson gson = new Gson();
            JsonObject object = gson.fromJson(reader, JsonObject.class);

            for (String i : object.keySet()) {

                Logger.println("Object: " + i);

            }

            checkBoxes.put("fb", object.get("streamFBBox").getAsBoolean());
            checkBoxes.put("yt", object.get("streamYTBox").getAsBoolean());
            checkBoxes.put("ytEnabled", object.get("ytEnabled").getAsBoolean());

            config.put("title", object.get("title").getAsString());
            config.put("description", object.get("description").getAsString());
            config.put("description", object.get("description").getAsString());

            config.put("ytprivacy", object.get("ytprivacy").getAsString());

            config.put("pageName", object.get("pageName").getAsString());
        } else {
            Logger.println("Config Doesn't Exist");

            writeDefaultConfig("Test Stream Title", "Test Stream Desc", "Capitol Hill Baptist", true, true, "public", false);

//            readConfig();
        }
    }

    public static void writeDefaultConfig(String title, String desc, String pageName, boolean streamFBBox, boolean streamYTBox, String ytprivacy, boolean ytEnabled) {
        File file = new File(SavedData);
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

                Writer writer = new FileWriter(SavedData);

                Gson gson = new Gson();

                gson.toJson(map, writer);

                writer.close();

                Logger.println("Wrote Default Config");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void writeConfig(String title, String desc, String pageName, boolean streamFBBox, boolean streamYTBox, String ytprivacy, boolean ytEnabled) {
        File file = new File(SavedData);
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

                Writer writer = new FileWriter(SavedData);

                Gson gson = new Gson();

                gson.toJson(map, writer);

                writer.close();

                Logger.println("Wrotes Config");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void readYTConfig(){
        try {
            InputStream in = new FileInputStream(YoutubeData);

            String jsonString = new String(in.readAllBytes(), StandardCharsets.UTF_8);

            Gson gson = new Gson();

            JsonObject jsonObject = (JsonObject) gson.fromJson(jsonString, JsonObject.class);

            for (String i : jsonObject.keySet()) {
                config.put(i, jsonObject.get(i).getAsString());
            }
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

            Writer writer = new FileWriter(YoutubeData);

            Gson gson = new Gson();

            gson.toJson(map, writer);

            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void saveRefreshToken(String refreshToken) {
        try {
            Map<String, Object> map = new HashMap<>();
            map.put("refreshToken", refreshToken);

            Writer writer = new FileWriter(RefreshToken);

            Gson gson = new Gson();

            gson.toJson(map, writer);

            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
