package com.javarush.test.level25.lesson16.big01;

/**
 * Created by Inontran on 29.10.2016.
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

    public void setPoint(double x, double y, char c)
    {
        if (x > 0 && y > 0 && y < matrix.length && x < matrix[0].length) matrix[(int)y][(int)x] = c;
    }

    public void drawMatrix(double x, double y, int[][] matrix, char c)
    {
        for (int i = 0; i < matrix.length; i++)
        {
            for (int j = 0; j < matrix[i].length; j++)
            {
                if (matrix[i][j] != 0) setPoint(x+j, y+i, c);
            }
        }
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
