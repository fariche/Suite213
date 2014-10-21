package com.swg.parse.docx;

import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.commons.io.FileUtils;
import org.openide.util.Exceptions;
import org.python.google.common.io.Files;
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
 * @author mpm3
 */
public class TestAll_B {

    // mike's win7-64 path
    //private static final String path = "C:/Users/Supercode/Documents/SwgDocs/CAD_2013_ReSurvey_Dig_Reports/";

    // swgas path
    private static final String path = "H:/CurrentWork/CAD_2013_ReSurvey_Dig_Reports/";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new TestAll_B().go();
    }

    private void copyDocxToZip(File docx, File zip) {
        try {
            Files.copy(docx, zip);
            System.out.printf("Copied File (docx --> zip)\n \t%s \n\t%s\n", docx.getAbsoluteFile(), zip.getAbsoluteFile());
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }
    }

    private void parseXML(File f) throws SAXException, IOException {
        XMLReader parser = XMLReaderFactory.createXMLReader();
        XmlHandler xml = new XmlHandler();
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
    }

    private void go() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            File docx = null;
            JFileChooser jfc = new JFileChooser();
            jfc.setCurrentDirectory(new File(path));
            FileNameExtensionFilter filter = new FileNameExtensionFilter(
                    "DOC", "doc", "docx");
            jfc.setFileFilter(filter);
            int returnVal = jfc.showOpenDialog(null);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                System.out.println("You chose to open this file: "
                        + jfc.getSelectedFile().getName());
                docx = jfc.getSelectedFile();
            }

            File zip = new File(docx.getAbsolutePath().substring(0, docx.getAbsolutePath().length() - 4) + "zip");
            copyDocxToZip(docx, zip);
            UnZipIt.unZip(zip.getAbsolutePath(), path + "temp");
            parseXML(new File(path + "temp/word/document.xml"));
            FileUtils.deleteDirectory(new File(path + "temp"));
            zip.delete();
            System.out.println("\n*** Done ***");
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        } catch (SAXException ex) {
            Exceptions.printStackTrace(ex);
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
