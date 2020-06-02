package com.qa.selenium;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.File;

import static java.lang.Thread.sleep;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FilmClassificationSeleniumTest {

    @LocalServerPort
    static String port;

    static WebDriver driver;
    static ExtentReports report;
    static ExtentTest test;

    @BeforeTest
    public static void startReport() {
        report = new ExtentReports(System.getProperty("user.dir") + "/test-output/Report.html", true);
        report.addSystemInfo("Host Name", "QA").addSystemInfo("Tester", "Dan");
        report.loadConfig(new File(System.getProperty("user.dir") + "\\extent-report.xml"));
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    public void seleniumFilmClassificationPageTest() throws InterruptedException {
        test = report.startTest("Testing Film Classifications Page");
        driver.manage().window().maximize();
        test.log(LogStatus.INFO, "Started chrome browser and made it fullscreen");
        driver.get("http://127.0.0.1:"+ port +"/src/main/resources/static/homepage.html");
        test.log(LogStatus.INFO, "Navigated to the Cinema website");
        sleep(2000);
        test.log(LogStatus.INFO, "Attempting to access Footer Link for Films Classifications Page...");
        WebElement footerLinkClassifications = driver.findElement(By.id("footerLinkClassifications"));
        footerLinkClassifications.click();
        sleep(2000);
        test.log(LogStatus.INFO, "Footer Link to Films Classifications Page Succeeded");
        sleep(2000);
        test.log(LogStatus.INFO, "Films Classifications Selenium Test Completed");
    }

    @Test
    public void seleniumFilmClassificationsPageExternalLinkOneTest() throws InterruptedException {
        test = report.startTest("Testing Film Classifications Page External Link One");
        driver.manage().window().maximize();
        test.log(LogStatus.INFO, "Started chrome browser and made it fullscreen");
        driver.get("http://127.0.0.1:"+ port +"/src/main/resources/static/homepage.html");
        test.log(LogStatus.INFO, "Navigated to the Cinema website");
        sleep(2000);
        test.log(LogStatus.INFO, "Attempting to access Footer Link for Films Classifications Page...");
        WebElement footerLinkClassifications = driver.findElement(By.id("footerLinkClassifications"));
        footerLinkClassifications.click();
        sleep(2000);
        test.log(LogStatus.INFO, "Footer Link to Films Classifications Page Succeeded");
        sleep(2000);
        test.log(LogStatus.INFO, "Attempting to access External Link One from Films Classifications Page...");
        WebElement externalLinkOne = driver.findElement(By.id("linkExternalTwo"));
        externalLinkOne.click();
        sleep(2000);
        test.log(LogStatus.INFO, "External Link One Succeeded");
    }

    @Test
    public void seleniumFilmClassificationsPageExternalLinkTwoTest() throws InterruptedException {
        test = report.startTest("Testing Film Classifications Page External Link Two");
        driver.manage().window().maximize();
        test.log(LogStatus.INFO, "Started chrome browser and made it fullscreen");
        driver.get("http://127.0.0.1:"+ port +"/src/main/resources/static/homepage.html");
        test.log(LogStatus.INFO, "Navigated to the Cinema website");
        sleep(2000);
        test.log(LogStatus.INFO, "Attempting to access Footer Link for Films Classifications Page...");
        WebElement footerLinkClassifications = driver.findElement(By.id("footerLinkClassifications"));
        footerLinkClassifications.click();
        sleep(2000);
        test.log(LogStatus.INFO, "Footer Link to Films Classifications Page Succeeded");
        sleep(2000);
        test.log(LogStatus.INFO, "Attempting to access External Link Two from Films Classifications Page...");
        WebElement externalLinkTwo = driver.findElement(By.id("linkExternalThree"));
        externalLinkTwo.click();
        sleep(2000);
        test.log(LogStatus.INFO, "External Link Two Succeeded");
    }

    @AfterMethod
    public void getResult(ITestResult result) {
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
    public static void endReport() {
        report.flush();
        report.close();
    }

}
