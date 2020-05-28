package com.qa.rest;

import com.qa.domain.BookingInfo;
import com.qa.dto.BookingInfoDTO;
import com.qa.service.BookingInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookingInfoController {

    private final BookingInfoService service;

    @Autowired
    public BookingInfoController(BookingInfoService service) {
        this.service = service;
    }

    @PostMapping("/createBookingInfo")
    public ResponseEntity<BookingInfoDTO> createBookingInfo(@RequestBody BookingInfo bookingInfo) {
        return new ResponseEntity<BookingInfoDTO>(this.service.createBookingInfo(bookingInfo), HttpStatus.CREATED);
    }

    @GetMapping("/getAllBookingInfos")
    public ResponseEntity<List<BookingInfoDTO>> getAllBookingInfos() {
        return ResponseEntity.ok(this.service.readBookingInfos());
    }

    @GetMapping("/getBookingInfoById/{bookingInfoId}")
    public ResponseEntity<BookingInfoDTO> getBookingInfoById(@PathVariable Long bookingInfoId) {
        return ResponseEntity.ok(this.service.getBookingInfoById(bookingInfoId));
    }

    @PutMapping("/updateBookingInfo/{bookingInfoId}")
    public ResponseEntity<BookingInfoDTO> updateBookingInfo(@PathVariable Long bookingInfoId, @RequestBody BookingInfo bookingInfo){
        return ResponseEntity.ok(this.service.updateBookingInfo(bookingInfoId, bookingInfo));
    }

    @DeleteMapping("/deleteBookingInfo/{bookingInfoId}")
    public ResponseEntity<?> deleteBookingInfo(@PathVariable Long bookingInfoId){
        return this.service.deleteBookingInfo(bookingInfoId)
                ? ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()
                : ResponseEntity.ok(this.service.getBookingInfoById(bookingInfoId));
    }
}