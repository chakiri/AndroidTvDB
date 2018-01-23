package com.example.chakiri.thetvdb.model.episode;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**  * Created by chakiri */

public class Language {
    @SerializedName("episodeName")
    @Expose
    private String episodeName;
    @SerializedName("overview")
    @Expose
    private String overview;

    public String getEpisodeName() {
        return episodeName;
    }

    public void setEpisodeName(String episodeName) {
        this.episodeName = episodeName;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }
}
