package com.android.t440p.photo.POJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class HttpResponse {
    @SerializedName("status")
    @Expose
    private String status;
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}