package com.example.chakiri.thetvdb.model.serieInfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**  * Created by chakiri */

public class SerieInfo {
    @SerializedName("data")
    @Expose
    private SerieInfoData data;

    public SerieInfoData getData() {
        return data;
    }

    public void setData(SerieInfoData data) {
        this.data = data;
    }
}
