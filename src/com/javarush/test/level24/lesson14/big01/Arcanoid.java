package com.javarush.test.level24.lesson14.big01;

import java.util.ArrayList;

/**
 * Created by Inontran on 18.10.2016.
 */
public class Arcanoid
{
    private int height;
    private int width;
    private Ball ball;
    private Stand stand;
    private ArrayList<Brick> bricks;

    public static Arcanoid game;

    public Arcanoid(int height, int width)
    {
        this.height = height;
        this.width = width;
    }

    public static void main(String[] args)
    {

    }

    public void run(){}

    public void move(){}



    public Ball getBall()
    {
        return ball;
    }

    public void setBall(Ball ball)
    {
        this.ball = ball;
    }

    public Stand getStand()
    {
        return stand;
    }

    public void setStand(Stand stand)
    {
        this.stand = stand;
    }

    public ArrayList<Brick> getBricks()
    {
        return bricks;
    }

    public void setBricks(ArrayList<Brick> bricks)
    {
        this.bricks = bricks;
    }

    public int getHeight()
    {
        return height;
    }

    public void setHeight(int height)
    {
        this.height = height;
    }

    public int getWidth()
    {
        return width;
    }

    public void setWidth(int width)
    {
        this.width = width;
    }
}
