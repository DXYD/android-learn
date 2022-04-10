package com.example.myapplication.Retrofit;

import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * @author CodeMilk
 * @version 1.0
 * @title UploadServiceUnitTest
 * @projectName My Application
 * @description TODO
 * @date 2022/4/10 13:38
 */
public class UploadServiceUnitTest {
    Retrofit retrofit = new Retrofit.Builder().baseUrl("https://httpbin.org/").build();

    UploadService uploadService = retrofit.create(UploadService.class);

    @Test
    public void uploadFileTest() throws IOException {
        File fileA = new File("C:\\Users\\Administrator\\Desktop\\1.txt");
        MultipartBody.Part part = MultipartBody.Part.createFormData("fileA", "1.txt", RequestBody.create(MediaType.parse("text/plain"), fileA));

        Call<ResponseBody> call = uploadService.upload(part);
        System.out.println(call.execute().body().string());
    }

    @Test
    public void downloadTest() throws IOException {
        Response<ResponseBody> response = uploadService.download("http://gxt.hunan.gov.cn/gxt/rkb/jsjtzgg/202203/22721068/files/195b3e70928e4b3ba4ee86a0a578bc83.docx").execute();
        InputStream inputStream = response.body().byteStream();

        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\1.docx");

        int len;
        byte[] buffer = new byte[4096];

        while ((len = inputStream.read(buffer)) != -1){
            fileOutputStream.write(buffer, 0, len);
        }
        fileOutputStream.close();
    }
}
