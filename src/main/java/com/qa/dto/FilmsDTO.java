package com.qa.dto;


public class
FilmsDTO {

    private Long FilmsID;
    private String filmsTitle;
    private String filmsClassification;
    private Boolean filmsIsFeature;
    private String filmsOMDBID;
    private Boolean filmsCurrentlyReleased;


    public FilmsDTO() {

    }

    public FilmsDTO(String filmsTitle, String filmsClassification, Boolean filmsIsFeature,
                    String filmsOMDBID, Boolean filmsCurrentlyReleased) {

        this.filmsTitle = filmsTitle;
        this.filmsClassification = filmsClassification;
        this.filmsIsFeature = filmsIsFeature;
        this.filmsOMDBID = filmsOMDBID;
        this.filmsCurrentlyReleased = filmsCurrentlyReleased;

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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((FilmsID == null) ? 0 : FilmsID.hashCode());
        result = prime * result + ((filmsClassification == null) ? 0 : filmsClassification.hashCode());
        result = prime * result + ((filmsCurrentlyReleased == null) ? 0 : filmsCurrentlyReleased.hashCode());
        result = prime * result + ((filmsIsFeature == null) ? 0 : filmsIsFeature.hashCode());
        result = prime * result + ((filmsOMDBID == null) ? 0 : filmsOMDBID.hashCode());
        result = prime * result + ((filmsTitle == null) ? 0 : filmsTitle.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        FilmsDTO other = (FilmsDTO) obj;
        if (FilmsID == null) {
            if (other.FilmsID != null)
                return false;
        } else if (!FilmsID.equals(other.FilmsID))
            return false;
        if (filmsClassification == null) {
            if (other.filmsClassification != null)
                return false;
        } else if (!filmsClassification.equals(other.filmsClassification))
            return false;
        if (filmsCurrentlyReleased == null) {
            if (other.filmsCurrentlyReleased != null)
                return false;
        } else if (!filmsCurrentlyReleased.equals(other.filmsCurrentlyReleased))
            return false;
        if (filmsIsFeature == null) {
            if (other.filmsIsFeature != null)
                return false;
        } else if (!filmsIsFeature.equals(other.filmsIsFeature))
            return false;
        if (filmsOMDBID == null) {
            if (other.filmsOMDBID != null)
                return false;
        } else if (!filmsOMDBID.equals(other.filmsOMDBID))
            return false;
        if (filmsTitle == null) {
            if (other.filmsTitle != null)
                return false;
        } else if (!filmsTitle.equals(other.filmsTitle))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "FilmsDTO [FilmsID=" + FilmsID + ", filmsClassification=" + filmsClassification
                + ", filmsCurrentlyReleased=" + filmsCurrentlyReleased + ", filmsIsFeature=" + filmsIsFeature
                + ", filmsOMDBID=" + filmsOMDBID + ", filmsTitle=" + filmsTitle + "]";
    }

    
}
