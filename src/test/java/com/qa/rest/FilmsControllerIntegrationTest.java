package com.qa.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.domain.DeluxeScreen;
import com.qa.domain.Films;
import com.qa.domain.StandardScreen;
import com.qa.dto.FilmsDTO;
import com.qa.repo.FilmsRepository;
import com.qa.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class FilmsControllerIntegrationTest {

    @Autowired
    private MockMvc mock;

    @Autowired
    private FilmsRepository repository;

    @Autowired
    private ModelMapper mapper;

    private ObjectMapper objectMapper = new ObjectMapper();

    private Films testFilms;

    private Films testFilmsWithID;

    private long testID;

    private List<StandardScreen> standardScreen;

    private List<DeluxeScreen> deluxeScreen;

    private FilmsDTO filmsDTO;

    private FilmsDTO mapToDTO(Films films){
        return this.mapper.map(films, FilmsDTO.class);
    }

    @Before
    public void setUpForTests() {
        this.repository.deleteAll();
        this.standardScreen = new ArrayList<>();
        this.deluxeScreen = new ArrayList<>();
        this.testFilms = new Films("Title", "classification", true,
                "AAA", standardScreen, deluxeScreen);
        this.testFilmsWithID = this.repository.save(testFilms);
        this.testID = testFilmsWithID.getFilmsID();
        this.filmsDTO = this.mapToDTO(testFilmsWithID);
    }

    @Test
    public void getAllFilmsTest() throws Exception {
        List<FilmsDTO> filmsDTOList = new ArrayList<>();
        filmsDTOList.add(filmsDTO);
        String jsonContent = this.mock.perform(request(HttpMethod.GET, "/getAllUsers")
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn().getResponse()
                .getContentAsString();
        assertEquals(jsonContent, this.objectMapper.writeValueAsString(filmsDTOList));
    }
}
