package com.qacart.todo.Utils;

import java.util.Properties;

public class ConfigUtils {
    private Properties properties;
    private static ConfigUtils configUtils;

    public ConfigUtils() {
        String env = System.getProperty("env","PRODUCTION");
        switch (env){
            case "PRODUCTION":
                properties = PropertiesUtil.loadProperties("src/test/java/com/qacart/todo/config/production.properties");
                break;
            case "LOCAL":
                properties = PropertiesUtil.loadProperties("src/test/java/com/qacart/todo/config/local.properties");
                break;
            default:
                throw new RuntimeException("Invalid environment name");
        }

       // properties = PropertiesUtil.loadProperties("src/test/java/com/qacart/todo/config/production.properties");
    }

    public static ConfigUtils getInstance() {
        if (configUtils == null) {
            configUtils = new ConfigUtils();
        }
        return configUtils;
    }

    public String getBaseUrl() {
        String prop = properties.getProperty("baseUrl");
        if (prop != null) return prop;
        throw new RuntimeException("baseUrl is not specified in the production.properties file");

    }
    public String getEmail() {
        String prop = properties.getProperty("email");
        if (prop != null) return prop;
        throw new RuntimeException("email is not specified in the production.properties file");

    }
    public String getPassword() {
        String prop = properties.getProperty("password");
        if (prop != null) return prop;
        throw new RuntimeException("password is not specified in the production.properties file");

    }


}