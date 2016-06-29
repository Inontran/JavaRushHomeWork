package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки. Не использовать try-with-resources

Пример вывода:
, 19
- 7
f 361
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(args[0])));
        ArrayList<Character> characterArrayList = new ArrayList<>();

        while (reader.ready())
        {
            char s = (char)reader.read();
            if (!characterArrayList.contains(s)) characterArrayList.add(s);
        }
        reader.close();
        Collections.sort(characterArrayList, new Comparator<Character>()
        {
            @Override
            public int compare(Character o1, Character o2)
            {
                return o1.toString().compareTo(o2.toString());
            }
        });

        for (int i = 0; i < characterArrayList.size(); i++)
        {
            int count = 0;
            BufferedReader readerInside = new BufferedReader(new InputStreamReader(new FileInputStream(args[0])));
            while (readerInside.ready())
            {
                char s = (char)readerInside.read();
                if (characterArrayList.get(i).equals(s)) count++;
            }
            System.out.println(characterArrayList.get(i) + " " + count);
            readerInside.close();
        }
    }
}
