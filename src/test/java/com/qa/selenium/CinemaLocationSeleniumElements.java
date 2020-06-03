package com.qa.selenium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CinemaLocationSeleniumElements {

    @FindBy(id = "ourLocation")
    private  WebElement ourLocation;

    @FindBy(id = "oldTraffordLink")
    private WebElement oldTraffordLink;

    @FindBy(id = "iWMNorthLink")
    private WebElement iWMNorthLink;

    @FindBy(id = "ordsallParkLink")
    private WebElement ordsallParkLink;

    public void clickOldTraffordLink() {
        this.oldTraffordLink.click();
    }

    public WebElement getOurLocation() {
        return ourLocation;
    }

    public void setOurLocation(WebElement ourLocation) {
        this.ourLocation = ourLocation;
    }

    public void clickIWMNorthLink() {
        this.iWMNorthLink.click();
    }

    public void clickOrdsallParkLink() {
        this.ordsallParkLink.click();
    }

    public WebElement getOldTraffordLink() {
        return oldTraffordLink;
    }

    public void setOldTraffordLink(WebElement oldTraffordLink) {
        this.oldTraffordLink = oldTraffordLink;
    }

    public WebElement getiWMNorthLink() {
        return iWMNorthLink;
    }

    public void setiWMNorthLink(WebElement iWMNorthLink) {
        this.iWMNorthLink = iWMNorthLink;
    }

    public WebElement getOrdsallParkLink() {
        return ordsallParkLink;
    }

    public void setOrdsallParkLink(WebElement ordsallParkLink) {
        this.ordsallParkLink = ordsallParkLink;
    }
}
