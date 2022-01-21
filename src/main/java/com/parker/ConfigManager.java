package com.parker;

import java.io.File;
import java.util.Locale;

public class ConfigManager {
    private String defaultDir = System.getProperty("user.home") + "/Documents/CHBC Livestream Macro/";
    
    // Me

    public static String chechArch() {
        return System.getProperty("user.home") + "/Documents/CHBC Livestream Macro/";
    }

    public static boolean createContainer (String path) {
        File temp = new File(path);
        if (!temp.exists()) {
            if (temp.mkdirs()) {
                return true;
            }
        }

        return false;
    }

}
