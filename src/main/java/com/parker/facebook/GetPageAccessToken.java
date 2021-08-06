package com.parker.facebook;

import com.google.gson.Gson;
import com.parker.MainWindow.MainWindow;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Map;

public class GetPageAccessToken {

    int timeOut;

    public String get(String pageName) throws Exception{
        try {
            URL url = new URL("https://graph.facebook.com/v11.0/" + new GetFacebookData().getManagedPagesID(pageName) + "?fields=access_token&access_token=" + new GetFacebookData().getAccessToken());
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
        }catch (Exception e) {
            if (timeOut > 20) new MainWindow().errorCalled(Arrays.toString(e.getStackTrace()));
            Thread.sleep(1000);
            System.out.println("Error When Getting FB Page Access Token Stream Retrying and Ending in " + timeOut + " Out of 20 Retries");
            timeOut++;
            return get(pageName);
        }
    }
}
