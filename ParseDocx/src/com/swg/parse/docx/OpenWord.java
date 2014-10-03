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
    private static final String newline = System.getProperty("line.separator");

    @Override
    public void actionPerformed(ActionEvent e) {

        io.getOut().println("Selecting a MSWord file...");
        JFileChooser fc = new JFileChooser();
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

    private void parseFile() {
        try {
            File f = selectedFile;
            XMLReader parser = XMLReaderFactory.createXMLReader();
            XmlHandler xml = new XmlHandler();
            parser.setContentHandler(xml);
            parser.parse(f.getAbsolutePath());
            //System.out.println(" *** STORED DATA ***");
            io.getOut().println(" *** STORED DATA ***");
            int i = 0;
            for (List<String> s : XmlHandler.dataList) {
                //System.out.printf("%d %s\n", i++, s.toString());
                io.getOut().printf("%d %s\n", i++, s.toString());
            }
            Extract ext = new Extract();
            ext.extract(XmlHandler.dataList);
            //System.out.println("\n*** PROPERTIES ***");
            ioProps = IOProvider.getDefault().getIO(selectedFile.getName(), true);
            ioProps.getOut().println("\n*** PROPERTIES ***");
            ioProps.getOut().println(ext.toString());
            ioProps.getOut().close();
            //System.out.println(ext.toString());
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        } catch (SAXException ex) {
            Exceptions.printStackTrace(ex);
        }
    }
}
