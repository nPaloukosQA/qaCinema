package com.qa.service;

import com.qa.domain.StandardScreen;
import com.qa.dto.StandardScreenDTO;
import com.qa.exceptions.StandardScreenNotFoundException;
import com.qa.repo.StandardScreensRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StandardScreenService {

    private final StandardScreensRepository repo;

    private final ModelMapper mapper;

    @Autowired
    public StandardScreenService(StandardScreensRepository repo, ModelMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    private StandardScreenDTO mapToDTO(StandardScreen standardScreen) { return this.mapper.map(standardScreen, StandardScreenDTO.class);}

    public StandardScreenDTO createStandardScreen(StandardScreen standardScreen) { return this.mapToDTO(this.repo.save(standardScreen));}

    public List<StandardScreenDTO> readStandardScreens() {
        return this.repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public StandardScreenDTO getStandardScreenById(Long standardScreenId) {
        return this.mapToDTO(this.repo.findById(standardScreenId).orElseThrow(StandardScreenNotFoundException::new));
    }

    public StandardScreenDTO updateStandardScreen(Long standardScreenId, StandardScreen standardScreen) {
        StandardScreen update = this.repo.findById(standardScreenId).orElseThrow(StandardScreenNotFoundException::new);
        update.setStandardScreenFilmId(standardScreen.getStandardScreenFilmId());
        update.setStandardScreenBookingId(standardScreen.getStandardScreenBookingId());
        update.setStandardScreenScreeningTime(standardScreen.getStandardScreenScreeningTime());
        update.setStandardScreenSeatsBooked(standardScreen.getStandardScreenSeatsBooked());
        StandardScreen tempStandardScreen = this.repo.save(update);
        return this.mapToDTO(tempStandardScreen);
    }

    public boolean deleteStandardScreen(Long standardScreenId){
        if(!this.repo.existsById(standardScreenId)){
            throw new StandardScreenNotFoundException();
        }
        this.repo.deleteById(standardScreenId);
        return this.repo.existsById(standardScreenId);
    }
}
