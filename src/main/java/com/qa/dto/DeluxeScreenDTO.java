package com.qa.dto;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class DeluxeScreenDTO {

    private Long deluxeScreeningId;
    private Double deluxeScreeningTime;
    private String deluxeSeatsBooked;
    private LocalDate deluxeScreenDate;

    private List<BookingInfoDTO> bookings;

    public DeluxeScreenDTO(){

    }

    public DeluxeScreenDTO(Double deluxeScreeningTime, String deluxeSeatsBooked, LocalDate deluxeScreenDate) {
        super();
        this.deluxeScreeningTime = deluxeScreeningTime;
        this.deluxeSeatsBooked = deluxeSeatsBooked;
        this.deluxeScreenDate = deluxeScreenDate;
    }

    public Long getDeluxeScreeningId() {
        return deluxeScreeningId;
    }

    public void setDeluxeScreeningId(Long deluxeScreeningId) {
        this.deluxeScreeningId = deluxeScreeningId;
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

    public LocalDate getDeluxeScreenDate() {
        return deluxeScreenDate;
    }

    public void setDeluxeScreenDate(LocalDate deluxeScreenDate) {
        this.deluxeScreenDate = deluxeScreenDate;
    }

    public List<BookingInfoDTO> getBookings() {
        return bookings;
    }

    public void setBookings(List<BookingInfoDTO> bookings) {
        this.bookings = bookings;
    }

    @Override
    public String toString() {
        return "DeluxeScreenDTO{" +
                "deluxeScreeningId=" + deluxeScreeningId +
                ", deluxeScreeningTime=" + deluxeScreeningTime +
                ", deluxeSeatsBooked='" + deluxeSeatsBooked + '\'' +
                ", deluxeScreenDate=" + deluxeScreenDate +
                ", bookings=" + bookings +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DeluxeScreenDTO)) return false;
        DeluxeScreenDTO that = (DeluxeScreenDTO) o;
        return Objects.equals(getDeluxeScreeningId(), that.getDeluxeScreeningId()) &&
                Objects.equals(getDeluxeScreeningTime(), that.getDeluxeScreeningTime()) &&
                Objects.equals(getDeluxeSeatsBooked(), that.getDeluxeSeatsBooked()) &&
                Objects.equals(getDeluxeScreenDate(), that.getDeluxeScreenDate()) &&
                Objects.equals(getBookings(), that.getBookings());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDeluxeScreeningId(), getDeluxeScreeningTime(), getDeluxeSeatsBooked(), getDeluxeScreenDate(), getBookings());
    }
}
