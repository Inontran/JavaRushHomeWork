package com.javarush.test.level26.lesson15.big01;

import java.io.*;

/**
 * Created by Inontran on 16.12.2016.
 */
public class ConsoleHelper
{
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message)
    {
        try
        {
           System.out.println(message);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static String readString()
    {
        try
        {
            return bufferedReader.readLine();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return "error";
    }

    public static String askCurrencyCode()
    {
        writeMessage("Enter currency:");
        String currencyCode = "";
        while (currencyCode.length() != 3)
        {
            currencyCode = readString();
            if (currencyCode.matches("[a-zA-Z]{3}")) return currencyCode.toUpperCase();
            else writeMessage("Currency is incorrect! Please enter currency again.");
        }
        return "";
    }

    public static String[] getValidTwoDigits(String currencyCode)
    {
        writeMessage("Enter denomination and count:");
        String[] parameters;
        while (true)
        {
            parameters = readString().split(" ");
            try
            {
                if ( Integer.parseInt(parameters[0]) < 0 || Integer.parseInt(parameters[1]) < 0 ) throw new Exception();
            }
            catch (Exception e)
            {
                writeMessage("Data is incorrect! Please enter data again.");
                continue;
            }
            break;
        }
        return parameters;
    }

    public static Operation askOperation()
    {
        writeMessage("Enter type of operation:");
        String numberOperation = "";
        while (true)
        {
            try
            {
                numberOperation = readString();
                return Operation.getAllowableOperationByOrdinal( Integer.parseInt(numberOperation) );
            }
            catch (Exception e)
            {
                writeMessage("Data is incorrect! Please enter data again.");
                continue;
            }
//            break;
        }
    }
}
