package com.globant.automation.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeSuite;

public class TestRunner {

    private static final String PROPERTIES_FILE = "src/test/resources/config.properties";
    private static final Properties PROPERTIES = new Properties();

    private static String baseUrl;
    private static String apiKey;

    @BeforeSuite
    public void setupEnvironment() {
        loadProperties();
        baseUrl = PROPERTIES.getProperty("url.base");
        apiKey = PROPERTIES.getProperty("api.key");
    }

    private void loadProperties() {
        try (FileInputStream fileInputStream = new FileInputStream(PROPERTIES_FILE)) {
            PROPERTIES.load(fileInputStream);
        } catch (IOException e) {
            System.out.println("Error loading properties file: " + e.getMessage());
        }
    }

    public static String getBaseUrl() {
        return baseUrl;
    }

    public static String getApiKey() {
        return apiKey;
    }
}
