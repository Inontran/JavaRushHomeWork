package com.javarush.test.level20.lesson02.task02;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush
В файле your_file_name.tmp может быть несколько объектов JavaRush
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream("C:\\Users\\sasha\\IdeaProjects\\JavaRushHomeWork\\out.txt");
            InputStream inputStream = new FileInputStream("C:\\Users\\sasha\\IdeaProjects\\JavaRushHomeWork\\out.txt");

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User user = new User();
            user.setFirstName("a");
            user.setLastName("b");
            user.setBirthDate(new Date());
            user.setMale(true);
            user.setCountry(User.Country.RUSSIA);
            javaRush.users.add(user);

            user = new User();
            user.setFirstName("a2");
            user.setLastName("b2");
            user.setBirthDate(new Date());
            user.setMale(true);
            user.setCountry(User.Country.UKRAINE);
            javaRush.users.add(user);

            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны
            for (int i = 0; i < javaRush.users.size(); i++) {
                User user1 = javaRush.users.get(i);
                System.out.println(user1.getFirstName() + " " + user1.getLastName() + " " + user1.getBirthDate().getTime() + " " + user1.isMale() + " " + user1.getCountry());
            }
            System.out.println();
            for (int i = 0; i < loadedObject.users.size(); i++) {
                User user1 = loadedObject.users.get(i);
                System.out.println(user1.getFirstName() + " " + user1.getLastName() + " " + user1.getBirthDate().getTime() + " " + user1.isMale() + " " + user1.getCountry());
            }
            if (javaRush.equals(loadedObject)) System.out.println(true);

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter writer = new PrintWriter(outputStream);

            if (writer!=null)
            {
                String isUsersPresent = users != null ? "yes" : "no";
                writer.println(isUsersPresent);

                if (users != null) {
                    for (int i = 0; i < users.size(); i++){
                        writer.print(users.get(i).getFirstName() + " ");
                        writer.print(users.get(i).getLastName() + " ");
                        writer.print(users.get(i).getBirthDate().getTime() + " ");
                        writer.print(users.get(i).isMale() + " ");
                        writer.println(users.get(i).getCountry().getDisplayedName());
                    }
                }

                writer.close();
            }
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            boolean flag = false;
            if (reader!=null){
                while (reader.ready()){
                    String stringFromFile = reader.readLine();//читаем строку из файла
                    String[] strings = stringFromFile.split(" ");
                    
                    if (flag){
                        if (strings.length == 1) break;
                        User user = new User();
                        user.setFirstName(strings[0]);
                        user.setLastName(strings[1]);
                        user.setBirthDate(new Date(Long.parseLong(strings[2])));
                        user.setMale(Boolean.parseBoolean(strings[3]));
                        user.setCountry(User.Country.valueOf(strings[4].toUpperCase()));
                        users.add(user);
                    }

                    //если найден yes, то флаг становиться true и следующие строки будут распарсины
                    if (strings[0].equals("yes")){
                        flag = true;
                    }
                }

                reader.close();
            }
        }
    }
}
