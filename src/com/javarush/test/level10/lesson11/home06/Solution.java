package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
        //напишите тут ваши переменные и конструкторы
        String name;
        int age;
        Human father;
        Human mother;
        int hieght;
        float weight;

        Human(){}

        Human(String name){
            this.name = name;
        }

        Human(int age, Human father){
            this.age = age;
            this.father = father;
        }

        Human(Human f){
            this.father = f;
        }

        Human(String name, Human m){
            this.name = name;
            this.mother = m;
        }

        Human(String name, int age){
            this.name = name;
            this.age = age;
        }

        Human(String name, float weight){
            this.name = name;
            this.weight = weight;
        }

        Human(int age, float weight){
            this.age = age;
            this.weight = weight;
        }

        Human(Human f, float weight){
            this.father = f;
            this.weight = weight;
        }

        Human(String name, int age, Human father, Human mother, int hieght, float weight){
            this.name = name;
            this.father = father;
            this.mother = mother;
            this.hieght = hieght;
            this.weight = weight;
        }
    }
}
