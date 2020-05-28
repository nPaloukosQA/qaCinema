package com.qa.rest;

import com.qa.domain.StandardScreen;
import com.qa.dto.StandardScreenDTO;
import com.qa.service.StandardScreenService;
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
public class StandardScreenControllerUnitTest {

    @InjectMocks
    private StandardScreenController standardScreenController;

    @Mock
    private StandardScreenService service;

    private List<StandardScreen> standardScreen;

    private StandardScreen testStandardScreen;

    private StandardScreen testStandardScreenWithId;

    private Long standardScreenId = 1L;

    private StandardScreenDTO standardScreenDTO;

    private final ModelMapper mapper = new ModelMapper();

    private StandardScreenDTO mapToDTO(StandardScreen standardScreen) { return this.mapper.map(standardScreen, StandardScreenDTO.class); }

    @Before
    public void setUp() {
        this.standardScreen = new ArrayList<>();
        this.testStandardScreen = new StandardScreen();
        this.standardScreen.add(testStandardScreen);
        this.testStandardScreenWithId = new StandardScreen();
        this.testStandardScreenWithId.setStandardScreeningId(this.standardScreenId);
        this.standardScreenDTO = this.mapToDTO(testStandardScreenWithId);
    }

    @Test
    public void createStandardScreenTest() {
        when(this.service.createStandardScreen(testStandardScreen)).thenReturn(this.standardScreenDTO);
        assertEquals(this.standardScreenController.createStandardScreen(testStandardScreen), new ResponseEntity<StandardScreenDTO>(this.standardScreenDTO, HttpStatus.CREATED));
        verify(this.service, times(1)).createStandardScreen(testStandardScreen);
    }

    @Test
    public void getAllStandardScreensTest() {
        when(service.readStandardScreens()).thenReturn(this.standardScreen.stream().map(this::mapToDTO).collect(Collectors.toList()));
        assertFalse("No Standard Screens found", this.standardScreenController.getAllStandardScreens().getBody().isEmpty());
        verify(service, times(1)).readStandardScreens();
    }

    @Test
    public void getStandardScreenByIdTest() {
        when(this.service.getStandardScreenById(standardScreenId)).thenReturn(this.standardScreenDTO);
        assertEquals(this.standardScreenController.getStandardScreenById(standardScreenId), new ResponseEntity<StandardScreenDTO>(this.standardScreenDTO, HttpStatus.OK));
        verify(service, times(1)).getStandardScreenById(standardScreenId);
    }

//    @Test
//    public void  updateStandardScreenTest() {
//
//    }

//    @Test
//    public void deleteStandardScreenTestTrue() {
//
//    }

//    @Test
//    public void deleteStandardScreenTestFalse() {
//
//    }

}
