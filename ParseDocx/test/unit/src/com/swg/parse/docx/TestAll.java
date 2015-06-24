package com.swg.parse.docx;

//import com.swg.reverse.xml.Form213CheckBoxHandler;
//import com.swg.reverse.xml.UnZipIt;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
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
public class TestAll {

    
    // mike's win7-64 path
    //private static final String path = "C:/Users/Supercode/Documents/SwgDocs/CAD_2013_ReSurvey_Dig_Reports/";

    private static final String path = "H:/CurrentWork/No_Touch/";
    private static final File docx = new File(path + "11.15.10 PPC_2010_E-01.docx");

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new TestAll().go();
    }

    /***
     * copy and transform the first file into a zip file
     * the first file needs to be a doc file
     * @param docx a .doc File
     * @param zip a .zip File
     */
    private void copyDocxToZip(File docx, File zip) {
        try {
            Files.copy(docx, zip);
            System.out.printf("Copied File (docx --> zip)\n \t ORIGINAL WORD DOC DIRECTORY PATH %s "
                    + "\n\t COPIED ZIPED FILE DIRECTORY PATH: %s\n", docx.getAbsoluteFile(), zip.getAbsoluteFile());
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }
    }

    /***
     * Parse the passed .xml file
     * All <w:t> elements of the .xml file are displayed
     * Then the interpreted information is displayed
     * @param f .xml file to be parsed
     * @throws SAXException
     * @throws IOException
     */
    private void parseXML(File f) throws SAXException, IOException {
        
        FileInputStream inputTest = new FileInputStream(path + "11.15.10 PPC_2010_E-01.docx");
        XWPFDocument docxTest = new XWPFDocument(inputTest);
        XWPFWordExtractor ContentTest = new XWPFWordExtractor(docxTest);
        
        String contentIn = ContentTest.getText();
        String[] contentTok = contentIn.split("\\s+");
        StringBuilder builder = new StringBuilder();
        for (String value : contentTok) {
            builder.append(value).append(" ");
        }
        String content = builder.toString();
        
        XMLReader parser = XMLReaderFactory.createXMLReader();
        XmlHandler xml = new XmlHandler();  //only look at document.xml
        parser.setContentHandler((ContentHandler) xml);
        parser.parse(f.getAbsolutePath());
        System.out.println(" *** STORED DATA ***");
        int i = 0;
        for (List<String> s : XmlHandler.dataList) {
            System.out.printf("%d %s\n", i++, s.toString());
        }
        
        Extract ext = new Extract();
        ext.extract(XmlHandler.dataList, content);
        System.out.println("\n*** PROPERTIES ***");
        System.out.println(ext.toString());
    }

    /***
     * launch testAll
     * zip the pre-set .doc file
     * copy it into the pre-set directory path
     * Creates an XML file with the content of the zip file (doc file)
     * interpret/parse the XML and then delete all created files/directories
     */
    private void go() {
        try {   
            File zip = new File(docx.getAbsolutePath().substring(0, docx.getAbsolutePath().length() - 4) + "zip");
            copyDocxToZip(docx, zip);
            UnZipIt.unZip(zip.getAbsolutePath(), path + "temp");
            parseXML(new File(path + "temp/word/document.xml"));
            //FileUtils.deleteDirectory(new File(path + "temp"));
            //zip.delete();
            System.out.println("\n*** Done ***");
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        } catch (SAXException ex) {
            Exceptions.printStackTrace(ex);
        }
    }

}