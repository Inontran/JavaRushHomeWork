package com.javarush.test.level14.lesson08.bonus02;

/* НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader readerConsole = new BufferedReader(new InputStreamReader(System.in));
        Integer a = Integer.parseInt(readerConsole.readLine());
        Integer b = Integer.parseInt(readerConsole.readLine());

        while (a != 0 && b != 0) {
            if (a > b) a = a % b;
            else b = b % a;
        }
        System.out.println(a + b);
    }
}
