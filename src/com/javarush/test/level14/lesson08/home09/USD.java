package com.javarush.test.level14.lesson08.home09;

/**
 * Created by alexandr on 31.12.2015.
 */
public class USD extends Money
{
    public USD(double amount)
    {
        super(amount);
    }

    @Override
    public String getCurrencyName()
    {
        return "USD";
    }
}
