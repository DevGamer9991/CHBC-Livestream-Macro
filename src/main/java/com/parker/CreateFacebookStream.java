package com.parker;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.parker.MainWindow.MainWindow;

public class CreateFacebookStream{

    public static String streamURL;
    public static String streamID;

    public void createStream(String titleString, String descripString, String pageName) throws Exception{
        
        titleString = titleString.replaceAll(" ", "+");
        descripString = descripString.replaceAll(" ", "+");

        URL url = new URL("https://graph.facebook.com/v11.0/me/live_videos?status=LIVE_NOW&title=" + titleString + "&description=" + descripString + "&access_token=" + new GetFacebookData().getPageAccessToken(pageName));
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setConnectTimeout(5000);
        conn.setDoOutput(true);
        conn.setDoInput(true);
        conn.setRequestMethod("POST");

        InputStream in = conn.getInputStream();

        String response = new String(in.readAllBytes(), StandardCharsets.UTF_8);

        //System.out.println(response);

        Gson gson = new Gson();

        JsonObject jsonObject = gson.fromJson(response, JsonObject.class);

        streamID = jsonObject.get("id").getAsString();
        streamURL = jsonObject.get("secure_stream_url").getAsString();

        if (jsonObject.toString().contains("secure_stream_url")) {
            MainWindow mainWindow = new MainWindow();
            mainWindow.streamIDField.setText(streamID);
            System.out.println("\n" + streamID);
            mainWindow.streamIDField.setText(streamURL);
            System.out.println("\n" + streamURL);
        } else {
        System.out.println("\n Didnt work \n" + jsonObject.toString());
        }
    }

    public String getStreamID() {
        return streamID;
    }
    public String getStreamURL() {
        return streamURL;
    }
}
