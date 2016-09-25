package com.javarush.test.level22.lesson09.task01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/* Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Порядок слов first/second не влияет на тестирование.
Использовать StringBuilder.
Пример содержимого файла
рот тор торт о
о тот тот тот
Вывод:
рот тор
о о
тот тот
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws Exception{
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(consoleReader.readLine()));

        String previous = "";
        StringBuilder nextWord;
        Pair newPair;
        StringTokenizer tokenizer = new StringTokenizer(fileReader.readLine(), " \t\r\n");
        if (tokenizer.hasMoreTokens()) previous = tokenizer.nextToken();
        while (tokenizer.hasMoreTokens())
        {
            nextWord = new StringBuilder(tokenizer.nextToken());
            if (previous.equals(nextWord.reverse()))
            {
                newPair = new Pair();
                newPair.first = previous;
                newPair.second = nextWord.toString();
                result.add(newPair);
            }
            previous = nextWord.toString();
        }

        for (int i = 0; i < result.size(); i++)
        {
            System.out.print(result.get(i) + " ");
        }


        if (consoleReader!=null) consoleReader.close();
        if (fileReader!=null) fileReader.close();
    }

    public static class Pair {
        String first;
        String second;

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
