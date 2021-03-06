/*
 * This class is the mainPOJO class. 
 * It exactly matches all the elements and fields of the database.
 */
package com.swg.parse.Form213Pojo;

import java.util.Date;

/**
 *
 * @author KXK3
 */
public class MainPOJO {
    public String DE_Location_ID;
    public String HCA_Name;
    public String Examination_number;
    public String work_request_no;
    public String division;
    public String district_number;
    public String town_or_county;
    public String state;
    public String Tile_Number;
    public String Address;
    public String Inspection_company;
    public String GPS_synchronized_date;
    public String field_location_start_x;
    public String field_location_start_y;
    public String field_location_end_x;
    public String field_location_end_y;
    public String gps_file_name;
    public String region;
    public String planned_exam_len_ft;
    public String actual_exam_len_ft;
    //----------------------------------- ~ Section 2
    public String foreign_pipe_in_excava;
    public String size;    
    public String material;
    public String foreign_current;
    public String cp_present;
    public String bond_present;
    public String current_flow_to;
    public String current_flow_from;
    public String anode_present;
    public String percent_consumed;
    public String temperature;
    public String time_24;
    public String weather_conditions;
    public String soil_conditions;
    public String bedding_shading_type;
    public String rockshield_used;
    public String soil_type;
    public String depth_of_cover;
    public String nominal_size;
    public String in_diam;
    public String wthick;
    public String grade;
    public String yield;
    public String coating;
    public String wk_req_no;
    public String installation_month;
    public String installation_year;
    public String ops_sys_name;
    public String weld_seam;
    public String coating_types;
    public String coating_condition;
    public String holiday_detec_colt_setting;
    public String per_dam_ncorros_disbond;
    public String o_clock_ncorros_disbond;
    public String percent_damage_blistering;
    public String o_clock_damage_blistering;
    public String ground_cover_type;
    public String blister_fluid_ph;
    public String procedure_adequate_flag;
    public String inspected_by;
    public String inspection_date;
    public String reviewed_by;
    public String reviewed_date;
    //--------------------------------------- ~ Section3
    public String soilph_at_pipe_depth;
    public String soil_resistivity_at_pipe_depth;
    public String soil_chem_performed_flag;
    public String method_used;
    public String chlorides_ppm;
    public String nitrates_ppm;
    public String sulfates_ppm;
    public String pipe_to_soil_frm_exc_6_oclock;
    public String pipe_to_soil_frm_exc_3_oclock;
    public String pipe_to_soil_frm_exc_9_oclock;
    public String pipe_to_soil_frm_exc_12_oclock;
    public String bacterial_samples_taken;
    public String asphalt_tar_samples_taken;
    public String defects_found;
    public String defects_comments;
    public String cause_of_corrosion;
    public String date_of_incubation;
    //---------------------------------- ~Section 3,4 and 5 without tables
    public String suspec_severity_coating_anom ;
    public String found_severity_coating_anomaly ;
    public String DE_defect_severity;
    public String severity_coatinganomaly2xpctd;
    public String initial_assessment_covered_seg;
    public String need_to_adjust_sct_flag;
    public String corrosion_found;
    public String b_or_c_priority_flag;
    public String more_severe_than_A_priority;
    public String sct_assessed_for_adjustment;
    public String changes_made_to_sct_flag;
    public String add_indirect_surveys_needed;
    public String significant_corrosion_flag;
    public String review_conducted_flag;
    public String alt_methods_requirement_flag;
    public String corros_other_location_sameHCA;
    public String similar_rootcause_same_HCA;
    public String crt_date_calc_completed;
    public String inspector_comments;
    public String remed_action_requirement_flag;
    public String reference_request_number;
    public String repair_quickness;
    public String remediation_comments;
    public String if_no_moc_explain_why;    //done
    public String explanation_for_other;
    //---------------------------------- ~end of doc
    public String ultrasonicthickness_comments;
    public String min_ICDA_scrub_1;
    public String max_ICDA_scrub_1;
    public String wt_percentage_scrub1;
    public String min_ICDA_scrub_2;
    public String max_ICDA_scrub_2;
    public String wt_percentage_scrub2;
    //---------------------------------- ~some of section 5
    public String location_of_samples;
    public String collected_by;
    public String date_collected;
    public String seven_day_interpreted_by;
    public String seven_day_date_of_reading;
    public String fourteen_day_interpreted_by;
    public String fourteen_day_date_of_reading;
    //---------------------------------- ~some of section 6
    public String title;
    public String title_gps_row;
    //--------------------------------- ~beginning of bacterial table handling
    public String cap_color;
    public String bottle_num;
    public String results_w1;
    public String results_w2;
    public String comments;
    //---------------------------------- ~end of bacterial table handling
    public String UltraRowNum;
    public String UltraRowPkey;
    //---------------------------------- ~beginning of ultrasonic table handling
    public String Dist_from_zero_point;
    public String clock_12;
    public String clock_3;
    public String clock_6;
    public String clock_9;
    public String wt_percentage;
    //---------------------------------- ~end of ultrasonic table handling
    public String defect_title;
    //---------------------------------- ~beginning of defect table handling
    public String defect_number;
    public String defect_type;
    public String distance_from_zero;
    public String o_clock_position;
    public String axial_length;
    public String circumferential_length;
    public String max_depth;
    public String repair_category;
    public String corrosion_interactivity;
    public String remaining_wall_thickness_in;
    //---------------------------------- ~end of defect table handling
    public String Inadequate_CP_current_HCA_exam;
    public String No_CP_time_HCA_exam;
    public String No_CP_metal_couplings_HCA_exam;
    public String interference_source_HCA_exam;
    public String shielding_HCA_exam;
    public String MIC_HCA_exam;
    public String other_root_cause_HCA_exam;
    public String Inadequate_CP_current_HCA_examOther;
    public String No_CP_time_HCA_examOther;
    public String No_CP_metal_couplings_HCA_examOther;
    public String interference_source_HCA_examOther;
    public String shielding_HCA_examOther;
    public String MIC_HCA_examOther;
    public String other_root_cause_HCA_examOther;
    //---------------------------------- ~special table on Version0
//    public Float normal_size_range_from;
//    public Float normal_size_range_to;
//    public Float InDiam_range_from;
//    public Float InDiam_range_to;
//    public Float wthick_range_from;
//    public Float wthick_range_to;
//    public Integer yield_range_from;
//    public Integer yield_range_to;
//    public Integer installation_month_range_from;
//    public Integer installation_month_range_to;
//    public Integer installation_year_range_from;
//    public Integer installation_year_range_to;
//    public Integer holiday_detection_volt_range_from;
//    public Integer holiday_detection_volt_range_to;
//    public Integer size_range_to;
//    public Integer size_range_from;
    //------------------------------------- ~ranges NOT NEEDED AT VERSION BETA

