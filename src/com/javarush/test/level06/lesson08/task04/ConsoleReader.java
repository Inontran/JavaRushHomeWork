package com.javarush.test.level06.lesson08.task04;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Класс ConsoleReader
Сделать класс ConsoleReader, у которого будут 4 статических метода:
String readString() – читает с клавиатуры строку
int readInt() – читает с клавиатуры число
double readDouble() – читает с клавиатуры дробное число
boolean readBoolean() – читает с клавиатуры строку "true" или "false" и возвращает соответствующую логическую переменную true или false
Внимание: создавайте переменную для чтения данных с консоли (BufferedReader или Scanner) внутри каждого метода
*/

public class ConsoleReader
{
    public static String readString() throws Exception
    {
        //напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str = bufferedReader.readLine();
        return str;
    }

    public static int readInt() throws Exception
    {
        //напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bufferedReader.readLine());
        return num;
    }

    public static double readDouble() throws Exception
    {
        //напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        double doubl = Double.parseDouble(bufferedReader.readLine());
        return doubl;
    }

    public static boolean readBoolean() throws Exception
    {
        //напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        boolean bool = Boolean.parseBoolean(bufferedReader.readLine());
        return bool;
    }
}
