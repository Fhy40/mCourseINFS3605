package com.example.mcourse.career_selection;

import java.util.ArrayList;

public class career {
    private String id;
    private String name;

    public career(){
    }

    public career(String id, String name){
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


    public static ArrayList<career> getCareers() {
        ArrayList<career> careerList = new ArrayList<>();
        careerList.add(new career("1","Business Analyst"));
        careerList.add(new career("2","Credit Analyst"));
        careerList.add(new career("3","IS/IT Architect"));
        careerList.add(new career("4","IS/IT Consultant"));
        careerList.add(new career("5","IT Infrastructure Developer"));
        careerList.add(new career("6","Data Analyst"));
        careerList.add(new career("7","Management Consultant"));
        careerList.add(new career("8","Marketing/Brand Manager"));
        return careerList;
    }
}
