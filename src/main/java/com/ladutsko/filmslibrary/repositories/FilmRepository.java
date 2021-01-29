package com.ladutsko.filmslibrary.repositories;

import com.ladutsko.filmslibrary.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FilmRepository extends JpaRepository<Film, Integer> {

    @Query("select f from Film f " +
            "where (:lastName is null or lower(f.director.lastName) like concat(:lastName,'%')) " +
            "and (:yearFrom is null or FUNCTION('year', f.releaseDate) >= :yearFrom) " +
            "and (:yearUntil is null or FUNCTION('year', f.releaseDate) <= :yearUntil)")
     List<Film> findFilms(@Param("lastName") String lastName,
                          @Param("yearFrom") Integer yearFrom,
                          @Param("yearUntil") Integer yearUntil);

    boolean existsById(Integer id);

}
