package com.qa.selenium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OpeningTimesSeleniumElements {

    @FindBy(id = "openingTimesTitle")
    private WebElement openingTimesTitle;

    @FindBy(id = "headerBurgerMenu")
    private WebElement burgerMenu;

    @FindBy(id = "headerLinkHours")
    private WebElement hoursLink;

    public WebElement getOpeningTimesTitle() {
        return openingTimesTitle;
    }

    public void setOpeningTimesTitle(WebElement openingTimesTitle) {
        this.openingTimesTitle = openingTimesTitle;
    }

    public WebElement getBurgerMenu() {
        return burgerMenu;
    }

    public void setBurgerMenu(WebElement burgerMenu) {
        this.burgerMenu = burgerMenu;
    }

    public WebElement getHoursLink() {
        return hoursLink;
    }

    public void setHoursLink(WebElement hoursLink) {
        this.hoursLink = hoursLink;
    }
}
