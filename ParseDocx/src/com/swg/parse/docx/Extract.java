/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swg.parse.docx;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author michaelmann
 */
public class Extract {

    public static Properties props = new Properties();
    private static List<List<String>> extractData;
    private static Properties xmlProps = new Properties();
    private static List<String> repeats = new ArrayList();
    
    private static final List<String> LabsList = new ArrayList<>();
    private static final List<String> NextLabsList = new ArrayList<>();
    
    private static int TempIndex = 0;
    private static int TempIndexEnd =0;

    private int propCounter;
    //private int lineCounter;

    private boolean comboIndex;
    private boolean checked;
    private int gpsYcounter;
    private int multiNameCounter;

    private Map<String, Integer> usedNames = new HashMap<String, Integer>();

    private int startLine, endLine;

    private DecimalFormat df = new DecimalFormat("0000");

    public Extract() {
        try {
            xmlProps.load(Extract.class.getResourceAsStream("xmlMap.properties"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    /***
     * This method is like a set method for extractData member
     * It extract the important data from the passed List of string
     * The passed argument is coming from a parsed .xml file
     * 
     * @param data List of string in a parsed .xml file
     */
    public void extract(List<List<String>> data, String content) {
        extractData = data;
        
        //--------------------------------------------------------------------------
        
        //------------------------------------------------
        FindValue("This form is used", "DE Location ID", content);
        label("#   Section 1                                                 #");
        FindValue("DE Location ID", "HCA Name", content);
        FindValue("HCA Name", "Examination Number", content);
        FindValue("Examination Number", "Work Request No.", content);
        FindValue("Work Request No.", "Division", content);
        lookForCombo("Division");
        FindValue("District Number", "Town or County", content);
        FindValue("Town or County", "State", content);
        lookForCombo("State");
        FindValue("Tile Number", "Address and/or Location", content);
        FindValue("Address and/or Location", "Inspection Company", content);
        FindValue("Inspection Company", "Date GPS Synchronized", content);
        FindValue("Date GPS Synchronized", "Field Location (from Top of Pipe)", content);
        FindValue("Start: GPS X", "Y", content);
        FindValue("Y", "End: GPS X", content);
        FindValue("End: GPS X", "Y", content);
        FindValue("Y", "GPS File Name", content);
        FindValue("GPS File Name", "Region", content);
        lookForCombo("Region");
        FindValue("Planned Examination Length", "Actual Examination Length", content);
        FindValue("Actual Examination Length", "Foreign Pipe in Excavation", content);
        label("#   Section 2                                                 #");
        lookForCheck("Foreign Pipe in Excavation", "Size");
        FindValue("Size", "Material", content);
        FindValue("Material", "Foreign Current", content);
        lookForCheck("Foreign Current", "Bond Present");
        lookForCheck("Bond Present", "If Current Flow");
        //-----------------------------------------------------Checkpoint --> works
        lookForCheck("If Current Flow, To:", "CP Present");  //If Current Flow --> works
        lookForCheck("From:", "CP Present");
        //From ...
        lookForCheck("CP Present", "Anode Present");
        lookForCheck("Anode Present", "Environmental Conditions:");
        
        FindValue("% consumed", "Environmental Conditions:", content);
        FindValue("Temp", "Time 24-hr", content);
        FindValue("Time 24-hr", "Weather Conditions", content);
        FindValue("Weather Conditions", "Soil Conditions:", content);
        lookForCheck("Soil Conditions:", "Bedding/Shading Type");    //Soil Conditions: ---> checkbox
        FindValue("Bedding/Shading Type", "Rockshield Used", content);
        lookForCheck("Rockshield Used", "Soil Type:");
        lookForCheck("Soil Type:", "Depth of Cover");
        FindValue("Other", "Depth of Cover", content);
        FindValue("Depth of Cover", "Pipe Data (as found in EMRS):", content);
        FindValue("Nominal Size", "InDiam", content );
        FindValue("InDiam", "Wthick", content);
        FindValue("Wthick", "Grade", content);
        FindValue("Grade", "Yield", content);
        FindValue("Yield", "WkReqNo", content);
        FindValue("WkReqNo", "Installation Month", content);
        FindValue("Installation Month", "Installation Year", content);
        FindValue("Installation Year", "OpsSysName", content);
        FindValue("OpsSysName", "Weld Seam:", content);
        
        lookForCheck("Weld Seam:", "Coating Types:");
        FindValue("Other", "Coating Types:", content);
        lookForCheck("Coating Types:", "Coating Condition:");
        //-------------------------ERROR
        //FindValue("Other", "Coating Condition:", content);
        //-------------------------ERROR
        //lookForCheck("Coating Condition:", "Holiday Detection Volt Setting");
        //--------------------------
        
        FindValue("Holiday Detection Volt Setting", "Type of Coating", content);
        lookForCheck("Ground Cover Found:", "on-C");    //Ground Cover Found: ---> checkbox
        FindValue("Non-Corrosive Disbondment", "Concrete", content); //problem ...
        FindValue("Blistering Due to Corrosion", "pH of Fluid in Blisters", content); //problem
        FindValue("pH of Fluid in Blisters", "I have reviewed the procedures performed and have found them:", content);
        //-------------------ERROR
        //lookForCheck("I have reviewed the procedures performed and have found them:", "*If Inadequate, send comments and copy of WMS-WR to Engineering and Project Support Staff, LVA-581");//Fix this
        //-------------------
        FindValue("Inspected By", "Inspection Date", content);
        FindValue("Inspection Date", "Print or type name", content);
        FindValue("Reviewed By", "Date Reviewed", content);
        FindValue("Date Reviewed", "Print or type name", content);
        label("#   Section 3                                                 #");
        
        FindValue("Soil pH at Pipe Depth", "(using Antimony half cell)", content);
        FindValue("Soil Resistivity at Pipe Depth", "cm", content);
        //Soil Chemistry Performed ---> checkbox
        //Method used - ---> checkbox
        FindValue("Chlorides", "ppm", content);
        FindValue("Nitrates", "ppm", content);
        FindValue("Sulfates", "ppm", content);
        FindValue("6 O’clock", "Bacterial Samples Taken", content);
        //Bacterial Samples Taken
        //If yes, see Section 6	Asphalt and/or Tar Wrap samples taken ---> checkbox
        //section 4 ---> label ---------------------------------------------
        //Defects: ---> single checkbox
        //!!!!!!!!!! Table section 4 !!!!!!!!!!!!
        //section 5 ---> label ----------------------------------------------
        FindValue("Comments:", "Ultrasonic Thickness Readings", content);
        //!!!!!!!!! Table "Ultrasonic Thickness Readings" !!!!!!!!!!!!
        FindValue("Comments:", "Culture Results", content);
        //section 6 ---> label ---------------------------------------------
        FindValue("Location of samples", "Collected by", content);
        FindValue("Collected by", "Date collected", content);
        FindValue("Date collected", "7th day Interpreted by", content);
        FindValue("7th day Interpreted by", "Date of reading", content);
        FindValue("Date of reading", "14th day Interpreted by", content);
        FindValue("14th day Interpreted by", "Date of reading", content);
        FindValue("Date of reading", "Cap Color", content);
        //!!!!!!!!!! Table section 6 !!!!!!!!!!!!!! 
        //section 7 ---> label ---------------------------------------------
        //Severity of Coating Anomaly Suspected ---> checkbox
        //Severity of Coating Anomaly Found ---> checkbox
        //Severity of DE Defect Found on Pipe ---> checkbox
        //Severity of the coating anomaly found was more / less severe than originally prioritized? ---> checkbox
        //Is this the initial assessment of this covered segment? ---> checkbox
        //If both 3a & 4b, then should the criteria in the Severity Classification Table be adjusted? ---> checkbox
        //Was corrosion found? ---> checkbox
        //Was this a B or C priority in which the corrosion found was deeper than 20% of the original wall thickness? ---> checkbox
        //Was this corrosion deeper or more severe than corrosion found on any A-priority examination in this same region? ---> checkbox
        //Was the Severity Classification Table assessed for adjustments? ---> checkbox
        //Were changes made to the Severity Classification Table? ---> checkbox
        FindValue("If Yes, document on MOC. If No, explain why not.", "11. Are additional indirect inspection surveys needed on this segment?", content );
        //Are additional indirect inspection surveys needed on this segment? ---> checkbox
        //Is the corrosion considered significant?  ---> checkbox
        //!!!!!!!!!!!!! Table - Check the most likely root cause !!!!!!!!!!!!!!!
        FindValue("Explanation for Other:", "Office Work:", content);
        //Was the review conducted? ---> checkbox
        //Do alternative methods need to be implemented? ---> checkbox
        //For this HCA, has corrosion been found and a root cause determined at other locations? ---> checkbox
        //For this HCA, are similar occurrences of the root cause being determined at other locations? ---> checkbox
        FindValue("Date calculation completed:", "|_| N/A", content);
        //checkbox ...
        //section 8 ---> lable -------------------------------------------------
        FindValue("Inspector’s Comments:", "Remediation Action Required?", content);
        //section 9 ---> label -------------------------------------------------
        //Remediation Action Required?  ---> checkbox
        FindValue("Reference Work Request No.", "Check one: Repair was:", content);
        //Repair was: ---> checkbox
        FindValue("Remediation Comments:", "ANOMALY SKETCH", content);
        //section 10 ---> label ------------------------------------------------
        //need titles ?
        //section 11 ---> label ------------------------------------------------
        
        
        //----------------------------------------------------------------------------
        
//        label("#   Section 1                                                 #");
//        lookForUntil("DE Location ID", "HCA");
//        lookForUntil("Name", "xamination");
//        lookForUntil("Number", "Work Request No.");
//        lookForUntil("Work Request No.", "Division");
//        lookForCombo("Division");
//        lookForUntil("District Number", "Town or County");
//        lookForUntil("Town or County", "State");
//        lookForCombo("State");
//        lookForUntil("ile Number", "Address and/or Location");
//        lookForUntil("Address and/or Location", "nspection Company");
//        lookForUntil("nspection Company", "Date");
//        lookForUntil("Synchronized", "Field Location (from Top of Pipe)");
//        lookForGps("Start: GPS X", "GPS File Name");
//        lookForUntil("GPS File Name", "Region");
//        lookForCombo("Region");
//        lookForUntil("Planned Examination Length", "Actual Examination Length");
//        lookForUntil("Actual Examination Length", "Section 2");
//
//        label("#   Section 2                                                 #");
//        lookForCheck("oreign Pipe in Excavation", "Size");
//        lookForUntil("Size", "Material");
//        lookForUntil("Material", "Foreign Current");
//        lookForCheck("Foreign Current", "ond Present");
//        lookForCheck("ond Present", "If");
//        lookForCheck("To:", "CP Present");
//        lookForCheck("CP Present", "Anode Present");
//        lookForCheck("Anode Present", "nvironmental Conditions:");
//        lookForUntil("Temp", "Time");
//        lookForUntil("Time", "Weather Conditions");
//        lookForUntil("Weather Conditions", "oil Conditions:");
//        lookForCheck("oil Conditions:", "Bedding/Shading Type");
//        lookForUntil("Bedding/Shading Type", "Rockshield Used");
//        lookForCheck("Rockshield Used", "Soil Type:");
//        lookForCheck("Soil Type:", "Depth of Cover");
//        lookForUntil("Depth of Cover", "Pipe Data (as found in EMRS):");
//        lookForUntil("Size", "InDiam");
//        lookForUntil("InDiam", "Wthick");
//        lookForUntil("Wthick", "Grade");
//        lookForUntil("Grade", "Yield");
//        lookForUntil("Yield", "WkReqNo");
//        lookForUntil("WkReqNo", "Installation Month");
//        lookForUntil("Installation Month", "Installation Year");
//        lookForUntil("Installation Year", "OpsSysName");
//        lookForUntil("OpsSysName", "Weld Seam:");
//        lookForCheck("Weld Seam:", "Coating Types:");
//        lookForCheck("Coating Types:", "Coating Condition:");
//        lookForCheck("Coating Condition:", "Holiday Detection Volt Setting");
//        lookForUntil("Holiday Detection Volt Setting", "Type of Coating Damage");
//        lookForCheck("Ground Cover Found:", "on-C"); // Fix this
//        lookForUntil("listers", "I have reviewed the procedures performed and have found them:");
//        lookForCheck("I have reviewed the procedures performed and have found them:", "*If Inadequate, send comments and copy of WMS-WR to Engineering and Project Support Staff, LVA-581");//Fix this
//        lookForUntil("Inspected By", "Inspection Date");
//        lookForUntil("Inspection Date", "Print"); //Fix this
//        lookForUntil("Reviewed By", "Date Reviewed");
//        lookForUntil("Date Reviewed", "Print");
//
//        label("#   Section 3                                                 #");
//        lookForUntil("Soil pH at Pipe Depth", "(using Antimony half cell)");
//        lookForUntil("Soil Resistivity at Pipe Depth", "cm");
//        lookForCheck("Soil Chemistry Performed", "Method used -");
//        lookForUntil("Chlorides", "ppm");
//        lookForUntil("Nitrates", "ppm");
//        lookForUntil("Sulfates", "ppm");
//        lookForUntil("O’clock", "Bacterial Samples Taken");
//        lookForCheck("Bacterial Samples Taken", "If yes, see Section 6");
//        lookForCheck("Asphalt and/or Tar Wrap samples taken", "Section 4");
//        lookForCheck("Defects:", "All external");//Fix this
//        //lookForCombo("Coating)");//Fix this
//
//        // Add more
//        lookForUntil("Distance from Zero Point (feet)", "O’clock Position");
//        lookForUntil("O’clock Position", "Length (Axial) (inch)");
//        lookForUntil("Length (Axial) (inch)", "Length (Circumferential) (inch)");
//        lookForUntil("Length (Circumferential) (inch)", "Maximum Depth (inch)");
//        lookForUntil("Maximum Depth (inch)", "Repair Category");
//
//        label("#   Section 4                                                 #");
//        // Fix below
//        
//         lookFor("Number");
//         lookForNext("Num 1");
//         lookForNext("Num 2");
//         lookForNext("Num 3");
//         lookForNext("Num 4");
//         lookForNext("Num 5");
//         
//        lookForCombo("Coating)");
//        lookForNextCombo("Type of Defect 2");
//        lookForNextCombo("Type of Defect 3");
//        lookForNextCombo("Type of Defect 4");
//        lookForNextCombo("Type of Defect 5");
//        lookForCombo("Repair Category");
//        lookForNextCombo("Repair Category 2");
//        lookForNextCombo("Repair Category 3");
//        lookForNextCombo("Repair Category 4");
//        lookForNextCombo("Repair Category 5");
//        lookForCombo("Corrosion Interactivity");
//        lookForNextCombo("Corrosion Interactivity 2");
//        lookForNextCombo("Corrosion Interactivity 3");
//        lookForNextCombo("Corrosion Interactivity 4");
//        lookForNextCombo("Corrosion Interactivity 5");
//
//        // Section 5
//        label("#   Section 5                                                 #");
//        // Add more info here
//        readTableInfo("Distance from Zero Point", "ICDA Scrub #1: Min"); //300-319
//        //        lookForUntil("ICDA Scrub #1: Min", "Max");
//        //        lookForUntil("Max", "WT ∆%");
//        //        lookForUntil("ICDA Scrub #2: Min", "Max");
//        //        lookForUntil("Max", "WT ∆%");
//        lookForUntil("ICDA Scrub #1: Min", "ICDA Scrub #2: Min");
//        lookForUntil("ICDA Scrub #2: Min", "Comments:");
//        lookForUntil("Comments:", "Section");
//        lookForUntil("amples", "Collected b");
//        lookForUntil("Collected b", "Date c");
//        lookForUntil("ollected", "th");
//        lookForUntil("Interpreted by", "Date of reading");
//        lookForUntil("Date of reading", "14");
//        lookForUntil("14", "Date of reading");
//        lookForUntil("Date of reading", "Cap Color");
//
//        label("#   Section 6                                                 #");
//        // need new code for tables
//        label("#   Section 7                                                 #");
//        lookForCheck("ty of Coating Anomaly Suspected", " . Severity of Coating Anomaly Found");//401-406
//        lookForCheck(" . Severity of Coating Anomaly Found", "2b");//406-411
//        lookForCheck("ipe", " . Severity of the coating anomaly found was");//415-420
//        lookForCheck("severe than originally prioritized?", " . Is this the initial assessment of this covered segment?");//423-426
//        lookForCheck(" . Is this the initial assessment of this covered segment?", " . If both 3a");
//        lookForCheck(" . If both 3a", " . Was corrosion found?");//429-435
//        lookForCheck(" . Was corrosion found?", " . Was this a B or C priority in which the corrosion found was deeper than 20% of the original wall thickness?");
//        lookForCheck(" . Was this a B or C priority in which the corrosion found was deeper than 20% of the original wall thickness?", " . Was this corrosion deeper or more severe than corrosion found on any A-priority examination in this same region?");
//        lookForCheck(" . Was this corrosion deeper or more severe than corrosion found on any A-priority examination in this same region", " OTE");
//        lookForCheck(" assessed for adjustments?", " 10");//454-458
//        lookForCheck(" . Were changes made to the", " f Yes, document on MOC.  If No, explain why not.");
//
//        lookForCheck(" . Are additional indirect inspection surveys needed on this segment?", " 7B – Root Cause (based on data on");
//        lookForCheck(" 1. Is the corrosion considered significant?", " Only if Yes, proceed to 2, otherwise go to");
//        lookForCheck(" a. Was the review conducted?", "b.");//499-503
//        lookForCheck("Do alternative methods need to be implemented?", "Field Work:");
//        lookForCheck("4. For this HCA, has corrosion been found and a root cause determined at other locations?", " Only if Y");
//        lookForCheck("5. For this HCA, are similar occurrences of the root cause being determined at other locations?", "7C - Remaining Strength Calculation");
//        lookForCheck("Date calculation completed:", "Section");
//
//        label("#   Section 8                                                 #");
//        lookForUntil("nspector’s Comments", "Section");
//
//        label("#   Section 9                                                 #");
//        lookForCheck("Required?", " Reference Work Request No.");
//        lookForUntil(" Reference Work Request No.", "Check one:");//535-536
//        lookForCheck(" Repair was", " Remediation Comments:");
//        lookForUntil(" Remediation Comments:", "Section");//535-536
//
//        label("#   Section 10                                                #");
//        label("#   Section 11                                                #");
    }

    /***
     * Find the strings inside a specific table of 3 Rows
     * begining  with the cell containing lab1 and ending with cell containing
     * lab2, display the fond value
     * @param lab1 begining of the value inside the first cell
     * @param lab2 begining of the value inside the last cell
     */
    private void readTableInfo(String lab1, String lab2) {
        try {
            String name = findName(lab1);
            if (name.equalsIgnoreCase("")) {
                System.out.println("*** Cannot find name: " + lab1);
                return;
            }
            String nextLine = null, val;
            String[] labs = {"[R1]", "[R2]", "[R3]"};
            int lineCounter = startLine, labIndex = 0, offset = 7;
            int master = startLine;
            do {
                for (int i = 0; i < 6; i++) {
                    name = extractData.get(lineCounter).get(1).trim();
                    val = extractData.get(lineCounter++ + offset).get(1).trim();
                    processDisplayName(labs[labIndex] + name.trim(), val);
                    ++master;
                    //System.out.println("Master:" + master);
                }
                lineCounter = startLine;
                offset += 6;
                ++labIndex;
                nextLine = extractData.get(master + 7).get(1).trim(); // target 319
            } while (!nextLine.equalsIgnoreCase(lab2));
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }

    /***
     * simple find passed String
     * @param lab1 
     */
    private void lookFor(String lab1) {
        findName(lab1);
    }

    /***
     * Find the string between the "from" string and the "until" string.
     * display the fond value
     * @param lab1 from string
     * @param lab2 until string
     */
    private void lookForUntil(String lab1, String lab2) {
        try {
            String name = findName(lab1);
            if (name.equalsIgnoreCase("")) {
                System.out.println("*** Cannot find name: " + lab1);
                return;
            }
            String val = "";
            String nextLine = "";
            int lineCounter = startLine;
            do {
                nextLine = extractData.get(++lineCounter).get(1).trim();
                if (!nextLine.equalsIgnoreCase(lab2)) {
                    if (val.equalsIgnoreCase("")) {
                        val = val + nextLine;
                    } else {
                        val = val + " " + nextLine;
                    }
                }
            } while (!nextLine.equalsIgnoreCase(lab2));

            processDisplayName(name.trim(), val);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }

    /***
     * Find the checkable boxes with it s value 
     * (reads also the value of options)
     * display the fond value
     * @param lab1
     * @param lab2 
     */
    private void lookForCheck(String lab1, String lab2) {
        try {
            String name = findName(lab1);
            if (name.equalsIgnoreCase("")) {
                System.out.println("*** Cannot find name: " + lab1);
                return;
            }
            String sublab2 = lab2.substring(1);
            String val = "";
            String nextLine;
            boolean first = false;
            int lineCounter = startLine;
            boolean TokenizedLab2Detected = false;
            String[] Lab2Tok = lab2.split("\\s+");
            
            
            
            //exception
            if (name.equalsIgnoreCase("Ground Cover Found:") || name.equalsIgnoreCase("Defects:")) {
                do {
                    if (extractData.get(lineCounter).get(2).contains("<w:checked/>")) {
                        if (first) {
                            val = val + "," + extractData.get(++lineCounter).get(1);
                        } else {
                            val = val + extractData.get(++lineCounter).get(1);
                        }
                        first = true;
                    }
                    nextLine = extractData.get(++lineCounter).get(1).trim();
                } while (!nextLine.equalsIgnoreCase(lab2) && !nextLine.equalsIgnoreCase(sublab2));
            } else {
//-------------------------------------------------------------------------------------                
                do {
                    if (extractData.get(lineCounter).get(2).contains("<w:checked/>") && 
                           extractData.get(lineCounter + 1).get(0).contains("<w:t>") ) {
                        if (first) {
                            val = val + "," + extractData.get(lineCounter).get(5) +
                                    extractData.get(lineCounter + 1).get(1);
                        } else {
                            val = val + extractData.get(lineCounter).get(5);
                        }
                        first = true;
                    }
                    else if (extractData.get(lineCounter).get(2).contains("<w:checked/>")) {
                        if (first) {
                            val = val + "," + extractData.get(lineCounter).get(5);
                        } else {
                            val = val + extractData.get(lineCounter).get(5);
                        }
                        first = true;
                    }
                    nextLine = extractData.get(++lineCounter).get(1).trim();    //goes to next
                    
                    for(String value : Lab2Tok){
                        if(nextLine.equalsIgnoreCase(value))
                            TokenizedLab2Detected = true;
                        }
                    
                } while (!nextLine.equalsIgnoreCase(lab2) && !nextLine.equalsIgnoreCase(sublab2) && !TokenizedLab2Detected);
            }
            
            
            if(val.contains("   ") ){
                val = val.substring(0, val.indexOf("   "));
            }
            else if(val.contains("\t") ){
                val = val.substring(0, val.indexOf("\t"));
            }
            processDisplayName(name.trim(), val);
        } catch (java.lang.IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }
    
    /***
     * Find the passed argument
     * for the value, name attached together only
     * @param lab1 
     */
    //is there a better way? this is risky
    private void lookForCombo(String lab1) {
        String name = findName(lab1);
        int lineCounter = startLine;
        String value = "";
        List<String> tags = extractData.get(++lineCounter);
        if (tags.get(1).contains("<w:wResult")) {
            comboIndex = true;
            value = getListEntryValue(tags);
        } else {
            value = getListEntryValue(tags);
        }
        processDisplayName(name.trim(), value);
    }

    // User supplies a name, like a column
    private void lookForNextCombo(String name) {
        int lineCounter = startLine;
        String value = "";
        List<String> tags = extractData.get(++lineCounter);
        if (tags.get(1).contains("<w:wResult")) {
            comboIndex = true;
            value = getListEntryValue(tags);
        } else {
            value = getListEntryValue(tags);
        }
        processDisplayName(name.trim(), value);
    }

    // User supplies a name, like a column
    private void lookForNext(String lab1) {
        String name = findName(lab1);
        int lineCounter = startLine;
        String value = "";
        List<String> tags = extractData.get(++lineCounter);
        value = tags.get(3);
        processDisplayName(name.trim(), value);
    }

    /***
     * Find the passed argument
     * display the fond value
     * @param str 
     */
    private void label(String str) {
        processDisplayName(str, "");
    }

    /***
     * 
     * @param tags
     * @return 
     */
    private String getListEntryValue(List<String> tags) {
        String value;
        if (comboIndex) {
            String item = tags.get(1);
            String temp = "<w:wResult val=";
            int begin = temp.length();
            int end = item.length() - 1;
            value = item.substring(begin, end);
            item = tags.get((Integer.parseInt(value) + 2));
            temp = "<w:listEntry val=";
            begin = temp.length();
            end = item.length() - 1;
            value = item.substring(begin, end);
            comboIndex = false;
            return value;
        } else {
            String item = tags.get(1);
            String temp = "<w:listEntry val=";
            int begin = temp.length();
            int end = item.length() - 1;
            value = item.substring(begin, end);
            return value;
        }
    }

    /***
     * display the <name>:<value> 
     * @param name
     * @param value 
     */
    private void processDisplayName(String name, String value) {
        if (value.equalsIgnoreCase("")) {
            value = "N/A";
        }
        // exception needs to be handle some other way ---> DONE!
//        if (value.equalsIgnoreCase("No      % consumed")) {
//            value = "No";
//        }
        // exception
        if (name.trim().contains("Coating)")) {
            name = "Type of Defect";
        }
        // exception
        if (name.equalsIgnoreCase("Date of reading")) {
            //no need of this
            if (repeats.contains("Date of reading")) {
                name = "14th " + name;
            } else {
                //no need
                repeats.add("Date of reading");
                name = "7th " + name;
            }
        }
        // exception
        if (value.startsWith("th|day|Interpreted by|")) {
            value = value.substring(new String("th|day|Interpreted by|").length());
        }
        //formating
        name = name.trim().replace(":", "");

        String displayName, displayValue = null;
        if (xmlProps.containsKey(value)) {
            displayValue = xmlProps.getProperty(value);
        } else {
            displayValue = value;
        }
        if (xmlProps.containsKey(name)) {
            displayName = xmlProps.getProperty(name).replace(" ", "_");
            //System.out.println(displayName + " = " + displayValue);
            props.put(df.format(propCounter) + "_" + displayName, displayValue);
            propCounter++;
        } else {
            props.put(df.format(propCounter) + "_" + name.trim().replace(" ", "_"), displayValue);
            propCounter++;
        }
    }

    /***
     * delete the list of String
     * @param data list of String to be deleted
     * @return 
     */
    private List<String> cleanUpData(List<String> data) {
        List<String> clean = new ArrayList<String>();
        for (String d : data) {
            //d = d.replace(":", "");
            d = d.replace("   ", " ");
            d = d.replace("  ", " ");
            clean.add(d);
        }
        return clean;
    }

    /***
     * 
     * @param args
     * @return 
     */
    private String findName(String args) {
        args = args.trim();
        Set<String> keys = this.usedNames.keySet();
        // build up the label
        int localCounter = 0;
        String name = "";
        int lineCounter = -1;
        startLine = -1;
        boolean TokenizedArgDetected = false; 
        
        String subArg = args.substring(1);
        
        String[] ArgTok = args.split("\\s+");
        
        for (List<String> data : extractData) {
            data = cleanUpData(data);
            //            System.out.println("*** Looking for:" + data);
            lineCounter++;
            if (lineCounter == 406) {
                System.out.println("Stop");
            }
            for(String val : ArgTok){
                if(data.contains(val))
                    TokenizedArgDetected = true;
            }
            
            startLine++;
            if (data.contains(args) || data.contains(subArg) || 
                    TokenizedArgDetected == true) {
                if (keys.contains(args)) {
                    Integer nameReuse = this.usedNames.get(args);
                    if (nameReuse > localCounter++) {
                        continue;
                    }
                } else if (!keys.contains(args)) {
                    usedNames.put(args, ++localCounter);
                    ++multiNameCounter;
                }
                usedNames.put(args, localCounter);
                if (name.isEmpty()) {
                    name = name + args;
                } else {
                    name = name + "_" + args;
                }
                return name;
            }
        }
        return name;
    }

    private String findName(String[] args) {
        // build up the label
        String name = "";
        int lineCounter = -1;
        for (int i = 0; i < args.length; i++) {
            for (List<String> data : extractData) {
                data = cleanUpData(data);
                lineCounter++;
                if (data.contains(args[i])) {
                    if (name.isEmpty()) {
                        name = name + args[i];
                    } else {
                        name = name + "_" + args[i];
                    }
                    return name;
                }
            }
        }
        return name;
    }

    @Override
    public String toString() {
        Set<Object> set = props.keySet();
        List sortedKeys = new ArrayList(new TreeSet(set));
        StringBuilder sb = new StringBuilder();
        for (Object o : sortedKeys) {
            sb.append("\n").append(o.toString().substring(5)).append("=").append(props.get(o));
        }
        return sb.toString();
    }
    
    //from - untill reader
    private int FindValue(String labl, String nextLabel, String content ){
        int begin =0, end=0;
        
        if(!content.contains(labl) || !content.contains(nextLabel)){
            System.out.println("Could not find the desired labels");
            return -1;
        }
        else{
        
            TempIndex = content.indexOf(labl);
            TempIndexEnd = content.indexOf(nextLabel);
            
            //---------------------------- Can you explain this Kasra???? 
            //                              No I can't, happy now?
            if(LabsList.contains(labl)){
                content = content.substring(TempIndex+labl.length(), content.length());
            }
            
            LabsList.add(labl);
            if(LabsList.contains(nextLabel)){
                content = content.substring(TempIndex, content.length());
            }
            else if(NextLabsList.contains(nextLabel) || TempIndex > TempIndexEnd){
                content = content.substring(TempIndex, content.length() );
            }
            NextLabsList.add(nextLabel);
            //----------------------------

            begin = content.indexOf(labl)+labl.length();
            end = content.indexOf(nextLabel);

            //need to tokenize it--------------------------
            String[] lablTok = labl.split("\\s+");
            String[] ValTok = content.substring(begin, end).split("\\s+");
            
            StringBuilder builder = new StringBuilder();
            for (String value : lablTok) {
                builder.append(value).append(" ");
            }
            String labels = builder.toString();
            
            StringBuilder builder2 = new StringBuilder();
            for (String value : ValTok) {
                builder2.append(value).append(" ");
            }
            String Vals = builder2.toString();
            labels = labels.replace(':', ' ');
            Vals = Vals.replace("|_|", " ");
            String LabelPrime;
            
            
            if (props.containsKey(labels)) {
                LabelPrime = labels + " 2";
            //LabelPrime = props.getProperty(labels).replace(" ", "_");
            //System.out.println(displayName + " = " + displayValue);
                props.put(df.format(propCounter) + " " + LabelPrime, Vals);
                propCounter++;
            }
            else{
                props.put(df.format(propCounter) + " " + labels, Vals);
                propCounter++;
            }
            
            //-----------------------------------------------
            System.out.println(labels + " = " + Vals);
            
            return 1;
        }
    }

}
