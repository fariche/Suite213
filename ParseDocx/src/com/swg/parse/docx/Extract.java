/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swg.parse.docx;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Hashtable;
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

    private int propCounter;
    //private int lineCounter;

    private boolean comboIndex;
    private boolean checked;
    private int gpsYcounter;
    private int multiNameCounter;

    private Map<String, Integer> usedNames = new Hashtable<String, Integer>();

    private int nameLine;

    private DecimalFormat df = new DecimalFormat("0000");

    public Extract() {
        try {
            xmlProps.load(Extract.class.getResourceAsStream("xmlMap.properties"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void extract(List<List<String>> data) {
        extractData = data;

        /*
         lookForUntil("DE Location ID", "HCA");
         lookForUntil("Name", "xamination");
         lookForUntil("xamination", "Work Request No.");
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
         */
        lookForCheck("Ground Cover Found:", "on-C"); // Fix this
         /*
         lookForUntil("listers", "I have reviewed the procedures performed and have found them:");
         //lookForCheck("I have reviewed the procedures performed and have found them", "*If Inadequate, send comments and copy of WMS-WR to Engineering and Project Support Staff, LVA-581");//Fix this
         lookForUntil("Inspected By", "Inspection Date");
         //lookForUntil("Inspected Date", "Print"); //Fix this
         lookForUntil("Reviewed By", "Date Reviewed");
         lookForUntil("Date Reviewed", "Print");
         lookForUntil("Soil pH at Pipe Depth","(using Antimony half cell)");
         lookForUntil("Soil Resistivity at Pipe Depth","cm");
         lookForCheck("Soil Chemistry Performed", "Method used -");
         lookForUntil("Chlorides","ppm");
         lookForUntil("Nitrates","ppm");
         lookForUntil("Sulfates","ppm");
         lookForUntil("O’clock","Bacterial Samples Taken");
         lookForCheck("Bacterial Samples Taken","If yes, see Section 6");
         lookForCheck("Asphalt and/or Tar Wrap samples taken","Section 4");
         //lookForCheck("Defects:"," All external");//Fix this
         //lookForCombo("Coating");//Fix this
         lookForUntil("Distance from Zero Point (feet)","O’clock Position");
         lookForUntil("O’clock Position","Length (Axial) (inch)");
         lookForUntil("Length (Axial) (inch)","Length (Circumferential) (inch)");
         lookForUntil("Length (Circumferential) (inch)","Maximum Depth (inch)");
         lookForUntil("Maximum Depth (inch)","Repair Category");
         
         /* Fix below
         lookFor("Number");
         lookForNext("Num 1");
         lookForNext("Num 2");
         lookForNext("Num 3");
         lookForNext("Num 4");
         lookForNext("Num 5");
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
         lookForUntil("ICDA Scrub #1: Min", "Max");
         lookForUntil("Max", "WT ∆%");
         lookForUntil("ICDA Scrub #2: Min", "Max");
         */
    }

    private void lookForGps(String lab1, String lab2) {
        String name = findName(lab1);
        if (name.equalsIgnoreCase("")) {
            System.out.println("*** Cannot find name: " + lab1);
            return;
        }
        List<String> val = new ArrayList<String>();
        String nextLine;
        int lineCounter = nameLine;
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
        String name = findName(lab1);
        if (name.equalsIgnoreCase("")) {
            System.out.println("*** Cannot find name: " + lab1);
            return;
        }
        String val = "";
        String nextLine = "";
        int lineCounter = nameLine;
        do {
            nextLine = extractData.get(++lineCounter).get(1).trim();
            if (!nextLine.equalsIgnoreCase(lab2)) {
                val = val + nextLine;
            }
        } while (!nextLine.equalsIgnoreCase(lab2));
        processDisplayName(name.trim(), val);
    }

    private void lookForCheck(String lab1, String lab2) {
        String name = findName(lab1);
        if (name.equalsIgnoreCase("")) {
            System.out.println("*** Cannot find name: " + lab1);
            return;
        }
        String val = "";
        String nextLine;
        boolean first = false;
        int lineCounter = nameLine;
        if (name.equalsIgnoreCase("Ground Cover Found:")) {
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
            } while (!nextLine.equalsIgnoreCase(lab2));
        }
        processDisplayName(name.trim(), val);
    }

    private void lookForCombo(String lab1) {
        String name = findName(lab1);
        int lineCounter = nameLine;
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
        int lineCounter = nameLine;
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
        int lineCounter = nameLine;
        String value = "";
        List<String> tags = extractData.get(++lineCounter);
        value = tags.get(3);
        processDisplayName(name.trim(), value);
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
        // exception
        if (value.equalsIgnoreCase("No      % consumed")) {
            value = "No";
        }
        // exception
        if (name.trim().contains("clock")) {
            name = "6 O'clock";
        }
        // exception
        if (name.trim().contains("Coating)")) {
            name = "Type of Defect";
        }
//        // exception
//        if (name.trim().contains("oil Conditions:")) {
//            name = "Soil Conditions";
//        }
//        // exception
//        if (name.trim().contains("Weld Seam:")) {
//            name = "Weld Seam";
//        }
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
        Set<String> keys = this.usedNames.keySet();
        // build up the label
        int localCounter = 0;
        String name = "";
        int lineCounter = -1;
        nameLine = -1;
        for (List<String> data : extractData) {
            data = cleanUpData(data);
//            System.out.println("*** Looking for:" + data);
            lineCounter++;
            nameLine++;
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
