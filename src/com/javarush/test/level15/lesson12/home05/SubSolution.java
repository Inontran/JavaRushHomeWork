package com.javarush.test.level15.lesson12.home05;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

/**
 * Created by root on 03.01.16.
 */
public class SubSolution extends Solution
{
    public SubSolution()
    {
    }

    public SubSolution(String s)
    {
        super(s);
    }

    public SubSolution(Object o)
    {
        super(o);
    }

    SubSolution(Integer i)
    {
        super(i);
    }

    SubSolution(Float f)
    {
        super(f);
    }

    SubSolution(Double d)
    {
        super(d);
    }

    protected SubSolution(Exception e)
    {
        super(e);
    }

    protected SubSolution(ArrayList<String> list)
    {
        super(list);
    }

    protected SubSolution(LinkedList<String> list)
    {
        super(list);
    }

    private SubSolution(Date d){}
    private SubSolution(Date d, Integer i){}
    private SubSolution(Date d, String s){}
}
