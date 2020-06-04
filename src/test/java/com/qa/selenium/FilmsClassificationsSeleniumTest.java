package com.qa.selenium;

import com.mysql.cj.x.protobuf.MysqlxCursor;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.junit.*;
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

import java.io.File;

import static java.lang.Thread.sleep;
import static org.testng.AssertJUnit.assertEquals;

//import org.testng.ITestResult;
//import org.testng.annotations.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class FilmsClassificationsSeleniumTest {

    @LocalServerPort
    private int port;

    private WebDriver driver;
    static ExtentReports report;
    ExtentTest test;

    @BeforeClass
    public static void reportSetup(){
        report = new ExtentReports ("test-output" + File.separator + "Report-dan-filmClassifications.html", true);
        report
                .addSystemInfo("Host Name", "QA")
                .addSystemInfo("Environment", "Automated Testing")
                .addSystemInfo("User Name", "Dan");
        report.loadConfig(new File("extent-config.xml"));

    }

    @Before
    public void driverSetUp(){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        ChromeOptions opts = new ChromeOptions();
        this.driver = new ChromeDriver(opts);
    }

    @Test
    public void seleniumFilmClassificationLinkOneTest() throws InterruptedException {
        test = report.startTest("Start Selenium Test for Film Classifications link One Page");
        driver.manage().window().maximize();
        test.log(LogStatus.INFO, "Browser started");
        driver.get("http://localhost:"+ port +"/filmClassifications.html");
        FilmsClassificationsSeleniumElements classPage = PageFactory.initElements(driver, FilmsClassificationsSeleniumElements.class);
        WebDriverWait wait = new WebDriverWait(driver, 2);

        wait.until(ExpectedConditions.elementToBeClickable(classPage.getExternalLinkTwo()));
        assertEquals(driver.getCurrentUrl(), "http://localhost:"+ port +"/filmClassifications.html");
        classPage.getExternalLinkTwo().click();
        sleep(2000);

        assertEquals(driver.getCurrentUrl(), "https://www.bbfc.co.uk/");
        if (!(driver.getCurrentUrl().equals("https://www.bbfc.co.uk/"))){
            test.log(LogStatus.FAIL, "Could not navigate external link Two: Result FAIL!");
            Assert.fail();
        } else {
            test.log(LogStatus.PASS, "Successfully navigated using external link Two: Result PASS!");
        }
    }

    @Test
    public void seleniumFilmClassificationPageTestOne() throws InterruptedException{
        test = report.startTest("Start Selenium Test for Film Classifications Page Link One");
        driver.manage().window().maximize();
        test.log(LogStatus.INFO, "Browser started");
        driver.get("http://localhost:"+ port +"/filmClassifications.html");
        FilmsClassificationsSeleniumElements classPage = PageFactory.initElements(driver, FilmsClassificationsSeleniumElements.class);
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.elementToBeClickable(classPage.getExternalLinkTwo()));
        assertEquals(driver.getCurrentUrl(), "http://localhost:" + port + "/filmClassifications.html");
        classPage.getExternalLinkTwo().click();
        sleep(2000);
        assertEquals(driver.getCurrentUrl(), "https://www.bbfc.co.uk/");
        if (!(driver.getCurrentUrl().equals("https://www.bbfc.co.uk/"))){
            test.log(LogStatus.FAIL, "FAIL!");
            Assert.fail();
        } else {
            test.log(LogStatus.INFO, "PASS!");
        }
    }

    @Test
    public void seleniumFilmClassificationLinkTwoTest() throws InterruptedException {
        test = report.startTest("Start Selenium Test for Film Classifications link Two Page");
        driver.manage().window().maximize();
        test.log(LogStatus.INFO, "Browser started");
        driver.get("http://localhost:" + port + "/filmClassifications.html");
        FilmsClassificationsSeleniumElements classPage = PageFactory.initElements(driver, FilmsClassificationsSeleniumElements.class);
        WebDriverWait wait = new WebDriverWait(driver, 2);

        wait.until(ExpectedConditions.elementToBeClickable(classPage.getClassLink()));
        classPage.getClassLink().click();

        wait.until(ExpectedConditions.elementToBeClickable(classPage.getExternalLinkThree()));
        classPage.getExternalLinkThree().click();
        sleep(2000);
        assertEquals(driver.getCurrentUrl(), "https://www.britinfo.net/cinema/film-classification.htm");
        if (!(driver.getCurrentUrl().equals("https://www.britinfo.net/cinema/film-classification.htm"))){
            test.log(LogStatus.FAIL, "Could not navigate external link Three: Result FAIL!");
            Assert.fail();
        } else {
            test.log(LogStatus.PASS, "Successfully navigated using external link Three: Result PASS!");
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