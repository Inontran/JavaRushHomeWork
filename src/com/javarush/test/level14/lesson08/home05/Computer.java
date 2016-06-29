package com.javarush.test.level14.lesson08.home05;

/**
 * Created by alexandr on 31.12.2015.
 */
public class Computer
{
    private Monitor monitor;
    private Mouse mouse;
    private Keyboard keyboard;

    public Computer()
    {
        this.monitor = new Monitor();
        this.mouse = new Mouse();
        this.keyboard = new Keyboard();
    }

    public Monitor getMonitor()
    {
        return monitor;
    }

    public Mouse getMouse()
    {
        return mouse;
    }

    public Keyboard getKeyboard()
    {
        return keyboard;
    }
}
