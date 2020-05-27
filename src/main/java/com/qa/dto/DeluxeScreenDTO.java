package com.qa.dto;

import java.util.List;

public class DeluxeScreenDTO {

    private Long deluxeScreeningId;
    private Long filmId;
    private double screeningTime;
    private String seatsBooked;
//    private List<package_info> package_infoList;

    public DeluxeScreenDTO(){

    }

    public DeluxeScreenDTO(Long filmId, double screeningTime, String seatsBooked) {
        super();
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

//    public List<package_info> getPackage_infoList() {
//        return package_infoList;
//    }

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

//    public void setPackage_infoList(List<package_info> package_infoList) {
//        this.package_infoList = package_infoList;
//    }
}
