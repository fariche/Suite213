/*
 * This class populates MainPOJO elements coresponding to the following ddatabase table:
 * bacterial_samples, bacterial_samples_details, bacterial_samples_details1,
 * defect_details, defect_details1, ultra_sonic_details, ultra_sonic_thickness_readings
 * it also inserts all elements into the database
 */
package com.swg.parse.populate;

import com.swg.parse.Form213Pojo.ExtractPOJO;
import com.swg.parse.Form213Pojo.MainPOJO;
import com.swg.parse.data.Form213FactoryMain;
import java.text.ParseException;
import java.util.ArrayList;

/**
 *
 * @author KXK3
 */
public class DynamicPopulatePOJO {

    public DynamicPopulatePOJO(ArrayList<ExtractPOJO> ListOfPOJO_Rows, ArrayList<String> ValueBeforePOJO, int version) throws ParseException {
        
        //populate the main pojo with the help of the previous pojo
        populatePOJOs PojoPop = new populatePOJOs(ListOfPOJO_Rows);
        
        Form213FactoryMain PopulateOperation = new Form213FactoryMain();
        
        PopulateOperation.insertData2DirectDetails(PojoPop.mainPojo);
        PopulateOperation.insertData2SpecificDetails(PojoPop.mainPojo);
        PopulateOperation.insertData2BacterialSample(PojoPop.mainPojo);
        
        int k =0;
        int flag = 0;
        ArrayList <String> qNum = new ArrayList<>();
        ArrayList <String> qType = new ArrayList<>();
        ArrayList <String> qDistance = new ArrayList<>();
        ArrayList <String> qOClock = new ArrayList<>();
        ArrayList <String> qAxeLength= new ArrayList<>();
        ArrayList <String> qCircLengh= new ArrayList<>();
        ArrayList <String> qMax = new ArrayList<>();
        ArrayList <String> qRepair = new ArrayList<>();
        ArrayList <String> qcorrosion = new ArrayList<>();
                
        for(int i=0; i< ValueBeforePOJO.size(); i++){
            
            if( (ListOfPOJO_Rows.get(i).getLabel().contains("number(") ) ){
                qNum.clear();
                qType.clear();
                qDistance.clear();
                qOClock.clear();
                qAxeLength.clear();
                qCircLengh.clear();
                qMax.clear();
                qRepair.clear();
                qcorrosion.clear();
                
                    MainPOJO pojo = new MainPOJO();
                    String tempStr = null;
                    Integer TableRowNum = null;
                    pojo.clearIt();
                    
                    while(!ListOfPOJO_Rows.get(i).getLabel().contains("type of defect(") && !ListOfPOJO_Rows.get(i).getLabel().contains("defects comments:")){
                        //populate num
                        ListOfPOJO_Rows.get(i).setValue(ListOfPOJO_Rows.get(i).getValue().replaceAll(" ", ""));            
                        qNum.add(ListOfPOJO_Rows.get(i).getValue());
                        i++;
                    }
                    while(!ListOfPOJO_Rows.get(i).getLabel().contains("distance from zero point defect(") && !ListOfPOJO_Rows.get(i).getLabel().contains("defects comments:")){
                        //populate type
                        qType.add(ListOfPOJO_Rows.get(i).getValue());
                        i++;
                    }
                    while(!ListOfPOJO_Rows.get(i).getLabel().contains("o'clock position defect(") && !ListOfPOJO_Rows.get(i).getLabel().contains("defects comments:")){
                        //populate distance zero
                        String temp = null;
                        ListOfPOJO_Rows.get(i).setValue(ListOfPOJO_Rows.get(i).getValue().replaceAll(" ", ""));
                        if(ListOfPOJO_Rows.get(i).getValue().equals("") ){
                            temp = null;
                        }
                        else{
                            temp = ListOfPOJO_Rows.get(i).getValue();
                        }                        
                        qDistance.add(temp);
                        i++;
                    }
                    while(!ListOfPOJO_Rows.get(i).getLabel().contains("length axe defect(") && !ListOfPOJO_Rows.get(i).getLabel().contains("defects comments:")){
                        //populate position
                        String temp = null;
                        if(ListOfPOJO_Rows.get(i).getValue().equals("") ){
                            temp = null;
                        }
                        else{
                            temp = ListOfPOJO_Rows.get(i).getValue();
                        }                        
                        qOClock.add(temp);
                        i++;
                    }
                    while(!ListOfPOJO_Rows.get(i).getLabel().contains("length circ defect(") && !ListOfPOJO_Rows.get(i).getLabel().contains("defects comments:")){
                        //populate axial
                        String temp = null;
                        if(ListOfPOJO_Rows.get(i).getValue().equals("") ){
                            temp = null;
                        }
                        else{
                            temp = ListOfPOJO_Rows.get(i).getValue();
                        }                        
                        qAxeLength.add(temp);                        
                        i++;
                    }
                    while(!ListOfPOJO_Rows.get(i).getLabel().contains("maximum depth(") && !ListOfPOJO_Rows.get(i).getLabel().contains("defects comments:")){
                        //populate circ
                        String temp = null;
                        ListOfPOJO_Rows.get(i).setValue(ListOfPOJO_Rows.get(i).getValue().replaceAll(" ", ""));
                        if(ListOfPOJO_Rows.get(i).getValue().equals("") ){
                            temp = null;
                        }
                        else{
                            temp = ListOfPOJO_Rows.get(i).getValue();
                        }                        
                        qCircLengh.add(temp);                        
                        i++;
                    }
                    while(!ListOfPOJO_Rows.get(i).getLabel().contains("repair category(") && !ListOfPOJO_Rows.get(i).getLabel().contains("defects comments:")){
                        //populate max
                        String temp = null;
                        ListOfPOJO_Rows.get(i).setValue(ListOfPOJO_Rows.get(i).getValue().replaceAll(" ", ""));
                        if(ListOfPOJO_Rows.get(i).getValue().equals("") ){
                            temp = null;
                        }
                        else{
                            temp = ListOfPOJO_Rows.get(i).getValue();
                        }                        
                        qMax.add(temp);                        
                        i++;
                    }
                    while(!ListOfPOJO_Rows.get(i).getLabel().contains("corrosion interactivity(") && !ListOfPOJO_Rows.get(i).getLabel().contains("defects comments:")){
                        //populate repair
                        qRepair.add(ListOfPOJO_Rows.get(i).getValue());
                        i++;
                    }
                    while(!ListOfPOJO_Rows.get(i).getLabel().contains("number(") && !ListOfPOJO_Rows.get(i).getLabel().contains("defects comments:")){
                        //populate corrosion
                        qcorrosion.add(ListOfPOJO_Rows.get(i).getValue());
                        i++;
                    }
                    
                    for(int n = 0; n < qNum.size(); n++ ){
                        
                        pojo.setGps_file_name(PojoPop.mainPojo.getGps_file_name());
                        //tempStr = ListOfPOJO_Rows.get(i).getLabel().substring(ListOfPOJO_Rows.get(i).getLabel().indexOf("(") + 1, ListOfPOJO_Rows.get(i).getLabel().indexOf(")") );
                        TableRowNum = n;       //Integer.parseInt(tempStr);
                        String TablePkey = pojo.getGps_file_name() + " " + TableRowNum;
                        pojo.setDefect_title(TablePkey);
                        PopulateOperation.insertData2DefectDetails(pojo);
                        
                        pojo.setDefect_number(qNum.get(n));
                        pojo.setDefect_type(qType.get(n));
                        pojo.setDistance_from_zero(qDistance.get(n));
                        pojo.setO_clock_position(qOClock.get(n));
                        pojo.setAxial_length(qAxeLength.get(n));
                        pojo.setCircumferential_length(qCircLengh.get(n));
                        pojo.setMax_depth(qMax.get(n));
                        pojo.setRepair_category(qRepair.get(n));
                        pojo.setCorrosion_interactivity(qcorrosion.get(n));
                        
                        PopulateOperation.insertData2DefectDetails1(pojo);
                        
//                        pojo.setDefect_number(qNum.get(n-1));
//                        pojo.setDefect_type(qType.get(n-1));
//                        pojo.setDistance_from_zero(qDistance.get(n-1));
//                        pojo.setO_clock_position(qOClock.get(n-1));
//                        pojo.setAxial_length(qAxeLength.get(n-1));
//                        pojo.setCircumferential_length(qCircLengh.get(n-1));
//                        pojo.setMax_depth(qMax.get(n-1));
//                        pojo.setRepair_category(qRepair.get(n-1));
//                        pojo.setCorrosion_interactivity(qcorrosion.get(n-1));
//                        PopulateOperation.insertData2DefectDetails1(pojo);
                    }

            }
            else if( ListOfPOJO_Rows.get(i).getLabel().contains("  no.")){
                String temp1 = ListOfPOJO_Rows.get(i).getValue().replace(" ", "");
                if(!temp1.equals("")){
                    MainPOJO pojo = new MainPOJO();
                    pojo.setGps_file_name(PojoPop.mainPojo.getGps_file_name());
                    String tempStr = ListOfPOJO_Rows.get(i).getLabel().substring(ListOfPOJO_Rows.get(i).getLabel().indexOf(".") + 1);
                    String TableRowNum = tempStr;
                    String TablePkey = pojo.getGps_file_name() + " " + tempStr;
                    pojo.setDefect_title(TablePkey);
                    
                    String tp = ListOfPOJO_Rows.get(i).getValue().replace(" ", "");
                    tp = tp.replace("n/a", "");
                    tp = tp.replace("na", "");
                    if(tp.equals("")){
                        pojo.setDefect_number(null);
                    }
                    else{
                        pojo.setDefect_number(TableRowNum);
                    }
                    PopulateOperation.insertData2DefectDetails(pojo);
                    
                    i++;
                     while(!ListOfPOJO_Rows.get(i).getLabel().contains("  no.") && !ListOfPOJO_Rows.get(i).getLabel().equals(" distance from zero point0")  ){
                        
                         if(ListOfPOJO_Rows.get(i).getLabel().contains("type of defect")){
                            pojo.setDefect_type(ListOfPOJO_Rows.get(i).getValue());
                        }
                        else if(ListOfPOJO_Rows.get(i).getLabel().contains("distance from zero reference")){
                            String str = ListOfPOJO_Rows.get(i).getValue().replaceAll("[^0-9^.]+", "");
                            String temp = null; 
                            if(str.equals("")){
                                temp = null;
                            }
                            else{
                                temp =  str;
                            }
                            pojo.setDistance_from_zero(temp);
                        }
                         else if(ListOfPOJO_Rows.get(i).getLabel().contains("o'clock position")){
                            String str = ListOfPOJO_Rows.get(i).getValue().replaceAll("[^0-9^.]+", "");
                            String temp = null; 
                            if(str.equals("")){
                                temp = null;
                             }
                             else{
                                temp = str;
                             }
                            pojo.setO_clock_position(temp);
                         }
                         else if(ListOfPOJO_Rows.get(i).getLabel().contains("longitudinal length")){
                            String str = ListOfPOJO_Rows.get(i).getValue().replaceAll("[^0-9^.]+", "");
                            String temp = null; 
                            if(str.equals("")){
                                temp = null;
                             }
                             else{
                                temp =  str;
                             }
                            pojo.setAxial_length(temp);
                         }
                         else if(ListOfPOJO_Rows.get(i).getLabel().contains("width")){
                            String str = ListOfPOJO_Rows.get(i).getValue().replaceAll("[^0-9^.]+", "");
                            String temp = null; 
                            if(str.equals("")){
                                temp = null;
                             }
                             else{
                                temp =  str;
                             }
                            pojo.setCircumferential_length(temp);
                         }
                         else if(ListOfPOJO_Rows.get(i).getLabel().contains("maximum depth")){
                            String str = ListOfPOJO_Rows.get(i).getValue().replaceAll("[^0-9^.]+", "");
                            String temp = null; 
                            if(str.equals("")){
                                temp = null;
                             }
                             else{
                                temp =  str;
                             }
                            pojo.setMax_depth(temp); 
                         }
                         else if(ListOfPOJO_Rows.get(i).getLabel().contains("remaining wall thickness")){
                            String str = ListOfPOJO_Rows.get(i).getValue().replaceAll("[^0-9^.]+", "");
                            String temp = null; 
                            if(str.equals("")){
                                temp = null;
                             }
                             else{
                                temp =  str;
                             }
                            pojo.setRemaining_wall_thickness_in(temp);   
                         }
                         
                         i++;
                     }
                     PopulateOperation.insertData2DefectDetails1(pojo);
            }
            }
            //-------------------------------
            //exam num, row num into ultra sonic
            if(ListOfPOJO_Rows.get(i).getLabel().contains("distance from zero point") && ListOfPOJO_Rows.get(i).getValue() != null &&
                    !ListOfPOJO_Rows.get(i).getValue().equals("")){
                String tp = ListOfPOJO_Rows.get(i).getValue().replace(" ", "");
                if(!tp.equals("")){
                    MainPOJO pojo = new MainPOJO();
                    pojo.setGps_file_name(PojoPop.mainPojo.getGps_file_name());
                    String tempStr = ListOfPOJO_Rows.get(i).getLabel().substring(ListOfPOJO_Rows.get(i).getLabel().indexOf("point") + "point".length());
                    String TableRowNum = tempStr;
                    String TablePkey = pojo.getGps_file_name() + " " + tempStr;
                    pojo.setUltraRowPkey(TablePkey);
                    pojo.setDist_from_zero_point(ListOfPOJO_Rows.get(i).getValue());
                    
                    PopulateOperation.insertData2Ultra(pojo);

                    i++;
                    while(!ListOfPOJO_Rows.get(i).getLabel().contains("distance from zero point") && !ListOfPOJO_Rows.get(i).getLabel().contains("icda scrub #1: min") &&
                           !ListOfPOJO_Rows.get(i).getLabel().contains("indicate units of measure:") && !ListOfPOJO_Rows.get(i).getLabel().contains("location of samples")  ){
                        
                        if(ListOfPOJO_Rows.get(i).getLabel().contains("12 o'clock")){
                            String temp;
                            ListOfPOJO_Rows.get(i).setValue(ListOfPOJO_Rows.get(i).getValue().replaceAll("[^0-9^.]+", ""));
                            if(ListOfPOJO_Rows.get(i).getValue().equals("")){
                                temp = null;
                            }
                            else{
                                temp = ListOfPOJO_Rows.get(i).getValue();
                            }
                            pojo.setClock_12(temp);
                        }
                        else if(ListOfPOJO_Rows.get(i).getLabel().contains("9 o'clock")){
                            String temp;
                            ListOfPOJO_Rows.get(i).setValue(ListOfPOJO_Rows.get(i).getValue().replaceAll("[^0-9^.]+", ""));
                            if(ListOfPOJO_Rows.get(i).getValue().equals("")){
                                temp = null;
                            }
                            else{
                                temp = ListOfPOJO_Rows.get(i).getValue();
                            }
                            pojo.setClock_9(temp);
                        }
                        else if(ListOfPOJO_Rows.get(i).getLabel().contains("6 o'clock")){
                            String temp;
                            ListOfPOJO_Rows.get(i).setValue(ListOfPOJO_Rows.get(i).getValue().replaceAll("[^0-9^.]+", ""));
                            if(ListOfPOJO_Rows.get(i).getValue().equals("")){
                                temp = null;
                            }
                            else{
                                temp = ListOfPOJO_Rows.get(i).getValue();
                            }
                            pojo.setClock_6(temp);
                        }
                        else if(ListOfPOJO_Rows.get(i).getLabel().contains("3 o'clock")){
                            String temp;
                            ListOfPOJO_Rows.get(i).setValue(ListOfPOJO_Rows.get(i).getValue().replaceAll("[^0-9^.]+", ""));
                            if(ListOfPOJO_Rows.get(i).getValue().equals("")){
                                temp = null;
                            }
                            else{
                                temp = ListOfPOJO_Rows.get(i).getValue();
                            }
                            pojo.setClock_3(temp);
                        }
                        else if(ListOfPOJO_Rows.get(i).getLabel().contains("(h-l)/h = wt âˆ†% (10% max)")){
                            String temp;
                            ListOfPOJO_Rows.get(i).setValue(ListOfPOJO_Rows.get(i).getValue().replaceAll("[^0-9^.]+", ""));
                            if(ListOfPOJO_Rows.get(i).getValue().equals("")){
                                temp = null;
                            }
                            else{
                                temp = ListOfPOJO_Rows.get(i).getValue();
                            }
                            pojo.setWt_percentage(temp);
                        }
                        i++;
                    }
                    
                    PopulateOperation.insertData2UltraDetails(pojo);

                }
            }
            
            //-------------------------------
            if(flag == 1){
                i--;
                flag = 0;
            }
            
            if(ListOfPOJO_Rows.get(i).getLabel().equals("title") && ListOfPOJO_Rows.get(i).getValue() != null ){
                    MainPOJO pojo = new MainPOJO();
                    pojo.setGps_file_name(PojoPop.mainPojo.getGps_file_name());
                    pojo.setTitle(PojoPop.mainPojo.getGps_file_name() + " " + ListOfPOJO_Rows.get(i).getValue());
                    PopulateOperation.insertData2BacterialSampleDetail(pojo);
                    
                    int j = 0;
                    i++;
                    
                    //--------------------------------
                    while(!ListOfPOJO_Rows.get(i).getLabel().equals("title") && !ListOfPOJO_Rows.get(i).getLabel().equals("severity of coating anomaly suspected") &&
                            !ListOfPOJO_Rows.get(i).getLabel().equals("inspector?s comments:")){
                        
                        if(i >= ListOfPOJO_Rows.size() -1){
                            break;
                        }
                        
                        if(ListOfPOJO_Rows.get(i).getLabel().contains("cap color(")){
                            j++;
                            flag = 1;
                            pojo.setCap_color(ListOfPOJO_Rows.get(i).getValue());
                        }
                        if(ListOfPOJO_Rows.get(i).getLabel().contains("bottle #(")){
                            j++;
                            if(ListOfPOJO_Rows.get(i).getValue().equals("")){
                                pojo.setBottle_num(null);
                            }else{
                            String temp = ListOfPOJO_Rows.get(i).getValue();
                            pojo.setBottle_num(temp);
                            pojo.setTitle_gps_row(pojo.getTitle() + " " + pojo.getCap_color() + " " + pojo.getBottle_num()  );
                        }}
                        if(ListOfPOJO_Rows.get(i).getLabel().contains("results week 1(")){
                            j++;
                            pojo.setResults_w1(ListOfPOJO_Rows.get(i).getValue());
                        }
                        if(ListOfPOJO_Rows.get(i).getLabel().contains("results week 2(")){
                            j++;
                            pojo.setResults_w2(ListOfPOJO_Rows.get(i).getValue());
                        }
                        if(ListOfPOJO_Rows.get(i).getLabel().contains("comments(")){
                            j++;
                            pojo.setComments(ListOfPOJO_Rows.get(i).getValue());
                        }
                        
                        if(j == 5){
                            j = 0;
                            //pojo is populated
                            //now insert the thing.
                            PopulateOperation.insertData2BacterialSampleDetail1(pojo);
                        }
                        i++;
                    }
                }
        }
    
    }
    
    
    
}

