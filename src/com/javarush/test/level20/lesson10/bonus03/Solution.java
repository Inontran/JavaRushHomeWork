package com.javarush.test.level20.lesson10.bonus03;

import java.util.ArrayList;
import java.util.List;

/* Кроссворд
1. Дан двумерный массив, который содержит буквы английского алфавита в нижнем регистре.
2. Метод detectAllWords должен найти все слова из words в массиве crossword.
3. Элемент(startX, startY) должен соответствовать первой букве слова, элемент(endX, endY) - последней.
text - это само слово, располагается между начальным и конечным элементами
4. Все слова есть в массиве.
5. Слова могут быть расположены горизонтально, вертикально и по диагонали как в нормальном, так и в обратном порядке.
6. Метод main не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };

//        System.out.println(crossword.length);

        long start = System.currentTimeMillis();
        List<Word> list = detectAllWords(crossword, "same", "ero", "nsd", "home", "vor", "du", "nlo", "npe");// 3 2 12 10 9 8 6 4
        long end = System.currentTimeMillis() - start; // считаю сколько секунд длилась "программа"
        long memory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory(); // считаю сколько памяти было занято.
        System.out.println("Time = " + end);
        System.out.println("Memory = " + memory / 1048576);

        for (Word w : list){
            System.out.println(w);
        }

        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        ArrayList<Word> list = new ArrayList<>();
        char[] charsWord;
        int y;
        Word objectWord;
        for (String word : words){
            charsWord = word.toCharArray();

            objectWord = new Word(word);

            searchWord: for (int i = 0; i < crossword.length; i++){
                for (int j = 0; j < crossword[i].length; j++){
                    y = 0;
                    if (charsWord[y] == (char)crossword[i][j]){
                        objectWord.setStartPoint(j, i);
                        try
                        {   //направление на 3 часа
                            if (charsWord[++y] == (char) crossword[i][j + y])
                            {
                                for (; y < charsWord.length; y++)
                                {
                                    if (charsWord[y] != crossword[i][j + y]) break;
                                    if (y == charsWord.length - 1)
                                    {
                                        objectWord.setEndPoint(j + y, i);
                                        list.add(objectWord);
                                        break searchWord;//здесь должен быть выход из циклов до самого первого
                                    }
                                }
                            }
                        } catch (ArrayIndexOutOfBoundsException e){}
                        try
                        {   //направление на 2 часа
                            y = 0;
                            if (charsWord[++y] == (char)crossword[i - y][j + y]){
                                for ( ; y < charsWord.length; y++){
                                    if (charsWord[y] != crossword[i - y][j + y]) break;
                                    if (y == charsWord.length - 1)
                                    {
                                        objectWord.setEndPoint(j + y, i - y);
                                        list.add(objectWord);
                                        break searchWord;//здесь должен быть выход из циклов до самого первого
                                    }
                                }
                            }
                            y = 0;
                        }catch (ArrayIndexOutOfBoundsException e){}
                        try
                        {   //направление на 12 часов
                             y = 0;
                            if (charsWord[++y] == (char)crossword[i - y][j]){
                                for ( ; y < charsWord.length; y++){
                                    if (charsWord[y] != crossword[i - y][j]) break;
                                    if (y == charsWord.length - 1)
                                    {
                                        objectWord.setEndPoint(j + 1, i - y);
                                        list.add(objectWord);
                                        break searchWord;//здесь должен быть выход из циклов до самого первого
                                    }
                                }
                            }
                        }catch (ArrayIndexOutOfBoundsException e){}
                        try
                        {   //направление на 10 часов
                            y = 0;
                            if (charsWord[++y] == (char)crossword[i - y][j - y]){
                                for ( ; y < charsWord.length; y++){
                                    if (charsWord[y] != crossword[i - y][j - y]) break;
                                    if (y == charsWord.length - 1)
                                    {
                                        objectWord.setEndPoint(j - y, i - y);
                                        list.add(objectWord);
                                        break searchWord;//здесь должен быть выход из циклов до самого первого
                                    }
                                }
                            }
                        }catch (ArrayIndexOutOfBoundsException e){}
                        try
                        {   //направление на 9 часов
                            y = 0;
                            if (charsWord[++y] == (char)crossword[i][j - y]){
                                for ( ; y < charsWord.length; y++){
                                    if (charsWord[y] != crossword[i][j - y]) break;
                                    if (y == charsWord.length - 1)
                                    {
                                        objectWord.setEndPoint(j - y, i);
                                        list.add(objectWord);
                                        break searchWord;//здесь должен быть выход из циклов до самого первого
                                    }
                                }
                            }
                        }catch (ArrayIndexOutOfBoundsException e){}
                        try
                        {   //направление на 8 часов
                            y = 0;
                            if (charsWord[++y] == (char)crossword[i + y][j - y]){
                                for ( ; y < charsWord.length; y++){
                                    if (charsWord[y] != crossword[i + y][j - y]) break;
                                    if (y == charsWord.length - 1)
                                    {
                                        objectWord.setEndPoint(j - y, i + y);
                                        list.add(objectWord);
                                        break searchWord;//здесь должен быть выход из циклов до самого первого
                                    }
                                }
                            }
                        }catch (ArrayIndexOutOfBoundsException e){}
                        try
                        {   //направление на 6 часов
                            y = 0;
                            if (charsWord[++y] == (char)crossword[i + y][j]){
                                for ( ; y < charsWord.length; y++){
                                    if (charsWord[y] != crossword[i + y][j]) break;
                                    if (y == charsWord.length - 1)
                                    {
                                        objectWord.setEndPoint(j, i + y);
                                        list.add(objectWord);
                                        break searchWord;//здесь должен быть выход из циклов до самого первого
                                    }
                                }
                            }
                        }catch (ArrayIndexOutOfBoundsException e){}
                        try
                        {   //направление на 4 часов
                            y = 0;
                            if (charsWord[++y] == (char)crossword[i + y][j + y]){
                                for ( ; y < charsWord.length; y++){
                                    if (charsWord[y] != crossword[i + y][j + y]) break;
                                    if (y == charsWord.length - 1)
                                    {
                                        objectWord.setEndPoint(j + y, i + y);
                                        list.add(objectWord);
                                        break searchWord;//здесь должен быть выход из циклов до самого первого
                                    }
                                }
                            }
                        }catch (ArrayIndexOutOfBoundsException e){}
                    }
                }
            }

        }


        return list;
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
