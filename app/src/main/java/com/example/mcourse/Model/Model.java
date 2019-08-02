package com.example.mcourse.Model;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.widget.ImageView;

public class Model {
    public String title;
    public Integer resourceIdl;


    public Model(String title, Integer resourceId) {
        this.title = title;
        this.resourceIdl = resourceId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getResourceIdl() {
        return resourceIdl;
    }

    public void setResourceIdl(Integer resourceIdl) {
        this.resourceIdl = resourceIdl;
    }
}
