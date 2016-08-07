package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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

        //находим самое большое значение
        double max = list.get(0).getValue();
        int y = 0;//индекс самого большого значения в списке
        for (int i = 0; i < list.size(); i++){
            Person p = list.get(i);
            if (Math.abs(p.getValue()) > Math.abs(max)) {
                max = p.getValue();
                y = i;
            }
        }

        //выводим результат в консоль
        System.out.println(list.get(y).getName());

        //закрываем поток
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
