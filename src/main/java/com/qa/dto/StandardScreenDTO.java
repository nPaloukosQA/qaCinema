package com.qa.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class StandardScreenDTO {

    private Long standardScreeningId;
    private Double standardScreenScreeningTime;
    private String standardScreenSeatsBooked;
    private LocalDate standardScreenDate;

    private List<FilmsDTO> films;

    public StandardScreenDTO() {

    }

    public StandardScreenDTO(Double standardScreenScreeningTime, String standardScreenSeatsBooked, LocalDate standardScreenDate, List<FilmsDTO> films){
        super();
        this.standardScreenScreeningTime = standardScreenScreeningTime;
        this.standardScreenSeatsBooked = standardScreenSeatsBooked;
        this.standardScreenDate = standardScreenDate;
        this.films = films;
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

    public LocalDate getStandardScreenDate() {
        return standardScreenDate;
    }

    public void setStandardScreenDate(LocalDate standardScreenDate) {
        this.standardScreenDate = standardScreenDate;
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
        if (!(o instanceof StandardScreenDTO)) return false;
        StandardScreenDTO that = (StandardScreenDTO) o;
        return Objects.equals(getStandardScreeningId(), that.getStandardScreeningId()) &&
                Objects.equals(getStandardScreenScreeningTime(), that.getStandardScreenScreeningTime()) &&
                Objects.equals(getStandardScreenSeatsBooked(), that.getStandardScreenSeatsBooked()) &&
                Objects.equals(getStandardScreenDate(), that.getStandardScreenDate()) &&
                Objects.equals(getFilms(), that.getFilms());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStandardScreeningId(), getStandardScreenScreeningTime(), getStandardScreenSeatsBooked(), getStandardScreenDate(), getFilms());
    }
}
