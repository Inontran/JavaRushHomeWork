package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        //открываем поток на чтение файла
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));

        //заполняем список людей
        String stringFromFile;//строка из файла
        StringTokenizer tokenizer;//этот токенайзер делит строки из файла на 2 подстроки - на имя и занчение
        Person person;//человек
        ArrayList<Person> list = new ArrayList<>();//список людей
        //читаем файл
        while (reader.ready()){
            stringFromFile = reader.readLine();
            tokenizer = new StringTokenizer(stringFromFile, " ");
            if (tokenizer.hasMoreTokens()){
                String name = tokenizer.nextToken();
                double value = Double.parseDouble(tokenizer.nextToken());
                person = new Person(name, value);
                int i = list.indexOf(person);//получаем индекс элемента в списке. если его там нет, то получаем -1
                if (i != -1){//если список содержит такого человека, то прибавляем ему значение
                    double valuePerson = list.get(i).getValue();//получаем текущее значение
                    list.get(i).setValue(value + valuePerson);//устанавливаем новое значение
                } else list.add(person);//иначе, если не содержит такого человека, то добавляем его в список
            }
        }

        //сортируем список
        Collections.sort(list, new Comparator<Person>()
        {
            @Override
            public int compare(Person o1, Person o2)
            {
                return o1.toString().compareTo(o2.toString());
            }
        });

        //выводим результат в консоль
        for (Person p : list){
            System.out.println(p.getName() + " " + p.getValue());
        }

        if (reader!=null) reader.close();
    }

    private static class Person{
        private String name;
        private double value;

        public Person(String name, double value)
        {
            this.name = name;
            this.value = value;
        }

        public String getName()
        {
            return name;
        }

        public void setName(String name)
        {
            this.name = name;
        }

        public double getValue()
        {
            return value;
        }

        public void setValue(double value)
        {
            this.value = value;
        }


        @Override
        public boolean equals(Object o)
        {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Person person = (Person) o;

            return name.equals(person.name);
        }

        @Override
        public int hashCode()
        {
            return name.hashCode();
        }
    }
}
