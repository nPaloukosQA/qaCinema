package com.qa.selenium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductionProcessSeleniumElements {

    @FindBy(id = "leftControl")
    private WebElement leftControl;

    @FindBy(id = "rightControl")
    private WebElement rightControl;

    @FindBy(id = "img1")
    private WebElement imgOne;

    @FindBy(id = "img2")
    private WebElement imgTwo;

    @FindBy(id = "img3")
    private WebElement imgThree;

    @FindBy(id = "img4")
    private WebElement imgFour;

    @FindBy(id = "img5")
    private WebElement imgFive;

    @FindBy(id = "img6")
    private WebElement imgSix;

    @FindBy(id = "img7")
    private WebElement imgSeven;

    @FindBy(id = "img8")
    private WebElement imgEight;

    @FindBy(id = "img9")
    private WebElement imgNine;

    @FindBy(id = "developersLink")
    private WebElement devLink;


    public WebElement getLeftControl() {
        return leftControl;
    }

    public void setLeftControl(WebElement leftControl) {
        this.leftControl = leftControl;
    }

    public WebElement getRightControl() {
        return rightControl;
    }

    public void setRightControl(WebElement rightControl) {
        this.rightControl = rightControl;
    }

    public WebElement getImgOne() {
        return imgOne;
    }

    public void setImgOne(WebElement imgOne) {
        this.imgOne = imgOne;
    }

    public WebElement getImgTwo() {
        return imgTwo;
    }

    public void setImgTwo(WebElement imgTwo) {
        this.imgTwo = imgTwo;
    }

    public WebElement getImgThree() {
        return imgThree;
    }

    public void setImgThree(WebElement imgThree) {
        this.imgThree = imgThree;
    }

    public WebElement getImgFour() {
        return imgFour;
    }

    public void setImgFour(WebElement imgFour) {
        this.imgFour = imgFour;
    }

    public WebElement getImgFive() {
        return imgFive;
    }

    public void setImgFive(WebElement imgFive) {
        this.imgFive = imgFive;
    }

    public WebElement getImgSix() {
        return imgSix;
    }

    public void setImgSix(WebElement imgSix) {
        this.imgSix = imgSix;
    }

    public WebElement getImgSeven() {
        return imgSeven;
    }

    public void setImgSeven(WebElement imgSeven) {
        this.imgSeven = imgSeven;
    }

    public WebElement getImgEight() {
        return imgEight;
    }

    public void setImgEight(WebElement imgEight) {
        this.imgEight = imgEight;
    }

    public WebElement getImgNine() {
        return imgNine;
    }

    public void setImgNine(WebElement imgNine) {
        this.imgNine = imgNine;
    }

    public WebElement getDevLink() {
        return devLink;
    }

    public void setDevLink(WebElement devLink) {
        this.devLink = devLink;
    }
}
