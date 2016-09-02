package com.javarush.test.level20.lesson10.bonus04;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.List;

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
public class Solution extends AbstractList<String> implements List<String>, Cloneable, Serializable
{
    public static void main(String[] args) {
        List<String> list = new Solution();
//        for (int i = 1; i < 16; i++) {
//            list.add(String.valueOf(i));
//        }
        list.add("");
        for (int i = 0; i <= 6; i++) try
        {
            System.out.println(i + ", parent is " + ((Solution) list).getParent(String.valueOf(i)));
        } catch (NullPointerException e){
            System.out.println(i + ", parent is null");
//            e.printStackTrace();
        }
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
        while (x != null)
        {
            if (value.equals(x.key)) return x.parent.key;
            else
            {
                if (x.right != null)
                {//проверяем правого потока
                    x = x.right;
                    continue;
                } else
                {
                    if (x.left != null)
                    {//если правый потомок не подходит, то проверяем левого потомка
                        x = x.left;
                        continue;
                    } else
                    {//если потомки не подходят, проверяем левого брата это узла, поднимаясь вверх по этой ветке
                        while (x.parent.left == null)
                        {
                            x = x.parent;
                        }
                        if (x.parent.left.equals(x))
                        {//если мы уже перешли на левую ветку до этого, то мы проверяем дядей этого узла,
                            // поднимаясь вверх по ветке
                            while (x.parent.parent.left == null){
                                x = x.parent.parent.left;
                            }
                            x = x.parent.parent.left;
                        }else x = x.parent.left;
                    }
                }
            }
        }
        return null;
    }

    @Override
    public String get(int index)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size()
    {
        return size;
    }

    public boolean add(String k) {
//        Node<String> x = root, y = null;
//        while (x != null) {
//            int cmp = k.compareTo(x.key);
//            if (cmp == 0) {
//                //если нашли такой же элемент, то возвращаем false
//                return false;
//            } else {
//                y = x;
//                if (cmp < 0) {
//                    x = x.right;
//                } else {
//                    x = x.left;
//                }
//            }
//        }
//
//        Node<String> newNode = new Node<>(k);
//        if (y == null) {
//            root = newNode;
//        } else {
//            if (k.compareTo(y.key) < 0) {
//                y.right = newNode;
//            } else {
//                y.left = newNode;
//            }
//        }
//
//        size++;

        Node<String> node = new Node<>("0");
        root = node;
        root.right = new Node<>("1");
        root.right.parent = root;
        root.left = new Node<>("2");
        root.left.parent = root;

        root.right.right = new Node<>("3");
        root.right.right.parent = root.right;
        root.right.left = new Node<>("4");
        root.right.left.parent = root.right;

        root.left.right = new Node<>("5");
        root.left.right.parent = root.left;
        root.left.left = new Node<>("6");
        root.left.left.parent = root.left;

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
