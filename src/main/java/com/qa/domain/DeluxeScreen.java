package com.qa.domain;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class DeluxeScreen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long deluxeScreeningId;
    private Long filmId;
    private double screeningTime;
    private String seatsBooked;

//    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
//    private List<Films> films = new ArrayList<>();

//    @ManyToOne(targetEntity = BookingInfo.class)
//    private BookingInfo bookingInfo;;

    public DeluxeScreen(){

    }

    public DeluxeScreen(Long filmId, double screeningTime, String seatsBooked){
        this.filmId = filmId;
        this.screeningTime = screeningTime;
        this.seatsBooked = seatsBooked;
    }

    public Long getDeluxeScreeningId() {
        return deluxeScreeningId;
    }

    public void setDeluxeScreeningId(Long deluxeScreeningId) {
        this.deluxeScreeningId = deluxeScreeningId;
    }

    public Long getFilmId() {
        return filmId;
    }

    public void setFilmId(Long filmId) {
        this.filmId = filmId;
    }

    public double getScreeningTime() {
        return screeningTime;
    }

    public void setScreeningTime(double screeningTime) {
        this.screeningTime = screeningTime;
    }

    public String getSeatsBooked() {
        return seatsBooked;
    }

    public void setSeatsBooked(String seatsBooked) {
        this.seatsBooked = seatsBooked;
    }
}
