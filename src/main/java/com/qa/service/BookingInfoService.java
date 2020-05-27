package com.qa.service;

import com.qa.domain.BookingInfo;
import com.qa.dto.BookingInfoDTO;
import com.qa.repo.BookingInfoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
