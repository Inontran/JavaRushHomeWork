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
public class Solution extends AbstractList<String> implements List<String>, Cloneable, Serializable
{
    public static void main(String[] args) {
        List<String> list = new Solution();
//        for (int i = 1; i < 16; i++) {
//            list.add(String.valueOf(i));
//        }
        list.add("");
//        for (int i = 0; i <= 6; i++) try
//        {
//            System.out.println(i + ", parent is " + ((Solution) list).getParent(String.valueOf(i)));
//        } catch (NullPointerException e){
//            System.out.println(i + ", parent is null");
//        }

//        ListIterator<String> listIter = list.listIterator();
//        while (listIter.hasNext()){
//            System.out.println(listIter.next());
//        }

        try
        {
            list.remove("2");
            System.out.println("Expected null, actual is " + ((Solution) list).getParent("5"));
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void test(){
//        List<String> listTree = new Solution();
//        System.out.println("Check isEmpty: " + listTree.isEmpty() + " Size: " + listTree.size());
//
//        for (int i = 1; i < 16; i++) {
//            listTree.add(String.valueOf(i));
//        }
//        System.out.println(listTree);
//
//        System.out.println("Check isEmpty: " + listTree.isEmpty() + " Size: " + listTree.size());
//        List<String> list2222 = new Solution();
//        System.out.println("Check isEmpty: " + list2222.isEmpty() + " Size: " + list2222.size());
//        list2222.add("test");
//        System.out.println("Check isEmpty: " + list2222.isEmpty() + " Size: " + list2222.size());
//        List<String> list1111 = new Solution();
//        System.out.println("Check isEmpty: " + list1111.isEmpty() + " Size: " + list1111.size());
//
//        System.out.println("\nExpected 3, actual is " + ((Solution) listTree).getParent("8"));
//        listTree.remove("5");
//        System.out.println("Expected null, actual is " + ((Solution) listTree).getParent("11"));
//        listTree.clear();
//        for (int i = 1; i < 16; i++) {
//            listTree.add(String.valueOf(i));
//        }
//
//        //For additional check correct work clone method
//        Solution list = ((Solution)listTree).clone();
//
//        System.out.println("Start value with using clone: " + listTree);
//        System.out.println("\n===== REMOVE Remove 2 and 9 =====");
//        list.remove("2");
//        list.remove("9");
//        for (String s : list) System.out.print(s+ " ");
//        System.out.println("\n===== ADD 16, 17, 18, 19, 20 =====");
//        list.add("16");
//        list.add("17");
//        list.add("18");
//        list.add("19");
//        list.add("20");
//        for (String s : list) System.out.print(s+ " ");
//        System.out.println("\n===== REMOVE 18 and 20 =====");
//        list.remove("18");
//        list.remove("20");
//        for (String s : list) System.out.print(s+ " ");
//        System.out.println("\n===== ADD 21 and 22 =====");
//        list.add("21");
//        list.add("22");
//        list.add("23");
//        list.add("24");
//        list.add("25");
//        list.add("26");
//        list.add("27");
//        list.add("28");
//        list.add("29");
//        list.add("30");
//        list.add("31");
//        list.add("32");
//        //list.add(null);
//        for (String s : list) System.out.print(s+ " ");
//        System.out.println("\n---------------------------------------");
//        System.out.println("3 Expected 1, actual is " + ((Solution) list).getParent("3"));
//        System.out.println("4 Expected 1, actual is " + ((Solution) list).getParent("4"));
//        System.out.println("8 Expected 3, actual is " + ((Solution) list).getParent("8"));
//        System.out.println("11 Expected null, actual is " + ((Solution) list).getParent(null));
//        System.out.println("15 Expected 7, actual is " + ((Solution) list).getParent("15"));
//        System.out.println("16 Expected 7, actual is " + ((Solution) list).getParent("16"));
//        System.out.println("10 Expected 4, actual is " + ((Solution) list).getParent("10"));
//        System.out.println("17 Expected 8, actual is " + ((Solution) list).getParent("17"));
//        System.out.println("19 Expected 10, actual is " + ((Solution) list).getParent("19"));
//        System.out.println("21 Expected 10, actual is " + ((Solution) list).getParent("21"));
//        System.out.println("22 Expected 15, actual is " + ((Solution) list).getParent("22"));
//        System.out.println("--->> By task and add more item:");
//        System.out.println("23 Expected 15, actual is " + ((Solution) list).getParent("23"));
//        System.out.println("24 Expected 16, actual is " + ((Solution) list).getParent("24"));
//        System.out.println("25 Expected 16, actual is " + ((Solution) list).getParent("25"));
//        System.out.println("26 Expected 17, actual is " + ((Solution) list).getParent("26"));
//        System.out.println("27 Expected 17, actual is " + ((Solution) list).getParent("27"));
//        System.out.println("28 Expected 19, actual is " + ((Solution) list).getParent("28"));
//        System.out.println("29 Expected 19, actual is " + ((Solution) list).getParent("29"));
//        System.out.println("30 Expected 21, actual is " + ((Solution) list).getParent("30"));
//        System.out.println("31 Expected 21, actual is " + ((Solution) list).getParent("31"));
//        System.out.println("32 Expected 22, actual is " + ((Solution) list).getParent("32"));
//        System.out.println("---------------------------------------");
//        System.out.println("Size array = " + list.size() + " expected = 22");
//        System.out.println();
//
//        System.out.println("=============== Clone test ==================");
//
//        System.out.println("Object: " + list + " --> Size = " + list.size());
//        Solution sol = list.clone();
//        //list.remove("7"); //Select for test
//        System.out.println("Clone object: " + sol + " --> Size = " + sol.size());
//        System.out.println("Result: " + list.containsAll(sol));
//
//        System.out.println("\nTest addAll: ");
//        Solution add = new Solution();
//        add.addAll(sol);
//        System.out.println(add + " --> Size: " + add.size() + " = " + sol.size());
//
//        System.out.println("=============== Iterator test ===============");
//        Iterator<String> itr = list.iterator();
//        while (itr.hasNext()) {
//            String a = itr.next();
//            System.out.print(a + " ");
//        }
//        System.out.println("\nExpected size 22 = " + list.size());
//
//        System.out.println("\nIter remove");
//        Iterator<String> itr2 = list.iterator();
//        while (itr2.hasNext()) {
//            if (itr2.next().contains("31")) {
//                itr2.remove();
//            }
//        }
//        System.out.println("For test " + list + " --> Size = " + list.size());
//        System.out.println("Collect size " + list.size() + " Expected 21");
//
//        System.out.println("\n===== SERIALIZATION and DESERIALIZATION =====");
//        System.out.println("Collect before serializable " + list);
//        System.out.print("Save list");
//        FileOutputStream fos = new FileOutputStream("file");
//        ObjectOutputStream oos = new ObjectOutputStream(fos);
//        oos.writeObject(list);
//        oos.close();
//        fos.close();
//        System.out.println(" Serializable done");
//        System.out.print("Load list");
//        FileInputStream fis = new FileInputStream("file");
//        ObjectInputStream ois = new ObjectInputStream(fis);
//        List<String> list2 = (List<String>) ois.readObject();
//        ois.close();
//        fis.close();
//        System.out.println(" Deserializable done");
//        System.out.println("Collect after deserializable " + list2);
//
//        System.out.println("\n================ Clear test =================");
//        System.out.println("Before: " + listTree);
//        listTree.clear();
//        System.out.println("After clear: " + listTree + (listTree.isEmpty() ? " OK" : " Badly"));
//
    }

    transient ArrayList<Node<String>> minHeap = new ArrayList<>();

    public Solution(){}

    public String getParent(String value) {
        //have to be implemented
        for (int i = 0; i < minHeap.size(); i++){
            if (minHeap.get(i).key.equals(value)) return minHeap.get(i).parent.key;
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
        return minHeap.size();
    }

    @Override
    public boolean add(String s)
    {
        for (int i = 0; i < 8; i++) minHeap.add(new Node<>(String.valueOf(i)));

        for (int i = 0; i < minHeap.size(); i++)
        {
            if ( 2 * i + 2 == minHeap.size()) break;
            minHeap.get(i).right = minHeap.get(2*i + 2);
            minHeap.get(2*i + 2).parent = minHeap.get(i);
            minHeap.get(i).left = minHeap.get(2*i + 1);
            minHeap.get(2*i + 1).parent = minHeap.get(i);
        }

        return true;
    }

    @Override
    public String set(int index, String element)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, String element)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public String remove(int index)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(Object value){
        for (int i = 0; i < minHeap.size(); i++){
            Node<String> node = minHeap.get(i);
            if (node.key.equals(value)){
                if (node.right != null) remove(node.right.key);
                if (node.left != null) remove(node.right.left);
                minHeap.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(Object o)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public int lastIndexOf(Object o)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear()
    {
        minHeap.clear();
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<String> iterator()
    {
        return super.iterator();
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }

    @Override
    protected void finalize() throws Throwable
    {
        super.finalize();
    }

    @Override
    public ListIterator<String> listIterator()
    {
        return new ListIter();
    }

    private class ListIter implements ListIterator<String>{
        private Node<String> lastReturned;
        private Node<String> next;
        private int countReturnedNodes;

        ListIter(){
            countReturnedNodes = 1;
            next = minHeap.get(0);
        }

        @Override
        public boolean hasNext()
        {
            return countReturnedNodes < minHeap.size();
        }

        @Override
        public String next()
        {
            if (!hasNext()) throw new NoSuchElementException();

            lastReturned = next;
            next = minHeap.get(countReturnedNodes).right;
            countReturnedNodes++;
            return lastReturned.key;
        }

        @Override
        public boolean hasPrevious()
        {
            throw new UnsupportedOperationException();
        }

        @Override
        public String previous()
        {
            throw new UnsupportedOperationException();
        }

        @Override
        public int nextIndex()
        {
            return countReturnedNodes;
        }

        @Override
        public int previousIndex()
        {
            return 0;
        }

        @Override
        public void remove()
        {

        }

        @Override
        public void set(String s)
        {

        }

        @Override
        public void add(String s)
        {

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
