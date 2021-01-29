package com.ladutsko.filmslibrary.facade.impl;

import com.ladutsko.filmslibrary.exceptions.ResourceNotFoundException;
import com.ladutsko.filmslibrary.facade.DirectorFacade;
import com.ladutsko.filmslibrary.model.Director;
import com.ladutsko.filmslibrary.repositories.DirectorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
@RequiredArgsConstructor
public class DirectorFacadeImpl implements DirectorFacade {

    private final DirectorRepository directorRepository;

    @Override
    public List<Director> getAll() {
        return directorRepository.findAll();
    }

    @Override
    public Director getOne(Integer directorId) {
        return directorRepository.findById(directorId)
                .orElseThrow(() -> new ResourceNotFoundException("Director not found."));
    }
}
