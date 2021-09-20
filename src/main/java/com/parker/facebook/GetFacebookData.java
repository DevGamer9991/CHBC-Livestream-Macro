package com.parker.facebook;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.gson.*;
import com.parker.HTTPSServer;
import com.parker.HTTPSServerThread;
import com.parker.Logger.Logger;
import com.parker.MainWindow.MainWindow;

public class GetFacebookData {

    // https://graph.facebook.com/v3.3/oauth/authorize?type=user_agent&client_id=703083304425017&redirect_uri=http://localhost:5000&scope=publish_video,pages_manage_posts,pages_manage_metadata,pages_read_user_content

    public String clientID = "186968813458771";

    public static String access_token;
    public static String page_id;

    public static boolean streamFBBool;
    public static boolean streamYTBool;
    public static String ytprivacy;

    public String getName() throws Exception{
        try {
            URL url = new URL("https://graph.facebook.com/v11.0/me?fields=name&access_token=" + getAccessToken());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestMethod("GET");

            InputStream in = new BufferedInputStream(conn.getInputStream());

            String jsonString = new String(in.readAllBytes(), StandardCharsets.UTF_8);

            String token = null;

            Gson gson = new Gson();

            JsonObject jsonObject = (JsonObject) gson.fromJson(jsonString, JsonObject.class);

            String name = jsonObject.get("name").getAsString();

            Logger.println(name);

            return name;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void setAccessToken(String input) throws Exception {
        if (input.contains("code")) {
            String[] s2 = input.split("code=");

            access_token = s2[1];

            Logger.println(access_token);

            new MainWindow().setFBName(new GetFacebookData().getName());
        }
    }

    public String getAccessToken() {
        return access_token;
    }

    public void savePageID(String id) {
        page_id = id;
    }

    public void openLoginPage(Integer port) {
        URI url;
        try {
            url = new URI("https://graph.facebook.com/v3.3/oauth/authorize?type=user_agent&client_id=" + clientID +"&redirect_uri=https://localhost:" + port + "/token&scope=publish_video,pages_manage_posts,pages_manage_metadata,pages_read_user_content");

            Logger.printlnOverride("Open In Web Browser: " + url);
            if(Desktop.isDesktopSupported()) {

                Desktop.getDesktop().browse(url);
            }else {
                Logger.printlnOverride("Cant Open Web Browser Here is Link: " + url.toString());
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void saveTitleAndDesc(String title, String desc) {
        try {
            Map<String, Object> map = new HashMap<>();
            map.put("title", title);
            map.put("description", desc);
            map.put("pageName", getPageNameFromFile());
            map.put("streamFBBox", streamFBBool);
            map.put("streamYTBox", streamYTBool);
            map.put("ytprivacy", getYTPrivacyFromFile());
            map.put("ytEnabled", getYTEnabled());

            Writer writer = new FileWriter("Data Files/SavedData.json");

            Gson gson = new Gson();

            gson.toJson(map, writer);

            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean getYTEnabled() throws IOException {
        File file = new File("Data Files/SavedData.json");
        if (file.exists()) {
            Logger.println("Found File");
            // create Gson instance
            Gson gson = new Gson();

            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get("Data Files/SavedData.json"));

            // convert JSON file to map
            JsonObject object = gson.fromJson(reader, JsonObject.class);

            boolean ytEnabled = object.get("ytEnabled").getAsBoolean();

            Logger.println(ytEnabled);

            // close reader
            reader.close();

            return ytEnabled;
        } else {
            return false;
        }
    }

    public String getPageNameFromFile() {
        try {
            File file = new File("Data Files/SavedData.json");
            if (file.exists()) {
                Logger.println("Found File");
                // create Gson instance
                Gson gson = new Gson();

                // create a reader
                Reader reader = Files.newBufferedReader(Paths.get("Data Files/SavedData.json"));

                // convert JSON file to map
                JsonObject object = gson.fromJson(reader, JsonObject.class);

                String pageName = object.get("pageName").getAsString();

                Logger.println(pageName);

                // close reader
                reader.close();

                return pageName;
            } else {
                return null;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public String getYTPrivacyFromFile() {
        Logger.println("Getting Privacy");
        try {
            File file = new File("Data Files/SavedData.json");
            if (file.exists()) {
                Logger.println("Found File");
                // create Gson instance
                Gson gson = new Gson();

                // create a reader
                Reader reader = Files.newBufferedReader(Paths.get("Data Files/SavedData.json"));

                // convert JSON file to map
                JsonObject object = gson.fromJson(reader, JsonObject.class);

                ytprivacy = object.get("ytprivacy").getAsString();

                Logger.println(ytprivacy);

                // close reader
                reader.close();
                return ytprivacy;
            } else {
                Logger.println("Privacy not set");
                return "public";
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public String getYTPrivacy() {
        return ytprivacy;
    }


    public String getTitle() {
        try {
            File file = new File("Data Files/SavedData.json");
            if (file.exists()) {
                Logger.println("Found File");
                // create Gson instance
                Gson gson = new Gson();

                // create a reader
                Reader reader = Files.newBufferedReader(Paths.get("Data Files/SavedData.json"));

                // convert JSON file to map
                JsonObject object = gson.fromJson(reader, JsonObject.class);

                String title = object.get("title").getAsString();

                Logger.println(title);

                // close reader
                reader.close();

                return title;
            } else {
                return null;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public String getDesc() {
        try {
            File file = new File("Data Files/SavedData.json");
            if (file.exists()) {
                Logger.println("Found File");
                // create Gson instance
                Gson gson = new Gson();

                // create a reader
                Reader reader = Files.newBufferedReader(Paths.get("Data Files/SavedData.json"));

                // convert JSON file to map
                JsonObject object = gson.fromJson(reader, JsonObject.class);

                String desc = object.get("description").getAsString();

                Logger.println(desc);
                // close reader
                reader.close();

                return desc;
            } else {
                return null;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public String getManagedPagesID(String pageName) throws Exception {
        String managedPagesJson = new GetManagedPagesJSON().get();

        Logger.println(managedPagesJson);

        if (managedPagesJson != null) {
            if (managedPagesJson.contains(pageName)) {
                Gson gson = new Gson();

                JsonObject jsonObject = gson.fromJson(managedPagesJson, JsonObject.class);

                JsonArray entry = (JsonArray) jsonObject.get("data");

                Logger.print(entry.toString());

                int num = 0;

                for (int i = 0; i < entry.size(); i++) {
                    String name = ((JsonObject) entry.get(i)).get("name").getAsString();
                    if (name.contains(pageName)) {
                        num = i;
                    }
                }

                String id = ((JsonObject) entry.get(num)).get("id").getAsString();

                savePageID(id);

                return id;
            } else {
                Logger.println("Account: " + getName() + " Is Not a Admin Of: " + getPageNameFromFile());
                return null;
            }
        } else {
            return null;
        }
    }

    public void copy(String text) {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection selection = new StringSelection(text);
        clipboard.setContents(selection, null);
    }

    public void checkDataFile() {
        File file = new File("Data Files/SavedData.json");
        if (!file.exists()) {
            try {
                Map<String, Object> map = new HashMap<>();
                map.put("title", "Stream Title");
                map.put("description", "Stream Desc");
                map.put("pageName", "Capitol Hill Baptist");
                map.put("streamFBBox", true);
                map.put("streamYTBox", true);
                map.put("ytprivacy", "public");
                map.put("ytEnabled", false);

                Writer writer = new FileWriter("Data Files/SavedData.json");

                Gson gson = new Gson();

                gson.toJson(map, writer);

                writer.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void setYTEnabled() {
        try {
            Map<String, Object> map = new HashMap<>();
            map.put("title", getTitle());
            map.put("description", getDesc());
            map.put("pageName", getPageNameFromFile());
            map.put("streamFBBox", streamFBBool);
            map.put("streamYTBox", streamYTBool);
            map.put("ytprivacy", getYTPrivacyFromFile());
            map.put("ytEnabled", true);

            Writer writer = new FileWriter("Data Files/SavedData.json");

            Gson gson = new Gson();

            gson.toJson(map, writer);

            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveStreamBoxes(boolean fb, boolean yt) {
        Logger.println("Saving Boxes");

        Logger.println("FB: " + fb);
        Logger.println("YT: " + yt);

        File file = new File("Data Files/SavedData.json");
        if (file.exists()) {
            try {
                Map<String, Object> map = new HashMap<>();
                map.put("title", getTitle());
                map.put("description", getDesc());
                map.put("pageName", getPageNameFromFile());
                map.put("streamFBBox", fb);
                map.put("streamYTBox", yt);
                map.put("ytprivacy", getYTPrivacyFromFile());
                map.put("ytEnabled", true);

                streamFBBool = fb;
                streamYTBool = yt;

                Writer writer = new FileWriter("Data Files/SavedData.json");

                Gson gson = new Gson();

                gson.toJson(map, writer);

                writer.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public boolean checkStreamFBBox() {
        try {
            File file = new File("Data Files/SavedData.json");
            if (file.exists()) {
                Logger.println("Found File");
                // create Gson instance
                Gson gson = new Gson();

                // create a reader
                Reader reader = Files.newBufferedReader(Paths.get("Data Files/SavedData.json"));

                // convert JSON file to map
                JsonObject object = gson.fromJson(reader, JsonObject.class);

                streamFBBool = object.get("streamFBBox").getAsBoolean();

                Logger.println(streamFBBool);
                // close reader
                reader.close();

                return streamFBBool;
            } else {
                return false;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
    public boolean checkStreamYTBox() {
        try {
            File file = new File("Data Files/SavedData.json");
            if (file.exists()) {
                Logger.println("Found File");
                // create Gson instance
                Gson gson = new Gson();

                // create a reader
                Reader reader = Files.newBufferedReader(Paths.get("Data Files/SavedData.json"));

                // convert JSON file to map
                JsonObject object = gson.fromJson(reader, JsonObject.class);

                streamYTBool = object.get("streamYTBox").getAsBoolean();

                Logger.println(streamYTBool);
                // close reader
                reader.close();

                return streamYTBool;
            } else {
                return false;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
