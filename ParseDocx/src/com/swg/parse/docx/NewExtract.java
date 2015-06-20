/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swg.parse.docx;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import static java.lang.Character.isDigit;
import static java.lang.Character.isLetter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.imageio.ImageIO;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFPictureData;



/**
 *
 * @author KXK3
 */
public class NewExtract {
    //CopyOfContent and CopyOfPOIContent  will be constantly updated
    private static String CopyOfContent, CopyOfPOIContent, POIValue, TableTitle;
    private static int begin = 0, end = 0;
    private static int beginPOI = 0, endPOI = 0;
    private static int ManualColNum = 0, ManualRowNum = 0;
    private static ArrayList<String> rowLabels = new ArrayList<>();
    private static ArrayList<String> headContent = new ArrayList<>();
    private static boolean isHeader = false;
    
    public void extract(String content,String POIContent,String filePath) {
        
//        System.out.println("content: " + content);;
//        System.out.println(POIContent);
        
         //in case we need to use the entire content, we can re-use "content"
        CopyOfContent = content.toLowerCase();
        //in case we need to use the entire POI content, we can re-use "POI content"
        CopyOfPOIContent = POIContent.toLowerCase();
        
        File file= new File(filePath);
        extractImages(file.toString());
        
        //always put at least end of the label and start of end string 
        SectionMarker(0);
        FindTextField("This form is used", "DE Location ID", "");     //do we need this?
        SectionMarker(1);
        FindTextField("DE Location ID", "HCA Name", "");
        FindTextField("HCA Name", "Examination Number", "");
        FindTextField("Examination Number", "Work Request No.", "");
        FindTextField("Work Request No.", "Division", "");
        FindTextField("Division", "District Number", "");
        FindTextField("District Number", "Town or County", "");
        FindTextField("Town or County", "State", "");
        FindTextField("State", "Tile Number", "");
        FindTextField("Tile Number", "Address and/or Location", "");
        FindTextField("Address and/or Location", "Inspection Company", "");
        FindTextField("Inspection Company", "Date GPS Synchronized", "");
        FindTextField("Date GPS Synchronized", "Field Location (from Top of Pipe)", "");
        FindTextField("Start: GPS X", "Y", "");
        FindTextField("Y", "End: GPS X", "");
        FindTextField("End: GPS X", "Y", "");
        FindTextField("Y", "GPS File Name", "");
        FindTextField("GPS File Name", "Region", "");
        FindTextField("Region", "Planned Examination Length", "");
        FindTextField("Planned Examination Length", "Actual Examination Length", "");
        FindTextField("Actual Examination Length", "Foreign Pipe in Excavation", "");
        SectionMarker(2);
        FindTextField("Foreign Pipe in Excavation", "Size", "");
        FindTextField("Size", "Material", "");
        FindTextField("Material", "Foreign Current", "");
        FindTextField("Foreign Current", "Bond Present", "");
        FindTextField("Bond Present", "If Current Flow", "");
        FindTextField("If Current Flow, To:", "From:", "");
        FindTextField("From:", "CP Present", "");
        FindTextField("CP Present", "Anode Present", "");
        FindTextField("Anode Present", "% consumed", "");
        FindTextField("% consumed", "Environmental Conditions:", "");
        FindTextField("Temp", "Time 24-hr", "");
        FindTextField("Time 24-hr", "Weather Conditions", "");
        FindTextField("Weather Conditions", "Soil Conditions:", "");
        FindTextField("Soil Conditions:", "Bedding/Shading Type", "");
        FindTextField("Bedding/Shading Type", "Rockshield Used", "");
        FindTextField("Rockshield Used", "Soil Type:", "");
        FindTextField("Soil Type:", "Depth of Cover", "");
        FindTextField("Depth of Cover", "Pipe Data (as found in EMRS):", "");
        FindTextField("Nominal Size", "InDiam", "");
        FindTextField("InDiam", "Wthick", "");
        FindTextField("Wthick", "Grade", "");
        FindTextField("Grade", "Yield", "");
        FindTextField("Yield", "WkReqNo", "");
        FindTextField("WkReqNo", "Installation Month", "");
        FindTextField("Installation Month", "Installation Year", "");
        FindTextField("Installation Year", "OpsSysName", "");
        FindTextField("OpsSysName", "Weld Seam:", "");
        FindTextField("Weld Seam:", "Coating Types:", "");
        FindTextField("Coating Types:", "Coating Condition:", "");
        FindTextField("Coating Condition:", "Holiday Detection Volt Setting", "");
        FindTextField("Holiday Detection Volt Setting", "Type of Coating Damage", "");
        //--------------------------------
        FindTextField("Type of Coating Damage", "Ground Cover Found:", "exception tableText");
        //reserved for InTextTable & ground cover --> check box midle of text
        //--------------------------------
        FindTextField("pH of Fluid in Blisters", "I have reviewed", "");
        FindTextField("I have reviewed the procedures performed and have found them:", "*If Inadequate, send comments", "");
        FindTextField("Inspected By", "Inspection Date", "");
        FindTextField("Inspection Date", "Print or type name", "");
        FindTextField("Reviewed By", "Date Reviewed", "");
        FindTextField("Date Reviewed", "Print or type name", "");
        SectionMarker(3);
        FindTextField("Soil pH at Pipe Depth", "(using Antimony half cell)", "");
        FindTextField("Soil Resistivity at Pipe Depth", "cm", "");      //strange charachters ...
        FindTextField("soil chemistry performed", "method used", "");
        FindTextField("method used - ", "results:", "");
        FindTextField("chlorides", "ppm", "");
        FindTextField("nitrates", "ppm", "");
        FindTextField("sulfates", "ppm", "");
        FindTextField("6 o'clock", "bacterial samples taken", "");
        FindTextField("bacterial samples taken", "if yes, see section 6", "");
        FindTextField("asphalt and/or tar wrap samples taken", "defects:", "");
        SectionMarker(4);
        FindTextField("defects:", "all external defects shall", "");
        FindTextField("on the field sketch.", "see remediation", "");
        FindTextField("Comments:", "Ultrasonic Thickness Readings", "");
        SectionMarker(5);
        FindTextField("Ultrasonic Thickness Readings", "ICDA Scrub #1: Min", "colNum = 6");
        FindTextField("ICDA Scrub #1: Min", "Max", "");
        FindTextField("Max", "WT ?%", "");
        FindTextField("WT ?%", "ICDA Scrub #2: Min", "");
        FindTextField("ICDA Scrub #2: Min", "Max", "");
        FindTextField("Max", "WT ?%", "");
        FindTextField("WT ?%", "Comments:", "");
        FindTextField("Comments:", "Culture Results", "");
        SectionMarker(6);
        FindTextField("Location of samples", "Collected by", "");
        FindTextField("Collected by", "Date collected", "");
        FindTextField("Date collected", "7th day Interpreted by", "");
        FindTextField("7th day Interpreted by", "Date of reading", "");
        FindTextField("Date of reading", "14th day Interpreted by", "");
        FindTextField("14th day Interpreted by", "Date of reading", "");
        FindTextField("Date of reading", "Cap Color", "");
        FindTextField("Cap Color", "Low-Nutrient Bacteria (LNB)", "isHeader");
        FindTextField("A positive reaction results in a cloudy appearance or the formation of slime, which appears as sheets or clumps.", "Iron Related Bacteria (IRB)", "TableTitle = LNB");
        FindTextField("A cloudy appearance or slime DO NOT constitute a positive reaction.", "Anaerobic or Facultatively Anaerobic (ANA)", "TableTitle = IRB");
        FindTextField("A positive reaction results in cloudy appearance.", "Acid Producing Bacteria (APB)", "TableTitle = ANA");
        FindTextField("A positive reaction will turn media from red to cloudy orange or cloudy yellow.", "Sulfate Reducing Bacteria (SRB)", "TableTitle = APB");
        FindTextField("gray flecks does not constitute a positive reaction.", "In-Process Evaluation", "TableTitle = SRB");
        SectionMarker(7);
        //---------------------------------------CHECK POINT
        FindTextField("Severity of Coating Anomaly Suspected", "Severity of Coating Anomaly Found ", "");
        FindTextField("Severity of Coating Anomaly Found", "Severity of DE Defect Found on Pipe", "");
        FindTextField("Severity of DE Defect Found on Pipe", "3. Severity of the coating anomaly found was more", "");
        FindTextField("3. Severity of the coating anomaly found was more / less severe than originally prioritized?", "4. Is this the initial assessment of this covered segment?", "");
        FindTextField("4. Is this the initial assessment of this covered segment?", "5. If both 3a & 4b, then should the criteria in the Severity Classification Table be adjusted?", "");
        FindTextField("5. If both 3a & 4b, then should the criteria in the Severity Classification Table be adjusted?", "6. Was corrosion found?", "");
        FindTextField("6. Was corrosion found?", "7. Was this a B or C priority in which the corrosion found was deeper than 20% of the original wall thickness?", "");
        FindTextField("7. Was this a B or C priority in which the corrosion found was deeper than 20% of the original wall thickness?", "8. Was this corrosion deeper or more severe than corrosion found on any A-priority examination in this same region?", "");
        FindTextField("8. Was this corrosion deeper or more severe than corrosion found on any A-priority examination in this same region?", "NOTE:  If 4a, 7 and 8 are all true, then two additional", "");
        FindTextField("  9. Was the Severity Classification Table assessed for adjustments?", "10. Were changes made to the Severity Classification Table?", "");
        FindTextField("10. Were changes made to the Severity Classification Table?", "If Yes, document on MOC.  If No, explain why not.", "");
        FindTextField("If Yes, document on MOC.  If No, explain why not.", "11. Are additional indirect inspection surveys needed on this segment?", "");
        FindTextField("11. Are additional indirect inspection surveys needed on this segment?", "7B ? Root Cause", "");
        FindTextField("1. Is the corrosion considered significant?", "Only if Yes, proceed to 2,", "");
        FindTextField("2. Check the most likely root cause", "Inadequate CP current", "isHeader");
        //FindTextField("Inadequate CP current", "Explanation for Other:", ""); //reserved for table section 7
        FindTextField("Explanation for Other:", "Office Work:", "");
        FindTextField("a. Was the review conducted?", "b. Do alternative methods need to be implemented?", "");
        FindTextField("b. Do alternative methods need to be implemented?", "Field Work:", "");
        FindTextField("4. For this HCA, has corrosion been found and a root cause determined at other locations?", "Only if Yes, proceed.", "");
        FindTextField("5. For this HCA, are similar occurrences of the root cause being determined at other locations?", "7C - Remaining Strength Calculation", "");
        FindTextField("Date calculation completed:", "Inspector?s Comments:", "");
        SectionMarker(8);
        FindTextField("Inspector?s Comments:", "Remediation Action Required?", "");
        SectionMarker(9);
        FindTextField("Remediation Action Required?", "Reference Work Request No.", "");
        FindTextField("Reference Work Request No.", "Check one: Repair was:", "");
        FindTextField("Check one: Repair was:", "Remediation Comments: ", "");
        FindTextField("Remediation Comments:", "ANOMALY SKETCH", "");
        SectionMarker(10);
        SectionMarker(11);
        
//        FindTextField("", "", "");

        
    }

