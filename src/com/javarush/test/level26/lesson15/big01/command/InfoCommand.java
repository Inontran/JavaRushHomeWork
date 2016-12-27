package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;

import java.util.Collection;
import java.util.Map;

/**
 * Created by Inontran on 23.12.2016.
 */
class InfoCommand implements Command
{
    @Override
    public void execute()
    {
        boolean moneyAvailable = false;
        for (CurrencyManipulator c : CurrencyManipulatorFactory.getAllCurrencyManipulators())
        {
            moneyAvailable = moneyAvailable | c.hasMoney();
            ConsoleHelper.writeMessage(c.getCurrencyCode() + " - " + c.getTotalAmount());
        }
        if (!moneyAvailable)
        {
            ConsoleHelper.writeMessage("No money available.");
        }
    }
}
