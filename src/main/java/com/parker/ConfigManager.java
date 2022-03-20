package com.parker;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.parker.facebook.GetFacebookData;
import org.apache.commons.logging.Log;
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

    private static String OS = System.getProperty("os.name").toLowerCase();

    public static String SavedData;
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

            config = object;
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

                Logger.println("Wrote Config");
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

                Logger.println("Wrote Config");
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

            Writer writer = new FileWriter(YoutubeData);

            Gson gson = new Gson();

            gson.toJson(map, writer);

            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean isWindows() {
        return (OS.indexOf("win") >= 0);
    }

    public static boolean isMac() {
        return (OS.indexOf("mac") >= 0);
    }

    public static boolean isUnix() {
        return (OS.indexOf("nix") >= 0
                || OS.indexOf("nux") >= 0
                || OS.indexOf("aix") > 0);
    }

    public static boolean isSolaris() {
        return (OS.indexOf("sunos") >= 0);
    }

}
