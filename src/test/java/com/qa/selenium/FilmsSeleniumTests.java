package com.qa.selenium;
import org.hibernate.annotations.SourceType;
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
import org.openqa.selenium.support.FindBy;
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

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class FilmsSeleniumTests {
    
    @LocalServerPort
    private int port;

    private WebDriver driver;
    static ExtentReports report;
    ExtentTest test;

    @BeforeClass
    public static void reportSetup(){
        report = new ExtentReports ("test-output" + File.separator + "Report-luke-films.html", true);
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
        opts.setHeadless(true);
        this.driver = new ChromeDriver(opts);
    }

    @Test
    public void CarouselTests() throws InterruptedException {
        test = report.startTest("Start Selenium Test for HomePage Carousel");
        driver.manage().window().maximize();
        test.log(LogStatus.INFO, "Browser started");
        driver.get("http://localhost:"+ port +"/homepage.html");
        FilmsSeleniumElements films = PageFactory.initElements(driver, FilmsSeleniumElements.class);
        WebDriverWait wait = new WebDriverWait(driver, 2);
        Thread.sleep(3000);

        wait.until(ExpectedConditions.elementToBeClickable(films.getCarouselRight()));
        if (!(driver.getCurrentUrl().equals("http://localhost:" + port + "/homepage.html"))){
            test.log(LogStatus.FAIL, "Home Page Loaded: FAIL!");
            Assert.fail();
        } else {
            test.log(LogStatus.PASS, "Home Page Loaded: PASS!");
        }
        assertEquals(driver.getCurrentUrl(), "http://localhost:" + port + "/homepage.html");
        films.getCarouselRight().click();
        Thread.sleep(1000);
        WebElement image1 = driver.findElement(By.id("carouselImage1"));
        Thread.sleep(1000);
        if (!(image1.isDisplayed())){
            test.log(LogStatus.FAIL, "Films carousel right button: FAIL!");
            Assert.fail();
        } else {
            test.log(LogStatus.PASS, "Films carousel right button: PASS!");
        }
        assertTrue(image1.isDisplayed());

        films.getCarouselLeft().click();
        Thread.sleep(1000);
        WebElement image0 = driver.findElement(By.id("carouselImage0"));
        Thread.sleep(1000);
        if (!(image0.isDisplayed())){
            test.log(LogStatus.FAIL, "Films carousel left button: FAIL!");
            Assert.fail();
        } else {
            test.log(LogStatus.PASS, "Films carousel left button: PASS!");
        }
        assertTrue(image0.isDisplayed());

        films.getCarouselRight().click();
        Thread.sleep(1000);
        films.getCarouselRight().click();
        Thread.sleep(1000);
        WebElement image2 = driver.findElement(By.id("carouselImage2"));
        Thread.sleep(1000);
        image2.click();
        Thread.sleep(2000);

        if (!(driver.getCurrentUrl().equals("http://localhost:" + port + "/filmInfoPage.html?omdbid=tt0080684&id=3"))){
            test.log(LogStatus.FAIL, "Film Info Page Loaded: FAIL!");
            Assert.fail();
        } else {
            test.log(LogStatus.PASS, "Film Info Page Loaded: PASS!");
        }
        assertEquals(driver.getCurrentUrl(), "http://localhost:" + port + "/filmInfoPage.html?omdbid=tt0080684&id=3");
    }

    @Test
    public void FilmInfoButtonTests() throws InterruptedException {
        test = report.startTest("Start Selenium Test for film info page");
        driver.manage().window().maximize();
        test.log(LogStatus.INFO, "Browser started");
        driver.get("http://localhost:"+ port +"/filmInfoPage.html?omdbid=tt0080684&id=3");
        FilmsSeleniumElements films = PageFactory.initElements(driver, FilmsSeleniumElements.class);
        WebDriverWait wait = new WebDriverWait(driver, 2);

        wait.until(ExpectedConditions.attributeToBe(films.getFilmTicketsButton(), "href", "http://localhost:" + port + "/bookingTickets.html?id=3"));
        if (!(driver.getCurrentUrl().equals("http://localhost:" + port + "/filmInfoPage.html?omdbid=tt0080684&id=3"))){
            test.log(LogStatus.FAIL, "Film Info Page Loaded: FAIL!");
            Assert.fail();
        } else {
            test.log(LogStatus.PASS, "Film Info Page Loaded: PASS!");
        }
        assertEquals(driver.getCurrentUrl(), "http://localhost:" + port + "/filmInfoPage.html?omdbid=tt0080684&id=3");

        films.getFilmTicketsButton().click();
        BookingTicketsSeleniumElements tickets = PageFactory.initElements(driver, BookingTicketsSeleniumElements.class);
        wait.until(ExpectedConditions.elementToBeClickable(tickets.getFname()));
        System.out.println(driver.getCurrentUrl());
        if (!(driver.getCurrentUrl().equals("http://localhost:" + port + "/bookingTickets.html?id=3"))){
            test.log(LogStatus.FAIL, "Tickets Page Loaded: FAIL!");
            Assert.fail();
        } else {
            test.log(LogStatus.PASS, "Tickets Page Loaded: PASS!");
        }
        assertEquals(driver.getCurrentUrl(), "http://localhost:" + port + "/bookingTickets.html?id=3");

    }

    @Test
    public void filmInfoClassButtonTests() throws InterruptedException {
        test = report.startTest("Start Selenium Test for film info page");
        driver.manage().window().maximize();
        test.log(LogStatus.INFO, "Browser started");
        driver.get("http://localhost:"+ port +"/filmInfoPage.html?omdbid=tt0080684&id=3");
        FilmsSeleniumElements films = PageFactory.initElements(driver, FilmsSeleniumElements.class);
        WebDriverWait wait = new WebDriverWait(driver, 2);

        wait.until(ExpectedConditions.attributeToBe(films.getFilmTicketsButton(), "href", "http://localhost:" + port + "/bookingTickets.html?id=3"));
        if (!(driver.getCurrentUrl().equals("http://localhost:" + port + "/filmInfoPage.html?omdbid=tt0080684&id=3"))){
            test.log(LogStatus.FAIL, "Film Info Page Loaded: FAIL!");
            Assert.fail();
        } else {
            test.log(LogStatus.PASS, "Film Info Page Loaded: PASS!");
        }
        assertEquals(driver.getCurrentUrl(), "http://localhost:" + port + "/filmInfoPage.html?omdbid=tt0080684&id=3");

        films.getFilmCertImg().click();
        FilmsClassificationsSeleniumElements cert = PageFactory.initElements(driver, FilmsClassificationsSeleniumElements.class);
        wait.until(ExpectedConditions.elementToBeClickable(cert.getClassLink()));
        System.out.println(driver.getCurrentUrl());
        if (!(driver.getCurrentUrl().equals("http://localhost:" + port + "/filmClassifications.html"))){
            test.log(LogStatus.FAIL, "Film Cert Page Loaded: FAIL!");
            Assert.fail();
        } else {
            test.log(LogStatus.PASS, "Film Cert Page Loaded: PASS!");
        }
        assertEquals(driver.getCurrentUrl(), "http://localhost:" + port + "/filmClassifications.html");
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