    public void MainPOJOInit(){
//        this.size_range_from = null;
//        this.size_range_to = null;
        this.setDE_Location_ID(null);
        this.setHCA_Name(null);
        this.setExamination_number(null);
        this.setWork_request_no(null);
        this.setDivision(null);
        this.setDistrict_number(null);
        this.setTown_or_county(null);
        this.setState(null);
        this.setTile_Number(null);
        this.setAddress(null);
        this.setInspection_company(null);
        this.setGPS_synchronized_date(null);
        this.setField_location_start_x(null);
        this.setField_location_start_y(null);
        this.setField_location_end_x(null);
        this.setField_location_end_y(null);
        this.setGps_file_name(null);
        this.setRegion(null);
        this.setPlanned_exam_len_ft(null);
        this.setActual_exam_len_ft(null);
        this.setForeign_pipe_in_excava(null);
        this.setSize(null);    
        this.setMaterial(null);
        this.setForeign_current(null);
        this.setCp_present(null);
        this.setBond_present(null);
        this.setCurrent_flow_to(null);
        this.setCurrent_flow_from(null);
        this.setAnode_present(null);
        this.setPercent_consumed(null);
        this.setTemperature(null);
        this.setTime_24(null);
        this.setWeather_conditions(null);
        this.setSoil_conditions(null);
        this.setBedding_shading_type(null);
        this.setRockshield_used(null);
        this.setSoil_type(null);
        this.setDepth_of_cover(null);
        this.setNominal_size(null);
        this.setIn_diam(null);
        this.setWthick(null);
        this.setGrade(null);
        this.setYield(null);
        this.setCoating(null);
        this.setWk_req_no(null);
        this.setInstallation_month(null);
        this.setInstallation_year(null);
        this.setOps_sys_name(null);
        this.setWeld_seam(null);
        this.setCoating_types(null);
        this.setCoating_condition(null);
        this.setHoliday_detec_colt_setting(null);
        this.setPer_dam_ncorros_disbond(null);
        this.setO_clock_ncorros_disbond(null);
        this.setPercent_damage_blistering(null);
        this.setO_clock_damage_blistering(null);
        this.setGround_cover_type(null);
        this.setBlister_fluid_ph(null);
        this.setProcedure_adequate_flag(null);
        this.setInspected_by(null);
        this.setInspection_date(null);
        this.setReviewed_by(null);
        this.setReviewed_date(null);
        this.setSoilph_at_pipe_depth(null);
        this.setSoil_resistivity_at_pipe_depth(null);
        this.setSoil_chem_performed_flag(null);
        this.setMethod_used(null);
        this.setChlorides_ppm(null);
        this.setNitrates_ppm(null);
        this.setSulfates_ppm(null);
        this.setPipe_to_soil_frm_exc_6_oclock(null);
        this.setPipe_to_soil_frm_exc_3_oclock(null);
        this.setPipe_to_soil_frm_exc_9_oclock(null);
        this.setPipe_to_soil_frm_exc_12_oclock(null);
        this.setBacterial_samples_taken(null);
        this.setAsphalt_tar_samples_taken(null);
        this.setDefects_found(null);
        this.setDefects_comments(null);
        this.setCause_of_corrosion(null);
        this.setDate_of_incubation(null);
        this.setSuspec_severity_coating_anom(null);
        this.setFound_severity_coating_anomaly(null);
        this.setDE_defect_severity(null);
        this.setSeverity_coatinganomaly2xpctd(null);
        this.setInitial_assessment_covered_seg(null);
        this.setNeed_to_adjust_sct_flag(null);
        this.setCorrosion_found(null);
        this.setB_or_c_priority_flag(null);
        this.setMore_severe_than_A_priority(null);
        this.setSct_assessed_for_adjustment(null);
        this.setChanges_made_to_sct_flag(null);
        this.setAdd_indirect_surveys_needed(null);
        this.setSignificant_corrosion_flag(null);
        this.setReview_conducted_flag(null);
        this.setAlt_methods_requirement_flag(null);
        this.setCorros_other_location_sameHCA(null);
        this.setSimilar_rootcause_same_HCA(null);
        this.setCrt_date_calc_completed(null);
        this.setInspector_comments(null);
        this.setRemed_action_requirement_flag(null);
        this.setReference_request_number(null);
        this.setRepair_quickness(null);
        this.setRemediation_comments(null);
        this.setIf_no_moc_explain_why(null);
        this.setExplanation_for_other(null);
        this.setUltrasonicthickness_comments(null);
        this.setMin_ICDA_scrub_1(null);
        this.setMax_ICDA_scrub_1(null);
        this.setWt_percentage_scrub1(null);
        this.setMin_ICDA_scrub_2(null);
        this.setMax_ICDA_scrub_2(null);
        this.setWt_percentage_scrub2(null);
        this.setLocation_of_samples(null);
        this.setCollected_by(null);
        this.setDate_collected(null);
        this.setSeven_day_interpreted_by(null);
        this.setSeven_day_date_of_reading(null);
        this.setFourteen_day_interpreted_by(null);
        this.setFourteen_day_date_of_reading(null);
        this.setTitle(null);
        this.setCap_color(null);
        this.setBottle_num(null);
        this.setResults_w1(null);
        this.setResults_w2(null);
        this.setComments(null);
        this.setUltraRowNum(null);
        this.setUltraRowPkey(null);
        this.setDist_from_zero_point(null);
        this.setClock_12(null);
        this.setClock_3(null);
        this.setClock_6(null);
        this.setClock_9(null);
        this.setWt_percentage(null);
        this.setDefect_title(null);
        this.setDefect_number(null);
        this.setDefect_type(null);
        this.setDistance_from_zero(null);
        this.setO_clock_position(null);
        this.setAxial_length(null);
        this.setCircumferential_length(null);
        this.setMax_depth(null);
        this.setRepair_category(null);
        this.setCorrosion_interactivity(null);
        this.setRemaining_wall_thickness_in(null);
        this.setInadequate_CP_current_HCA_exam(null);
        this.setNo_CP_time_HCA_exam(null);
        this.setNo_CP_metal_couplings_HCA_exam(null);
        this.setInterference_source_HCA_exam(null);
        this.setShielding_HCA_exam(null);
        this.setMIC_HCA_exam(null);
        this.setOther_root_cause_HCA_exam(null);
        this.setInadequate_CP_current_HCA_examOther(null);
        this.setNo_CP_time_HCA_examOther(null);
        this.setNo_CP_metal_couplings_HCA_examOther(null);
        this.setInterference_source_HCA_examOther(null);
        this.setShielding_HCA_examOther(null);
        this.setMIC_HCA_examOther(null);
        this.setOther_root_cause_HCA_examOther(null);
//        this.normal_size_range_from = null;
//        this.normal_size_range_to = null;
//        this.InDiam_range_from = null;
//        this.InDiam_range_to = null;
//        this.wthick_range_from = null;
//        this.wthick_range_to = null;
//        this.yield_range_from = null;
//        this.yield_range_to = null;
//        this.installation_month_range_from = null;
//        this.installation_month_range_to = null;
//        this.installation_year_range_from = null;
//        this.installation_year_range_to = null;
//        this.holiday_detection_volt_range_from = null;
//        this.holiday_detection_volt_range_to = null;
    }
    
    public void clearIt(){
                this.setDE_Location_ID(null);
        this.setHCA_Name(null);
        this.setExamination_number(null);
        this.setWork_request_no(null);
        this.setDivision(null);
        this.setDistrict_number(null);
        this.setTown_or_county(null);
        this.setState(null);
        this.setTile_Number(null);
        this.setAddress(null);
        this.setInspection_company(null);
        this.setGPS_synchronized_date(null);
        this.setField_location_start_x(null);
        this.setField_location_start_y(null);
        this.setField_location_end_x(null);
        this.setField_location_end_y(null);
        this.setGps_file_name(null);
        this.setRegion(null);
        this.setPlanned_exam_len_ft(null);
        this.setActual_exam_len_ft(null);
        this.setForeign_pipe_in_excava(null);
        this.setSize(null);    
        this.setMaterial(null);
        this.setForeign_current(null);
        this.setCp_present(null);
        this.setBond_present(null);
        this.setCurrent_flow_to(null);
        this.setCurrent_flow_from(null);
        this.setAnode_present(null);
        this.setPercent_consumed(null);
        this.setTemperature(null);
        this.setTime_24(null);
        this.setWeather_conditions(null);
        this.setSoil_conditions(null);
        this.setBedding_shading_type(null);
        this.setRockshield_used(null);
        this.setSoil_type(null);
        this.setDepth_of_cover(null);
        this.setNominal_size(null);
        this.setIn_diam(null);
        this.setWthick(null);
        this.setGrade(null);
        this.setYield(null);
        this.setCoating(null);
        this.setWk_req_no(null);
        this.setInstallation_month(null);
        this.setInstallation_year(null);
        this.setOps_sys_name(null);
        this.setWeld_seam(null);
        this.setCoating_types(null);
        this.setCoating_condition(null);
        this.setHoliday_detec_colt_setting(null);
        this.setPer_dam_ncorros_disbond(null);
        this.setO_clock_ncorros_disbond(null);
        this.setPercent_damage_blistering(null);
        this.setO_clock_damage_blistering(null);
        this.setGround_cover_type(null);
        this.setBlister_fluid_ph(null);
        this.setProcedure_adequate_flag(null);
        this.setInspected_by(null);
        this.setInspection_date(null);
        this.setReviewed_by(null);
        this.setReviewed_date(null);
        this.setSoilph_at_pipe_depth(null);
        this.setSoil_resistivity_at_pipe_depth(null);
        this.setSoil_chem_performed_flag(null);
        this.setMethod_used(null);
        this.setChlorides_ppm(null);
        this.setNitrates_ppm(null);
        this.setSulfates_ppm(null);
        this.setPipe_to_soil_frm_exc_6_oclock(null);
        this.setPipe_to_soil_frm_exc_3_oclock(null);
        this.setPipe_to_soil_frm_exc_9_oclock(null);
        this.setPipe_to_soil_frm_exc_12_oclock(null);
        this.setBacterial_samples_taken(null);
        this.setAsphalt_tar_samples_taken(null);
        this.setDefects_found(null);
        this.setDefects_comments(null);
        this.setCause_of_corrosion(null);
        this.setDate_of_incubation(null);
        this.setSuspec_severity_coating_anom(null);
        this.setFound_severity_coating_anomaly(null);
        this.setDE_defect_severity(null);
        this.setSeverity_coatinganomaly2xpctd(null);
        this.setInitial_assessment_covered_seg(null);
        this.setNeed_to_adjust_sct_flag(null);
        this.setCorrosion_found(null);
        this.setB_or_c_priority_flag(null);
        this.setMore_severe_than_A_priority(null);
        this.setSct_assessed_for_adjustment(null);
        this.setChanges_made_to_sct_flag(null);
        this.setAdd_indirect_surveys_needed(null);
        this.setSignificant_corrosion_flag(null);
        this.setReview_conducted_flag(null);
        this.setAlt_methods_requirement_flag(null);
        this.setCorros_other_location_sameHCA(null);
        this.setSimilar_rootcause_same_HCA(null);
        this.setCrt_date_calc_completed(null);
        this.setInspector_comments(null);
        this.setRemed_action_requirement_flag(null);
        this.setReference_request_number(null);
        this.setRepair_quickness(null);
        this.setRemediation_comments(null);
        this.setIf_no_moc_explain_why(null);
        this.setExplanation_for_other(null);
        this.setUltrasonicthickness_comments(null);
        this.setMin_ICDA_scrub_1(null);
        this.setMax_ICDA_scrub_1(null);
        this.setWt_percentage_scrub1(null);
        this.setMin_ICDA_scrub_2(null);
        this.setMax_ICDA_scrub_2(null);
        this.setWt_percentage_scrub2(null);
        this.setLocation_of_samples(null);
        this.setCollected_by(null);
        this.setDate_collected(null);
        this.setSeven_day_interpreted_by(null);
        this.setSeven_day_date_of_reading(null);
        this.setFourteen_day_interpreted_by(null);
        this.setFourteen_day_date_of_reading(null);
        this.setTitle(null);
        this.setCap_color(null);
        this.setBottle_num(null);
        this.setResults_w1(null);
        this.setResults_w2(null);
        this.setComments(null);
        this.setUltraRowNum(null);
        this.setUltraRowPkey(null);
        this.setDist_from_zero_point(null);
        this.setClock_12(null);
        this.setClock_3(null);
        this.setClock_6(null);
        this.setClock_9(null);
        this.setWt_percentage(null);
        this.setDefect_title(null);
        this.setDefect_number(null);
        this.setDefect_type(null);
        this.setDistance_from_zero(null);
        this.setO_clock_position(null);
        this.setAxial_length(null);
        this.setCircumferential_length(null);
        this.setMax_depth(null);
        this.setRepair_category(null);
        this.setCorrosion_interactivity(null);
        this.setRemaining_wall_thickness_in(null);
        this.setInadequate_CP_current_HCA_exam(null);
        this.setNo_CP_time_HCA_exam(null);
        this.setNo_CP_metal_couplings_HCA_exam(null);
        this.setInterference_source_HCA_exam(null);
        this.setShielding_HCA_exam(null);
        this.setMIC_HCA_exam(null);
        this.setOther_root_cause_HCA_exam(null);
        this.setInadequate_CP_current_HCA_examOther(null);
        this.setNo_CP_time_HCA_examOther(null);
        this.setNo_CP_metal_couplings_HCA_examOther(null);
        this.setInterference_source_HCA_examOther(null);
        this.setShielding_HCA_examOther(null);
        this.setMIC_HCA_examOther(null);
        this.setOther_root_cause_HCA_examOther(null);
    }

