package com.javarush.test.level13.lesson11.home04;

/* Запись в файл
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести абсолютно все введенные строки в файл, каждую строчку с новой стороки.
*/

import java.io.*;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        String exitString = "exit";
        String path = "";
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        try
        {
            path = bufferedReader.readLine();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        try
        {
            OutputStream outputStream = new FileOutputStream(path);
            String stringData = "";
            while (!stringData.equals(exitString)){
                stringData = bufferedReader.readLine();
                outputStream.write((stringData + "\n").getBytes());
            }
            outputStream.close();
            bufferedReader.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}
