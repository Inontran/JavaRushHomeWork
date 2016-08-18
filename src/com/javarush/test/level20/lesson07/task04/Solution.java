package com.javarush.test.level20.lesson07.task04;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* Serializable Solution
Сериализуйте класс Solution.
Подумайте, какие поля не нужно сериализовать, пометить ненужные поля — transient.
Объект всегда должен содержать актуальные итоговые данные.
Метод main не участвует в тестировании.
Написать код проверки самостоятельно в методе main:
1) создать файл, открыть поток на чтение (input stream) и на запись(output stream)
2) создать экземпляр класса Solution - savedObject
3) записать в поток на запись savedObject (убедитесь, что они там действительно есть)
4) создать другой экземпляр класса Solution с другим параметром
5) загрузить из потока на чтение объект - loadedObject
6) проверить, что savedObject.string равна loadedObject.string
7) обработать исключения
*/
public class Solution implements Externalizable{
    public static void main(String[] args)
    {
        try
        {
            //1) создать файл, открыть поток на чтение (input stream) и на запись(output stream)
            File your_file_name = File.createTempFile("C:\\Users\\sasha\\IdeaProjects\\JavaRushHomeWork\\out.txt", null);
            ObjectOutput oo = new ObjectOutputStream(new FileOutputStream(your_file_name));
            ObjectInput oi = new ObjectInputStream(new FileInputStream(your_file_name));

            //2) создать экземпляр класса Solution - savedObject
            Solution savedObject = new Solution(1);

            //3) записать в поток на запись savedObject (убедитесь, что они там действительно есть)
            savedObject.writeExternal(oo);

            //4) создать другой экземпляр класса Solution с другим параметром
            Solution loadedObject = new Solution(2);

            //5) загрузить из потока на чтение объект - loadedObject
            loadedObject.readExternal(oi);

            //6) проверить, что savedObject.string равна loadedObject.string
            if (savedObject.string.equals(loadedObject.string)) System.out.println("=");

            //Закрыть потоки
            oo.close();
            oi.close();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    private transient final String pattern = "dd MMMM yyyy, EEEE";
    private transient Date currentDate;
    private transient int temperature;
    String string;

    public Solution(){}

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException
    {
        String isStringPresent = string != null ? "yes" : "no";
        out.writeObject(isStringPresent);
        if (string!=null) out.writeObject(string);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException
    {
        if (in.readObject().equals("yes")) string = (String) in.readObject();
    }
}
