package com.qa.service;

import com.qa.domain.BookingInfo;
import com.qa.dto.BookingInfoDTO;
import com.qa.exceptions.BookingInfoNotFoundException;
import com.qa.repo.BookingInfoRepository;
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
public class BookingInfoServiceUnitTest {

    @InjectMocks
    private BookingInfoService service;

    @Mock
    private BookingInfoRepository repository;

    @Mock
    private ModelMapper mapper;

    private List<BookingInfo> bookingInfoList;

    private BookingInfo testBookingInfo;

    private Long bookingInfoId = 1L;

    private BookingInfo testBookingInfoWithId;

    private BookingInfoDTO bookingInfoDTO;

    private BookingInfoDTO mapToDTO(BookingInfo bookingInfo) { return this.mapper.map(bookingInfo, BookingInfoDTO.class); }

    @Before
    public void setUp() {
        this.bookingInfoList = new ArrayList<>();
        this.testBookingInfo = new BookingInfo();
        this.bookingInfoList.add(testBookingInfo);
        this.testBookingInfoWithId = new BookingInfo();
        this.testBookingInfoWithId.setBookingInfoId(bookingInfoId);
        this.bookingInfoDTO = this.mapToDTO(testBookingInfoWithId);
    }

    @Test
    public void createBookingInfoTest() {
        when(repository.save(testBookingInfo)).thenReturn(testBookingInfoWithId);
        when(this.mapper.map(testBookingInfoWithId, BookingInfoDTO.class)).thenReturn(bookingInfoDTO);
        assertEquals(this.service.createBookingInfo(testBookingInfo), this.bookingInfoDTO);
        verify(repository, times(1)).save(this.testBookingInfo);
    }

   @Test
   public void getAllBookingInfoTest() {
        when(repository.findAll()).thenReturn(this.bookingInfoList);
        when(this.mapper.map(testBookingInfoWithId, BookingInfoDTO.class)).thenReturn(bookingInfoDTO);
        assertFalse("service returned no Booking Info", this.service.readBookingInfos().isEmpty());
        verify(repository, times(1)).findAll();
   }

    @Test
    public void getBookingInfoById() {
        when(this.repository.findById(bookingInfoId)).thenReturn(java.util.Optional.ofNullable(testBookingInfoWithId));
        when(this.mapper.map(testBookingInfoWithId, BookingInfoDTO.class)).thenReturn(bookingInfoDTO);
        assertEquals(this.service.getBookingInfoById(this.bookingInfoId), bookingInfoDTO);
        verify(repository, times(1)).findById(bookingInfoId);
    }

    @Test
    public void updateBookingInfo() {
        BookingInfo newBookingInfo = new BookingInfo();
        BookingInfo updateBookingInfo = new BookingInfo();
        updateBookingInfo.setBookingInfoId(bookingInfoId);

        BookingInfoDTO updateBookingInfoDTO = new ModelMapper().map(updateBookingInfo, BookingInfoDTO.class);

        when(this.repository.findById(bookingInfoId)).thenReturn(java.util.Optional.ofNullable(testBookingInfoWithId));
        when(this.repository.save(updateBookingInfo)).thenReturn(updateBookingInfo);
        when(this.mapper.map(updateBookingInfo, BookingInfoDTO.class)).thenReturn(updateBookingInfoDTO);
        assertEquals(updateBookingInfoDTO, this.service.updateBookingInfo(bookingInfoId, newBookingInfo));
        verify(this.repository, times(1)).findById(bookingInfoId);
        verify(this.repository, times(1)).save(updateBookingInfo);
    }

    @Test
    public void deleteBookingInfoByExistingIdTest() {
        when(this.repository.existsById(bookingInfoId)).thenReturn(true, false);
        assertFalse(service.deleteBookingInfo(bookingInfoId));
        verify(repository, times(1)).deleteById(bookingInfoId);
        verify(repository, times(2)).existsById(bookingInfoId);
    }

    @Test(expected = BookingInfoNotFoundException.class)
    public void deleteBookingInfoByNonExistingIdTest() {
        when(this.repository.existsById(bookingInfoId)).thenReturn(false);
        service.deleteBookingInfo(bookingInfoId);
        verify(repository, times(1)).existsById(bookingInfoId);
    }

}