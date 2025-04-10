package com.properties;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class JenkinsPropertiesTest {
    @Test
    @Tag("remote")
    void checkJenkinsParameters() {
        System.out.println("Browser: " + System.getProperty("browser", "chrome"));
        System.out.println("Version: " + System.getProperty("browserVersion", "128.0"));
        System.out.println("Size: " + System.getProperty("browserSize", "1920x1080"));
        System.out.println("Remote URL: " + System.getProperty("remoteUrl"));
    }
}