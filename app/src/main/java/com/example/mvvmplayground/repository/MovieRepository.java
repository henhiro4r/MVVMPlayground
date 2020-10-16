package com.example.mvvmplayground.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.mvvmplayground.model.Movie;
import com.example.mvvmplayground.model.MovieResponse;
import com.example.mvvmplayground.network.ApiEndpoints;
import com.example.mvvmplayground.network.RetrofitService;
import com.example.mvvmplayground.util.Constants;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieRepository {
    private static MovieRepository movieRepository;
    private ApiEndpoints apiEndpoints;
    private RetrofitService apiService;
    private static final String TAG = "MovieRepository";

    private MovieRepository() {
        apiService = RetrofitService.getInstance();
    }

    public static MovieRepository getInstance() {
        if (movieRepository == null) {
            movieRepository = new MovieRepository();
        }
        return movieRepository;
    }

    public MutableLiveData<List<Movie>> getMovieCollection() {
        MutableLiveData<List<Movie>> listMovie = new MutableLiveData<>();

        apiService.getMovies().enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        Log.d(TAG, "onResponse: " + response.body().getResults().size());
                        listMovie.postValue(response.body().getResults());
                    }
                }
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });

//        apiEndpoints.getMovies(Constants.API_KEY).enqueue(new Callback<MovieResponse>() {
//            @Override
//            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
//                if (response.isSuccessful()) {
//                    if (response.body() != null) {
//                        Log.d(TAG, "onResponse: " + response.body().getPages());
//                        listMovie.postValue(response.body().getResults());
//                    }
//                }
//            }
//
//            @Override
//            public void onFailure(Call<MovieResponse> call, Throwable t) {
//                Log.d(TAG, "onFailure: " + t.getMessage());
//            }
//        });

        return listMovie;
    }
}
