package com.ladutsko.filmslibrary.facade;

import com.ladutsko.filmslibrary.model.Film;

import java.util.List;

public interface FilmFacade {

    List<Film> searchFilms(String lastName, Integer yearFrom, Integer yearUntil);

    Film createFilm(Film film);

    Film updateFilm(Film film);

    List<Film> getAllFilms();

    void delete(Integer id);
}
