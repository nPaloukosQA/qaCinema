package com.qa.rest;

import com.qa.domain.DeluxeScreen;
import com.qa.domain.Films;
import com.qa.domain.StandardScreen;
import com.qa.dto.FilmsDTO;
import com.qa.service.FilmsService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class FilmsControllerUnitTest {

    @InjectMocks
    private FilmsController filmsController;

    @Mock
    private FilmsService service;

    private List<Films> filmsList;

    private Films testFilms;

    private Films testFilmsWithID;

    private long testID = 1L;

    private List<StandardScreen> standardScreen;

    private List<DeluxeScreen> deluxeScreen;

    private FilmsDTO filmsDTO;

    private final ModelMapper mapper = new ModelMapper();

    private FilmsDTO mapToDTO(Films films){
        return this.mapper.map(films, FilmsDTO.class);
    }

    @Before
    public void setUpForTests() {
        this.filmsList = new ArrayList<>();
        this.standardScreen = new ArrayList<>();
        this.deluxeScreen = new ArrayList<>();
        this.testFilms = new Films("Title", "classification", true,
                "AAA", standardScreen, deluxeScreen);
        this.filmsList.add(testFilms);
        this.testFilmsWithID = new Films(testFilms.getFilmsTitle(), testFilms.getFilmsClassification(), testFilms.getFilmsIsFeature(),
                testFilms.getFilmsOMDBID(), testFilms.getStandardScreen(), testFilms.getDeluxeScreen());
        this.testFilmsWithID.setFilmsID(this.testID);
        this.filmsDTO = this.mapToDTO(testFilmsWithID);
    }

    @Test
    public void getAllFilmsTest() {
        when(service.readFilms()).thenReturn(this.filmsList.stream().map(this::mapToDTO).collect(
                Collectors.toList()));
        assertFalse("No Users found", this.filmsController.getAllFilms().getBody().isEmpty());
        verify(service, times(1)).readFilms();
    }

    @Test
    public void createFilmsTest() {
        when(this.service.createFilms(testFilms)).thenReturn(this.filmsDTO);
        assertEquals(this.filmsController.createFilms(testFilms), new ResponseEntity<FilmsDTO>(
                this.filmsDTO, HttpStatus.CREATED));
        verify(this.service, times(1)).createFilms(testFilms);
    }

}
