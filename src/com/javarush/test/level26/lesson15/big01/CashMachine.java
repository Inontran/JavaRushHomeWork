package com.javarush.test.level26.lesson15.big01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

/**
 * Created by Inontran on 16.12.2016.
 */
public class CashMachine
{
    public static void main(String[] args) throws IOException
    {
        Locale.setDefault(Locale.ENGLISH);

        String currency = ConsoleHelper.askCurrencyCode();
        String[] money = ConsoleHelper.getValidTwoDigits(currency);
        CurrencyManipulator manipulator = new CurrencyManipulator(currency);
        manipulator.addAmount(Integer.parseInt(money[0]), Integer.parseInt(money[1]));
    }


}
