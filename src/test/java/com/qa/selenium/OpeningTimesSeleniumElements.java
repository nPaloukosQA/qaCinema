package com.qa.selenium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OpeningTimesSeleniumElements {

    @FindBy(id = "openingTimesTitle")
    private WebElement openingTimesTitle;

    public WebElement getOpeningTimesTitle() {
        return openingTimesTitle;
    }

}
