package com.parker;

public class Logger {

    public static boolean consoleEnabled;

    public static void println(Object s) {
        if (!consoleEnabled) return;

        System.out.println(s);
    }

    public static void printlnOverride(Object s) {
        System.out.println(s);
    }

    public static void print(Object s) {
        if (!consoleEnabled) return;

        System.out.print(s);
    }
}
