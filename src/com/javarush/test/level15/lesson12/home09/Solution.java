package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        //add your code here
        String url = "";
        try
        {
//            System.out.println("Ввод:");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            url = reader.readLine();
        }
        catch (Exception e)
        {
            e.getStackTrace();
        }

        for (int i = 0; i < url.length()-1; i++)
            if ( url.substring(i,i+1).equals("?") ) url = new String(url.substring(i+1));

        ArrayList<String> listParameters = new ArrayList<>();
        int startIndexOfParameter = 0;
        int endIndexOfParameter = 0;
        for (int i = 0; i < url.length(); i++)
        {
            if (url.substring(i, i+1).equals("&"))
            {
                startIndexOfParameter = endIndexOfParameter;
                endIndexOfParameter = i;
                listParameters.add(url.substring(startIndexOfParameter, endIndexOfParameter));
                endIndexOfParameter+=1;
            }else if (i==url.length()-1)
            {
                listParameters.add(url.substring(endIndexOfParameter));
            }
        }

        String valueOfObj = "";
        ArrayList<String> listOfValuesObj = new ArrayList<>();
        for (int i = 0; i < listParameters.size(); i++)
        {
            String parametr = listParameters.get(i);
            for (int j = 0; j < parametr.length(); j++)
            {
                if (parametr.substring(j, j+1).equals("=")) parametr = parametr.substring(0, j);
            }
            if (parametr.equals("obj"))
            {
                valueOfObj = listParameters.get(i);
                for (int j = 0; j < valueOfObj.length(); j++)
                {
                    if (valueOfObj.substring(j, j+1).equals("="))
                    {
                        valueOfObj = valueOfObj.substring(j+1);
                        listOfValuesObj.add(valueOfObj);
                    }
                }
            }
            listParameters.set(i, parametr);
        }

//        System.out.println("Вывод:");
        for (int i = 0; i < listParameters.size(); i++) System.out.print(listParameters.get(i) + " ");

        System.out.println();
        if (listOfValuesObj.size()!=0)
        {
            for (int i = 0; i < listOfValuesObj.size(); i++)
            {
                try
                {
                    alert(Double.parseDouble(listOfValuesObj.get(i)));
                }
                catch (Exception e)
                {
                    alert(listOfValuesObj.get(i));
                }
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
