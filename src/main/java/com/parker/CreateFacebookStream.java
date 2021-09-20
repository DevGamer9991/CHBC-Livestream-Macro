package com.parker;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.parker.Logger.Logger;
import com.parker.MainWindow.MainWindow;
import com.parker.facebook.GetFacebookData;
import com.parker.facebook.GetPageAccessToken;

public class CreateFacebookStream {

    public static String streamURL;
    public static String streamID;

    int timeOut;

    public void createStream(String titleString, String descripString, String pageName) throws Exception{
        String access_token = new GetPageAccessToken().get(pageName);
        if (access_token != null) {
            try {
                titleString = titleString.replaceAll(" ", "+");
                descripString = descripString.replaceAll(" ", "+");

                URL url = new URL("https://graph.facebook.com/" + new GetFacebookData().getManagedPagesID(pageName) +"/live_videos?status=LIVE_NOW&title=" + titleString + "&description=" + descripString + "&access_token=" + access_token);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setConnectTimeout(5000);
                conn.setDoOutput(true);
                conn.setDoInput(true);
                conn.setRequestMethod("POST");

                InputStream in = conn.getInputStream();

                String response = new String(in.readAllBytes(), StandardCharsets.UTF_8);

                Logger.println(response);

                Gson gson = new Gson();

                JsonObject jsonObject = gson.fromJson(response, JsonObject.class);

                streamID = jsonObject.get("id").getAsString();
                streamURL = jsonObject.get("secure_stream_url").getAsString();

                if (jsonObject.toString().contains("secure_stream_url")) {
                    MainWindow mainWindow = new MainWindow();
                    Logger.println("\n" + streamID);
                    Logger.println("\n" + streamURL);
                } else {
                    Logger.println("\n Didnt work \n" + jsonObject.toString());
                }

                new MainWindow().setLoadingBar(32);
            }catch (Exception e) {
                if (timeOut > 20) new MainWindow().errorCalled(Arrays.toString(e.getStackTrace()));
                Thread.sleep(1000);
                Logger.println("Error When Creating FB Stream Retrying and Ending in " + timeOut + " Out of 20 Retries");
                timeOut++;
                createStream(titleString, descripString, pageName);
            }
        } else {
            streamID = "";
            streamURL = "";
        }
    }

    public String getStreamID() {
        return streamID;
    }
    public String getStreamURL() {
        return streamURL;
    }
}
