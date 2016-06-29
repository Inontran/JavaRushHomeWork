package com.javarush.test.level03.lesson08.task02;

/* Зарплата через 5 лет
Ввести с клавиатуры Имя и два числа, вывести надпись:
name1 получает «число1» через «число2» лет.
Пример: Коля получает 3000 через 5 лет.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String name = bufferedReader.readLine();
        String num1Str = bufferedReader.readLine();
        int num1 = Integer.parseInt(num1Str);
        String num2Str = bufferedReader.readLine();
        int num2 = Integer.parseInt(num2Str);

        System.out.println(name + " получает " + num1 + " через " + num2 + " лет.");




    }
}