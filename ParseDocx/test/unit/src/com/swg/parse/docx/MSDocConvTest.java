/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swg.parse.docx;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author KXK3
 */
public class MSDocConvTest {
    
    private static final String path = "H:/CurrentWork/conversion/";
    private static final String pathToFile = path + "CAD_2013_RE-01.txt";
    private static final File ConvertedDocx = new File(pathToFile);
    
    public static void main(String[] args) throws FileNotFoundException {
        new MSDocConvTest().run();
    }
    
    void run() throws FileNotFoundException {
        
        ArrayList<String> content = readTxtFile();
        
        NewExtract ext = new NewExtract();
        ext.extract(content);
        
        
    }

    private ArrayList<String> readTxtFile() throws FileNotFoundException {

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
        return list;
    
    
    
    }
    
    
}
