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
    private static final int lineTracker = 0;
    
    private static int TempIndex = 0;
    private static int TempIndexEnd =0;
    private static String mainContent = null;

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
        mainContent = content;
        
        //--------------------------------------------------------------------------
        
        //------------------------------------------------
        FindValue("This form is used", "DE Location ID");
        label("#   Section 1                                                 #");
        FindValue("DE Location ID", "HCA Name");
        FindValue("HCA Name", "Examination Number");
        FindValue("Examination Number", "Work Request No.");
        FindValue("Work Request No.", "Division");
        lookForCombo("Division");
        FindValue("District Number", "Town or County");
        FindValue("Town or County", "State");
        lookForCombo("State");
        FindValue("Tile Number", "Address and/or Location");
        FindValue("Address and/or Location", "Inspection Company");
        FindValue("Inspection Company", "Date GPS Synchronized");
        FindValue("Date GPS Synchronized", "Field Location (from Top of Pipe)");
        FindValue("Start: GPS X", "Y");
        FindValue("Y", "End: GPS X");
        FindValue("End: GPS X", "Y");
        FindValue("Y", "GPS File Name");
        FindValue("GPS File Name", "Region");
        lookForCombo("Region");
        FindValue("Planned Examination Length", "Actual Examination Length");
        FindValue("Actual Examination Length", "Foreign Pipe in Excavation");
        label("#   Section 2                                                 #");
        lookForCheck("Foreign Pipe in Excavation", "Size");
        FindValue("Size", "Material");
        FindValue("Material", "Foreign Current");
        lookForCheck("Foreign Current", "Bond Present");
        lookForCheck("Bond Present", "If Current Flow");
        lookForCheck("If Current Flow, To:", "From");
        lookForCheck("From:", "CP Present");
        lookForCheck("CP Present", "Anode Present");
        lookForCheck("Anode Present", "Environmental Conditions:");
        FindValue("% consumed", "Environmental Conditions:");
        FindValue("Temp", "Time 24-hr");
        FindValue("Time 24-hr", "Weather Conditions");
        FindValue("Weather Conditions", "Soil Conditions:");
        lookForCheck("Soil Conditions:", "Bedding/Shading Type");    //Soil Conditions: ---> checkbox
        FindValue("Bedding/Shading Type", "Rockshield Used");
        lookForCheck("Rockshield Used", "Soil Type:");
        lookForCheck("Soil Type:", "Depth of Cover");
        FindValue("Other", "Depth of Cover");
        FindValue("Depth of Cover", "Pipe Data (as found in EMRS):");
        FindValue("Nominal Size", "InDiam" );
        FindValue("InDiam", "Wthick");
        FindValue("Wthick", "Grade");
        FindValue("Grade", "Yield");
        FindValue("Yield", "WkReqNo");
        FindValue("WkReqNo", "Installation Month");
        FindValue("Installation Month", "Installation Year");
        FindValue("Installation Year", "OpsSysName");
        FindValue("OpsSysName", "Weld Seam:");
        lookForCheck("Weld Seam:", "Coating Types:");
        FindValue("Other", "Coating Types:");
        lookForCheck("Coating Types:", "Coating Condition:");
        FindValue("Other", "Coating Condition:");
        lookForCheck("Coating Condition:", "Holiday Detection Volt Setting");
        FindValue("Holiday Detection Volt Setting", "Type of Coating");
        //-----------------------------------------------------Checkpoint --> works

        //----------------------------------------------ERROR
        //--------------------------
        lookForCheck("Ground Cover Found:", "on-C");    //Ground Cover Found: ---> checkbox //problem ...
        //--------------------------
        FindValue("Non-Corrosive Disbondment", "Concrete");
        FindValue("Blistering Due to Corrosion", "pH of Fluid in Blisters"); //problem
        //--------------------------
        //----------------------------------------------ERROR
        
        //----------------------------------------------------------------------
        FindValue("pH of Fluid in Blisters", "I have reviewed the procedures performed and have found them:");
        lookForCheck("I have reviewed the procedures performed and have found them:", "*If Inadequate, send comments and copy of WMS-WR to Engineering and Project Support Staff, LVA-581");//Fix this
        FindValue("Inspected By", "Inspection Date");
        FindValue("Inspection Date", "Print or type name");
        FindValue("Reviewed By", "Date Reviewed");
        FindValue("Date Reviewed", "Print or type name");
        label("#   Section 3                                                 #");
        FindValue("Soil pH at Pipe Depth", "(using Antimony half cell)");
        FindValue("Soil Resistivity at Pipe Depth", "cm");
        lookForCheck("Soil Chemistry Performed", "Method used");
        lookForCheck("Method used -", "Results:");
        FindValue("Chlorides", "ppm");
        FindValue("Nitrates", "ppm");
        FindValue("Sulfates", "ppm");
        FindValue("6 O’clock", "Bacterial Samples Taken");
        lookForCheck("Bacterial Samples Taken", "If yes, see Section 6");
        lookForCheck("Asphalt and/or Tar Wrap samples taken", "Section 4");
        label("#   Section 4                                                 #");
        lookForCheck("Defects:", "All external");
        //-----------------------------------------------------Checkpoint --> works
        
        
        ReadDropDownOnTable("Number", "See Remediation Design for determination of Repair Category.", 5);
        HorizontalTableFindValue("Number", "Type of Defect", 5);
        HorizontalTableFindValue("Distance from Zero Point (feet)", "O’clock Position", 5);
        HorizontalTableFindValue("O’clock Position", "Length (Axial) (inch)", 5);
        HorizontalTableFindValue("Length (Axial) (inch)", "Length (Circumferential) (inch)", 5);
        HorizontalTableFindValue("Length (Circumferential) (inch)", "Maximum Depth (inch)", 5);
        FindValue("Comments:", "Ultrasonic Thickness Readings");
        label("#   Section 5                                                 #");
        
        //!!!!!!!!! Table "Ultrasonic Thickness Readings" !!!!!!!!!!!!
        FindValue("ICDA Scrub #1: Min", "Max");
        FindValue("Max", "WT ∆%");
        FindValue("WT ∆%", "ICDA Scrub #2: Min");
        FindValue("ICDA Scrub #2: Min", "Max");
        FindValue("Max", "WT ∆%");
        FindValue("WT ∆%", "Comments:");
        FindValue("Comments:", "Culture Results");
        label("#   Section 6                                                 #");
        FindValue("Location of samples", "Collected by");
        FindValue("Collected by", "Date collected");
        FindValue("Date collected", "7th day Interpreted by");
        FindValue("7th day Interpreted by", "Date of reading");
        FindValue("Date of reading", "14th day Interpreted by");
        FindValue("14th day Interpreted by", "Date of reading");
        FindValue("Date of reading", "Cap Color");
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
        FindValue("If Yes, document on MOC. If No, explain why not.", "11. Are additional indirect inspection surveys needed on this segment?" );
        //Are additional indirect inspection surveys needed on this segment? ---> checkbox
        //Is the corrosion considered significant?  ---> checkbox
        //!!!!!!!!!!!!! Table - Check the most likely root cause !!!!!!!!!!!!!!!
        FindValue("Explanation for Other:", "Office Work:");
        //Was the review conducted? ---> checkbox
        //Do alternative methods need to be implemented? ---> checkbox
        //For this HCA, has corrosion been found and a root cause determined at other locations? ---> checkbox
        //For this HCA, are similar occurrences of the root cause being determined at other locations? ---> checkbox
        FindValue("Date calculation completed:", "|_| N/A");
        //checkbox ...
        //section 8 ---> lable -------------------------------------------------
        FindValue("Inspector’s Comments:", "Remediation Action Required?");
        //section 9 ---> label -------------------------------------------------
        //Remediation Action Required?  ---> checkbox
        FindValue("Reference Work Request No.", "Check one: Repair was:");
        //Repair was: ---> checkbox
        FindValue("Remediation Comments:", "ANOMALY SKETCH");
        //section 10 ---> label ------------------------------------------------
        //need titles ?
        //section 11 ---> label ------------------------------------------------
        
        
        //----------------------------------------------------------------------------
    }

    /***
     * Find the checkable boxes with it s value 
     * (reads also the value of options)
     * display the fond value
     * @param lab1
     * @param lab2 
     */
    private void lookForCheck(String lab1, String lab2) {
        LabsList.add(lab1);
        try {
            TempIndexEnd = mainContent.indexOf(lab2);
            String name = findName(lab1);
            TempIndexEnd = 0;
            if (name.equalsIgnoreCase("")) {
                System.out.println("*** Cannot find name: " + lab1);
                return;
            }
            String sublab2 = lab2.substring(1);
            String val = "";
            String nextLine;
            String[] Lab2Tok = lab2.split("\\s+");
            boolean first = false;
            int lineCounter = startLine;
            boolean TokenizedLab2Detected = false;
            boolean ErrorCheck = false;
            boolean hasSublab = false, hasLab = false;
            
//-------------------------------------------------------------------------------------                
                do {
                    
                    for(int i =1; i< 3; i++){
                        for(String checkVal : Lab2Tok){
                           if(extractData.get(lineCounter + i).get(1).contains(checkVal))
                               ErrorCheck = true;
                        }
                        if(extractData.get(lineCounter + i).get(1).contains(lab2) ||
                            extractData.get(lineCounter + i).get(1).contains(sublab2)){
                            ErrorCheck = true;
                        }
                    }
                    //--------------------------------------------------------------
                    for(int j=0; j < extractData.get(lineCounter).size(); j++){
                        if(extractData.get(lineCounter).get(j).contains(lab2)){
                            hasLab = true;
                        }
                        if(extractData.get(lineCounter).get(j).contains(sublab2)){
                            hasSublab = true;
                        }
                    }
                    //--------------------------------------------------------------
                    
                    //handls the option that is checked
                    if (extractData.get(lineCounter).get(2).contains("<w:checked/>") && 
                           extractData.get(lineCounter + 1).get(0).contains("<w:t>") &&
                            !ErrorCheck ) {
                        if (first) {
                            val = val + "," + extractData.get(lineCounter).get(5) +
                                    extractData.get(lineCounter + 1).get(1);
                        } else {
                            val = val + extractData.get(lineCounter).get(5) +
                                    extractData.get(lineCounter + 1).get(1);
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
                    if(val.contains("<w:t/>")){
                        val = extractData.get(lineCounter+1).get(1);
                    }
                    
                    nextLine = extractData.get(++lineCounter).get(1);    //goes to next
                    if(nextLine.contains(lab2))
                        break;
                    
                    if(nextLine.contains(Lab2Tok[0]) && nextLine.contains(Lab2Tok[1]) )
                        TokenizedLab2Detected = true;
                        
                    
                } while (!nextLine.equalsIgnoreCase(lab2) && !nextLine.equalsIgnoreCase(sublab2) && !TokenizedLab2Detected 
                        && !hasSublab && !hasLab);
            
            
            
            //if the checked option has \t, this means that after \t begins another label
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
        String name = null;
        if(lab1 == "next"){
            name = "next";
            startLine++;
        }
        else{
            name = findName(lab1);
        }
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
        // exception
//        if (name.trim().contains("Coating)")) {
//            name = "Type of Defect";
//        }
        //formating
        name = name.trim().replace(":", "");
        name = name.trim().replace("-", "");

        String displayName, displayValue = null;
        if (xmlProps.containsKey(value)) {
            displayValue = xmlProps.getProperty(value);
        } else {
            displayValue = value;
        }
        if (xmlProps.containsKey(name)) {
            displayName = xmlProps.getProperty(name);
            props.put(df.format(propCounter) + "_" + displayName, displayValue);
            propCounter++;
        } else {
            props.put(df.format(propCounter) + "_" + name.trim(), displayValue);
            propCounter++;
        }
    }

    /***
     * delete the list of String
     * @param data list of String to be deleted
     * @return 
     */
    private List<String> cleanUpData(List<String> data) {
        List<String> clean = new ArrayList<>();
        for (String d : data) {
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
        boolean TokenizedArgDetected = false, TokenizedDataDetected = false; 
        int StartIndex =0;
        
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
                StartIndex = mainContent.indexOf(val);
                if( data.contains(val) && !data.equals(val) && StartIndex < TempIndexEnd)
                    TokenizedArgDetected = true;
            }
            for(String dataTok : data){
                if(dataTok.contains(args))
                    TokenizedDataDetected = true;
            }
            
            startLine++;
            if (data.contains(args) || data.contains(subArg) || 
                    TokenizedArgDetected == true || TokenizedDataDetected == true) {
                if (keys.contains(args)) {
                    Integer nameReuse = this.usedNames.get(args);
                    if (nameReuse > localCounter++){ 
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
                
                extractData = extractData.subList(startLine, extractData.size() -1 );
                startLine = 0;
                
                return name;
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
    private int FindValue(String labl, String nextLabel){
        int begin =0, end=0;
        
        if(!mainContent.contains(labl) || !mainContent.contains(nextLabel)){
            System.out.println("Could not find the desired labels");
            return -1;
        }
        else{
        
            TempIndex = mainContent.indexOf(labl);
            TempIndexEnd = mainContent.indexOf(nextLabel);
            
            while(TempIndex > TempIndexEnd){
                mainContent = mainContent.substring(TempIndex);
                
                TempIndex = mainContent.indexOf(labl);
                TempIndexEnd = mainContent.indexOf(nextLabel);
            }

            begin = mainContent.indexOf(labl)+labl.length();
            end = mainContent.indexOf(nextLabel);

            String[] lablTok = labl.split("\\s+");
            String[] ValTok = mainContent.substring(begin, end).split("\\s+");
            
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
            
            mainContent = mainContent.substring(TempIndexEnd);
            

            
            if (props.containsKey(labels)) {
                String LabelPrime = labels + " 2";
                props.put(df.format(propCounter) + " " + LabelPrime, Vals);
                propCounter++;
            }
            else{
                props.put(df.format(propCounter) + " " + labels, Vals);
                propCounter++;
            }
            
            return 1;
        }
    }
    
    private int HorizontalTableFindValue(String labl, String nextLabel, int ColNum){
        
        int begin =0, end=0;
        
        if(!mainContent.contains(labl) || !mainContent.contains(nextLabel)){
            System.out.println("Could not find the desired labels");
            return -1;
        }
        else{
        
            TempIndex = mainContent.indexOf(labl);
            TempIndexEnd = mainContent.indexOf(nextLabel);
            
            while(TempIndex > TempIndexEnd){
                mainContent = mainContent.substring(TempIndex);
                
                TempIndex = mainContent.indexOf(labl);
                TempIndexEnd = mainContent.indexOf(nextLabel);
            }

            begin = mainContent.indexOf(labl)+labl.length();
            end = mainContent.indexOf(nextLabel);

            String[] lablTok = labl.split("\\s+");
            String[] ValTok = mainContent.substring(begin, end).split("\\s+");
            
            StringBuilder builder = new StringBuilder();
            for (String value : lablTok) {
                builder.append(value).append(" ");
            }
            String labels = builder.toString();
            
            mainContent = mainContent.substring(TempIndexEnd);
            
            for(int i=1; i< ColNum+1; i++){
                if (props.containsKey(labels)) {
                   String LabelPrime = labels + i + " 2";
                   props.put(df.format(propCounter) + " " + LabelPrime + i, ValTok[i]);
                   propCounter++;
               }
               else{
                   props.put(df.format(propCounter) + " " + labels + i, ValTok[i]);
                   propCounter++;
               }
            }
            
            return 1;
        }
    }
    
    private int ReadDropDownOnTable(String StartString, String StopString, int ColNum){
                        

        List<List<String>> ReadTableList = extractData;
        int StartXMLParseLine = 0, StopXMLParseLine = 0;
        boolean hasTextVal = false, hasDropDownVal = false;
        
        for(List<String> list : ReadTableList){
            
            if(list.contains(StartString) && StartXMLParseLine > startLine ){
                break;
            }
            StartXMLParseLine ++;
        }
        
        startLine = StartXMLParseLine;
        
        for(List<String> list : ReadTableList){
            
            if(list.contains(StopString) && StopXMLParseLine > startLine ){
                break;
            }
            StopXMLParseLine ++;
        }
        
        startLine = StopXMLParseLine;
        
        ReadTableList = ReadTableList.subList(StartXMLParseLine, StopXMLParseLine);
        
        int breakPoint = ReadTableList.size();
        StopXMLParseLine = 0;
        
        while(!ReadTableList.isEmpty()){
            if(ReadTableList.get(0).get(0).contains("<w:t>")){
                if(ReadTableList.get(1).get(0).contains("<w:ddList>")){
                    lookForCombo(ReadTableList.get(0).get(1));
                    for(int i=1; i< ColNum; i++ ){
                        //take the 4 others
                        lookForCombo("next");
                    }
                }
            }
            
            ReadTableList = ReadTableList.subList(1, ReadTableList.size()-1);
            
        }        
        
        return 0;
    }

}
