package com.ladutsko.filmslibrary.services.impl;

import com.ladutsko.filmslibrary.model.Film;
import com.ladutsko.filmslibrary.repositories.FilmRepository;
import com.ladutsko.filmslibrary.services.FilmService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FilmServiceImpl implements FilmService {

    private final FilmRepository filmRepository;

    @Override
    public List<Film> searchFilms(String lastName, Integer yearFrom, Integer yearUntil) {
        List<Film> films;
        if (lastName.isEmpty() && yearFrom == null && yearUntil == null) {
            films = filmRepository.findAll();
        } else {
            films = filmRepository.findFilms(lastName, yearFrom, yearUntil);
        }

        return films;
    }

    @Override
    public Film createFilm(Film film) {
        return filmRepository.save(film);
    }

    @Override
    public Film updateFilm(Film film) {
        return filmRepository.save(film);
    }
}
