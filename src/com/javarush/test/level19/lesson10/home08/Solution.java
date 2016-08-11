package com.javarush.test.level19.lesson10.home08;

/* Перевертыши
1 Считать с консоли имя файла.
2 Для каждой строки в файле:
2.1 переставить все символы в обратном порядке
2.2 вывести на экран
3 Закрыть потоки. Не использовать try-with-resources

Пример тела входного файла:
я - программист.
Амиго

Пример результата:
.тсиммаргорп - я
огимА
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        //1 Считать с консоли имя файла.
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(consoleReader.readLine()));

        //2 Для каждой строки в файле:
        while (fileReader.ready()){
            //получаем строку из файла
            String stringFromFile = fileReader.readLine();
            //2.1 переставить все символы в обратном порядке
            stringFromFile = new StringBuffer(stringFromFile).reverse().toString();

            //2.2 вывести на экран
            System.out.println(stringFromFile);
        }

        //3 Закрыть потоки.
        if (consoleReader!=null) consoleReader.close();
        if (fileReader!=null) fileReader.close();
    }
}
