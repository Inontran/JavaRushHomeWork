package com.javarush.test.level09.lesson11.home09;

import java.io.IOException;
import java.util.*;

/* Десять котов
Создать класс кот – Cat, с полем «имя» (String).
Создать словарь Map(<String, Cat>) и добавить туда 10 котов в виде «Имя»-«Кот».
Получить из Map множество(Set) всех имен и вывести его на экран.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap() throws IOException
    {
        //напишите тут ваш код
        HashMap<String, Cat> hashMap = new HashMap<>();
        for (int i = 0; i < 10; i++){
            hashMap.put(Integer.toString(i), new Cat(Integer.toString(new Random().nextInt())));
        }
        return hashMap;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map)
    {

        return new HashSet<>(map.values());
    }

    public static void printCatSet(Set<Cat> set)
    {
        for (Cat cat:set)
        {
            System.out.println(cat);
        }
    }

    public static class Cat
    {
        private String name;

        public Cat(String name)
        {
            this.name = name;
        }

        public String toString()
        {
            return "Cat "+this.name;
        }
    }


}
