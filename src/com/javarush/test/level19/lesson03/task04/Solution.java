package com.javarush.test.level19.lesson03.task04;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1950

В файле хранится большое количество людей, данные одного человека находятся в одной строке. Метод read() должен читать данные одного человека.
*/

public class Solution {
    public static class PersonScannerAdapter implements PersonScanner{

        private Scanner scanner;

        PersonScannerAdapter(Scanner scanner)
        {
            this.scanner = scanner;
        }

        @Override
        public Person read() throws IOException
        {
            String[] strings = scanner.nextLine().split(" ");
            String lastName = strings[0];
            String firstName = strings[1];
            String middleName = strings[2];
            int day = Integer.parseInt(strings[3]);
            int month = Integer.parseInt(strings[4]);
            int year = Integer.parseInt(strings[5]);
            Calendar calendar = new GregorianCalendar(year, month-1, day);
            return new Person(firstName, middleName, lastName, calendar.getTime());
        }

        @Override
        public void close() throws IOException
        {
            scanner.close();
        }
    }
}
