/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * This class also populate ListOfPOJO_Rows a label-value-section POJO that wilol be used by other classes
 */
package com.swg.parse.docx;

import com.swg.parse.Form213Pojo.ExtractPOJO;
import com.swg.parse.Form213Pojo.MainPOJO;
import com.swg.parse.data.Form213FactoryMain;
import com.swg.parse.populate.DynamicPopulatePOJO;
import com.swg.parse.populate.populatePOJOs;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import static java.lang.Character.isDigit;
import static java.lang.Character.isLetter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.imageio.ImageIO;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFPictureData;



/**
 * Extract all data from the .txt and .docx file, format them nicely and set the values of the first POJO
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
    private static ArrayList<String> tempCheckException = new ArrayList<>();
    private static boolean isHeader = false;
    private static int version = 0;
    private static int section = 0;
    private static String TempLab = null;
    
    
    private static ArrayList<String> labelBeforePOJO = new ArrayList<>();
    private static ArrayList<String> ValueBeforePOJO = new ArrayList<>();
    private static ArrayList<String> typeBeforePOJO = new ArrayList<>();
    private static ArrayList<Integer> sectionBeforePOJO = new ArrayList<>();
    private static ArrayList<ExtractPOJO> ListOfPOJO_Rows = new ArrayList<>();
    
    /**
     * object that can be used to extract all necessary data from .docx or .txt
     * @param content .txt string content
     * @param POIContent .docx string content
     * @param filePath the path to the file .docx file
     * @param Ver the version of the document
     * @param FileCnt the current value of the counter used specially when there are multiple .docx files in a directory
     */
    public void extract(String content,String POIContent,String filePath, int Ver, int FileCnt) throws ParseException {

        version = Ver;
         //in case we need to use the entire content, we can re-use "content"
        CopyOfContent = content.toLowerCase();
        //in case we need to use the entire POI content, we can re-use "POI content"
        CopyOfPOIContent = POIContent.toLowerCase();
        
        File file= new File(filePath);
        extractImages(file.toString(), FileCnt);

        if(version == 0){
            //always put at least end of the label and start of end string 
            SectionMarker(0);
            FindTextField("This form is used", "DE Location ID", "");
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
            FindTextField("Type of Coating Damage", "Ground Cover Found:", "exception tableTextHeader");
            FindTextField("Ground Cover Found:", "Non-Corrosive Disbondment", "CheckBoxConflict");
            FindTextField("Non-Corrosive Disbondment", "Blistering Due to Corrosion", "tableTexBody");
            FindTextField("Blistering Due to Corrosion", "pH of Fluid in Blisters", "tableTexBody");
            DisplayCheckException();
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
            FindTextField("defects:", "all external defects shall", "labelException = Anomaly:  Coating Defect,");
            FindTextField("on the field sketch.", "see remediation", "SpecialTableForcing");
            FindTextField("Comments:", "Ultrasonic Thickness Readings", "labelException = defects comments:,");
            SectionMarker(5);
            FindTextField("Ultrasonic Thickness Readings", "ICDA Scrub #1: Min", "colNum = 6");
            FindTextField("ICDA Scrub #1: Min", "Max", "");
            FindTextField("Max", "WT ?%", "");
            FindTextField("WT ?%", "ICDA Scrub #2: Min", "");
            FindTextField("ICDA Scrub #2: Min", "Max", "");
            FindTextField("Max", "WT ?%", "");
            FindTextField("WT ?%", "Comments:", "");
            FindTextField("Comments:", "Culture Results", "labelException = ultrasonic comments:,");
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
            FindTextField("A positive reaction results in cloudy appearance. ", "Acid Producing Bacteria (APB)", "TableTitle = ANA");
            FindTextField("A positive reaction will turn media from red to cloudy orange or cloudy yellow.", "Sulfate Reducing Bacteria (SRB)", "TableTitle = APB");
            FindTextField("gray flecks does not constitute a positive reaction.", "In-Process Evaluation", "TableTitle = SRB");
            SectionMarker(7);
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
            FindTextField("2. Check the most likely root cause", "Inadequate CP current", "SkipFirstTableHeader");
            FindTextField("Inadequate CP current", "Explanation for Other:", "2DimVersion1Expection"); //reserved for table section 7
            FindTextField("Explanation for Other:", "Office Work:", "");
            FindTextField("a. Was the review conducted?", "b. Do alternative methods need to be implemented?", "");
            FindTextField("b. Do alternative methods need to be implemented?", "Field Work:", "");
            FindTextField("4. For this HCA, has corrosion been found and a root cause determined at other locations?", "Only if Yes, proceed.", "");
            FindTextField("5. For this HCA, are similar occurrences of the root cause being determined at other locations?", "7C - Remaining Strength Calculation", "");
            FindTextField("Date calculation completed:", "Inspector Comments:", "");
            SectionMarker(8);
            FindTextField("Inspector?s Comments:", "Remediation Action Required?", "");
            SectionMarker(9);
            FindTextField("Remediation Action Required?", "Reference Work Request No.", "");
            FindTextField("Reference Work Request No.", "Check one: Repair was:", "");
            FindTextField("Check one: Repair was:", "Remediation Comments: ", "");
            FindTextField("Remediation Comments:", "ANOMALY SKETCH", "");
            SectionMarker(10);
            SectionMarker(11);
        }
        
        if(version == 1){
            //always put at least end of the label and start of end string 
            SectionMarker(0);
            FindTextField("This form is used", "DE Location ID", "");
            SectionMarker(1);
            FindTextField("DE Location ID", "HCA#", "");
            FindTextField("HCA#", "Examination Number", "");
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
            FindTextField("GPS File Name", "ECDA Region", "");
            FindTextField("ECDA Region", "Planned Examination Length", "");
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
            FindTextField("Soil Type:", "Pipe Data (as found in EMRS):", "");
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
            FindTextField("Coating Condition:", "Type of Coating Damage", "");
            FindTextField("Type of Coating Damage", "Holiday Detection Volt Setting", "exception tableTextHeader");
            FindTextField("Holiday Detection Volt Setting", "Non-Corrosive Disbondment", "");
            FindTextField("Non-Corrosive Disbondment", "Blistering Due to Corrosion", "tableTexBody");
            FindTextField("Blistering Due to Corrosion", "pH of Fluid in Blisters", "tableTexBody");
            FindTextField("pH of Fluid in Blisters", "I have reviewed", "");
            FindTextField("I have reviewed the procedures performed and have found them:", "*If Inadequate, send comments", "");
            FindTextField("Inspected By", "Inspection Date", "");
            FindTextField("Inspection Date", "Print name", "");
            FindTextField("Reviewed By", "Date Reviewed", "");
            FindTextField("Date Reviewed", "Print name", "");
            SectionMarker(3);
            FindTextField("Soil pH at Pipe Depth", "(using Antimony half cell)", "");
            FindTextField("Soil Resistivity at Pipe Depth", "cm", "");      //strange charachters ...
            FindTextField("soil chemistry performed", "method used", "");
            FindTextField("method used - ", "results:", "");
            FindTextField("chlorides", "ppm", "");
            FindTextField("nitrates", "ppm", "");
            FindTextField("sulfates", "ppm", "");
            FindTextField("6 o'clock", "bacterial samples taken", "");
            FindTextField("bacterial samples taken", "date of incubation", "");
            FindTextField("date of incubation", "asphalt and/or tar wrap samples taken", "");
            FindTextField("asphalt and/or tar wrap samples taken", "Anomaly:  Coating Defect", "");
            SectionMarker(4);
            FindTextField("Anomaly:  Coating Defect, Pipe Damage, Corrosion and Pitting Measurements and Location (from Grid Sketch)", "Cause of Corrosion:", "labelException = Anomaly:  Coating Defect,");
            FindTextField("Cause of Corrosion:", "All external corrosion anomalies shall be identified and quantified below", "");
            FindTextField("sketch in Section 6 of this inspection report.", "Ultrasonic Thickness Testing", "colNum = 8, manualHeader");
            SectionMarker(5);
            FindTextField("Ultrasonic Thickness Testing", "Culture Results", "colNum = 5");
            SectionMarker(6);
            FindTextField("Location of samples", "Collected by", "");
            FindTextField("Collected by", "Date collected", "");
            FindTextField("Date collected", "7th day Interpreted by", "");
            FindTextField("7th day Interpreted by", "Date of reading", "");
            FindTextField("Date of reading", "14th day Interpreted by", "");
            FindTextField("14th day Interpreted by", "Date of reading", "");
            FindTextField("Date of reading", "Cap Color", "");
            FindTextField("Cap Color", "Aerobic Bacteria (AERO)", "isHeader");
            FindTextField("A positive reaction indicated by cloudy appearance or formation of slime which appears as sheets or clumps of material.", "Acid Producing Bacteria (APB)", "TableTitle = AERO");
            FindTextField("A positive reaction will turn media from red to cloudy orange or cloudy yellow.", "Sulfate Reducing Bacteria (SRB)", "TableTitle = APB");
            FindTextField("gray flecks does not constitute a positive reaction.", "Iron Related Bacteria (IRB)", "TableTitle = SRB");
            FindTextField("Deposits may be rust, white, black, or green.  A cloudy appearance or slime DO NOT constitute a positive reaction.", "Low-Nutrient Bacteria (LNB)", "TableTitle = IRB");
            FindTextField("A positive reaction results in a cloudy appearance or the formation of slime, which appears as sheets or clumps.", "Inspector's Comments:", "TableTitle = LNB");
            SectionMarker(7);
            FindTextField("Inspector's Comments:", "Remediation Action Performed", "");
            SectionMarker(8);
            FindTextField("Remediation Action Performed", "Reference Work Request No.", "");
            FindTextField("Reference Work Request No.", "Remediation Comments:", "");
            FindTextField("Remediation Comments:", "ANOMALY SKETCH", "");
            SectionMarker(9);
            SectionMarker(10);
            
        }
        
        if(version == 2){
            //always put at least end of the label and start of end string 
            SectionMarker(0);
            FindTextField("This form is used", "DE Location ID", "");
            SectionMarker(1);
            FindTextField("DE Location ID", "HCA#", "");
            FindTextField("HCA#", "Examination Number", "");
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
            FindTextField("GPS File Name", "ECDA Region", "");
            FindTextField("ECDA Region", "Planned Examination Length", "");
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
            FindTextField("Soil Type:", "Pipe Data (as found in EMRS):", "");
            FindTextField("Nominal Size", "InDiam", "");
            FindTextField("InDiam", "Wthick", "");
            FindTextField("Wthick", "Grade", "");
            FindTextField("Grade", "Yield", "");
            FindTextField("Yield", "Coating", "");
            FindTextField("Coating", "WkReqNo", "");
            FindTextField("WkReqNo", "Installation Month", "");
            FindTextField("Installation Month", "Installation Year", "");
            FindTextField("Installation Year", "OpsSysName", "");
            FindTextField("OpsSysName", "Weld Seam:", "");
            FindTextField("Weld Seam:", "Coating Types:", "");
            FindTextField("Coating Types:", "Coating Condition:", "");
            FindTextField("Coating Condition:", "Type of Coating Damage", "");
            FindTextField("Type of Coating Damage", "Holiday Detection Volt Setting", "exception tableTextHeader");
            FindTextField("Holiday Detection Volt Setting", "Non-Corrosive Disbondment", "");
            FindTextField("Non-Corrosive Disbondment", "Blistering Due to Corrosion", "tableTexBody");
            FindTextField("Blistering Due to Corrosion", "pH of Fluid in Blisters", "tableTexBody");
            FindTextField("pH of Fluid in Blisters", "I have reviewed", "");
            FindTextField("I have reviewed the procedures performed and have found them:", "*If Inadequate, send comments", "");
            FindTextField("Inspected By", "Inspection Date", "");
            FindTextField("Inspection Date", "Print and sign", "");
            FindTextField("Reviewed By", "Date Reviewed", "");
            FindTextField("Date Reviewed", "Print and sign", "");
            SectionMarker(3);
            FindTextField("Soil pH at Pipe Depth", "(using Antimony half cell)", "");
            FindTextField("Soil Resistivity at Pipe Depth", "cm", ""); //strange char
            FindTextField("Soil Chemistry Performed", "Method used", "");
            FindTextField("Method used -", "Results:", "");
            FindTextField("Chlorides", "ppm", "");
            FindTextField("Nitrates", "ppm", "");
            FindTextField("Sulfates", "ppm", "");
            FindTextField("Pipe to Soil from Start of Excavation: 12 O'clock", "3 O'clock", "");
            FindTextField("3 O'clock", "6 O'clock", "labelException = Pipe to Soil from Start of Excavation: 3 o'clock,");
            FindTextField("6 O'clock", "9 O'clock", "labelException = Pipe to Soil from Start of Excavation: 6 o'clock,");
            FindTextField("9 O'clock", "Bacterial Samples Taken", "labelException = Pipe to Soil from Start of Excavation: 9 o'clock,");
            FindTextField("Bacterial Samples Taken", "Date of Incubation", "");
            FindTextField("Date of Incubation", "Bacterial Results:", "");
            SectionMarker(4);
            FindTextField("Anomaly:  Coating Defect, Pipe Damage, Corrosion and Pitting Measurements and Location (from Grid Sketch)", "Cause of Corrosion:", "labelException = Anomaly:  Coating Defect,");
            FindTextField("Cause of Corrosion:", "All external corrosion anomalies shall be identified and quantified below", "");
            FindTextField("sketch in Section 6 of this inspection report.", "Ultrasonic Thickness Testing", "colNum = 8, manualHeader");
            SectionMarker(5);
            FindTextField("Ultrasonic Thickness Testing", "ANOMALY SKETCH", "colNum = 5");
            SectionMarker(6);
            //FindTextField("", "", "");    //reserved for the table section 6 V2
            FindTextField("Indicate units of measure:", "Inspector's Comments:", "");
            SectionMarker(7);
            FindTextField("Inspector's Comments:", "Take a minimum of two photos and attach or embed in this report.", "");
            SectionMarker(8);
            
        }
        //FindTextField("", "", "");
        
        PopulatePOJOAlpha();
        DynamicPopulatePOJO pojoPop = new DynamicPopulatePOJO(ListOfPOJO_Rows, ValueBeforePOJO, version);
                
    }

    /**
     * trap the data between the 2 strings. the comment can be used to handle the exceptions
     * a list of them can be given as the following:
     * comments include: "colNum = x" (x is a int),  "rolNum = x" (x is a int),
     * "headContent = [x], [y], [z], .... (x,y,z are strings), "isHeader", "TableTitle = x (x is a string)
     * "manualHeader", "labelException = x" (x is a string), "tableTexBody", "CheckBoxConflict", "exception tableTextHeader"
     * @param StartString from this word
     * @param StopString to this other word
     * @param comment or exception
     * @return 
     */
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
            
            if(comment.contains("labelException")){
                label = TempLab;
            }
            
            String ValType = DetermineTypeOfValue(value, comment).toLowerCase();
            
            //this first if is a huge exception only for the first version ...
            if(comment.equals("2DimVersion1Expection")){
                process2DimVersion1Expection(StartString, value);
            }
            else if(comment.equals("CheckBoxConflict")){
                tempCheckException.clear();
                tempCheckException.add(StartString);
                String temp = FindCheckValue(value);
                tempCheckException.add(temp);
            }
            else if(comment.equals("exception tableTextHeader")){
                processInTextTableHeader(value);
            }
            else if(comment.contains("tableTexBody")){
                processInTextBody(value, StartString);
            }
            else if(comment.equals("SkipFirstTableHeader")){
                setHeadOfTable(value);
            }
            else if(ValType.contains("table header")){
                setHeadOfTable(value, StartString);
            }
            else if(ValType.contains("checkbox")){
                value = FindCheckValue(value);
            }
            else if(ValType.contains("table")){
                
                TableType = DetermineTypeOfTable(value).toLowerCase();
                if(comment.equals("SpecialTableForcing")){
                    TableType = "Special!";
                }

                if(TableType.equals("Special!")){
                    processSpecialTable(value);
                }
                else if(TableType.contains("horizontal")){
                    processHorizontalTable(value);
                }
                else if(TableType.contains("vertical")){
                    processVerticalTable(value, comment);
                }
                else if(TableType.contains("no label")){
                    processNoLabTable(value);
                }
            }
            if(!ValType.contains("table") && !isHeader && !comment.contains("tableText")            //simplify this
                    && !comment.contains("tableTexBody") && !comment.equals("CheckBoxConflict")
                    && !comment.equals("SkipFirstTableHeader") && !comment.equals("2DimVersion1Expection")){
                
                value = displayCleanUp(value, ValType);
                
                DisplayInfo(label, value);
            }
            return 1;
        }
            
        return 0;
    }

    private void DisplayInfo(String label, String value) {
        
        System.out.print(label + " = " + value);
        labelBeforePOJO.add(label);
        ValueBeforePOJO.add(value);
        sectionBeforePOJO.add(section);
        System.out.println("");
        
    }

    private void SectionMarker(int sectionNum) {
        System.out.println("Section" + sectionNum + "-----------------------------------------------");   
        section = sectionNum;
    }

    private String DetermineTypeOfValue(String value, String comment) {
        
        
        boolean IsCheckBox = false;
        boolean IsTable = false;
        //by default the type is either text field or drop down
        //the reason why we don't make the difference between drop down and textfield
        //is that they are both processed the exact same way
        String Type = "text field or drop down";
        
        IsCheckBox = DetermineCheck(value);
        IsTable = DetermineTable(value, comment);
        
        if(comment.equals("SkipFirstTableHeader")){
            Type = "table header(skip 1)";
        }
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
            System.out.println("Unable to find the labls");
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
            System.out.println("Unable to find the labls");
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

    private boolean DetermineTable(String value, String comment) {
        
        boolean IsTable = false;
        
        int cnt =0;
        for(int i = 0; i < value.length()-1; i++){
            if(value.charAt(i) == '\n' && value.charAt(i+1) != '\n' ){
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
            System.out.println("Unable to find the labls");
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
            System.out.println("Unable to find the labls");
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
                
        int rowNum = 0;
        String temp = "";
        int j =0;
        for(int i = 0; i< POIValue.length()-1; i++){
            if(POIValue.charAt(i) == '\n' && isLetter(POIValue.charAt(i+1)) ){
                while(POIValue.charAt(i+1) != '\t' && POIValue.charAt(i+1) != ' ' && POIValue.charAt(i+2) != ' '){
                    temp = temp + POIValue.charAt(i+1);
                    i++;
                    j = 0;
                }
                rowLabels.add(temp);    //has all the labels
                temp = "";
                if(!temp.equals("") && !temp.equals(" "))
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
                        labelBeforePOJO.add(rowLabels.get(i) + cntTemp);
                        ValueBeforePOJO.add(temp);
                        sectionBeforePOJO.add(section);
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

    private void processVerticalTable(String value, String comment) {
        
        ArrayList<String> VerticalLabels = new ArrayList<>();
        String temp = "";
        int index = 0, j =0, dataCnt = 0;
        for(int i =0;i<value.length(); i++){
            if(index < ManualColNum && comment.contains("manualHeader")){
                if(value.charAt(i) != '\n'){
                    temp = temp + value.charAt(i);

                }
                //include the content between ('s in the label
                else if(value.charAt(i+1) == '('){
                    while(value.charAt(i) != ')'){
                        if(value.charAt(i) != '\n')
                            temp = temp + value.charAt(i);
                        i++;
                    }
                    temp = temp + ')';
                }
                else if(temp.equals("distance from ") || temp.equals("o'clock ") || temp.equals("longitudinal ")
                       || temp.equals("maximum ") || temp.equals("remaining wall ") ){
                    //skip it
                }
                else if(!temp.equals(" ") && !temp.equals("") && !temp.equals("  ")){
                    VerticalLabels.add(temp);
                    temp = "";
                    index++;
                }
            }
            else if(index < ManualColNum){
                if(value.charAt(i) != '\n'){
                    temp = temp + value.charAt(i);

                }
                else if(temp.contains("(inch")){
                    VerticalLabels.add(temp);
                    temp = "";
                    index++;
                }
                //include the content between ('s in the label
                else if(value.charAt(i+1) == '('){
                    while(value.charAt(i) != ')'){
                        if(value.charAt(i) != '\n')
                            temp = temp + value.charAt(i);
                        i++;
                    }
                    temp = temp + ')';
                }
                else if(!temp.equals(" ") && !temp.equals("") && !temp.equals("  ")){
                    VerticalLabels.add(temp);
                    temp = "";
                    index++;
                }
        }
        else{
            if(value.charAt(i) != '\n'){
                temp = temp + value.charAt(i);

            }
            else if(temp != " " && temp != "" && temp != "  "){
                    System.out.println(VerticalLabels.get(j) + dataCnt + " = " + temp);
                    labelBeforePOJO.add(VerticalLabels.get(j) + dataCnt);
                    ValueBeforePOJO.add(temp);
                    sectionBeforePOJO.add(section);
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
        else if(comment.contains("labelException")){
                TempLab = comment.substring(comment.indexOf(" = ") + 3, comment.indexOf(","));
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
                if(temp.equals("results")){         //exception ... a better way?
                    temp = temp + " ";
                    i++;
                }
                if(temp.equals("a") || temp.equals(" ") ){  //exceptions
                    temp = "";
                    i++;
                }
            }
            else if(!temp.equals(" ") && !temp.equals("") ) {
                headContent.add(temp);
                temp = "";

            }
        }
        
    }
    
    private void setHeadOfTable(String value) {
        
        headContent.clear();
        String temp = "";
        for(int i=1; i < value.length(); i++){
            if(value.charAt(i) != '\n'){
                temp = temp + value.charAt(i);
                if(temp.equals("results")){         //exception ... a better way?
                    temp = temp + " ";
                    i++;
                }
                if(temp.equals("a") || temp.equals(" ") ){  //exceptions
                    temp = "";
                    i++;
                }
            }
            else if(!temp.equals(" ") && !temp.equals("") && value.charAt(i+1) != '(' ) {
                headContent.add(temp);
                temp = "";
            }
        }        
        
    }
    

    private void processNoLabTable(String value) {
                            
        String temp = "";
        int j =0, index = 0;
        System.out.println("tile = " + TableTitle);
        labelBeforePOJO.add("title");
        ValueBeforePOJO.add(TableTitle);
        sectionBeforePOJO.add(section);
        int k =0;
        for(int i=1; i<value.length(); i++){
            if(value.charAt(i) != '\n'){
                temp = temp + value.charAt(i);
            }
            else if(value.charAt(i) == '\n' && headContent.get(k).contains("cap color") && TableTitle.equals("ANA") ){
                k++;
                //do nothing
            }
            else{
                System.out.println(headContent.get(j) + "(" + index + ")" +" = " + temp);
                labelBeforePOJO.add(headContent.get(j) + "(" + index + ")");
                ValueBeforePOJO.add(temp);
                sectionBeforePOJO.add(section);
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

    private void extractImages(String src, int cnt) {
        
        try{

            FileInputStream fs=new FileInputStream(src);
            XWPFDocument docx=new XWPFDocument(fs);
            List<XWPFPictureData> piclist=docx.getAllPictures();
            Iterator<XWPFPictureData> iterator=piclist.iterator();
            int i=0;
            new File("C:\\Users\\KXK3\\Documents\\NetBeansProjects\\ParseSuite2\\ParseDocx\\build\\test\\unit\\results\\NewPicFolder"+cnt).mkdir();
            while(iterator.hasNext()){
                XWPFPictureData pic=iterator.next();
                byte[] bytepic=pic.getData();
                BufferedImage imag=ImageIO.read(new ByteArrayInputStream(bytepic));
                File CreatedImageFile = new File("C:\\Users\\KXK3\\Documents\\NetBeansProjects\\ParseSuite2\\ParseDocx\\build\\test\\unit\\results\\NewPicFolder"+cnt+"\\imagefromword"+i+".jpg");
                ImageIO.write(imag, "jpg", new File("C:\\Users\\KXK3\\Documents\\NetBeansProjects\\ParseSuite2\\ParseDocx\\build\\test\\unit\\results\\NewPicFolder"+cnt+"\\imagefromword"+i+".jpg"));
                i++;
                System.out.println("path to image " + i + " = " + CreatedImageFile.getAbsolutePath());
                labelBeforePOJO.add("path to image " + i);
                ValueBeforePOJO.add(CreatedImageFile.getAbsolutePath());
                sectionBeforePOJO.add(section);
            }
        }catch(Exception e){//I can handle the image advance conversion here?
            System.exit(-1);}
        
    }

    private void processInTextTableHeader(String value) {
        
        headContent.clear();
        String valueTok[] = value.split("\n");
        for(String str:valueTok){
            if(!str.equals("")){
                headContent.add(str);
            }
        }
        
    }

    private void processInTextBody(String value, String StartString) {
        
        String valueTok[] = value.split("\n");
        int i = 0;
        boolean IsCheckBox = false;
        for(String str:valueTok){
            //see if there is a checkbox value to save it for checkboxConflict
            IsCheckBox = DetermineCheck(str);           
            if(IsCheckBox){
                String temp = FindCheckValue(str);
                tempCheckException.add(temp);
            }
            
            if(!str.equals("") && i < headContent.size()){
                System.out.println(StartString + " " + headContent.get(i) + " = " + 
                        str);
                labelBeforePOJO.add(StartString + " " + headContent.get(i));
                ValueBeforePOJO.add(str);
                sectionBeforePOJO.add(section);
                i++;
            }
        }
                
    }

    private void DisplayCheckException() {
        
        String temp = tempCheckException.get(0) + " = ";
        String temp2 = "";
        for(int i = 1;i < tempCheckException.size(); i++){
            temp += tempCheckException.get(i);
        }
        String valueTok[] = temp.split("\\s+");
        
        System.out.println("");
        for(String str:valueTok){
            System.out.print(str + " ");
            if(tempCheckException.get(0).contains(str) || str.contains("=")){
                //do nothing
            }
            else{
                temp2 += (str + " ");
            }
        }
        System.out.println("");
        
        labelBeforePOJO.add(tempCheckException.get(0));     //flag
        ValueBeforePOJO.add(temp2);
        sectionBeforePOJO.add(section);
        
        
    }

    private void process2DimVersion1Expection(String StartString, String value) {
        
                String temp = "a\n";
                temp += StartString;
                temp += value;
                
                
                String lab0 = null, lab1 = null, lab2 = null;
                String val1 = null;
                for(int i = 0; i < 7; i++){
                    val1 = "";
                    if(i == 0){
                        lab0 = temp.substring(temp.indexOf("a"), temp.indexOf("inadequate cp current") + "inadequate cp current".length());
                        lab0 = lab0.replace("\n", " ");
                        temp = temp.substring(temp.indexOf("inadequate cp current") + "inadequate cp current".length());
                    }
                    else if(i == 1){
                        lab0 = temp.substring(temp.indexOf("b"), temp.indexOf("no cp for a known period of time") + "no cp for a known period of time".length());
                        lab0 = lab0.replace("\n", " ");
                        temp = temp.substring(temp.indexOf("no cp for a known period of time") + "no cp for a known period of time".length());
                        
                    }
                    else if(i == 2){
                        lab0 = temp.substring(temp.indexOf("c"), temp.indexOf("no cp with dissimilar metal couplings") + "no cp with dissimilar metal couplings".length());
                        lab0 = lab0.replace("\n", " ");
                        temp = temp.substring(temp.indexOf("no cp with dissimilar metal couplings") + "no cp with dissimilar metal couplings".length());
                    }
                    else if(i == 3){
                        lab0 = temp.substring(temp.indexOf("d"), temp.indexOf("previously unidentified source of interference") + "previously unidentified source of interference".length());
                        lab0 = lab0.replace("\n", " ");
                        temp = temp.substring(temp.indexOf("previously unidentified source of interference") + "previously unidentified source of interference".length());
                    }
                    else if(i == 4){
                        lab0 = temp.substring(temp.indexOf("e"), temp.indexOf("shielding occurred by disbonded coating") + "shielding occurred by disbonded coating".length());
                        lab0 = lab0.replace("\n", " ");
                        temp = temp.substring(temp.indexOf("shielding occurred by disbonded coating") + "shielding occurred by disbonded coating".length());
                    }
                    else if(i == 5){
                        lab0 = temp.substring(temp.indexOf("f"), temp.indexOf("mic or biological corrosion") + "mic or biological corrosion".length());
                        lab0 = lab0.replace("\n", " ");
                        temp = temp.substring(temp.indexOf("mic or biological corrosion") + "mic or biological corrosion".length());
                    }
                    else if(i == 6){
                        lab0 = temp.substring(temp.indexOf("g"), temp.indexOf("other (specify):") + "other (specify):".length());
                        lab0 = lab0.replace("\n", " ");
                        temp = temp.substring(temp.indexOf("other (specify):") + "other (specify):".length());
                    }
                    
                    lab1 = lab0 + headContent.get(1);
                    lab2 = lab0 + headContent.get(2);
                    temp = temp.substring(temp.indexOf("\n")+1);
                    while(!temp.startsWith("\n")){
                        val1 += temp.charAt(0);
                        temp = temp.substring(1);
                    }
                    val1 = val1.replace("null", "");
                    System.out.println(lab1 + " = " + val1);
                    labelBeforePOJO.add(lab1);
                    ValueBeforePOJO.add(val1);
                    sectionBeforePOJO.add(section);
                    temp = temp.substring(1);
                    val1 = "";
                    while(!temp.startsWith("\n")){
                        val1 += temp.charAt(0);
                        temp = temp.substring(1);
                    }
                    if(val1.contains("null"))
                        val1 = val1.replace("null", "");
                    System.out.println(lab2 + " = " + val1);
                    labelBeforePOJO.add(lab2);
                    ValueBeforePOJO.add(val1);
                    sectionBeforePOJO.add(section);
                    
                }       
    }

    /**
     * Populate the first POJO, this includes only the label, the value associated to the label
     * the section of label and version of the document 
     */
    private void PopulatePOJOAlpha() {
        ListOfPOJO_Rows.clear();
            for(int i=0; i< ValueBeforePOJO.size(); i++){
                ListOfPOJO_Rows.add(new ExtractPOJO());
                ListOfPOJO_Rows.get(i).setLabel(labelBeforePOJO.get(i));
                ListOfPOJO_Rows.get(i).setValue(ValueBeforePOJO.get(i));
                ListOfPOJO_Rows.get(i).setSection(sectionBeforePOJO.get(i));
                ListOfPOJO_Rows.get(i).setID(i);
                ListOfPOJO_Rows.get(i).setVersion(version);
            }        //looks like it is working !!!!!!
    }

    private void processSpecialTable(String value) {
        
        for(int i=0; i< 2; i++){
            
            int j =0;
            String first = value.substring(value.indexOf("number") + "number".length() , value.indexOf("type of defect"));
            value = value.substring(value.indexOf("number") + "number".length());
            String[] tok1 = first.split("\n");
            for(String str : tok1){
                System.out.println("number("+ j + "- " + i + ") = " + str);
                labelBeforePOJO.add("number("+ j + ")");
                ValueBeforePOJO.add(str);
                sectionBeforePOJO.add(section);
                j++;
            }
            j= 0;
            String second = value.substring(value.indexOf("coating)") + "coating)".length() , value.indexOf("distance from zero point"));
            value = value.substring(value.indexOf("coating") + "coating".length());
            String[] tok2 = second.split("\n");
            for(String str : tok2){
                System.out.println("type of defect("+ j + "- " + i + ") = " + str);
                labelBeforePOJO.add("type of defect("+ j + ")");
                ValueBeforePOJO.add(str);
                sectionBeforePOJO.add(section);
                j++;
            }
            j =0;
            String third = value.substring(value.indexOf("distance from zero point (feet)") + "distance from zero point (feet)".length() , value.indexOf("o'clock position"));
            value = value.substring(value.indexOf("distance from zero point (feet)") + "distance from zero point (feet)".length());
            String[] tok3 = third.split("\n");
            for(String str : tok3){
                System.out.println("distance from zero point defect("+ j + "- " + i + ") = " + str);
                labelBeforePOJO.add("distance from zero point defect("+ j + ")");
                ValueBeforePOJO.add(str);
                sectionBeforePOJO.add(section);
                j++;
            }
            j =0;
            String fourth = value.substring(value.indexOf("o'clock position") + "o'clock position".length() , value.indexOf("length (axial) (inch)"));
            value = value.substring(value.indexOf("o'clock position") + "o'clock position".length());
            String[] tok4 = fourth.split("\n");
            for(String str : tok4){
                System.out.println("o'clock position defect("+ j + "- " + i + ") = " + str);
                labelBeforePOJO.add("o'clock position defect("+ j + ")");
                ValueBeforePOJO.add(str);
                sectionBeforePOJO.add(section);
                j++;
            }
            j =0;
            String fifth = value.substring(value.indexOf("length (axial) (inch)") + "length (axial) (inch)".length() , value.indexOf("length (circumferential) (inch)"));
            value = value.substring(value.indexOf("length (axial) (inch)") + "length (axial) (inch)".length());
            String[] tok5 = fifth.split("\n");
            for(String str : tok5){
                System.out.println("length axe defect("+ j + "- " + i + ") = " + str);
                labelBeforePOJO.add("length axe defect("+ j + ")");
                ValueBeforePOJO.add(str);
                sectionBeforePOJO.add(section);
                j++;
            }
            j =0;
            String six = value.substring(value.indexOf("length (circumferential) (inch)") + "length (circumferential) (inch)".length() , value.indexOf("maximum depth (inch)"));
            value = value.substring(value.indexOf("length (circumferential) (inch)") + "length (circumferential) (inch)".length());
            String[] tok6 = six.split("\n");
            for(String str : tok6){
                System.out.println("length circ defect("+ j + "- " + i + ") = " + str);
                labelBeforePOJO.add("length circ defect("+ j + ")");
                ValueBeforePOJO.add(str);
                sectionBeforePOJO.add(section);
                j++;
            }
            j =0;
            String seven = value.substring(value.indexOf("maximum depth (inch)") + "maximum depth (inch)".length() , value.indexOf("repair category *".toLowerCase()));
            value = value.substring(value.indexOf("maximum depth (inch)") + "maximum depth (inch)".length());
            String[] tok7 = seven.split("\n");
            for(String str : tok7){
                System.out.println("maximum depth("+ j + "- " + i + ") = " + str);
                labelBeforePOJO.add("maximum depth("+ j + ")");
                ValueBeforePOJO.add(str);
                sectionBeforePOJO.add(section);
                j++;
            }
            j =0;
            String eight = value.substring(value.indexOf("repair category *") + "repair category *".length() , value.indexOf("Corrosion Interactivity".toLowerCase()));
            value = value.substring(value.indexOf("repair category *") + "repair category *".length());
            String[] tok8 = eight.split("\n");
            for(String str : tok8){
                System.out.println("repair category("+ j + "- " + i + ") = " + str);
                labelBeforePOJO.add("repair category("+ j + ")");
                ValueBeforePOJO.add(str);
                sectionBeforePOJO.add(section);
                j++;
            }
            j =0;
            String nine = null;
            if(i == 0){
                nine = value.substring(value.indexOf("corrosion interactivity") + "corrosion interactivity".length() , value.indexOf("Number".toLowerCase()));
            }
            else if(i == 1){
                nine = value.substring(value.indexOf("corrosion interactivity") + "corrosion interactivity".length() , value.indexOf("*".toLowerCase()));
            }
            value = value.substring(value.indexOf("corrosion interactivity") + "corrosion interactivity".length());

            String[] tok9 = nine.split("\n");
            for(String str : tok9){
                System.out.println("corrosion interactivity("+ j + "- " + i + ") = " + str);
                labelBeforePOJO.add("corrosion interactivity("+ j + ")");
                ValueBeforePOJO.add(str);
                sectionBeforePOJO.add(section);
                j++;
            }
            
        }
    }

    private String displayCleanUp(String value, String ValType) {
        
        if(value.contains("0  n/a") && ValType.contains("text field")){
            value = value.replace("0  n/a", "");
        }
        if(value.contains("1  n/a") && ValType.contains("text field")){
            value = value.replace("1  n/a", "");
        }
        String valueTok[] = value.split("\\s+");
        StringBuilder builder = new StringBuilder();
        for (String str : valueTok) {
            builder.append(str).append(" ");
        }
        value = builder.toString();
        if(value.contains("section")){
            value = value.replace(value.subSequence(value.indexOf("section"), value.indexOf("section") + "section".length() + 2), "");                    
        }
        return value;
    }
    
}
