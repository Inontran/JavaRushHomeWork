package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        // напишите тут ваш код
        BufferedReader readerCosole = new BufferedReader(new InputStreamReader(System.in));
        String path = readerCosole.readLine();
        readerCosole.close();

        ArrayList<Integer> list = new ArrayList<>();
        BufferedReader readerFile = new BufferedReader(new FileReader(path));
        String stringFromFile = "";
        while ( (stringFromFile = readerFile.readLine())!=null)
        {
            int number = Integer.parseInt(stringFromFile);
            list.add(number);
        }
        readerFile.close();

        Collections.sort(list, new Comparator<Integer>()
        {
            public int compare(Integer o1, Integer o2)
            {
                return o1.compareTo(o2);
            }
        });

        for (int i = 0; i < list.size(); i++)
        {
            if ( list.get(i)%2==0 ) System.out.println(list.get(i));
        }
    }
}
