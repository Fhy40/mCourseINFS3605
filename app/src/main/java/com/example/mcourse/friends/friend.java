package com.example.mcourse.friends;

import com.example.mcourse.friend_request.requests;

import java.util.ArrayList;

public class friend {
    private String f_name;
    private String l_name;
    private String degree;

    public friend(){

    }

    public friend(String f_name, String l_name, String degree){
        this.f_name = f_name;
        this.l_name = l_name;
        this.degree = degree;
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

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public static ArrayList<friend> getDummyFriends() {
        ArrayList<friend> friendList = new ArrayList<>();
        friendList.add(new friend("Steve","Jobs", "Information Systems"));
        friendList.add(new friend("Paul","Porter", "Information Systems"));
        friendList.add(new friend("Carl","Carol", "B. Commerce/Information Systems"));

        return friendList;
    }


}
