package com.example.chakiri.thetvdb.model.serieInfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**  * Created by chakiri */

public class SerieIdInfoData {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("lastUpdated")
    @Expose
    private Integer lastUpdated;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Integer lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
