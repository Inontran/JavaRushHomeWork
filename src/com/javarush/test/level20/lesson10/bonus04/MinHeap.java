package com.javarush.test.level20.lesson10.bonus04;

import java.io.Serializable;
import java.util.*;
import java.util.function.Consumer;

/**
 * Created by sasha on 08.09.2016.
 */
public class MinHeap extends AbstractList<String> implements List<String>, Cloneable, Serializable
{
    transient int size = 0;
    transient Node<TreeNode> first;
    transient Node<TreeNode> last;


    public MinHeap()
    {
    }

    //TODO реализвать древовидную структуру (добавление элемента согласно условию задания)
    @Override
    public boolean add(String s)
    {
        linkLast(new TreeNode(s));
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

    //TODO реализовать удаление не одного элемента, а всей ветки
    public boolean remove(Object o) {
        if (o == null) {
            for (Node<TreeNode> x = first; x != null; x = x.next) {
                if (x.item == null) {
                    unlink(x);
                    return true;
                }
            }
        } else {
            for (Node<TreeNode> x = first; x != null; x = x.next) {
                if (o.equals(x.item)) {
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
            for (Node<TreeNode> x = first; x != null; x = x.next) {
                if (x.item == null)
                    return index;
                index++;
            }
        } else {
            for (Node<TreeNode> x = first; x != null; x = x.next) {
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
            for (Node<TreeNode> x = last; x != null; x = x.prev) {
                index--;
                if (x.item == null)
                    return index;
            }
        } else {
            for (Node<TreeNode> x = last; x != null; x = x.prev) {
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
        for (Node<TreeNode> x = first; x != null; ) {
            Node<TreeNode> next = x.next;
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
        return super.iterator();
    }

    @Override
    public int size()
    {
        return size;
    }

    @Override
    public ListIterator<String> listIterator()
    {
        return super.listIterator();
    }

    @Override
    public ListIterator<TreeNode> listIterator(int index)
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
//TODO реализовать клонирование
    private LinkedList<TreeNode> superClone() {
//        try {
//            return (MinHeap) super.clone();
//        } catch (CloneNotSupportedException e) {
//            throw new InternalError(e);
//        }
        return null;
    }

    public Object clone() throws CloneNotSupportedException
    {
//        MinHeap clone = superClone();
//
//        // Put clone into "virgin" state
//        clone.first = clone.last = null;
//        clone.size = 0;
//        clone.modCount = 0;
//
//        // Initialize clone with our elements
//        for (Node<TreeNode> x = first; x != null; x = x.next)
//            clone.add((String) x.item.key);
//
//        return clone;
    return null;
    }

    @Override
    public String get(int index)
    {
        throw new UnsupportedOperationException();
    }

    Node<TreeNode> node(int index) {
        // assert isElementIndex(index);

        if (index < (size >> 1)) {
            Node<TreeNode> x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node<TreeNode> x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }

    TreeNode unlink(Node<TreeNode> x) {
        // assert x != null;
        final TreeNode element = x.item;
        final Node<TreeNode> next = x.next;
        final Node<TreeNode> prev = x.prev;

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

    private TreeNode unlinkLast(Node<TreeNode> l) {
        // assert l == last && l != null;
        final TreeNode element = l.item;
        final Node<TreeNode> prev = l.prev;
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

    private TreeNode unlinkFirst(Node<TreeNode> f) {
        // assert f == first && f != null;
        final TreeNode element = f.item;
        final Node<TreeNode> next = f.next;
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

    void linkBefore(TreeNode e, Node<TreeNode> succ) {
        // assert succ != null;
        final Node<TreeNode> pred = succ.prev;
        final Node<TreeNode> newNode = new Node<>(pred, e, succ);
        succ.prev = newNode;
        if (pred == null)
            first = newNode;
        else
            pred.next = newNode;
        size++;
        modCount++;
    }

    void linkLast(TreeNode e) {
        final Node<TreeNode> l = last;
        final Node<TreeNode> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
        modCount++;
    }

    private void linkFirst(TreeNode e) {
        final Node<TreeNode> f = first;
        final Node<TreeNode> newNode = new Node<>(null, e, f);
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
        for (Node<TreeNode> x = first; x != null; x = x.next)
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
            linkLast((TreeNode) s.readObject());
    }

    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }



    private class ListItr implements ListIterator<TreeNode> {
        private Node<TreeNode> lastReturned;
        private Node<TreeNode> next;
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

        public TreeNode next() {
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

        public TreeNode previous() {
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

            Node<TreeNode> lastNext = lastReturned.next;
            unlink(lastReturned);
            if (next == lastReturned)
                next = lastNext;
            else
                nextIndex--;
            lastReturned = null;
            expectedModCount++;
        }

        public void set(TreeNode e) {
            if (lastReturned == null)
                throw new IllegalStateException();
            checkForComodification();
            lastReturned.item = e;
        }

        public void add(TreeNode e) {
            checkForComodification();
            lastReturned = null;
            if (next == null)
                linkLast(e);
            else
                linkBefore(e, next);
            nextIndex++;
            expectedModCount++;
        }

        public void forEachRemaining(Consumer<? super TreeNode> action) {
            Objects.requireNonNull(action);
            while (modCount == expectedModCount && nextIndex < size) {
                action.accept(next.item);
                lastReturned = next;
                next = next.next;
                nextIndex++;
            }
            checkForComodification();
        }

        final void checkForComodification() {
            if (modCount != expectedModCount)
                throw new ConcurrentModificationException();
        }
    }

    private static class Node<TreeNode> {
        TreeNode item;
        Node<TreeNode> next;
        Node<TreeNode> prev;

        Node(Node<TreeNode> prev, TreeNode element, Node<TreeNode> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    private class TreeNode<String>{
        private String key;
        private TreeNode<String> parent;
        private TreeNode<String> left;
        private TreeNode<String> right;

        TreeNode(String key) {
            this.key = key;
        }
    }
}
