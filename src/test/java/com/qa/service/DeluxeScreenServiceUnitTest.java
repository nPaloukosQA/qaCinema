package com.qa.service;

import com.qa.domain.DeluxeScreen;
import com.qa.dto.DeluxeScreenDTO;
import com.qa.exceptions.DeluxeScreenNotFoundException;
import com.qa.repo.DeluxeScreenRepository;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class DeluxeScreenServiceUnitTest {

    @InjectMocks
    private DeluxeScreenService service;

    @Mock
    private DeluxeScreenRepository repository;

    @Mock
    private ModelMapper mapper;

    private List<DeluxeScreen> deluxeScreenList;

    private DeluxeScreen testDeluxeScreen;

    private Long deluxeScreenId = 1L;

    private DeluxeScreen testDeluxeScreenWithId;

    private DeluxeScreenDTO deluxeScreenDTO;

    private DeluxeScreenDTO mapToDTO(DeluxeScreen deluxeScreen) {
        return this.mapper.map(deluxeScreen, DeluxeScreenDTO.class);
    }

    @Before
    public void setUp() {
        this.deluxeScreenList = new ArrayList<>();
        this.testDeluxeScreen = new DeluxeScreen();
        this.deluxeScreenList.add(testDeluxeScreen);
        this.testDeluxeScreenWithId = new DeluxeScreen();
        this.testDeluxeScreenWithId.setDeluxeScreeningId(deluxeScreenId);
        this.deluxeScreenDTO = this.mapToDTO(testDeluxeScreenWithId);
    }


    @Test
    public void createDeluxeScreenTest() {
        when(repository.save(testDeluxeScreen)).thenReturn(testDeluxeScreenWithId);
        when(this.mapper.map(testDeluxeScreenWithId, DeluxeScreenDTO.class)).thenReturn(deluxeScreenDTO);
        assertTrue("This service returned no Deluxe Screens", this.service.readDeluxeScreens().isEmpty());
        verify(repository, times(1)).findAll();
    }

    @Test
    public void getAllDeluxeScreensTest() {
        when(repository.findAll()).thenReturn(this.deluxeScreenList);
        when(this.mapper.map(testDeluxeScreenWithId, DeluxeScreenDTO.class)).thenReturn(deluxeScreenDTO);
        assertFalse("This service returned no Deluxe Screens", this.service.readDeluxeScreens().isEmpty());
        verify(repository, times(1)).findAll();
    }

    @Test
    public void getDeluxeScreenByIdTest() {
        when(this.repository.findById(deluxeScreenId)).thenReturn(java.util.Optional.ofNullable(testDeluxeScreenWithId));
        when(this.mapper.map(testDeluxeScreenWithId, DeluxeScreenDTO.class)).thenReturn(deluxeScreenDTO);
        assertEquals(this.service.getDeluxeScreenById(this.deluxeScreenId), deluxeScreenDTO);
        verify(repository, times(1)).findById(deluxeScreenId);
    }

    @Test
    public void updateDeluxeScreenTest() {
        DeluxeScreen newDeluxeScreen = new DeluxeScreen();
        DeluxeScreen updateDeluxeScreen = new DeluxeScreen();
        updateDeluxeScreen.setDeluxeScreeningId(deluxeScreenId);
        DeluxeScreenDTO updateDeluxeScreenDTO = new ModelMapper().map(updateDeluxeScreen, DeluxeScreenDTO.class);

        when(this.repository.findById(deluxeScreenId)).thenReturn(java.util.Optional.ofNullable(testDeluxeScreenWithId));
        when(this.repository.save(updateDeluxeScreen)).thenReturn(updateDeluxeScreen);
        when(this.mapper.map(updateDeluxeScreen, DeluxeScreenDTO.class)).thenReturn(updateDeluxeScreenDTO);
        assertEquals(updateDeluxeScreenDTO, this.service.updateDeluxeScreen(deluxeScreenId, newDeluxeScreen));
        verify(this.repository, times(1)).findById(deluxeScreenId);
        verify(this.repository, times(1)).save(updateDeluxeScreen);
    }

    @Test
    public void deleteDeluxeScreenByExistingIdTest() {
        when(this.repository.existsById(deluxeScreenId)).thenReturn(true, false);
        assertFalse(service.deleteDeluxeScreen(deluxeScreenId));
        verify(repository, times(1)).deleteById(deluxeScreenId);
        verify(repository, times(2)).existsById(deluxeScreenId);
    }

    @Test(expected = DeluxeScreenNotFoundException.class)
    public void deleteDeluxeScreenByNonExistingIdTest() {
        when(this.repository.existsById(deluxeScreenId)).thenReturn(false);
        service.deleteDeluxeScreen(deluxeScreenId);
        verify(repository, times(1)).existsById(deluxeScreenId);
    }

}
