package com.changhao.week01_exercise_02.net;

import java.util.HashMap;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface RetrofitService {

    @GET
    Call<ResponseBody> getReg(@Url String apiUrl);

    @POST
    Call<ResponseBody> postReg(@Url String apiUrl, @FieldMap HashMap<String,String> params);

}
