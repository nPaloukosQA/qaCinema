package com.qa.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.domain.StandardScreen;
import com.qa.dto.StandardScreenDTO;
import com.qa.repo.StandardScreensRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
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
public class StandardScreenControllerIntergrationTest {

    @Autowired
    private MockMvc mock;

    @Autowired
    private StandardScreensRepository repository;

    @Autowired
    private ModelMapper mapper;

    private ObjectMapper objectMapper = new ObjectMapper();

    private StandardScreen testStandardScreen;

    private StandardScreen testStandardScreenWithId;

    private Long standardScreenId;

    private StandardScreenDTO standardScreenDTO;

    private StandardScreenDTO mapToDTO(StandardScreen standardScreen) { return this.mapper.map(standardScreen, StandardScreenDTO.class); }

    @Before
    public void setUp() {
        this.repository.deleteAll();
        this.testStandardScreen = new StandardScreen();
        this.testStandardScreenWithId = this.repository.save(testStandardScreen);
        this.standardScreenId = testStandardScreenWithId.getStandardScreeningId();
        this.standardScreenDTO = this.mapToDTO(testStandardScreenWithId);
    }

    @Test
    public void createStandardScreenTest() throws Exception {
        String result = this.mock.perform(
                request(HttpMethod.POST, "/createStandardScreen")
                .contentType(MediaType.APPLICATION_JSON)
                .content(this.objectMapper.writeValueAsString(testStandardScreen))
                .accept(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isCreated())
                .andReturn()
                .getResponse()
                .getContentAsString();
        assertEquals(result, this.objectMapper.writeValueAsString(standardScreenDTO));
    }

    @Test
    public void getAllStandardScreensYTest() throws Exception {
        List<StandardScreenDTO> standardScreenDTOList = new ArrayList<>();
        standardScreenDTOList.add(standardScreenDTO);
        String content = this.mock.perform(
                request(HttpMethod.GET, "/getAllStandardScreens")
                    .accept(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();
        assertEquals(content, this.objectMapper.writeValueAsString(standardScreenDTOList));
    }

    @Test
    public void getStandardScreenByIdTest() throws Exception {
        String content = this.mock.perform(
                request(HttpMethod.GET, "/getStandardScreenById/" + this.standardScreenId)
                    .accept(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();
        assertEquals(content, this.objectMapper.writeValueAsString(standardScreenDTO));
    }

    @Test
    public void updateStandardScreenTest() throws Exception {
        String content = this.mock.perform(
                request(HttpMethod.PUT, "/updateStandardScreen/" + this.standardScreenId)
                    .accept(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();
        assertEquals(content, this.objectMapper.writeValueAsString(standardScreenDTO));
    }

    @Test
    public void deleteStandardScreenTest() throws Exception {
        this.mock.perform(
                request(HttpMethod.DELETE, "/deleteStandardScreen/" + this.standardScreenId)
        ).andExpect(status().isNoContent());
    }

}