    //comments include: "colNum = x" (x is a int),  "rolNum = x" (x is a int),
    //"headContent = [x], [y], [z], .... (x,y,z are strings), "isHeader", "TableTitle = x (x is a string)
    //
    private int FindTextField(String StartString, String StopString, String comment) {
        
        StartString = StartString.toLowerCase();
        StopString = StopString.toLowerCase();
        begin = 0;
        end = 0;
        String value, label;
        String TableType;
                
        label = StartString;
        
        value = FindValue(StartString, StopString);
        
        //process the value type determination, formating, parsing and display
        if(end != 0 && begin != 0){
            
            commentHandeler(comment);
            String ValType = DetermineTypeOfValue(value).toLowerCase();
            
            //-------------------------------------------Work in progress ...
            if(comment.contains("tableText")){
                System.out.println("TESTTTTTTTTTT");
                String valueTok[] = value.split("\n");
                for(String str:valueTok){
                    if(!str.contains("%"))
                        System.out.println(str);
                }
            }
            //-------------------------------------------Work in progress ...
            else if(ValType.contains("table header")){
                setHeadOfTable(value, StartString);
            }
            else if(ValType.contains("checkbox")){
                value = FindCheckValue(value);
            }
            else if(ValType.contains("table")){
                
                TableType = DetermineTypeOfTable(value).toLowerCase();

                if(TableType.contains("horizontal")){
                    processHorizontalTable(value);
                }
                else if(TableType.contains("vertical")){
                    processVerticalTable(value);
                }
                else if(TableType.contains("no label")){
                    processNoLabTable(value);
                }
            }
            
            if(!ValType.contains("table") && !isHeader){
                //----------------------------------------------- see if you can make a function
                if(value.contains("0  n/a") && ValType.contains("text")){
                    String temp ="";
                    int j=0;
                    for(int i= 0; i< value.length(); i++){
                        if(value.charAt(i) != '\n'){
                            temp =  temp + value.charAt(i);
                            if(j == 2){
                                value = temp;
                            }
                        }
                        else{
                            j ++;
                        }
                    }
                }
                //-----------------------------------------------
                DisplayInfo(label, value);
            }
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
        else if(IsTable){
            Type = "Table";
        }
        else if(isHeader){
            Type = "table header";
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
                
                if(CopyOfPOIContent.contains(str)){
                    beginPOI = CopyOfPOIContent.indexOf(str) + str.length();
                    CopyOfPOIContent = CopyOfPOIContent.substring(beginPOI);
                }
            }
        }
        if(begin == 0 || beginPOI == 0){
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
            for(String str : StopStringTok){
                if( CopyOfPOIContent.contains(str) ){
                    endPOI = CopyOfPOIContent.indexOf(str);
                    break;
                }
            }
        }
        if(end == 0 || endPOI == 0){
            System.out.println("Unable to fgind the labls");
            return value;
        }
        else{
            value = CopyOfContent.substring(0, end);
            CopyOfContent = CopyOfContent.substring(end);
            POIValue = CopyOfPOIContent.substring(0, endPOI);
            CopyOfPOIContent = CopyOfPOIContent.substring(endPOI);
            return value;
        }
        
        
    }

