package com.qa.dto;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class DeluxeScreenDTO {

    private Long deluxeScreeningId;
    private Double deluxeScreeningTime;
    private String deluxeSeatsBooked;
    private Date deluxeScreenDate;

    private List<BookingInfoDTO> bookings;

    public DeluxeScreenDTO(){

    }

    public DeluxeScreenDTO(Double deluxeScreeningTime, String deluxeSeatsBooked, Date deluxeScreenDate) {
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
        if (o == null || getClass() != o.getClass()) return false;
        DeluxeScreenDTO that = (DeluxeScreenDTO) o;
        return Objects.equals(deluxeScreeningId, that.deluxeScreeningId) &&
                Objects.equals(deluxeScreeningTime, that.deluxeScreeningTime) &&
                Objects.equals(deluxeSeatsBooked, that.deluxeSeatsBooked) &&
                Objects.equals(deluxeScreenDate, that.deluxeScreenDate) &&
                Objects.equals(bookings, that.bookings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deluxeScreeningId, deluxeScreeningTime, deluxeSeatsBooked, deluxeScreenDate, bookings);
    }
}
