package com.qa.selenium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsSeleniumElements {

    @FindBy (id = "emailAddress")
    private WebElement emailAdress;

    @FindBy (id = "emailFName")
    private WebElement emailFName;

    @FindBy (id = "emailLName")
    private  WebElement emailLName;

    @FindBy (id = "subject")
    private WebElement subject;

    @FindBy (id = "submitButton")
    private WebElement submitButton;

    @FindBy (linkText = "Return to original site")
    private WebElement formSpreeLink;

    public void sendEmail(String emailAdress, String fName, String lName, String subject) {
        this.emailAdress.sendKeys(emailAdress);
        this.emailFName.sendKeys(fName);
        this.emailLName.sendKeys(lName);
        this.subject.sendKeys(subject);
        this.submitButton.click();
    }

    public WebElement getEmailAdress() {
        return emailAdress;
    }

    public void setEmailAdress(WebElement emailAdress) {
        this.emailAdress = emailAdress;
    }

    public WebElement getEmailFName() {
        return emailFName;
    }

    public void setEmailFName(WebElement emailFName) {
        this.emailFName = emailFName;
    }

    public WebElement getEmailLName() {
        return emailLName;
    }

    public void setEmailLName(WebElement emailLName) {
        this.emailLName = emailLName;
    }

    public WebElement getSubject() {
        return subject;
    }

    public void setSubject(WebElement subject) {
        this.subject = subject;
    }

    public WebElement getSubmitButton() {
        return submitButton;
    }

    public void setSubmitButton(WebElement submitButton) {
        this.submitButton = submitButton;
    }

    public WebElement getFormSpreeLink() {
        return formSpreeLink;
    }

    public void setFormSpreeLink(WebElement formSpreeLink) {
        this.formSpreeLink = formSpreeLink;
    }
}
