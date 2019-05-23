package com.example.cobaprojek1.connection;

import com.example.cobaprojek1.model.get_user.LoginResponse;
import com.example.cobaprojek1.model.postlogin.PostLoginResponse;
import com.example.cobaprojek1.model.update.CreateResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;

/**
 * Created by Qori Fatkhul Kurniyadi on 15/05/2019
 * Nim : 124170036
 * github : github.com/qori19
 */

public interface ApiLogin {
    @FormUrlEncoded
    @POST("/users/login")
    Call<PostLoginResponse> PostUserResponse (@Field("email") String email,
                                              @Field("password") String passw);

    @FormUrlEncoded
    @POST("/users")
    Call<Void> PostCreate (@Field("email") String email,
                           @Field("password") String passw,
                           @Field("name") String name);

    @GET("/users/")
    Call<List<LoginResponse>> getUser (@Header("x-access-token")String token);

    @FormUrlEncoded
    @PUT("/users/")
    Call<CreateResponse> updateUser (@Header("x-access-token") String token,
                                     @Field("name") String name);
}
