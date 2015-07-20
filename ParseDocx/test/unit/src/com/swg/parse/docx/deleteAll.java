/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swg.parse.docx;

import com.swg.parse.data.Form213FactoryMain;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

/**
 *
 * @author KXK3
 */
public class deleteAll {
    
    public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
        Form213FactoryMain PopulateOperation = new Form213FactoryMain();
        
        PopulateOperation.deleteAllDefectDetails1();
        PopulateOperation.deleteAllBacterialSampleDetail1();
        PopulateOperation.deleteAllBacterialSampleDetail();
        PopulateOperation.deleteAllBacterialSample();
        PopulateOperation.deleteAllDefectDetails();
        PopulateOperation.deleteAllUltraDetails();
        PopulateOperation.deleteAllUltra();
        PopulateOperation.deleteAllSpecificDetails();
        PopulateOperation.deleteAllDirectDetails();
    }
        
}
