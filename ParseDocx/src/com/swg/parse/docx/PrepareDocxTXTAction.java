/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swg.parse.docx;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.util.Exceptions;
import org.openide.util.NbBundle.Messages;

@ActionID(
        category = "PrepareDocxAndTXT",
        id = "com.swg.parse.docx.PrepareDocxTXTAction"
)
@ActionRegistration(
        iconBase = "com/swg/parse/images/cmd.png",
        displayName = "#CTL_PrepareDocxTXTAction"
)
@ActionReference(path = "Toolbars/File", position = 1300)
@Messages("CTL_PrepareDocxTXTAction=Select folder with .doc or .docx")
public final class PrepareDocxTXTAction implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        String workingDir = System.getProperty("user.dir");
        
        try {
            
            Runtime.getRuntime().exec("cmd /c start " + workingDir + "\\src\\com\\swg\\parse\\Bash\\main.bat");
            
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }
    }
}
