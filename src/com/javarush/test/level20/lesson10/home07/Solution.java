package com.javarush.test.level20.lesson10.home07;

import java.io.*;

/* Переопределение сериализации в потоке
Сериализация/десериализация Solution не работает.
Исправьте ошибки не меняя сигнатуры методов и класса.
Метод main не участвует в тестировании.
Написать код проверки самостоятельно в методе main:
1) создать экземпляр класса Solution
2) записать в него данные  - writeObject
3) сериализовать класс Solution  - writeObject(ObjectOutputStream out)
4) десериализовать, получаем новый объект
5) записать в новый объект данные - writeObject
6) проверить, что в файле есть данные из п.2 и п.5
*/
public class Solution implements Serializable, AutoCloseable {
    private transient FileOutputStream stream;
    private String fileName;

    public static void main(String[] args)
    {
        try
        {
            //1) создать файл, открыть поток на чтение (input stream) и на запись(output stream)
            File your_file_name = File.createTempFile("C:\\Users\\sasha\\IdeaProjects\\JavaRushHomeWork\\out.txt", null);
//            ObjectInputStream oi = new ObjectInputStream(new FileInputStream(your_file_name));
            ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(your_file_name));

            //2) создать экземпляр класса Solution - savedObject
            Solution savedObject = new Solution("C:\\Users\\sasha\\IdeaProjects\\JavaRushHomeWork\\out.txt");

            //3) записать в поток на запись savedObject (убедитесь, что они там действительно есть)
            savedObject.writeObject("qwe");

            //4) создать другой экземпляр класса Solution с другим параметром
            Solution loadedObject = new Solution("C:\\Users\\sasha\\IdeaProjects\\JavaRushHomeWork\\out.txt");

            //5) загрузить из потока на чтение объект - loadedObject
//            loadedObject.readObject(oi);

            //6) проверить, что savedObject.string равна loadedObject.string
            if (savedObject.equals(loadedObject)) System.out.println("=");

            //Закрыть потоки
            oo.close();
//            oi.close();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
//        catch (ClassNotFoundException e)
//        {
//            e.printStackTrace();
//        }
    }

    public Solution(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        stream = new FileOutputStream(fileName);
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.writeObject(fileName);
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        fileName = (String) in.readObject();
        stream = new FileOutputStream(fileName, true);
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }
}
