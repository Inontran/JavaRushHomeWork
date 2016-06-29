package com.javarush.test.level07.lesson09.task02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* Слова в обратном порядке
Введи с клавиатуры 5 слов в список строк. Удали 3 - ий элемент списка, и выведи оставшиеся элементы в обратном порядке.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> stringArrayList = new ArrayList<String>();

        for (int i = 0; i < 5; i++){
            stringArrayList.add(bufferedReader.readLine());
        }

        stringArrayList.remove(2);

        for (int i = stringArrayList.size()-1; i >= 0; i--){
            System.out.println(stringArrayList.get(i));
        }
    }
}
