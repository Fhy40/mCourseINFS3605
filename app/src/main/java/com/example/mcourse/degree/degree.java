package com.example.mcourse.degree;

import java.util.ArrayList;


public class degree {

    private String id;
    private String name;
    private String code;

    public degree(){

    }

    public degree(String id, String name, String code){
        this.id = id;
        this.name = name;
        this.code = code;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public static ArrayList<degree> getDegrees() {
        ArrayList<degree> degreeList = new ArrayList<>();
        degreeList.add(new degree("1","Information Systems","440"));
        degreeList.add(new degree("2","Information Systems + Commerce","670"));
        degreeList.add(new degree("3","Information Systems (Co-op)","560"));
        degreeList.add(new degree("4","Information Systems (Co-op) (Honours)","210"));
        return degreeList;
    }
}
