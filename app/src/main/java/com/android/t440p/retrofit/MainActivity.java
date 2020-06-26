package com.android.t440p.retrofit;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.android.t440p.retrofit.POJO.HttpResponse;
//import com.android.t440p.retrofit.POJO.Login;
import com.android.t440p.retrofit.POJO.Model;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    String url = "http://192.168.235.1/";
    TextView textViewData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewData = findViewById(R.id.data);
        getData();
    }
    void getData(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RestApi service = retrofit.create(RestApi.class);
        File sdcard = Environment.getExternalStorageDirectory();
        File file = new File(sdcard + File.separator + "test.jpg");
        RequestBody fbody = RequestBody.create(MediaType.parse("image/jpg"), file);
        Map<String, RequestBody> picMap = new HashMap<>();
        picMap.put("file\"; filename=\"" + file.getName(), fbody);
        Call<HttpResponse> call = service.uploadData(picMap);
        call.enqueue(new Callback<HttpResponse>() {
            @Override
            public void onResponse(Call<HttpResponse> call, Response<HttpResponse> response) {
                String data = response.body().getStatus();
                textViewData.setText("data : " + data);
            }
            @Override
            public void onFailure(Call<HttpResponse> call, Throwable t) {
            }
        });
    }
}
