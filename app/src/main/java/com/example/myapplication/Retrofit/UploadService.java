package com.example.myapplication.Retrofit;

import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**
 * @author CodeMilk
 * @version 1.0
 * @title UploadService
 * @projectName My Application
 * @description TODO
 * @date 2022/4/10 11:41
 */
public interface UploadService {

    /**
     * 文件上传
     *
     * @param file
     * @return
     */
    @POST("/post")
    @Multipart
    Call<ResponseBody> upload(@Part MultipartBody.Part file);

    /**
     * 文件下载
     * 大文件下载加上@Streaming 注解内存溢出，以流的方式
     * @param url
     * @return
     */
    @GET
    @Streaming
    Call<ResponseBody> download(@Url String url);

}
