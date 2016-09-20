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
        System.out.println(getPartOfString("JavaRush - лучший сервис wer wer  wer"));
    }

    public static String getPartOfString(String string) throws TooShortStringException
    {
        String partString = "";
        int startIndex = string.indexOf(" ");
        if (startIndex == -1) throw new TooShortStringException();


        return partString;
    }

    public static class TooShortStringException extends Exception{
    }
}
