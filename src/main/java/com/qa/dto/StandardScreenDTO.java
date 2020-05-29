package com.qa.dto;

import java.util.List;
import java.util.Objects;

public class StandardScreenDTO {

    private Long standardScreeningId;
    private Double standardScreenScreeningTime;
    private String standardScreenSeatsBooked;

    private List<BookingInfoDTO> bookings;

    public StandardScreenDTO() {

    }

    public StandardScreenDTO(Double standardScreenScreeningTime, String standardScreenSeatsBooked){
        super();
        this.standardScreenScreeningTime = standardScreenScreeningTime;
        this.standardScreenSeatsBooked = standardScreenSeatsBooked;
    }

    public Long getStandardScreeningId() {
        return standardScreeningId;
    }

    public void setStandardScreeningId(Long standardScreeningId) {
        this.standardScreeningId = standardScreeningId;
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

    @Override
    public String toString() {
        return "StandardScreenDTO{" +
                "standardScreeningId=" + standardScreeningId +
                ", standardScreenScreeningTime=" + standardScreenScreeningTime +
                ", standardScreenSeatsBooked='" + standardScreenSeatsBooked + '\'' +
                ", bookings=" + bookings +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StandardScreenDTO)) return false;
        StandardScreenDTO that = (StandardScreenDTO) o;
        return Objects.equals(getStandardScreeningId(), that.getStandardScreeningId()) &&
                Objects.equals(getStandardScreenScreeningTime(), that.getStandardScreenScreeningTime()) &&
                Objects.equals(getStandardScreenSeatsBooked(), that.getStandardScreenSeatsBooked()) &&
                Objects.equals(getBookings(), that.getBookings());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStandardScreeningId(), getStandardScreenScreeningTime(), getStandardScreenSeatsBooked(), getBookings());
    }
}
