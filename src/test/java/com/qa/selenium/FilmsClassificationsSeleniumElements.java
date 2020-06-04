package com.qa.selenium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FilmsClassificationsSeleniumElements {

    @FindBy(id = "footerLinkClassifications")
    private WebElement classLink;

    @FindBy(id = "linkExternalTwo")
    private WebElement externalLinkTwo;

    @FindBy(id = "linkExternalThree")
    private WebElement externalLinkThree;

    public WebElement getClassLink() {
        return classLink;
    }

    public void setClassLink(WebElement classLink) {
        this.classLink = classLink;
    }

    public WebElement getExternalLinkTwo() {
        return externalLinkTwo;
    }

    public void setExternalLinkTwo(WebElement externalLinkTwo) {
        this.externalLinkTwo = externalLinkTwo;
    }

    public WebElement getExternalLinkThree() {
        return externalLinkThree;
    }

    public void setExternalLinkThree(WebElement externalLinkThree) {
        this.externalLinkThree = externalLinkThree;
    }
}
