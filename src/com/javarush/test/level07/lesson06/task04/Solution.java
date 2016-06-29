package com.javarush.test.level07.lesson06.task04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 10 строчек в начало списка
1. Создай список строк в методе main.
2. Добавь в него 10 строчек с клавиатуры, но только добавлять не в конец списка, а в начало.
3. Используя цикл выведи содержимое на экран, каждое значение с новой строки.
*/
public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        ArrayList<String> stringArrayList = new ArrayList<String>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 10; i++){
            stringArrayList.add(0, bufferedReader.readLine());
        }

        for (int i = 0; i < stringArrayList.size(); i++){
            System.out.println(stringArrayList.get(i));
        }
    }
}
