package com.javarush.test.level22.lesson09.task03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* Составить цепочку слов
В методе main считайте с консоли имя файла, который содержит слова, разделенные пробелом.
В методе getLine используя StringBuilder расставить все слова в таком порядке,
чтобы последняя буква данного слова совпадала с первой буквой следующего не учитывая регистр.
Каждое слово должно участвовать 1 раз.
Метод getLine должен возвращать любой вариант.
Слова разделять пробелом.
В файле не обязательно будет много слов.

Пример тела входного файла:
Киев Нью-Йорк Амстердам Вена Мельбурн

Результат:
Амстердам Мельбурн Нью-Йорк Киев Вена
*/
public class Solution {
    public static void main(String[] args){
        try
        {
            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader fileReader = new BufferedReader(new FileReader(consoleReader.readLine()));

            String[] strings = fileReader.readLine().split(" ");

            StringBuilder result = getLine(strings);
            System.out.println(result.toString());
        } catch (Exception e) {e.printStackTrace();}
    }

    public static StringBuilder getLine(String... words) {
        if (words == null) return null;

        StringBuilder stringBuilder = new StringBuilder();
        if (words.length == 0) return stringBuilder;
        if (words.length == 1) return stringBuilder.append(words[0]);

        String charOfPreviousString;
        String charOfNextString;

        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < words.length; i++) list.add(words[i]);
        Collections.shuffle(list);
        for (int i = 0; i < list.size(); i++) words[i] = list.get(i);

        for (int i = 0; i < words.length; i++)
        {
            charOfPreviousString = words[i].substring(words[i].length()-1, words[i].length());
            for (int j = i + 1; j < words.length; j++)
            {
                charOfNextString = words[j].substring(0, 1);
                if ( charOfPreviousString.equalsIgnoreCase(charOfNextString) )
                {
                    String temp = words[i+1];
                    words[i+1] = words[j];
                    words[j] = temp;
                    break;
                }
            }
        }

        for (int i = 0; i < words.length; i++)
        {
            stringBuilder.append(words[i]);
            if (i < words.length-1) stringBuilder.append(" ");
        }
        return stringBuilder;
    }
}
