package com.qa.service;


import com.qa.domain.DeluxeScreen;
import com.qa.domain.Films;
import com.qa.domain.StandardScreen;
import com.qa.dto.DeluxeScreenDTO;
import com.qa.dto.FilmsDTO;
import com.qa.dto.StandardScreenDTO;
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
import java.util.Optional;
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

    private List<StandardScreen> standardScreen;

    private List<DeluxeScreen> deluxeScreen;

    private StandardScreenDTO testStandardScreenDTO;

    private DeluxeScreenDTO testDeluxeScreenDTO;

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
        this.testStandardScreenDTO = new StandardScreenDTO();
        this.testDeluxeScreenDTO = new DeluxeScreenDTO();
        this.standardScreen = new ArrayList<>();
        this.standardScreen.add(testSScreen);
        this.deluxeScreen = new ArrayList<>();
        this.deluxeScreen.add(testDscreen);
        this.testFilms = new Films("Title", "classification", true,
                "AAA", standardScreen, deluxeScreen);
        this.filmsList.add(testFilms);
        this.testFilmsWithID = new Films(testFilms.getFilmsTitle(), testFilms.getFilmsClassification(), testFilms.getFilmsIsFeature(),
                testFilms.getFilmsOMDBID(), testFilms.getStandardScreen(), testFilms.getDeluxeScreen());
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
    public void getFilmsStandardScreeningsTest() {
        when(this.repo.findById(testID)).thenReturn(java.util.Optional.ofNullable(testFilmsWithID));
        when(this.mapper.map(testFilmsWithID, FilmsDTO.class)).thenReturn(filmsDTO);
        assertEquals(this.service.getFilmsStandardScreenings(this.testID), filmsDTO.getStandardScreen());
        verify(repo, times(1)).findById(testID);
    }

    @Test
    public void getFilmsDeluxeScreeningsTest() {
        when(this.repo.findById(testID)).thenReturn(java.util.Optional.ofNullable(testFilmsWithID));
        when(this.mapper.map(testFilmsWithID, FilmsDTO.class)).thenReturn(filmsDTO);
        assertEquals(this.service.getFilmsDeluxeScreenings(this.testID), filmsDTO.getDeluxeScreen());
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

/*    @Test
    public void updateFilmsTest() {
        Films newFilms = new Films("NewTitle", "Newclassification", true,
                "BBB", standardScreen, deluxeScreen);
        Films updateFilms = new Films(newFilms.getFilmsTitle(), newFilms.getFilmsClassification(), newFilms.getFilmsIsFeature(),
                newFilms.getFilmsOMDBID(), newFilms.getStandardScreen(), newFilms.getDeluxeScreen());
        updateFilms.setFilmsID(testID);

        FilmsDTO updateFilmsDTO = new ModelMapper().map(updateFilms, FilmsDTO.class);

        when(this.repo.findById(testID)).thenReturn(java.util.Optional.ofNullable(testFilmsWithID));
        when(this.repo.save(updateFilms)).thenReturn(updateFilms);
        when(this.mapper.map(updateFilms, FilmsDTO.class)).thenReturn(updateFilmsDTO);

        assertEquals(updateFilmsDTO, this.service.updateFilms(testID, newFilms));
        verify(this.repo, times(1)).findById(testID);
        verify(this.repo, times(1)).save(updateFilms);
    }*/


}
