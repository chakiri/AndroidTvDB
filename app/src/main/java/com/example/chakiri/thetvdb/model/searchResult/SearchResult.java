package com.example.chakiri.thetvdb.model.searchResult;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**  * Created by chakiri */

public class SearchResult {
    @SerializedName("data")
    @Expose
    private List<SearchResultData> data = null;

    public List<SearchResultData> getData() {
        return data;
    }

    public void setData(List<SearchResultData> data) {
        this.data = data;
    }
}
