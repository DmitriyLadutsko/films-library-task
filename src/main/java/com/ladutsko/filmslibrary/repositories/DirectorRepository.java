package com.ladutsko.filmslibrary.repositories;

import com.ladutsko.filmslibrary.model.Director;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectorRepository extends JpaRepository<Director, Integer> {
}
