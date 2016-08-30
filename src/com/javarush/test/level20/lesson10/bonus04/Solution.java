package com.javarush.test.level20.lesson10.bonus04;

import java.io.Serializable;
import java.util.*;

/* Свой список
Посмотреть, как реализован LinkedList.
Элементы следуют так: 1->2->3->4  и так 4->3->2->1
По образу и подобию создать Solution.
Элементы должны следовать так:
1->3->7->15
    ->8...
 ->4->9
    ->10
2->5->11
    ->12
 ->6->13
    ->14
Удалили 2 и 9
1->3->7->15
    ->8
 ->4->10
Добавили 16,17,18,19,20 (всегда добавляются на самый последний уровень к тем элементам, которые есть)
1->3->7->15
       ->16
    ->8->17
       ->18
 ->4->10->19
        ->20
Удалили 18 и 20
1->3->7->15
       ->16
    ->8->17
 ->4->10->19
Добавили 21 и 22 (всегда добавляются на самый последний уровень к тем элементам, которые есть.
Последний уровень состоит из 15, 16, 17, 19. 19 последний добавленный элемент, 10 - его родитель.
На данный момент 10 не содержит оба дочерних элемента, поэтому 21 добавился к 10. 22 добавляется в следующий уровень.)
1->3->7->15->22
       ->16
    ->8->17
 ->4->10->19
        ->21

Во внутренней реализации элементы должны добавляться по 2 на каждый уровень
Метод getParent должен возвращать элемент, который на него ссылается.
Например, 3 ссылается на 7 и на 8, т.е.  getParent("8")=="3", а getParent("13")=="6"
Строки могут быть любыми.
При удалении элемента должна удаляться вся ветка. Например, list.remove("5") должен удалить "5", "11", "12"
Итерироваться элементы должны в порядке добавления
Доступ по индексу запрещен, воспользуйтесь при необходимости UnsupportedOperationException
Должно быть наследование AbstractList<String>, List<String>, Cloneable, Serializable
Метод main в тестировании не участвует
*/
public class Solution extends AbstractList<String> implements List<String>, Cloneable, Serializable{
    public static void main(String[] args) {
        List<String> list = new Solution();
        for (int i = 1; i < 16; i++) {
            list.add(String.valueOf(i));
        }

//        for (int i = 1; i < list.size(); i++){
//            System.out.println(list.get(i));
//        }
        System.out.println("Expected 3, actual is " + ((Solution) list).getParent("8"));
//        list.remove("5");
//        System.out.println("Expected null, actual is " + ((Solution) list).getParent("11"));

    }

    transient int size = 0;
    transient Node<String> root;
    transient Node<String> lastLeft;
    transient Node<String> lastRight;


    public Solution(){}

    public String getParent(String value) {
        //have to be implemented
        Node<String> x = root;
        while (x != null) {
            int cmp = value.compareTo(x.key);
            if (cmp == 0) {
                return x.parent.key;
            }
            if (cmp < 0) {
                x = x.right;
            } else {
                x = x.left;
            }
        }
        return null;
    }

    @Override
    public String get(int index)
    {
        Node<String> x = root;
        while (x != null) {
            int cmp = String.valueOf(index).compareTo(x.key);
            if (cmp == 0) {
                return x.key;
            }
            if (cmp < 0) {
                x = x.right;
            } else {
                x = x.left;
            }
        }
        return null;
    }

    @Override
    public int size()
    {
        return size;
    }

    public boolean add(String k) {
        Node<String> x = root, y = null;
        while (x != null) {
            int cmp = k.compareTo(x.key);
            if (cmp == 0) {
                //если нашли такой же элемент, то возвращаем false
                return false;
            } else {
                y = x;
                if (cmp < 0) {
                    x = x.right;
                } else {
                    x = x.left;
                }
            }
        }

        Node<String> newNode = new Node<>(k);
        if (y == null) {
            root = newNode;
        } else {
            if (k.compareTo(y.key) < 0) {
                y.right = newNode;
            } else {
                y.left = newNode;
            }
        }

        size++;
        return true;
    }

    public void printTree(){
        Node<String> temp = root;
        while (temp != null){
            System.out.println(temp.key + "->");
            temp = temp.right;
        }
    }


    private class Node<String>{
        private String key;
        private Node<String> parent;
        private Node<String> left;
        private Node<String> right;

        Node(String key) {
            this.key = key;
        }
    }
}
