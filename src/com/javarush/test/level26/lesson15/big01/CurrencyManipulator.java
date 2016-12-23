package com.javarush.test.level26.lesson15.big01;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Inontran on 17.12.2016.
 */
public class CurrencyManipulator
{
    private String currencyCode;
    private Map<Integer, Integer> denominations;

    public CurrencyManipulator(String currencyCode)
    {
        this.currencyCode = currencyCode;
        denominations = new HashMap<>();
    }

    public String getCurrencyCode()
    {
        return currencyCode;
    }

    public void addAmount(int denomination, int count)
    {
        if (!denominations.containsKey(denomination)) denominations.put(denomination, count);
        else denominations.put(denomination, denominations.get(denomination) + count);
    }

    public int getTotalAmount()
    {
        int balance = 0;
        for (Map.Entry<Integer,Integer> pair : denominations.entrySet())
        {
            balance += pair.getKey() * pair.getValue();
        }
        return balance;
    }
}
