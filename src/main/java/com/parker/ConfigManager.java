package com.parker;

import java.io.File;
import java.util.Locale;

public class ConfigManager {
    public static String defaultDir = System.getProperty("user.home") + "/Documents/CHBC Livestream Macro/";

    public static String linDir = "~/.chbc-livestream-macro/";

    public static String chechArch() {
        String os = System.getProperty("os.name");

        if (os.toLowerCase(Locale.ROOT).contains("win")) {
            return defaultDir;
        } else if (os.toLowerCase(Locale.ROOT).contains("mac")){
            return defaultDir;
        } else if (os.toLowerCase(Locale.ROOT).contains("nix") || os.toLowerCase(Locale.ROOT).contains("nux") || os.toLowerCase(Locale.ROOT).contains("aix")) {
            return linDir;
        }

        System.out.println(os);
        return null;
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
