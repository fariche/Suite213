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
    
    public MainPOJO mainPojo = new MainPOJO();
    
    public populatePOJOs(ArrayList<ExtractPOJO> ExtractPOJOList) throws ParseException{
        
        for(int i=0; i< ExtractPOJOList.size(); i++){
            if(ExtractPOJOList.get(i).getLabel().equals("examination number")){
                mainPojo.setExamination_number(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("de location id")){
                mainPojo.setDE_Location_ID(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("hca#") || ExtractPOJOList.get(i).getLabel().equals("hca name")){
                mainPojo.setHCA_Name(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("work request no.")){
                
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unknwn", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unk", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unknown", ""));
                
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace(" ", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("na", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("n/a", ""));
                if(ExtractPOJOList.get(i).getValue().equals("")){
                    ExtractPOJOList.get(i).setValue("0");
                }
                Integer val = Integer.parseInt(ExtractPOJOList.get(i).getValue());
                mainPojo.setWork_request_no(val);
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("division")){
                mainPojo.setDivision(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("district number")){
                
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unknwn", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unk", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unknown", ""));
                
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace(" ", ""));
                if(ExtractPOJOList.get(i).getValue().equals("")){
                    ExtractPOJOList.get(i).setValue("0");
                }
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
                
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unknwn", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unk", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unknown", ""));
                
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
                
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unknwn", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unk", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unknown", ""));
                
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace(" ", ""));
                if(ExtractPOJOList.get(i).getValue().equals("")){
                    ExtractPOJOList.get(i).setValue("0");
                }
                Double val = Double.parseDouble(ExtractPOJOList.get(i).getValue());
                mainPojo.setField_location_start_x(val);
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("y") && 
                    ExtractPOJOList.get(i-1).getLabel().equals("start: gps x")){
                
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unknwn", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unk", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unknown", ""));
                
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace(" ", ""));
                if(ExtractPOJOList.get(i).getValue().equals("")){
                    ExtractPOJOList.get(i).setValue("0");
                }
                Double val = Double.parseDouble(ExtractPOJOList.get(i).getValue());
                mainPojo.setField_location_start_y(val);
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("end: gps x")){
                
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unknwn", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unk", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unknown", ""));
                
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace(" ", ""));
                if(ExtractPOJOList.get(i).getValue().equals("")){
                    ExtractPOJOList.get(i).setValue("0");
                }
                Double val = Double.parseDouble(ExtractPOJOList.get(i).getValue());
                mainPojo.setField_location_end_x(val);
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("y") && 
                    ExtractPOJOList.get(i-1).getLabel().equals("end: gps x")){
                
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unknwn", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unk", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unknown", ""));
                
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace(" ", ""));
                if(ExtractPOJOList.get(i).getValue().equals("")){
                    ExtractPOJOList.get(i).setValue("0");
                }
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
                
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unknwn", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unk", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unknown", ""));
                
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("na", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("n/a", ""));
                
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replaceAll("[^0-9]+", " "));
                if(ExtractPOJOList.get(i).getValue().equals("")){
                    ExtractPOJOList.get(i).setValue("0");
                    float k = 0;
                    mainPojo.setPlanned_exam_len_ft(k);
                }
                else if(Arrays.asList(ExtractPOJOList.get(i).getValue().trim().split(" ")).size() > 1){
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
            else if(ExtractPOJOList.get(i).getLabel().equals("actual examination length")){
                
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unknwn", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unk", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unknown", ""));
                
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("na", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("n/a", ""));
                
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replaceAll("[^0-9]+", " "));
                if(ExtractPOJOList.get(i).getValue().equals("")){
                    ExtractPOJOList.get(i).setValue("0");
                    float k = 0;
                    mainPojo.setActual_exam_len_ft(k);
                }
                else if(Arrays.asList(ExtractPOJOList.get(i).getValue().trim().split(" ")).size() > 1){
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
            else if(ExtractPOJOList.get(i).getLabel().equals("foreign pipe in excavation")){
                mainPojo.setForeign_pipe_in_excava(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("size")){
                
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unknwn", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unk", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unknown", ""));
                
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace(" ", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("na", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("n/a", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replaceAll("[^0-9]+", ""));
                if(ExtractPOJOList.get(i).getValue().equals("")){
                    ExtractPOJOList.get(i).setValue("0");
                }
                Integer val = Integer.parseInt(ExtractPOJOList.get(i).getValue());
                mainPojo.setSize(val);             
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("material")){
                mainPojo.setMaterial(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("foreign current")){
                mainPojo.setForeign_current(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("bond present")){
                mainPojo.setBond_present(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().contains("if current flow")){
                mainPojo.setCurrent_flow_to(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("from:")){
                mainPojo.setCurrent_flow_from(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("cp present")){
                mainPojo.setCp_present(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("anode present")){
                mainPojo.setAnode_present(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("% consumed")){
                
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unknwn", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unk", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unknown", ""));
                
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace(" ", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("na", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("n/a", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replaceAll("[^0-9^.]+", ""));
                if(ExtractPOJOList.get(i).getValue().equals("")){
                    ExtractPOJOList.get(i).setValue("0");
                }
                Float val = Float.parseFloat(ExtractPOJOList.get(i).getValue());
                mainPojo.setPercent_consumed(val);
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("temp")){
                
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unknwn", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unk", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unknown", ""));
                
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace(" ", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("na", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("n/a", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replaceAll("[^0-9^.]+", ""));
                if(ExtractPOJOList.get(i).getValue().equals("")){
                    ExtractPOJOList.get(i).setValue("0");
                }
                Float val = Float.parseFloat(ExtractPOJOList.get(i).getValue());
                mainPojo.setTemperature(val);
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("time 24-hr")){
                
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unknwn", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unk", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unknown", ""));
                
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace(" ", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("na", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("n/a", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replaceAll("[^0-9]+", ""));
                if(ExtractPOJOList.get(i).getValue().equals("")){
                    ExtractPOJOList.get(i).setValue("0");
                }
                Integer val = Integer.parseInt(ExtractPOJOList.get(i).getValue());
                mainPojo.setTime_24(val);
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("weather conditions")){
                mainPojo.setWeather_conditions(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("soil conditions:")){
                mainPojo.setSoil_conditions(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("bedding/shading type")){
                mainPojo.setBedding_shading_type(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("rockshield used")){
                mainPojo.setRockshield_used(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("soil type:")){
                mainPojo.setSoil_type(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("depth of cover")){
                
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unknwn", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unk", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unknown", ""));
                
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace(" ", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("na", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("n/a", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replaceAll("[^0-9]+", ""));
                if(ExtractPOJOList.get(i).getValue().equals("")){
                    ExtractPOJOList.get(i).setValue("0");
                }
                Integer val = Integer.parseInt(ExtractPOJOList.get(i).getValue());
                mainPojo.setDepth_of_cover(val);
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("nominal size")){
                
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unknwn", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unk", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unknown", ""));
                
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace(" ", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("na", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("n/a", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replaceAll("[^0-9^.]+", ""));
                if(ExtractPOJOList.get(i).getValue().equals("")){
                    ExtractPOJOList.get(i).setValue("0");
                }
                Float val = Float.parseFloat(ExtractPOJOList.get(i).getValue());
                mainPojo.setNominal_size(val);
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("indiam")){
                
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unknwn", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unk", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unknown", ""));
                
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace(" ", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("na", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("n/a", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replaceAll("[^0-9^.]+", ""));
                if(ExtractPOJOList.get(i).getValue().equals("")){
                    ExtractPOJOList.get(i).setValue("0");
                }
                Float val = Float.parseFloat(ExtractPOJOList.get(i).getValue());
                mainPojo.setIn_diam(val);
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("wthick")){
                
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unknwn", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unk", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unknown", ""));
                
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace(" ", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("na", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("n/a", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replaceAll("[^0-9^.]+", ""));
                if(ExtractPOJOList.get(i).getValue().equals("")){
                    ExtractPOJOList.get(i).setValue("0");
                }
                Float val = Float.parseFloat(ExtractPOJOList.get(i).getValue());
                mainPojo.setWthick(val);
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("grade")){
                mainPojo.setGrade(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("yield")){
                
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unknwn", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unk", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unknown", ""));
                
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace(" ", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("na", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("n/a", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replaceAll("[^0-9]+", ""));
                if(ExtractPOJOList.get(i).getValue().equals("")){
                    ExtractPOJOList.get(i).setValue("0");
                }
                Integer val = Integer.parseInt(ExtractPOJOList.get(i).getValue());
                mainPojo.setYield(val);
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("coating")){
                mainPojo.setCoating(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("wkreqno")){
                mainPojo.setWk_req_no(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("installation month")){
                
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unknwn", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unk", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unknown", ""));
                
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace(" ", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("na", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("n/a", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replaceAll("[^0-9]+", ""));
                if(ExtractPOJOList.get(i).getValue().equals("")){
                    ExtractPOJOList.get(i).setValue("0");
                }
                Integer val = Integer.parseInt(ExtractPOJOList.get(i).getValue());
                mainPojo.setInstallation_month(val);
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("installation year")){
                
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unknwn", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unk", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unknown", ""));
                
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace(" ", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("na", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("n/a", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replaceAll("[^0-9]+", ""));
                if(ExtractPOJOList.get(i).getValue().equals("")){
                    ExtractPOJOList.get(i).setValue("0");
                }
                Integer val = Integer.parseInt(ExtractPOJOList.get(i).getValue());
                mainPojo.setInstallation_year(val);
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("opssysname")){
                mainPojo.setOps_sys_name(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("weld seam:")){
                mainPojo.setWeld_seam(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("coating types:")){
                mainPojo.setCoating_types(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("coating condition:")){
                mainPojo.setCoating_condition(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("holiday detection volt setting")){
               
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unknwn", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unk", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unknown", ""));
                
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace(" ", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("na", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("n/a", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replaceAll("[^0-9]+", ""));
                if(ExtractPOJOList.get(i).getValue().equals("")){
                    ExtractPOJOList.get(i).setValue("0");
                }
                Integer val = Integer.parseInt(ExtractPOJOList.get(i).getValue());
                mainPojo.setHoliday_detec_colt_setting(val);
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("non-corrosive disbondment % damage")){
                
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unknwn", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unk", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unknown", ""));
                
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace(" ", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("na", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("n/a", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replaceAll("[^0-9^.]+", ""));
                if(ExtractPOJOList.get(i).getValue().equals("")){
                    ExtractPOJOList.get(i).setValue("0");
                }
                Float val = Float.parseFloat(ExtractPOJOList.get(i).getValue());
                mainPojo.setPer_dam_ncorros_disbond(val);
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("non-corrosive disbondment o'clock/position")){
                
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unknwn", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unk", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unknown", ""));
                
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace(" ", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("na", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("n/a", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replaceAll("[^0-9]+", ""));
                if(ExtractPOJOList.get(i).getValue().equals("")){
                    ExtractPOJOList.get(i).setValue("0");
                }
                Integer val = Integer.parseInt(ExtractPOJOList.get(i).getValue());
                mainPojo.setO_clock_ncorros_disbond(val);
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("blistering due to corrosion % damage")){
                
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unknwn", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unk", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unknown", ""));
                
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace(" ", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("na", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("n/a", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replaceAll("[^0-9^.]+", ""));
                if(ExtractPOJOList.get(i).getValue().equals("")){
                    ExtractPOJOList.get(i).setValue("0");
                }
                Float val = Float.parseFloat(ExtractPOJOList.get(i).getValue());
                mainPojo.setPercent_damage_blistering(val);
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("blistering due to corrosion o'clock/position")){
                
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unknwn", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unk", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unknown", ""));
                
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace(" ", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("na", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("n/a", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replaceAll("[^0-9]+", ""));
                if(ExtractPOJOList.get(i).getValue().equals("")){
                    ExtractPOJOList.get(i).setValue("0");
                }
                Integer val = Integer.parseInt(ExtractPOJOList.get(i).getValue());
                mainPojo.setO_clock_damage_blistering(val);
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("ground cover found:")){
                mainPojo.setGround_cover_type(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("ph of fluid in blisters")){
                
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unknwn", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unk", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unknown", ""));
                
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace(" ", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("na", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("n/a", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replaceAll("[^0-9^.]+", ""));
                if(ExtractPOJOList.get(i).getValue().equals("")){
                    ExtractPOJOList.get(i).setValue("0");
                }
                Float val = Float.parseFloat(ExtractPOJOList.get(i).getValue());
                mainPojo.setBlister_fluid_ph(val);
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("i have reviewed the procedures performed and have found them:")){
                mainPojo.setProcedure_adequate_flag(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("inspected by")){
                mainPojo.setInspected_by(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("inspection date")){
                
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unknwn", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unk", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unknown", ""));
                
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace(" ", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("na", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("n/a", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("-", "/"));
                if(!ExtractPOJOList.get(i).getValue().equals("")){
                SimpleDateFormat DateFormat = new SimpleDateFormat("MM/dd/yyyy");
                    Date dateVal = DateFormat.parse(ExtractPOJOList.get(i).getValue());
                    mainPojo.setInspection_date(dateVal);
                }
                else{
                    mainPojo.setInspection_date(null);
                }
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("reviewed by")){
                mainPojo.setReviewed_by(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("date reviewed")){
                
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unknwn", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unk", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unknown", ""));
                
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace(" ", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("na", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("n/a", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("-", "/"));
                if(!ExtractPOJOList.get(i).getValue().equals("")){
                SimpleDateFormat DateFormat = new SimpleDateFormat("MM/dd/yyyy");
                    Date dateVal = DateFormat.parse(ExtractPOJOList.get(i).getValue());
                    mainPojo.setReviewed_date(dateVal);
                }
                else{
                    mainPojo.setReviewed_date(null);
                }
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("soil ph at pipe depth")){
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace(" ", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("na", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("n/a", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replaceAll("[^0-9^.]+", ""));
                if(ExtractPOJOList.get(i).getValue().equals("")){
                    ExtractPOJOList.get(i).setValue("0");
                }
                Float val = Float.parseFloat(ExtractPOJOList.get(i).getValue());
                mainPojo.setSoilph_at_pipe_depth(val);
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("soil resistivity at pipe depth")){
                
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unknwn", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unk", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unknown", ""));
                
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace(" ", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("na", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("n/a", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replaceAll("[^0-9]+", ""));
                if(ExtractPOJOList.get(i).getValue().equals("")){
                    ExtractPOJOList.get(i).setValue("0");
                }
                Integer val = Integer.parseInt(ExtractPOJOList.get(i).getValue());
                mainPojo.setSoil_resistivity_at_pipe_depth(val);
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("soil chemistry performed")){
                mainPojo.setSoil_chem_performed_flag(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("method used - ")){
                mainPojo.setMethod_used(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("chlorides")){
                
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unknwn", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unk", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unknown", ""));
                
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace(" ", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("na", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("n/a", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replaceAll("[^0-9^.]+", ""));
                if(ExtractPOJOList.get(i).getValue().equals("")){
                    ExtractPOJOList.get(i).setValue("0");
                }
                Float val = Float.parseFloat(ExtractPOJOList.get(i).getValue());
                mainPojo.setChlorides_ppm(val);
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("nitrates")){
                
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unknwn", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unk", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unknown", ""));
                
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace(" ", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("na", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("n/a", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replaceAll("[^0-9^.]+", ""));
                if(ExtractPOJOList.get(i).getValue().equals("")){
                    ExtractPOJOList.get(i).setValue("0");
                }
                Float val = Float.parseFloat(ExtractPOJOList.get(i).getValue());
                mainPojo.setNitrates_ppm(val);
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("sulfates")){
                
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unknwn", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unk", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unknown", ""));
                
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace(" ", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("na", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("n/a", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replaceAll("[^0-9^.]+", ""));
                if(ExtractPOJOList.get(i).getValue().equals("")){
                    ExtractPOJOList.get(i).setValue("0");
                }
                Float val = Float.parseFloat(ExtractPOJOList.get(i).getValue());
                mainPojo.setSulfates_ppm(val);
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("6 o'clock") || ExtractPOJOList.get(i).getLabel().equals("Pipe to Soil from Start of Excavation: 6 o'clock") ){
                
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unknwn", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unk", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unknown", ""));
                
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace(" ", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("na", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("n/a", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replaceAll("[^0-9^.]+", ""));
                if(ExtractPOJOList.get(i).getValue().equals("")){
                    ExtractPOJOList.get(i).setValue("0");
                }
                Float val = Float.parseFloat(ExtractPOJOList.get(i).getValue());
                mainPojo.setPipe_to_soil_frm_exc_6_oclock(val);
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("Pipe to Soil from Start of Excavation: 3 o'clock") ){
                
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unknwn", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unk", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unknown", ""));
                
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace(" ", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("na", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("n/a", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replaceAll("[^0-9^.]+", ""));
                if(ExtractPOJOList.get(i).getValue().equals("")){
                    ExtractPOJOList.get(i).setValue("0");
                }
                Float val = Float.parseFloat(ExtractPOJOList.get(i).getValue());
                mainPojo.setPipe_to_soil_frm_exc_3_oclock(val);
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("Pipe to Soil from Start of Excavation: 9 o'clock") ){
                
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unknwn", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unk", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unknown", ""));
                
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace(" ", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("na", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("n/a", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replaceAll("[^0-9^.]+", ""));
                if(ExtractPOJOList.get(i).getValue().equals("")){
                    ExtractPOJOList.get(i).setValue("0");
                }
                Float val = Float.parseFloat(ExtractPOJOList.get(i).getValue());
                mainPojo.setPipe_to_soil_frm_exc_9_oclock(val);
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("Pipe to Soil from Start of Excavation: 12 o'clock") ){
                
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unknwn", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unk", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unknown", ""));
                
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace(" ", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("na", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("n/a", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replaceAll("[^0-9^.]+", ""));
                if(ExtractPOJOList.get(i).getValue().equals("")){
                    ExtractPOJOList.get(i).setValue("0");
                }
                Float val = Float.parseFloat(ExtractPOJOList.get(i).getValue());
                mainPojo.setPipe_to_soil_frm_exc_12_oclock(val);
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("bacterial samples taken")){
                mainPojo.setBacterial_samples_taken(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("asphalt and/or tar wrap samples taken")){
                mainPojo.setAsphalt_tar_samples_taken(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("date of incubation")){
                
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unknwn", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unk", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unknown", ""));
                
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace(" ", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("na", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("n/a", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("-", "/"));
                if(!ExtractPOJOList.get(i).getValue().equals("")){
                SimpleDateFormat DateFormat = new SimpleDateFormat("MM/dd/yyyy");
                    Date dateVal = DateFormat.parse(ExtractPOJOList.get(i).getValue());
                    mainPojo.setDate_of_incubation(dateVal);
                }
                else{
                    mainPojo.setDate_of_incubation(null);
                }
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("Anomaly:  Coating Defect")){
                mainPojo.setDefects_found(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("cause of corrosion:")){
                mainPojo.setCause_of_corrosion(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("defects comments:")){
                mainPojo.setDefects_comments(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("severity of coating anomaly suspected")){
                mainPojo.setSuspec_severity_coating_anom(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("severity of coating anomaly found")){
                mainPojo.setFound_severity_coating_anomaly(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("severity of de defect found on pipe")){
                mainPojo.setDE_defect_severity(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("3. severity of the coating anomaly found was more / less severe than originally prioritized?")){
                mainPojo.setSeverity_coatinganomaly2xpctd(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("4. is this the initial assessment of this covered segment?")){
                mainPojo.setInitial_assessment_covered_seg(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("5. if both 3a & 4b, then should the criteria in the severity classification table be adjusted?")){
                mainPojo.setNeed_to_adjust_sct_flag(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("6. was corrosion found?")){
                mainPojo.setCorrosion_found(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("7. was this a b or c priority in which the corrosion found was deeper than 20% of the original wall thickness?")){
                mainPojo.setB_or_c_priority_flag(ExtractPOJOList.get(i).getValue());
            }
            else if(i>1 && ExtractPOJOList.get(i-1).getLabel().equals("8. was this corrosion deeper or more severe than corrosion found on any a-priority examination in this same region?")){
                mainPojo.setMore_severe_than_A_priority(ExtractPOJOList.get(i-1).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("  9. was the severity classification table assessed for adjustments?")){
                mainPojo.setSct_assessed_for_adjustment(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("10. were changes made to the severity classification table?")){
                mainPojo.setChanges_made_to_sct_flag(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("if yes, document on moc.  if no, explain why not.")){
                mainPojo.setIf_no_moc_explain_why(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("11. are additional indirect inspection surveys needed on this segment?")){
                mainPojo.setAdd_indirect_surveys_needed(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("1. is the corrosion considered significant?")){
                mainPojo.setSignificant_corrosion_flag(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("a. was the review conducted?")){
                mainPojo.setReview_conducted_flag(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("explanation for other:")){
                mainPojo.setExplanation_for_other(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("b. do alternative methods need to be implemented?")){
                mainPojo.setAlt_methods_requirement_flag(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("4. for this hca, has corrosion been found and a root cause determined at other locations?")){
                mainPojo.setCorros_other_location_sameHCA(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("5. for this hca, are similar occurrences of the root cause being determined at other locations?")){
                mainPojo.setSimilar_rootcause_same_HCA(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("date calculation completed:")){
                
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unknwn", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unk", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unknown", ""));
                
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace(" ", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("na", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("n/a", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("-", "/"));
                if(!ExtractPOJOList.get(i).getValue().equals("") && !ExtractPOJOList.get(i).getValue().equals(",")){
                SimpleDateFormat DateFormat = new SimpleDateFormat("MM/dd/yyyy");
                    Date dateVal = DateFormat.parse(ExtractPOJOList.get(i).getValue());
                    mainPojo.setCrt_date_calc_completed(dateVal);
                }
                else{
                    mainPojo.setCrt_date_calc_completed(null);
                }
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("inspector?s comments:")){
                mainPojo.setInspector_comments(ExtractPOJOList.get(i).getValue());
            }//needs testing
            else if(ExtractPOJOList.get(i).getLabel().equals("remediation action required?")){
                mainPojo.setRemed_action_requirement_flag(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("reference work request no.")){
                mainPojo.setReference_request_number(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("check one: repair was:")){
                mainPojo.setRepair_quickness(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("remediation comments:")){
                mainPojo.setRemediation_comments(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("icda scrub #1: min")){
                
                
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unknwn", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unk", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unknown", ""));
                
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace(" ", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("na", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("n/a", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replaceAll("[^0-9^.]+", ""));
                if(ExtractPOJOList.get(i).getValue().equals("")){
                    ExtractPOJOList.get(i).setValue("0");
                }
                Float val = Float.parseFloat(ExtractPOJOList.get(i).getValue());
                mainPojo.setMin_ICDA_scrub_1(val);
            }
            else if(i>2 && ExtractPOJOList.get(i-1).getLabel().equals("icda scrub #1: min") && ExtractPOJOList.get(i).getLabel().equals("max")){
                
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unknwn", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unk", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unknown", ""));
                
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace(" ", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("na", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("n/a", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replaceAll("[^0-9^.]+", ""));
                if(ExtractPOJOList.get(i).getValue().equals("")){
                    ExtractPOJOList.get(i).setValue("0");
                }
                Float val = Float.parseFloat(ExtractPOJOList.get(i).getValue());
                mainPojo.setMax_ICDA_scrub_1(val);
            }
            else if(i>2 && ExtractPOJOList.get(i-2).getLabel().equals("icda scrub #1: min") && ExtractPOJOList.get(i).getLabel().equals("wt ?%")){
                
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unknwn", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unk", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unknown", ""));
                
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace(" ", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("na", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("n/a", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replaceAll("[^0-9^.]+", ""));
                if(ExtractPOJOList.get(i).getValue().equals("")){
                    ExtractPOJOList.get(i).setValue("0");
                }
                Float val = Float.parseFloat(ExtractPOJOList.get(i).getValue());
                mainPojo.setWt_percentage_scrub1(val);
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("icda scrub #2: min")){
                
                
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unknwn", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unk", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unknown", ""));
                
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace(" ", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("na", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("n/a", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replaceAll("[^0-9^.]+", ""));
                if(ExtractPOJOList.get(i).getValue().equals("")){
                    ExtractPOJOList.get(i).setValue("0");
                }
                Float val = Float.parseFloat(ExtractPOJOList.get(i).getValue());
                mainPojo.setMin_ICDA_scrub_2(val);
            }
            else if(i>2 && ExtractPOJOList.get(i-1).getLabel().equals("icda scrub #2: min") && ExtractPOJOList.get(i).getLabel().equals("max")){
                
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unknwn", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unk", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unknown", ""));
                
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace(" ", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("na", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("n/a", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replaceAll("[^0-9^.]+", ""));
                if(ExtractPOJOList.get(i).getValue().equals("")){
                    ExtractPOJOList.get(i).setValue("0");
                }
                Float val = Float.parseFloat(ExtractPOJOList.get(i).getValue());
                mainPojo.setMax_ICDA_scrub_2(val);
            }
            else if(i>2 && ExtractPOJOList.get(i-2).getLabel().equals("icda scrub #2: min") && ExtractPOJOList.get(i).getLabel().equals("wt ?%")){
                
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unknwn", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unk", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("unknown", ""));
                
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace(" ", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("na", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replace("n/a", ""));
                ExtractPOJOList.get(i).setValue(ExtractPOJOList.get(i).getValue().replaceAll("[^0-9^.]+", ""));
                if(ExtractPOJOList.get(i).getValue().equals("")){
                    ExtractPOJOList.get(i).setValue("0");
                }
                Float val = Float.parseFloat(ExtractPOJOList.get(i).getValue());
                mainPojo.setWt_percentage_scrub2(val);
            }
            
        }
        //System.out.println(mainPojo.toString());
        
    }
    
}
