/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swg.parse.populate;

import com.swg.parse.Form213Pojo.ExtractPOJO;
import com.swg.parse.Form213Pojo.MainPOJO;
import static java.lang.Character.isDigit;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

/**
 *
 * @author KXK3
 */
public class populatePOJOs {
    
    private static MainPOJO mainPojo = new MainPOJO();
    
    public populatePOJOs(ArrayList<ExtractPOJO> ExtractPOJOList) throws ParseException{
        
        for(int i=0; i< ExtractPOJOList.size(); i++){
            if(ExtractPOJOList.get(i).getLabel().equals("de location id")){
                mainPojo.setDE_Location_ID(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().contains("hca")){
                mainPojo.setHCA_Name(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("work request no.")){
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace(" ", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("na", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("n/a", ""));
                Integer val = Integer.parseInt(ExtractPOJOList.get(i).getValue());
                mainPojo.setWork_request_no(val);
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("division")){
                mainPojo.setDivision(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("district number")){
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace(" ", ""));
                Integer val = Integer.parseInt(ExtractPOJOList.get(i).getValue());
                mainPojo.setDistrict_number(val);
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("town or county")){
                mainPojo.setTown_or_county(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("state")){
                mainPojo.setState(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("tile number")){
                mainPojo.setTile_Number(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("address and/or location")){
                mainPojo.setAddress(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("inspection company")){
                mainPojo.setInspection_company(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("date gps synchronized")){
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace(" ", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("na", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("n/a", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("-", "/"));
                if(!ExtractPOJOList.get(i).getValue().equals("")){
                SimpleDateFormat DateFormat = new SimpleDateFormat("MM/dd/yyyy");
                    Date dateVal = DateFormat.parse(ExtractPOJOList.get(i).getValue());
                    mainPojo.setGPS_synchronized_date(dateVal);
                }
                else{
                    mainPojo.setGPS_synchronized_date(null);
                }
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("start: gps x")){
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace(" ", ""));
                Double val = Double.parseDouble(ExtractPOJOList.get(i).getValue());
                mainPojo.setField_location_start_x(val);
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("y") && 
                    ExtractPOJOList.get(i-1).getLabel().equals("start: gps x")){
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace(" ", ""));
                Double val = Double.parseDouble(ExtractPOJOList.get(i).getValue());
                mainPojo.setField_location_start_y(val);
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("end: gps x")){
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace(" ", ""));
                Double val = Double.parseDouble(ExtractPOJOList.get(i).getValue());
                mainPojo.setField_location_end_x(val);
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("y") && 
                    ExtractPOJOList.get(i-1).getLabel().equals("end: gps x")){
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace(" ", ""));
                Double val = Double.parseDouble(ExtractPOJOList.get(i).getValue());
                mainPojo.setField_location_end_y(val);
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("gps file name")){
                mainPojo.setGps_file_name(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().contains("region")){
                mainPojo.setRegion(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("planned examination length")){
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("na", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("n/a", ""));
                
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replaceAll("[^0-9]+", " "));
                if(Arrays.asList(ExtractPOJOList.get(i).getValue().trim().split(" ")).size() > 1){
                    Float second = Float.parseFloat(Arrays.asList(ExtractPOJOList.get(i).getValue().trim().split(" ")).get(1));
                    second = second/12;
                
                    Float first = Float.parseFloat(Arrays.asList(ExtractPOJOList.get(i).getValue().trim().split(" ")).get(0));
                    mainPojo.setPlanned_exam_len_ft((first + second));
                }
                else{
                    Float first = Float.parseFloat(Arrays.asList(ExtractPOJOList.get(i).getValue().trim().split(" ")).get(0));
                    mainPojo.setPlanned_exam_len_ft((first));
                }
            }
            else if(ExtractPOJOList.get(i).getLabel().contains("actual examination length")){
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("na", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("n/a", ""));
                
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replaceAll("[^0-9]+", " "));
                if(Arrays.asList(ExtractPOJOList.get(i).getValue().trim().split(" ")).size() > 1){
                    Float second = Float.parseFloat(Arrays.asList(ExtractPOJOList.get(i).getValue().trim().split(" ")).get(1));
                    second = second/12;
                
                    Float first = Float.parseFloat(Arrays.asList(ExtractPOJOList.get(i).getValue().trim().split(" ")).get(0));
                    mainPojo.setActual_exam_len_ft((first + second));
                }
                else{
                    Float first = Float.parseFloat(Arrays.asList(ExtractPOJOList.get(i).getValue().trim().split(" ")).get(0));
                    mainPojo.setActual_exam_len_ft((first));
                }
            }
            //---------------------------------------------------------------------------------Section 1
            
        }
        //System.out.println(mainPojo.toString());
        
    }
    
}
