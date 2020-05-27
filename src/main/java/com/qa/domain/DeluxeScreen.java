package com.qa.domain;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
public class DeluxeScreen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long deluxeScreeningId;
    private Long deluxeFilmId;
    private Long deluxeBookingId;
    private Double deluxeScreeningTime;
    private String deluxeSeatsBooked;

    @OneToMany (mappedBy = "deluxeScreen", fetch = FetchType.LAZY)
    private List<BookingInfo> bookingInfo = new ArrayList<>();

    @ManyToOne(targetEntity = Films.class)
    private DeluxeScreen deluxeScreen;

    public DeluxeScreen(){
    }

    public DeluxeScreen(Long deluxeFilmId, Long deluxeBookingId, Double deluxeScreeningTime, String deluxeSeatsBooked){
        this.deluxeFilmId = deluxeFilmId;
        this.deluxeBookingId = deluxeBookingId;
        this.deluxeScreeningTime = deluxeScreeningTime;
        this.deluxeSeatsBooked = deluxeSeatsBooked;
    }

   public DeluxeScreen(Long deluxeScreeningId, Long deluxeFilmId, Long deluxeBookingId, Double deluxeScreeningTime, String deluxeSeatsBooked){
        this.deluxeScreeningId = deluxeScreeningId;
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

    public List<BookingInfo> getBookingInfo() {
        return bookingInfo;
    }

    public void setBookingInfo(List<BookingInfo> bookingInfo) {
        this.bookingInfo = bookingInfo;
    }

    public DeluxeScreen getDeluxeScreen() {
        return deluxeScreen;
    }

    public void setDeluxeScreen(DeluxeScreen deluxeScreen) {
        this.deluxeScreen = deluxeScreen;
    }

    @Override
    public String toString(){
        return "DeluxeScreen{" +
                "deluxeScreeningId=" + deluxeScreeningId +
                ", deluxeFilmId=" + deluxeFilmId +
                ", deluxeBookingId=" + deluxeBookingId +
                ", deluxeScreeningTime=" + deluxeScreeningTime +
                ", deluxeSeatsBooked=" + deluxeSeatsBooked + '\'' +
                ", bookingInfo=" + bookingInfo +
                ", standardScreen=" + deluxeScreen +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeluxeScreen that = (DeluxeScreen) o;
        return Objects.equals(deluxeScreeningId, that.deluxeScreeningId) &&
                Objects.equals(deluxeFilmId, that.deluxeFilmId) &&
                Objects.equals(deluxeBookingId, that.deluxeBookingId) &&
                Objects.equals(deluxeScreeningTime, that.deluxeScreeningTime) &&
                Objects.equals(deluxeSeatsBooked, that.deluxeSeatsBooked) &&
                Objects.equals(bookingInfo, that.bookingInfo) &&
                Objects.equals(deluxeScreen, that.deluxeScreen);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deluxeScreeningId, deluxeFilmId, deluxeBookingId, deluxeScreeningTime, deluxeSeatsBooked, bookingInfo, deluxeScreen);
    }
}
