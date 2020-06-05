package com.qa.selenium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FilmsSeleniumElements {

    @FindBy(id = "carouselLeft")
    private WebElement carouselLeft;

    @FindBy(id = "carouselRight")
    private WebElement carouselRight;

	public WebElement getCarouselLeft() {
		return carouselLeft;
	}

	public WebElement getCarouselRight() {
		return carouselRight;
	}
    
    // Film Info Page

    @FindBy(id = "filmCertImg")
    private WebElement filmCertImg;

    @FindBy(id = "filmTicketsButton")
    private WebElement filmTicketsButton;

    @FindBy(id = "filmInfoTitle")
    private WebElement filmInfoTitle;

    @FindBy(id = "fname")
    private WebElement fName;

	public WebElement getFilmCertImg() {
		return filmCertImg;
	}

	public WebElement getFilmTicketsButton() {
		return filmTicketsButton;
	}

	public WebElement getFilmInfoTitle() {
		return filmInfoTitle;
	}

	public WebElement getfName() {
		return fName;
	}
    
}