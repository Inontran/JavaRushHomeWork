package com.javarush.test.level15.lesson09.task01;

import java.util.HashMap;
import java.util.Map;

/* Статики 1
В статическом блоке инициализировать labels 5 различными парами.
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();

    static
    {
        labels.put(2123.123, "sdf");
        labels.put(345.35, "qwe");
        labels.put(5.7, "rty");
        labels.put(55.3, "wee");
        labels.put(334.32, "asd");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
