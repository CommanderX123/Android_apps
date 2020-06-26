package com.android.t440p.photo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import android.widget.TextView;

import com.android.t440p.photo.POJO.HttpResponse;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



public class MainActivity extends AppCompatActivity {
    String url ="http://192.168.235.1/";
    static final int REQUEST_TAKE_PHOTO = 1;
    ImageView mImageView;
    String mCurrentPhotoPath;
    TextView textViewData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImageView = findViewById(R.id.image);
        dispatchTakePictureIntent();
        textViewData = findViewById(R.id.data);
        getData();
    }
    void getData(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RestApi service = retrofit.create(RestApi.class);
        String photoPath = mCurrentPhotoPath.substring("file:".length() + 1);
        Log.d("test", photoPath);
        File file = new File(photoPath);
        RequestBody fbody = RequestBody.create(MediaType.parse("image/jpg"),file);
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
                Log.d("error", t.getMessage());

            }
        });
    }
    private void dispatchTakePictureIntent() {
        Intent takePictureIntent =
                new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
// Ensure that there's a camera activity to handle the intent
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
// Create the File where the photo should go
            File photoFile = null;
            try {
                photoFile = createImageFile();
            } catch (IOException ex) {
// Error occurred while creating the File
            }
// Continue only if the File was successfully created
            if (photoFile != null) {
                Uri photoURI = FileProvider.getUriForFile(this,
                        "com.android.t440p.photo",
                        photoFile);
                takePictureIntent.putExtra(
                        MediaStore.EXTRA_OUTPUT,
                        photoURI);
                startActivityForResult(
                        takePictureIntent,
                        REQUEST_TAKE_PHOTO);
            }
        }
    }

    @Override
    protected void onActivityResult(
            int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_TAKE_PHOTO && resultCode == RESULT_OK) {
            Bitmap bMap = null;
            try {
                bMap = getBitmapRotatedIfRequired(mCurrentPhotoPath);
            } catch (IOException e) {
                Log.d("error", e.getMessage());
            }
            mImageView.setImageBitmap(bMap);
        }
    }
    private File createImageFile() throws IOException {
// Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new
                Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName, /* prefix */
                ".jpg", /* suffix */
                storageDir /* directory */
        );
// Save a file: path for use with ACTION_VIEW intents
        mCurrentPhotoPath = "file:" + image.getAbsolutePath();
        return image;
    }

    private Bitmap rotateBitmap(Bitmap bMap, int degrees) {
        Matrix matrix = new Matrix();
        matrix.postRotate(degrees);
        Bitmap rotatedMatrix = Bitmap.createBitmap(
                bMap,
                0,
                0,
                bMap.getWidth(),
                bMap.getHeight(),
                matrix,
                true);
        bMap.recycle();
        return rotatedMatrix;
    }

    private Bitmap getBitmapRotatedIfRequired(String pathToImageToBeRotated) throws
            IOException {
        Bitmap bMap =
                BitmapFactory.decodeFile(pathToImageToBeRotated.replace("file:", ""));
        ExifInterface ei = new ExifInterface(pathToImageToBeRotated.replace("file:", ""));
        int orientation = ei.getAttributeInt(ExifInterface.TAG_ORIENTATION,
                ExifInterface.ORIENTATION_NORMAL);
        switch (orientation) {
            case ExifInterface.ORIENTATION_ROTATE_90:
                return rotateBitmap(bMap, 90);
            case ExifInterface.ORIENTATION_ROTATE_180:
                return rotateBitmap(bMap, 180);
            case ExifInterface.ORIENTATION_ROTATE_270:
                return rotateBitmap(bMap, 270);
            default:
                return bMap;
        }
    }

}
