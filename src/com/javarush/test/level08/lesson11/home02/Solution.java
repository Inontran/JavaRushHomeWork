package com.javarush.test.level08.lesson11.home02;

import java.util.*;

/* Множество всех животных
1. Внутри класса Solution создать public static классы Cat, Dog.
2. Реализовать метод createCats, котороый должен возвращать множество с 4 котами.
3. Реализовать метод createDogs, котороый должен возвращать множество с 3 собаками.
4. Реализовать метод join, котороый должен возвращать объединенное множество всех животных - всех котов и собак.
5. Реализовать метод removeCats, котороый должен удалять из множества pets всех котов, которые есть в множестве cats.
6. Реализовать метод printPets, котороый должен выводить на экран всех животных, которые в нем есть. Каждое животное с новой строки
*/

public class Solution
{
    public static void main(String[] args)
    {
        Set<Cat> cats = createCats();
        Set<Dog> dogs = createDogs();

        Set<Object> pets = join(cats, dogs);
        printPets(pets);

        removeCats(pets, cats);
        printPets(pets);
    }

    public static Set<Cat> createCats()
    {
        HashSet<Cat> result = new HashSet<Cat>();

        //напишите тут ваш код
        result.add(new Cat());
        result.add(new Cat());
        result.add(new Cat());
        result.add(new Cat());
        return result;
    }

    public static Set<Dog> createDogs()
    {
        //напишите тут ваш код
        HashSet<Dog> set = new HashSet<Dog>(3);
        set.add(new Dog());
        set.add(new Dog());
        set.add(new Dog());
        return set;
    }

    public static Set<Object> join(Set<Cat> cats, Set<Dog> dogs)
    {
        //напишите тут ваш код
        HashSet<Object> hashSet = new HashSet<Object>();

        Iterator<Cat> catIterator = cats.iterator();
        while (catIterator.hasNext()){
            hashSet.add(catIterator.next());
        }

        Iterator<Dog> dogIterator = dogs.iterator();
        while (dogIterator.hasNext()){
            hashSet.add(dogIterator.next());
        }

        return hashSet;
    }

    public static void removeCats(Set<Object> pets, Set<Cat> cats)
    {
        //напишите тут ваш код
        HashSet<Object> clonePets = new HashSet<Object>(pets);
        Iterator<Object> petsIterator = clonePets.iterator();
        while (petsIterator.hasNext()){
            Iterator<Cat> catIterator = cats.iterator();
            String valueCat = petsIterator.next().toString();
            while (catIterator.hasNext()){
                Cat cat = catIterator.next();
                if ( valueCat.equals(cat.toString()) ) pets.remove(cat);
            }
        }
    }

    public static void printPets(Set<Object> pets)
    {
        //напишите тут ваш код
        Iterator<Object> iterator = pets.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    //напишите тут ваш код
    public static class Cat{

    }

    public static class Dog{

    }
}
