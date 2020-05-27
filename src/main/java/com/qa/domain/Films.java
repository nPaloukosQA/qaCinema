package com.qa.domain;

import com.sun.org.apache.xpath.internal.operations.String;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Films {

    @Id
    @GeneratedValue
    private Long filmsID;
    private String filmsTitle;
    private String filmsClassification;

//    @OneToMany(mappedBy = "films", fetch = FetchType.LAZY)
//    private List<StandardScreen> standardScreen = new ArrayList<>();

//    @OneToMany(mappedBy = "films", fetch = FetchType.LAZY)
//    private List<DeluxeScreen> deluxeScreen = new ArrayList<>();

    public Films () {
    }

    public Films (String filmsTitle, String filmsClassification) {

        this.filmsTitle = filmsTitle;
        this.filmsClassification = filmsClassification;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Films films = (Films) o;
        return Objects.equals(filmsID, films.filmsID) &&
                Objects.equals(filmsTitle, films.filmsTitle) &&
                Objects.equals(filmsClassification, films.filmsClassification);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filmsID, filmsTitle, filmsClassification);
    }
}