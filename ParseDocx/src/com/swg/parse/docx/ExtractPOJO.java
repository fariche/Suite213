/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swg.parse.docx;

/**
 * This is the pojo to be populated by the NewExtract.java 
 * @author KXK3
 */
public class ExtractPOJO {
    
    public int id;
    public String label;
    public String value;
    public String type;
    public int version;
    public int section;
    
    //constructor
    public ExtractPOJO(){
        label = "undefined";
        value = "undefined";
        type = "undefined";
        version = 0;
        section = 0;
    }
    
    //getters and setters
    
    /**
     * getter for ID column of this row
     * @return 
     */
    public int getID(){
        return id;
    }
    
    /**
     * Setter for ID column of this row
     * @param num 
     */
    public void setID(int num){
        this.id = num;
    }
    
    /**
     * getter for label column of this row
     * @return label 
     */
    public String getLabel(){
        return label;
    }
    
    /**
     * Setter for label column of this row
     * @param lab 
     */
    public void setLabel(String lab){
        this.label = lab;
    }
    
    /**
     * getter for value column of this row
     * @return value
     */
    public String getValue(){
        return value;
    }
    
    /**
     * Setter for value column of this row
     * @param val 
     */
    public void setValue(String val){
        this.value = val;
    }
    
    /**
     * getter for type column of this row
     * @return type 
     */
    public String getType(){
        return type;
    }
    
    /**
     * Setter for type column of this row
     * @param ty 
     */
    public void setType(String ty){
        this.type = ty;
    }
    
    /**
     * getter for version column of this row
     * @return version
     */
    public int getVersion(){
        return version;
    }
    
    /**
     * Setter for version column of this row
     * @param ver 
     */
    public void setVersion(int ver){
        this.version = ver;
    }
    
    /**
     * getter for section column of this row
     * @return section 
     */
    public int getSection(){
        return section;
    }
    
    /**
     * Setter for section column of this row
     * @param sec 
     */
    public void setSection(int sec){
        this.section = sec;
    }
    
    
}
