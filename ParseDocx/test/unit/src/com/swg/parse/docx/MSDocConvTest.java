/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swg.parse.docx;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;


/**
 *
 * @author KXK3
 */
public class MSDocConvTest {
    
    private static final String path = "H:/CurrentWork/conversion/";
    private static final String pathToFile = path + "CAD_2013_RE-01.txt";
    private static final String pathToFileDocx = path + "CAD_2013_RE-01.docx";
    private static final File ConvertedDocx = new File(pathToFile);
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        new MSDocConvTest().run();
    }
    
    void run() throws FileNotFoundException, IOException {
        
        String content = readTxtFile();
        String POIContent = getPOI();
        
        NewExtract ext = new NewExtract();
        ext.extract(content, POIContent, pathToFileDocx);
        
        
    }

    private String readTxtFile() throws FileNotFoundException {

        ArrayList<String> list = new ArrayList<>();
        BufferedReader br = null;
        try {
           br = new BufferedReader(new FileReader(ConvertedDocx));
           String availalbe;
           while((availalbe = br.readLine()) != null) {
               list.add(availalbe.toLowerCase());            
           }
        } catch (FileNotFoundException e) {
           e.printStackTrace();
        } catch (IOException e) {
           e.printStackTrace();
        } finally {
           if (br != null) {
              try {
                 br.close();
              } catch (IOException e) {
                 e.printStackTrace();
              }
           }
        }
        
        StringBuilder builder = new StringBuilder();
        for(String str : list){
            builder.append(str).append("\n");
        }
        
        return builder.toString();
    
    
    
    }

    private String getPOI() throws FileNotFoundException, IOException {
        
        FileInputStream inputTest = new FileInputStream(path + "CAD_2013_RE-01.docx");
        XWPFDocument docxTest = new XWPFDocument(inputTest);
        XWPFWordExtractor ContentTest = new XWPFWordExtractor(docxTest);
        String contentIn = ContentTest.getText();
        return contentIn;
    }
    
    
}
