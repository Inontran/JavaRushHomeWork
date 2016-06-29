package com.javarush.test.level15.lesson12.home04;

/**
 * Created by root on 03.01.16.
 */
public class Earth implements Planet
{
    private static Earth instance= new Earth();

    private Earth(){}

    public static Earth getInstance()
    {
        if (instance==null){
            instance = new Earth();
        }
        return instance;
    }
}
