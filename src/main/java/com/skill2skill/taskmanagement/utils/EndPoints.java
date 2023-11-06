package com.skill2skill.taskmanagement.utils;

public class EndPoints {

    public static final String Admin="/admin";
    public static final String Registration="/registration";
    public static final String Login="/login";
    public static final String COMPANY = "/company";
    public static final String ADD_UPDATE_COMPANY_DETAILS = "/addUpdateCompany";

    public static final String COMPANY_LIST = "/companyList";
    public  static final String FORGETPASSWORD="/forgetpassword";
    public static final String ADD_UPDATE_DEPARTMENT_DETAILS="/addUpdateDepartment";
    public static final String DEPARTMENT_LIST="/departmentList";
    public static final String DEPARTMENT="/department";

    public static final String DELETE_DEPARTMENT="/deleteDepartment/{departmentId}";

   public static final String ADD_UPDATE_DESIGNATION_DETAILS="/addUpdateDesignation";
   public static  final  String DESIGNATION="/designation";
   public static final String DESIGNATION_LIST="/designationListDetails";
   public static  final String DESIGNATION_DELETE="/deleteDesignation";
   public static  final String FETCH_COMPANY_NAME_IN_DESIGNATION="/fetch-company-names";
   public static final String FETCH_DEPARTMENT_NAME_IN_DESIGNATION="/fetch-department-names";
   public static final String COMPANY_SEARCH_BY_LOCATION="/company-search-by-location";


   public static final String DEPARTMENT_SEARCH_BY_DEPARTMENT_NAME="/search-by-department";
}
