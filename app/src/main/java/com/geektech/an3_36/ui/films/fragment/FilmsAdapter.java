package com.geektech.an3_36.ui.films.fragment;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.geektech.an3_36.data.models.Film;
import com.geektech.an3_36.databinding.ItemFilmBinding;

import java.util.ArrayList;
import java.util.List;

public class FilmsAdapter extends RecyclerView.Adapter<FilmsAdapter.FilmsViewHolder> {

    private List<Film> films = new ArrayList<>();
    private OnItemClickListener onItemClickListener;

    public void setFilms(List<Film>films) {
        this.films = films;
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public FilmsAdapter.FilmsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        ItemFilmBinding binding = ItemFilmBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent,
                false
        );
        return new FilmsViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull FilmsAdapter.FilmsViewHolder holder, int position) {
        holder.onBind(films.get(position));
    }

    @Override
    public int getItemCount() {
        return films.size();
    }

    public class FilmsViewHolder extends RecyclerView.ViewHolder {

        private ItemFilmBinding binding;

        public FilmsViewHolder(@NonNull ItemFilmBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
        public void onBind(Film film){
            binding.title.setText(film.getTitle());
            binding.description.setText(film.getDescription());
            binding.getRoot().setOnClickListener(view -> {
                onItemClickListener.OnItemClick(film);
            });
        }
    }
}