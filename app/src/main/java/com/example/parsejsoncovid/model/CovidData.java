package com.example.parsejsoncovid.model;

import com.google.gson.annotations.SerializedName;

public class CovidData {
    @SerializedName("positive")
    private Integer positive;
    @SerializedName("negative")
    private Integer negative;
    @SerializedName("death")
    private Integer death;
    @SerializedName("pending")
    private Integer pending;
    @SerializedName("dateChecked")
    private String dateChecked;

public CovidData(Integer positive, Integer negative, Integer death, Integer pending, String dateChecked) {
    this.positive = positive;
    this.negative = negative;
    this.death = death;
    this.pending = pending;
    this.dateChecked = dateChecked;
}

    public String getDateChecked() {
        return dateChecked;
    }

    public Integer getPositive() {
        return positive;
    }

    public Integer getNegative() {
        return negative;
    }

    public Integer getDeath() {
        return death;
    }

    public Integer getPending() {return pending; }


}



