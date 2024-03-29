package com.parker.facebook;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import com.google.gson.*;
import com.parker.App;
import com.parker.ConfigManager;
import com.parker.Logger;
import com.parker.MainWindow.MainWindow;
import org.json.simple.parser.ParseException;

public class GetFacebookData {

    // https://graph.facebook.com/v3.3/oauth/authorize?type=user_agent&client_id=703083304425017&redirect_uri=http://localhost:5000&scope=publish_video,pages_manage_posts,pages_manage_metadata,pages_read_user_content

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
            JsonObject object = gson.fromJson(jsonString, JsonObject.class);

            String name = object.get("name").getAsString();

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
            url = new URI("https://graph.facebook.com/v3.3/oauth/authorize?type=user_agent&client_id=" + ConfigManager.clientID +"&redirect_uri=https://localhost:" + port + "/token&scope=publish_video,pages_manage_posts,pages_manage_metadata,pages_read_user_content");

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

    public void saveTitleAndDesc(String title, String desc) throws IOException, ParseException {
        Logger.println("Youtube Checkbox set to " + ConfigManager.checkBoxes.get("yt"));
        ConfigManager.writeConfig(title, desc, getPageNameFromFile(), ConfigManager.checkBoxes.get("fb"), ConfigManager.checkBoxes.get("yt"), getYTPrivacyFromFile(), getYTEnabled());
    }

    public boolean getYTEnabled() throws IOException, ParseException {
        return ConfigManager.checkBoxes.get("ytEnabled");
    }

    public String getPageNameFromFile() {
        return ConfigManager.config.get("pageName");
    }

    public String getYTPrivacyFromFile() {
        return ConfigManager.config.get("ytprivacy");
    }

    public String getTitle() {
        return ConfigManager.config.get("title");
    }

    public String getDesc() {
        return ConfigManager.config.get("description");
    }

    public String getManagedPagesID(String pageName) throws Exception {
        String managedPagesJson = new GetManagedPagesData().get();

        Logger.println(managedPagesJson);

        if (managedPagesJson != null) {
            if (managedPagesJson.contains(pageName)) {

                Gson gson = new Gson();

                JsonObject object = gson.fromJson(managedPagesJson, JsonObject.class);

                JsonArray entry = (JsonArray) object.get("data");

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

    public void checkKeystore(String keystore) throws IOException {
        InputStream is = new App().getClass().getClassLoader().getResourceAsStream(keystore);

        OutputStream os = new FileOutputStream(App.osDir + "/" + keystore);

        try {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } finally {
            is.close();
            os.close();
        }
    }

    public void setYTEnabled() {
        ConfigManager.checkBoxes.put("ytEnabled", true);
        ConfigManager.writeConfig(getTitle(), getDesc(), getPageNameFromFile(), ConfigManager.checkBoxes.get("fb"), ConfigManager.checkBoxes.get("yt"), getYTPrivacyFromFile(), ConfigManager.checkBoxes.get("ytEnabled"));
    }

    public void saveStreamBoxes(boolean fb, boolean yt) {
        ConfigManager.writeConfig(getTitle(), getDesc(), getPageNameFromFile(), ConfigManager.checkBoxes.get("fb"),  ConfigManager.checkBoxes.get("yt"), getYTPrivacyFromFile(), ConfigManager.checkBoxes.get("ytEnabled"));
    }

    public boolean checkStreamFBBox() { Logger.println("FB Stream Box: " + ConfigManager.checkBoxes.get("fb")); return ConfigManager.checkBoxes.get("fb"); }
    public boolean checkStreamYTBox() { Logger.println("YT Stream Box: " + ConfigManager.checkBoxes.get("yt")); return ConfigManager.checkBoxes.get("yt"); }
}
