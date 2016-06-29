package com.javarush.test.level05.lesson12.bonus03;

import java.io.*;

/* Задача по алгоритмам
Написать программу, которая:
1. вводит с консоли число N > 0
2. потом вводит N чисел с консоли
3. выводит на экран максимальное из введенных N чисел.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int maximum;

        //напишите тут ваш код
        String strN = reader.readLine();
        int N = Integer.parseInt(strN);
        int[] array = new int[N];

        for (int i = 0; i < N; i++){
            array[i] = Integer.parseInt(reader.readLine());
        }

        maximum = array[0];
        for (int i = 1; i < N; i++){
            if ( array[i] > maximum ) maximum = array[i];
        }

        System.out.println(maximum);
    }
}
