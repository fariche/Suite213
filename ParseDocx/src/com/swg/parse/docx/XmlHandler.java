/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swg.parse.docx;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author michaelmann
 */
public class XmlHandler extends DefaultHandler {

    public static List<List<String>> dataList = new ArrayList<>();
    public Properties props = new Properties();
    private boolean textVal, isList, isChecked, isResult;
    private String data;
    private static List<String> xmlString = new ArrayList<String>();

    @Override
    public void startElement(String nsURI, String localName, String rawName, Attributes attributes) throws SAXException {
        String resultVal;
        switch (rawName) {
            case "w:result":
                resultVal = attributes.getValue("w:val").trim();
                xmlString.add("<w:wResult val=" + resultVal + ">");
                isResult = true;
                break;
            case "w:ddList":
                xmlString.add("<w:ddList>");
                isList = true;
                break;
            case "w:listEntry":
                String val = attributes.getValue("w:val").trim();
                xmlString.add("<w:listEntry val=" + val + ">");
                break;
            case "w:checkBox":
                xmlString.add("<w:checkBox>");
                break;
            case "w:checked":
                if (attributes.getValue("w:val") == null) {
                    isChecked = true;
                    xmlString.add("<w:checked>");
                }
                break;
            case "w:t":
                // dont display empty strings
                xmlString.add("<w:t>");
                textVal = true;
                break;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName) {
            case "w:ddList":
                if (isList) {
                    xmlString.add("<w:ddList/>");
                    dataList.add(xmlString);
                    xmlString = new ArrayList<String>();
                }
                break;
            case "w:checkBox":
                xmlString.add("<w:checkBox/>");
                break;
            case "w:checked":
                if (isChecked) {
                    xmlString.add("<w:checked/>");
                }
                break;
            case "w:t":
                xmlString.add("<w:t/>");
                String s = xmlString.get(1);
                if (s.length() == 1) {
                    char character = data.charAt(0); // This gives the character 'a'
                    if (character == 8194 || character == 61527 || character == 61482) {
                        xmlString.clear();
                    }
                } else if (xmlString.size() > 2) {
                    dataList.add(xmlString);
                }
                xmlString = new ArrayList<String>();
                break;
            default:
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (textVal) {
            data = new String(ch, start, length).trim();
            if (data.length() == 0) {
                textVal = false;
            } else if (data.length() == 1) {
                char character = data.charAt(0);
                //System.out.printf("\nChar: %s=%d", character, (int) character);
                if (character != 8194 || character != 61527 || character != 61482) {
                    xmlString.add(data);
                    //System.out.printf("\nCodes that did get printed: %s - %d",character, (int)character);
                }
            } else if (data.length() >= 2) {
                xmlString.add(data);
            }
            textVal = false;
        }
    }

}
