package com.qa.selenium;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertFalse;
import static org.testng.AssertJUnit.assertEquals;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.junit.*;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
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

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CinemaLocationSeleniumTest {

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
                .addSystemInfo("User Name", "Matt");
        report.loadConfig(new File("extent-config.xml"));

    }

    @Before
    public void driverSetUp(){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        ChromeOptions opts = new ChromeOptions();
        this.driver = new ChromeDriver(opts);
    }

    @Test
    public void seleniumLocationOldTraffordLinkTest() throws InterruptedException{
        test = report.startTest("Start Selenium Test for Old Trafford Link");
        driver.manage().window().maximize();
        test.log(LogStatus.INFO, "Browser started");
        driver.get("http://localhost:"+ port +"/location.html");
        CinemaLocationSeleniumElements locationPage = PageFactory.initElements(driver, CinemaLocationSeleniumElements.class);
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.elementToBeClickable(locationPage.getOldTraffordLink()));
        assertEquals(driver.getCurrentUrl(), "http://localhost:" + port + "/location.html");
        locationPage.getOldTraffordLink().click();
        sleep(2000);
        assertEquals(driver.getCurrentUrl(), "https://www.manutd.com/en/visit-old-trafford");
        if (!(driver.getCurrentUrl().equals("https://www.manutd.com/en/visit-old-trafford"))){
            test.log(LogStatus.FAIL, "FAIL!");
            Assert.fail();
        } else {
            test.log(LogStatus.INFO, "PASS!");
        }
    }

    @Test
    public void seleniumLocationIWMNorthLinkTest() throws InterruptedException{
        test = report.startTest("Start Selenium Test for IWM North Link");
        driver.manage().window().maximize();
        test.log(LogStatus.INFO, "Browser started");
        driver.get("http://localhost:"+ port +"/location.html");
        CinemaLocationSeleniumElements locationPage = PageFactory.initElements(driver, CinemaLocationSeleniumElements.class);
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.elementToBeClickable(locationPage.getiWMNorthLink()));
        assertEquals(driver.getCurrentUrl(), "http://localhost:" + port + "/location.html");
        locationPage.getiWMNorthLink().click();
        sleep(2000);
        assertEquals(driver.getCurrentUrl(), "https://www.iwm.org.uk/visits/iwm-north");
        if (!(driver.getCurrentUrl().equals("https://www.iwm.org.uk/visits/iwm-north"))){
            test.log(LogStatus.FAIL, "FAIL!");
            Assert.fail();
        } else {
            test.log(LogStatus.INFO, "PASS!");
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

