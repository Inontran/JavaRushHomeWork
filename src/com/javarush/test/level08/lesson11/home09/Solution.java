package com.javarush.test.level08.lesson11.home09;

import java.util.Date;

/* Работа с датой
1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true, если количество дней с начала года - нечетное число, иначе false
2. String date передается в формате MAY 1 2013
Не забудьте учесть первый день года.
Пример:
JANUARY 1 2000 = true
JANUARY 2 2020 = false
*/

public class Solution
{
    public static void main(String[] args)
    {
    }

    public static boolean isDateOdd(String date)
    {
        Date yearsDate = new Date();
        yearsDate.setHours(0);
        yearsDate.setMinutes(0);
        yearsDate.setSeconds(0);
        yearsDate.setMonth(0);
        yearsDate.setDate(1);

        Date currentDate = new Date(date);
        long msTimeDistance = currentDate.getTime() - yearsDate.getTime();
        long msDay = 24 * 60 * 60 * 1000;

        int countDay = (int) (msTimeDistance/msDay)+1;
        if (countDay%2==0) return false;
        return true;
    }
}
