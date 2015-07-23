/*
 * This class populates MainPOJO elements coresponding to the following ddatabase table:
 * examination_specific_details, direct_examination_details
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
       mainPojo.MainPOJOInit();
       
        for(int i=0; i< ExtractPOJOList.size(); i++){
            if(ExtractPOJOList.get(i).getLabel().equals("examination number") || ExtractPOJOList.get(i).getLabel().equals("exam number")){
                mainPojo.setExamination_number(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("de location id")){
                mainPojo.setDE_Location_ID(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("hca#") || ExtractPOJOList.get(i).getLabel().equals("hca name")){
                mainPojo.setHCA_Name(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("work request no.")){
                mainPojo.setWork_request_no(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("division")){
                mainPojo.setDivision(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("district number")){
                mainPojo.setDistrict_number(ExtractPOJOList.get(i).getValue());
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
                mainPojo.setGPS_synchronized_date(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("start: gps x")){
                mainPojo.setField_location_start_x(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("y") && 
                    ExtractPOJOList.get(i-1).getLabel().equals("start: gps x")){
                mainPojo.setField_location_start_y(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("end: gps x")){
                mainPojo.setField_location_start_x(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("y") && 
                    ExtractPOJOList.get(i-1).getLabel().equals("end: gps x")){
                mainPojo.setField_location_end_y(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("gps file name")){
                mainPojo.setGps_file_name(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("region") || ExtractPOJOList.get(i).getLabel().equals("ecda region") ){
                mainPojo.setRegion(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("planned examination length")){
                mainPojo.setPlanned_exam_len_ft(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("actual examination length")){
                mainPojo.setActual_exam_len_ft(ExtractPOJOList.get(i).getValue());
            }
            //---------------------------------------------------------------------------------Section 1
            else if(ExtractPOJOList.get(i).getLabel().equals("foreign pipe in excavation")){
                mainPojo.setForeign_pipe_in_excava(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("size")){
                mainPojo.setSize(ExtractPOJOList.get(i).getValue());
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
                mainPojo.setPercent_consumed(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("temp")){
                mainPojo.setTemperature(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("time 24-hr")){
                mainPojo.setTime_24(ExtractPOJOList.get(i).getValue());
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
                mainPojo.setDepth_of_cover(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("nominal size")){
                mainPojo.setNominal_size(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("indiam")){
                mainPojo.setIn_diam(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("wthick")){
                mainPojo.setWthick(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("grade")){
                mainPojo.setGrade(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("yield")){
                mainPojo.setYield(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("coating")){
                mainPojo.setCoating(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("wkreqno")){
                mainPojo.setWk_req_no(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("installation month")){
                mainPojo.setInstallation_month(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("installation year")){
                mainPojo.setInstallation_year(ExtractPOJOList.get(i).getValue());
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
            //-------------------------------------------------------------------------
            else if(ExtractPOJOList.get(i).getLabel().equals("holiday detection volt setting")){
               mainPojo.setHoliday_detec_colt_setting(ExtractPOJOList.get(i).getValue());
            }
            //-------------------------------------------------------------------------
            else if(ExtractPOJOList.get(i).getLabel().equals("non-corrosive disbondment % damage")){
                mainPojo.setPer_dam_ncorros_disbond(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("non-corrosive disbondment o'clock/position")){
                mainPojo.setO_clock_ncorros_disbond(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("blistering due to corrosion % damage")){
                mainPojo.setPercent_damage_blistering(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("blistering due to corrosion o'clock/position")){
                mainPojo.setO_clock_damage_blistering(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("ground cover found:")){
                mainPojo.setGround_cover_type(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("ph of fluid in blisters")){
                mainPojo.setBlister_fluid_ph(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("i have reviewed the procedures performed and have found them:")){
                mainPojo.setProcedure_adequate_flag(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("inspected by")){
                mainPojo.setInspected_by(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("inspection date")){
                mainPojo.setInspection_date(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("reviewed by")){
                mainPojo.setReviewed_by(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("date reviewed")){
                mainPojo.setReviewed_date(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("soil ph at pipe depth")){
                mainPojo.setSoilph_at_pipe_depth(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("soil resistivity at pipe depth")){
                mainPojo.setSoil_resistivity_at_pipe_depth(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("soil chemistry performed")){
                mainPojo.setSoil_chem_performed_flag(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("method used - ") || ExtractPOJOList.get(i).getLabel().equals("method used -") ){
                mainPojo.setMethod_used(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("chlorides")){
                mainPojo.setChlorides_ppm(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("nitrates")){
                mainPojo.setNitrates_ppm(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("sulfates")){
                mainPojo.setSulfates_ppm(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("6 o'clock") || ExtractPOJOList.get(i).getLabel().equals("Pipe to Soil from Start of Excavation: 6 o'clock") ){
                mainPojo.setPipe_to_soil_frm_exc_6_oclock(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("Pipe to Soil from Start of Excavation: 3 o'clock") ){
                mainPojo.setPipe_to_soil_frm_exc_3_oclock(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("Pipe to Soil from Start of Excavation: 9 o'clock") ){
                mainPojo.setPipe_to_soil_frm_exc_9_oclock(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("pipe to soil from start of excavation: 12 o'clock") ){
                mainPojo.setPipe_to_soil_frm_exc_12_oclock(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("bacterial samples taken")){
                mainPojo.setBacterial_samples_taken(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("asphalt and/or tar wrap samples taken")){
                mainPojo.setAsphalt_tar_samples_taken(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("date of incubation")){
                mainPojo.setDate_of_incubation(ExtractPOJOList.get(i).getValue());
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
                mainPojo.setCrt_date_calc_completed(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("inspector?s comments:")){
                mainPojo.setInspector_comments(ExtractPOJOList.get(i).getValue());
            }
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
                mainPojo.setMin_ICDA_scrub_1(ExtractPOJOList.get(i).getValue());
            }
            else if(i>2 && ExtractPOJOList.get(i-1).getLabel().equals("icda scrub #1: min") && ExtractPOJOList.get(i).getLabel().equals("max")){
                mainPojo.setMax_ICDA_scrub_1(ExtractPOJOList.get(i).getValue());
            }
            else if(i>2 && ExtractPOJOList.get(i-2).getLabel().equals("icda scrub #1: min") && ExtractPOJOList.get(i).getLabel().equals("wt ?%")){
                mainPojo.setWt_percentage_scrub1(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("icda scrub #2: min")){
                mainPojo.setMin_ICDA_scrub_2(ExtractPOJOList.get(i).getValue());
            }
            else if(i>2 && ExtractPOJOList.get(i-1).getLabel().equals("icda scrub #2: min") && ExtractPOJOList.get(i).getLabel().equals("max")){
                mainPojo.setMax_ICDA_scrub_2(ExtractPOJOList.get(i).getValue());
            }
            else if(i>2 && ExtractPOJOList.get(i-2).getLabel().equals("icda scrub #2: min") && ExtractPOJOList.get(i).getLabel().equals("wt ?%")){
                mainPojo.setWt_percentage_scrub2(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("location of samples")){
                mainPojo.setLocation_of_samples(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("collected by")){
                mainPojo.setCollected_by(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("date collected")){
                mainPojo.setDate_collected(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("7th day interpreted by")){
                mainPojo.setSeven_day_interpreted_by(ExtractPOJOList.get(i).getValue());
            }
            else if(i>1 && ExtractPOJOList.get(i-1).getLabel().equals("7th day interpreted by") && ExtractPOJOList.get(i).getLabel().equals("date of reading")){
                mainPojo.setSeven_day_date_of_reading(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().equals("14th day interpreted by")){
                mainPojo.setFourteen_day_interpreted_by(ExtractPOJOList.get(i).getValue());
            }
            else if(i>1 && ExtractPOJOList.get(i-1).getLabel().equals("14th day interpreted by") && ExtractPOJOList.get(i).getLabel().equals("date of reading")){
                mainPojo.setFourteen_day_date_of_reading(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().contains("inadequate cp currentfor this hca exam")){
                mainPojo.setInadequate_CP_current_HCA_exam(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().contains("no cp for a known period of timefor this hca exam")){
                mainPojo.setNo_CP_time_HCA_exam(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().contains("no cp with dissimilar metal couplingsfor this hca exam")){
                mainPojo.setNo_CP_metal_couplings_HCA_exam(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().contains("previously unidentified source of interferencefor this hca exam")){
                mainPojo.setInterference_source_HCA_exam(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().contains("shielding occurred by disbonded coatingfor this hca exam")){
                mainPojo.setShielding_HCA_exam(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().contains("mic or biological corrosionfor this hca exam")){
                mainPojo.setMIC_HCA_exam(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().contains("other (specify):for this hca exam")){
                mainPojo.setOther_root_cause_HCA_exam(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().contains("inadequate cp currentof other exams on this hca")){
                mainPojo.setOther_root_cause_HCA_examOther(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().contains("no cp for a known period of timeof other exams on this hca")){
                mainPojo.setNo_CP_time_HCA_examOther(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().contains("no cp with dissimilar metal couplingsof other exams on this hca")){
                mainPojo.setNo_CP_metal_couplings_HCA_examOther(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().contains("previously unidentified source of interferenceof other exams on this hca")){
                mainPojo.setInterference_source_HCA_examOther(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().contains("shielding occurred by disbonded coatingof other exams on this hca")){
                mainPojo.setShielding_HCA_examOther(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().contains("mic or biological corrosionof other exams on this hca")){
                mainPojo.setMIC_HCA_examOther(ExtractPOJOList.get(i).getValue());
            }
            else if(ExtractPOJOList.get(i).getLabel().contains("other (specify):of other exams on this hca")){
                mainPojo.setOther_root_cause_HCA_examOther(ExtractPOJOList.get(i).getValue());
            }
            
        }
        
    }
}
