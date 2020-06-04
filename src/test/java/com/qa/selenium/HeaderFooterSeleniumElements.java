package com.qa.selenium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderFooterSeleniumElements {

    @FindBy(id = "headerBurgerMenu")
    private WebElement burgerMenu;

    public WebElement getBurgerMenu() {
        return burgerMenu;
    }
    
}