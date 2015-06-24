 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swg.parse.docx;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.util.Exceptions;
import org.openide.util.NbBundle.Messages;
import org.openide.windows.IOProvider;
import org.openide.windows.InputOutput;
import org.openide.windows.WindowManager;
import org.python.google.common.io.Files;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.apache.commons.io.FileUtils;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.xmlgraphics.java2d.TextHandler;


@ActionID(
        category = "Edit",
        id = "com.swg.parse.docx.OpenWord"
)
@ActionRegistration(
        iconBase = "com/swg/parse/images/Word.png",
        displayName = "#CTL_OpenWord"
)
@ActionReference(path = "Toolbars/File", position = 300)
@Messages("CTL_OpenWord=Select Form213")
public final class OpenWord implements ActionListener {

    public static File selectedFile, TxtFile;
    public static String pathToTxtFile;
    private static final InputOutput io = IOProvider.getDefault().getIO("XML", true);
    private static final String newline = System.getProperty("line.separator");
    private static int version = 0;
    final ImageIcon icon = new ImageIcon();

    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        io.getOut().println("Selecting a MSWord file...");
        JFileChooser fc = new JFileChooser();
        fc.setAcceptAllFileFilterUsed(false);
        fc.addChoosableFileFilter(new DocxFileFilter());        //this can be commented out
        if (selectedFile != null) {
            fc.setSelectedFile(selectedFile);
        }
        int returnVal = fc.showDialog(WindowManager.getDefault().getMainWindow(), "Parse");
         
        VersionSlector();
               
        if (returnVal == JFileChooser.APPROVE_OPTION) {
                        
            File file = fc.getSelectedFile();
            selectedFile = file;
            io.getOut().append("Opening: " + file.getName() + newline);
            
            pathToTxtFile = selectedFile.getAbsolutePath().replace(".docx", ".txt");
            TxtFile = new File(pathToTxtFile);
            
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
                POIContent = getPOI();
                NewExtract ext = new NewExtract();
                ext.extract(content, POIContent, selectedFile.getAbsolutePath(), version);

            }
            catch (FileNotFoundException ex) {
                Exceptions.printStackTrace(ex);
            } catch (IOException ex) {
                Exceptions.printStackTrace(ex);
            }
                        
        } else {
            io.getOut().append("Open command cancelled by user" + newline);
        }

        io.getOut().close();

    }
    
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

    private String getPOI() throws FileNotFoundException, IOException {
        
        FileInputStream inputTest = new FileInputStream(selectedFile.getAbsolutePath());
        XWPFDocument docxTest = new XWPFDocument(inputTest);
        XWPFWordExtractor ContentTest = new XWPFWordExtractor(docxTest);
        String contentIn = ContentTest.getText();
        return contentIn;
    }

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
