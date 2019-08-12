package com.example.mcourse.course_preference;

import java.util.ArrayList;


public class course_preference {

    private String id;
    private String name;

    public course_preference(){

    }

    public course_preference(String id, String name){
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public static ArrayList<course_preference> getCoursePreferences() {
        ArrayList<course_preference> CoursePreferenceList = new ArrayList<>();
        CoursePreferenceList.add(new course_preference("1","I am new to UNSW"));
        CoursePreferenceList.add(new course_preference("2","ACCT1501"));
        CoursePreferenceList.add(new course_preference("3","MGMT1001"));
        CoursePreferenceList.add(new course_preference("4","ECON1203"));
        CoursePreferenceList.add(new course_preference("5","MATH1401"));
        CoursePreferenceList.add(new course_preference("6","INFS1603"));
        CoursePreferenceList.add(new course_preference("7","INFS1609"));
        CoursePreferenceList.add(new course_preference("8","INFS2603"));
        CoursePreferenceList.add(new course_preference("9","INFS2605"));
        CoursePreferenceList.add(new course_preference("10","INFS2608"));
        CoursePreferenceList.add(new course_preference("11","INFS2621"));
        CoursePreferenceList.add(new course_preference("12","INFS3603"));
        CoursePreferenceList.add(new course_preference("13","INFS3634"));
        CoursePreferenceList.add(new course_preference("14","INFS3830"));
        CoursePreferenceList.add(new course_preference("15","INFS3617"));
        CoursePreferenceList.add(new course_preference("16","INFS3605"));
        CoursePreferenceList.add(new course_preference("17","INFS3837"));
        return CoursePreferenceList;
    }
}
