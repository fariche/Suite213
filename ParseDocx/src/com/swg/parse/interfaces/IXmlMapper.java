/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swg.parse.interfaces;

import com.swg.parse.Form213Pojo.ExtractPOJO;
import java.util.List;

/**
 *
 * @author KXK3
 */
public interface IXmlMapper {
    public void insertData(ExtractPOJO ExtractPOJO);
    public void deleteDataById(Integer idNum);
    public List<ExtractPOJO> getAll();
    public void deleteAll();
    public ExtractPOJO getById(Integer idNum);
    public void updateData(ExtractPOJO ExtractPOJO);
    public void deleteData(ExtractPOJO ExtractPOJO);
    
}
