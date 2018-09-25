package com.epam.pageParameters;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class PageParameters {
    String parameterXML = "";

    public String getPageParams(String param) {

        try {
            File file = new File("src/main/resources/datasorce.xml");
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(file);
            parameterXML = document.getElementsByTagName(param).item(0).getTextContent();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return parameterXML;
    }
}
