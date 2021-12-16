package com.geektech.an3_36.ui.film_detail_fragment;

import android.os.Bundle;
import android.os.Parcel;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.geektech.an3_36.App;
import com.geektech.an3_36.R;
import com.geektech.an3_36.data.models.Film;
import com.geektech.an3_36.databinding.FilmDetailfragmentLayoutBinding;
import com.geektech.an3_36.ui.films.fragment.Films_Fragment;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FilmDetailFragment extends Fragment {

    FilmDetailfragmentLayoutBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FilmDetailfragmentLayoutBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String id = getArguments().getString("key");
        App.api.getFilmsById(id).enqueue(new Callback<Film>() {
            @Override
            public void onResponse(Call<Film> call, Response<Film> response) {
                if(response.isSuccessful() && response.body() != null){
                    binding.title.setText(response.body().getTitle());
                    binding.description.setText(response.body().getDescription());
                    binding.director.setText(response.body().getDirector());
                    binding.originalTitle.setText(response.body().getOriginalTitle());
                    binding.originalTitleRomanised.setText(response.body().getOriginalTitleRomanised());

                }
            }

            @Override
            public void onFailure(Call<Film> call, Throwable t) {

            }
        });
    }
}