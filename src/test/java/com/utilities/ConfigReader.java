package com.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    //Bu class configuration. properties file/dosyadaki bilgileri okumak icindir

        // Properties object olusturduk
     private  static Properties properties;

    static {
        // Properties file path'i
        String path="configuration.properties";
        try {
            FileInputStream fileInputStream =new FileInputStream(path);
            //Properties objecti aktif et/calistir
            properties=new Properties();

            //dosyayi yukle
            properties.load( fileInputStream);
            //dosyayi, kapat
            fileInputStream.close();


        } catch (IOException e) {

        }

    }
        //getProperti(key)==>value
    public static String getProperty(String key){

        String value=properties.getProperty(key);
        return value;

        //return properties.getProperty(key);


    }


}
