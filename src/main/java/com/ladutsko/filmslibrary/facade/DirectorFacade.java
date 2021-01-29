package com.ladutsko.filmslibrary.facade;

import com.ladutsko.filmslibrary.model.Director;

import java.util.List;

public interface DirectorFacade {

    List<Director> getAll();

    Director getOne(Integer directorId);
}
