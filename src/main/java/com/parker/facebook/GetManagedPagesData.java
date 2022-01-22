package com.parker.facebook;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class GetManagedPagesData {

    public String get() {
        try {
            URL url = new URL("https://graph.facebook.com/v11.0/me/accounts?fields=id%2Cname%2Caccess_token&access_token=" + new GetFacebookData().getAccessToken());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestMethod("GET");

            InputStream in = new BufferedInputStream(conn.getInputStream());

            String result = new String(in.readAllBytes(), StandardCharsets.UTF_8);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
