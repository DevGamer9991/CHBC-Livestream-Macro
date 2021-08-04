package com.parker;

import com.parker.MainWindow.MainWindow;
import com.parker.youtube.*;

public class CreateYoutubeStream {
    public static final String DevKey = "AIzaSyCuumDlKGiJJdHa5IIkp5FxydAjn7zUAhY";

    public static String broadcastID;
    public static String streamID;
    public static String streamURL;
    public static String streamKey;

    public void createYoutubeStream(String titleString, String descString) throws Exception {
        if (!titleString.equals("")){
            auth(titleString, descString);
        } else {
            auth("Test Stream", descString);
        }
    }

    public void auth(String titleString, String descString) throws Exception {
        Authorize auth = new Authorize();
        auth.authorize();

        new CreateBroadcast().create(titleString, descString, DevKey);

        if (new ManageYoutubeData().checkFile("Data Files/YoutubeData.json")) {

            if (new ManageYoutubeData().getStreamIDFromFile() != null) {
                System.out.println("Ran Check");
                new CheckStreamID().check(new ManageYoutubeData().getStreamIDFromFile());
            } else {
                System.out.println("Didn't Run Check");
                new CreateStream().create(DevKey);
                new ManageYoutubeData().saveFile();
            }

        } else {
            new CreateStream().create(DevKey);
            new ManageYoutubeData().saveFile();
        }

        ManageYoutubeData manageYoutubeData = new ManageYoutubeData();

        manageYoutubeData.setStreamKeyFromFile();
        manageYoutubeData.setStreamURLFromFile();

        System.out.println("Binding");

        new BindBroadcast().bind(manageYoutubeData.getBroadcastID(), manageYoutubeData.getStreamID(), DevKey);

        streamID = new ManageYoutubeData().getStreamID();
        streamURL = new ManageYoutubeData().getStreamURL();
        streamKey = new ManageYoutubeData().getStreamKey();

        System.out.println(new ManageYoutubeData().getBroadcastID());
        System.out.println(new ManageYoutubeData().getStreamID());
        System.out.println(new ManageYoutubeData().getStreamURL());
        System.out.println(new ManageYoutubeData().getStreamKey());

        new MainWindow().setData();

        new MainWindow().setLoadingBar(16);
    }

    public String getStreamID() {
        return streamID;
    }
    public String getStreamURL() {
        return streamURL;
    }
    public String getBroadcastID() {
        return broadcastID;
    }
    public String getStreamKey() {
        return streamKey;
    }
}
