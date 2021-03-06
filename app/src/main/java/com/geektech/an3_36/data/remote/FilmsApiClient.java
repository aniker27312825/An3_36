package com.geektech.an3_36.data.remote;

import com.geektech.an3_36.App;
import com.geektech.an3_36.data.models.Film;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FilmsApiClient {

    public void getFilms(FilmsCallback filmsCallback){
        App.api.getFilms().enqueue(new Callback<List<Film>>() {
            @Override
            public void onResponse(Call<List<Film>> call, Response<List<Film>> response) {
                if(response.isSuccessful() && response.body() != null) {
                    filmsCallback.success(response.body());
                }else {
                    filmsCallback.failure(response.errorBody().toString());
                }

            }

            @Override
            public void onFailure(Call<List<Film>> call, Throwable t) {
                   filmsCallback.failure((t.getLocalizedMessage()));
            }
        });
    }
}
