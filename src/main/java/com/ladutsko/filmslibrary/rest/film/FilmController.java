package com.ladutsko.filmslibrary.rest.film;

import com.ladutsko.filmslibrary.facade.FilmFacade;
import com.ladutsko.filmslibrary.model.Film;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/films")
@RequiredArgsConstructor
public class FilmController {

    private final FilmFacade filmFacade;

    @GetMapping()
    public ResponseEntity<List<Film>> getAll() {
        return ResponseEntity.ok(filmFacade.getAllFilms());
    }

    @GetMapping("/search")
    public ResponseEntity<List<Film>> searchFilms(
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) Integer yearFrom,
            @RequestParam(required = false) Integer yearUntil) {
        return ResponseEntity.ok(filmFacade.searchFilms(lastName, yearFrom, yearUntil));
    }

    @PostMapping
    public ResponseEntity<Film> create(@RequestBody Film film) {
        return ResponseEntity.status(HttpStatus.CREATED).body(filmFacade.createFilm(film));
    }

    @PutMapping
    public ResponseEntity<Film> update(@RequestBody Film film) {
        return ResponseEntity.ok(filmFacade.updateFilm(film));
    }

}
