package com.qa.rest;

import com.qa.domain.DeluxeScreen;
import com.qa.dto.DeluxeScreenDTO;
import com.qa.service.DeluxeScreenService;
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
public class DeluxeScreenControllerUnitTest {

    @InjectMocks
    private DeluxeScreenController deluxeScreenController;

    @Mock
    private DeluxeScreenService service;

    private List<DeluxeScreen> deluxeScreen;

    private DeluxeScreen testDeluxeScreen;

    private DeluxeScreen testDeluxeScreenWithId;

    private Long deluxeScreenId = 1L;

    private DeluxeScreenDTO deluxeScreenDTO;

    private final ModelMapper mapper = new ModelMapper();

    private DeluxeScreenDTO mapToDTO(DeluxeScreen deluxeScreen) {
        return this.mapper.map(deluxeScreen, DeluxeScreenDTO.class);
    }

    @Before
    public void setUp() {
        this.deluxeScreen = new ArrayList<>();
        this.testDeluxeScreen = new DeluxeScreen();
        this.deluxeScreen.add(testDeluxeScreen);
        this.testDeluxeScreenWithId = new DeluxeScreen();
        this.testDeluxeScreenWithId.setDeluxeScreeningId(this.deluxeScreenId);
        this.deluxeScreenDTO = this.mapToDTO(testDeluxeScreenWithId);
    }

    @Test
    public void createDeluxeScreenTest() {
        when(this.service.createDeluxeScreen(testDeluxeScreen)).thenReturn(this.deluxeScreenDTO);
        assertEquals(this.deluxeScreenController.createDeluxeScreen(testDeluxeScreen), new ResponseEntity<DeluxeScreenDTO>(this.deluxeScreenDTO, HttpStatus.CREATED));
        verify(this.service, times(1)).createDeluxeScreen(testDeluxeScreen);
    }

    @Test
    public void getAllDeluxeScreensTest() {
        when(service.readDeluxeScreens()).thenReturn(this.deluxeScreen.stream().map(this::mapToDTO).collect(Collectors.toList()));
        assertFalse("No Deluxe Screens found", this.deluxeScreenController.getAllDeluxeScreens().getBody().isEmpty());
        verify(service, times(1)).readDeluxeScreens();
    }

    @Test
    public void getDeluxeScreenByIdTest() {
        when(this.service.getDeluxeScreenById(deluxeScreenId)).thenReturn(this.deluxeScreenDTO);
        assertEquals(this.deluxeScreenController.getDeluxeScreenById(deluxeScreenId), new ResponseEntity<DeluxeScreenDTO>(this.deluxeScreenDTO, HttpStatus.OK));
        verify(service, times(1)).getDeluxeScreenById(deluxeScreenId);
    }

    @Test
    public void deleteDeluxeScreenTestTrue() {
        when(service.deleteDeluxeScreen(3L)).thenReturn(true);
        this.deluxeScreenController.deleteDeluxeScreen(3L);
        verify(service, times(1)).deleteDeluxeScreen(3L);
    }

    @Test
    public void deteleDeluxeScreenTestFalse() {
        this.deluxeScreenController.deleteDeluxeScreen(deluxeScreenId);
        verify(service, times(1)).deleteDeluxeScreen(deluxeScreenId);
    }


}
