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
        CoursePreferenceList.add(new course_preference("1","Project Management"));
        CoursePreferenceList.add(new course_preference("2","Java"));
        CoursePreferenceList.add(new course_preference("3","Python"));
        CoursePreferenceList.add(new course_preference("4","Enterprise Systems"));
        CoursePreferenceList.add(new course_preference("5","Cyber Security"));
        CoursePreferenceList.add(new course_preference("6","Social Media"));
        CoursePreferenceList.add(new course_preference("7","Design Thinking"));
        CoursePreferenceList.add(new course_preference("8","Database Management"));
        CoursePreferenceList.add(new course_preference("9","Technology Management"));
        CoursePreferenceList.add(new course_preference("10","Transformation in Business"));
        CoursePreferenceList.add(new course_preference("11","Analytics"));
        CoursePreferenceList.add(new course_preference("12","App Development"));
        CoursePreferenceList.add(new course_preference("13","Network"));
        CoursePreferenceList.add(new course_preference("14","System Analyst"));
        return CoursePreferenceList;
    }
}
