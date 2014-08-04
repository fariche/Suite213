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
    private int lineCounter;

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

//         lookForUntil("DE Location ID", "HCA");
//         lookForUntil("Name", "xamination");
//         lookForUntil("xamination", "Work Request No.");
//         lookForUntil("Work Request No.", "Division");
//         lookForCombo("Division");
//         lookForUntil("District Number", "Town or County");
//         lookForUntil("Town or County", "State");
//         lookForCombo("State");
//         lookForUntil("ile Number", "Address and/or Location");
//         lookForUntil("Address and/or Location", "nspection Company");
//         lookForUntil("nspection Company", "Date GPS Synchronized");
//         lookForUntil("Date GPS Synchronized", "Field Location (from Top of Pipe)");
//         lookForGps("Start GPS X", "GPS File Name");
//         lookForUntil("GPS File Name", "Region");
//         lookForCombo("Region");
//         lookForUntil("Planned Examination Length", "Actual Examination Length");
//         lookForUntil("Actual Examination Length", "Section 2");
//         lookForCheck("oreign Pipe in Excavation", "Size");
        lookForUntil("Size", "Material");
//         lookForUntil("Material", "Foreign Current");
//         lookForCheck("Foreign Current", "ond Present");
//         lookForCheck("ond Present", "If");
//         lookForCheck("To", "CP Present");
//         lookForCheck("CP Present", "Anode Present");
//         lookForCheck("Anode Present", "nvironmental Conditions:");
//         lookForUntil("Temp", "Time");
//         lookForUntil("Time", "Weather Conditions");
//         lookForUntil("Weather Conditions", "oil Conditions:");
//         lookForCheck("oil Conditions", "Bedding/Shading Type");
//         lookForUntil("Bedding/Shading Type", "Rockshield Used");
//         lookForCheck("Rockshield Used", "Soil Type:");

//        lookForCheck("Soil Type", "Depth of Cover");
//        lookForUntil("Depth of Cover", "Pipe Data (as found in EMRS):");
        lookForUntil("Size", "InDiam");
//        lookForUntil("InDiam", "Wthick");
//        lookForUntil("Wthick", "Grade");
//        lookForUntil("Grade", "Yield");
//        lookForUntil("Yield", "WkReqNo");
//        lookForUntil("WkReqNo", "Installation Month");
//        lookForUntil("Installation Month", "Installation Year");
//        lookForUntil("Installation Year", "OpsSysName");
    }

    private void lookForGps(String lab1, String lab2) {
        String name = findName(lab1);
        List<String> val = new ArrayList<String>();
        String nextLine;
        int lineCounter = nameLine;
        do {
            nextLine = extractData.get(++lineCounter).get(1).trim();
            val.add(nextLine);
        } while (!nextLine.equalsIgnoreCase(lab2));

        props.put(df.format(propCounter) + "_" + "Start GPS X", val.get(0));
        propCounter++;
        props.put(df.format(propCounter) + "_" + "Start GPS Y", val.get(1));
        propCounter++;
        props.put(df.format(propCounter) + "_" + "End GPS X", val.get(3));
        propCounter++;
        props.put(df.format(propCounter) + "_" + "End GPS Y", val.get(4));
        propCounter++;
    }

    private void lookForUntil(String lab1, String lab2) {
        String name = findName(lab1);
        String val = "";
        String nextLine;
        int lineCounter = nameLine;
        do {
            nextLine = extractData.get(++lineCounter).get(1).trim();
            if (!nextLine.equalsIgnoreCase(lab2)) {
                val = val + nextLine;
            }
        } while (!nextLine.equalsIgnoreCase(lab2));
        processDisplayName(name.trim(), val);
    }

//    private void lookFor(int offset, int add, String... args) {
//        String name = findName(args);
//        // find the last arg and do an offset
//        int lineCounter = -1;
//        for (List<String> data : extractData) {
//            data = cleanUpData(data);
//            lineCounter++;
//            if (data.contains(args[args.length - 1])) {
//                String value = extractData.get(lineCounter + offset).get(1).trim();
//                for (int j = 0; j < add; j++) {
//                    value = value + extractData.get(lineCounter + offset + add).get(1).trim();
//                }
//                processDisplayName(name.trim(), value);
//            }
//        }
//    }
    private void lookForCheck(String lab1, String lab2) {
        String name = findName(lab1);
        String val = "";
        String nextLine;
        boolean first = false;
        int lineCounter = nameLine;
        do {
            nextLine = extractData.get(++lineCounter).get(1).trim();
            if (extractData.get(lineCounter).get(2).contains("<w:checked/>")) {
                if (first) {
                    val = val + "," + extractData.get(lineCounter).get(5);
                } else {
                    val = val + extractData.get(lineCounter).get(5);
                }
                first = true;
            }
        } while (!nextLine.equalsIgnoreCase(lab2));
        processDisplayName(name.trim(), val);
    }

    private void lookForCombo(String... args) {
        String name = findName(args);
        String value = "";
        for (int i = 0; i < args.length; i++) {
            List<String> tags = extractData.get(++lineCounter);
            if (tags.get(1).contains("<w:wResult")) {
                comboIndex = true;
                value = getListEntryValue(tags);
            } else {
                value = getListEntryValue(tags);
            }
            processDisplayName(name.trim(), value);
        }
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
            int begin = temp.length() + 1;
            int end = item.length() - 1;
            value = item.substring(begin, end);
            return value;
        }
    }

    private void processDisplayName(String name, String value) {
        name = name.trim().replace(" ", "_");
        if (xmlProps.containsKey(name)) {
            String displayValue = xmlProps.getProperty(name).replace(" ", "_");
            props.put(df.format(propCounter) + "_" + displayValue, value);
            propCounter++;
        } else {
            props.put(df.format(propCounter) + "_" + name.trim().replace(" ", "_"), value);
            propCounter++;
        }
    }

    private List<String> cleanUpData(List<String> data) {
        List<String> clean = new ArrayList<String>();
        for (String d : data) {
            d = d.replace(":", "");
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
        lineCounter = -1;
        nameLine = -1;
        for (List<String> data : extractData) {
            data = cleanUpData(data);
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
        lineCounter = -1;
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
