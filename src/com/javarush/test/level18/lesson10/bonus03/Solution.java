package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args)
    {
        String pathFile = "/home/ubuntuvod/IdeaProjects/JavaRushHomeWork/in.txt";
        try
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            pathFile = reader.readLine();
            reader.close();
        }
        catch (IOException e) { e.printStackTrace(); }

        args = convertorArgs(args);//этот массив аргументов создан,
        // потому что нельзя использовать аргументы из параметров метода main(),
        // так как в этих значениях могут быть пробелы, которые расцениваются как разделители между аргументами.
        // Пример: вместе такой строки ,,Шорты пляжные синие           159.00  12   ,,
        // получается такая ,,Шорты                         пляжные синие,,

        if (args[0].equals("-c"))
        {
            int maxId = 0;
            try
            {
                BufferedReader reader = new BufferedReader(new FileReader(pathFile));
                while (reader.ready())
                {
                    String stringFromFile = reader.readLine();
                    int id = getId(stringFromFile);
                    if (id > maxId) maxId = id;
                    Thread.sleep(10);
                }
                reader.close();
            }
            catch (FileNotFoundException e) {e.printStackTrace();}
            catch (IOException e) {e.printStackTrace();}
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }

            maxId++;

            try
            {
                FileOutputStream fileOutputStream = new FileOutputStream(pathFile, true);

                if (maxId != 1) fileOutputStream.write("\n".getBytes());

                String stringId = addSpaces(String.valueOf(maxId), 8);
                fileOutputStream.write(stringId.getBytes());

                String stringProductName = addSpaces(args[1], 30);
                fileOutputStream.write(stringProductName.getBytes());

                String stringPrice = addSpaces(args[2], 8);
                fileOutputStream.write(stringPrice.getBytes());

                String stringQuantity = addSpaces(args[3], 4);
                fileOutputStream.write(stringQuantity.getBytes());

                fileOutputStream.close();
            }
            catch (FileNotFoundException e) {e.printStackTrace();}
            catch (IOException e) {e.printStackTrace();}
        }

        if (args[0].equals("-u"))
        {
            long pos = findPositionById(pathFile, args[1]);
            RandomAccessFile accessFile = null;
            try
            {
                accessFile = new RandomAccessFile(pathFile, "rw");
                accessFile.seek(pos);

                String stringId = addSpaces(String.valueOf(args[1]), 8);
                accessFile.writeBytes(stringId);
//                String stringProductName = addSpaces(args[2], 30);
                String stringProductName = new String(addSpaces(args[2], 30).getBytes("UTF-8"), "ISO-8859-1");
                accessFile.writeBytes(stringProductName);
                String stringPrice = addSpaces(args[3], 8);
                accessFile.writeBytes(stringPrice);
                String stringQuantity = addSpaces(args[4], 4);
                accessFile.writeBytes(stringQuantity);
            }
            catch (FileNotFoundException e) {e.printStackTrace();}
            catch (IOException e) {}
            finally
            {
                if (accessFile != null) try {accessFile.close();}
                catch (IOException e) {e.printStackTrace();}
            }
//            System.out.println(pos);
        }


        if (args[0].equals("-d"))
        {
            long pos1 = findPositionById(pathFile, args[1]);
            RandomAccessFile accessFile = null;
            try
            {
                accessFile = new RandomAccessFile(pathFile, "rw");
                accessFile.seek(pos1);
                accessFile.readLine();//считываем строку, чтобы сдвинуть каретку ровно на одну строку
                byte[] buffer = new byte[64];
                long pos2 = accessFile.getFilePointer();//запоминаем, где сейчас каретка
                while (accessFile.readBoolean())
                {
                    accessFile.seek(pos2);
                    accessFile.read(buffer);
                    pos2 = accessFile.getFilePointer();
                    accessFile.seek(pos1);
                    accessFile.write(buffer);
                    pos1 = accessFile.getFilePointer();

                    try {Thread.sleep(10);}
                    catch (InterruptedException e) {e.printStackTrace();}
                }
            }
            catch (FileNotFoundException e) {e.printStackTrace();}
            catch (IOException e) {e.printStackTrace();}
            finally
            {
                if (accessFile != null) try {accessFile.close();}
                catch (IOException e) {e.printStackTrace();}
            }
        }
    }

    public static int getId(String stringFromFile)
    {
        char[] arrayChars = stringFromFile.toCharArray();

        char[] charsId = new char[8];
        for (int i = 0; i < 8; i++) { charsId[i] = arrayChars[i];}

        String stringId = String.valueOf(charsId);

        StringTokenizer tokenizer = new StringTokenizer(stringId, " ");
        stringId = tokenizer.nextToken();

        int id = Integer.parseInt(stringId);
        return id;
    }

    public static String addSpaces(String string, int size)
    {
        char[] primaryArray = string.toCharArray();
        if (primaryArray.length >= size) return string;
        else
        {
            char[] secondaryArray = new char[size];
            for (int i = 0; i < size; i++)
            {
                if (primaryArray.length > i){ secondaryArray[i] = primaryArray[i];}
                else secondaryArray[i] = ' ';
                try
                {
                    Thread.sleep(10);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
            return String.valueOf(secondaryArray);
        }
    }

    public static String[] convertorArgs(String[] args)
    {
        String[] newStringArray = args;
        if (args[0].equals("-c"))
        {
            newStringArray = new String[4];
            newStringArray[0] = args[0];
            newStringArray[1] = args[1];
            for (int i = 2; i < args.length; i++)
            {
                try
                {
                    Float.parseFloat(args[i]);
                    newStringArray[2] = args[i];
                    newStringArray[3] = args[i+1];
                    break;
                }
                catch (NumberFormatException e)
                {
                    newStringArray[1] += " " + args[i];
                }
                try
                {
                    Thread.sleep(10);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        }

        if (args[0].equals("-u"))
        {
            newStringArray = new String[5];
            newStringArray[0] = args[0];
            newStringArray[1] = args[1];
            newStringArray[2] = args[2];
            for (int i = 3; i < args.length; i++)
            {
                try
                {
                    Float.parseFloat(args[i]);
                    newStringArray[3] = args[i];
                    newStringArray[4] = args[i+1];
                    break;
                }
                catch (NumberFormatException e)
                {
                    newStringArray[2] += " " + args[i];
                }
                try
                {
                    Thread.sleep(10);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        }
        return newStringArray;
    }

    public static long findPositionById(String pathFile, String id)
    {
        RandomAccessFile accessFile = null;
        try
        {
            accessFile = new RandomAccessFile(pathFile, "r");
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        long pos = 0;
        long i = 0;
        try
        {
            while(accessFile.readBoolean())
            {
                accessFile.seek(i);//костыль для правильного позиционирования, иначе не читает первый символ в строках
                String stringFromFile = accessFile.readLine();
                stringFromFile = new String(stringFromFile.getBytes("ISO-8859-1"), "UTF-8");
//                System.out.println(stringFromFile + "    " + i);
                if ( getId(stringFromFile) == Integer.parseInt(id))
                {
                    pos = i;
                    break;
                }
                i = accessFile.getFilePointer();//часть костыля

                try {Thread.sleep(10);}
                catch (InterruptedException e) {e.printStackTrace();}
            }
        }
        catch (IOException e) {e.printStackTrace();}
        finally
        {
            if (accessFile != null) try {accessFile.close();}
            catch (IOException e) {e.printStackTrace();}
        }
        return pos;
    }
}