package com.parker.youtube;

import com.parker.GetFacebookData;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Objects;

public class TransitionLoop {

    public boolean transitioned = false;

    public void startLoop(String id, String DevKey) throws GeneralSecurityException, IOException, InterruptedException {
        while (!transitioned) {
            Thread.sleep(2000);
            System.out.println(new ManageYoutubeData().getStreamKey());
            if (new GetStreamStatusFromID().get(id).equals("noData")) {
                System.out.println("no");
            } else {
                System.out.println("yes");
                new TransitionBroadcast().transition(new ManageYoutubeData().getBroadcastID(), DevKey);
            }
        }
    }
}
