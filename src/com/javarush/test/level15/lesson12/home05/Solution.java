package com.javarush.test.level15.lesson12.home05;

/* Перегрузка конструкторов
1. В классе Solution создайте по 3 конструктора для каждого модификатора доступа.
2. В отдельном файле унаследуйте класс SubSolution от класса Solution.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так, чтобы они соответствовали конструкторам класса Solution.
*/

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

public class Solution {
    public Solution(){}
    public Solution(String s){}
    public Solution(Object o){}

    private Solution(Date d){}
    private Solution(Date d, Integer i){}
    private Solution(Date d, String s){}

    Solution(Integer i){}
    Solution(Float f){}
    Solution(Double d){}

    protected Solution(Exception e){}
    protected Solution(ArrayList<String> list){}
    protected Solution(LinkedList<String> list){}
}

