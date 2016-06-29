package com.javarush.test.level14.lesson08.bonus03;

/**
 * Created by alexandr on 31.12.2015.
 */
public class Singleton
{
    private static final Singleton singleton = new Singleton();

    private Singleton(){}

    public static Singleton getInstance()
    {
        return singleton;
    }
}
