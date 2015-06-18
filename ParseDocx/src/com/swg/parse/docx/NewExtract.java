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
    private static List<String> CopyOfContent = new ArrayList<>();
    private static int BeginTempIndex = 0;
    private static int EndTempIndex = 0;
    public void extract(List<String> content) {
        
        //in case we need to use the entire content, we can re-use "content"
        //this builds the initial "CopyOfContent"
        CleanAndBuildContent(content);
        
        
        for(String str : CopyOfContent){
            System.out.println(str);
        }
        
        //FindTextField("This form is used", "DE Location ID");     //do we need this?
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
        //---------------------------------------CHECK POINT
        FindTextField("Actual Examination Length", "Foreign Pipe in Excavation");
        FindTextField("Foreign Pipe in Excavation", "Size");
        FindTextField("Size", "Material");
        FindTextField("Material", "Foreign Current");
        FindTextField("Foreign Current", "Bond Present");
        FindTextField("Bond Present", "If Current Flow");
        FindTextField("If Current Flow,     To:", "From:");
//        FindTextField("", "");
//        FindTextField("", "");
//        FindTextField("", "");
//        FindTextField("", "");
        
    }

    private int FindTextField(String StartString, String StopString) {
        StartString = StartString.toLowerCase();
        StopString = StopString.toLowerCase();
        int begin =0, end=0;
        List<String> value = new ArrayList<>();
        String label = null;
        
        FindLabels(StartString, StopString);
        
        if( BeginTempIndex == 0  || EndTempIndex == 0 ){
            System.out.println("Could not find the desired labels");
            return -1;
        }
        else{
            if(BeginTempIndex == 0)
                begin = CopyOfContent.indexOf(StartString)+1;
            else
                begin = BeginTempIndex;
            if(EndTempIndex == 0)
                end = CopyOfContent.indexOf(StopString);
            else
                end = EndTempIndex;
            
            label = StartString;
            value = CopyOfContent.subList(begin, end);
            
            CopyOfContent = CopyOfContent.subList(end, CopyOfContent.size());
            
            //If it is a Check box
            if(value.isEmpty() ){  
                System.out.println("CHECK BOXXXXXXXXXXXXXXXXX");
            }
              
            
            DisplayInfo(label, value);
            
            return 1;
        }
        
    }

    private void DisplayInfo(String label, List<String> value) {
        
        System.out.print(label + " = ");
        for(String str : value){
            System.out.print(str);
        }
        System.out.println("");
        
    }

    private void CleanAndBuildContent(List<String> content) {
        
        for(String str: content){
            String[] strTok = str.split("\\s+");
            StringBuilder builder = new StringBuilder();
            for (String value : strTok) {
                builder.append(value).append(" ");
            }
            while(builder.length() > 0){
                if(builder.charAt(0) == ' ')
                    builder.deleteCharAt(0);
                else
                    break;
            }
            while(builder.length() > 1){
                if(builder.charAt(builder.length()-1) == ' '){
                    builder.deleteCharAt(builder.length()-1);
                }
                else
                    break;
            }

            str = builder.toString();
            CopyOfContent.add(str);

        }
        
        
        
    }

    private void FindLabels(String StartString, String StopString) {
        
        BeginTempIndex =0;
        EndTempIndex = 0;
        
        String[] StartStringTok = StartString.split("\\s+");
        String[] StopStringTok = StopString.split("\\s+");
        
        for(String str : CopyOfContent){
            for(String s : StartStringTok){
                String[] strTok = str.split("\\s+");
                for(String word : strTok){
                    if(word.equalsIgnoreCase(s)){
                        BeginTempIndex = CopyOfContent.indexOf(str)+1;
                        break;
                    }
                }
                if(BeginTempIndex != 0)
                    break;
            }
            if(BeginTempIndex != 0)
                    break;
        }
        
        for(String str : CopyOfContent){
            for(String s : StopStringTok){
                String[] strTok = str.split("\\s+");
                for(String word : strTok){
                    if(word.equalsIgnoreCase(s)){
                        EndTempIndex = CopyOfContent.indexOf(str);
                        break;
                    }
                }
                if(EndTempIndex != 0)
                    break;
            }
            if(EndTempIndex != 0)
                    break;
        }
                
    }
    
}
