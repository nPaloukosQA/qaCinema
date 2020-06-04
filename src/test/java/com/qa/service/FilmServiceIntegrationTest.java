package com.qa.service;

import com.qa.domain.DeluxeScreen;
import com.qa.domain.Films;
import com.qa.domain.StandardScreen;
import com.qa.dto.FilmsDTO;
import com.qa.repo.FilmsRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FilmServiceIntegrationTest {

    @Autowired
    private FilmsService service;

    @Autowired
    private FilmsRepository repo;

    @Autowired
    private ModelMapper mapper;

    private Films testFilms;

    private Films testFilmsWithID;

    private FilmsDTO mapToDTO(Films films){
        return this.mapper.map(films, FilmsDTO.class);
    }

    @Before
    public void setUpForTests() {
        List<StandardScreen> standardScreen = new ArrayList<>();
        List<DeluxeScreen> deluxeScreen = new ArrayList<>();
        this.testFilms = new Films("Avenger: Infinity War", "12A", true,
                "tt4154756", true, standardScreen, deluxeScreen);
        this.repo.deleteAll();
        this.testFilmsWithID = this.repo.save(this.testFilms);
    }

    @Test
    public void readFilmsTest() {
        assertThat(this.service.readFilms()).isEqualTo(
                Stream.of(this.mapToDTO(testFilmsWithID)).collect(Collectors.toList()));
    }

    @Test
    public void createFilmsTest() {
        assertEquals(this.mapToDTO(this.testFilmsWithID), this.service.createFilms(testFilms));
    }

    @Test
    public void findFilmsByIDTest() {
        assertThat(this.service.getFilmsById(this.testFilmsWithID.getFilmsID())).isEqualTo(this.mapToDTO(this.testFilmsWithID));
    }

    @Test
    public void deleteFilmsTest() {
        assertThat(this.service.deleteFilms(this.testFilmsWithID.getFilmsID())).isFalse();
    }

}
