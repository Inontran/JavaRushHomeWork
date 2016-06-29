package com.javarush.test.level14.lesson06.home01;

/**
 * Created by root on 30.12.15.
 */
public class RussianHen extends Hen
{
    @Override
    public int getCountOfEggsPerMonth()
    {
        return 1;
    }

    public String getDescription()
    {
        return super.getDescription() + " Моя страна - " + Country.RUSSIA +
                ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
