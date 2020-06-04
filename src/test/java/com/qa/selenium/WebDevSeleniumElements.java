package com.qa.selenium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebDevSeleniumElements {

    @FindBy(id = "leftControl")
    private WebElement leftControl;

    @FindBy(id = "rightControl")
    private WebElement rightControl;

    @FindBy(id = "dan-pic")
    private WebElement danPic;

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

    public WebElement getDanPic() {
        return danPic;
    }

    public void setDanPic(WebElement danPic) {
        this.danPic = danPic;
    }
}
