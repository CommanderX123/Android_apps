package com.example.lab1;

import androidx.lifecycle.ViewModel;

public class WeatherModel extends ViewModel {
    protected OpenWeatherResponse cachedResponse;
    protected int forecastIndex = 0;

    public int getForecastIndex() {
        return forecastIndex;
    }

    public void setForecastIndex(int forecastIndex) {
        this.forecastIndex = forecastIndex;
    }

    public OpenWeatherResponse getCachedResponse() {
        return cachedResponse;
    }

    public void setCachedResponse(OpenWeatherResponse cachedResponse) {
        this.cachedResponse = cachedResponse;
    }
}
