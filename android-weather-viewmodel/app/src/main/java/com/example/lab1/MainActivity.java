package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    protected WeatherModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewModel = ViewModelProviders.of(this).get(WeatherModel.class);

        updateForecast();

        Button prev = (Button) findViewById(R.id.prev);
        Button next = (Button) findViewById(R.id.next);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewModel.setForecastIndex(mViewModel.getForecastIndex() + 1);
                updateForecast();
            }
        });

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewModel.setForecastIndex(mViewModel.getForecastIndex() - 1);
                updateForecast();
            }
        });
    }

    protected void updateText(OpenWeatherResponse weatherForecast) {
        if (mViewModel.getForecastIndex() < 0) {
            mViewModel.setForecastIndex(0);
        }

        if (mViewModel.getForecastIndex() > weatherForecast.getList().size() - 1) {
            mViewModel.setForecastIndex(weatherForecast.getList().size() - 1);
        }

        TextView title = (TextView) findViewById(R.id.title);
        TextView temperature = (TextView) findViewById(R.id.temperature);
        TextView humidity = (TextView) findViewById(R.id.humidity);
        TextView pressure = (TextView) findViewById(R.id.pressure);

        List forecastEntry = weatherForecast.getList().get(mViewModel.getForecastIndex());

        title.setText("Temperature for period: \n" + forecastEntry.getDtTxt());
        temperature.setText("Temperature: " + String.valueOf(forecastEntry.getMain().getTemp()));
        humidity.setText("Humidity: " + String.valueOf(forecastEntry.getMain().getHumidity()));
        pressure.setText("Pressure: " + String.valueOf(forecastEntry.getMain().getPressure()));
    }

    protected void updateForecast() {
        if (mViewModel.getCachedResponse() != null) {
            updateText(mViewModel.getCachedResponse());
            Log.d("tata", "Set from cache");
            return;
        }

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("http://api.openweathermap.org/")
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();
        OpenWeatherClient client = retrofit.create(OpenWeatherClient.class);

        Call<OpenWeatherResponse> call = client.weatherForecast();

        call.enqueue(new Callback<OpenWeatherResponse>() {
            @Override
            public void onResponse(Call<OpenWeatherResponse> call, Response<OpenWeatherResponse> response) {
                Log.d("tata", "Inside onResponse");
                mViewModel.setCachedResponse(response.body());
                updateText(mViewModel.getCachedResponse());
            }

            @Override
            public void onFailure(Call<OpenWeatherResponse> call, Throwable throwable) {
                Log.d("tata", "inside onFailure");
            }
        });
    };
}
