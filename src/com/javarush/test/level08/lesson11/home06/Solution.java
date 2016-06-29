package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код
        ArrayList<Human> arrayList0 = new ArrayList<Human>(0);
        Human child1 = new Human("Саша", true, 20, arrayList0);
        Human child2 = new Human("Макс", true, 15, arrayList0);
        Human child3 = new Human("Лена", false, 3, arrayList0);
        ArrayList<Human> childrenArray = new ArrayList<Human>(3);
        childrenArray.add(child1);
        childrenArray.add(child2);
        childrenArray.add(child3);

        Human father = new Human("Юра", true, 43, childrenArray);
        ArrayList<Human> fatherArray = new ArrayList<Human>(1);
        fatherArray.add(father);

        Human mother = new Human("Ирина", false, 43, childrenArray);
        ArrayList<Human> motherArray = new ArrayList<Human>(1);
        motherArray.add(mother);

        Human grandfaOfMother = new Human("Дмитрий", true, 70, motherArray);
        Human grandmaOfMother = new Human("Галина", false, 68, motherArray);

        Human grandfaOfFather = new Human("?", true, 0, fatherArray);
        Human grandmaOfFather = new Human("?", false, 0, fatherArray);

        System.out.println(grandfaOfFather);
        System.out.println(grandmaOfFather);
        System.out.println();

        System.out.println(grandmaOfMother);
        System.out.println(grandfaOfMother);
        System.out.println();

        System.out.println(mother);
        System.out.println(father);
        System.out.println();

        System.out.println(child3);
        System.out.println(child2);
        System.out.println(child1);
    }

    public static class Human
    {
        //напишите тут ваш код
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children = new ArrayList<Human>();

        public Human(String name, boolean sex, int age, ArrayList<Human> children){
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.children = children;
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }

            return text;
        }
    }

}
