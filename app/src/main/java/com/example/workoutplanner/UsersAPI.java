package com.example.workoutplanner;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface UsersAPI {

    @GET("users/token")
    Call<UserResponse> getUser(@Query("api_key") String apiKey);

    @POST("users")
    Call<User> createPost(@Body User user);

}
