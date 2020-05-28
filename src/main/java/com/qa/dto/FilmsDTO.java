package com.qa.dto;

import java.util.List;
import java.util.Objects;

public class
FilmsDTO {

    private Long FilmsID;
    private String filmsTitle;
    private String filmsClassification;

    private List<StandardScreenDTO> standardScreen;
    private List<DeluxeScreenDTO> deluxeScreen;

    public FilmsDTO() {

    }

    public FilmsDTO(String filmsTitle, String filmsClassification, List<StandardScreenDTO> standardScreen, List<DeluxeScreenDTO> deluxeScreen) {

        this.filmsTitle = filmsTitle;
        this.filmsClassification = filmsClassification;
        this.standardScreen = standardScreen;
        this.deluxeScreen = deluxeScreen;

    }

    public Long getFilmsID() {
        return FilmsID;
    }

    public void setFilmsID(Long filmsID) {
        FilmsID = filmsID;
    }

    public String getFilmsTitle() {
        return filmsTitle;
    }

    public void setFilmsTitle(String filmsTitle) {
        this.filmsTitle = filmsTitle;
    }

    public String getFilmsClassification() {
        return filmsClassification;
    }

    public void setFilmsClassification(String filmsClassification) {
        this.filmsClassification = filmsClassification;
    }

    public List<StandardScreenDTO> getStandardScreen() {
        return standardScreen;
    }

    public void setStandardScreen(List<StandardScreenDTO> standardScreen) {
        this.standardScreen = standardScreen;
    }

    public List<DeluxeScreenDTO> getDeluxeScreen() {
        return deluxeScreen;
    }

    public void setDeluxeScreen(List<DeluxeScreenDTO> deluxeScreen) {
        this.deluxeScreen = deluxeScreen;
    }

    @Override
    public String toString() {
        return "FilmsDTO{" +
                "FilmsID=" + FilmsID +
                ", filmsTitle='" + filmsTitle + '\'' +
                ", filmsClassification='" + filmsClassification + '\'' +
                ", standardScreen=" + standardScreen +
                ", deluxeScreen=" + deluxeScreen +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilmsDTO filmsDTO = (FilmsDTO) o;
        return Objects.equals(FilmsID, filmsDTO.FilmsID) &&
                Objects.equals(filmsTitle, filmsDTO.filmsTitle) &&
                Objects.equals(filmsClassification, filmsDTO.filmsClassification) &&
                Objects.equals(standardScreen, filmsDTO.standardScreen) &&
                Objects.equals(deluxeScreen, filmsDTO.deluxeScreen);
    }

    @Override
    public int hashCode() {
        return Objects.hash(FilmsID, filmsTitle, filmsClassification, standardScreen, deluxeScreen);
    }
}
