package com.javarush.test.level21.lesson08.task03;

/* Запретить клонирование
Разрешите клонировать класс А
Запретите клонировать класс B
Разрешите клонировать класс C
Метод main не участвует в тестировании.
*/
public class Solution {
    public static class A implements Cloneable {
        @Override
        protected Object clone() throws CloneNotSupportedException {
            return new A(getI(), getJ());
        }
        private int i;
        private int j;
        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }
        public int getI() {
            return i;
        }
        public int getJ() {
            return j;
        }
    }
    public static class B extends A {
        @Override
        protected Object clone() throws CloneNotSupportedException {
            return new CloneNotSupportedException();
        }
        private String name;
        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }
        public String getName() {
            return name;
        }
    }
    public static class C extends B {
        @Override
        protected Object clone() throws CloneNotSupportedException {
            return new C(super.getI(), super.getJ(), super.getName());
        }
        public C(int i, int j, String name) {
            super(i, j, name);
        }
    }
}
