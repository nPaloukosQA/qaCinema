package com.qa.rest;

import com.qa.domain.Films;
import com.qa.dto.FilmsDTO;
import com.qa.service.FilmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class FilmsController {

    private final FilmsService service;

    @Autowired
    public FilmsController(FilmsService service) {
        this.service = service;
    }

    @PostMapping("/createFilms")
    public ResponseEntity<FilmsDTO> createFilms(@RequestBody Films films) {
        return new ResponseEntity<FilmsDTO>(this.service.createFilms(films), HttpStatus.CREATED);
    }

    @GetMapping("/getAllFilms")
    public ResponseEntity<List<FilmsDTO>> getAllFilms() {
        return ResponseEntity.ok(this.service.readFilms());
    }

    @GetMapping("/getFilmsById/{filmsID}")
    public ResponseEntity<FilmsDTO> getFilmsById(@PathVariable Long filmsID) {
        return ResponseEntity.ok(this.service.getFilmsById(filmsID));
    }

    // @GetMapping("/getFilmsStandardScreenings/{filmsID}")
    // public ResponseEntity<List<StandardScreenDTO>> getFilmsStandardScreenings(@PathVariable Long filmsID) {
    //     return ResponseEntity.ok(this.service.getFilmsStandardScreenings(filmsID));
    // }

    // @GetMapping("/getFilmsDeluxeScreenings/{filmsID}")
    // public ResponseEntity<List<DeluxeScreenDTO>> getFilmsDeluxeScreenings(@PathVariable Long filmsID) {
    //     return ResponseEntity.ok(this.service.getFilmsDeluxeScreenings(filmsID));
    // }

    @PutMapping("/updateFilms/{filmsID}")
    public ResponseEntity<FilmsDTO> updateFilms(@PathVariable Long filmsID, @RequestBody Films films){
        return ResponseEntity.ok(this.service.updateFilms(filmsID, films));
    }

    @DeleteMapping("/deleteFilms/{filmsID}")
    public ResponseEntity<?> deleteFilms(@PathVariable Long filmsID){
        return this.service.deleteFilms(filmsID)
                ? ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()
                : ResponseEntity.noContent().build();
    }
}
