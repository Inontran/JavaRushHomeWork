package com.javarush.test.level25.lesson16.big01;

/**
 * Created by Inontran on 29.10.2016.
 */
public class SpaceShip extends BaseObject
{
    private double dx = 0;

    public SpaceShip(double x, double y)
    {
        super(x, y, 3);
    }

    public void moveLeft()
    {
        dx = -1;
    }

    public void moveRight()
    {
        dx = 1;
    }
}
