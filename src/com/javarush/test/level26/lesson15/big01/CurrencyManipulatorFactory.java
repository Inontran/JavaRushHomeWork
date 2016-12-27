package com.javarush.test.level26.lesson15.big01;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Inontran on 17.12.2016.
 */
public class CurrencyManipulatorFactory
{
    private static Map<String, CurrencyManipulator> manipulators = new HashMap<>();

    private CurrencyManipulatorFactory()
    {
    }

    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode)
    {
        if (manipulators.containsKey(currencyCode)) return manipulators.get(currencyCode);
        else
        {
            CurrencyManipulator newManipulitor = new CurrencyManipulator(currencyCode);
            manipulators.put(currencyCode, newManipulitor);
            return newManipulitor;
        }
    }

    public static Collection<CurrencyManipulator> getAllCurrencyManipulators()
    {
        return manipulators.values();
    }
}
