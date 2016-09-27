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


        StringBuilder stringBuilder = new StringBuilder();
        while (fileReader.ready()) stringBuilder.append(fileReader.readLine()).append(System.lineSeparator());

        String previous = "";
        String currentString;
        Pair newPair;
        StringTokenizer tokenizer = new StringTokenizer(stringBuilder.toString(), " " + System.lineSeparator());

        if (tokenizer.hasMoreTokens()) previous = tokenizer.nextToken();
        while (tokenizer.hasMoreTokens())
        {
            currentString = tokenizer.nextToken();
            stringBuilder = new StringBuilder(currentString);
            if (stringBuilder.reverse().toString().equals(previous))
            {
                newPair = new Pair();
                newPair.first = previous;
                newPair.second = stringBuilder.toString();
                if (!result.contains(newPair)) result.add(newPair);
            }
            previous = currentString;
        }

        for (int i = 0; i < result.size(); i++) System.out.println(result.get(i).first + " " + result.get(i).second);

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

        @Override
        public boolean equals(Object o)
        {
            if (this == o) return true;
            if (!(o instanceof Pair)) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode()
        {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }
    }

}
