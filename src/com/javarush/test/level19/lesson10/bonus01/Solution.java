package com.javarush.test.level19.lesson10.bonus01;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* Отслеживаем изменения
Считать в консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME
Пример:
оригинальный   редактированный    общий
file1:         file2:             результат:(lines)

строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка4                           REMOVED строка4
строка5        строка5            SAME строка5
               строка0            ADDED строка0
строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
               строка5            ADDED строка5
строка4        строка4            SAME строка4
строка5                           REMOVED строка5
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException
    {
        //открываем потоки на чтение
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(consoleReader.readLine()));

        //записываем в списки строки для удобного сравнения
        List<String> stringList1 = new ArrayList<>();
        List<String> stringList2 = new ArrayList<>();
        while (fileReader.ready()){
            stringList1.add(fileReader.readLine());
        }
        fileReader.close();

        fileReader = new BufferedReader(new FileReader(consoleReader.readLine()));
        while (fileReader.ready()){
            stringList2.add(fileReader.readLine());
        }

        //сравниваем строки и добавляем в общий список
        addLines(stringList1, stringList2);

        //закрываем потоки на чтение
        if (consoleReader!=null) consoleReader.close();
        if (fileReader!=null) fileReader.close();
    }

    public static void addLines(List<String> stringList1, List<String> stringList2){
        int y = 0;//отвечает за смещение "каретки" во 2 списке в зависимости от найденного элемента
        for (int i = 0; i < stringList1.size(); i++){
            //добавляем последний элемент из 1 списка если 2 список подошел к концу, а первый нет
            if (i + y == stringList2.size() && i == stringList1.size() - 1){
                lines.add(new LineItem(Type.REMOVED, stringList1.get(stringList1.size()-1)));
                break;
            }
            if (stringList1.get(i).equals(stringList2.get(i + y)))
            {
                lines.add(new LineItem(Type.SAME, stringList1.get(i)));
            } else
            {
                if (stringList1.get(i).equals(stringList2.get(i + y + 1)))
                {
                    lines.add(new LineItem(Type.ADDED, stringList2.get(i + y)));
                    lines.add(new LineItem(Type.SAME, stringList1.get(i)));
                    y++;//смещаем "каретку" к концу списка
                }
                else
                {
                    lines.add(new LineItem(Type.REMOVED, stringList1.get(i)));
                    y--;////смещаем "каретку" к началу списка
                }
            }
        }
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
