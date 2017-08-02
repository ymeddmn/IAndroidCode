package com.example.demo.iframework.login;

import com.example.demo.iframework.DataService;
import com.example.mvplibrary.zmodel.impl.ModelImpl;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * @author ${mayong}
 *         创建时间 2017/8/2.
 */

public class LoginModel extends ModelImpl {
    public void login(String userName, String pwd) {
        repuestData();
    }

    private void repuestData() {
        //
        //
        ///
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://106.3.227.33/pulamsi/")
                //增加返回值为String的支持
                .addConverterFactory(ScalarsConverterFactory.create())
                //增加返回值为Gson的支持(以实体类返回)
                .addConverterFactory(GsonConverterFactory.create())
                //增加返回值为Oservable<T>的支持
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();


        DataService requestSerives = retrofit.create(DataService.class);
        Call<String> call = requestSerives.login("userName", "1234");
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                getCallBackListener().call(new LoginResponse());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                getCallBackListener().error("请求失败");
            }
        });


    }
}
