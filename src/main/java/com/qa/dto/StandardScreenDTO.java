package com.qa.dto;

import java.util.List;

public class StandardScreenDTO {

    private Long standardScreeningId;
    private Long standardScreenFilmId;
    private Long standardScreenBookingId;
    private Double standardScreenScreeningTime;
    private String standardScreenSeatsBooked;

    private List<BookingInfoDTO> bookings;

    public StandardScreenDTO() {

    }

    public StandardScreenDTO(Long standardScreenFilmId, Long standardScreenBookingId, Double standardScreenScreeningTime, String standardScreenSeatsBooked){
        super();
        this.standardScreenFilmId = standardScreenFilmId;
        this.standardScreenBookingId = standardScreenBookingId;
        this.standardScreenScreeningTime = standardScreenScreeningTime;
        this.standardScreenSeatsBooked = standardScreenSeatsBooked;
    }

    public Long getStandardScreeningId() {
        return standardScreeningId;
    }

    public void setStandardScreeningId(Long standardScreeningId) {
        this.standardScreeningId = standardScreeningId;
    }

    public Long getStandardScreenFilmId() {
        return standardScreenFilmId;
    }

    public void setStandardScreenFilmId(Long standardScreenFilmId) {
        this.standardScreenFilmId = standardScreenFilmId;
    }

    public Long getStandardScreenBookingId() {
        return standardScreenBookingId;
    }

    public void setStandardScreenBookingId(Long standardScreenBookingId) {
        this.standardScreenBookingId = standardScreenBookingId;
    }

    public Double getStandardScreenScreeningTime() {
        return standardScreenScreeningTime;
    }

    public void setStandardScreenScreeningTime(Double standardScreenScreeningTime) {
        this.standardScreenScreeningTime = standardScreenScreeningTime;
    }

    public String getStandardScreenSeatsBooked() {
        return standardScreenSeatsBooked;
    }

    public void setStandardScreenSeatsBooked(String standardScreenSeatsBooked) {
        this.standardScreenSeatsBooked = standardScreenSeatsBooked;
    }

    public List<BookingInfoDTO> getBookings() {
        return bookings;
    }

    public void setBookings(List<BookingInfoDTO> bookings) {
        this.bookings = bookings;
    }
}
