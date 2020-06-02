package com.qa.service;

import com.qa.domain.BookingInfo;
import com.qa.dto.BookingInfoDTO;
import com.qa.exceptions.BookingInfoNotFoundException;
import com.qa.repo.BookingInfoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingInfoService {

    private final BookingInfoRepository repo;

    private final ModelMapper mapper;

    @Autowired
    public BookingInfoService(BookingInfoRepository repo, ModelMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    private BookingInfoDTO mapToDTO(BookingInfo bookingInfo) { return this.mapper.map(bookingInfo, BookingInfoDTO.class);}

    public BookingInfoDTO createBookingInfo(BookingInfo bookingInfo) { return this.mapToDTO(this.repo.save(bookingInfo));}

    public List<BookingInfoDTO> readBookingInfos() {
        return this.repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public BookingInfoDTO getBookingInfoById(Long bookingInfoId) {
        return this.mapToDTO(this.repo.findById(bookingInfoId).orElseThrow(BookingInfoNotFoundException::new));
    }

    public BookingInfoDTO updateBookingInfo(Long bookingInfoId, BookingInfo bookingInfo) {
        BookingInfo update = this.repo.findById(bookingInfoId).orElseThrow(BookingInfoNotFoundException::new);
        update.setFirstName(bookingInfo.getFirstName());
        update.setSurname(bookingInfo.getSurname());
        update.setDateOfBirth(bookingInfo.getDateOfBirth());
        update.setEmail(bookingInfo.getEmail());
        update.setPhoneNumber(bookingInfo.getPhoneNumber());
        update.setAddress(bookingInfo.getAddress());
        update.setPostCode(bookingInfo.getPostCode());
        BookingInfo tempBookingInfo = this.repo.save(update);
        return this.mapToDTO(tempBookingInfo);
    }

    public boolean deleteBookingInfo(Long bookingInfoId){
        if(!this.repo.existsById(bookingInfoId)){
            throw new BookingInfoNotFoundException();
        }
        this.repo.deleteById(bookingInfoId);
        return this.repo.existsById(bookingInfoId);
    }
}
