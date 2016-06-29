package com.javarush.test.level14.lesson08.bonus01;

import sun.misc.ExtensionInstallationException;

import javax.crypto.ExemptionMechanismException;
import java.rmi.activation.ActivationException;
import java.rmi.server.ExportException;
import java.util.*;

/* Нашествие эксепшенов
Заполни массив exceptions 10 различными эксепшенами.
Первое исключение уже реализовано в методе initExceptions.
*/

public class Solution
{
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args)
    {
        initExceptions();

        for (Exception exception : exceptions)
        {
            System.out.println(exception);
        }
    }

    private static void initExceptions()
    {   //it's first exception
        try
        {
            float i = 1 / 0;

        } catch (Exception e)
        {
            exceptions.add(e);
        }

        //Add your code here
        try
        {
            int[] array = new int[1];
            int result = array[5]/2;
        }catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            Integer integer = null;
            int result = integer/1;
        }catch (Exception e)
        {
            exceptions.add(e);
        }

        exceptions.add(new ActivationException());
        exceptions.add(new ExportException("blya"));
        exceptions.add(new ExemptionMechanismException());
        exceptions.add(new RuntimeException());
        exceptions.add(new ConcurrentModificationException());
        exceptions.add(new DuplicateFormatFlagsException(""));
        exceptions.add(new EmptyStackException());
    }
}
