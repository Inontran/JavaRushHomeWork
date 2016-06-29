package com.javarush.test.level08.lesson08.task05;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
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

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
    {
        //напишите тут ваш код
        HashMap<String, String> hashMap = new HashMap<String, String>(map);
        Iterator<Map.Entry<String, String>> iterator = hashMap.entrySet().iterator();

        while (iterator.hasNext()){
            Map.Entry<String, String> pair = iterator.next();
            int e = 0;
            Iterator<Map.Entry<String, String>> insideIterator = hashMap.entrySet().iterator();
            while (insideIterator.hasNext()){
                Map.Entry<String, String> insidePair = insideIterator.next();
                if ( pair.getValue().equals(insidePair.getValue()) && e < 2 ){
                    e++;
                }
                else if ( e > 1 ){
                    removeItemFromMapByValue(map, pair.getValue());
                }
            }
        }

    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair: copy.entrySet())
        {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }
}
