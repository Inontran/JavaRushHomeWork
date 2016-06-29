package com.javarush.test.level18.lesson08.task03;

import java.io.*;

/* AmigoOutputStream
1 Измените класс AmigoOutputStream так, чтобы он стал Wrapper-ом для класса FileOutputStream. Используйте наследование.
2 При вызове метода close() должны выполняться следующая последовательность действий:
2.1 вызвать метод flush()
2.2 дописать следующий текст [JavaRush © 2012-2013 All rights reserved.], используйте метод getBytes()
2.3 закрыть поток методом close()
*/

public class AmigoOutputStream extends FileOutputStream{
//    public static String fileName = "C:/tmp/result.txt";
    public static String fileName = "/home/JavaRushHomeWork/in.txt";

    private FileOutputStream fileOutputStream;

    public AmigoOutputStream(FileOutputStream fileOutputStream) throws FileNotFoundException
    {
        super(fileName);
        this.fileOutputStream = fileOutputStream;
    }

    public void close() throws IOException
    {
        fileOutputStream.flush();

        String string = "JavaRush © 2012-2013 All rights reserved.";
        FileInputStream fileInputStream = new FileInputStream(fileName);
        String beginString = "";
        if (fileInputStream.available() > 0)
        {
            byte buffer[] = new byte[fileInputStream.available()];
            fileInputStream.read(buffer);
            beginString = String.valueOf(buffer);
            System.out.println(buffer);
        }
        fileInputStream.close();
//        System.out.println(beginString);
        string += beginString;
        fileOutputStream.write(string.getBytes());
        fileOutputStream.close();
    }


    public static void main(String[] args) throws IOException
    {
        new AmigoOutputStream(new FileOutputStream(fileName)).close();
    }

}
