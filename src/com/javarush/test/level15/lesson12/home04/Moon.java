package com.javarush.test.level15.lesson12.home04;

/**
 * Created by root on 03.01.16.
 */
public class Moon implements Planet
{
    private static Moon instance= new Moon();

    private Moon(){}

    public static Moon getInstance()
    {
        if (instance==null){
            instance = new Moon();
        }
        return instance;
    }
}
