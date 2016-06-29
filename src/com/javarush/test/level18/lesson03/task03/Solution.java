package com.javarush.test.level18.lesson03.task03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Самые частые байты
Ввести с консоли имя файла
Найти байт или байты с максимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
//        String path = consoleReader.readLine();
        String path = "/home/JavaRushHomeWork/in.txt";
        FileInputStream inputStreamReader = new FileInputStream(path);
        ArrayList<Integer> listByte = new ArrayList<>();
        listByte.add(0);
        int numberOfRepeat = 0;
        int maxNumberOfRepeat = 0;
        while (inputStreamReader.available() > 0)
        {
            int data = inputStreamReader.read();
            System.out.println(data);
            FileInputStream insideInputStream = new FileInputStream(path);
            while (insideInputStream.available() > 0)
            {
                int insideData = insideInputStream.read();
                if (insideData==data) numberOfRepeat++;
            }
            if (numberOfRepeat > maxNumberOfRepeat)
            {
                maxNumberOfRepeat = numberOfRepeat;
                listByte.set(0, data);
            }
            insideInputStream.close();
        }

        while (inputStreamReader.available() > 0)
        {
            int data = inputStreamReader.read();
            FileInputStream insideInputStream = new FileInputStream(path);
            while (insideInputStream.available() > 0)
            {
                int insideData = insideInputStream.read();
                if (insideData==data) numberOfRepeat++;
            }
            if (numberOfRepeat == maxNumberOfRepeat)
            {
                listByte.add(data);
            }
            insideInputStream.close();
        }

        System.out.println(listByte);

        inputStreamReader.close();
    }
}
