/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * This testes the extraction of data from a manually entered .docx directory path
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
    
    //enter path of the folder here
    private static final String path = "H:/CurrentWork/temp3/";
    //enter the name of the .txt file here
    private static final String pathToFile = path + "C System E03 5.8.07.txt";
    //enter the name of the .docx file here
    private static final String pathToFileDocx = path + "C System E03 5.8.07.docx";
    private static final File ConvertedDocx = new File(pathToFile);
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        new MSDocConvTest().run();
    }
    
    /***
     * Launches the test
     * @throws FileNotFoundException
     * @throws IOException 
     */
    void run() throws FileNotFoundException, IOException {
        
        String content = readTxtFile();
        String POIContent = getPOI();
        
        NewExtract ext = new NewExtract();
        ext.extract(content, POIContent, pathToFileDocx, 2);
        
        
    }

    /***
     * get the content of the .txt file generated from the .docx file previously
     * @return String containing the content of the .txt file
     * @throws FileNotFoundException 
     */
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

    /***
     * @return String containing the content of the .docx file from POI apache
     * @throws FileNotFoundException
     * @throws IOException 
     */
    private String getPOI() throws FileNotFoundException, IOException {
        
        FileInputStream inputTest = new FileInputStream(path + "C System E03 5.8.07.docx");
        XWPFDocument docxTest = new XWPFDocument(inputTest);
        XWPFWordExtractor ContentTest = new XWPFWordExtractor(docxTest);
        String contentIn = ContentTest.getText();
        return contentIn;
    }
    
    
}
