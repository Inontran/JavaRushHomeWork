package com.javarush.test.level19.lesson03.task05;

import jdk.internal.util.xml.impl.Pair;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

/* Закрепляем адаптер
Адаптировать Customer и Contact к RowItem.
Классом-адаптером является DataAdapter.
Инициализируйте countries перед началом выполнения программы. Соответствие кода страны и названия:
UA Ukraine
RU Russia
CA Canada
*/

public class Solution {
    private static Map<String,String> countries = new HashMap<String,String>();
    static
    {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russian");
        countries.put("CA", "Canada");
    }

    public static class DataAdapter implements RowItem {
        private Customer customer;
        private Contact contact;

        public DataAdapter(Customer customer, Contact contact) {
            this.contact = contact;
            this.customer = customer;
        }

        @Override
        public String getCountryCode()
        {
            String contriesCode = "";
            for (Map.Entry<String, String> entry : countries.entrySet())
            {
                if (entry.getValue().equals(customer.getCountryName())) contriesCode = entry.getKey();
            }
            return contriesCode;
        }

        @Override
        public String getCompany()
        {
            return customer.getCompanyName();
        }

        @Override
        public String getContactFirstName()
        {
            StringTokenizer tokenizer = new StringTokenizer(contact.getName(), ", ");
            tokenizer.nextToken();
            return tokenizer.nextToken();
        }

        @Override
        public String getContactLastName()
        {
            StringTokenizer tokenizer = new StringTokenizer(contact.getName(), ", ");
            return tokenizer.nextToken();
        }

        @Override
        public String getDialString()
        {
            StringTokenizer tokenizer = new StringTokenizer(contact.getPhoneNumber(), "()- ");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("callto://");
            while (tokenizer.hasMoreTokens())
            {
                stringBuilder.append(tokenizer.nextToken());
            }
            return new String(stringBuilder);
        }
    }

    public static interface RowItem {
        String getCountryCode();        //example UA
        String getCompany();            //example JavaRush Ltd.
        String getContactFirstName();   //example Ivan
        String getContactLastName();    //example Ivanov
        String getDialString();         //example callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.
        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan
        String getPhoneNumber();        //example +38(050)123-45-67
    }
}