package com.android.t440p.photo;

import com.android.t440p.photo.POJO.HttpResponse;
import java.util.Map;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PartMap;


public interface RestApi {
    @Multipart
    @POST("retrofit.php")
    Call<HttpResponse> uploadData (@PartMap Map<String, RequestBody> pic);
}

