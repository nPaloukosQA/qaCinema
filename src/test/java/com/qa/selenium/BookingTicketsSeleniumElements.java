package com.qa.selenium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookingTicketsSeleniumElements {

    @FindBy(id = "headerTicketsButton")
    private WebElement headerTicketsButton;

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

    @FindBy(id = "filmsSelector")
    private WebElement filmsSelector;

    @FindBy(id = "std")
    private WebElement std;

    @FindBy(id = "dlx")
    private WebElement dlx;

    @FindBy(id = "dateSelector")
    private WebElement dateSelector;

    @FindBy(id = "timeSelector")
    private WebElement timeSelector;

    @FindBy(className = "seatPicker")
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

    @FindBy(id = "bs-select-1-11")
    private WebElement b01;

    @FindBy(id = "bs-select-1-1")
    private WebElement b02;

    @FindBy(id = "bs-select-1-2")
    private WebElement b03;

    @FindBy(id = "bs-select-1-2")
    private WebElement seatsDropdown;

    @FindBy(id = "email")
    private WebElement payPalMail;

    @FindBy(id = "password")
    private WebElement payPalPassword;

    @FindBy(id = "btnLogin")
    private WebElement loginPaypal;

    @FindBy(id = "payment-submit-btn")
    private WebElement paymentBtn;


    public WebElement getFname() {
        return fname;
    }

    public WebElement getSname() {
        return sname;
    }

    public WebElement getEmail() {
        return email;
    }

    public WebElement getPhone() {
        return phone;
    }

    public WebElement getAddress() {
        return address;
    }

    public WebElement getPostcode() {
        return postcode;
    }

    public WebElement getStd() {
        return std;
    }

    public WebElement getDlx() {
        return dlx;
    }

    public WebElement getDateSelector() {
        return dateSelector;
    }

    public WebElement getTimeSelector() {
        return timeSelector;
    }

    public WebElement getSeatPicker() {
        return seatPicker;
    }

    public WebElement getSeatNumbersCheck() {
        return seatNumbersCheck;
    }

    public WebElement getInputOfAdults() {
        return inputOfAdults;
    }

    public WebElement getInputOfChildren() {
        return inputOfChildren;
    }

    public WebElement getInputOfConcession() {
        return inputOfConcession;
    }

    public WebElement getTotalPrice() {
        return totalPrice;
    }

    public WebElement getPaypalButton() {
        return paypalButton;
    }

    public WebElement getSubmitBtn() {
        return submitBtn;
    }

    public WebElement getHeaderTicketsButton() {
        return headerTicketsButton;
    }

    public WebElement getFilmsSelector() {
        return filmsSelector;
    }

    public WebElement getB01() {
        return b01;
    }

    public WebElement getB02() {
        return b02;
    }

    public WebElement getB03() {
        return b03;
    }

    public WebElement getSeatsDropdown() {
        return seatsDropdown;
    }

    public WebElement getPayPalMail() {
        return payPalMail;
    }

    public WebElement getPayPalPassword() {
        return payPalPassword;
    }

    public WebElement getLoginPaypal() {
        return loginPaypal;
    }

    public WebElement getPaymentBtn() {
        return paymentBtn;
    }
}
