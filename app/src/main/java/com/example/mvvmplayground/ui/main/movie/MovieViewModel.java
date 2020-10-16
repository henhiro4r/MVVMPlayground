package com.example.mvvmplayground.ui.main.movie;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvmplayground.model.Movie;
import com.example.mvvmplayground.repository.MovieRepository;

import java.util.List;

public class MovieViewModel extends ViewModel {

    private MovieRepository repository;

    public MovieViewModel() {
        repository = MovieRepository.getInstance();
    }

    public LiveData<List<Movie>> getMovieCollection() {
        return repository.getMovieCollection();
    }
}
