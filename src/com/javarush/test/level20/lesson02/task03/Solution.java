package com.javarush.test.level20.lesson02.task03;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуйте логику записи в файл и чтения из файла для карты properties.
*/
public class Solution {

    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() {
        //implement this method - реализуйте этот метод
        try
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            InputStream inputStream = new FileInputStream(reader.readLine());
            try{
                load(inputStream);
            } catch (Exception e){
                e.printStackTrace();
            }

            inputStream.close();
            reader.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties pr = new Properties();
        for (Map.Entry<String,String> pair : properties.entrySet()){
            pr.setProperty(pair.getKey(), pair.getValue());
        }
        pr.store(outputStream, "properties");
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties pr = new Properties();
        pr.load(inputStream);
        for (Map.Entry<Object, Object> pair : pr.entrySet()){
            properties.put(pair.getKey().toString(), pair.getValue().toString());
        }
    }
}
