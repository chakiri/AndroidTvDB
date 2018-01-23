package com.example.chakiri.thetvdb.model.actors;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**  * Created by chakiri */

public class Actors {

    @SerializedName("data")
    @Expose
    private List<ActorsData> data = null;

    public List<ActorsData> getData() {
        return data;
    }

    public void setData(List<ActorsData> data) {
        this.data = data;
    }
}
