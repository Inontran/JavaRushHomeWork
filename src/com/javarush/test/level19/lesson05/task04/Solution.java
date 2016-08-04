package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader readerConsole = new BufferedReader(new InputStreamReader(System.in));
        try
        {
            FileReader fileReader = new FileReader(readerConsole.readLine());
            FileWriter fileWriter = new FileWriter(readerConsole.readLine());

            while(fileReader.ready()){
                char[] buffer = new char[64];
                fileReader.read(buffer);
                //если в порции символов содержиться точки, то заменяем на ! и записываем в другой файл
                if (String.valueOf(buffer).contains(".")){
                    for (int i = 0; i < buffer.length; i++){
                        if (buffer[i]=='.') buffer[i] = '!';
                    }
                    fileWriter.write(buffer);
                } else {//иначе, просто переписываем в другой файл
                    fileWriter.write(buffer);
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
