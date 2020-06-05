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

}