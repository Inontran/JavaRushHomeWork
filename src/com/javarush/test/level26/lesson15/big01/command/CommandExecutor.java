package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.Operation;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Inontran on 23.12.2016.
 */
public class CommandExecutor
{
    private static Map<Operation, Command> mapOperation;
    static {
        mapOperation = new HashMap<>();
        mapOperation.put(Operation.DEPOSIT, new DepositCommand() );
        mapOperation.put(Operation.EXIT, new ExitCommand() );
        mapOperation.put(Operation.INFO, new InfoCommand() );
        mapOperation.put(Operation.WITHDRAW, new WithdrawCommand() );
    }

    private CommandExecutor(){}

    public static final void execute(Operation operation)
    {
        try
        {
            if (mapOperation.containsKey(operation)) mapOperation.get(operation).execute();
            else throw new InterruptOperationException();
        }
        catch (InterruptOperationException e)
        {
//            e.printStackTrace();
        }
    }
}
