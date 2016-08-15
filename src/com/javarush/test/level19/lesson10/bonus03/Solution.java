package com.javarush.test.level19.lesson10.bonus03;

/* Знакомство с тегами
Считайте с консоли имя файла, который имеет HTML-формат
Пример:
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span><span>Super</span><span>girl</span>
Первым параметром в метод main приходит тег. Например, "span"
Вывести на консоль все теги, которые соответствуют заданному тегу
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле
Количество пробелов, \n, \r не влияют на результат
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нету
Тег может содержать вложенные теги
Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>
<span>Super</span>
<span>girl</span>

Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>

text1, text2 могут быть пустыми
*/

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        try
        {
            //Считайте с консоли имя файла, который имеет HTML-формат
            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

            // Создается построитель документа
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            // Создается дерево DOM документа из файла
            Document document = documentBuilder.parse(consoleReader.readLine());
//            Document document = documentBuilder.parse("C:\\Users\\sasha\\IdeaProjects\\JavaRushHomeWork\\out.txt");

            // Получаем корневой элемент
            Node root = document.getDocumentElement();
            //если искомый(required) тег корневой, то печатаем его на экран, иначе
            if (root.getNodeName().equals(args[0])) System.out.println(tagConstructor(root));
            else
            {
                // Просматриваем все подэлементы корневого
                NodeList tags = root.getChildNodes();
                printTags(tags, args[0]);
            }

            if (consoleReader!=null) consoleReader.close();
        }
        catch (SAXException | ParserConfigurationException | IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void printTags(NodeList tags, String requiredTag){
        // Просматриваем все подэлементы корневого
        for (int i = 0; i < tags.getLength(); i++){
            Node tag = tags.item(i);

            //сравниваем название тег с искомым
            if (tag.getNodeName().equals(requiredTag)) {
                System.out.println(tagConstructor(tag));
            }

            //если у тега есть дочерние теги, то выводим на экран и их тоже
            if (tag.hasChildNodes()) printTags(tag.getChildNodes(), requiredTag);
        }
    }

    public static String tagConstructor(Node node){
        if (node.getNodeType() == Node.TEXT_NODE) return node.getNodeValue();

        StringBuilder builderStringTag = new StringBuilder();
        builderStringTag.append("<").append(node.getNodeName());// <tag

        //получаем атрибуты и собираем их в builderStringTag
        if (node.hasAttributes() == true){
            NamedNodeMap attributes = node.getAttributes();
            builderStringTag.append(" ");// ставим пробел после тега если есть атрибуты
            for (int i = attributes.getLength() - 1; i >= 0; i--){
                Node attr = attributes.item(i);
                builderStringTag.append(attr.getNodeName()).append("=\"").append(attr.getNodeValue()).append("\"");
                //если атрибут не последний, то после него ставим пробел
                if ( i!=0 ) builderStringTag.append(" ");
            }
        }
        builderStringTag.append(">");// >

        //если у тега есть дочерние элементы, то вызываем этот же метод
        if (node.hasChildNodes()){
            String childTag = "";
            NodeList listChildTags = node.getChildNodes();
            for (int i = 0; i < listChildTags.getLength(); i++){
                childTag = tagConstructor(listChildTags.item(i));
                builderStringTag.append(childTag);
            }

        }

        builderStringTag.append("</").append(node.getNodeName()).append(">");// </span>

        return builderStringTag.toString();
    }
}
