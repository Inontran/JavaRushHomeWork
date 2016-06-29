package com.javarush.test.level09.lesson11.home08;

import java.util.ArrayList;

/* Список из массивов чисел
Создать список, элементами которого будут массивы чисел.
Добавить в список пять объектов–массивов длиной 5, 2, 4, 7, 0 соответственно.
Заполнить массивы любыми данными и вывести их на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList()
    {
        //напишите тут ваш код
        ArrayList<int[]> arrayList = new ArrayList<int[]>(5);
        arrayList.add(createArrays(5));
        arrayList.add(createArrays(2));
        arrayList.add(createArrays(4));
        arrayList.add(createArrays(7));
        arrayList.add(createArrays(0));
        return arrayList;
    }

    public static int[] createArrays(int n){
        int[] array = new int[n];
        for (int i = 0; i < array.length; i++){
            array[i] = i*10;
        }
        return array;
    }

    public static void printList(ArrayList<int[]> list)
    {
        for (int[] array: list )
        {
            for (int x: array)
            {
                System.out.println(x);
            }
        }
    }
}
