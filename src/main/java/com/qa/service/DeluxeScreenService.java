package com.qa.service;

import com.qa.domain.DeluxeScreen;
import com.qa.dto.DeluxeScreenDTO;
import com.qa.exceptions.DeluxeScreenNotFoundException;
import com.qa.repo.DeluxeScreenRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeluxeScreenService {

    private final DeluxeScreenRepository repo;

    private final ModelMapper mapper;

    @Autowired
    public DeluxeScreenService(DeluxeScreenRepository repo, ModelMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    private DeluxeScreenDTO mapToDTO(DeluxeScreen deluxeScreen) {
        return this.mapper.map(deluxeScreen, DeluxeScreenDTO.class);
    }

    private DeluxeScreenDTO createDeluxeScreen(DeluxeScreen deluxeScreen) {
        return this.mapToDTO(this.repo.save(deluxeScreen));
    }

    public List<DeluxeScreenDTO> readDeluxeScreens() {
        return this.repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public DeluxeScreenDTO getDeluxeScreenById(Long deluxeScreenId) {
        return this.mapToDTO(this.repo.findById(deluxeScreenId).orElseThrow(DeluxeScreenNotFoundException::new));
    }

    public DeluxeScreenDTO updateDeluxeScreen(Long deluxeScreenId, DeluxeScreen deluxeScreen) {
        DeluxeScreen update = this.repo.findById(deluxeScreenId).orElseThrow(DeluxeScreenNotFoundException::new);
        update.setDeluxeFilmId(deluxeScreen.getDeluxeFilmId());
        update.setDeluxeBookingId(deluxeScreen.getDeluxeBookingId());
        update.setDeluxeScreeningTime(deluxeScreen.getDeluxeScreeningTime());
        update.setDeluxeSeatsBooked(deluxeScreen.getDeluxeSeatsBooked());
        DeluxeScreen tempDeluxeScreen = this.repo.save(update);
        return this.mapToDTO(tempDeluxeScreen);
    }

    public boolean deleteDeluxeScreen(Long deluxeScreenId) {
        if (!this.repo.existsById(deluxeScreenId)) {
            throw new DeluxeScreenNotFoundException();
        }
        this.repo.deleteById(deluxeScreenId);
        return this.repo.existsById(deluxeScreenId);
    }


}
