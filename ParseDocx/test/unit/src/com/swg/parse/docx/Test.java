/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swg.parse.docx;

import com.swg.parse.Form213Pojo.ExtractPOJO;
import java.sql.*;
import java.io.Reader;
import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 *
 * @author KXK3
 */
public class Test {
    
    private static SqlSessionFactory sessionFac = null;
    private static Reader reader;
    private static String CONFIGURATION_FILE = "sqlmap-config.xml";
    
    static{
        try {
            reader = Resources.getResourceAsReader(CONFIGURATION_FILE);
            sessionFac = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
        e.printStackTrace();
        }
    }
    
    public static void main(String[] args){
        SqlSession session = sessionFac.openSession();
        try {
            //xmlMap productServiceObj = session.getMapper(xmlMap.class);
            ExtractPOJO obj = new ExtractPOJO();
            obj.setID(100);
            obj.setLabel("TestLab");
            obj.setValue("testVal");
            obj.setSection(100);
            obj.setVersion(100);

            //productServiceObj.save(product);
            session.commit();

        } finally {
        session.close();
        }
    }
    
}
