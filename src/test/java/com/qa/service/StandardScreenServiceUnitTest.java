package com.qa.service;

import com.qa.domain.StandardScreen;
import com.qa.dto.StandardScreenDTO;
import com.qa.exceptions.StandardScreenNotFoundException;
import com.qa.repo.StandardScreensRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class StandardScreenServiceUnitTest {

    @InjectMocks
    private StandardScreenService service;

    @Mock
    private StandardScreensRepository repository;

    @Mock
    private ModelMapper mapper;

    private List<StandardScreen> standardScreenList;

    private StandardScreen testStandardScreen;

    private Long standardScreenId = 1L;

    private StandardScreen testStandardScreenWithId;

    private StandardScreenDTO standardScreenDTO;

    private StandardScreenDTO mapToDTO(StandardScreen standardScreen) { return this.mapper.map(standardScreen, StandardScreenDTO.class); }

    @Before
    public void setUp() {
        this.standardScreenList = new ArrayList<>();
        this.testStandardScreen = new StandardScreen();
        this.standardScreenList.add(testStandardScreen);
        this.testStandardScreenWithId = new StandardScreen();
        this.testStandardScreenWithId.setStandardScreeningId(standardScreenId);
        this.standardScreenDTO = this.mapToDTO(testStandardScreenWithId);
    }

    @Test
    public void createStandardScreenTest() {
        when(repository.save(testStandardScreen)).thenReturn(testStandardScreenWithId);
        when(this.mapper.map(testStandardScreenWithId, StandardScreenDTO.class)).thenReturn(standardScreenDTO);
        assertEquals(this.service.createStandardScreen(testStandardScreen), this.standardScreenDTO);
        verify(repository, times(1)).save(this.testStandardScreen);
    }

    @Test
    public void getAllStandardScreensTest() {
        when(repository.findAll()).thenReturn(this.standardScreenList);
        when(this.mapper.map(testStandardScreenWithId, StandardScreenDTO.class)).thenReturn(standardScreenDTO);
        assertFalse("service returned no Standard Screens", this.service.readStandardScreens().isEmpty());
        verify(repository, times(1)).findAll();
    }

    @Test
    public void getStandardScreenByIdTest() {
        when(this.repository.findById(standardScreenId)).thenReturn(java.util.Optional.ofNullable(testStandardScreenWithId));
        when(this.mapper.map(testStandardScreenWithId, StandardScreenDTO.class)).thenReturn(standardScreenDTO);
        assertEquals(this.service.getStandardScreenById(this.standardScreenId), standardScreenDTO);
        verify(repository, times(1)).findById(standardScreenId);
    }

    @Test
    public void updateStandardScreenTest() {
        StandardScreen newStandardScreen = new StandardScreen();
        StandardScreen updateStandardScreen = new StandardScreen();
        updateStandardScreen.setStandardScreeningId(standardScreenId);

        StandardScreenDTO updateStandardScreenDTO = new ModelMapper().map(updateStandardScreen, StandardScreenDTO.class);

        when(this.repository.findById(standardScreenId)).thenReturn(java.util.Optional.ofNullable(testStandardScreenWithId));
        when(this.repository.save(updateStandardScreen)).thenReturn(updateStandardScreen);
        when(this.mapper.map(updateStandardScreen, StandardScreenDTO.class)).thenReturn(updateStandardScreenDTO);
        assertEquals(updateStandardScreenDTO, this.service.updateStandardScreen(standardScreenId, newStandardScreen));
        verify(this.repository, times(1)).findById(standardScreenId);
        verify(this.repository, times(1)).save(updateStandardScreen);
    }

    @Test
    public void deleteStandardScreenByExistingIdTest() {
        when(this.repository.existsById(standardScreenId)).thenReturn(true, false);
        assertFalse(service.deleteStandardScreen(standardScreenId));
        verify(repository, times(1)).deleteById(standardScreenId);
        verify(repository, times(2)).existsById(standardScreenId);
    }

    @Test(expected = StandardScreenNotFoundException.class)
    public void deleteStandardScreenByNonExistingIdTest() {
        when(this.repository.existsById(standardScreenId)).thenReturn(false);
        service.deleteStandardScreen(standardScreenId);
        verify(repository, times(1)).existsById(standardScreenId);
    }

}
