package com.geektech.an3_36.data.remote;

import com.geektech.an3_36.data.models.Film;

import java.util.List;

public interface FilmsCallback {

    void success(List<Film> films);
    void failure(String msg);
}
