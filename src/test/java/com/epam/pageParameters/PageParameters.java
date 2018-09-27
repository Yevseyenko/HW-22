package com.epam.pageParameters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class PageParameters {
    private static final Logger log = LogManager.getLogger("log4j2");
    private String parameterXML = "";

    public String getPageParams(String param) {

        try {
            File file = new File("src/main/resources/datasorce.xml");
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(file);
            parameterXML = document.getElementsByTagName(param).item(0).getTextContent();
        } catch (Exception e) {
            log.info(e.getMessage());
        }
        return parameterXML;
    }
}
