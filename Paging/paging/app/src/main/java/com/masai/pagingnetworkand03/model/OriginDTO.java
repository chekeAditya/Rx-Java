package com.masai.pagingnetworkand03.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class OriginDTO implements Serializable {

    @SerializedName("name")
    private String name;

    @SerializedName("url")
    private String url;

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return
                "OriginDTO{" +
                        "name = '" + name + '\'' +
                        ",url = '" + url + '\'' +
                        "}";
    }
}