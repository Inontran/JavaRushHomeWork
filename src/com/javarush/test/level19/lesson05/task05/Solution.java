package com.javarush.test.level19.lesson05.task05;

/* Пунктуация
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Удалить все знаки пунктуации, включая символы новой строки. Результат вывести во второй файл.
http://ru.wikipedia.org/wiki/%D0%9F%D1%83%D0%BD%D0%BA%D1%82%D1%83%D0%B0%D1%86%D0%B8%D1%8F
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader readerConsole = new BufferedReader(new InputStreamReader(System.in));
        try
        {
            FileReader fileReader = new FileReader(readerConsole.readLine());
            FileWriter fileWriter = new FileWriter(readerConsole.readLine());

            while(fileReader.ready()){
                char[] buffer = new char[1024];
                fileReader.read(buffer);

                StringTokenizer tokenizer = new StringTokenizer(String.valueOf(buffer), "’'[]{}()⟨ ⟩:,‒–—―….!‐-?„“«»“”‘’‹›;   \r\n");
                while (tokenizer.hasMoreTokens()){
                    fileWriter.write(tokenizer.nextToken());
                }
            }

            if (fileReader!=null) fileReader.close();
            if (fileWriter!=null) fileWriter.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        if (readerConsole!=null) readerConsole.close();
    }
}