    private boolean DetermineCheck(String value) {
        
        boolean IsCheckBox = false;
        for(int i =0; i < value.length(); i++){
            if(value.charAt(i) == ' ' || value.charAt(i) == '\n' ){
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
        if(cnt > 17){
            IsTable = true;
        }
        
        return IsTable;
    }

    private String FindValueForTables(String StartString, String StopString, String SpecificValue) {
        
        
        String [] StartStringTok = StartString.split("\\s+");
        String [] StopStringTok = StopString.split("\\s+");
        String value = "ERROR";    
        String CopyOfContent = SpecificValue;
        int begin = 0, end =0;
        
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

    //if "no label" then the labels are in headContent: you need to empty it to reuse it
    private String DetermineTypeOfTable(String value) {
          
        boolean isVertical = false;
        String type = "no label";     //by default
                
        int rowNum = 0, cntTemp =0;
        String temp = "";
        int j =0;
        for(int i = 0; i< POIValue.length()-1; i++){
            if(POIValue.charAt(i) == '\n' && isLetter(POIValue.charAt(i+1)) ){
                while(POIValue.charAt(i+1) != '\t'){
                    temp = temp + POIValue.charAt(i+1);
                    i++;
                    j = 0;
                }
                rowLabels.add(temp);    //has all the labels
                temp = "";
                rowNum ++;
            }
            else if(POIValue.charAt(i) != '\n'){
                j++;
                if(j > 200){
                    isVertical = true;
                }
            }

        }
        
        
        if(rowNum > 5){
            type = "Horizontal";
        }
        else if(isVertical){
            type = "Vertical";
        }
     
        
        return type;
    }

    private void processHorizontalTable(String value) {
        
        String temp = "";
        int colNum = 0, cntTemp =0;
        for(int i =0; i < rowLabels.size()-1 ; i++ ){
            String TableRowVal = FindValueForTables(rowLabels.get(i), rowLabels.get(i+1), value);
            for(int j =0; j < TableRowVal.length(); j++){
                if(TableRowVal.charAt(j) == '\n'){
                    if(cntTemp > 0){
                        System.out.println(rowLabels.get(i) + cntTemp + " = " + temp);
                        temp = "";
                    }
                cntTemp ++;
                }
                else{
                temp = temp + TableRowVal.charAt(j);
                }
            }
        colNum = cntTemp;
        cntTemp = 0;
        }
        
    }

    private void processVerticalTable(String value) {
        
        ArrayList<String> VerticalLabels = new ArrayList<>();
        String temp = "";
        int index = 0, j =0, dataCnt = 0;
        for(int i =0;i<value.length(); i++){
            if(index < ManualColNum){
            if(value.charAt(i) != '\n'){
                temp = temp + value.charAt(i);

            }
            else if(temp != " " && temp != ""){
                VerticalLabels.add(temp);
                temp = "";
                index++;
            }
        }
        else{
            if(value.charAt(i) != '\n'){
                temp = temp + value.charAt(i);

            }
            else if(temp != " " && temp != ""){
                    System.out.println(VerticalLabels.get(j) + dataCnt + " = " + temp);
                    temp = "";
                    j++;
                    if(j == ManualColNum){
                        j = 0;
                        dataCnt ++;
                    }
                }
            }
        }
        
    }

    private void commentHandeler(String comment) {
        isHeader = false;
        if(comment == ""){
            //do nothing
        }
        else if(comment.contains("colNum")){
            for(int i =0; i< comment.length(); i++){
                if(comment.charAt(i) == '=' && comment.charAt(i+1) == ' ' && isDigit(comment.charAt(i+2))){
                    char c = comment.charAt(i+2);
                    ManualColNum = Character.getNumericValue(c);
                }
            }
        }
        else if(comment.contains("rowNum")){
            for(int i =0; i< comment.length(); i++){
                if(comment.charAt(i) == '=' && comment.charAt(i+1) == ' ' && isDigit(comment.charAt(i+2))){
                    char c = comment.charAt(i+2);
                    ManualRowNum = Character.getNumericValue(c);
                }
            }
        }
        else if(comment.contains("isHeader")){
            isHeader = true;
        }
        else if(comment.contains("TableTitle")){
            TableTitle = "";
            boolean keepGoing = false;
            for(int i =0; i< comment.length() - 2; i++){
                if(comment.charAt(i) == '=' && comment.charAt(i+1) == ' ' && isLetter(comment.charAt(i+2))){
                    keepGoing = true;
                }
                if(keepGoing)
                    TableTitle = TableTitle + comment.charAt(i+2);
            }
        }
    }

    private void setHeadOfTable(String value, String StartString) {
        headContent.clear();
        String temp = "";
        headContent.add(StartString);
        for(int i=1; i < value.length(); i++){
            if(value.charAt(i) != '\n'){
                temp = temp + value.charAt(i);
                if(temp.equals("results")){
                    temp = temp + " ";
                    i++;
                }
                if(temp.equals("A")){
                    temp = "";
                    i++;
                }
            }
            else {
                headContent.add(temp);
                temp = "";

            }
        }
        
    }
    

    private void processNoLabTable(String value) {
                            
        String temp = "";
        int j =0, index = 0;
        System.out.println("tile = " + TableTitle);
        for(int i=1;i<value.length(); i++){
            if(value.charAt(i) != '\n'){
                temp = temp + value.charAt(i);
            }
            else{
                System.out.println(headContent.get(j) + "(" + index + ")" +" = " + temp);
                temp = "";
                            
                if(j == headContent.size()-1){
                    j =0;
                    index ++;
                }
                else{
                    j++;
                }
                //a better way to do this?
                if(index > 3){
                    break;
                }
            }
        }
                            
    }

    private void extractImages(String src) {
        
        try{

            FileInputStream fs=new FileInputStream(src);
            XWPFDocument docx=new XWPFDocument(fs);
            List<XWPFPictureData> piclist=docx.getAllPictures();
            Iterator<XWPFPictureData> iterator=piclist.iterator();
            int i=0;
            while(iterator.hasNext()){
                XWPFPictureData pic=iterator.next();
                byte[] bytepic=pic.getData();
                BufferedImage imag=ImageIO.read(new ByteArrayInputStream(bytepic));
                File CreatedImageFile = new File("imagefromword"+i+".jpg");
                ImageIO.write(imag, "jpg", new File("imagefromword"+i+".jpg"));
                i++;
                System.out.println("path to image " + i + " = " + CreatedImageFile.getAbsolutePath());
            }
        }catch(Exception e){System.exit(-1);}
        
    }
    
    
}
