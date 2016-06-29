package com.javarush.test.level08.lesson08.task03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
        //напишите тут ваш код
        HashMap<String, String> hashMap = new HashMap<String, String>(10);
        hashMap.put("Брагин", "Саша");
        hashMap.put("Касперский", "Евгений");
        hashMap.put("Джобс", "Стив");
        hashMap.put("Возняк", "Стив");
        hashMap.put("Скалли", "Джон");
        hashMap.put("Брин", "Сергей");
        hashMap.put("Писька", "Мурыська");
        hashMap.put("Злобный", "Ян");
        hashMap.put("Армян", "Ян");
        hashMap.put("Бубело", "Яна");
        return hashMap;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name)
    {
        //напишите тут ваш код
        int count = 0;
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();

        while (iterator.hasNext())
        {
            Map.Entry<String, String> pair = iterator.next();
            String value = pair.getValue();        //значение
            if (name.equals(value)) count++;
        }
        return count;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String familiya)
    {
        //напишите тут ваш код
        int count = 0;
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();

        while (iterator.hasNext())
        {
            Map.Entry<String, String> pair = iterator.next();
            String key = pair.getKey();        //значение
            if (familiya.equals(key)) count++;
        }
        return count;
    }
}
