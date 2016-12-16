package com.javarush.test.level26.lesson15.big01;

import java.io.*;

/**
 * Created by Inontran on 16.12.2016.
 */
public class ConsoleHelper
{
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message)
    {
        try
        {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
            writer.write(message);
        }
        catch (Exception e)
        {
//            e.printStackTrace();
        }
    }

    public static String readString()
    {
        try
        {
            return bufferedReader.readLine();
        }
        catch (IOException e)
        {
//            e.printStackTrace();
        }
        return "";
    }
}
