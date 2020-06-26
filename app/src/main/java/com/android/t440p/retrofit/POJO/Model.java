package com.android.t440p.retrofit.POJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Model {

    @SerializedName("data")
    @Expose
    private Integer data;
    @SerializedName("sort")
    @Expose
    private String sort;
    @SerializedName("direction")
    @Expose
    private String direction;
    @SerializedName("limit")
    @Expose
    private String limit;
    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }
    public String getSort() { return sort; }
    public void setSort(String sort) { this.sort = sort; }
    public String getDirection() {
        return direction;
    }
    public void setDirection(String direction) {
        this.direction = direction;
    }
    public String getLimit() {
        return limit;
    }
    public void setLimit(String limit) {
        this.limit = limit;
    }
}