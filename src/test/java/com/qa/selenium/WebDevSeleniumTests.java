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
import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;
import static org.testng.AssertJUnit.assertEquals;

//import org.testng.ITestResult;
//import org.testng.annotations.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class WebDevSeleniumTests {

    @LocalServerPort
    private int port;

    private WebDriver driver;
    static ExtentReports report;
    ExtentTest test;

    @BeforeClass
    public static void reportSetup(){
        report = new ExtentReports ("test-output" + File.separator + "Report-dan-webDev.html", true);
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
    public void seleniumWebDevCarouselTest() throws InterruptedException {
        test = report.startTest("Start Selenium Test for Web Dev Page");
        driver.manage().window().maximize();
        test.log(LogStatus.INFO, "Browser started");
        driver.get("http://localhost:"+ port +"/webDev.html");
        WebDevSeleniumElements webDev = PageFactory.initElements(driver, WebDevSeleniumElements.class);
        WebDriverWait wait = new WebDriverWait(driver, 2);

        wait.until(ExpectedConditions.elementToBeClickable(webDev.getRightControl()));
        webDev.getRightControl().click();
        sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(webDev.getRightControl()));
        webDev.getRightControl().click();
        sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(webDev.getRightControl()));
        webDev.getRightControl().click();
        sleep(1000);

        if (!(webDev.getDanPic().isDisplayed())){
            test.log(LogStatus.FAIL, "Final image in carousel is not viable: Result FAIL!");
            Assert.fail();
        } else {
            test.log(LogStatus.PASS, "Final image in carousel is viable: Result PASS!");
        }
    }

    @Test
    public void seleniumWebDevSocialLinkTest() throws InterruptedException {
        test = report.startTest("Start Selenium Test for Web Dev Page");
        driver.manage().window().maximize();
        test.log(LogStatus.INFO, "Browser started");
        driver.get("http://localhost:"+ port +"/webDev.html");
        WebDevSeleniumElements webDev = PageFactory.initElements(driver, WebDevSeleniumElements.class);
        WebDriverWait wait = new WebDriverWait(driver, 2);

        wait.until(ExpectedConditions.elementToBeClickable(webDev.getRightControl()));
        webDev.getRightControl().click();
        sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(webDev.getRightControl()));
        webDev.getRightControl().click();
        sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(webDev.getRightControl()));
        webDev.getRightControl().click();
        sleep(1000);

        wait.until(ExpectedConditions.elementToBeClickable(webDev.getDanPic()));
        webDev.getDanPic().click();

        assertEquals(driver.getCurrentUrl(), "http://localhost:"+ port +"/webDev.html");
        if (!(driver.getCurrentUrl().equals("http://localhost:"+ port +"/webDev.html"))){
            test.log(LogStatus.PASS, "Found linkedIn page when image clicked: Result PASS!");
            Assert.fail();
        } else {
            test.log(LogStatus.FAIL, "Did not find linkedIn page when image clicked: Result FAIL!");
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