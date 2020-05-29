package com.qa.dto;

import java.util.List;
import java.util.Objects;

public class DeluxeScreenDTO {

    private Long deluxeScreeningId;
    private Long deluxeFilmId;
    private Long deluxeBookingId;
    private Double deluxeScreeningTime;
    private String deluxeSeatsBooked;

    private List<BookingInfoDTO> bookings;

    public DeluxeScreenDTO(){

    }

    public DeluxeScreenDTO(Long deluxeFilmId, Long deluxeBookingId, Double deluxeScreeningTime, String deluxeSeatsBooked) {
        super();
        this.deluxeFilmId = deluxeFilmId;
        this.deluxeBookingId = deluxeBookingId;
        this.deluxeScreeningTime = deluxeScreeningTime;
        this.deluxeSeatsBooked = deluxeSeatsBooked;
    }

    public Long getDeluxeScreeningId() {
        return deluxeScreeningId;
    }

    public void setDeluxeScreeningId(Long deluxeScreeningId) {
        this.deluxeScreeningId = deluxeScreeningId;
    }

    public Long getDeluxeFilmId() {
        return deluxeFilmId;
    }

    public void setDeluxeFilmId(Long deluxeFilmId) {
        this.deluxeFilmId = deluxeFilmId;
    }

    public Long getDeluxeBookingId() {
        return deluxeBookingId;
    }

    public void setDeluxeBookingId(Long deluxeBookingId) {
        this.deluxeBookingId = deluxeBookingId;
    }

    public Double getDeluxeScreeningTime() {
        return deluxeScreeningTime;
    }

    public void setDeluxeScreeningTime(Double deluxeScreeningTime) {
        this.deluxeScreeningTime = deluxeScreeningTime;
    }

    public String getDeluxeSeatsBooked() {
        return deluxeSeatsBooked;
    }

    public void setDeluxeSeatsBooked(String deluxeSeatsBooked) {
        this.deluxeSeatsBooked = deluxeSeatsBooked;
    }

    public List<BookingInfoDTO> getBookings() {
        return bookings;
    }

    public void setBookings(List<BookingInfoDTO> bookings) {
        this.bookings = bookings;
    }

    @Override
    public String toString(){
        return "DeluxeScreenDTO{" +
                "deluxeScreeningId=" + deluxeScreeningId +
                ", deluxeFilmId=" + deluxeFilmId +
                ", deluxeBookingId=" + deluxeBookingId +
                ", deluxeScreeningTime=" + deluxeScreeningTime +
                ", deluxeSeatsBooked=" + deluxeSeatsBooked + '\'' +
                ", bookings=" + bookings +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeluxeScreenDTO that = (DeluxeScreenDTO) o;
        return Objects.equals(deluxeScreeningId, that.deluxeScreeningId) &&
                Objects.equals(deluxeFilmId, that.deluxeFilmId) &&
                Objects.equals(deluxeBookingId, that.deluxeBookingId) &&
                Objects.equals(deluxeScreeningTime, that.deluxeScreeningTime) &&
                Objects.equals(deluxeSeatsBooked, that.deluxeSeatsBooked) &&
                Objects.equals(bookings, that.bookings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deluxeScreeningId, deluxeFilmId, deluxeBookingId, deluxeScreeningTime, deluxeSeatsBooked, bookings);
    }
}
