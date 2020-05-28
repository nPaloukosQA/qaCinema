package com.qa.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.domain.BookingInfo;
import com.qa.dto.BookingInfoDTO;
import com.qa.repo.BookingInfoRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BookingInfoControllerIntergrationTest {

    @Autowired
    private MockMvc mock;

    @Autowired
    private BookingInfoRepository repository;

    @Autowired
    private ModelMapper mapper;

    private ObjectMapper objectMapper = new ObjectMapper();

    private BookingInfo testBookingInfo;

    private BookingInfo testBookingInfoWithId;

    private Long bookingInfoId;

    private BookingInfoDTO bookingInfoDTO;

    private BookingInfoDTO mapToDTO(BookingInfo bookingInfo) { return this.mapper.map(bookingInfo, BookingInfoDTO.class); }

    @Before
    public void setUp() {
        this.repository.deleteAll();
        this.testBookingInfo = new BookingInfo();
        this.testBookingInfoWithId = this.repository.save(testBookingInfo);
        this.bookingInfoId = testBookingInfoWithId.getBookingInfoId();
        this.bookingInfoDTO = this.mapToDTO(testBookingInfoWithId);
    }

    @Test
    public void createBookingInfoTest() throws Exception {
        String result = this.mock.perform(
                request(HttpMethod.POST, "/createBookingInfo")
                .contentType(MediaType.APPLICATION_JSON)
                .content(this.objectMapper.writeValueAsString(testBookingInfo))
                .accept(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isCreated())
                .andReturn()
                .getResponse()
                .getContentAsString();
        assertEquals(result, this.objectMapper.writeValueAsString(bookingInfoDTO));
    }

    @Test
    public void getAllBookingInfosTest() throws Exception{
        List<BookingInfoDTO> bookingInfoDTOList = new ArrayList<>();
        bookingInfoDTOList.add(bookingInfoDTO);
        String content = this.mock.perform(
                request(HttpMethod.GET, "/getAllBookingInfos")
                    .accept(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();
        assertEquals(content, this.objectMapper.writeValueAsString(bookingInfoDTOList));
    }

    @Test
    public void getBookingInfoByIdTest() throws Exception {
        String content = this.mock.perform(
                request(HttpMethod.GET, "/getBookingInfoById/" + this.bookingInfoId)
                .accept(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();
        assertEquals(content, this.objectMapper.writeValueAsString(bookingInfoDTO));
    }

//    @Test
//    public void updateBookingInfoTest() throws Exception {
//        String content = this.mock.perform(
//                request(HttpMethod.PUT, "/updateBookingInfo/" + this.bookingInfoId)
//                .accept(MediaType.APPLICATION_JSON)
//        )
//                .andExpect(status().isOk())
//                .andReturn()
//                .getResponse()
//                .getContentAsString();
//        assertEquals(content, this.objectMapper.writeValueAsString(bookingInfoDTO));
//    }

    @Test
    public void  deleteBookingInfoTest() throws  Exception {
        this.mock.perform(
                request(HttpMethod.DELETE, "/deleteBookingInfo/" + this.bookingInfoId)
        ).andExpect(status().isNoContent());
    }

}
