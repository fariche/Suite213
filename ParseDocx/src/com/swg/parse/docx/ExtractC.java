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
public class ExtractC {

    public static Properties props = new Properties();
    private static List<List<String>> extractData;
    private static Properties xmlProps = new Properties();
    private static List<String> repeats = new ArrayList();

    private int propCounter;
    //private int lineCounter;

    private boolean comboIndex;
    private boolean checked;
    private int gpsYcounter;
    private int multiNameCounter;

    private Map<String, Integer> usedNames = new HashMap<String, Integer>();

    private int startLine, endLine;

    private DecimalFormat df = new DecimalFormat("0000");

    public ExtractC() {
        try {
            xmlProps.load(ExtractC.class.getResourceAsStream("xmlMap.properties"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void extract(List<List<String>> data) {
        extractData = data;

        label("#   Section 1                                                 #");
        lookForUntil("DE Location ID", "HCA");
        lookForUntil("Name", "xamination");
        lookForUntil("Number", "Work Request No.");
        lookForUntil("Work Request No.", "Division");
        lookForCombo("Division");
        lookForUntil("District Number", "Town or County");
        lookForUntil("Town or County", "State");
        lookForCombo("State");
        lookForUntil("ile Number", "Address and/or Location");
        lookForUntil("Address and/or Location", "nspection Company");
        lookForUntil("nspection Company", "Date GPS Synchronized");
        lookForUntil("Date GPS Synchronized", "Field Location (from Top of Pipe)");
        lookForGps("Start: GPS X", "GPS File Name");
        lookForUntil("GPS File Name", "Region");
        lookForCombo("Region");
        lookForUntil("Planned Examination Length", "Actual Examination Length");
        lookForUntil("Actual Examination Length", "Section 2");

        label("#   Section 2                                                 #");
        lookForCheck("oreign Pipe in Excavation", "Size");
        lookForUntil("Size", "Material");
        lookForUntil("Material", "Foreign Current");
        lookForCheck("Foreign Current", "ond Present");
        lookForCheck("ond Present", "If");
        lookForCheck("To:", "CP Present");
        lookForCheck("CP Present", "Anode Present");
        lookForCheck("Anode Present", "nvironmental Conditions:");
        lookForUntil("Temp", "Time");
        lookForUntil("Time", "Weather Conditions");
        lookForUntil("Weather Conditions", "oil Conditions:");
        lookForCheck("oil Conditions:", "Bedding/Shading Type");
        lookForUntil("Bedding/Shading Type", "Rockshield Used");
        lookForCheck("Rockshield Used", "Soil Type:");
        lookForCheck("Soil Type:", "Depth of Cover");
        lookForUntil("Depth of Cover", "Pipe Data (as found in EMRS):");
        lookForUntil("Size", "InDiam");
        lookForUntil("InDiam", "Wthick");
        lookForUntil("Wthick", "Grade");
        lookForUntil("Grade", "Yield");
        lookForUntil("Yield", "WkReqNo");
        lookForUntil("WkReqNo", "Installation Month");
        lookForUntil("Installation Month", "Installation Year");
        lookForUntil("Installation Year", "OpsSysName");
        lookForUntil("OpsSysName", "Weld Seam:");
        lookForCheck("Weld Seam:", "Coating Types:");
        lookForCheck("Coating Types:", "Coating Condition:");
        lookForCheck("Coating Condition:", "Holiday Detection Volt Setting");
        lookForUntil("Holiday Detection Volt Setting", "Type of Coating Damage");
        lookForCheck("Ground Cover Found:", "on-C"); // Fix this
        lookForUntil("listers", "I have reviewed the procedures performed and have found them:");
        lookForCheck("I have reviewed the procedures performed and have found them:", "*If Inadequate, send comments and copy of WMS-WR to Engineering and Project Support Staff, LVA-581");//Fix this
        lookForUntil("Inspected By", "Inspection Date");
        lookForUntil("Inspection Date", "Print"); //Fix this
        lookForUntil("Reviewed By", "Date Reviewed");
        lookForUntil("Date Reviewed", "Print");

        label("#   Section 3                                                 #");
        lookForUntil("Soil pH at Pipe Depth", "(using Antimony half cell)");
        lookForUntil("Soil Resistivity at Pipe Depth", "cm");
        lookForCheck("Soil Chemistry Performed", "Method used -");
        lookForUntil("Chlorides", "ppm");
        lookForUntil("Nitrates", "ppm");
        lookForUntil("Sulfates", "ppm");
        lookForUntil("O’clock", "Bacterial Samples Taken");
        lookForCheck("Bacterial Samples Taken", "If yes, see Section 6");
        lookForCheck("Asphalt and/or Tar Wrap samples taken", "Section 4");
        lookForCheck("Defects:", "All external");//Fix this
        //lookForCombo("Coating)");//Fix this

        // Add more
        lookForUntil("Distance from Zero Point (feet)", "O’clock Position");
        lookForUntil("O’clock Position", "Length (Axial) (inch)");
        lookForUntil("Length (Axial) (inch)", "Length (Circumferential) (inch)");
        lookForUntil("Length (Circumferential) (inch)", "Maximum Depth (inch)");
        lookForUntil("Maximum Depth (inch)", "Repair Category");

        label("#   Section 4                                                 #");
        // Fix below
        /*
         lookFor("Number");
         lookForNext("Num 1");
         lookForNext("Num 2");
         lookForNext("Num 3");
         lookForNext("Num 4");
         lookForNext("Num 5");
         */
        lookForCombo("Coating)");
        lookForNextCombo("Type of Defect 2");
        lookForNextCombo("Type of Defect 3");
        lookForNextCombo("Type of Defect 4");
        lookForNextCombo("Type of Defect 5");
        lookForCombo("Repair Category");
        lookForNextCombo("Repair Category 2");
        lookForNextCombo("Repair Category 3");
        lookForNextCombo("Repair Category 4");
        lookForNextCombo("Repair Category 5");
        lookForCombo("Corrosion Interactivity");
        lookForNextCombo("Corrosion Interactivity 2");
        lookForNextCombo("Corrosion Interactivity 3");
        lookForNextCombo("Corrosion Interactivity 4");
        lookForNextCombo("Corrosion Interactivity 5");

        // Section 5
        label("#   Section 5                                                 #");
        // Add more info here
        readTableInfo("Distance from Zero Point", "ICDA Scrub #1: Min"); //300-319
        //        lookForUntil("ICDA Scrub #1: Min", "Max");
        //        lookForUntil("Max", "WT ∆%");
        //        lookForUntil("ICDA Scrub #2: Min", "Max");
        //        lookForUntil("Max", "WT ∆%");
        lookForUntil("ICDA Scrub #1: Min", "ICDA Scrub #2: Min");
        lookForUntil("ICDA Scrub #2: Min", "Comments:");
        lookForUntil("Comments:", "Section");
        lookForUntil("amples", "Collected b");
        lookForUntil("Collected b", "Date c");
        lookForUntil("ollected", "th");
        lookForUntil("Interpreted by", "Date of reading");
        lookForUntil("Date of reading", "14");
        lookForUntil("14", "Date of reading");
        lookForUntil("Date of reading", "Cap Color");

        label("#   Section 6                                                 #");
        // need new code for tables
        label("#   Section 7                                                 #");
        lookForCheck("ty of Coating Anomaly Suspected", " . Severity of Coating Anomaly Found");//401-406
        lookForCheck(" . Severity of Coating Anomaly Found", "2b");//406-411
        lookForCheck("ipe", " . Severity of the coating anomaly found was");//415-420
        lookForCheck("severe than originally prioritized?", " . Is this the initial assessment of this covered segment?");//423-426
        lookForCheck(" . Is this the initial assessment of this covered segment?", " . If both 3a");
        lookForCheck(" . If both 3a", " . Was corrosion found?");//429-435
        lookForCheck(" . Was corrosion found?", " . Was this a B or C priority in which the corrosion found was deeper than 20% of the original wall thickness?");
        lookForCheck(" . Was this a B or C priority in which the corrosion found was deeper than 20% of the original wall thickness?", " . Was this corrosion deeper or more severe than corrosion found on any A-priority examination in this same region?");
        lookForCheck(" . Was this corrosion deeper or more severe than corrosion found on any A-priority examination in this same region", " OTE");
        lookForCheck(" assessed for adjustments?", " 10");//454-458
        lookForCheck(" . Were changes made to the", " f Yes, document on MOC.  If No, explain why not.");

        lookForCheck(" . Are additional indirect inspection surveys needed on this segment?", " 7B – Root Cause (based on data on");
        lookForCheck(" 1. Is the corrosion considered significant?", " Only if Yes, proceed to 2, otherwise go to");
        lookForCheck(" a. Was the review conducted?", "b.");//499-503
        lookForCheck("Do alternative methods need to be implemented?", "Field Work:");
        lookForCheck("4. For this HCA, has corrosion been found and a root cause determined at other locations?", " Only if Y");
        lookForCheck("5. For this HCA, are similar occurrences of the root cause being determined at other locations?", "7C - Remaining Strength Calculation");
        lookForCheck("Date calculation completed:", "Section");

        label("#   Section 8                                                 #");
        lookForUntil("nspector’s Comments", "Section");

        label("#   Section 9                                                 #");
        lookForCheck("Required?", " Reference Work Request No.");
        lookForUntil(" Reference Work Request No.", "Check one:");//535-536
        lookForCheck(" Repair was", " Remediation Comments:");
        lookForUntil(" Remediation Comments:", "Section");//535-536

        label("#   Section 10                                                #");
        label("#   Section 11                                                #");
    }

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

    private void lookForGps(String lab1, String lab2) {
        String name = findName(lab1);
        if (name.equalsIgnoreCase("")) {
            System.out.println("*** Cannot find name: " + lab1);
            return;
        }
        List<String> val = new ArrayList<String>();
        String nextLine;
        int lineCounter = startLine;
        do {
            nextLine = extractData.get(++lineCounter).get(1).trim();
            val.add(nextLine);
        } while (!nextLine.equalsIgnoreCase(lab2));

        props.put(df.format(propCounter++) + "_" + "Start_GPS_X", val.get(0));
        props.put(df.format(propCounter++) + "_" + "Start_GPS_Y", val.get(1));
        props.put(df.format(propCounter++) + "_" + "End_GPS_X", val.get(4));
        props.put(df.format(propCounter++) + "_" + "End_GPS_Y", val.get(5));
    }

    private void lookFor(String lab1) {
        findName(lab1);
    }

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
                        val = val + "|" + nextLine;
                    }
                }
            } while (!nextLine.equalsIgnoreCase(lab2));

            processDisplayName(name.trim(), val);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }

