package com.parker;

import java.awt.Desktop;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import com.google.gson.*;

public class GetFacebookAccessCode {

    // https://graph.facebook.com/v3.3/oauth/authorize?type=user_agent&client_id=703083304425017&redirect_uri=http://localhost:5000&scope=publish_video,pages_manage_posts,pages_manage_metadata,pages_read_user_content

    public String getAccessToken() {
        try {
            FileReader reader = new FileReader("Data Files/AccessToken.txt");

            StringBuilder token = new StringBuilder();

            int i;
            while ((i=reader.read()) != -1) {
                token.append((char) i);
            }

            reader.close();
            return token.toString();
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void getManagedPages() {
        // String pageName = "Page2";
        // String pageID = getManagedPagesID(pageName);
        // String pageToken = getManagedPagesAccessToken(pageName);
    }

    public void saveAccessToken(InputStream input) {
        try {
            String s = new String(input.readAllBytes(), StandardCharsets.UTF_8);

            System.out.print(s);

            if (s.contains("Access_Token")) {
                String[] s2 = s.split("Access_Token=");
                System.out.println(" ");

                try {
                    File file = new File("Data Files/AccessToken.txt");
                    file.getParentFile().mkdir();
                    if (file.createNewFile()) {
                      System.out.println("File created: " + file.getName());
                    } else {
                      System.out.println("File already exists.");
                    }

                    try {
                        FileWriter  fr = new FileWriter(file);
                        fr.write(s2[1]);
                        fr.close();
                        System.out.println("Successfully wrote to the file.");
                    } catch (IOException e) {
                        System.out.println("An error occurred.");
                        e.printStackTrace();
                    }
                    
                } catch (IOException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
            } else {
                
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void savePageID(String id) {
        try {
            File file = new File("Data Files/PageID.txt");
            file.getParentFile().mkdir();
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }

            try {
                FileWriter  fr = new FileWriter(file);
                fr.write(id);
                fr.close();
                System.out.println("Successfully wrote to the file.");
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
            
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void savePageAccessToken(String token) {
        try {
            File file = new File("Data Files/PageToken.txt");
            file.getParentFile().mkdir();
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }

            try {
                FileWriter  fr = new FileWriter(file);
                fr.write(token);
                fr.close();
                System.out.println("Successfully wrote to the file.");
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
            
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void openLoginPage() {
        URI url;
        try {
            url = new URI("https://graph.facebook.com/v3.3/oauth/authorize?type=user_agent&client_id=703083304425017&redirect_uri=http://localhost:5000&scope=publish_video,pages_manage_posts,pages_manage_metadata,pages_read_user_content");
            Desktop.getDesktop().browse(url);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public String getManagedPagesJSON() {
        try {
            URL url = new URL("https://graph.facebook.com/v11.0/me/accounts?fields=id%2Cname%2Caccess_token&access_token=" + getAccessToken());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestMethod("GET");

            InputStream in = new BufferedInputStream(conn.getInputStream());

            String result = new String(in.readAllBytes(), StandardCharsets.UTF_8);
            return result;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }

    public String getPageAccessToken(String pageName) throws Exception{
        URL url = new URL("https://graph.facebook.com/v11.0/" + getManagedPagesID(pageName) + "?fields=access_token&access_token=" + getAccessToken());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setConnectTimeout(5000);
        conn.setDoOutput(true);
        conn.setDoInput(true);
        conn.setRequestMethod("GET");

        InputStream in = new BufferedInputStream(conn.getInputStream());

        String json = new String(in.readAllBytes(), StandardCharsets.UTF_8);

        String token = null;

        Gson gson = new Gson();

        Map<?, ?> map = gson.fromJson(json, Map.class);

        for (Map.Entry<?, ?> entry : map.entrySet()) {
            if (entry.getKey().toString().contains("access")) {
                token = entry.getValue().toString();
            }
        }
        return token;
    }

    public String getManagedPagesAccessToken(String pageName) {
        String managedPagesJson = getManagedPagesJSON();

        if (managedPagesJson != null) {
            Gson gson = new Gson();

            JsonObject jsonObject = gson.fromJson(managedPagesJson, JsonObject.class);

            JsonArray entry = (JsonArray) jsonObject.get("data");

            int num = 0;

            for (int i = 0; i < entry.size(); i++) {
                String name = ((JsonObject) entry.get(i)).get("name").getAsString();
                if (name.contains(pageName)) {
                    num = i;
                }
            }

            String token = ((JsonObject) entry.get(num)).get("access_token").getAsString();

            savePageAccessToken(token);;

            return token;
        } else {
            return null;
        }
    }
    public String getManagedPagesID(String pageName) {
        String managedPagesJson = getManagedPagesJSON();

        if (managedPagesJson != null) {
            Gson gson = new Gson();

            JsonObject jsonObject = gson.fromJson(managedPagesJson, JsonObject.class);

            JsonArray entry = (JsonArray) jsonObject.get("data");

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
            return null;
        }
    }
}
