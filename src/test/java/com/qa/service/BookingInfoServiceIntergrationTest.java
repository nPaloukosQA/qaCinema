package com.qa.service;

import com.qa.domain.BookingInfo;
import com.qa.dto.BookingInfoDTO;
import com.qa.repo.BookingInfoRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.awt.print.Book;
import java.security.cert.CollectionCertStoreParameters;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookingInfoServiceIntergrationTest {

    @Autowired
    private BookingInfoService service;

    @Autowired
    private BookingInfoRepository repository;

    @Autowired
    private ModelMapper mapper;

    private BookingInfo testBookingInfo;

    private BookingInfo testBookingInfoWithId;

    private BookingInfoDTO mapToDTO(BookingInfo bookingInfo) {
        return this.mapper.map(bookingInfo, BookingInfoDTO.class);
    }

    @Before
    public void setUp() {
        this.testBookingInfo = new BookingInfo();
        this.repository.deleteAll();
        this.testBookingInfoWithId = this.repository.save(this.testBookingInfo);
    }

    @Test
    public void createBookingInfoTest() {
        assertEquals(this.mapToDTO(this.testBookingInfoWithId), this.service.createBookingInfo(testBookingInfo));
    }

    @Test
    public void getAllBookingInfoTest() {
        assertThat(this.service.readBookingInfos())
        .isEqualTo(
                Stream.of(this.mapToDTO(testBookingInfoWithId)).collect(Collectors.toList())
        );
    }

    @Test
    public void getBookingInfoByIdTest() {
        assertThat(this.service.getBookingInfoById(this.testBookingInfoWithId.getBookingInfoId())).isEqualTo((this.mapToDTO(this.testBookingInfoWithId)));
    }

    @Test
    public void updateBookingInfoTest() {
        BookingInfo newBookingInfo = new BookingInfo();
        BookingInfo updateBookingInfo = new BookingInfo();
        updateBookingInfo.setBookingInfoId(this.testBookingInfoWithId.getBookingInfoId());
        assertThat(this.service.updateBookingInfo(this.testBookingInfoWithId.getBookingInfoId(), newBookingInfo))
                .isEqualTo(this.mapToDTO(updateBookingInfo));
    }

    @Test
    public void deleteBookingInfoTest() {
        assertThat(this.service.deleteBookingInfo(this.testBookingInfoWithId.getBookingInfoId())).isFalse();
    }

}