    private void lookForCheck(String lab1, String lab2) {
        try {
            String name = findName(lab1);
            if (name.equalsIgnoreCase("")) {
                System.out.println("*** Cannot find name: " + lab1);
                return;
            }
            String val = "";
            String nextLine;
            boolean first = false;
            int lineCounter = startLine;
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
                } while (!nextLine.equalsIgnoreCase(lab2));
            } else {
                do {
                    if (extractData.get(lineCounter).get(2).contains("<w:checked/>")) {
                        if (first) {
                            val = val + "," + extractData.get(lineCounter).get(5);
                        } else {
                            val = val + extractData.get(lineCounter).get(5);
                        }
                        first = true;
                    }
                    nextLine = extractData.get(++lineCounter).get(1).trim();
                } while (!nextLine.equalsIgnoreCase(lab2.trim()));
            }
            processDisplayName(name.trim(), val);
        } catch (java.lang.IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }

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

    private void label(String str) {
        processDisplayName(str, "");
    }

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

    private void processDisplayName(String name, String value) {
        if (value.equalsIgnoreCase("")) {
            value = "N/A";
        }
        // exception
        if (value.equalsIgnoreCase("No      % consumed")) {
            value = "No";
        }
        // exception
        if (name.trim().contains("Coating)")) {
            name = "Type of Defect";
        }
        // exception
        if (name.equalsIgnoreCase("Date of reading")) {
            if (repeats.contains("Date of reading")) {
                name = "14th " + name;
            } else {
                repeats.add("Date of reading");
                name = "7th " + name;
            }
        }
        // exception
        if (value.startsWith("th|day|Interpreted by|")) {
            value = value.substring(new String("th|day|Interpreted by|").length());
        }
        name = name.trim().replace(" ", "_");
        name = name.trim().replace(":", "");

        String displayName, displayValue = null;
        if (xmlProps.containsKey(value)) {
            displayValue = xmlProps.getProperty(value);
        } else {
            displayValue = value;
        }
        if (xmlProps.containsKey(name)) {
            displayName = xmlProps.getProperty(name).replace(" ", "_");
            props.put(df.format(propCounter) + "_" + displayName, displayValue);
            propCounter++;
        } else {
            props.put(df.format(propCounter) + "_" + name.trim().replace(" ", "_"), displayValue);
            propCounter++;
        }
    }

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

    private String findName(String args) {
        args = args.trim();
        Set<String> keys = this.usedNames.keySet();
        // build up the label
        int localCounter = 0;
        String name = "";
        int lineCounter = -1;
        startLine = -1;
        for (List<String> data : extractData) {
            data = cleanUpData(data);
            //            System.out.println("*** Looking for:" + data);
            lineCounter++;
            if (lineCounter == 406) {
                System.out.println("Stop");
            }
            startLine++;
            if (data.contains(args)) {
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

}
