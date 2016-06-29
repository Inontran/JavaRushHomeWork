package com.javarush.test.level08.lesson08.task04;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Удалить всех людей, родившихся летом
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» - «дата рождения».
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution
{
    public static HashMap<String, Date> createMap()
    {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone", new Date("JUNE 1 1980"));

        //напишите тут ваш код
        map.put("Jackson", new Date("JANUARY 12 1982"));
        map.put("White", new Date("JULY 13 1999"));
        map.put("Black", new Date("SEPTEMBER 14 1988"));
        map.put("Red", new Date("DECEMBER 15 1986"));
        map.put("Yellow", new Date("MAY 16 1988"));
        map.put("Pink", new Date("MARCH 17 1998"));
        map.put("Blue", new Date("JUNE 18 1975"));
        map.put("Orange", new Date("OCTOBER 19 1990"));
        map.put("Fox", new Date("NOVEMBER 11 1978"));
        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map)
    {
        //напишите тут ваш код
        Iterator<Map.Entry<String, Date>> iterator = map.entrySet().iterator();

        while (iterator.hasNext())
        {
            Map.Entry<String, Date> pair = iterator.next();
            Date date = pair.getValue();
            if ( date.getMonth() > 4 && date.getMonth() < 8 ) iterator.remove();
        }
    }
    /*
    public static void main(String[] args){
        HashMap<String, Date> hashMap = Solution.removeAllSummerPeople(Solution.createMap());
        Iterator<Map.Entry<String, Date>> iterator = hashMap.entrySet().iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    */
}
