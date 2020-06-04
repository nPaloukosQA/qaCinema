package com.qa.service;


import com.qa.domain.DeluxeScreen;
import com.qa.domain.Films;
import com.qa.domain.StandardScreen;
import com.qa.dto.FilmsDTO;
import com.qa.exceptions.FilmsNotFoundException;
import com.qa.repo.FilmsRepository;
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
public class FilmsServiceUnitTest {

    @InjectMocks
    private FilmsService service;

    @Mock
    private FilmsRepository repo;

    @Mock
    private ModelMapper mapper;

    private ModelMapper testMapper = new ModelMapper();

    private List<Films> filmsList;

    private Films testFilms;

    private Long testID = 1l;

    private Films testFilmsWithID;

    private FilmsDTO filmsDTO;

    private StandardScreen testSScreen;

    private DeluxeScreen testDscreen;

    private FilmsDTO mapToDTO(Films films) {
        return this.testMapper.map(films, FilmsDTO.class);
    }

    @Before
    public void setUpForTests() {
        this.filmsList = new ArrayList<>();
        this.testSScreen = new StandardScreen();
        this.testDscreen = new DeluxeScreen();
        List<StandardScreen> standardScreen = new ArrayList<>();
        standardScreen.add(testSScreen);
        List<DeluxeScreen> deluxeScreen = new ArrayList<>();
        deluxeScreen.add(testDscreen);
        this.testFilms = new Films("Title", "classification", true,
                "AAA", true, standardScreen, deluxeScreen);
        this.filmsList.add(testFilms);
        this.testFilmsWithID = new Films(testFilms.getFilmsTitle(), testFilms.getFilmsClassification(), testFilms.getFilmsIsFeature(),
                testFilms.getFilmsOMDBID(), testFilms.getFilmsCurrentlyReleased(), testFilms.getStandardScreen(), testFilms.getDeluxeScreen());
        this.testFilmsWithID.setFilmsID(testID);
        this.filmsDTO = this.mapToDTO(testFilmsWithID);
    }

    @Test
    public void getAllFilmsTest() {
        when(repo.findAll()).thenReturn(this.filmsList);
        when(this.mapper.map(testFilmsWithID, FilmsDTO.class)).thenReturn(filmsDTO);
        assertFalse("Service returned no films", this.service.readFilms().isEmpty());
        verify(repo, times(1)).findAll();
    }

    @Test
    public void createFilmsTest() {
        when(repo.save(testFilms)).thenReturn(testFilmsWithID);
        when(this.mapper.map(testFilmsWithID, FilmsDTO.class)).thenReturn(filmsDTO);
        assertEquals(this.service.createFilms(testFilms), this.filmsDTO);
        verify(repo, times(1)).save(this.testFilms);
    }

    @Test
    public void findFilmsByIDTest() {
        when(this.repo.findById(testID)).thenReturn(java.util.Optional.ofNullable(testFilmsWithID));
        when(this.mapper.map(testFilmsWithID, FilmsDTO.class)).thenReturn(filmsDTO);
        assertEquals(this.service.getFilmsById(this.testID), filmsDTO);
        verify(repo, times(1)).findById(testID);
    }

 
    @Test
    public void deleteUserByExistingID() {
        when(this.repo.existsById(testID)).thenReturn(true, false);
        assertFalse(service.deleteFilms(testID));
        verify(repo, times(1)).deleteById(testID);
        verify(repo, times(2)).existsById(testID);
    }

    @Test(expected = FilmsNotFoundException.class)
    public void deleteUserByNonExistingID() {
        when(this.repo.existsById(testID)).thenReturn(false);
        service.deleteFilms(testID);
        verify(repo, times(1)).existsById(testID);
    }

}
