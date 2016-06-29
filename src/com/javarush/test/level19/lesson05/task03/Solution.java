package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки. Не использовать try-with-resources

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import com.sun.xml.internal.fastinfoset.util.CharArray;

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        BufferedReader readerConsole = new BufferedReader(new InputStreamReader(System.in));
        try
        {
            FileReader fileReader = new FileReader(readerConsole.readLine());
            FileWriter fileWriter = new FileWriter(readerConsole.readLine());
            Scanner scanner = new Scanner(fileReader);
            while (scanner.hasNext())
            {
                String string = scanner.next();
                try
                {
                    int num = Integer.parseInt(string);
                    char[] buffer = Character.toChars(num);
                    fileWriter.write(buffer);
                    fileWriter.write(' ');
                    System.out.println(num);
                }
                catch (Exception e) {}
            }

            if (fileReader!=null) fileReader.close();
            if (fileWriter!=null) fileWriter.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
