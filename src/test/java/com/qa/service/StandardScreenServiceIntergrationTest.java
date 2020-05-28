package com.qa.service;

import com.qa.domain.StandardScreen;
import com.qa.dto.StandardScreenDTO;
import com.qa.repo.StandardScreensRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StandardScreenServiceIntergrationTest {

    @Autowired
    private StandardScreenService service;

    @Autowired
    private StandardScreensRepository repository;

    @Autowired
    private ModelMapper mapper;

    private StandardScreen testStandardScreen;

    private StandardScreen testStandardScreenWithId;

    private StandardScreenDTO mapToDTO(StandardScreen standardScreen) {
        return this.mapper.map(standardScreen, StandardScreenDTO.class);
    }

    @Before
    public void setUp() {
        this.testStandardScreen = new StandardScreen();
        this.repository.deleteAll();
        this.testStandardScreenWithId = this.repository.save(this.testStandardScreen);
    }

    @Test
    public void createStandardScreenTest() {
        assertEquals(this.mapToDTO(this.testStandardScreenWithId), this.service.createStandardScreen(testStandardScreen));
    }

    @Test
    public void getAllStandardScreensTest() {
        assertThat(this.service.readStandardScreens())
                .isEqualTo(
                        Stream.of(this.mapToDTO(testStandardScreenWithId)).collect(Collectors.toList())
                );
    }

    @Test
    public void getStandardScreenByIdTest() {
        assertThat(this.service.getStandardScreenById(this.testStandardScreenWithId.getStandardScreeningId())).isEqualTo(this.mapToDTO(this.testStandardScreenWithId));
    }

    @Test
    public void updateStandardScreenTest() {
        StandardScreen newStandardScreen = new StandardScreen();
        StandardScreen updateStandardScreen = new StandardScreen();
        updateStandardScreen.setStandardScreeningId(this.testStandardScreenWithId.getStandardScreeningId());
        assertThat(this.service.updateStandardScreen(this.testStandardScreenWithId.getStandardScreeningId(), newStandardScreen))
                .isEqualTo(this.mapToDTO(updateStandardScreen));
    }

    @Test
    public void deleteStandardScreenTest() {
        assertThat(this.service.deleteStandardScreen(this.testStandardScreenWithId.getStandardScreeningId())).isFalse();
    }

}
