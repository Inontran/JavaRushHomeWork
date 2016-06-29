package com.javarush.test.level08.lesson08.task01;

import java.util.HashSet;
import java.util.Set;

/* 20 слов на букву «Л»
Создать множество строк (Set<String>), занести в него 20 слов на букву «Л».
*/

public class Solution
{
    public static HashSet<String> createSet()
    {
        //напишите тут ваш код
        Set<String> set = new HashSet<String>();
        set.add("Лило");
        set.add("Лил");
        set.add("Ли");
        set.add("Лихо");
        set.add("Лолипоп");
        set.add("Ложка");
        set.add("Лобзик");
        set.add("Лобок");
        set.add("Лесби");
        set.add("Лизун");
        set.add("Лиза");
        set.add("Лох");
        set.add("Лупа");
        set.add("Лопата");
        set.add("Лен");
        set.add("Леша");
        set.add("Лошадь");
        set.add("Ленин");
        set.add("Лена");
        set.add("Лимпопо");
        return (HashSet<String>)set;
    }
}
