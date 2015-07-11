/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swg.parse.data;

import com.swg.parse.Form213Pojo.MainPOJO;
import com.swg.parse.interfaces.IXmlMapperMain;
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
public class Form213FactoryMain implements IXmlMapperMain {
    
    protected SqlSessionFactory sqlSessionFactory;
    private final static String ConfigProps = "/com/swg/parse/config/configuration.properties";
    private final static String ServerConfig = "com/swg/parse/config/configuration.xml";
    private final static Properties configProperties = new Properties();
    private Reader reader;
        
    static {
        try {
            InputStream in = new FindMeMain().getClass().getResourceAsStream(ConfigProps);
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
    
    public Form213FactoryMain() {
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
    public void insertData2DirectDetails(MainPOJO pojo) {
        
        try(SqlSession session = sqlSessionFactory.openSession()){
            IXmlMapperMain xmlMapper = session.getMapper(IXmlMapperMain.class);
            xmlMapper.insertData2DirectDetails(pojo);
            session.commit();

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        
    }
    
    @Override
    public void deleteAllDirectDetails() {
        try(SqlSession session = sqlSessionFactory.openSession()){
            IXmlMapperMain xmlMapper = session.getMapper(IXmlMapperMain.class);
            xmlMapper.deleteAllDirectDetails();        //only change this
            session.commit();

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
    
        @Override
    public void insertData2SpecificDetails(MainPOJO pojo) {
        try(SqlSession session = sqlSessionFactory.openSession()){
            IXmlMapperMain xmlMapper = session.getMapper(IXmlMapperMain.class);
            xmlMapper.insertData2SpecificDetails(pojo);
            session.commit();

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    @Override
    public void deleteAllSpecificDetails() {
        try(SqlSession session = sqlSessionFactory.openSession()){
            IXmlMapperMain xmlMapper = session.getMapper(IXmlMapperMain.class);
            xmlMapper.deleteAllSpecificDetails();        //only change this
            session.commit();

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
    
    @Override
    public void insertData2BacterialSample(MainPOJO pojo) {
        try(SqlSession session = sqlSessionFactory.openSession()){
            IXmlMapperMain xmlMapper = session.getMapper(IXmlMapperMain.class);
            xmlMapper.insertData2BacterialSample(pojo);
            session.commit();

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    @Override
    public void deleteAllBacterialSample() {
        try(SqlSession session = sqlSessionFactory.openSession()){
            IXmlMapperMain xmlMapper = session.getMapper(IXmlMapperMain.class);
            xmlMapper.deleteAllBacterialSample();        //only change this
            session.commit();

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
    
    @Override
    public void insertData2BacterialSampleDetail(MainPOJO pojo) {
        try(SqlSession session = sqlSessionFactory.openSession()){
            IXmlMapperMain xmlMapper = session.getMapper(IXmlMapperMain.class);
            xmlMapper.insertData2BacterialSampleDetail(pojo);
            session.commit();

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    @Override
    public void deleteAllBacterialSampleDetail() {
        try(SqlSession session = sqlSessionFactory.openSession()){
            IXmlMapperMain xmlMapper = session.getMapper(IXmlMapperMain.class);
            xmlMapper.deleteAllBacterialSampleDetail();        //only change this
            session.commit();

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
    
    @Override
    public void insertData2BacterialSampleDetail1(MainPOJO pojo) {
        try(SqlSession session = sqlSessionFactory.openSession()){
            IXmlMapperMain xmlMapper = session.getMapper(IXmlMapperMain.class);
            xmlMapper.insertData2BacterialSampleDetail1(pojo);
            session.commit();

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    @Override
    public void deleteAllBacterialSampleDetail1() {
        try(SqlSession session = sqlSessionFactory.openSession()){
            IXmlMapperMain xmlMapper = session.getMapper(IXmlMapperMain.class);
            xmlMapper.deleteAllBacterialSampleDetail1();        //only change this
            session.commit();

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
    
    
    @Override
    public void insertData2Ultra(MainPOJO pojo) {
        
        try(SqlSession session = sqlSessionFactory.openSession()){
            IXmlMapperMain xmlMapper = session.getMapper(IXmlMapperMain.class);
            xmlMapper.insertData2Ultra(pojo);
            session.commit();

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        
    }

    @Override
    public void deleteAllUltra() {
        
        try(SqlSession session = sqlSessionFactory.openSession()){
            IXmlMapperMain xmlMapper = session.getMapper(IXmlMapperMain.class);
            xmlMapper.deleteAllUltra();        //only change this
            session.commit();

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        
    }
    
    
//===============================================================    
    

    @Override
    public void deleteDataById(Integer idNum) {
        
        try(SqlSession session = sqlSessionFactory.openSession()){
            IXmlMapperMain xmlMapper = session.getMapper(IXmlMapperMain.class);
            xmlMapper.deleteDataById(idNum);        //only change this
            session.commit();

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        
    }

    @Override
    public List<MainPOJO> getAll() {
        try(SqlSession session = sqlSessionFactory.openSession()){
            IXmlMapperMain xmlMapper = session.getMapper(IXmlMapperMain.class);
            return xmlMapper.getAll();        //only change this

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }

    @Override
    public MainPOJO getById(Integer idNum) {
        try(SqlSession session = sqlSessionFactory.openSession()){
            IXmlMapperMain xmlMapper = session.getMapper(IXmlMapperMain.class);
            return xmlMapper.getById(idNum);        //only change this

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }

    @Override
    public void updateData(MainPOJO ExtractPOJO) {
        try(SqlSession session = sqlSessionFactory.openSession()){
            IXmlMapperMain xmlMapper = session.getMapper(IXmlMapperMain.class);
            xmlMapper.updateData(ExtractPOJO);//only change this
            session.commit();

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    @Override
    public void deleteData(MainPOJO ExtractPOJO) {
        try(SqlSession session = sqlSessionFactory.openSession()){
            IXmlMapperMain xmlMapper = session.getMapper(IXmlMapperMain.class);
            xmlMapper.deleteData(ExtractPOJO);//only change this
            session.commit();

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
    
}
class FindMeMain {
}
