package com.swg.parse.docx;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author michaelmann
 */
public class ATest {

    private static int branch = 0;

    static XmlHandler xml;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            URL url = ATest.class.getResource("CAD_2013_RS-01.xml");
            File f = new File(url.getFile());
            XMLReader parser = XMLReaderFactory.createXMLReader();
            xml = new XmlHandler();
            parser.setContentHandler((ContentHandler) xml);
            parser.parse(f.getAbsolutePath());
            System.out.println(" *** STORED DATA ***");
            int i = 0;
            for (List<String> s : XmlHandler.dataList) {
                System.out.printf("%d %s\n", i++, s.toString());
            }
            Extract ext = new Extract();
            ext.extract(XmlHandler.dataList);
            System.out.println("\n*** PROPERTIES ***");
            System.out.println(ext.toString());
        } catch (SAXException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
