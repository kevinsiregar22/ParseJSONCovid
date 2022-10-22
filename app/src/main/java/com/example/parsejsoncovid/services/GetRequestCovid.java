package com.example.parsejsoncovid.services;

import com.example.parsejsoncovid.model.CovidData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetRequestCovid {
    @GET("daily.json")
    Call<List<CovidData>> getAllCovidData();
}
