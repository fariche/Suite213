/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swg.parse.interfaces;

import com.swg.parse.Form213Pojo.MainPOJO;
import java.util.List;

/**
 *
 * @author KXK3
 */
public interface IXmlMapperMain {
    public void insertData2DirectDetails(MainPOJO ExtractPOJO);
    public void deleteAllDirectDetails();
    
    public void insertData2SpecificDetails(MainPOJO ExtractPOJO);
    public void deleteAllSpecificDetails();
    
    public void insertData2BacterialSample(MainPOJO ExtractPOJO);
    public void deleteAllBacterialSample();
    
    public void insertData2BacterialSampleDetail(MainPOJO ExtractPOJO);
    public void deleteAllBacterialSampleDetail();
    
    public void insertData2BacterialSampleDetail1(MainPOJO ExtractPOJO);
    public void deleteAllBacterialSampleDetail1();
    
    public void insertData2Ultra(MainPOJO ExtractPOJO);
    public void deleteAllUltra();
    
    public void insertData2UltraDetails(MainPOJO ExtractPOJO);
    public void deleteAllUltraDetails();
    
    public void insertData2DefectDetails(MainPOJO ExtractPOJO);
    public void deleteAllDefectDetails();
    
    public void insertData2DefectDetails1(MainPOJO ExtractPOJO);
    public void deleteAllDefectDetails1();
    

    
    //=========================================================================
    
    public void deleteDataById(Integer idNum);
    public List<MainPOJO> getAll();
    public MainPOJO getById(Integer idNum);
    public void updateData(MainPOJO ExtractPOJO);
    public void deleteData(MainPOJO ExtractPOJO);
    
}
