package com.example.chakiri.thetvdb.model.serieInfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**  * Created by chakiri */

public class SerieIdInfo {
    @SerializedName("data")
    @Expose
    private List<SerieIdInfoData> data = null;

    public List<SerieIdInfoData> getData() {
        return data;
    }

    public void setData(List<SerieIdInfoData> data) {
        this.data = data;
    }
}
