package com.qa.selenium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookingTicketsSeleniumElements {

    @FindBy(id = "fname")
    private WebElement fname;

    @FindBy(id = "sname")
    private WebElement sname;

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "phone")
    private WebElement phone;

    @FindBy(id = "address")
    private WebElement address;

    @FindBy(id = "postcode")
    private WebElement postcode;

    @FindBy(id = "std")
    private WebElement std;

    @FindBy(id = "dlx")
    private WebElement dlx;

    @FindBy(id = "dateSelector")
    private WebElement dateSelector;

    @FindBy(id = "timeSelector")
    private WebElement timeSelector;

    @FindBy(id = "seatPicker")
    private WebElement seatPicker;

    @FindBy(id = "seatNumbersCheck")
    private WebElement seatNumbersCheck;

    @FindBy(id = "inputOfAdults")
    private WebElement inputOfAdults;

    @FindBy(id = "inputOfChildren")
    private WebElement inputOfChildren;

    @FindBy(id = "inputOfConcession")
    private WebElement inputOfConcession;

    @FindBy(id = "totalPrice")
    private WebElement totalPrice;
    
    @FindBy(id = "paypal-button")
    private WebElement paypalButton;

    @FindBy(id = "submitBtn")
    private WebElement submitBtn;


}
