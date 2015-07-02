/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swg.parse.Form213Pojo;

/**
 * This is the pojo to be populated by the NewExtract.java 
 * @author KXK3
 */
public class ExtractPOJO {
    
    public Integer id;
    public String label;
    public String value;
    public Integer version;
    public Integer section;
    
    //constructor
    public ExtractPOJO(){
        label = "undefined";
        value = "undefined";
        version = 0;
        section = 0;
    }
    
    //getters and setters
    
    /**
     * getter for ID column of this row
     * @return 
     */
    public Integer getID(){
        return id;
    }
    
    /**
     * Setter for ID column of this row
     * @param num 
     */
    public void setID(Integer num){
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
     * getter for version column of this row
     * @return version
     */
    public Integer getVersion(){
        return version;
    }
    
    /**
     * Setter for version column of this row
     * @param ver 
     */
    public void setVersion(Integer ver){
        this.version = ver;
    }
    
    /**
     * getter for section column of this row
     * @return section 
     */
    public Integer getSection(){
        return section;
    }
    
    /**
     * Setter for section column of this row
     * @param sec 
     */
    public void setSection(Integer sec){
        this.section = sec;
    }
    
}
