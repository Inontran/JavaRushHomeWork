package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.CharBuffer;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        BufferedReader readerConsole = new BufferedReader(new InputStreamReader(System.in));
        try
        {
            String path = readerConsole.readLine();
            FileReader fileReader = new FileReader(path);
            int countWorld = 0;
            String lastToken = "something";
            while (fileReader.ready())
            {
                char[] buffer = new char[16];
                fileReader.read(buffer);
                StringTokenizer tokenizer = new StringTokenizer(String.valueOf(buffer), " ,.?!:;)(\n");
                int i = 0;
                while (tokenizer.hasMoreTokens())
                {
                    String token = tokenizer.nextToken();
                    if (token.equals("world")) countWorld++;
                    if (i==0)
                    {
                        if ( (lastToken+token).equals("world") ) countWorld++;
                    }
                    lastToken = token;
                    i++;
                }
            }
            if (fileReader!=null) fileReader.close();
            if (readerConsole!=null) readerConsole.close();
            System.out.println(countWorld);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
