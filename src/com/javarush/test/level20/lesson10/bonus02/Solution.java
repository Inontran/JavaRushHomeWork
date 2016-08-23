package com.javarush.test.level20.lesson10.bonus02;

import java.lang.reflect.Array;
import java.util.Arrays;

/* Алгоритмы-прямоугольники
1. Дан двумерный массив N*N, который содержит несколько прямоугольников.
2. Различные прямоугольники не соприкасаются и не накладываются.
3. Внутри прямоугольник весь заполнен 1.
4. В массиве:
4.1) a[i, j] = 1, если элемент (i, j) принадлежит какому-либо прямоугольнику
4.2) a[i, j] = 0, в противном случае
5. getRectangleCount должен возвращать количество прямоугольников.
6. Метод main не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        int count = getRectangleCount(a);
        System.out.println("count = " + count + ". Должно быть 2");
    }

    public static int getRectangleCount(byte[][] a) {
        int count = 0;

        for (int i = 0; i < a.length; i++){

            for (int j = 0; j < a.length; j++){
                if (a[i][j]==1){
                    count++;
                    a = fillByZero(a, i, j);
                }
            }
        }

        return count;
    }

    public static byte[][] fillByZero(byte[][] a, int startI, int startJ){
        //здесь вычисляем ширину прямоугольника
        int widthOfRect = 0;
        for (int j = startJ; j < a.length; j++){
            if (a[startI][j]==1) widthOfRect++;
            else break;
        }

        //здесь по строчно заменяем еденицы нулями
        for (int i = startI; i < a.length; i++){
            if (a[i][startJ]==1) Arrays.fill(a[i], startJ, startJ + widthOfRect, (byte)0 );
            else break;
        }
        return a;
    }
}
