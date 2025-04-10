package com.properties;

public class ConfigProperties {
    public static String browser() {
        return System.getProperty("browser", "chrome");
    }

    public static String browserVersion() {
        return System.getProperty("browser.version", "120.0");
    }

    public static String browserSize() {
        return System.getProperty("browser.size", "1920x1080");
    }

    public static String remoteUrl() {
        return System.getProperty("REMOTE_URL", "https://user1:1234@selenoid.autotests.cloud/wd/hub");
    }
}
