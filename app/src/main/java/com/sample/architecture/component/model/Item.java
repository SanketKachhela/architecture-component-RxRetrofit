package com.sample.architecture.component.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Sanket Kachhela on 09-07-2017.
 */

public class Item {

    @SerializedName("name")
    private String name = null;

    @SerializedName("full_name")
    private String full_name = null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }
}
