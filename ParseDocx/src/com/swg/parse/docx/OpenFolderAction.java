/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/***
 * This allows uses to open Folders containing .doc or .docx forms and begin Extraction
 * Instead of opening one by one single .doc or .docx forms
 */
package com.swg.parse.docx;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import org.apache.commons.io.filefilter.WildcardFileFilter;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.util.Exceptions;
import org.openide.util.NbBundle.Messages;
import org.openide.windows.WindowManager;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

/***
 * ID of the action
 * @author KXK3
 */
@ActionID(
        category = "OpenFolder",
        id = "com.swg.parse.docx.OpenFolderAction"
)
/***
 * setting of the icon of the action
 */
@ActionRegistration(
        iconBase = "com/swg/parse/images/Untitled.png",
        displayName = "#CTL_OpenFolderAction"
)
/***
 * positioning and other setting of action
 */
@ActionReference(path = "Toolbars/File", position = 1300, separatorBefore = 1250, separatorAfter = 1350)
@Messages("CTL_OpenFolderAction=Extract data from all .docx in the directory")
public final class OpenFolderAction implements ActionListener {
    
    public static File selectedFile, TxtFile;
    public static String pathToTxtFile;
    private static int version = 0;
    final ImageIcon icon = new ImageIcon();

    @Override
    public void actionPerformed(ActionEvent e) {
        
        JFileChooser fc = new JFileChooser();
        fc.setCurrentDirectory(new File("C:/"));
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        if (selectedFile != null) {
            fc.setSelectedFile(selectedFile);
        }

        int returnVal = fc.showDialog(WindowManager.getDefault().getMainWindow(), "Extract Data");
        
            JFrame jf = new JFrame("Progress Bar");
            Container Jcontent = jf.getContentPane();
            JProgressBar progressBar = new JProgressBar();
            progressBar.setValue(0);
            progressBar.setStringPainted(true);
            Jcontent.add(progressBar, BorderLayout.NORTH);
            jf.setSize(300, 60);
            jf.setVisible(true);
            
            //we needed a new thread for a functional progress bar on the JFrame
            new Thread(new Runnable() {
                public void run(){
                    
                    if (returnVal == JFileChooser.APPROVE_OPTION) {
                       
                        File file = fc.getSelectedFile();
                        selectedFile = file;

                        FileFilter fileFilter = new WildcardFileFilter("*.docx");
                        File[] files = selectedFile.listFiles(fileFilter);
                        double cnt = 0, cnt2 = 0;     //number of how many .docx is in the folder
                        for(File f:files){
                            cnt2 ++;
                        }

                        for(File f:files){
                            cnt ++;
                            pathToTxtFile = f.getAbsolutePath().replace(".docx", ".txt");
                            TxtFile = new File(pathToTxtFile);

                            //if the txt file doesn't exist, it tries to convert whatever 
                            //can be the txt into the actual txt.
                            if(!TxtFile.exists()){
                                pathToTxtFile = f.getAbsolutePath().replace(".docx", "");
                                TxtFile = new File(pathToTxtFile);
                                pathToTxtFile += ".txt";
                                TxtFile.renameTo(new File(pathToTxtFile));
                                TxtFile = new File(pathToTxtFile);
                            }

                            String content = "";
                            String POIContent = "";

                            try {
                                content = readTxtFile();
                                POIContent = getPOI(f);
                                version = DetermineVersion(content);
                                NewExtract ext = new NewExtract();
                                ext.extract(content, POIContent, f.getAbsolutePath(), version, (int)cnt);

                            }
                            catch (FileNotFoundException ex) {
                                Exceptions.printStackTrace(ex);
                            } catch (IOException ex) {
                                Exceptions.printStackTrace(ex);
                            } catch (ParseException ex) {
                                Exceptions.printStackTrace(ex);
                            }
                            
                            double tempProg = (cnt/cnt2) * 100;
                            progressBar.setValue((int)tempProg);
                            jf.setVisible(true);
                    }

                    } else {
                        //do nothing
                    }  
                }
              }).start();
        
      
        
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
    private String getPOI(File f) throws FileNotFoundException, IOException {
        
        FileInputStream inputTest = new FileInputStream(f.getAbsolutePath());
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
        
        if(!content.contains("Anomaly:  Coating Defect, Pipe Damage, Corrosion and Pitting Measurements and Location (from Grid Sketch)".toLowerCase())){
                    System.out.println("V0");
                    return 0;
                }
        else if(content.contains(("Culture Results\n" + "BTI Products, MICkit 5 Diagnostic Field Test Kit").toLowerCase())){
                    System.out.println("V1");
                    return 1;
                }
                else{
            System.out.println("V2");
            return 2;
        }
    }
    
}
