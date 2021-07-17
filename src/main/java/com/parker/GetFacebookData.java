package com.parker;

import java.awt.Desktop;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.*;
import com.restfb.json.Json;

public class GetFacebookData {

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

            // System.out.println(name);

            return name;
        } catch (Exception e) {
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
        String s = null;
        try {
            s = new String(input.readAllBytes(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (s.contains("Access_Token")) {
            String[] s2 = s.split("Access_Token=");
            String[] s3 = s2[1].split("\n");
            try {
                File file = new File("Data Files/AccessToken.txt");
                file.getParentFile().mkdir();
                if (file.createNewFile()) {
                    // System.out.println("File created: " + file.getName());
                } else {
                    // System.out.println("File already exists.");
                }

                try {
                    FileWriter fr = new FileWriter(file);
                    fr.write(s3[0]);
                    System.out.println(s3[0]);
                    fr.close();
                    // System.out.println("Successfully wrote to the file.");
                } catch (IOException e) {
                    // System.out.println("An error occurred.");
                    e.printStackTrace();
                }

            } catch (IOException e) {
                // System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
    }

    public void savePageID(String id) {
        try {
            File file = new File("Data Files/PageID.txt");
            file.getParentFile().mkdir();
            if (file.createNewFile()) {
                // System.out.println("File created: " + file.getName());
            } else {
                // System.out.println("File already exists.");
            }

            try {
                FileWriter  fr = new FileWriter(file);
                fr.write(id);
                fr.close();
                // System.out.println("Successfully wrote to the file.");
            } catch (IOException e) {
                // System.out.println("An error occurred.");
                e.printStackTrace();
            }
            
        } catch (IOException e) {
            // System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void savePageAccessToken(String token) {
        try {
            File file = new File("Data Files/PageToken.txt");
            file.getParentFile().mkdir();
            if (file.createNewFile()) {
                // System.out.println("File created: " + file.getName());
            } else {
                // System.out.println("File already exists.");
            }

            try {
                FileWriter  fr = new FileWriter(file);
                fr.write(token);
                fr.close();
                // System.out.println("Successfully wrote to the file.");
            } catch (IOException e) {
                // System.out.println("An error occurred.");
                e.printStackTrace();
            }
            
        } catch (IOException e) {
            // System.out.println("An error occurred.");
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

    public void saveTitleAndDesc(String title, String desc) {
        try {
            Map<String, Object> map = new HashMap<>();
            map.put("title", title);
            map.put("description", desc);

            Writer writer = new FileWriter("Data Files/SavedData.json");

            Gson gson = new Gson();

            gson.toJson(map, writer);

            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getTitle() {
        try {
            File file = new File("Data Files/SavedData.json");
            if (file.exists()) {
                // System.out.println("Found File");
                // create Gson instance
                Gson gson = new Gson();

                // create a reader
                Reader reader = Files.newBufferedReader(Paths.get("Data Files/SavedData.json"));

                // convert JSON file to map
                JsonObject object = gson.fromJson(reader, JsonObject.class);

                String title = object.get("title").getAsString();

                // System.out.println(title);

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
                // System.out.println("Found File");
                // create Gson instance
                Gson gson = new Gson();

                // create a reader
                Reader reader = Files.newBufferedReader(Paths.get("Data Files/SavedData.json"));

                // convert JSON file to map
                JsonObject object = gson.fromJson(reader, JsonObject.class);

                String desc = object.get("description").getAsString();

                // System.out.println(desc);
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
