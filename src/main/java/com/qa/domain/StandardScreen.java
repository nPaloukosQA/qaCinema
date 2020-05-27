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
    private Long standardScreenFilmId;
    private Long standardScreenBookingId;
    private Double standardScreenScreeningTime;
    private String standardScreenSeatsBooked;

    @OneToMany (mappedBy = "standardScreen", fetch = FetchType.LAZY)
    private List<BookingInfo> bookingInfo = new ArrayList<>();

    @ManyToOne (targetEntity = Films.class)
    private StandardScreen standardScreen;

    public StandardScreen() {

    }

    public StandardScreen(Long standardScreenFilmId, Long standardScreenBookingId, Double standardScreenScreeningTime, String standardScreenSeatsBooked) {
        this.standardScreenFilmId = standardScreenFilmId;
        this.standardScreenBookingId = standardScreenBookingId;
        this.standardScreenScreeningTime = standardScreenScreeningTime;
        this.standardScreenSeatsBooked = standardScreenSeatsBooked;
    }

    public StandardScreen(Long standardScreeningId, Long standardScreenFilmId, Long standardScreenBookingId, Double standardScreenScreeningTime, String standardScreenSeatsBooked) {
        this.standardScreeningId = standardScreeningId;
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

    public List<BookingInfo> getBookingInfo() {
        return bookingInfo;
    }

    public void setBookingInfo(List<BookingInfo> bookingInfo) {
        this.bookingInfo = bookingInfo;
    }

    public StandardScreen getStandardScreen() {
        return standardScreen;
    }

    public void setStandardScreen(StandardScreen standardScreen) {
        this.standardScreen = standardScreen;
    }

    @Override
    public String toString() {
        return "StandardScreen{" +
                "standardScreeningId=" + standardScreeningId +
                ", standardScreenFilmId=" + standardScreenFilmId +
                ", standardScreenBookingId=" + standardScreenBookingId +
                ", standardScreenScreeningTime=" + standardScreenScreeningTime +
                ", standardScreenSeatsBooked='" + standardScreenSeatsBooked + '\'' +
                ", bookingInfo=" + bookingInfo +
                ", standardScreen=" + standardScreen +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StandardScreen)) return false;
        StandardScreen that = (StandardScreen) o;
        return Objects.equals(getStandardScreeningId(), that.getStandardScreeningId()) &&
                Objects.equals(getStandardScreenFilmId(), that.getStandardScreenFilmId()) &&
                Objects.equals(getStandardScreenBookingId(), that.getStandardScreenBookingId()) &&
                Objects.equals(getStandardScreenScreeningTime(), that.getStandardScreenScreeningTime()) &&
                Objects.equals(getStandardScreenSeatsBooked(), that.getStandardScreenSeatsBooked()) &&
                Objects.equals(getBookingInfo(), that.getBookingInfo()) &&
                Objects.equals(getStandardScreen(), that.getStandardScreen());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStandardScreeningId(), getStandardScreenFilmId(), getStandardScreenBookingId(), getStandardScreenScreeningTime(), getStandardScreenSeatsBooked(), getBookingInfo(), getStandardScreen());
    }
}
