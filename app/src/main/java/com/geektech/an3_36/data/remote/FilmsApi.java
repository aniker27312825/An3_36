package com.geektech.an3_36.data.remote;

import com.geektech.an3_36.data.models.Film;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface FilmsApi {

    @GET("films")
    Call<List<Film>> getFilms();

    @GET("films/{id}")
    Call<Film> getFilmsById(
            @Path("id") String id
    );
}
