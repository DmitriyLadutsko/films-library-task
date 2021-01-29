package com.ladutsko.filmslibrary.services;

import com.ladutsko.filmslibrary.model.Film;

import java.util.List;

public interface FilmService {

    List<Film> searchFilms(String lastName, Integer yearFrom, Integer yearUntil);

    Film createFilm(Film film);

    Film updateFilm(Film film);
}
