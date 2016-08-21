package com.javarush.test.level20.lesson10.bonus01;

import java.util.ArrayList;
import java.util.Arrays;

/* Алгоритмы-числа
Число S состоит из M чисел, например, S=370 и M(количество цифр)=3
Реализовать логику метода getNumbers, который должен среди натуральных чисел меньше N (long)
находить все числа, удовлетворяющие следующему критерию:
число S равно сумме его цифр, возведенных в M степень
getNumbers должен возвращать все такие числа в порядке возрастания

Пример искомого числа:
370 = 3*3*3 + 7*7*7 + 0*0*0
8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8

На выполнение дается 10 секунд и 50 МБ памяти.
*/
public class Solution {

    public static void main(String[]args)
    {
        long start = System.currentTimeMillis();
        int[] array = getNumbers(2147483647);//2147483647
        long end = System.currentTimeMillis() - start; // считаю сколько секунд длилась "программа"
        long memory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory(); // считаю сколько памяти было занято.
        System.out.println("Time = " + end);
        System.out.println("Memory = " + memory / 1048576);

        for (int a : array)
        {
            if (a != 0)
                System.out.print(a + " ");
        }
//        int i = 370;
//        if (checkNumber(i)){
//            int powFromI = pow(i);
//            System.out.println(powFromI);
//            int numberArmstrong = pow(powFromI);
//            System.out.println(numberArmstrong);
//            if (powFromI == numberArmstrong) {
//                System.out.println("NoA" + numberArmstrong);
//            }
//        }
    }



    public static int[] getNumbers(int N) {
        ArrayList<Integer> list = new ArrayList<>();
        int powFromI;
        int numberArmstrong;
        for (int i = 0; i < N; i++){
            if (checkNumber(i)){
                powFromI = pow(i);
//                if (powFromI > N*10) break;
                numberArmstrong = pow(powFromI);
                if (powFromI == numberArmstrong && !list.contains(numberArmstrong)) {
                    list.add(numberArmstrong);
                }
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++){
            result[i] = list.get(i);
        }

        Arrays.sort(result);
        return result;
    }

    public static boolean checkNumber(int num){
        char[] chars = String.valueOf(num).toCharArray();
        for (int i = 0; i < chars.length - 1; i++){
            if (chars[i+1]-48==0) continue;
            if ( chars[i]-48 > chars[i+1]-48 ) return false;
        }
        return true;
    }

    public static int pow(int num){
        int result = 0;
        char[] chars = String.valueOf(num).toCharArray();
        for (int i = 0; i < chars.length; i++){
            result += Math.pow(chars[i]-48, chars.length);
        }
//        int[] numArr = delimeter(num);
//        for (int i = 0; i < numArr.length; i++) result += Math.pow(numArr[i], numArr.length);
        return result;
    }

    public static int[] delimeter(int num){
        int[] buffer = new int[20];
        int youngNumber;
        int i = buffer.length-1;
        while (num!=0){
            youngNumber = num % 10;
            num = num/10;

            buffer[i] = youngNumber;
            i--;
        }
        return Arrays.copyOfRange(buffer, buffer.length-i, buffer.length);
    }
}
