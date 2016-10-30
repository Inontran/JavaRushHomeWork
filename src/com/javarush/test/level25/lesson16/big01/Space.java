package com.javarush.test.level25.lesson16.big01;

import java.util.ArrayList;

/**
 * Created by Inontran on 29.10.2016.
 */
public class Space
{
    private int height;
    private int width;
    private SpaceShip ship;
    private ArrayList<Ufo> ufos = new ArrayList<>();
    private ArrayList<Rocket> rockets = new ArrayList<>();
    private ArrayList<Bomb> bombs = new ArrayList<>();
    public static Space game;

    public Space(int height, int width)
    {
        this.height = height;
        this.width = width;
    }

    public void run(){}

    public void draw(){}

    public void sleep(int ms){}

    public void setShip(SpaceShip ship)
    {
        this.ship = ship;
    }

    public int getHeight()
    {
        return height;
    }

    public int getWidth()
    {
        return width;
    }

    public SpaceShip getShip()
    {
        return ship;
    }

    public ArrayList<Ufo> getUfos()
    {
        return ufos;
    }

    public ArrayList<Rocket> getRockets()
    {
        return rockets;
    }

    public ArrayList<Bomb> getBombs()
    {
        return bombs;
    }

    public static void main(String[] args)
    {

    }
}
