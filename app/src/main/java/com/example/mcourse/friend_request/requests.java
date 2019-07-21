package com.example.mcourse.friend_request;

import com.example.mcourse.career_selection.career;

import java.util.ArrayList;


public class requests {
    private String id;
    private String f_name;
    private String l_name;

    public requests(){
    }

    public requests(String id, String f_name, String l_name){
        this.id = id;
        this.f_name = f_name;
        this.l_name = l_name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public String getL_name() {
        return l_name;
    }

    public void setL_name(String l_name) {
        this.l_name = l_name;
    }

    public static ArrayList<requests> getRequests() {
        ArrayList<requests> requestList = new ArrayList<>();
        requestList.add(new requests("1","Steve", "Jobs"));
        requestList.add(new requests("2","Kendrick", "Lamar"));

        return requestList;
    }
}
