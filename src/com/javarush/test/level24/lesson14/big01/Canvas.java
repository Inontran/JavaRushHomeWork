package com.javarush.test.level24.lesson14.big01;

/**
 * Created by Inontran on 18.10.2016.
 */
public class Canvas
{
    private int height;
    private int width;
    private char[][] matrix;

    public Canvas(int height, int width)
    {
        this.height = height;
        this.width = width;
        matrix = new char[height][width];
    }

    public int getHeight()
    {
        return height;
    }

    public int getWidth()
    {
        return width;
    }

    public char[][] getMatrix()
    {
        return matrix;
    }
}
