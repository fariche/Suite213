 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/***
 * This allows uses to open one by one single .doc or .docx forms and begin extraction from them
 */

package com.swg.parse.docx;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.util.Exceptions;
import org.openide.util.NbBundle.Messages;
import org.openide.windows.WindowManager;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;


@ActionID(
        category = "Edit",
        id = "com.swg.parse.docx.OpenWord"
)
@ActionRegistration(
        iconBase = "com/swg/parse/images/Word.png",
        displayName = "#CTL_OpenWord"
)
@ActionReference(path = "Toolbars/File", position = 300)
@Messages("CTL_OpenWord=Extract data from a .docx file")
public final class OpenWord implements ActionListener {

    public static File selectedFile, TxtFile;
    public static String pathToTxtFile;
    private static int version = 0;
    final ImageIcon icon = new ImageIcon();

    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        
        JFileChooser fc = new JFileChooser();
        fc.setCurrentDirectory(new File("C:/"));
        fc.setAcceptAllFileFilterUsed(false);
        //this authorize only .docx selection
        fc.addChoosableFileFilter(new DocxFileFilter());
        if (selectedFile != null) {
            fc.setSelectedFile(selectedFile);
        }
        int returnVal = fc.showDialog(WindowManager.getDefault().getMainWindow(), "Extract Data");
         
        if (returnVal == JFileChooser.APPROVE_OPTION) {
                        
            File file = fc.getSelectedFile();
            selectedFile = file;
            
            pathToTxtFile = selectedFile.getAbsolutePath().replace(".docx", ".txt");
            TxtFile = new File(pathToTxtFile);
            
            //if the txt file doesn't exist, it tries to convert whatever 
            //can be the txt into the actual txt.
            if(!TxtFile.exists()){
                pathToTxtFile = selectedFile.getAbsolutePath().replace(".docx", "");
                TxtFile = new File(pathToTxtFile);
                pathToTxtFile += ".txt";
                TxtFile.renameTo(new File(pathToTxtFile));
                TxtFile = new File(pathToTxtFile);
            }
            
            String content;
            String POIContent;
            
            try {
                content = readTxtFile();
               version = DetermineVersion(content);
                NewExtract ext = new NewExtract();
                ext.extract(content, selectedFile.getAbsolutePath(), version, 1);

            }
            catch (FileNotFoundException ex) {
                Exceptions.printStackTrace(ex);
            } catch (IOException ex) {
                Exceptions.printStackTrace(ex);
            } catch (ParseException ex) {
                Exceptions.printStackTrace(ex);
            }
                        
        } else {
            //do nothing
        }


    }
    
    /***
     * Simply grab all the content of the .txt file and put it into a string
     * @return contentOfTxtFile
     * @throws FileNotFoundException 
     */
    private String readTxtFile() throws FileNotFoundException {

        ArrayList<String> list = new ArrayList<>();
        BufferedReader br = null;
        try {
           br = new BufferedReader(new FileReader(TxtFile));
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
     * Simply grab the content of a .docx file using Apache POI and put it into a string
     * This String may have missing part due to POI library
     * @param f the .dox file
     * @return POI content of .docx
     * @throws FileNotFoundException
     * @throws IOException 
     */
    private String getPOI() throws FileNotFoundException, IOException {
        
        FileInputStream inputTest = new FileInputStream(selectedFile.getAbsolutePath());
        XWPFDocument docxTest = new XWPFDocument(inputTest);
        XWPFWordExtractor ContentTest = new XWPFWordExtractor(docxTest);
        String contentIn = ContentTest.getText();
        return contentIn;
    }
    
    /***
     * Automatically decides on what version of the form is handled using its .txt content 
     * @param content
     * @return 
     */
    private int DetermineVersion(String content) {
        
        int ver = 0;
        if(content.contains("Indicate the direction of sight on the grid sketch.".toLowerCase()) &&
                content.contains("Culture Results".toLowerCase()) &&
                content.indexOf("Indicate the direction of sight on the grid sketch.".toLowerCase()) < content.indexOf("Culture Results".toLowerCase())){
            System.out.println("V6");
            ver = 6;
        }
        else if(content.contains("Severity of DE defect found on pipe:".toLowerCase())
                && content.contains("Severity of Coating Anomaly Suspected:".toLowerCase())
                && content.contains("Severity of Coating Anomaly Found:".toLowerCase())){
            System.out.println("V4");
            ver = 4;
        }
        else if(!content.contains("DE Location ID".toLowerCase()) &&
                content.contains("Exam Number".toLowerCase()) && 
                !content.contains("WkReqNo".toLowerCase())){
            System.out.println("V5");
            ver = 5;
            
        }
        else if(!content.contains("DE Location ID".toLowerCase()) &&
                content.contains("Exam Number".toLowerCase()) ){
            System.out.println("V3");
            ver = 3;
        }
        else if(!content.contains(("Culture Results\n" + "BTI Products, MICkit 5 Diagnostic Field Test Kit").toLowerCase()) ){
            System.out.println("V2");
            ver = 2;
        }
        else if(content.contains("HCA Name".toLowerCase()) && !content.contains("Depth of Cover".toLowerCase()) &&
               content.contains("1. Severity of Coating Anomaly Suspected:".toLowerCase()) ){
            System.out.println("V7");
            ver = 7;
        }
        else if(content.contains(("Culture Results\n" + "BTI Products, MICkit 5 Diagnostic Field Test Kit").toLowerCase()) &&
                !content.contains("Depth of Cover".toLowerCase()) && 
                !content.contains("1.   Severity of Coating Anomaly Suspected")){
                    System.out.println("V1");
                    ver = 1;
                }
        else if(!content.contains("Anomaly:  Coating Defect, Pipe Damage, Corrosion and Pitting Measurements and Location (from Grid Sketch)".toLowerCase()) &&
                !content.contains("Exam Number") && 
                !content.contains("1. Severity of Coating Anomaly Suspected:") &&
                content.contains("Depth of Cover".toLowerCase()) ){
                    System.out.println("V0");
                    ver = 0;
                }
        
        return ver;
    }
    
    /***
     * Allows the user to enter the version of the document in question
     */
    private void VersionSlector() {
        
        Object[] possibilities = {0, 1, 2};


        version =  (int) JOptionPane.showInputDialog(WindowManager.getDefault().getMainWindow(),
                    "please select the version of the form",
                    "Form Version",
                    JOptionPane.PLAIN_MESSAGE,
                    icon,
                    possibilities,
                    0);
        
    }
    

}
