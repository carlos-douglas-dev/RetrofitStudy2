package com.example.android.retrofitstudy1.api;

import com.example.android.retrofitstudy1.model.Model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MyApi
{
    @GET("posts")
    Call<List<Model>> getModels();
}
