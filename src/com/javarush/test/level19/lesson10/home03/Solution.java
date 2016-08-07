package com.javarush.test.level19.lesson10.home03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException
    {
        //открываем поток на чтение файла
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));

        //заполняем список людей
        //читаем файл
        while (reader.ready()){
            String[] substringsFromFile = reader.readLine().split(" ");//создаем массив слов из строки
            //складываем все слова в одно имя, кроме послдених 3 слов. они являются датой.
            StringBuilder nameBuilder = new StringBuilder();
            for (int i = 0; i < substringsFromFile.length-3; i++){
                nameBuilder.append(substringsFromFile[i]);
                if (i < substringsFromFile.length-4) nameBuilder.append(" ");
            }
            Date date = new Date();
            int year = Integer.parseInt(substringsFromFile[substringsFromFile.length-1]) - 1900;
            int month = Integer.parseInt(substringsFromFile[substringsFromFile.length-2]) - 1;
            int day = Integer.parseInt(substringsFromFile[substringsFromFile.length-3]);
            date.setYear(year);
            date.setMonth(month);
            date.setDate(day);
            PEOPLE.add(new Person(nameBuilder.toString(), date));
        }

        //закрываем поток
        if (reader!=null) reader.close();
    }
}
