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
    
    public void deleteDataById(Integer idNum);
    public List<MainPOJO> getAll();
    public MainPOJO getById(Integer idNum);
    public void updateData(MainPOJO ExtractPOJO);
    public void deleteData(MainPOJO ExtractPOJO);
    
}
