package com.ladutsko.filmslibrary.repositories;

import com.ladutsko.filmslibrary.model.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface DirectorRepository extends JpaRepository<Director, Integer> {

    boolean existsDirectorByFirstNameAndLastNameAndBirthDate(String firstName, String lastName, LocalDate birthDate);

    boolean existsDirectorById(Integer id);
}
