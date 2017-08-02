package com.example.demo.iframework;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * @author ${mayong}
 *         创建时间 2017/8/2.
 */

public interface DataService {
    @POST("data/login")
    Call<String> login(@Query("loginname") String loginname,
                       @Query("pwd") String pwd);

}