    /**
     * @return the DE_Location_ID
     */
    public String getDE_Location_ID() {
        return DE_Location_ID;
    }

    /**
     * @param DE_Location_ID the DE_Location_ID to set
     */
    public void setDE_Location_ID(String DE_Location_ID) {
        this.DE_Location_ID = DE_Location_ID;
    }

    /**
     * @return the HCA_Name
     */
    public String getHCA_Name() {
        return HCA_Name;
    }

    /**
     * @param HCA_Name the HCA_Name to set
     */
    public void setHCA_Name(String HCA_Name) {
        this.HCA_Name = HCA_Name;
    }

    /**
     * @return the Examination_number
     */
    public String getExamination_number() {
        return Examination_number;
    }

    /**
     * @param Examination_number the Examination_number to set
     */
    public void setExamination_number(String Examination_number) {
        this.Examination_number = Examination_number;
    }

    /**
     * @return the work_request_no
     */
    public String getWork_request_no() {
        return work_request_no;
    }

    /**
     * @param work_request_no the work_request_no to set
     */
    public void setWork_request_no(String work_request_no) {
        this.work_request_no = work_request_no;
    }

    /**
     * @return the division
     */
    public String getDivision() {
        return division;
    }

    /**
     * @param division the division to set
     */
    public void setDivision(String division) {
        this.division = division;
    }

    /**
     * @return the district_number
     */
    public String getDistrict_number() {
        return district_number;
    }

    /**
     * @param district_number the district_number to set
     */
    public void setDistrict_number(String district_number) {
        this.district_number = district_number;
    }

    /**
     * @return the town_or_county
     */
    public String getTown_or_county() {
        return town_or_county;
    }

