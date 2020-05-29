package com.qa.domain;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class StandardScreen {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long standardScreeningId;
    private Double standardScreenScreeningTime;
    private String standardScreenSeatsBooked;

    @OneToMany (mappedBy = "standardScreen", fetch = FetchType.LAZY)
    private List<BookingInfo> bookingInfo = new ArrayList<>();

    @ManyToOne (targetEntity = Films.class)
    private Films films;

    public StandardScreen() {

    }

    public StandardScreen(Double standardScreenScreeningTime, String standardScreenSeatsBooked) {
        this.standardScreenScreeningTime = standardScreenScreeningTime;
        this.standardScreenSeatsBooked = standardScreenSeatsBooked;
    }

    public StandardScreen(Long standardScreeningId, Double standardScreenScreeningTime, String standardScreenSeatsBooked) {
        this.standardScreeningId = standardScreeningId;
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

    public List<BookingInfo> getBookingInfo() {
        return bookingInfo;
    }

    public void setBookingInfo(List<BookingInfo> bookingInfo) {
        this.bookingInfo = bookingInfo;
    }

    public Films getFilms() {
        return films;
    }

    public void setFilms(Films films) {
        this.films = films;
    }

    @Override
    public String toString() {
        return "StandardScreen{" +
                "standardScreeningId=" + standardScreeningId +
                ", standardScreenScreeningTime=" + standardScreenScreeningTime +
                ", standardScreenSeatsBooked='" + standardScreenSeatsBooked + '\'' +
                ", bookingInfo=" + bookingInfo +
                ", films=" + films +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StandardScreen)) return false;
        StandardScreen that = (StandardScreen) o;
        return Objects.equals(getStandardScreeningId(), that.getStandardScreeningId()) &&
                Objects.equals(getStandardScreenScreeningTime(), that.getStandardScreenScreeningTime()) &&
                Objects.equals(getStandardScreenSeatsBooked(), that.getStandardScreenSeatsBooked()) &&
                Objects.equals(getBookingInfo(), that.getBookingInfo()) &&
                Objects.equals(getFilms(), that.getFilms());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStandardScreeningId(), getStandardScreenScreeningTime(), getStandardScreenSeatsBooked(), getBookingInfo(), getFilms());
    }
}
