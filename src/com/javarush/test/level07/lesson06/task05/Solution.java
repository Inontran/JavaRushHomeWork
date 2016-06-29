package com.javarush.test.level07.lesson06.task05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Удали последнюю строку и вставь её в начало
1. Создай список строк.
2. Добавь в него 5 строчек с клавиатуры.
3. Удали последнюю строку и вставь её в начало. Повторить 13 раз.
4. Используя цикл выведи содержимое на экран, каждое значение с новой строки.
*/
public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        ArrayList<String> stringArrayList = new ArrayList<String>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++){
            stringArrayList.add(bufferedReader.readLine());
        }

        for (int i = 0; i < 13; i++){
            stringArrayList.add(0, stringArrayList.get(stringArrayList.size()-1));
            stringArrayList.remove(stringArrayList.size() - 1);
        }

        for (int i = 0; i < stringArrayList.size(); i++){
            System.out.println(stringArrayList.get(i));
        }
    }
}
