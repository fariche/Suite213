package com.swg.parse.docx;

import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.openide.util.Exceptions;
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
public class BTest {

    private static int branch = 0;

    static XmlHandler xml;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            File f = null;
            JFileChooser jfc = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter(
                    "XML", "xml");
            jfc.setFileFilter(filter);
            int returnVal = jfc.showOpenDialog(null);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                System.out.println("You chose to open this file: "
                        + jfc.getSelectedFile().getName());
                f = jfc.getSelectedFile();
            }
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
        } catch (ClassNotFoundException ex) {
            Exceptions.printStackTrace(ex);
        } catch (InstantiationException ex) {
            Exceptions.printStackTrace(ex);
        } catch (IllegalAccessException ex) {
            Exceptions.printStackTrace(ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Exceptions.printStackTrace(ex);
        }
    }

}
