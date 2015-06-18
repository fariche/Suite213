/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swg.parse.docx;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author KXK3
 */
public class NewExtract {
    //CopyOfContent will be constantly updated
    private static String CopyOfContent;
    private static int begin = 0, end = 0;
    
    public void extract(String content) {
        
        System.out.println("content: " + content);
        
         //in case we need to use the entire content, we can re-use "content"
        CopyOfContent = content.toLowerCase();
        
        //always put at least end of the label and start of end string 
        SectionMarker(0);
        FindTextField("This form is used", "DE Location ID");     //do we need this?
        SectionMarker(1);
        FindTextField("DE Location ID", "HCA Name");
        FindTextField("HCA Name", "Examination Number");
        FindTextField("Examination Number", "Work Request No.");
        FindTextField("Work Request No.", "Division");
        FindTextField("Division", "District Number");
        FindTextField("District Number", "Town or County");
        FindTextField("Town or County", "State");
        FindTextField("State", "Tile Number");
        FindTextField("Tile Number", "Address and/or Location");
        FindTextField("Address and/or Location", "Inspection Company");
        FindTextField("Inspection Company", "Date GPS Synchronized");
        FindTextField("Date GPS Synchronized", "Field Location (from Top of Pipe)");
        FindTextField("Start: GPS X", "Y");
        FindTextField("Y", "End: GPS X");
        FindTextField("End: GPS X", "Y");
        FindTextField("Y", "GPS File Name");
        FindTextField("GPS File Name", "Region");
        FindTextField("Region", "Planned Examination Length");
        FindTextField("Planned Examination Length", "Actual Examination Length");
        FindTextField("Actual Examination Length", "Foreign Pipe in Excavation");
        SectionMarker(2);
        FindTextField("Foreign Pipe in Excavation", "Size");
        FindTextField("Size", "Material");
        FindTextField("Material", "Foreign Current");
        FindTextField("Foreign Current", "Bond Present");
        FindTextField("Bond Present", "If Current Flow");
        FindTextField("If Current Flow, To:", "From:");
        FindTextField("From:", "CP Present");
        FindTextField("CP Present", "Anode Present");
        FindTextField("Anode Present", "% consumed");
        FindTextField("% consumed", "Environmental Conditions:");
        FindTextField("Temp", "Time 24-hr");
        FindTextField("Time 24-hr", "Weather Conditions");
        FindTextField("Weather Conditions", "Soil Conditions:");
        FindTextField("Soil Conditions:", "Bedding/Shading Type");
        FindTextField("Bedding/Shading Type", "Rockshield Used");
        FindTextField("Rockshield Used", "Soil Type:");
        FindTextField("Soil Type:", "Depth of Cover");
        FindTextField("Depth of Cover", "Pipe Data (as found in EMRS):");
        FindTextField("Nominal Size", "InDiam");
        FindTextField("InDiam", "Wthick");
        FindTextField("Wthick", "Grade");
        FindTextField("Grade", "Yield");
        FindTextField("Yield", "WkReqNo");
        FindTextField("WkReqNo", "Installation Month");
        FindTextField("Installation Month", "Installation Year");
        FindTextField("Installation Year", "OpsSysName");
        FindTextField("OpsSysName", "Weld Seam:");
        FindTextField("Weld Seam:", "Coating Types:");
        FindTextField("Coating Types:", "Coating Condition:");
        FindTextField("Coating Condition:", "Holiday Detection Volt Setting");
        FindTextField("Holiday Detection Volt Setting", "Type of Coating Damage");
        //--------------------------------
        //FindTextField("", "");
        //reserved for InTextTable & ground cover --> check box midle of text
        //--------------------------------
        FindTextField("pH of Fluid in Blisters", "I have reviewed");
        FindTextField("I have reviewed the procedures performed and have found them:", "*If Inadequate, send comments");
        FindTextField("Inspected By", "Inspection Date");
        FindTextField("Inspection Date", "Print or type name");
        FindTextField("Reviewed By", "Date Reviewed");
        FindTextField("Date Reviewed", "Print or type name");
        SectionMarker(3);
        FindTextField("Soil pH at Pipe Depth", "(using Antimony half cell)");
        FindTextField("Soil Resistivity at Pipe Depth", "cm");      //strange charachters ...
        FindTextField("soil chemistry performed", "method used");
        FindTextField("method used - ", "results:");
        FindTextField("chlorides", "ppm");
        FindTextField("nitrates", "ppm");
        FindTextField("sulfates", "ppm");
        FindTextField("6 o'clock", "bacterial samples taken");
        FindTextField("bacterial samples taken", "if yes, see section 6");
        FindTextField("asphalt and/or tar wrap samples taken", "defects:");
        SectionMarker(4);
        FindTextField("defects:", "all external defects shall");
        //---------------------------------------CHECK POINT
        FindTextField("on the field sketch.", "* see remediation"); //resrve for table S4
         FindTextField("Comments:", "Ultrasonic Thickness Readings");
         SectionMarker(5);
         
//        FindTextField("", "");

        
    }

