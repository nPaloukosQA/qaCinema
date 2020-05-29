package com.qa.rest;

import com.qa.domain.BookingInfo;
import com.qa.dto.BookingInfoDTO;
import com.qa.service.BookingInfoService;
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
public class BookingInfoControllerUnitTest {

    @InjectMocks
    private BookingInfoController bookingInfoController;

    @Mock
    private BookingInfoService service;

    private List<BookingInfo> bookingInfo;

    private BookingInfo testBookingInfo;

    private BookingInfo testBookingInfoWithId;

    private Long bookingInfoId = 1L;

    private BookingInfoDTO bookingInfoDTO;

    private final ModelMapper mapper = new ModelMapper();

    private BookingInfoDTO mapToDTO(BookingInfo bookingInfo) { return this.mapper.map(bookingInfo, BookingInfoDTO.class); }

    @Before
    public void setUp() {
        this.bookingInfo = new ArrayList<>();
        this.testBookingInfo = new BookingInfo();
        this.bookingInfo.add(testBookingInfo);
        this.testBookingInfoWithId = new BookingInfo();
        this.testBookingInfoWithId.setBookingInfoId(this.bookingInfoId);
        this.bookingInfoDTO = this.mapToDTO(testBookingInfoWithId);
    }

    @Test
    public void createBookingInfoTest() {
        when(this.service.createBookingInfo(testBookingInfo)).thenReturn(this.bookingInfoDTO);
        assertEquals(this.bookingInfoController.createBookingInfo(testBookingInfo), new ResponseEntity<BookingInfoDTO>(this.bookingInfoDTO, HttpStatus.CREATED));
        verify(this.service, times(1)).createBookingInfo(testBookingInfo);
    }

    @Test
    public void getAllBookingInfosTest() {
        when(service.readBookingInfos()).thenReturn(this.bookingInfo.stream().map(this::mapToDTO).collect(Collectors.toList()));
        assertFalse("No Booking Infos found", this.bookingInfoController.getAllBookingInfos().getBody().isEmpty());
        verify(service, times(1)).readBookingInfos();
    }

    @Test
    public void getBookingInfoByIdTest() {
        when(this.service.getBookingInfoById(bookingInfoId)).thenReturn(this.bookingInfoDTO);
        assertEquals(this.bookingInfoController.getBookingInfoById(bookingInfoId), new ResponseEntity<BookingInfoDTO>(this.bookingInfoDTO, HttpStatus.OK));
        verify(service, times(1)).getBookingInfoById(bookingInfoId);
    }

//    @Test
//    public void  updateBookingInfoTest() {
//        BookingInfo newBookingInfo = new BookingInfo();
//        BookingInfo updateBookingInfo = new BookingInfo();
//        updateBookingInfo.setBookingInfoId(bookingInfoId);
//
//        BookingInfoDTO updateBookingInfoDTO = new ModelMapper().map(updateBookingInfo, BookingInfoDTO.class);
//
//        when(this.service.getBookingInfoById(bookingInfoId)).thenReturn(java.util.Optional.ofNullable(testBookingInfoWithId));
//        when(this.service.(updateBookingInfo)).thenReturn(updateBookingInfo);
//        when(this.mapper.map(updateBookingInfo, BookingInfoDTO.class)).thenReturn(updateBookingInfoDTO);
//
//        assertEquals(updateBookingInfo, this.service.updateBookingInfo(bookingInfoId, newBookingInfo));
//        verify(this.service, times(1)).getBookingInfoById(bookingInfoId);
//        verify(this.service, times(1)).save(updateBookingInfo);
//    }

    @Test
    public void deleteBookingInfoTestTrue() {
        when(service.deleteBookingInfo(2L)).thenReturn(true);
        this.bookingInfoController.deleteBookingInfo(2L);
        verify(service, times(1)).deleteBookingInfo(2L);
    }

    @Test
    public void deleteBookingInfoTestFalse() {
        this.bookingInfoController.deleteBookingInfo(bookingInfoId);
        verify(service, times(1)).deleteBookingInfo(bookingInfoId);
    }

}