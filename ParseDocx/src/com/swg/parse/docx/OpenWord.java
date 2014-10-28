 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swg.parse.docx;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.swing.JFileChooser;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.util.Exceptions;
import org.openide.util.NbBundle.Messages;
import org.openide.windows.IOProvider;
import org.openide.windows.InputOutput;
import org.openide.windows.WindowManager;
import org.python.google.common.io.Files;
import org.apache.commons.io.FileUtils;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

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

    public static File selectedFile;
    private static final InputOutput io = IOProvider.getDefault().getIO("XML", true);
    private static InputOutput ioProps;
    private JFileChooser fc = new JFileChooser();
    private static final String newline = System.getProperty("line.separator");
    
    // mike's win7-64 path
    private static final String path = "C:/Users/Supercode/Documents/SwgDocs/CAD_2013_ReSurvey_Dig_Reports/";

    // swgas path
    //private static final String path = "H:/CurrentWork/CAD_2013_ReSurvey_Dig_Reports/";

    @Override
    public void actionPerformed(ActionEvent e) {
        io.getOut().println("Selecting a MSWord file...");
        fc.setAcceptAllFileFilterUsed(false);
        fc.addChoosableFileFilter(new DocxFileFilter());
        if (selectedFile != null) {
            fc.setSelectedFile(selectedFile);
        }
        int returnVal = fc.showDialog(WindowManager.getDefault().getMainWindow(), "Parse");
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            selectedFile = file;
            io.getOut().append("Opening: " + file.getName() + newline);
            parseFile();
        } else {
            io.getOut().append("Open command cancelled by user" + newline);
        }

        io.getOut().close();

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
        ioProps = IOProvider.getDefault().getIO(selectedFile.getName(), true);
        XMLReader parser = XMLReaderFactory.createXMLReader();
        XmlHandler xml = new XmlHandler();
        parser.setContentHandler((ContentHandler) xml);
        parser.parse(f.getAbsolutePath());
        System.out.println(" *** STORED DATA ***");
        //ioProps.getOut().println(" *** STORED DATA ***");
        int i = 0;
        for (List<String> s : XmlHandler.dataList) {
            System.out.printf("%d %s\n", i++, s.toString());
            //ioProps.getOut().printf("%d %s\n", i++, s.toString());
        }
        Extract ext = new Extract();
        ext.extract(XmlHandler.dataList);
        System.out.println("\n*** PROPERTIES ***");
        ioProps.getOut().println("\n*** PROPERTIES ***");
        System.out.println(ext.toString());
        ioProps.getOut().println(ext.toString());
        ioProps.getOut().close();
    }

    private void parseFile() {
        try {
            File docx = selectedFile;
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
        }
    }
}
