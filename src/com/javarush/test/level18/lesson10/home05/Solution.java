package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
*/

import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String path1 = reader.readLine();
        String path2 = reader.readLine();
        reader.close();

        File file = new File(path1);
        FileReader fileReader = new FileReader(file);
        FileWriter fileWriter = new FileWriter(path2);

        String stringFromFile = "";
        if (fileReader.ready())
        {
            char[] buffer = new char[(int) file.length()];
            fileReader.read(buffer);
            stringFromFile = String.valueOf(buffer);
        }
        fileReader.close();

        StringTokenizer tokenizer = new StringTokenizer(stringFromFile, " ");
        while (tokenizer.hasMoreTokens())
        {
            float number = Float.parseFloat(tokenizer.nextToken());
            fileWriter.write(String.valueOf(round(number) + " "));
        }
        fileWriter.close();
    }

    public static int round(float number)
    {
        float tmp = number - (int)number;
        if (number > 0)
        {
            if (tmp >= 0.5) return (int)number + 1;
            else return (int)number;
        }
        if (number < 0)
        {
            if (tmp < -0.5) return (int)number - 1;
            else return (int)number;
        }
        return 0;
    }
}
