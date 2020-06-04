package com.qa.selenium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderFooterSeleniumElements {

    //footer

    @FindBy(id = "headerBurgerMenu")
    private WebElement burgerMenu;

    @FindBy(id = "headerLinkFilms")
    private WebElement filmsLink;

    @FindBy(id = "headerLogoLink")
    private WebElement logoLink;

    @FindBy(id = "headerLinkScreen")
    private WebElement screenLink;

    @FindBy(id = "headerLinkAbout")
    private WebElement aboutLink;

    @FindBy(id = "headerLinkHours")
    private WebElement hoursLink;

    @FindBy(id = "headerLinkLocation")
    private WebElement locationLink;

    @FindBy(id = "headerLinkContact")
    private WebElement contactLink;

    @FindBy(id = "headerTicketsButton")
    private WebElement bookTickets;

    //Footer

    @FindBy(id = "footerLinkInformation")
    private WebElement infoLink;

    @FindBy(id = "footerLinkDevs")
    private WebElement websiteLink;
    
    @FindBy(id = "footerLinkProduction")
    private WebElement processLink;
    
    @FindBy(id = "footerLinkContact")
    private WebElement contactLinkFooter;
    
    @FindBy(id = "footerLinkLocation")
    private WebElement findUsLink;
        
    @FindBy(id = "footerLinkClassifications")
    private WebElement classLink;

    //Getters

    public WebElement getBurgerMenu() {
        return burgerMenu;
    }

    public WebElement getFilmsLink() {
        return filmsLink;
    }

    public WebElement getLogoLink() {
        return logoLink;
    }

    public WebElement getScreenLink() {
        return screenLink;
    }

    public WebElement getAboutLink() {
        return aboutLink;
    }

    public WebElement getHoursLink() {
        return hoursLink;
    }

    public WebElement getLocationLink() {
        return locationLink;
    }

    public WebElement getContactLink() {
        return contactLink;
    }

    public WebElement getBookTickets() {
        return bookTickets;
    }

    public WebElement getInfoLink() {
        return infoLink;
    }

    public WebElement getWebsiteLink() {
        return websiteLink;
    }

    public WebElement getProcessLink() {
        return processLink;
    }

    public WebElement getContactLinkFooter() {
        return contactLinkFooter;
    }

    public WebElement getFindUsLink() {
        return findUsLink;
    }

    public WebElement getClassLink() {
        return classLink;
    }
    
}