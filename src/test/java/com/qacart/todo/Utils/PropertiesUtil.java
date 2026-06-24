package com.qacart.todo.Utils;

import java.io.*;
import java.util.Properties;

public class PropertiesUtil {

    public static Properties loadProperties(String FilePath){
        File file = new File(FilePath);
       // InputStream inputStream = new FileInputStream(file);
        try{
            InputStream inputStream = new FileInputStream(file);
            Properties properties = new Properties();
            properties.load(inputStream);
            inputStream.close();
            return properties;

        }catch(FileNotFoundException e){
            throw new RuntimeException("File is no found");

        }catch(IOException e){
            throw new RuntimeException("File is not loaded");
        }

    }
}