    private int FindTextField(String StartString, String StopString) {
        
        StartString = StartString.toLowerCase();
        StopString = StopString.toLowerCase();
        begin = 0;
        end = 0;
        String value, label;
        
        label = StartString;
        
        value = FindValue(StartString, StopString);
        
        //process the value type determination, formating, parsing and display
        if(end != 0 && begin != 0){
            
            String ValType = DetermineTypeOfValue(value);
            
            if(ValType.contains("CHECKBOX")){
                value = FindCheckValue(value);
            }
            if(ValType.contains("Table")){
                System.out.println("TESTTTTTTTTTTTTTTTTTTTT");
                //create the value = FindTableValue(); ....
            }
            
            DisplayInfo(label, value);
            return 1;
        }
            
        return 0;
    }

    private void DisplayInfo(String label, String value) {
        
        System.out.print(label + " = " + value);
        System.out.println("");
        
    }

    private void SectionMarker(int sectionNum) {
        System.out.println("Section" + sectionNum + "-----------------------------------------------");   
    }

    private String DetermineTypeOfValue(String value) {
        
        
        boolean IsCheckBox = false;
        boolean IsTable = false;
        //by default the type is either text field or drop down
        //the reason why we don't make the difference between drop down and textfield
        //is that they are both processed the exact same way
        String Type = "text field or drop down";
        
        IsCheckBox = DetermineCheck(value);
        IsTable = DetermineTable(value);
        
        if(IsCheckBox ){
            Type = "CHECKBOX!!!!!!!!!!!!";
        }
        if(IsTable){
            Type = "Table";
        }
        
        
        System.out.println("");
        System.out.println(Type);
        
        return Type;
    }

    private String FindValue(String StartString, String StopString) {
        
        
        String [] StartStringTok = StartString.split("\\s+");
        String [] StopStringTok = StopString.split("\\s+");
        String value = "ERROR";    
        
        for(String str : StartStringTok){
            if( CopyOfContent.contains(str) ){
                begin = CopyOfContent.indexOf(str) + str.length();
                CopyOfContent = CopyOfContent.substring(begin);
            }
        }
        if(begin == 0){
            System.out.println("Unable to fgind the labls");
            return value;
        }
        else{
            
            for(String str : StopStringTok){
                if( CopyOfContent.contains(str) ){
                    end = CopyOfContent.indexOf(str);
                    break;
                }
            }
        }
        if(end == 0){
            System.out.println("Unable to fgind the labls");
            return value;
        }
        else{
            value = CopyOfContent.substring(0, end);
            CopyOfContent = CopyOfContent.substring(end);
            return value;
        }
        
        
    }

    private boolean DetermineCheck(String value) {
        
        boolean IsCheckBox = false;
        for(int i =0; i < value.length(); i++){
            if(value.charAt(i) == ' '){
                //continue
            }
            else if( (value.charAt(i) == '1' || value.charAt(i) == '0') && value.charAt(i+1) == ' ' ){
                IsCheckBox = true;
                break;
            }
            else{
                break;
            }
        }
        return IsCheckBox;
    }

    //-----------------------------------Algorithm
    //find 1
    //temp = find whatever between that 1 and (" 0 " || " 1 ")
    //val = val + temp + ","
    //find next 1 and repeat
    //-----------------------------------
    private String FindCheckValue(String valueOrig) {
        
        String value = valueOrig;
        String val = "";
        for(int i = 0; i < value.length(); i++){
            if(value.charAt(i) == '1'){
                //found 1
                if(i < value.length()){
                i++;
                while(true){
                        //find between that 1 and (" 0 " || " 1 ")
                        val = val +  value.charAt(i);
                        i++;
                        if(i == value.length()-1 || value.charAt(i) == '1' || value.charAt(i) == '0' ){
                            break;
                        }
                    }
                val = val + ",";
                }
            }
        }
        value = val;
        return value;
    }

    private boolean DetermineTable(String value) {
        
        boolean IsTable = false;
        
        int cnt =0;
        for(int i = 0; i < value.length(); i++){
            if(value.charAt(i) == '\n'){
                cnt ++;
            }
        }
        if(cnt > 10){
            IsTable = true;
        }
        
        return IsTable;
    }
    
    
}
