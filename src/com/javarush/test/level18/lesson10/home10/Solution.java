package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader readeronsole = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> stringArrayList = new ArrayList<>();
        String path = readeronsole.readLine();
        while (!path.equals("end"))
        {
            stringArrayList.add(path);
            path = readeronsole.readLine();
        }
        readeronsole.close();

        Collections.sort(stringArrayList, new Comparator<String>()
        {
            @Override
            public int compare(String o1, String o2)
            {
                return o1.compareTo(o2);
            }
        });

        String fileNameResult = stringArrayList.get(0).substring(0, stringArrayList.get(0).length()-6);
        File file = new File(fileNameResult);
        file.createNewFile();

        FileOutputStream fileOutputStream = new FileOutputStream(file);
        for (int i = 0; i < stringArrayList.size(); i++)
        {
            FileInputStream fileInputStream = new FileInputStream(stringArrayList.get(i));
            byte buffer[] = new byte[1024];
            while (fileInputStream.available() > 0)
            {
                fileInputStream.read(buffer);
                fileOutputStream.write(buffer);
            }
            fileInputStream.close();
        }
        fileOutputStream.close();
    }
}
