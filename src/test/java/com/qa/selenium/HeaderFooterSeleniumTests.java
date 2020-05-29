package com.qa.selenium;

import org.testng.ITestResult;
import org.testng.annotations.*;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.test.context.junit4.SpringRunner;

import static java.lang.Thread.*;

import java.io.File;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

@RunWith(SpringRunner.class)
public class HeaderFooterSeleniumTests {
    
    static WebDriver driver;
    static ExtentReports report;
    static ExtentTest test;

    @BeforeTest
    public static void startReport() {
        report = new ExtentReports(System.getProperty("user.dir") + "/test-output/Report.html", true);
        report.addSystemInfo("Host Name", "QA").addSystemInfo("Tester", "Luke");
        report.loadConfig(new File(System.getProperty("user.dir") + "\\extent-report.xml"));
    }
    
    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
    }

    @Test
    public void seleniumHeaderTest() throws InterruptedException {
        test = report.startTest("Testing Webpage Header");
        driver.manage().window().maximize();
        test.log(LogStatus.INFO, "Started chrome browser and made it fullscreen");
        driver.get("http://127.0.0.1:5500/src/main/resources/static/homepage.html");
        test.log(LogStatus.INFO, "Navigated to the Cinema website");
        sleep(2000);
        test.log(LogStatus.INFO, "Attempting to access burger menu link for films page link...");
        WebElement burgerMenu = driver.findElement(By.id("headerBurgerMenu"));
        burgerMenu.click();
        sleep(2000);
        WebElement headerFilmsLink = driver.findElement(By.id("headerLinkFilms"));
        headerFilmsLink.click();
        sleep(3000);
        test.log(LogStatus.INFO, "Header Burger menu Link to Films page Succeeded");
        test.log(LogStatus.INFO, "Attempting to use Header Logo for homepage link...");
        WebElement headerLogoLink = driver.findElement(By.id("headerLogoLink"));
        headerLogoLink.click();
        sleep(3000);
        test.log(LogStatus.INFO, "Header Logo Link to Home page Succeeded");
        test.log(LogStatus.INFO, "Attempting to use burger menu for Screens page link...");
        burgerMenu = driver.findElement(By.id("headerBurgerMenu"));
        burgerMenu.click();
        sleep(2000);
        WebElement headerScreensLink = driver.findElement(By.id("headerLinkScreen"));
        headerScreensLink.click();
        sleep(3000);
        test.log(LogStatus.INFO, "Burger Menu Link to Screens page Succeeded");
        test.log(LogStatus.INFO, "Attempting to use burger menu for About Us page link...");
        burgerMenu = driver.findElement(By.id("headerBurgerMenu"));
        burgerMenu.click();
        sleep(2000);
        WebElement headerAboutLink = driver.findElement(By.id("headerLinkAbout"));
        headerAboutLink.click();
        sleep(3000);
        test.log(LogStatus.INFO, "Burger Menu Link to About Us page Succeeded");

        test.log(LogStatus.INFO, "Header Selenium Tests Complete");
    }

    @Test
    public void SeleniumFooterTest() throws InterruptedException {
        test = report.startTest("Testing Webpage Footer");
        driver.manage().window().maximize();
        test.log(LogStatus.INFO, "Started chrome browser and made it fullscreen");
        driver.get("http://127.0.0.1:5500/src/main/resources/static/homepage.html");
        test.log(LogStatus.INFO, "Navigated to the Cinema website");
        sleep(2000);
        test.log(LogStatus.INFO, "Attempting to use footer About Us Link...");
        WebElement footerAboutUsLink = driver.findElement(By.id("footerLinkInformation"));
        footerAboutUsLink.click();
        sleep(3000);
        test.log(LogStatus.INFO, "Footer About Us Link to About Us Page Succeeded");
        sleep(2000);
        test.log(LogStatus.INFO, "Attempting to use footer Logo for homepage link...");
        WebElement footerLogoLink = driver.findElement(By.id("footerLinkLogo"));
        footerLogoLink.click();
        sleep(3000);
        test.log(LogStatus.INFO, "Footer Logo Link to Home page Succeeded");
    }
    
    @AfterMethod
    public void getResult(ITestResult result){
        driver.close();
        if(result.getStatus() == ITestResult.FAILURE){
            test.log(LogStatus.FAIL, "Test has failed " + result.getName());
            test.log(LogStatus.FAIL, "Test has failed " + result.getThrowable());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(LogStatus.PASS, "Test has passed " + result.getName());
        }
        report.endTest(test);
    }

    @AfterTest
    public static void endReport(){
        report.flush();
        report.close();
    }
}