package com.javarush.test.level13.lesson11.home03;

/* Чтение файла
1. Считать с консоли имя файла.
2. Вывести в консоль(на экран) содержимое файла.
3. Не забыть освободить ресурсы. Закрыть поток чтения с файла и поток ввода с клавиатуры.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args)
    {
        //add your code here
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String path = "";
        try
        {
            path = bufferedReader.readLine();
            bufferedReader.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        try
        {
            InputStream inputStream = new FileInputStream(path);
            while (inputStream.available() > 0){
                System.out.print((char)inputStream.read());
            }
            inputStream.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