    /**
     * @param town_or_county the town_or_county to set
     */
    public void setTown_or_county(String town_or_county) {
        this.town_or_county = town_or_county;
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return the Tile_Number
     */
    public String getTile_Number() {
        return Tile_Number;
    }

    /**
     * @param Tile_Number the Tile_Number to set
     */
    public void setTile_Number(String Tile_Number) {
        this.Tile_Number = Tile_Number;
    }

    /**
     * @return the Address
     */
    public String getAddress() {
        return Address;
    }

    /**
     * @param Address the Address to set
     */
    public void setAddress(String Address) {
        this.Address = Address;
    }

    /**
     * @return the Inspection_company
     */
    public String getInspection_company() {
        return Inspection_company;
    }

    /**
     * @param Inspection_company the Inspection_company to set
     */
    public void setInspection_company(String Inspection_company) {
        this.Inspection_company = Inspection_company;
    }

    /**
     * @return the GPS_synchronized_date
     */
    public String getGPS_synchronized_date() {
        return GPS_synchronized_date;
    }

    /**
     * @param GPS_synchronized_date the GPS_synchronized_date to set
     */
    public void setGPS_synchronized_date(String GPS_synchronized_date) {
        this.GPS_synchronized_date = GPS_synchronized_date;
    }

    /**
     * @return the field_location_start_x
     */
    public String getField_location_start_x() {
        return field_location_start_x;
    }

    /**
     * @param field_location_start_x the field_location_start_x to set
     */
    public void setField_location_start_x(String field_location_start_x) {
        this.field_location_start_x = field_location_start_x;
    }

    /**
     * @return the field_location_start_y
     */
    public String getField_location_start_y() {
        return field_location_start_y;
    }

    /**
     * @param field_location_start_y the field_location_start_y to set
     */
    public void setField_location_start_y(String field_location_start_y) {
        this.field_location_start_y = field_location_start_y;
    }

    /**
     * @return the field_location_end_x
     */
    public String getField_location_end_x() {
        return field_location_end_x;
    }

    /**
     * @param field_location_end_x the field_location_end_x to set
     */
    public void setField_location_end_x(String field_location_end_x) {
        this.field_location_end_x = field_location_end_x;
    }

    /**
     * @return the field_location_end_y
     */
    public String getField_location_end_y() {
        return field_location_end_y;
    }

    /**
     * @param field_location_end_y the field_location_end_y to set
     */
    public void setField_location_end_y(String field_location_end_y) {
        this.field_location_end_y = field_location_end_y;
    }

    /**
     * @return the gps_file_name
     */
    public String getGps_file_name() {
        return gps_file_name;
    }

    /**
     * @param gps_file_name the gps_file_name to set
     */
    public void setGps_file_name(String gps_file_name) {
        this.gps_file_name = gps_file_name;
    }

    /**
     * @return the region
     */
    public String getRegion() {
        return region;
    }

    /**
     * @param region the region to set
     */
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * @return the planned_exam_len_ft
     */
    public String getPlanned_exam_len_ft() {
        return planned_exam_len_ft;
    }

    /**
     * @param planned_exam_len_ft the planned_exam_len_ft to set
     */
    public void setPlanned_exam_len_ft(String planned_exam_len_ft) {
        this.planned_exam_len_ft = planned_exam_len_ft;
    }

    /**
     * @return the actual_exam_len_ft
     */
    public String getActual_exam_len_ft() {
        return actual_exam_len_ft;
    }

    /**
     * @param actual_exam_len_ft the actual_exam_len_ft to set
     */
    public void setActual_exam_len_ft(String actual_exam_len_ft) {
        this.actual_exam_len_ft = actual_exam_len_ft;
    }

    /**
     * @return the foreign_pipe_in_excava
     */
    public String getForeign_pipe_in_excava() {
        return foreign_pipe_in_excava;
    }

    /**
     * @param foreign_pipe_in_excava the foreign_pipe_in_excava to set
     */
    public void setForeign_pipe_in_excava(String foreign_pipe_in_excava) {
        this.foreign_pipe_in_excava = foreign_pipe_in_excava;
    }

    /**
     * @return the size
     */
    public String getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(String size) {
        this.size = size;
    }

    /**
     * @return the material
     */
    public String getMaterial() {
        return material;
    }

    /**
     * @param material the material to set
     */
    public void setMaterial(String material) {
        this.material = material;
    }

    /**
     * @return the foreign_current
     */
    public String getForeign_current() {
        return foreign_current;
    }

    /**
     * @param foreign_current the foreign_current to set
     */
    public void setForeign_current(String foreign_current) {
        this.foreign_current = foreign_current;
    }

    /**
     * @return the cp_present
     */
    public String getCp_present() {
        return cp_present;
    }

    /**
     * @param cp_present the cp_present to set
     */
    public void setCp_present(String cp_present) {
        this.cp_present = cp_present;
    }

    /**
     * @return the bond_present
     */
    public String getBond_present() {
        return bond_present;
    }

    /**
     * @param bond_present the bond_present to set
     */
    public void setBond_present(String bond_present) {
        this.bond_present = bond_present;
    }

    /**
     * @return the current_flow_to
     */
    public String getCurrent_flow_to() {
        return current_flow_to;
    }

    /**
     * @param current_flow_to the current_flow_to to set
     */
    public void setCurrent_flow_to(String current_flow_to) {
        this.current_flow_to = current_flow_to;
    }

    /**
     * @return the current_flow_from
     */
    public String getCurrent_flow_from() {
        return current_flow_from;
    }

    /**
     * @param current_flow_from the current_flow_from to set
     */
    public void setCurrent_flow_from(String current_flow_from) {
        this.current_flow_from = current_flow_from;
    }

    /**
     * @return the anode_present
     */
    public String getAnode_present() {
        return anode_present;
    }

    /**
     * @param anode_present the anode_present to set
     */
    public void setAnode_present(String anode_present) {
        this.anode_present = anode_present;
    }

    /**
     * @return the percent_consumed
     */
    public String getPercent_consumed() {
        return percent_consumed;
    }

    /**
     * @param percent_consumed the percent_consumed to set
     */
    public void setPercent_consumed(String percent_consumed) {
        this.percent_consumed = percent_consumed;
    }

    /**
     * @return the temperature
     */
    public String getTemperature() {
        return temperature;
    }

    /**
     * @param temperature the temperature to set
     */
    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    /**
     * @return the time_24
     */
    public String getTime_24() {
        return time_24;
    }

    /**
     * @param time_24 the time_24 to set
     */
    public void setTime_24(String time_24) {
        this.time_24 = time_24;
    }

    /**
     * @return the weather_conditions
     */
    public String getWeather_conditions() {
        return weather_conditions;
    }

    /**
     * @param weather_conditions the weather_conditions to set
     */
    public void setWeather_conditions(String weather_conditions) {
        this.weather_conditions = weather_conditions;
    }

    /**
     * @return the soil_conditions
     */
    public String getSoil_conditions() {
        return soil_conditions;
    }

    /**
     * @param soil_conditions the soil_conditions to set
     */
    public void setSoil_conditions(String soil_conditions) {
        this.soil_conditions = soil_conditions;
    }

    /**
     * @return the bedding_shading_type
     */
    public String getBedding_shading_type() {
        return bedding_shading_type;
    }

    /**
     * @param bedding_shading_type the bedding_shading_type to set
     */
    public void setBedding_shading_type(String bedding_shading_type) {
        this.bedding_shading_type = bedding_shading_type;
    }

    /**
     * @return the rockshield_used
     */
    public String getRockshield_used() {
        return rockshield_used;
    }

    /**
     * @param rockshield_used the rockshield_used to set
     */
    public void setRockshield_used(String rockshield_used) {
        this.rockshield_used = rockshield_used;
    }

    /**
     * @return the soil_type
     */
    public String getSoil_type() {
        return soil_type;
    }

    /**
     * @param soil_type the soil_type to set
     */
    public void setSoil_type(String soil_type) {
        this.soil_type = soil_type;
    }

    /**
     * @return the depth_of_cover
     */
    public String getDepth_of_cover() {
        return depth_of_cover;
    }

    /**
     * @param depth_of_cover the depth_of_cover to set
     */
    public void setDepth_of_cover(String depth_of_cover) {
        this.depth_of_cover = depth_of_cover;
    }

    /**
     * @return the nominal_size
     */
    public String getNominal_size() {
        return nominal_size;
    }

    /**
     * @param nominal_size the nominal_size to set
     */
    public void setNominal_size(String nominal_size) {
        this.nominal_size = nominal_size;
    }

    /**
     * @return the in_diam
     */
    public String getIn_diam() {
        return in_diam;
    }

    /**
     * @param in_diam the in_diam to set
     */
    public void setIn_diam(String in_diam) {
        this.in_diam = in_diam;
    }

    /**
     * @return the wthick
     */
    public String getWthick() {
        return wthick;
    }

    /**
     * @param wthick the wthick to set
     */
    public void setWthick(String wthick) {
        this.wthick = wthick;
    }

    /**
     * @return the grade
     */
    public String getGrade() {
        return grade;
    }

    /**
     * @param grade the grade to set
     */
    public void setGrade(String grade) {
        this.grade = grade;
    }

    /**
     * @return the yield
     */
    public String getYield() {
        return yield;
    }

    /**
     * @param yield the yield to set
     */
    public void setYield(String yield) {
        this.yield = yield;
    }

    /**
     * @return the coating
     */
    public String getCoating() {
        return coating;
    }

    /**
     * @param coating the coating to set
     */
    public void setCoating(String coating) {
        this.coating = coating;
    }

    /**
     * @return the wk_req_no
     */
    public String getWk_req_no() {
        return wk_req_no;
    }

    /**
     * @param wk_req_no the wk_req_no to set
     */
    public void setWk_req_no(String wk_req_no) {
        this.wk_req_no = wk_req_no;
    }

    /**
     * @return the installation_month
     */
    public String getInstallation_month() {
        return installation_month;
    }

    /**
     * @param installation_month the installation_month to set
     */
    public void setInstallation_month(String installation_month) {
        this.installation_month = installation_month;
    }

    /**
     * @return the installation_year
     */
    public String getInstallation_year() {
        return installation_year;
    }

    /**
     * @param installation_year the installation_year to set
     */
    public void setInstallation_year(String installation_year) {
        this.installation_year = installation_year;
    }

    /**
     * @return the ops_sys_name
     */
    public String getOps_sys_name() {
        return ops_sys_name;
    }

    /**
     * @param ops_sys_name the ops_sys_name to set
     */
    public void setOps_sys_name(String ops_sys_name) {
        this.ops_sys_name = ops_sys_name;
    }

    /**
     * @return the weld_seam
     */
    public String getWeld_seam() {
        return weld_seam;
    }

    /**
     * @param weld_seam the weld_seam to set
     */
    public void setWeld_seam(String weld_seam) {
        this.weld_seam = weld_seam;
    }

    /**
     * @return the coating_types
     */
    public String getCoating_types() {
        return coating_types;
    }

    /**
     * @param coating_types the coating_types to set
     */
    public void setCoating_types(String coating_types) {
        this.coating_types = coating_types;
    }

    /**
     * @return the coating_condition
     */
    public String getCoating_condition() {
        return coating_condition;
    }

    /**
     * @param coating_condition the coating_condition to set
     */
    public void setCoating_condition(String coating_condition) {
        this.coating_condition = coating_condition;
    }

    /**
     * @return the holiday_detec_colt_setting
     */
    public String getHoliday_detec_colt_setting() {
        return holiday_detec_colt_setting;
    }

    /**
     * @param holiday_detec_colt_setting the holiday_detec_colt_setting to set
     */
    public void setHoliday_detec_colt_setting(String holiday_detec_colt_setting) {
        this.holiday_detec_colt_setting = holiday_detec_colt_setting;
    }

    /**
     * @return the per_dam_ncorros_disbond
     */
    public String getPer_dam_ncorros_disbond() {
        return per_dam_ncorros_disbond;
    }

    /**
     * @param per_dam_ncorros_disbond the per_dam_ncorros_disbond to set
     */
    public void setPer_dam_ncorros_disbond(String per_dam_ncorros_disbond) {
        this.per_dam_ncorros_disbond = per_dam_ncorros_disbond;
    }

    /**
     * @return the o_clock_ncorros_disbond
     */
    public String getO_clock_ncorros_disbond() {
        return o_clock_ncorros_disbond;
    }

    /**
     * @param o_clock_ncorros_disbond the o_clock_ncorros_disbond to set
     */
    public void setO_clock_ncorros_disbond(String o_clock_ncorros_disbond) {
        this.o_clock_ncorros_disbond = o_clock_ncorros_disbond;
    }

    /**
     * @return the percent_damage_blistering
     */
    public String getPercent_damage_blistering() {
        return percent_damage_blistering;
    }

    /**
     * @param percent_damage_blistering the percent_damage_blistering to set
     */
    public void setPercent_damage_blistering(String percent_damage_blistering) {
        this.percent_damage_blistering = percent_damage_blistering;
    }

    /**
     * @return the o_clock_damage_blistering
     */
    public String getO_clock_damage_blistering() {
        return o_clock_damage_blistering;
    }

    /**
     * @param o_clock_damage_blistering the o_clock_damage_blistering to set
     */
    public void setO_clock_damage_blistering(String o_clock_damage_blistering) {
        this.o_clock_damage_blistering = o_clock_damage_blistering;
    }

    /**
     * @return the ground_cover_type
     */
    public String getGround_cover_type() {
        return ground_cover_type;
    }

    /**
     * @param ground_cover_type the ground_cover_type to set
     */
    public void setGround_cover_type(String ground_cover_type) {
        this.ground_cover_type = ground_cover_type;
    }

    /**
     * @return the blister_fluid_ph
     */
    public String getBlister_fluid_ph() {
        return blister_fluid_ph;
    }

    /**
     * @param blister_fluid_ph the blister_fluid_ph to set
     */
    public void setBlister_fluid_ph(String blister_fluid_ph) {
        this.blister_fluid_ph = blister_fluid_ph;
    }

    /**
     * @return the procedure_adequate_flag
     */
    public String getProcedure_adequate_flag() {
        return procedure_adequate_flag;
    }

    /**
     * @param procedure_adequate_flag the procedure_adequate_flag to set
     */
    public void setProcedure_adequate_flag(String procedure_adequate_flag) {
        this.procedure_adequate_flag = procedure_adequate_flag;
    }

    /**
     * @return the inspected_by
     */
    public String getInspected_by() {
        return inspected_by;
    }

    /**
     * @param inspected_by the inspected_by to set
     */
    public void setInspected_by(String inspected_by) {
        this.inspected_by = inspected_by;
    }

    /**
     * @return the inspection_date
     */
    public String getInspection_date() {
        return inspection_date;
    }

    /**
     * @param inspection_date the inspection_date to set
     */
    public void setInspection_date(String inspection_date) {
        this.inspection_date = inspection_date;
    }

    /**
     * @return the reviewed_by
     */
    public String getReviewed_by() {
        return reviewed_by;
    }

    /**
     * @param reviewed_by the reviewed_by to set
     */
    public void setReviewed_by(String reviewed_by) {
        this.reviewed_by = reviewed_by;
    }

    /**
     * @return the reviewed_date
     */
    public String getReviewed_date() {
        return reviewed_date;
    }

    /**
     * @param reviewed_date the reviewed_date to set
     */
    public void setReviewed_date(String reviewed_date) {
        this.reviewed_date = reviewed_date;
    }

    /**
     * @return the soilph_at_pipe_depth
     */
    public String getSoilph_at_pipe_depth() {
        return soilph_at_pipe_depth;
    }

    /**
     * @param soilph_at_pipe_depth the soilph_at_pipe_depth to set
     */
    public void setSoilph_at_pipe_depth(String soilph_at_pipe_depth) {
        this.soilph_at_pipe_depth = soilph_at_pipe_depth;
    }

    /**
     * @return the soil_resistivity_at_pipe_depth
     */
    public String getSoil_resistivity_at_pipe_depth() {
        return soil_resistivity_at_pipe_depth;
    }

    /**
     * @param soil_resistivity_at_pipe_depth the soil_resistivity_at_pipe_depth to set
     */
    public void setSoil_resistivity_at_pipe_depth(String soil_resistivity_at_pipe_depth) {
        this.soil_resistivity_at_pipe_depth = soil_resistivity_at_pipe_depth;
    }

    /**
     * @return the soil_chem_performed_flag
     */
    public String getSoil_chem_performed_flag() {
        return soil_chem_performed_flag;
    }

    /**
     * @param soil_chem_performed_flag the soil_chem_performed_flag to set
     */
    public void setSoil_chem_performed_flag(String soil_chem_performed_flag) {
        this.soil_chem_performed_flag = soil_chem_performed_flag;
    }

    /**
     * @return the method_used
     */
    public String getMethod_used() {
        return method_used;
    }

    /**
     * @param method_used the method_used to set
     */
    public void setMethod_used(String method_used) {
        this.method_used = method_used;
    }

    /**
     * @return the chlorides_ppm
     */
    public String getChlorides_ppm() {
        return chlorides_ppm;
    }

    /**
     * @param chlorides_ppm the chlorides_ppm to set
     */
    public void setChlorides_ppm(String chlorides_ppm) {
        this.chlorides_ppm = chlorides_ppm;
    }

    /**
     * @return the nitrates_ppm
     */
    public String getNitrates_ppm() {
        return nitrates_ppm;
    }

    /**
     * @param nitrates_ppm the nitrates_ppm to set
     */
    public void setNitrates_ppm(String nitrates_ppm) {
        this.nitrates_ppm = nitrates_ppm;
    }

    /**
     * @return the sulfates_ppm
     */
    public String getSulfates_ppm() {
        return sulfates_ppm;
    }

    /**
     * @param sulfates_ppm the sulfates_ppm to set
     */
    public void setSulfates_ppm(String sulfates_ppm) {
        this.sulfates_ppm = sulfates_ppm;
    }

    /**
     * @return the pipe_to_soil_frm_exc_6_oclock
     */
    public String getPipe_to_soil_frm_exc_6_oclock() {
        return pipe_to_soil_frm_exc_6_oclock;
    }

    /**
     * @param pipe_to_soil_frm_exc_6_oclock the pipe_to_soil_frm_exc_6_oclock to set
     */
    public void setPipe_to_soil_frm_exc_6_oclock(String pipe_to_soil_frm_exc_6_oclock) {
        this.pipe_to_soil_frm_exc_6_oclock = pipe_to_soil_frm_exc_6_oclock;
    }

    /**
     * @return the pipe_to_soil_frm_exc_3_oclock
     */
    public String getPipe_to_soil_frm_exc_3_oclock() {
        return pipe_to_soil_frm_exc_3_oclock;
    }

    /**
     * @param pipe_to_soil_frm_exc_3_oclock the pipe_to_soil_frm_exc_3_oclock to set
     */
    public void setPipe_to_soil_frm_exc_3_oclock(String pipe_to_soil_frm_exc_3_oclock) {
        this.pipe_to_soil_frm_exc_3_oclock = pipe_to_soil_frm_exc_3_oclock;
    }

    /**
     * @return the pipe_to_soil_frm_exc_9_oclock
     */
    public String getPipe_to_soil_frm_exc_9_oclock() {
        return pipe_to_soil_frm_exc_9_oclock;
    }

    /**
     * @param pipe_to_soil_frm_exc_9_oclock the pipe_to_soil_frm_exc_9_oclock to set
     */
    public void setPipe_to_soil_frm_exc_9_oclock(String pipe_to_soil_frm_exc_9_oclock) {
        this.pipe_to_soil_frm_exc_9_oclock = pipe_to_soil_frm_exc_9_oclock;
    }

    /**
     * @return the pipe_to_soil_frm_exc_12_oclock
     */
    public String getPipe_to_soil_frm_exc_12_oclock() {
        return pipe_to_soil_frm_exc_12_oclock;
    }

    /**
     * @param pipe_to_soil_frm_exc_12_oclock the pipe_to_soil_frm_exc_12_oclock to set
     */
    public void setPipe_to_soil_frm_exc_12_oclock(String pipe_to_soil_frm_exc_12_oclock) {
        this.pipe_to_soil_frm_exc_12_oclock = pipe_to_soil_frm_exc_12_oclock;
    }

    /**
     * @return the bacterial_samples_taken
     */
    public String getBacterial_samples_taken() {
        return bacterial_samples_taken;
    }

    /**
     * @param bacterial_samples_taken the bacterial_samples_taken to set
     */
    public void setBacterial_samples_taken(String bacterial_samples_taken) {
        this.bacterial_samples_taken = bacterial_samples_taken;
    }

    /**
     * @return the asphalt_tar_samples_taken
     */
    public String getAsphalt_tar_samples_taken() {
        return asphalt_tar_samples_taken;
    }

    /**
     * @param asphalt_tar_samples_taken the asphalt_tar_samples_taken to set
     */
    public void setAsphalt_tar_samples_taken(String asphalt_tar_samples_taken) {
        this.asphalt_tar_samples_taken = asphalt_tar_samples_taken;
    }

    /**
     * @return the defects_found
     */
    public String getDefects_found() {
        return defects_found;
    }

    /**
     * @param defects_found the defects_found to set
     */
    public void setDefects_found(String defects_found) {
        this.defects_found = defects_found;
    }

    /**
     * @return the defects_comments
     */
    public String getDefects_comments() {
        return defects_comments;
    }

    /**
     * @param defects_comments the defects_comments to set
     */
    public void setDefects_comments(String defects_comments) {
        this.defects_comments = defects_comments;
    }

    /**
     * @return the cause_of_corrosion
     */
    public String getCause_of_corrosion() {
        return cause_of_corrosion;
    }

    /**
     * @param cause_of_corrosion the cause_of_corrosion to set
     */
    public void setCause_of_corrosion(String cause_of_corrosion) {
        this.cause_of_corrosion = cause_of_corrosion;
    }

    /**
     * @return the date_of_incubation
     */
    public String getDate_of_incubation() {
        return date_of_incubation;
    }

    /**
     * @param date_of_incubation the date_of_incubation to set
     */
    public void setDate_of_incubation(String date_of_incubation) {
        this.date_of_incubation = date_of_incubation;
    }

    /**
     * @return the suspec_severity_coating_anom
     */
    public String getSuspec_severity_coating_anom() {
        return suspec_severity_coating_anom;
    }

    /**
     * @param suspec_severity_coating_anom the suspec_severity_coating_anom to set
     */
    public void setSuspec_severity_coating_anom(String suspec_severity_coating_anom) {
        this.suspec_severity_coating_anom = suspec_severity_coating_anom;
    }

    /**
     * @return the found_severity_coating_anomaly
     */
    public String getFound_severity_coating_anomaly() {
        return found_severity_coating_anomaly;
    }

    /**
     * @param found_severity_coating_anomaly the found_severity_coating_anomaly to set
     */
    public void setFound_severity_coating_anomaly(String found_severity_coating_anomaly) {
        this.found_severity_coating_anomaly = found_severity_coating_anomaly;
    }

    /**
     * @return the DE_defect_severity
     */
    public String getDE_defect_severity() {
        return DE_defect_severity;
    }

    /**
     * @param DE_defect_severity the DE_defect_severity to set
     */
    public void setDE_defect_severity(String DE_defect_severity) {
        this.DE_defect_severity = DE_defect_severity;
    }

    /**
     * @return the severity_coatinganomaly2xpctd
     */
    public String getSeverity_coatinganomaly2xpctd() {
        return severity_coatinganomaly2xpctd;
    }

    /**
     * @param severity_coatinganomaly2xpctd the severity_coatinganomaly2xpctd to set
     */
    public void setSeverity_coatinganomaly2xpctd(String severity_coatinganomaly2xpctd) {
        this.severity_coatinganomaly2xpctd = severity_coatinganomaly2xpctd;
    }

    /**
     * @return the initial_assessment_covered_seg
     */
    public String getInitial_assessment_covered_seg() {
        return initial_assessment_covered_seg;
    }

    /**
     * @param initial_assessment_covered_seg the initial_assessment_covered_seg to set
     */
    public void setInitial_assessment_covered_seg(String initial_assessment_covered_seg) {
        this.initial_assessment_covered_seg = initial_assessment_covered_seg;
    }

    /**
     * @return the need_to_adjust_sct_flag
     */
    public String getNeed_to_adjust_sct_flag() {
        return need_to_adjust_sct_flag;
    }

    /**
     * @param need_to_adjust_sct_flag the need_to_adjust_sct_flag to set
     */
    public void setNeed_to_adjust_sct_flag(String need_to_adjust_sct_flag) {
        this.need_to_adjust_sct_flag = need_to_adjust_sct_flag;
    }

    /**
     * @return the corrosion_found
     */
    public String getCorrosion_found() {
        return corrosion_found;
    }

    /**
     * @param corrosion_found the corrosion_found to set
     */
    public void setCorrosion_found(String corrosion_found) {
        this.corrosion_found = corrosion_found;
    }

    /**
     * @return the b_or_c_priority_flag
     */
    public String getB_or_c_priority_flag() {
        return b_or_c_priority_flag;
    }

    /**
     * @param b_or_c_priority_flag the b_or_c_priority_flag to set
     */
    public void setB_or_c_priority_flag(String b_or_c_priority_flag) {
        this.b_or_c_priority_flag = b_or_c_priority_flag;
    }

    /**
     * @return the more_severe_than_A_priority
     */
    public String getMore_severe_than_A_priority() {
        return more_severe_than_A_priority;
    }

    /**
     * @param more_severe_than_A_priority the more_severe_than_A_priority to set
     */
    public void setMore_severe_than_A_priority(String more_severe_than_A_priority) {
        this.more_severe_than_A_priority = more_severe_than_A_priority;
    }

    /**
     * @return the sct_assessed_for_adjustment
     */
    public String getSct_assessed_for_adjustment() {
        return sct_assessed_for_adjustment;
    }

    /**
     * @param sct_assessed_for_adjustment the sct_assessed_for_adjustment to set
     */
    public void setSct_assessed_for_adjustment(String sct_assessed_for_adjustment) {
        this.sct_assessed_for_adjustment = sct_assessed_for_adjustment;
    }

    /**
     * @return the changes_made_to_sct_flag
     */
    public String getChanges_made_to_sct_flag() {
        return changes_made_to_sct_flag;
    }

    /**
     * @param changes_made_to_sct_flag the changes_made_to_sct_flag to set
     */
    public void setChanges_made_to_sct_flag(String changes_made_to_sct_flag) {
        this.changes_made_to_sct_flag = changes_made_to_sct_flag;
    }

    /**
     * @return the add_indirect_surveys_needed
     */
    public String getAdd_indirect_surveys_needed() {
        return add_indirect_surveys_needed;
    }

    /**
     * @param add_indirect_surveys_needed the add_indirect_surveys_needed to set
     */
    public void setAdd_indirect_surveys_needed(String add_indirect_surveys_needed) {
        this.add_indirect_surveys_needed = add_indirect_surveys_needed;
    }

    /**
     * @return the significant_corrosion_flag
     */
    public String getSignificant_corrosion_flag() {
        return significant_corrosion_flag;
    }

    /**
     * @param significant_corrosion_flag the significant_corrosion_flag to set
     */
    public void setSignificant_corrosion_flag(String significant_corrosion_flag) {
        this.significant_corrosion_flag = significant_corrosion_flag;
    }

    /**
     * @return the review_conducted_flag
     */
    public String getReview_conducted_flag() {
        return review_conducted_flag;
    }

    /**
     * @param review_conducted_flag the review_conducted_flag to set
     */
    public void setReview_conducted_flag(String review_conducted_flag) {
        this.review_conducted_flag = review_conducted_flag;
    }

    /**
     * @return the alt_methods_requirement_flag
     */
    public String getAlt_methods_requirement_flag() {
        return alt_methods_requirement_flag;
    }

    /**
     * @param alt_methods_requirement_flag the alt_methods_requirement_flag to set
     */
    public void setAlt_methods_requirement_flag(String alt_methods_requirement_flag) {
        this.alt_methods_requirement_flag = alt_methods_requirement_flag;
    }

    /**
     * @return the corros_other_location_sameHCA
     */
    public String getCorros_other_location_sameHCA() {
        return corros_other_location_sameHCA;
    }

    /**
     * @param corros_other_location_sameHCA the corros_other_location_sameHCA to set
     */
    public void setCorros_other_location_sameHCA(String corros_other_location_sameHCA) {
        this.corros_other_location_sameHCA = corros_other_location_sameHCA;
    }

    /**
     * @return the similar_rootcause_same_HCA
     */
    public String getSimilar_rootcause_same_HCA() {
        return similar_rootcause_same_HCA;
    }

    /**
     * @param similar_rootcause_same_HCA the similar_rootcause_same_HCA to set
     */
    public void setSimilar_rootcause_same_HCA(String similar_rootcause_same_HCA) {
        this.similar_rootcause_same_HCA = similar_rootcause_same_HCA;
    }

    /**
     * @return the crt_date_calc_completed
     */
    public String getCrt_date_calc_completed() {
        return crt_date_calc_completed;
    }

    /**
     * @param crt_date_calc_completed the crt_date_calc_completed to set
     */
    public void setCrt_date_calc_completed(String crt_date_calc_completed) {
        this.crt_date_calc_completed = crt_date_calc_completed;
    }

    /**
     * @return the inspector_comments
     */
    public String getInspector_comments() {
        return inspector_comments;
    }

    /**
     * @param inspector_comments the inspector_comments to set
     */
    public void setInspector_comments(String inspector_comments) {
        this.inspector_comments = inspector_comments;
    }

    /**
     * @return the remed_action_requirement_flag
     */
    public String getRemed_action_requirement_flag() {
        return remed_action_requirement_flag;
    }

    /**
     * @param remed_action_requirement_flag the remed_action_requirement_flag to set
     */
    public void setRemed_action_requirement_flag(String remed_action_requirement_flag) {
        this.remed_action_requirement_flag = remed_action_requirement_flag;
    }

    /**
     * @return the reference_request_number
     */
    public String getReference_request_number() {
        return reference_request_number;
    }

    /**
     * @param reference_request_number the reference_request_number to set
     */
    public void setReference_request_number(String reference_request_number) {
        this.reference_request_number = reference_request_number;
    }

    /**
     * @return the repair_quickness
     */
    public String getRepair_quickness() {
        return repair_quickness;
    }

    /**
     * @param repair_quickness the repair_quickness to set
     */
    public void setRepair_quickness(String repair_quickness) {
        this.repair_quickness = repair_quickness;
    }

    /**
     * @return the remediation_comments
     */
    public String getRemediation_comments() {
        return remediation_comments;
    }

    /**
     * @param remediation_comments the remediation_comments to set
     */
    public void setRemediation_comments(String remediation_comments) {
        this.remediation_comments = remediation_comments;
    }

    /**
     * @return the if_no_moc_explain_why
     */
    public String getIf_no_moc_explain_why() {
        return if_no_moc_explain_why;
    }

    /**
     * @param if_no_moc_explain_why the if_no_moc_explain_why to set
     */
    public void setIf_no_moc_explain_why(String if_no_moc_explain_why) {
        this.if_no_moc_explain_why = if_no_moc_explain_why;
    }

    /**
     * @return the explanation_for_other
     */
    public String getExplanation_for_other() {
        return explanation_for_other;
    }

    /**
     * @param explanation_for_other the explanation_for_other to set
     */
    public void setExplanation_for_other(String explanation_for_other) {
        this.explanation_for_other = explanation_for_other;
    }

    /**
     * @return the ultrasonicthickness_comments
     */
    public String getUltrasonicthickness_comments() {
        return ultrasonicthickness_comments;
    }

    /**
     * @param ultrasonicthickness_comments the ultrasonicthickness_comments to set
     */
    public void setUltrasonicthickness_comments(String ultrasonicthickness_comments) {
        this.ultrasonicthickness_comments = ultrasonicthickness_comments;
    }

    /**
     * @return the min_ICDA_scrub_1
     */
    public String getMin_ICDA_scrub_1() {
        return min_ICDA_scrub_1;
    }

    /**
     * @param min_ICDA_scrub_1 the min_ICDA_scrub_1 to set
     */
    public void setMin_ICDA_scrub_1(String min_ICDA_scrub_1) {
        this.min_ICDA_scrub_1 = min_ICDA_scrub_1;
    }

    /**
     * @return the max_ICDA_scrub_1
     */
    public String getMax_ICDA_scrub_1() {
        return max_ICDA_scrub_1;
    }

    /**
     * @param max_ICDA_scrub_1 the max_ICDA_scrub_1 to set
     */
    public void setMax_ICDA_scrub_1(String max_ICDA_scrub_1) {
        this.max_ICDA_scrub_1 = max_ICDA_scrub_1;
    }

    /**
     * @return the wt_percentage_scrub1
     */
    public String getWt_percentage_scrub1() {
        return wt_percentage_scrub1;
    }

    /**
     * @param wt_percentage_scrub1 the wt_percentage_scrub1 to set
     */
    public void setWt_percentage_scrub1(String wt_percentage_scrub1) {
        this.wt_percentage_scrub1 = wt_percentage_scrub1;
    }

    /**
     * @return the min_ICDA_scrub_2
     */
    public String getMin_ICDA_scrub_2() {
        return min_ICDA_scrub_2;
    }

    /**
     * @param min_ICDA_scrub_2 the min_ICDA_scrub_2 to set
     */
    public void setMin_ICDA_scrub_2(String min_ICDA_scrub_2) {
        this.min_ICDA_scrub_2 = min_ICDA_scrub_2;
    }

    /**
     * @return the max_ICDA_scrub_2
     */
    public String getMax_ICDA_scrub_2() {
        return max_ICDA_scrub_2;
    }

    /**
     * @param max_ICDA_scrub_2 the max_ICDA_scrub_2 to set
     */
    public void setMax_ICDA_scrub_2(String max_ICDA_scrub_2) {
        this.max_ICDA_scrub_2 = max_ICDA_scrub_2;
    }

    /**
     * @return the wt_percentage_scrub2
     */
    public String getWt_percentage_scrub2() {
        return wt_percentage_scrub2;
    }

    /**
     * @param wt_percentage_scrub2 the wt_percentage_scrub2 to set
     */
    public void setWt_percentage_scrub2(String wt_percentage_scrub2) {
        this.wt_percentage_scrub2 = wt_percentage_scrub2;
    }

    /**
     * @return the location_of_samples
     */
    public String getLocation_of_samples() {
        return location_of_samples;
    }

    /**
     * @param location_of_samples the location_of_samples to set
     */
    public void setLocation_of_samples(String location_of_samples) {
        this.location_of_samples = location_of_samples;
    }

    /**
     * @return the collected_by
     */
    public String getCollected_by() {
        return collected_by;
    }

    /**
     * @param collected_by the collected_by to set
     */
    public void setCollected_by(String collected_by) {
        this.collected_by = collected_by;
    }

    /**
     * @return the date_collected
     */
    public String getDate_collected() {
        return date_collected;
    }

    /**
     * @param date_collected the date_collected to set
     */
    public void setDate_collected(String date_collected) {
        this.date_collected = date_collected;
    }

    /**
     * @return the seven_day_interpreted_by
     */
    public String getSeven_day_interpreted_by() {
        return seven_day_interpreted_by;
    }

    /**
     * @param seven_day_interpreted_by the seven_day_interpreted_by to set
     */
    public void setSeven_day_interpreted_by(String seven_day_interpreted_by) {
        this.seven_day_interpreted_by = seven_day_interpreted_by;
    }

    /**
     * @return the seven_day_date_of_reading
     */
    public String getSeven_day_date_of_reading() {
        return seven_day_date_of_reading;
    }

    /**
     * @param seven_day_date_of_reading the seven_day_date_of_reading to set
     */
    public void setSeven_day_date_of_reading(String seven_day_date_of_reading) {
        this.seven_day_date_of_reading = seven_day_date_of_reading;
    }

    /**
     * @return the fourteen_day_interpreted_by
     */
    public String getFourteen_day_interpreted_by() {
        return fourteen_day_interpreted_by;
    }

    /**
     * @param fourteen_day_interpreted_by the fourteen_day_interpreted_by to set
     */
    public void setFourteen_day_interpreted_by(String fourteen_day_interpreted_by) {
        this.fourteen_day_interpreted_by = fourteen_day_interpreted_by;
    }

    /**
     * @return the fourteen_day_date_of_reading
     */
    public String getFourteen_day_date_of_reading() {
        return fourteen_day_date_of_reading;
    }

    /**
     * @param fourteen_day_date_of_reading the fourteen_day_date_of_reading to set
     */
    public void setFourteen_day_date_of_reading(String fourteen_day_date_of_reading) {
        this.fourteen_day_date_of_reading = fourteen_day_date_of_reading;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the cap_color
     */
    public String getCap_color() {
        return cap_color;
    }

    /**
     * @param cap_color the cap_color to set
     */
    public void setCap_color(String cap_color) {
        this.cap_color = cap_color;
    }

    /**
     * @return the bottle_num
     */
    public String getBottle_num() {
        return bottle_num;
    }

    /**
     * @param bottle_num the bottle_num to set
     */
    public void setBottle_num(String bottle_num) {
        this.bottle_num = bottle_num;
    }

    /**
     * @return the results_w1
     */
    public String getResults_w1() {
        return results_w1;
    }

    /**
     * @param results_w1 the results_w1 to set
     */
    public void setResults_w1(String results_w1) {
        this.results_w1 = results_w1;
    }

    /**
     * @return the results_w2
     */
    public String getResults_w2() {
        return results_w2;
    }

    /**
     * @param results_w2 the results_w2 to set
     */
    public void setResults_w2(String results_w2) {
        this.results_w2 = results_w2;
    }

    /**
     * @return the comments
     */
    public String getComments() {
        return comments;
    }

    /**
     * @param comments the comments to set
     */
    public void setComments(String comments) {
        this.comments = comments;
    }

    /**
     * @return the UltraRowNum
     */
    public String getUltraRowNum() {
        return UltraRowNum;
    }

    /**
     * @param UltraRowNum the UltraRowNum to set
     */
    public void setUltraRowNum(String UltraRowNum) {
        this.UltraRowNum = UltraRowNum;
    }

    /**
     * @return the UltraRowPkey
     */
    public String getUltraRowPkey() {
        return UltraRowPkey;
    }

    /**
     * @param UltraRowPkey the UltraRowPkey to set
     */
    public void setUltraRowPkey(String UltraRowPkey) {
        this.UltraRowPkey = UltraRowPkey;
    }

    /**
     * @return the Dist_from_zero_point
     */
    public String getDist_from_zero_point() {
        return Dist_from_zero_point;
    }

    /**
     * @param Dist_from_zero_point the Dist_from_zero_point to set
     */
    public void setDist_from_zero_point(String Dist_from_zero_point) {
        this.Dist_from_zero_point = Dist_from_zero_point;
    }

    /**
     * @return the clock_12
     */
    public String getClock_12() {
        return clock_12;
    }

    /**
     * @param clock_12 the clock_12 to set
     */
    public void setClock_12(String clock_12) {
        this.clock_12 = clock_12;
    }

    /**
     * @return the clock_3
     */
    public String getClock_3() {
        return clock_3;
    }

    /**
     * @param clock_3 the clock_3 to set
     */
    public void setClock_3(String clock_3) {
        this.clock_3 = clock_3;
    }

    /**
     * @return the clock_6
     */
    public String getClock_6() {
        return clock_6;
    }

    /**
     * @param clock_6 the clock_6 to set
     */
    public void setClock_6(String clock_6) {
        this.clock_6 = clock_6;
    }

    /**
     * @return the clock_9
     */
    public String getClock_9() {
        return clock_9;
    }

    /**
     * @param clock_9 the clock_9 to set
     */
    public void setClock_9(String clock_9) {
        this.clock_9 = clock_9;
    }

    /**
     * @return the wt_percentage
     */
    public String getWt_percentage() {
        return wt_percentage;
    }

    /**
     * @param wt_percentage the wt_percentage to set
     */
    public void setWt_percentage(String wt_percentage) {
        this.wt_percentage = wt_percentage;
    }

    /**
     * @return the defect_title
     */
    public String getDefect_title() {
        return defect_title;
    }

    /**
     * @param defect_title the defect_title to set
     */
    public void setDefect_title(String defect_title) {
        this.defect_title = defect_title;
    }

    /**
     * @return the defect_number
     */
    public String getDefect_number() {
        return defect_number;
    }

    /**
     * @param defect_number the defect_number to set
     */
    public void setDefect_number(String defect_number) {
        this.defect_number = defect_number;
    }

    /**
     * @return the defect_type
     */
    public String getDefect_type() {
        return defect_type;
    }

    /**
     * @param defect_type the defect_type to set
     */
    public void setDefect_type(String defect_type) {
        this.defect_type = defect_type;
    }

    /**
     * @return the distance_from_zero
     */
    public String getDistance_from_zero() {
        return distance_from_zero;
    }

    /**
     * @param distance_from_zero the distance_from_zero to set
     */
    public void setDistance_from_zero(String distance_from_zero) {
        this.distance_from_zero = distance_from_zero;
    }

    /**
     * @return the o_clock_position
     */
    public String getO_clock_position() {
        return o_clock_position;
    }

    /**
     * @param o_clock_position the o_clock_position to set
     */
    public void setO_clock_position(String o_clock_position) {
        this.o_clock_position = o_clock_position;
    }

    /**
     * @return the axial_length
     */
    public String getAxial_length() {
        return axial_length;
    }

    /**
     * @param axial_length the axial_length to set
     */
    public void setAxial_length(String axial_length) {
        this.axial_length = axial_length;
    }

    /**
     * @return the circumferential_length
     */
    public String getCircumferential_length() {
        return circumferential_length;
    }

    /**
     * @param circumferential_length the circumferential_length to set
     */
    public void setCircumferential_length(String circumferential_length) {
        this.circumferential_length = circumferential_length;
    }

    /**
     * @return the max_depth
     */
    public String getMax_depth() {
        return max_depth;
    }

    /**
     * @param max_depth the max_depth to set
     */
    public void setMax_depth(String max_depth) {
        this.max_depth = max_depth;
    }

    /**
     * @return the repair_category
     */
    public String getRepair_category() {
        return repair_category;
    }

    /**
     * @param repair_category the repair_category to set
     */
    public void setRepair_category(String repair_category) {
        this.repair_category = repair_category;
    }

    /**
     * @return the corrosion_interactivity
     */
    public String getCorrosion_interactivity() {
        return corrosion_interactivity;
    }

    /**
     * @param corrosion_interactivity the corrosion_interactivity to set
     */
    public void setCorrosion_interactivity(String corrosion_interactivity) {
        this.corrosion_interactivity = corrosion_interactivity;
    }

    /**
     * @return the remaining_wall_thickness_in
     */
    public String getRemaining_wall_thickness_in() {
        return remaining_wall_thickness_in;
    }

    /**
     * @param remaining_wall_thickness_in the remaining_wall_thickness_in to set
     */
    public void setRemaining_wall_thickness_in(String remaining_wall_thickness_in) {
        this.remaining_wall_thickness_in = remaining_wall_thickness_in;
    }

    /**
     * @return the Inadequate_CP_current_HCA_exam
     */
    public String getInadequate_CP_current_HCA_exam() {
        return Inadequate_CP_current_HCA_exam;
    }

    /**
     * @param Inadequate_CP_current_HCA_exam the Inadequate_CP_current_HCA_exam to set
     */
    public void setInadequate_CP_current_HCA_exam(String Inadequate_CP_current_HCA_exam) {
        this.Inadequate_CP_current_HCA_exam = Inadequate_CP_current_HCA_exam;
    }

    /**
     * @return the No_CP_time_HCA_exam
     */
    public String getNo_CP_time_HCA_exam() {
        return No_CP_time_HCA_exam;
    }

    /**
     * @param No_CP_time_HCA_exam the No_CP_time_HCA_exam to set
     */
    public void setNo_CP_time_HCA_exam(String No_CP_time_HCA_exam) {
        this.No_CP_time_HCA_exam = No_CP_time_HCA_exam;
    }

    /**
     * @return the No_CP_metal_couplings_HCA_exam
     */
    public String getNo_CP_metal_couplings_HCA_exam() {
        return No_CP_metal_couplings_HCA_exam;
    }

    /**
     * @param No_CP_metal_couplings_HCA_exam the No_CP_metal_couplings_HCA_exam to set
     */
    public void setNo_CP_metal_couplings_HCA_exam(String No_CP_metal_couplings_HCA_exam) {
        this.No_CP_metal_couplings_HCA_exam = No_CP_metal_couplings_HCA_exam;
    }

    /**
     * @return the interference_source_HCA_exam
     */
    public String getInterference_source_HCA_exam() {
        return interference_source_HCA_exam;
    }

    /**
     * @param interference_source_HCA_exam the interference_source_HCA_exam to set
     */
    public void setInterference_source_HCA_exam(String interference_source_HCA_exam) {
        this.interference_source_HCA_exam = interference_source_HCA_exam;
    }

    /**
     * @return the shielding_HCA_exam
     */
    public String getShielding_HCA_exam() {
        return shielding_HCA_exam;
    }

    /**
     * @param shielding_HCA_exam the shielding_HCA_exam to set
     */
    public void setShielding_HCA_exam(String shielding_HCA_exam) {
        this.shielding_HCA_exam = shielding_HCA_exam;
    }

    /**
     * @return the MIC_HCA_exam
     */
    public String getMIC_HCA_exam() {
        return MIC_HCA_exam;
    }

    /**
     * @param MIC_HCA_exam the MIC_HCA_exam to set
     */
    public void setMIC_HCA_exam(String MIC_HCA_exam) {
        this.MIC_HCA_exam = MIC_HCA_exam;
    }

    /**
     * @return the other_root_cause_HCA_exam
     */
    public String getOther_root_cause_HCA_exam() {
        return other_root_cause_HCA_exam;
    }

    /**
     * @param other_root_cause_HCA_exam the other_root_cause_HCA_exam to set
     */
    public void setOther_root_cause_HCA_exam(String other_root_cause_HCA_exam) {
        this.other_root_cause_HCA_exam = other_root_cause_HCA_exam;
    }

    /**
     * @return the Inadequate_CP_current_HCA_examOther
     */
    public String getInadequate_CP_current_HCA_examOther() {
        return Inadequate_CP_current_HCA_examOther;
    }

    /**
     * @param Inadequate_CP_current_HCA_examOther the Inadequate_CP_current_HCA_examOther to set
     */
    public void setInadequate_CP_current_HCA_examOther(String Inadequate_CP_current_HCA_examOther) {
        this.Inadequate_CP_current_HCA_examOther = Inadequate_CP_current_HCA_examOther;
    }

    /**
     * @return the No_CP_time_HCA_examOther
     */
    public String getNo_CP_time_HCA_examOther() {
        return No_CP_time_HCA_examOther;
    }

    /**
     * @param No_CP_time_HCA_examOther the No_CP_time_HCA_examOther to set
     */
    public void setNo_CP_time_HCA_examOther(String No_CP_time_HCA_examOther) {
        this.No_CP_time_HCA_examOther = No_CP_time_HCA_examOther;
    }

    /**
     * @return the No_CP_metal_couplings_HCA_examOther
     */
    public String getNo_CP_metal_couplings_HCA_examOther() {
        return No_CP_metal_couplings_HCA_examOther;
    }

    /**
     * @param No_CP_metal_couplings_HCA_examOther the No_CP_metal_couplings_HCA_examOther to set
     */
    public void setNo_CP_metal_couplings_HCA_examOther(String No_CP_metal_couplings_HCA_examOther) {
        this.No_CP_metal_couplings_HCA_examOther = No_CP_metal_couplings_HCA_examOther;
    }

    /**
     * @return the interference_source_HCA_examOther
     */
    public String getInterference_source_HCA_examOther() {
        return interference_source_HCA_examOther;
    }

    /**
     * @param interference_source_HCA_examOther the interference_source_HCA_examOther to set
     */
    public void setInterference_source_HCA_examOther(String interference_source_HCA_examOther) {
        this.interference_source_HCA_examOther = interference_source_HCA_examOther;
    }

    /**
     * @return the shielding_HCA_examOther
     */
    public String getShielding_HCA_examOther() {
        return shielding_HCA_examOther;
    }

    /**
     * @param shielding_HCA_examOther the shielding_HCA_examOther to set
     */
    public void setShielding_HCA_examOther(String shielding_HCA_examOther) {
        this.shielding_HCA_examOther = shielding_HCA_examOther;
    }

    /**
     * @return the MIC_HCA_examOther
     */
    public String getMIC_HCA_examOther() {
        return MIC_HCA_examOther;
    }

    /**
     * @param MIC_HCA_examOther the MIC_HCA_examOther to set
     */
    public void setMIC_HCA_examOther(String MIC_HCA_examOther) {
        this.MIC_HCA_examOther = MIC_HCA_examOther;
    }

    /**
     * @return the other_root_cause_HCA_examOther
     */
    public String getOther_root_cause_HCA_examOther() {
        return other_root_cause_HCA_examOther;
    }

    /**
     * @param other_root_cause_HCA_examOther the other_root_cause_HCA_examOther to set
     */
    public void setOther_root_cause_HCA_examOther(String other_root_cause_HCA_examOther) {
        this.other_root_cause_HCA_examOther = other_root_cause_HCA_examOther;
    }

    /**
     * @return the title_gps_row
     */
    public String getTitle_gps_row() {
        return title_gps_row;
    }

    /**
     * @param title_gps_row the title_gps_row to set
     */
    public void setTitle_gps_row(String title_gps_row) {
        this.title_gps_row = title_gps_row;
    }
    

}
