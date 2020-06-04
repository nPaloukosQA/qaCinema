package com.qa.selenium;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
//import org.testng.ITestResult;
//import org.testng.annotations.*;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import static java.lang.Thread.*;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HeaderFooterSeleniumTests {
    
    @LocalServerPort
    private int port;

    private WebDriver driver;
    static ExtentReports report;
    ExtentTest test;

    @BeforeClass
    public static void reportSetup(){
        report = new ExtentReports ("test-output" + File.separator + "Report.html", true);
        report
                .addSystemInfo("Host Name", "QA")
                .addSystemInfo("Environment", "Automated Testing")
                .addSystemInfo("User Name", "Luke");
        report.loadConfig(new File("extent-config.xml"));

    }

    @Before
    public void driverSetUp(){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        ChromeOptions opts = new ChromeOptions();
        this.driver = new ChromeDriver(opts);
    }

    @Test
    public void seleniumHeaderTest() throws InterruptedException {
        test = report.startTest("Start Selenium Test for Header");
        driver.manage().window().maximize();
        test.log(LogStatus.INFO, "Browser started");
        driver.get("http://localhost:"+ port +"/homepage.html");
        HeaderFooterSeleniumElements header = PageFactory.initElements(driver, HeaderFooterSeleniumElements.class);
        WebDriverWait wait = new WebDriverWait(driver, 2);

        wait.until(ExpectedConditions.elementToBeClickable(header.getBurgerMenu()));
        assertEquals(driver.getCurrentUrl(), "http://localhost:" + port + "/homepage.html");
        header.getBurgerMenu().click();

        wait.until(ExpectedConditions.elementToBeClickable(header.getFilmsLink()));
        header.getFilmsLink().click();

        assertEquals(driver.getCurrentUrl(), "http://localhost:" + port + "/filmsPage.html");
        if (!(driver.getCurrentUrl().equals("http://localhost:" + port + "/filmsPage.html"))){
            test.log(LogStatus.FAIL, "Header Films Link: FAIL!");
            Assert.fail();
        } else {
            test.log(LogStatus.PASS, "Header Films Link: PASS!");
        }

        wait.until(ExpectedConditions.elementToBeClickable(header.getBurgerMenu()));
        header.getBurgerMenu().click();
        wait.until(ExpectedConditions.elementToBeClickable(header.getLogoLink()));
        header.getLogoLink().click();

        assertEquals(driver.getCurrentUrl(), "http://localhost:" + port + "/homepage.html");
        if (!(driver.getCurrentUrl().equals("http://localhost:" + port + "/homepage.html"))){
            test.log(LogStatus.FAIL, "Header Logo Link: FAIL!");
            Assert.fail();
        } else {
            test.log(LogStatus.PASS, "Header Logo Link: PASS!");
        }

        wait.until(ExpectedConditions.elementToBeClickable(header.getBurgerMenu()));
        header.getBurgerMenu().click();
        wait.until(ExpectedConditions.elementToBeClickable(header.getScreenLink()));
        header.getScreenLink().click();

        assertEquals(driver.getCurrentUrl(), "http://localhost:" + port + "/screensPage.html");
        if (!(driver.getCurrentUrl().equals("http://localhost:" + port + "/screensPage.html"))){
            test.log(LogStatus.FAIL, "Header Screens Link: FAIL!");
            Assert.fail();
        } else {
            test.log(LogStatus.PASS, "Header Screens Link: PASS!");
        }
        
        wait.until(ExpectedConditions.elementToBeClickable(header.getBurgerMenu()));
        header.getBurgerMenu().click();
        wait.until(ExpectedConditions.elementToBeClickable(header.getAboutLink()));
        header.getAboutLink().click();

        assertEquals(driver.getCurrentUrl(), "http://localhost:" + port + "/aboutUsPage.html");
        if (!(driver.getCurrentUrl().equals("http://localhost:" + port + "/aboutUsPage.html"))){
            test.log(LogStatus.FAIL, "Header About us Link: FAIL!");
            Assert.fail();
        } else {
            test.log(LogStatus.PASS, "Header About us Link: PASS!");
        }

        wait.until(ExpectedConditions.elementToBeClickable(header.getBurgerMenu()));
        header.getBurgerMenu().click();
        wait.until(ExpectedConditions.elementToBeClickable(header.getHoursLink()));
        header.getHoursLink().click();

        assertEquals(driver.getCurrentUrl(), "http://localhost:" + port + "/openingTimes.html");
        if (!(driver.getCurrentUrl().equals("http://localhost:" + port + "/openingTimes.html"))){
            test.log(LogStatus.FAIL, "Header Hours Link: FAIL!");
            Assert.fail();
        } else {
            test.log(LogStatus.PASS, "Header Hours Link: PASS!");
        }

        wait.until(ExpectedConditions.elementToBeClickable(header.getBurgerMenu()));
        header.getBurgerMenu().click();
        wait.until(ExpectedConditions.elementToBeClickable(header.getLocationLink()));
        header.getLocationLink().click();

        assertEquals(driver.getCurrentUrl(), "http://localhost:" + port + "/location.html");
        if (!(driver.getCurrentUrl().equals("http://localhost:" + port + "/location.html"))){
            test.log(LogStatus.FAIL, "Header location Link: FAIL!");
            Assert.fail();
        } else {
            test.log(LogStatus.PASS, "Header location Link: PASS!");
        }

        wait.until(ExpectedConditions.elementToBeClickable(header.getBurgerMenu()));
        header.getBurgerMenu().click();
        wait.until(ExpectedConditions.elementToBeClickable(header.getContactLink()));
        header.getContactLink().click();

        assertEquals(driver.getCurrentUrl(), "http://localhost:" + port + "/contactUs.html");
        if (!(driver.getCurrentUrl().equals("http://localhost:" + port + "/contactUs.html"))){
            test.log(LogStatus.FAIL, "Header Contact Us Link: FAIL!");
            Assert.fail();
        } else {
            test.log(LogStatus.PASS, "Header Contact Us Link: PASS!");
        }

        wait.until(ExpectedConditions.elementToBeClickable(header.getBurgerMenu()));
        header.getBurgerMenu().click();
        wait.until(ExpectedConditions.elementToBeClickable(header.getBookTickets()));
        header.getBookTickets().click();

        assertEquals(driver.getCurrentUrl(), "http://localhost:" + port + "/bookingTickets.html");
        if (!(driver.getCurrentUrl().equals("http://localhost:" + port + "/bookingTickets.html"))){
            test.log(LogStatus.FAIL, "Header Booking Link: FAIL!");
            Assert.fail();
        } else {
            test.log(LogStatus.PASS, "Header Booking Link: PASS!");
        }

    }

    @Test
    public void SeleniumFooterTest() throws InterruptedException {
        test = report.startTest("Start Selenium Test for Footer");
        driver.manage().window().maximize();
        test.log(LogStatus.INFO, "Browser started");
        driver.get("http://localhost:"+ port +"/homepage.html");
        HeaderFooterSeleniumElements footer = PageFactory.initElements(driver, HeaderFooterSeleniumElements.class);
        WebDriverWait wait = new WebDriverWait(driver, 2);

        wait.until(ExpectedConditions.elementToBeClickable(footer.getInfoLink()));
        footer.getInfoLink().click();
        assertEquals(driver.getCurrentUrl(), "http://localhost:" + port + "/aboutUsPage.html");
        if (!(driver.getCurrentUrl().equals("http://localhost:" + port + "/aboutUsPage.html"))){
            test.log(LogStatus.FAIL, "Footer Info Link: FAIL!");
            Assert.fail();
        } else {
            test.log(LogStatus.PASS, "Footer Info Link: PASS!");
        }

        wait.until(ExpectedConditions.elementToBeClickable(footer.getWebsiteLink()));
        footer.getWebsiteLink().click();
        assertEquals(driver.getCurrentUrl(), "http://localhost:" + port + "/webDev.html");
        if (!(driver.getCurrentUrl().equals("http://localhost:" + port + "/webDev.html"))){
            test.log(LogStatus.FAIL, "Footer Website Development Link: FAIL!");
            Assert.fail();
        } else {
            test.log(LogStatus.PASS, "Footer Website Development Link: PASS!");
        }

        wait.until(ExpectedConditions.elementToBeClickable(footer.getProcessLink()));
        footer.getProcessLink().click();
        assertEquals(driver.getCurrentUrl(), "http://localhost:" + port + "/productionProcess.html");
        if (!(driver.getCurrentUrl().equals("http://localhost:" + port + "/productionProcess.html"))){
            test.log(LogStatus.FAIL, "Footer Production Process Link: FAIL!");
            Assert.fail();
        } else {
            test.log(LogStatus.PASS, "Footer Production Process Link: PASS!");
        }
        
        wait.until(ExpectedConditions.elementToBeClickable(footer.getContactLinkFooter()));
        footer.getContactLinkFooter().click();
        assertEquals(driver.getCurrentUrl(), "http://localhost:" + port + "/contactUs.html");
        if (!(driver.getCurrentUrl().equals("http://localhost:" + port + "/contactUs.html"))){
            test.log(LogStatus.FAIL, "Footer Contact Us Link: FAIL!");
            Assert.fail();
        } else {
            test.log(LogStatus.PASS, "Footer Contact Us Link: PASS!");
        }
        
        wait.until(ExpectedConditions.elementToBeClickable(footer.getFindUsLink()));
        footer.getFindUsLink().click();
        assertEquals(driver.getCurrentUrl(), "http://localhost:" + port + "/location.html");
        if (!(driver.getCurrentUrl().equals("http://localhost:" + port + "/location.html"))){
            test.log(LogStatus.FAIL, "Footer Location Link: FAIL!");
            Assert.fail();
        } else {
            test.log(LogStatus.PASS, "Footer Location Link: PASS!");
        }
                
        wait.until(ExpectedConditions.elementToBeClickable(footer.getClassLink()));
        footer.getClassLink().click();
        assertEquals(driver.getCurrentUrl(), "http://localhost:" + port + "/filmClassifications.html");
        if (!(driver.getCurrentUrl().equals("http://localhost:" + port + "/filmClassifications.html"))){
            test.log(LogStatus.FAIL, "Footer Film Classifications Link: FAIL!");
            Assert.fail();
        } else {
            test.log(LogStatus.PASS, "Footer Film Classifications Link: PASS!");
        }
    }
    
    @After
    public void getResult(){
        driver.close();
        report.endTest(test);
    }

    @AfterClass
    public static void endReport(){
        report.flush();
        report.close();
    }


}