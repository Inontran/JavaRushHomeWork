package com.javarush.test.level22.lesson05.task01;

import java.util.StringTokenizer;

/* Найти подстроку
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.
Пример: "JavaRush - лучший сервис обучения Java."
Результат: "- лучший сервис обучения"
На некорректные данные бросить исключение TooShortStringException (сделать исключением).
Сигнатуру метода getPartOfString не менять.
Метод main не участвует в тестировании.
*/
public class Solution {

    public static void main(String[] args) throws TooShortStringException
    {
        System.out.println(getPartOfString("JavaRush - лучший сервис qwe qwe "));
    }

    public static String getPartOfString(String string)
    {
        try
        {
            int startIndex = string.indexOf(" ");
            int endIndex = startIndex;
            if (startIndex == -1) throw new TooShortStringException();
            for (int i = 1; i <= 4; i++)
            {
                endIndex = string.indexOf(" ", endIndex + 1);
                if (endIndex == -1) throw new TooShortStringException();
            }
            return string.substring(startIndex + 1, endIndex);
        }
        catch (TooShortStringException e)
        {
            e.printStackTrace();
        }
        return "";
    }

    public static class TooShortStringException extends Exception{
    }
}
