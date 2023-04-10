package com.test.sc.assistants.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoadConfig {
    public String loadConfig(String key){
        Properties props = new Properties();
        try (InputStream in = getClass().getClassLoader()
                .getResourceAsStream("Properties.txt")) {
            props.load(in);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return props.getProperty(key);
    }
}
