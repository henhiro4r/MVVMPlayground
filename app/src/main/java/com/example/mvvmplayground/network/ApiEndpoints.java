package com.example.mvvmplayground.network;

import com.example.mvvmplayground.model.MovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiEndpoints {
    @GET("discover/movie") // get movies collection
    Call<MovieResponse> getMovies(@Query("api_key") String apiKey);

//    @GET("movie/{movie_id}")
//    Call<MovieResponse> getDetailMovie(@Path("movie_id") int movieId, @Query("api_key") String apiKey);
}
