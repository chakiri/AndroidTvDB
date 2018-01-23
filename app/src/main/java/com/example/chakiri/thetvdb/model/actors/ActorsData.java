package com.example.chakiri.thetvdb.model.actors;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**  * Created by chakiri */

public class ActorsData {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("seriesId")
    @Expose
    private Integer seriesId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("role")
    @Expose
    private String role;
    @SerializedName("sortOrder")
    @Expose
    private Integer sortOrder;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("imageAuthor")
    @Expose
    private Object imageAuthor;
    @SerializedName("imageAdded")
    @Expose
    private String imageAdded;
    @SerializedName("lastUpdated")
    @Expose
    private String lastUpdated;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSeriesId() {
        return seriesId;
    }

    public void setSeriesId(Integer seriesId) {
        this.seriesId = seriesId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Object getImageAuthor() {
        return imageAuthor;
    }

    public void setImageAuthor(Object imageAuthor) {
        this.imageAuthor = imageAuthor;
    }

    public String getImageAdded() {
        return imageAdded;
    }

    public void setImageAdded(String imageAdded) {
        this.imageAdded = imageAdded;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
