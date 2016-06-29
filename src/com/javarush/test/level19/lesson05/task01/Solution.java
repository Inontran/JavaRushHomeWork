package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
Закрыть потоки ввода-вывода.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader readerConsole = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader;
        FileWriter fileWriter;
        try
        {
            String pathInputFile = readerConsole.readLine();
            String pathOutputFile  = readerConsole.readLine();
            fileReader = new FileReader(pathInputFile);
            fileWriter = new FileWriter(pathOutputFile);

            while (fileReader.ready())
            {
                char[] buffer = new char[64];
                fileReader.read(buffer);
                fileWriter.write(cutArray(buffer));
            }
            fileReader.close();
            fileWriter.close();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static char[] cutArray(char[] buffer)
    {
        char[] bytes = new char[buffer.length/2];
        for (int i = 0; i < bytes.length; i++)
        {
            bytes[i] = buffer[i*2+1];
        }
        return bytes;
    }
}
