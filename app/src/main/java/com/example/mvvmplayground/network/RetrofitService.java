package com.example.mvvmplayground.network;

import com.example.mvvmplayground.model.MovieResponse;
import com.example.mvvmplayground.util.Constants;

import java.util.PrimitiveIterator;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {
//    private static Retrofit retrofit;
    private ApiEndpoints api;
    private static RetrofitService service;

//    public static <S> S createService(Class<S> serviceClass) {
//        if (retrofit == null) {
//            retrofit = new Retrofit.Builder()
//                    .baseUrl(Constants.BASE_URL)
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .build();
//        }
//        return retrofit.create(serviceClass);
//    }

    private RetrofitService() {
        api = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiEndpoints.class);
    }

    public static RetrofitService getInstance() {
        if (service == null) {
            service = new RetrofitService();
        }
        return service;
    }

    public Call<MovieResponse> getMovies() {
        return api.getMovies(Constants.API_KEY);
    }
}
