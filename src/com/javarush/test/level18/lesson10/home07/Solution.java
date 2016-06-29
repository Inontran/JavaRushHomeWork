package com.javarush.test.level18.lesson10.home07;

/* Поиск данных внутри файла
Считать с консоли имя файла
Найти в файле информацию, которая относится к заданному id, и вывести ее на экран в виде, в котором она записана в файле.
Программа запускается с одним параметром: id (int)
Закрыть потоки. Не использовать try-with-resources

В файле данные разделены пробелом и хранятся в следующей последовательности:
id productName price quantity

где id - int
productName - название товара, может содержать пробелы, String
price - цена, double
quantity - количество, int

Информация по каждому товару хранится в отдельной строке
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader readerConsole = new BufferedReader(new InputStreamReader(System.in));
        String path = readerConsole.readLine();
        readerConsole.close();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
        while (bufferedReader.ready())
        {
            String line = bufferedReader.readLine();
            StringTokenizer tokenizer = new StringTokenizer(line, " ");
            if (tokenizer.nextToken().equals(args[0]))
            {
                System.out.println(line);
                break;
            }
        }
        bufferedReader.close();
    }
}
