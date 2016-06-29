package com.javarush.test.level15.lesson12.bonus02;

/**
 * Created by root on 04.01.16.
 */
public abstract class DrinkMaker
{
    public abstract void getRightCup();
    public abstract void putIngredient();
    public abstract void pour();

    public void makeDrink()
    {
        getRightCup();
        putIngredient();
        pour();
    }
}
