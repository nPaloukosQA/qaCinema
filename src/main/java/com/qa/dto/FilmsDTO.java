package com.qa.dto;


import com.qa.domain.DeluxeScreen;
import com.qa.domain.StandardScreen;

import java.util.List;
import java.util.Objects;

public class
FilmsDTO {

    private Long FilmsID;
    private String filmsTitle;
    private String filmsClassification;
    private Boolean filmsIsFeature;
    private String filmsOMDBID;
    private Boolean filmsCurrentlyReleased;

    private List<StandardScreen> standardScreen;
    private List<DeluxeScreen> deluxeScreen;



    public FilmsDTO() {

    }

    public FilmsDTO(String filmsTitle, String filmsClassification, Boolean filmsIsFeature,
                    String filmsOMDBID, Boolean filmsCurrentlyReleased, List<StandardScreen> standardScreen, List<DeluxeScreen> deluxeScreen) {

        this.filmsTitle = filmsTitle;
        this.filmsClassification = filmsClassification;
        this.filmsIsFeature = filmsIsFeature;
        this.filmsOMDBID = filmsOMDBID;
        this.filmsCurrentlyReleased = filmsCurrentlyReleased;
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

    public Boolean getFilmsIsFeature() {
        return filmsIsFeature;
    }

    public void setFilmsIsFeature(Boolean filmsIsFeature) {
        this.filmsIsFeature = filmsIsFeature;
    }

    public String getFilmsOMDBID() {
        return filmsOMDBID;
    }

    public void setFilmsOMDBID(String filmsOMDBID) {
        this.filmsOMDBID = filmsOMDBID;
    }

    public Boolean getFilmsCurrentlyReleased() {
        return filmsCurrentlyReleased;
    }

    public void setFilmsCurrentlyReleased(Boolean filmsCurrentlyReleased) {
        this.filmsCurrentlyReleased = filmsCurrentlyReleased;
    }

    public List<StandardScreen> getStandardScreen() {
        return standardScreen;
    }

    public void setStandardScreen(List<StandardScreen> standardScreen) {
        this.standardScreen = standardScreen;
    }

    public List<DeluxeScreen> getDeluxeScreen() {
        return deluxeScreen;
    }

    public void setDeluxeScreen(List<DeluxeScreen> deluxeScreen) {
        this.deluxeScreen = deluxeScreen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FilmsDTO)) return false;
        FilmsDTO filmsDTO = (FilmsDTO) o;
        return Objects.equals(getFilmsID(), filmsDTO.getFilmsID()) &&
                Objects.equals(getFilmsTitle(), filmsDTO.getFilmsTitle()) &&
                Objects.equals(getFilmsClassification(), filmsDTO.getFilmsClassification()) &&
                Objects.equals(getFilmsIsFeature(), filmsDTO.getFilmsIsFeature()) &&
                Objects.equals(getFilmsOMDBID(), filmsDTO.getFilmsOMDBID()) &&
                Objects.equals(getFilmsCurrentlyReleased(), filmsDTO.getFilmsCurrentlyReleased()) &&
                Objects.equals(getStandardScreen(), filmsDTO.getStandardScreen()) &&
                Objects.equals(getDeluxeScreen(), filmsDTO.getDeluxeScreen());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFilmsID(), getFilmsTitle(), getFilmsClassification(), getFilmsIsFeature(), getFilmsOMDBID(), getFilmsCurrentlyReleased(), getStandardScreen(), getDeluxeScreen());
    }
}
