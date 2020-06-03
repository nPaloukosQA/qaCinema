package com.qa.domain;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Films {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long filmsID;
    private String filmsTitle;
    private String filmsClassification;
    private Boolean filmsIsFeature;
    private String filmsOMDBID;
    @Column(name="films_currently_released")
    private Boolean filmsCurrentlyReleased;

    @OneToMany(mappedBy = "films") @LazyCollection(LazyCollectionOption.FALSE)
    private List<StandardScreen> standardScreen;

    @OneToMany(mappedBy = "films") @LazyCollection(LazyCollectionOption.FALSE)
    private List<DeluxeScreen> deluxeScreen;

    public Films () {
    }

    public Films (String filmsTitle, String filmsClassification, Boolean filmsIsFeature,
                  String filmsOMDBID, Boolean filmsCurrentlyReleased, List<StandardScreen> standardScreen,
                  List<DeluxeScreen> deluxeScreen) {

        this.filmsTitle = filmsTitle;
        this.filmsClassification = filmsClassification;
        this.filmsIsFeature = filmsIsFeature;
        this.filmsOMDBID = filmsOMDBID;
        this.filmsCurrentlyReleased = filmsCurrentlyReleased;
        this.standardScreen = standardScreen;
        this.deluxeScreen = deluxeScreen;
    }

    public Long getFilmsID() {
        return filmsID;
    }

    public void setFilmsID(Long filmsID) {
        this.filmsID = filmsID;
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
    public String toString() {
        return "Films{" +
                "filmsID=" + filmsID +
                ", filmsTitle='" + filmsTitle + '\'' +
                ", filmsClassification='" + filmsClassification + '\'' +
                ", filmsIsFeature=" + filmsIsFeature +
                ", filmsOMDBID='" + filmsOMDBID + '\'' +
                ", filmsCurrentlyReleased=" + filmsCurrentlyReleased +
                ", standardScreen=" + standardScreen +
                ", deluxeScreen=" + deluxeScreen +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Films films = (Films) o;
        return Objects.equals(filmsID, films.filmsID) &&
                Objects.equals(filmsTitle, films.filmsTitle) &&
                Objects.equals(filmsClassification, films.filmsClassification) &&
                Objects.equals(filmsIsFeature, films.filmsIsFeature) &&
                Objects.equals(filmsOMDBID, films.filmsOMDBID) &&
                Objects.equals(filmsCurrentlyReleased, films.filmsCurrentlyReleased) &&
                Objects.equals(standardScreen, films.standardScreen) &&
                Objects.equals(deluxeScreen, films.deluxeScreen);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filmsID, filmsTitle, filmsClassification, filmsIsFeature, filmsOMDBID, filmsCurrentlyReleased, standardScreen, deluxeScreen);
    }
}