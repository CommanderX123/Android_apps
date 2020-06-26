package com.example.lab1;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface OpenWeatherClient {

    @GET("/data/2.5/forecast?units=metric&lat=48.9215&lon=24.7097&APPID=f78eb68a1fdf677006f1089de4c6d8f7")
    Call<OpenWeatherResponse> weatherForecast();
}
