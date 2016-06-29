package com.javarush.test.level18.lesson10.home08;

import java.io.*;
import java.util.*;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader readerConsole = new BufferedReader(new InputStreamReader(System.in));
        String fileName = readerConsole.readLine();
        while (!fileName.equals("exit"))
        {
            new ReadThread(fileName).start();
            fileName = readerConsole.readLine();
        }
        readerConsole.close();
    }

    public static class ReadThread extends Thread {
        private String filename = "";
        public ReadThread(String fileName) throws IOException
        {
            //implement constructor body
            this.filename = fileName;
        }

        // implement file reading here - реализуйте чтение из файла тут
        @Override
        public void run()
        {
            super.run();
            try
            {
                counterByte(filename);
            }
            catch (IOException e)
            {
            }
        }

        public static void counterByte(String path) throws IOException
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
            ArrayList<Integer> characterArrayList = new ArrayList<>();

            while (reader.ready())
            {
                int s = reader.read();
                if (!characterArrayList.contains(s)) characterArrayList.add(s);
            }
            reader.close();

            int countMax = 0;
            int searchByte = 0;
            for (int i = 0; i < characterArrayList.size(); i++)
            {
                int count = 0;
                BufferedReader readerInside = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
                int s = 0;
                while (readerInside.ready())
                {
                    s = readerInside.read();
                    if (characterArrayList.get(i) == s) count++;
                }
                if (count > countMax)
                {
                    countMax = count;
                    searchByte = characterArrayList.get(i);
                }
                readerInside.close();
            }
            resultMap.put(path, searchByte);
        }
    }
}
