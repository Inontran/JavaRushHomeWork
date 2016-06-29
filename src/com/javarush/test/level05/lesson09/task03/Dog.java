package com.javarush.test.level05.lesson09.task03;

/* Создать класс Dog
Создать класс Dog (собака) с тремя конструкторами:
- Имя
- Имя, рост
- Имя, рост, цвет
*/

public class Dog
{
    //напишите тут ваш код
    String name, color;
    int hight;

    public Dog(String name){
        this.name = name;
    }

    public Dog (String name, int hight){
        this.name = name;
        this.hight = hight;
    }

    public Dog (String name, int hight, String color){
        this.name = name;
        this.hight = hight;
        this.color = color;
    }

}
