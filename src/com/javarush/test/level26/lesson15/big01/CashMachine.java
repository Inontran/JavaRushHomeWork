package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.command.CommandExecutor;

import java.io.IOException;
import java.util.Locale;

/**
 * Created by Inontran on 16.12.2016.
 */
public class CashMachine
{
    public static void main(String[] args) throws IOException
    {
        Locale.setDefault(Locale.ENGLISH);

        String operation = "";
        do
        {
            System.out.println("Enter type of operation: ");
            operation = ConsoleHelper.readString().toUpperCase();
            try
            {
                CommandExecutor.execute(Operation.valueOf(operation));
            } catch (IllegalArgumentException e){}
        } while ( !operation.equals("EXIT"));
    }


}
