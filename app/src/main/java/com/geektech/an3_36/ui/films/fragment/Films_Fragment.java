package com.geektech.an3_36.ui.films.fragment;

import static android.content.ContentValues.TAG;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.geektech.an3_36.App;
import com.geektech.an3_36.R;
import com.geektech.an3_36.data.models.Film;
import com.geektech.an3_36.data.remote.FilmsCallback;
import com.geektech.an3_36.databinding.FragmentFilmsBinding;

import java.util.List;

import retrofit2.http.Path;


public class Films_Fragment extends Fragment implements FilmsCallback, OnItemClickListener {

    private FragmentFilmsBinding binding;
    private FilmsAdapter adapter;

    public Films_Fragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFilmsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        adapter = new FilmsAdapter();
        adapter.setOnItemClickListener(this);
        binding.filmsRecycler.setAdapter(adapter);

        App.client.getFilms(this);

        }


    @Override
    public void success(List<Film> films) {
        adapter.setFilms(films);
    }

    // @Path() //надо использовать в домашке

    @Override
    public void failure(String msg) {
        Log.e("TAG", "failure: " + msg);
    }

    @Override
    public void OnItemClick(Film film) {
        String id = film.getId();
        Bundle bundle = new Bundle();
        bundle.putString("key", id);
        NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host);
        navController.navigate(R.id.filmDetailFragment, bundle);
    }
}