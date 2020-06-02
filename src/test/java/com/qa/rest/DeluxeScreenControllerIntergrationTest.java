package com.qa.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.domain.DeluxeScreen;
import com.qa.dto.DeluxeScreenDTO;
import com.qa.repo.DeluxeScreenRepository;
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
public class DeluxeScreenControllerIntergrationTest {

    @Autowired
    private MockMvc mock;

    @Autowired
    private DeluxeScreenRepository repository;

    @Autowired
    private ModelMapper mapper;

    private ObjectMapper objectMapper = new ObjectMapper();

    private DeluxeScreen testDeluxeScreen;

    private DeluxeScreen testDeluxeScreenWithId;

    private Long deluxeScreenId;

    private DeluxeScreenDTO deluxeScreenDTO;

    private DeluxeScreenDTO mapToDTO(DeluxeScreen deluxeScreen) {
        return this.mapper.map(deluxeScreen, DeluxeScreenDTO.class);
    }

    @Before
    public void setUp() {
        this.repository.deleteAll();
        this.testDeluxeScreen = new DeluxeScreen();
        this.testDeluxeScreenWithId = this.repository.save(testDeluxeScreen);
        this.deluxeScreenId = testDeluxeScreenWithId.getDeluxeScreeningId();
        this.deluxeScreenDTO = this.mapToDTO(testDeluxeScreenWithId);
    }

    @Test
    public void createDeluxeScreenTest() throws Exception {
        String result = this.mock.perform(
                request(HttpMethod.POST, "/createDeluxeScreen")
                .contentType(MediaType.APPLICATION_JSON)
                .content(this.objectMapper.writeValueAsString(testDeluxeScreen))
                .accept(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isCreated())
                .andReturn()
                .getResponse()
                .getContentAsString();
        assertEquals(result, this.objectMapper.writeValueAsString(deluxeScreenDTO));
    }

    @Test
    public void getAllDeluxeScreensYTest() throws Exception {
        List<DeluxeScreenDTO> deluxeScreenDTOList = new ArrayList<>();
        deluxeScreenDTOList.add(deluxeScreenDTO);
        String content = this.mock.perform(
                request(HttpMethod.GET, "/getAllDeluxeScreens")
                        .accept(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();
        assertEquals(content, this.objectMapper.writeValueAsString(deluxeScreenDTOList));
    }

    @Test
    public void getDeluxeScreenByIdTest() throws Exception {
        String content = this.mock.perform(
                request(HttpMethod.GET, "/getDeluxeScreenById/" + this.deluxeScreenId)
                        .accept(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();
        assertEquals(content, this.objectMapper.writeValueAsString(deluxeScreenDTO));
    }

    @Test
    public void deleteDeluxeScreenTest() throws Exception {
        this.mock.perform(
                request(HttpMethod.DELETE, "/deleteDeluxeScreen/" + this.deluxeScreenId)
        ).andExpect(status().isNoContent());
    }

}
