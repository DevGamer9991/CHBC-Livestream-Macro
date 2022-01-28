package com.parker;

import java.io.File;
import java.util.Locale;

public class ConfigManager {

    public static JsonObject config;

    public static String chechArch() {
        return System.getProperty("user.home") + "/Documents/CHBC Livestream Macro/";
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

    public static void openConfig() {
        File file = new File(App.osDir + "/SavedData.json");
        if (file.exists()) {
            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get(App.osDir + "/SavedData.json"));

            Gson gson = new Gson();
            JsonObject object = gson.fromJson(reader, JsonObject.class);

            config = object;
        } else {
            Logger.println("Error Opening Config")
        }
    }

    public static void writeConfig(String title, String desc, String pageName, boolean streamFBBox, boolean streamYTBox, String ytprivacy, boolean ytEnabled) {
        File file = new File(App.osDir + "/SavedData.json");
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

}
