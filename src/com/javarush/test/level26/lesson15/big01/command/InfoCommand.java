package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;

import java.util.Map;

/**
 * Created by Inontran on 23.12.2016.
 */
class InfoCommand implements Command
{
    @Override
    public void execute()
    {
        Map<String, CurrencyManipulator> manipulatorMap = CurrencyManipulatorFactory.getAllCurrencyManipulators();


        for (Map.Entry<String, CurrencyManipulator> pair : manipulatorMap.entrySet())
        {
            System.out.println(pair.getKey() + " - " + pair.getValue().getTotalAmount());
        }
    }
}
