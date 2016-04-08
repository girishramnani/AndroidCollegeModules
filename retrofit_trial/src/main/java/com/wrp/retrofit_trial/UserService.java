package com.wrp.retrofit_trial;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Girish on 08-04-2016.
 */
public interface UserService {

    @GET("api")
    Call<User> getUser();
}
