package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со слов, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
        FileWriter fileWriter = new FileWriter(args[1]);

        while (fileReader.ready()){
            String[] stringsFromFile = fileReader.readLine().split(" ");
            for (int i = 0; i < stringsFromFile.length; i++){
                if (findNumber(stringsFromFile[i])) fileWriter.write(stringsFromFile[i] + " ");
            }
        }

        //Закрыть потоки.
        if (fileReader!=null) fileReader.close();
        if (fileWriter!=null) fileWriter.close();
    }

    public static boolean findNumber(String str){
        try
        {
            Integer.parseInt(str);
            return false;
        } catch (Exception e)
        {
            char[] chars = str.toCharArray();
            for (int i = 0; i < chars.length; i++)
            {
                if (chars[i] >= 48 && chars[i] <= 57) return true;
            }
        }
        return false;
    }
}
