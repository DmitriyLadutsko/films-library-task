package com.ladutsko.filmslibrary.rest.director;

import com.ladutsko.filmslibrary.facade.DirectorFacade;
import com.ladutsko.filmslibrary.model.Director;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/directors")
@RequiredArgsConstructor
public class DirectorController {

    private final DirectorFacade directorFacade;

    @GetMapping
    public ResponseEntity<List<Director>> getAll() {
        return ResponseEntity.ok(directorFacade.getAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Director> getOne(@PathVariable Integer id) {
        return ResponseEntity.ok(directorFacade.getOne(id));
    }

    @PostMapping
    public ResponseEntity<Director> add(@RequestBody Director director) {
        return ResponseEntity.status(HttpStatus.CREATED).body(directorFacade.createDirector(director));
    }

    @PutMapping
    public ResponseEntity<Director> update(@RequestBody Director director) {
        return ResponseEntity.ok(directorFacade.updateDirector(director));
    }

}
