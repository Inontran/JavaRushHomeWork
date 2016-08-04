package com.javarush.test.level19.lesson08.task04;

/* Решаем пример
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить на консоль решенный пример
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Возможные операции: + - *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов - нет.

Пример вывода:
3 + 6 = 9
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringTokenizer;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        //запоминаем настоящий PrintStream в специальную переменную
        PrintStream consoleStream = System.out;

        //Создаем динамический массив
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        //создаем адаптер к классу PrintStream
        PrintStream stream = new PrintStream(outputStream);
        //Устанавливаем его как текущий System.out
        System.setOut(stream);

        //Вызываем функцию, которая ничего не знает о наших манипуляциях
        testString.printSomething();

        //Преобразовываем записанные в наш ByteArray данные в строку
        String result = outputStream.toString();
        //отрезаем переход на новую строку. отрезаем 2 символа, потому что переход на новую строку в windows \n\r
//        result = result.substring(0, result.length()-2);

        //выводить на консоль решенный пример
        StringTokenizer tokenizer = new StringTokenizer(result, " ");
        int c = 0;
        if(tokenizer.hasMoreTokens()){
            int a = Integer.parseInt(tokenizer.nextToken());
            String sign = tokenizer.nextToken();
            int b = Integer.parseInt(tokenizer.nextToken());

            switch (sign){
                case "+" : {
                    c = a + b;
                    break;
                }
                case "-" : {
                    c = a - b;
                    break;
                }
                case "*" : {
                    c = a * b;
                    break;
                }
            }
            result = String.valueOf(a) + " " + sign + " " + String.valueOf(b) + " = " + String.valueOf(c);
        }
//        result = result + String.valueOf(c);

        //Возвращаем все как было
        System.setOut(consoleStream);

        //Вывести модифицированную строку в консоль.
        System.out.println(result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

