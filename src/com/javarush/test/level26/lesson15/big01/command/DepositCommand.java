package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;

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

        CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currency);
        manipulator.addAmount(Integer.parseInt(money[0]), Integer.parseInt(money[1]));


    }
}
