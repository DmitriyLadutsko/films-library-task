package com.ladutsko.filmslibrary.facade.impl;

import com.ladutsko.filmslibrary.exceptions.ResourceAlreadyExistException;
import com.ladutsko.filmslibrary.exceptions.ResourceNotFoundException;
import com.ladutsko.filmslibrary.exceptions.ValidationException;
import com.ladutsko.filmslibrary.facade.FilmFacade;
import com.ladutsko.filmslibrary.model.Film;
import com.ladutsko.filmslibrary.repositories.FilmRepository;
import com.ladutsko.filmslibrary.services.FilmService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
@RequiredArgsConstructor
public class FilmFacadeImpl implements FilmFacade {

    private final FilmService filmService;
    private final FilmRepository filmRepository;

    @Override
    public List<Film> searchFilms(String lastName, Integer yearFrom, Integer yearUntil) {

        lastName = lastName != null ? lastName.trim().toLowerCase() : null;

        checkYearUntilGreaterThenFrom(yearFrom, yearUntil);

        return filmService.searchFilms(lastName, yearFrom, yearUntil);
    }

    @Override
    public Film createFilm(Film film) {
        if (filmRepository.existsFilmByNameAndReleaseDateAndGenreAndDirector(
                film.getName(),
                film.getReleaseDate(),
                film.getGenre(),
                film.getDirector())) {
            throw new ResourceAlreadyExistException("Such film already exists.");
        }
        return filmService.createFilm(film);
    }

    @Override
    public Film updateFilm(Film film) {
        filmRepository.findById(film.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Film not found."));

        return filmService.updateFilm(film);
    }

    @Override
    public List<Film> getAllFilms() {
        return filmRepository.findAll();
    }

    private void checkYearUntilGreaterThenFrom(Integer yearFrom, Integer yearUntil) {
        validateYear(yearFrom);
        validateYear(yearUntil);
        if (yearFrom != null && yearUntil != null) {
            if (yearFrom > yearUntil) {
                throw new ValidationException("The \"Release Until\" must be greater then \"Release From\"");
            }
        }
    }

    private void validateYear(Integer year) {
        if (year != null) {
            if (!String.valueOf(year).matches("^\\d{4}$")) {
                throw new ValidationException("The year must be a number with four digits");
            }
        }
    }
}
