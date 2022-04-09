package com.example.myapplication.Retrofit;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * @author CodeMilk
 * @version 1.0
 * @title HttpService
 * @projectName My Application
 * @description TODO
 * @date 2022/4/9 17:40
 */
public interface HttpService {

    /**
     * 发送Post请求
     *
     * @param userName
     * @param password
     * @return
     */
    @POST("/post")
    @FormUrlEncoded
    Call<ResponseBody> post(@Field("username") String userName, @Field("password ") String password);


    /**
     * 发送Get请求
     *
     * @param userName
     * @param password
     * @return
     */
    @GET("/get")
    Call<ResponseBody> get(@Query("username") String userName, @Query("password") String password);


}
