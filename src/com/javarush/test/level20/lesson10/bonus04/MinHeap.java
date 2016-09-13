package com.javarush.test.level20.lesson10.bonus04;

import java.io.*;
import java.util.*;
import java.util.function.Consumer;

/**
 * Created by sasha on 08.09.2016.
 */
public class MinHeap extends AbstractList<String> implements List<String>, Cloneable, Serializable
{
    public static void main(String[] args)
    {
//        MinHeap minHeap = new MinHeap();
//        for (int i = 0; i <= 16; i++) minHeap.add(String.valueOf(i));
//
//        try
//        {
//            minHeap.remove("2");
//            System.out.println("Expected null, actual is " + minHeap.getParent("5"));
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//
//
//        for (int i = 0; i <= 16; i++) try
//        {
//            System.out.println(i + ", parent is " + minHeap.getParent(String.valueOf(i)));
//        } catch (NullPointerException e){
//            System.out.println(i + ", parent is null");
//        }
//
//
//
//        System.out.println("================");
//        ListIterator<String> iterator = minHeap.listIterator();
//        while (iterator.hasNext())
//        {
//            System.out.print(iterator.next() + "->");
//        }
//        System.out.println("--------------------------------------------------");
        try
        {
            test();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    public static void test() throws Exception{
        List<String> listTree = new MinHeap();
        System.out.println("Check isEmpty: " + listTree.isEmpty() + " Size: " + listTree.size());

        for (int i = 1; i < 16; i++) {
            listTree.add(String.valueOf(i));
        }
        System.out.println(listTree);

        System.out.println("Check isEmpty: " + listTree.isEmpty() + " Size: " + listTree.size());
        List<String> list2222 = new MinHeap();
        System.out.println("Check isEmpty: " + list2222.isEmpty() + " Size: " + list2222.size());
        list2222.add("test");
        System.out.println("Check isEmpty: " + list2222.isEmpty() + " Size: " + list2222.size());
        List<String> list1111 = new MinHeap();
        System.out.println("Check isEmpty: " + list1111.isEmpty() + " Size: " + list1111.size());

        System.out.println("\nExpected 3, actual is " + ((MinHeap) listTree).getParent("8"));
        listTree.remove("5");
        System.out.println("Expected null, actual is " + ((MinHeap) listTree).getParent("11"));
        listTree.clear();
        for (int i = 1; i < 16; i++) {
            listTree.add(String.valueOf(i));
        }

        //For additional check correct work clone method
        MinHeap list = ((MinHeap)listTree).clone();

        System.out.println("Start value with using clone: " + listTree);
        System.out.println("\n===== REMOVE Remove 2 and 9 =====");
        list.remove("2");
        list.remove("9");
        for (String s : list)
            System.out.print(s+ " ");
        System.out.println("\n===== ADD 16, 17, 18, 19, 20 =====");
        list.add("16");
        list.add("17");
        list.add("18");
        list.add("19");
        list.add("20");
        for (String s : list) System.out.print(s+ " ");
        System.out.println("\n===== REMOVE 18 and 20 =====");
        list.remove("18");
        list.remove("20");
        for (String s : list) System.out.print(s+ " ");
        System.out.println("\n===== ADD 21 and 22 =====");
        list.add("21");
        list.add("22");
        list.add("23");
        list.add("24");
        list.add("25");
        list.add("26");
        list.add("27");
        list.add("28");
        list.add("29");
        list.add("30");
        list.add("31");
        list.add("32");
        //list.add(null);
        for (String s : list) System.out.print(s+ " ");
        System.out.println("\n---------------------------------------");
        System.out.println("3 Expected 1, actual is " + list.getParent("3"));
        System.out.println("4 Expected 1, actual is " + list.getParent("4"));
        System.out.println("8 Expected 3, actual is " + list.getParent("8"));
        System.out.println("11 Expected null, actual is " + list.getParent(null));
        System.out.println("15 Expected 7, actual is " + list.getParent("15"));
        System.out.println("16 Expected 7, actual is " + list.getParent("16"));
        System.out.println("10 Expected 4, actual is " + list.getParent("10"));
        System.out.println("17 Expected 8, actual is " + list.getParent("17"));
        System.out.println("19 Expected 10, actual is " + list.getParent("19"));
        System.out.println("21 Expected 10, actual is " + list.getParent("21"));
        System.out.println("22 Expected 15, actual is " + list.getParent("22"));
        System.out.println("--->> By task and add more item:");
        System.out.println("23 Expected 15, actual is " + list.getParent("23"));
        System.out.println("24 Expected 16, actual is " + list.getParent("24"));
        System.out.println("25 Expected 16, actual is " + list.getParent("25"));
        System.out.println("26 Expected 17, actual is " + list.getParent("26"));
        System.out.println("27 Expected 17, actual is " + list.getParent("27"));
        System.out.println("28 Expected 19, actual is " + list.getParent("28"));
        System.out.println("29 Expected 19, actual is " + list.getParent("29"));
        System.out.println("30 Expected 21, actual is " + list.getParent("30"));
        System.out.println("31 Expected 21, actual is " + list.getParent("31"));
        System.out.println("32 Expected 22, actual is " + list.getParent("32"));
        System.out.println("---------------------------------------");
        System.out.println("Size array = " + list.size() + " expected = 22");
        System.out.println();

        System.out.println("=============== Clone test ==================");

        System.out.println("Object: " + list + " --> Size = " + list.size());
        MinHeap sol = list.clone();
        //list.remove("7"); //Select for test
        System.out.println("Clone object: " + sol + " --> Size = " + sol.size());
        System.out.println("Result: " + list.containsAll(sol));

        System.out.println("\nTest addAll: ");
        Solution add = new Solution();
        add.addAll(sol);
        System.out.println(add + " --> Size: " + add.size() + " = " + sol.size());

        System.out.println("=============== Iterator test ===============");
        Iterator<String> itr = list.iterator();
        while (itr.hasNext()) {
            String a = itr.next();
            System.out.print(a + " ");
        }
        System.out.println("\nExpected size 22 = " + list.size());

        System.out.println("\nIter remove");
        Iterator<String> itr2 = list.iterator();
        while (itr2.hasNext()) {
            if (itr2.next().contains("31")) {
                itr2.remove();
            }
        }
        System.out.println("For test " + list + " --> Size = " + list.size());
        System.out.println("Collect size " + list.size() + " Expected 21");

        System.out.println("\n===== SERIALIZATION and DESERIALIZATION =====");
        System.out.println("Collect before serializable " + list);
        System.out.print("Save list");
        FileOutputStream fos = new FileOutputStream("C:/Users/sasha/IdeaProjects/JavaRushHomeWork/out.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(list);
        oos.close();
        fos.close();
        System.out.println(" Serializable done");
        System.out.print("Load list");
        FileInputStream fis = new FileInputStream("C:/Users/sasha/IdeaProjects/JavaRushHomeWork/out.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        List<String> list2 = (List<String>) ois.readObject();
        ois.close();
        fis.close();
        System.out.println(" Deserializable done");
        System.out.println("Collect after deserializable " + list2);

        System.out.println("\n================ Clear test =================");
        System.out.println("Before: " + listTree);
        listTree.clear();
        System.out.println("After clear: " + listTree + (listTree.isEmpty() ? " OK" : " Badly"));

    }



    transient int size = 0;
    transient Node<String> first;
    transient Node<String> last;

    //TODO реализация дерева без корня
    public MinHeap()
    {
        add(null);
    }

    public String getParent(String value)
    {
        try
        {
            ListItr iterator = listIterator();
            Node<String> currentNode;
            while (iterator.hasNext())
            {
                iterator.next();
                currentNode = iterator.lastReturned;
                if (currentNode.item.equals(value)) return currentNode.parentTree.item;
            }
        }catch (NullPointerException e){ return null; }
        return null;
    }

    @Override
    public boolean add(String s)
    {
        linkLast(s);//добавление элемента в список
        //далее идет установка связей древовидной структуры
        //если был добавлен только второй элемент, то его связи устанавливаем по отделному алгоритму, а иначе...
        if (size == 2){
            first.rightLeaf = last;
            last.parentTree = first;
        }
        //устанавливаем связи ...
        else
        {
            ListItr iterator = listIterator(size);
            Node<String> currentNode;
            while (iterator.hasPrevious()){
                iterator.previous();
                currentNode = iterator.lastReturned;
                if (currentNode.rightLeaf != null || currentNode.leftLeaf != null)
                {
                    if (currentNode.rightLeaf != null && currentNode.leftLeaf == null)
                    {
                        currentNode.leftLeaf = last;
                        last.parentTree = currentNode;
                        break;
                    }
                    else
                    {
                        iterator.next();
                        iterator.next();
                        iterator.lastReturned.rightLeaf = last;
                        last.parentTree = iterator.lastReturned;
                        break;
                    }
                }
            }
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

    //TODO удаление по индексу???
    @Override
    public String remove(int index)
    {
        checkElementIndex(index);
        return unlink(node(index));
    }

    public boolean remove(Object o) {
        if (o == null) {
            for (Node<String> x = first; x != null; x = x.next) {
                if (x.item == null) {
                    if (x.rightLeaf != null) remove(x.rightLeaf);
                    if (x.leftLeaf != null) remove(x.leftLeaf);
                    unlink(x);
                    return true;
                }
            }
        } else {
            for (Node<String> x = first; x != null; x = x.next) {
                if (o.equals(x.item)) {
                    if (x.rightLeaf != null) remove(x.rightLeaf.item);
                    if (x.leftLeaf != null) remove(x.leftLeaf.item);
                    unlink(x);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public int indexOf(Object o)
    {
        int index = 0;
        if (o == null) {
            for (Node<String> x = first; x != null; x = x.next) {
                if (x.item == null)
                    return index;
                index++;
            }
        } else {
            for (Node<String> x = first; x != null; x = x.next) {
                if (o.equals(x.item))
                    return index;
                index++;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o)
    {
        int index = size;
        if (o == null) {
            for (Node<String> x = last; x != null; x = x.prev) {
                index--;
                if (x.item == null)
                    return index;
            }
        } else {
            for (Node<String> x = last; x != null; x = x.prev) {
                index--;
                if (o.equals(x.item))
                    return index;
            }
        }
        return -1;
    }

    @Override
    public void clear()
    {
        // Clearing all of the links between nodes is "unnecessary", but:
        // - helps a generational GC if the discarded nodes inhabit
        //   more than one generation
        // - is sure to free memory even if there is a reachable Iterator
        for (Node<String> x = first; x != null; ) {
            Node<String> next = x.next;
            x.item = null;
            x.next = null;
            x.prev = null;
            x = next;
        }
        first = last = null;
        size = 0;
        modCount++;
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c)
    {
        return super.addAll(index, c);
    }

    @Override
    public Iterator<String> iterator()
    {
        return new Itr();
    }

    @Override
    public int size()
    {
        return size;
    }

    @Override
    public ListItr listIterator()
    {
        return listIterator(0);
    }

    @Override
    public ListItr listIterator(int index)
    {
        return new ListItr(index);
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
    public MinHeap clone() throws CloneNotSupportedException
    {
        MinHeap clone = (MinHeap) super.clone();

        // Put clone into "virgin" state
        clone.first = clone.last = null;
        clone.size = 0;
        clone.modCount = 0;

        // Initialize clone with our elements
        for (Node<String> x = first; x != null; x = x.next)
            clone.add(x.item);

        return clone;
    }

    @Override
    public String get(int index)
    {
        throw new UnsupportedOperationException();
    }

    private void checkElementIndex(int index) {
        if (!isElementIndex(index))
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    private String outOfBoundsMsg(int index) {
        return "Index: "+index+", Size: "+size;
    }

    Node<String> node(int index) {
        // assert isElementIndex(index);

        if (index < (size >> 1)) {
            Node<String> x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node<String> x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }

    String unlink(Node<String> x) {
        // assert x != null;
        final String element = x.item;
        final Node<String> next = x.next;
        final Node<String> prev = x.prev;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.item = null;
        size--;
        modCount++;
        return element;
    }

    private String unlinkLast(Node<String> l) {
        // assert l == last && l != null;
        final String element = l.item;
        final Node<String> prev = l.prev;
        l.item = null;
        l.prev = null; // help GC
        last = prev;
        if (prev == null)
            first = null;
        else
            prev.next = null;
        size--;
        modCount++;
        return element;
    }

    private String unlinkFirst(Node<String> f) {
        // assert f == first && f != null;
        final String element = f.item;
        final Node<String> next = f.next;
        f.item = null;
        f.next = null; // help GC
        first = next;
        if (next == null)
            last = null;
        else
            next.prev = null;
        size--;
        modCount++;
        return element;
    }

    void linkBefore(String e, Node<String> succ) {
        // assert succ != null;
        final Node<String> pred = succ.prev;
        final Node<String> newNode = new Node<>(pred, e, succ);
        succ.prev = newNode;
        if (pred == null)
            first = newNode;
        else
            pred.next = newNode;
        size++;
        modCount++;
    }

    void linkLast(String e) {
        final Node<String> l = last;
        final Node<String> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
        modCount++;
    }

    private void linkFirst(String e) {
        final Node<String> f = first;
        final Node<String> newNode = new Node<>(null, e, f);
        first = newNode;
        if (f == null)
            last = newNode;
        else
            f.prev = newNode;
        size++;
        modCount++;
    }

    private void writeObject(java.io.ObjectOutputStream s)
            throws java.io.IOException {
        // Write out any hidden serialization magic
        s.defaultWriteObject();

        // Write out size
        s.writeInt(size);

        // Write out all elements in the proper order.
        for (Node<String> x = first; x != null; x = x.next)
            s.writeObject(x.item);
    }

    private void readObject(java.io.ObjectInputStream s)
            throws java.io.IOException, ClassNotFoundException {
        // Read in any hidden serialization magic
        s.defaultReadObject();

        // Read in size
        int size = s.readInt();

        // Read in all elements in the proper order.
        for (int i = 0; i < size; i++)
            linkLast((String) s.readObject());
    }

    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    @Override
    public String toString() {
        if (first == null)
            return "[]";

        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (Node<String> x = first; x != null; x = x.next) {
            sb.append(x.item);
            if (x.next == null)
                return sb.append(']').toString();
            sb.append(',').append(' ');
        }
        return null;
    }

    private class Itr implements Iterator<String> {
        /**
         * Index of element to be returned by subsequent call to next.
         */
        int cursor = 0;

        /**
         * Index of element returned by most recent call to next or
         * previous.  Reset to -1 if this element is deleted by a call
         * to remove.
         */
        int lastRet = -1;

        /**
         * The modCount value that the iterator believes that the backing
         * List should have.  If this expectation is violated, the iterator
         * has detected concurrent modification.
         */
        int expectedModCount = modCount;

        public boolean hasNext() {
            return cursor != size();
        }

        public String next() {
            checkForComodification();
            try {
                int i = cursor;
                checkElementIndex(i);
                String next = node(i).item;
                lastRet = i;
                cursor = i + 1;
                return next;
            } catch (IndexOutOfBoundsException e) {
                checkForComodification();
                throw new NoSuchElementException();
            }
        }

        public void remove() {
            if (lastRet < 0)
                throw new IllegalStateException();
            checkForComodification();

            try {
                MinHeap.this.remove(lastRet);
                if (lastRet < cursor)
                    cursor--;
                lastRet = -1;
                expectedModCount = modCount;
            } catch (IndexOutOfBoundsException e) {
                throw new ConcurrentModificationException();
            }
        }

        final void checkForComodification() {
            if (modCount != expectedModCount)
                throw new ConcurrentModificationException();
        }
    }

    private class ListItr extends Itr implements ListIterator<String> {
        private Node<String> lastReturned;
        private Node<String> next;
        private int nextIndex;
        private int expectedModCount = modCount;

        ListItr(int index) {
            // assert isPositionIndex(index);
            next = (index == size) ? null : node(index);
            nextIndex = index;
        }

        public boolean hasNext() {
            return nextIndex < size;
        }

        public String next() {
            checkForComodification();
            if (!hasNext())
                throw new NoSuchElementException();

            lastReturned = next;
            next = next.next;
            nextIndex++;
            return lastReturned.item;
        }

        public boolean hasPrevious() {
            return nextIndex > 0;
        }

        public String previous() {
            checkForComodification();
            if (!hasPrevious())
                throw new NoSuchElementException();

            lastReturned = next = (next == null) ? last : next.prev;
            nextIndex--;
            return lastReturned.item;
        }

        public int nextIndex() {
            return nextIndex;
        }

        public int previousIndex() {
            return nextIndex - 1;
        }

        public void remove() {
            checkForComodification();
            if (lastReturned == null)
                throw new IllegalStateException();

            Node<String> lastNext = lastReturned.next;
            unlink(lastReturned);
            if (next == lastReturned)
                next = lastNext;
            else
                nextIndex--;
            lastReturned = null;
            expectedModCount++;
        }

        public void set(String e) {
            if (lastReturned == null)
                throw new IllegalStateException();
            checkForComodification();
            lastReturned.item = e;
        }

        public void add(String e) {
            checkForComodification();
            lastReturned = null;
            if (next == null)
                linkLast(e);
            else
                linkBefore(e, next);
            nextIndex++;
            expectedModCount++;
        }

        public void forEachRemaining(Consumer<? super String> action) {
            Objects.requireNonNull(action);
            while (modCount == expectedModCount && nextIndex < size) {
                action.accept(next.item);
                lastReturned = next;
                next = next.next;
                nextIndex++;
            }
            checkForComodification();
        }
    }

    private static class Node<String> {
        String item;
        Node<String> next;
        Node<String> prev;
        Node<String> parentTree;
        Node<String> rightLeaf;
        Node<String> leftLeaf;

        Node(Node<String> prev, String element, Node<String> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
