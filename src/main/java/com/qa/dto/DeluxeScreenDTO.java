package com.qa.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class DeluxeScreenDTO {

    private Long deluxeScreeningId;
    private Double deluxeScreeningTime;
    private String deluxeSeatsBooked;
    private LocalDate deluxeScreenDate;

    private List<FilmsDTO> films;

    public DeluxeScreenDTO(){

    }

    public DeluxeScreenDTO(Double deluxeScreeningTime, String deluxeSeatsBooked, LocalDate deluxeScreenDate, List<FilmsDTO> films) {
        super();
        this.deluxeScreeningTime = deluxeScreeningTime;
        this.deluxeSeatsBooked = deluxeSeatsBooked;
        this.deluxeScreenDate = deluxeScreenDate;
        this.films = films;
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

    public List<FilmsDTO> getFilms() {
        return films;
    }

    public void setFilms(List<FilmsDTO> films) {
        this.films = films;
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
                Objects.equals(getFilms(), that.getFilms());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDeluxeScreeningId(), getDeluxeScreeningTime(), getDeluxeSeatsBooked(), getDeluxeScreenDate(), getFilms());
    }
}
