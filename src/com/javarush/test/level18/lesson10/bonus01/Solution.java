package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.Key;

public class Solution {
    public static void main(String[] args) throws Exception{
//        FileInputStream fileInputStream = new FileInputStream(args[1]);
//        FileOutputStream fileOutputStream = new FileOutputStream(args[2]);
//        /home/ubuntuvod/IdeaProjects/JavaRushHomeWork/in.txt
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(args[1]), "UTF-8"));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(args[2]), "UTF-8"));

        RandomAccessFile accessFileReader = new RandomAccessFile(args[1], "r");
        RandomAccessFile accessFileWriter = new RandomAccessFile(args[2], "rw");

        LocalEncrypter.setUp();
        switch (args[0])
        {
            case "-e" : {
//                while (fileInputStream.available() > 0)
//                {
//                    byte buffer[] = new byte[1024];
//                    fileInputStream.read(buffer);
//                    buffer = LocalEncrypter.encrypt(buffer);
//                    fileOutputStream.write(buffer);
//
//                    try {Thread.sleep(10);}
//                    catch (InterruptedException e) {e.printStackTrace();}
//                }
//                while (bufferedReader.ready())
//                {
//                    String string = bufferedReader.readLine();
//                    System.out.println(string);
//                    byte encryptArrayByte[] = LocalEncrypter.encrypt(string);
//                    for (int i = 0; i < encryptArrayByte.length; i++)
//                    {
//                        System.out.print(encryptArrayByte[i]);
//                    }
//                    string = LocalEncrypter.decrypt(encryptArrayByte);
//                    System.out.println();
//                    System.out.println(string);
////                    fileOutputStream.write(encryptArrayByte);
//                    bufferedWriter.write(new String(encryptArrayByte, "ISO-8859-1"));
//
//                    try {Thread.sleep(10);}
//                    catch (InterruptedException e) {e.printStackTrace();}
//                }
                bufferedReader.close();
                bufferedWriter.close();

                long position = 0;
                while (accessFileReader.readBoolean())
                {
                    accessFileReader.seek(position);
                    accessFileWriter.seek(position);

                    String string = accessFileReader.readLine();
                    string = new String(string.getBytes("ISO-8859-1"), "UTF-8");
                    System.out.println(string);

                    byte encryptArrayByte[] = LocalEncrypter.encrypt(string);
                    for (int i = 0; i < encryptArrayByte.length; i++) System.out.print(encryptArrayByte[i]);
                    System.out.println();

                    string = new String(encryptArrayByte, "ISO-8859-1");
                    System.out.println(string);
                    accessFileWriter.writeBytes(string);
                    accessFileWriter.writeBytes("\n");
                    position = accessFileReader.getFilePointer();

                    try {Thread.sleep(10);}
                    catch (InterruptedException e) {e.printStackTrace();}
                }
                accessFileReader.close();
                accessFileWriter.close();
                break;
            }
            case "-d" : {
//                while (fileInputStream.available() > 0)
//                {
//                    byte buffer[] = new byte[1024];
//                    fileInputStream.read(buffer);
//                    buffer = LocalEncrypter.decrypt(buffer);
//                    fileOutputStream.write(buffer);
//                }
//                while (bufferedReader.ready())
//                {
//                    byte buffer[] = new byte[1024];
//                    fileInputStream.read(buffer);
//                    buffer = LocalEncrypter.decrypt(buffer);
//                    fileOutputStream.write(buffer);
//                }
                long position = 0;
                while (accessFileReader.readBoolean())
                {
                    accessFileReader.seek(position);
                    accessFileWriter.seek(position);

                    String string = accessFileReader.readLine();
                    string = new String(string.getBytes("ISO-8859-1"), "UTF-8");
                    System.out.println(string);

                    string = LocalEncrypter.decrypt(string.getBytes("ISO-8859-1"));
                    System.out.println(string);

                    string = new String(string.getBytes("UTF-8"), "ISO-8859-1");
                    System.out.println(string);
                    accessFileWriter.writeBytes(string);
                    accessFileWriter.writeBytes("\n");
                    position = accessFileReader.getFilePointer();

                    try {Thread.sleep(10);}
                    catch (InterruptedException e) {e.printStackTrace();}
                }
                accessFileReader.close();
                accessFileWriter.close();
                break;
            }
        }
    }

    public static class LocalEncrypter {

        private static String algorithm = "AES";
        private static Key key = null;
        private static Cipher cipher = null;

        private static void setUp() throws Exception {
            key = KeyGenerator.getInstance(algorithm).generateKey();
            cipher = Cipher.getInstance(algorithm);
        }

        private static byte[] encrypt(String input)
                throws InvalidKeyException, BadPaddingException, IllegalBlockSizeException
        {
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] inputBytes = new byte[0];
            try
            {
                inputBytes = input.getBytes("UTF-8");
            }
            catch (UnsupportedEncodingException e)
            {
                e.printStackTrace();
            }
            return cipher.doFinal(inputBytes);
        }

        private static byte[] encrypt(byte[] arrayByte)
                throws InvalidKeyException, BadPaddingException, IllegalBlockSizeException
        {
            cipher.init(Cipher.ENCRYPT_MODE, key);
            return cipher.doFinal(arrayByte);
        }



        private static String decrypt(byte[] encryptionBytes)
                throws InvalidKeyException, BadPaddingException, IllegalBlockSizeException
        {
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] recoveredBytes = cipher.doFinal(encryptionBytes);
            String recovered = new String(recoveredBytes);
            return recovered;
//            return recoveredBytes;
        }

    }
}
