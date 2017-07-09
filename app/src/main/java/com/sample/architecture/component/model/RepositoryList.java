package com.sample.architecture.component.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Sanket Kachhela on 09-07-2017.
 */

public class RepositoryList {

    @SerializedName("items")
    private ArrayList<Item> items;

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
}
