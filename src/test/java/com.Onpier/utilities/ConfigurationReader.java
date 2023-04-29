package com.Onpier.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    //1- Create the object of Properties
    private static Properties properties = new Properties();

    static {

        try {

            //2- We need to open the file in java memory: FileInputStream
            FileInputStream file = new FileInputStream("configuration.properties");

            //3- Load the properties object using FileInputStream object
            properties.load(file);

            // close the file
            file.close(); // we dont have to, gqrbage collecctor can take care, but we did mat

        } catch (IOException e) {
            System.out.println("File not found in the ConfigurationReader class.");
            e.printStackTrace();
        }
    }

    public static String getProperty(String keyword){

        return properties.getProperty(keyword);
    }


    public static String get(String url) {
        return url;
    }
}

