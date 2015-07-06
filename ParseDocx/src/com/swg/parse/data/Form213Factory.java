/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swg.parse.data;

import com.swg.parse.Form213Pojo.ExtractPOJO;
import com.swg.parse.interfaces.IXmlMapper;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;



/**
 *
 * @author KXK3
 */
public class Form213Factory implements IXmlMapper {
    
    protected SqlSessionFactory sqlSessionFactory;
    private final static String ConfigProps = "/com/swg/parse/config/configuration.properties";
    private final static String ServerConfig = "com/swg/parse/config/configuration.xml";
    private final static Properties configProperties = new Properties();
    private Reader reader;
        
    static {
        try {
            InputStream in = new FindMe().getClass().getResourceAsStream(ConfigProps);
            configProperties.load(in);
            Enumeration keys = configProperties.keys();
            while (keys.hasMoreElements()) {
                String key = (String) keys.nextElement();
                System.out.println(key + "=" + configProperties.getProperty(key));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public Form213Factory() {
        init();
    }

    protected void init() {
        try {
            reader = Resources.getResourceAsReader(ServerConfig);
            this.sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader, configProperties);
            //SqlSession testSession = sqlSessionFactory.openSession();
        
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }

    }
    
    @Override
    public void insertData(ExtractPOJO pojo) {
        
        try(SqlSession session = sqlSessionFactory.openSession()){
            IXmlMapper xmlMapper = session.getMapper(IXmlMapper.class);
            xmlMapper.insertData(pojo);
            session.commit();

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        
    }

    @Override
    public void deleteDataById(Integer idNum) {
        
        try(SqlSession session = sqlSessionFactory.openSession()){
            IXmlMapper xmlMapper = session.getMapper(IXmlMapper.class);
            xmlMapper.deleteDataById(idNum);        //only change this
            session.commit();

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        
    }

    @Override
    public List<ExtractPOJO> getAll() {
        try(SqlSession session = sqlSessionFactory.openSession()){
            IXmlMapper xmlMapper = session.getMapper(IXmlMapper.class);
            return xmlMapper.getAll();        //only change this

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }

    @Override
    public void deleteAll() {
        try(SqlSession session = sqlSessionFactory.openSession()){
            IXmlMapper xmlMapper = session.getMapper(IXmlMapper.class);
            xmlMapper.deleteAll();        //only change this
            session.commit();

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    @Override
    public ExtractPOJO getById(Integer idNum) {
        try(SqlSession session = sqlSessionFactory.openSession()){
            IXmlMapper xmlMapper = session.getMapper(IXmlMapper.class);
            return xmlMapper.getById(idNum);        //only change this

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }

    @Override
    public void updateData(ExtractPOJO ExtractPOJO) {
        try(SqlSession session = sqlSessionFactory.openSession()){
            IXmlMapper xmlMapper = session.getMapper(IXmlMapper.class);
            xmlMapper.updateData(ExtractPOJO);//only change this
            session.commit();

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    @Override
    public void deleteData(ExtractPOJO ExtractPOJO) {
        try(SqlSession session = sqlSessionFactory.openSession()){
            IXmlMapper xmlMapper = session.getMapper(IXmlMapper.class);
            xmlMapper.deleteData(ExtractPOJO);//only change this
            session.commit();

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
    
}
class FindMe {
}
