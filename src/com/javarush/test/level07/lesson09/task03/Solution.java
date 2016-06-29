package com.javarush.test.level07.lesson09.task03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* Слово «именно»
1. Создай список из слов «мама», «мыла», «раму».
2. После каждого слова вставь в список строку, содержащую слово «именно».
3. Используя цикл for вывести результат на экран, каждый элемент списка с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        ArrayList<String> stringArrayList = new ArrayList<String>();

        stringArrayList.add("мама");
        stringArrayList.add("мыла");
        stringArrayList.add("раму");
        stringArrayList.add(1, "именно");
        stringArrayList.add(3, "именно");
        stringArrayList.add(5, "именно");

        for (int i = 0; i < stringArrayList.size(); i++){
            System.out.println(stringArrayList.get(i));
        }
    }
}
