package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human). Создай объекты и заполни их так, чтобы получилось:
 Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код
        Human grandfa1 = new Human("gf1", true, 70, null, null);
        Human grandfa2 = new Human("gf2", true, 75, null, null);

        Human grandma1 = new Human("gm1", false, 69, null, null);
        Human grandma2 = new Human("gm1", false, 71, null, null);

        Human father = new Human("f", true, 30, grandfa1, grandma1);
        Human mother = new Human("m", false, 28, grandfa2, grandma2);

        Human son1 = new Human("s1", true, 10, father, mother);
        Human son2 = new Human("s2", true, 10, father, mother);
        Human son3 = new Human("s3", true, 10, father, mother);

        System.out.println(grandfa1);
        System.out.println(grandma1);

        System.out.println(grandfa2);
        System.out.println(grandma2);

        System.out.println(father);
        System.out.println(mother);

        System.out.println(son1);
        System.out.println(son2);
        System.out.println(son3);
    }

    public static class Human
    {
        //напишите тут ваш код
        String name;
        boolean sex;
        int age;
        Human father;
        Human mother;

        public Human(String name, boolean sex, int age, Human father, Human mother){
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }

}
