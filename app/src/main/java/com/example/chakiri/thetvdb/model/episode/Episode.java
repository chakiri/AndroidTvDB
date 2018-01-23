package com.example.chakiri.thetvdb.model.episode;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**  * Created by chakiri */

public class Episode {
    @SerializedName("data")
    @Expose
    private List<EpisodeData> data = null;

    public List<EpisodeData> getData() {
        return data;
    }

    public void setData(List<EpisodeData> data) {
        this.data = data;
    }
}
