package com.qa.domain;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;


@Entity
public class DeluxeScreen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long deluxeScreeningId;
    private Double deluxeScreeningTime;
    private String deluxeSeatsBooked;
    private LocalDate deluxeScreenDate;

    @OneToMany (mappedBy = "deluxeScreen", fetch = FetchType.LAZY)
    private List<BookingInfo> bookingInfo = new ArrayList<>();

    @ManyToOne(targetEntity = Films.class)
    private Films films;

    public DeluxeScreen(){
    }

    public DeluxeScreen(Double deluxeScreeningTime, String deluxeSeatsBooked, LocalDate deluxeScreenDate){
        this.deluxeScreeningTime = deluxeScreeningTime;
        this.deluxeSeatsBooked = deluxeSeatsBooked;
        this.deluxeScreenDate = deluxeScreenDate;
    }

   public DeluxeScreen(Long deluxeScreeningId, Double deluxeScreeningTime, String deluxeSeatsBooked, LocalDate deluxeScreenDate){
        this.deluxeScreeningId = deluxeScreeningId;
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

    public LocalDate getDeluxeScreenDate() {
        return deluxeScreenDate;
    }

    public void setDeluxeScreenDate(LocalDate deluxeScreenDate) {
        this.deluxeScreenDate = deluxeScreenDate;
    }

    @Override
    public String toString() {
        return "DeluxeScreen{" +
                "deluxeScreeningId=" + deluxeScreeningId +
                ", deluxeScreeningTime=" + deluxeScreeningTime +
                ", deluxeSeatsBooked='" + deluxeSeatsBooked + '\'' +
                ", deluxeScreenDate=" + deluxeScreenDate +
                ", bookingInfo=" + bookingInfo +
                ", films=" + films +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeluxeScreen that = (DeluxeScreen) o;
        return Objects.equals(deluxeScreeningId, that.deluxeScreeningId) &&
                Objects.equals(deluxeScreeningTime, that.deluxeScreeningTime) &&
                Objects.equals(deluxeSeatsBooked, that.deluxeSeatsBooked) &&
                Objects.equals(deluxeScreenDate, that.deluxeScreenDate) &&
                Objects.equals(bookingInfo, that.bookingInfo) &&
                Objects.equals(films, that.films);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deluxeScreeningId, deluxeScreeningTime, deluxeSeatsBooked, deluxeScreenDate, bookingInfo, films);
    }
}
