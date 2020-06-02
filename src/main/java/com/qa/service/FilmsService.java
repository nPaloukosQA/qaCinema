package com.qa.service;

import com.qa.domain.Films;
import com.qa.domain.StandardScreen;
import com.qa.dto.DeluxeScreenDTO;
import com.qa.dto.FilmsDTO;
import com.qa.dto.StandardScreenDTO;
import com.qa.exceptions.FilmsNotFoundException;
import com.qa.repo.FilmsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FilmsService {

    private final FilmsRepository repo;

    private final ModelMapper mapper;

    @Autowired
    public FilmsService(FilmsRepository repo, ModelMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    private FilmsDTO mapToDTO(Films films) {
        return this.mapper.map(films, FilmsDTO.class);
    }

    public FilmsDTO createFilms(Films films) {
        return this.mapToDTO(this.repo.save(films));
    }


    public List<FilmsDTO> readFilms() {
        return this.repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public FilmsDTO getFilmsById(Long filmsID) {
        return this.mapToDTO(this.repo.findById(filmsID).orElseThrow(FilmsNotFoundException::new));
    }

    public List<StandardScreenDTO> getFilmsStandardScreenings(Long filmsID) {
        Films tempFilms = this.repo.findById(filmsID).orElseThrow(FilmsNotFoundException::new);
        return this.mapToDTO(tempFilms).getStandardScreen();
    }

    public List<DeluxeScreenDTO> getFilmsDeluxeScreenings(Long filmsID) {
        Films tempFilms = this.repo.findById(filmsID).orElseThrow(FilmsNotFoundException::new);
        return this.mapToDTO(tempFilms).getDeluxeScreen();
    }

    public FilmsDTO updateFilms(Long filmsID, Films films) {
        Films update = this.repo.findById(filmsID).orElseThrow(FilmsNotFoundException::new);
        update.setFilmsTitle(films.getFilmsTitle());
        update.setFilmsClassification(films.getFilmsClassification());
        update.setFilmsIsFeature(films.getFilmsIsFeature());
        update.setFilmsCurrentlyReleased(films.getFilmsCurrentlyReleased());
        update.setStandardScreen(films.getStandardScreen());
        update.setDeluxeScreen(films.getDeluxeScreen());
        Films tempFilms = this.repo.save(update);
        return this.mapToDTO(tempFilms);
    }

    public boolean deleteFilms(Long filmsID){
        if(!this.repo.existsById(filmsID)){
            throw new FilmsNotFoundException();
        }
        this.repo.deleteById(filmsID);
        return this.repo.existsById(filmsID);
    }
}
