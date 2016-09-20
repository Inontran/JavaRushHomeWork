package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;

/**
 * Created by sasha on 20.09.2016.
 */
public class Hippodrome
{
    private ArrayList<Horse> horses = new ArrayList<>();
    public static Hippodrome game;

    public static void main(String[] args)
    {
        game = new Hippodrome();
        Horse mustang = new Horse("Mustang", 3, 0);
        Horse spirit = new Horse("Spirit", 3, 0);
        Horse buravchik = new Horse("Buravchik", 3, 0);

        game.getHorses().add(mustang);
        game.getHorses().add(spirit);
        game.getHorses().add(buravchik);

        game.run();
        game.printWinner();
    }

    public ArrayList<Horse> getHorses()
    {
        return horses;
    }

    public void run()
    {
        for (int i = 1; i <= 100; i++)
        {
            move();
            print();
            try
            {
                Thread.sleep(200);
            }
            catch (InterruptedException e)
            {
            }
        }
    }

    public void move()
    {
        for (Horse currentHorse : horses) currentHorse.move();
    }

    public void print()
    {
        for (Horse currentHorse : horses) currentHorse.print();
        System.out.println();
        System.out.println();
    }

    public Horse getWinner()
    {
        double maxDistance = 0;
        int numberWinner = 0;
        for (int i = 0; i < horses.size(); i++)
            if (maxDistance < horses.get(i).getDistance()) {maxDistance = horses.get(i).getDistance(); numberWinner = i;}
        return horses.get(numberWinner);
    }

    public void printWinner()
    {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }
}
