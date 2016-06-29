package com.javarush.test.level08.lesson11.bonus01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* Номер месяца
Программа вводит с клавиатуры имя месяца и выводит его номер на экран в виде: «May is 5 month».
Используйте коллекции.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        //напишите тут ваш код
        HashMap<Integer, String> hashMap = new HashMap<Integer, String>(12);
        hashMap.put(0, "January");
        hashMap.put(1, "February");
        hashMap.put(2, "March");
        hashMap.put(3, "April");
        hashMap.put(4, "May");
        hashMap.put(5, "June");
        hashMap.put(6, "July");
        hashMap.put(7, "August");
        hashMap.put(8, "September");
        hashMap.put(9, "October");
        hashMap.put(10, "November");
        hashMap.put(11, "December");

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String month = bufferedReader.readLine();

        Iterator<Map.Entry<Integer, String>> iterator = hashMap.entrySet().iterator();

        while (iterator.hasNext()){
            Map.Entry<Integer, String> pair = iterator.next();
            if (month.equals(pair.getValue())) System.out.println( pair.getValue() + " is " + (pair.getKey()+1) + " month" );
        }
    }

}
