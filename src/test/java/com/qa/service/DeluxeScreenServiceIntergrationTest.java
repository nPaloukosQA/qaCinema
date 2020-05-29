package com.qa.service;

import com.qa.domain.DeluxeScreen;
import com.qa.dto.DeluxeScreenDTO;
import com.qa.repo.DeluxeScreenRepository;
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
public class DeluxeScreenServiceIntergrationTest {

    @Autowired
    private DeluxeScreenService service;

    @Autowired
    private DeluxeScreenRepository repository;

    @Autowired
    private ModelMapper mapper;

    private DeluxeScreen testDeluxeScreen;

    private DeluxeScreen testDeluxeScreenWithId;

    private DeluxeScreenDTO mapToDTO(DeluxeScreen deluxeScreen) {
        return this.mapper.map(deluxeScreen, DeluxeScreenDTO.class);
    }

    @Before
    public void setUp() {
        this.testDeluxeScreen = new DeluxeScreen();
        this.repository.deleteAll();
        this.testDeluxeScreenWithId = this.repository.save(this.testDeluxeScreen);
    }

    @Test
    public void createDeluxeScreenTest() {
        assertEquals(this.mapToDTO(this.testDeluxeScreenWithId), this.service.createDeluxeScreen(testDeluxeScreen));
    }

    @Test
    public void getAllDeluxeScreensTest() {
        assertThat(this.service.readDeluxeScreens())
        .isEqualTo(
                Stream.of(this.mapToDTO(testDeluxeScreenWithId)).collect(Collectors.toList())
        );
    }

    @Test
    public void getDeluxeScreensByIdTest() {
        assertThat(this.service.getDeluxeScreenById(this.testDeluxeScreenWithId.getDeluxeScreeningId())).isEqualTo(this.mapToDTO(this.testDeluxeScreenWithId));
    }

    @Test
    public void updateDeluxeScreenTest() {
        DeluxeScreen newDeluxeScreen = new DeluxeScreen();
        DeluxeScreen updateDeluxeScreen = new DeluxeScreen();
        updateDeluxeScreen.setDeluxeScreeningId(this.testDeluxeScreenWithId.getDeluxeScreeningId());
        assertThat(this.service.updateDeluxeScreen(this.testDeluxeScreenWithId.getDeluxeScreeningId(), newDeluxeScreen))
                .isEqualTo(this.mapToDTO(updateDeluxeScreen));
    }

    @Test
    public void deleteStandardScreenTest() {
        assertThat(this.service.deleteDeluxeScreen(this.testDeluxeScreenWithId.getDeluxeScreeningId())).isFalse();
    }

}
