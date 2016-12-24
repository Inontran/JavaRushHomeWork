package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;

/**
 * Created by Inontran on 23.12.2016.
 */
class DepositCommand implements Command
{
    @Override
    public void execute()
    {
        String currency = ConsoleHelper.askCurrencyCode();
        String[] money = ConsoleHelper.getValidTwoDigits(currency);

        CurrencyManipulator manipulator = new CurrencyManipulator(currency);
        manipulator.addAmount(Integer.parseInt(money[0]), Integer.parseInt(money[1]));
    }
}
