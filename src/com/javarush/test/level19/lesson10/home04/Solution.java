package com.javarush.test.level19.lesson10.home04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Ищем нужные строки
Считать с консоли имя файла.
Вывести в консоль все строки из файла, которые содержат всего 2 слова из списка words
Закрыть потоки. Не использовать try-with-resources

Пример: words содержит слова А, Б, В
Строки:
В Б А Д  //3 слова из words, не подходит
Д А Д    //1 слово из words, не подходит
Д А Б Д  //2 слова - подходит, выводим
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException
    {
        //Считать с консоли имя файла.
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(consoleReader.readLine()));

        while (fileReader.ready()){
            String stringFromFile = fileReader.readLine();
            String[] substrings = stringFromFile.split(" ");
            //если есть 0 слово, то
            if (contains(substrings, words.get(0))){
                //должно быть или 1 или 2
                if (contains(substrings, words.get(1)) ^ contains(substrings, words.get(2))) System.out.println(stringFromFile);
            }
            //иначе должно быть 1 и 2 слово в строке
            else if (contains(substrings, words.get(1)) && contains(substrings, words.get(2))) System.out.println(stringFromFile);
        }

        //Закрыть потоки.
        if (consoleReader!=null) consoleReader.close();
        if (fileReader!=null) fileReader.close();
    }

    public static boolean contains(String[] strings, String str){
        for (int i = 0; i < strings.length; i++){
            if (strings[i].equals(str)) return true;
        }
        return false;
    }
}
