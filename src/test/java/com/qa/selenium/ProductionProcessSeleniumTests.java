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
public class ProductionProcessSeleniumTests {

    @LocalServerPort
    private int port;

    private WebDriver driver;
    static ExtentReports report;
    ExtentTest test;

    @BeforeClass
    public static void reportSetup(){
        report = new ExtentReports ("test-output" + File.separator + "Report-dan-productionProcess.html", true);
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
    public void seleniumProductionProcessCarouselTest() throws InterruptedException {
        test = report.startTest("Start Selenium Test for Production Process Page");
        driver.manage().window().maximize();
        test.log(LogStatus.INFO, "Browser started");
        driver.get("http://localhost:"+ port +"/productionProcess.html");
        ProductionProcessSeleniumElements prodProg = PageFactory.initElements(driver, ProductionProcessSeleniumElements.class);
        WebDriverWait wait = new WebDriverWait(driver, 2);

        wait.until(ExpectedConditions.elementToBeClickable(prodProg.getRightControl()));
        prodProg.getRightControl().click();
        sleep(1000);
        if (!(prodProg.getImgTwo().isDisplayed())){
            test.log(LogStatus.FAIL, "FAIL!");
            Assert.fail();
        } else {
            test.log(LogStatus.PASS, "PASS!");
        }
        sleep(1000);

        wait.until(ExpectedConditions.elementToBeClickable(prodProg.getRightControl()));
        prodProg.getRightControl().click();
        sleep(1000);
        if (!(prodProg.getImgThree().isDisplayed())){
            test.log(LogStatus.FAIL, "FAIL!");
            Assert.fail();
        } else {
            test.log(LogStatus.PASS, "PASS!");
        }
        sleep(1000);

        wait.until(ExpectedConditions.elementToBeClickable(prodProg.getRightControl()));
        prodProg.getRightControl().click();
        sleep(1000);
        if (!(prodProg.getImgFour().isDisplayed())){
            test.log(LogStatus.FAIL, "FAIL!");
            Assert.fail();
        } else {
            test.log(LogStatus.PASS, "PASS!");
        }
        sleep(1000);

        wait.until(ExpectedConditions.elementToBeClickable(prodProg.getRightControl()));
        prodProg.getRightControl().click();
        sleep(1000);
        if (!(prodProg.getImgFive().isDisplayed())){
            test.log(LogStatus.FAIL, "FAIL!");
            Assert.fail();
        } else {
            test.log(LogStatus.PASS, "PASS!");
        }
        sleep(1000);

        wait.until(ExpectedConditions.elementToBeClickable(prodProg.getRightControl()));
        prodProg.getRightControl().click();
        sleep(1000);
        if (!(prodProg.getImgSix().isDisplayed())){
            test.log(LogStatus.FAIL, "FAIL!");
            Assert.fail();
        } else {
            test.log(LogStatus.PASS, "PASS!");
        }
        sleep(1000);

        wait.until(ExpectedConditions.elementToBeClickable(prodProg.getRightControl()));
        prodProg.getRightControl().click();
        sleep(1000);
        if (!(prodProg.getImgSeven().isDisplayed())){
            test.log(LogStatus.FAIL, "FAIL!");
            Assert.fail();
        } else {
            test.log(LogStatus.PASS, "PASS!");
        }
        sleep(1000);

        wait.until(ExpectedConditions.elementToBeClickable(prodProg.getRightControl()));
        prodProg.getRightControl().click();
        sleep(1000);
        if (!(prodProg.getImgEight().isDisplayed())){
            test.log(LogStatus.FAIL, "FAIL!");
            Assert.fail();
        } else {
            test.log(LogStatus.PASS, "PASS!");
        }
        sleep(1000);

        wait.until(ExpectedConditions.elementToBeClickable(prodProg.getRightControl()));
        prodProg.getRightControl().click();
        sleep(1000);
        if (!(prodProg.getImgNine().isDisplayed())){
            test.log(LogStatus.FAIL, "Final image in carousel is not viable: Result FAIL!");
            Assert.fail();
        } else {
            test.log(LogStatus.PASS, "Final image in carousel is viable: Result PASS!");
        }
    }

    @Test
    public void seleniumProductionProcessInternalLinkTest() throws InterruptedException {
        test = report.startTest("Start Selenium Test for Production Process Page");
        driver.manage().window().maximize();
        test.log(LogStatus.INFO, "Browser started");
        driver.get("http://localhost:"+ port +"/productionProcess.html");
        ProductionProcessSeleniumElements prodProg = PageFactory.initElements(driver, ProductionProcessSeleniumElements.class);
        WebDriverWait wait = new WebDriverWait(driver, 2);

        wait.until(ExpectedConditions.elementToBeClickable(prodProg.getLeftControl()));
        prodProg.getLeftControl().click();
        sleep(1000);

        wait.until(ExpectedConditions.elementToBeClickable(prodProg.getDevLink()));
        prodProg.getDevLink().click();
        sleep(1000);

        assertEquals(driver.getCurrentUrl(), "http://localhost:"+ port +"/webDev.html");
        if (!(driver.getCurrentUrl().equals("http://localhost:"+ port +"/webDev.html"))){
            test.log(LogStatus.FAIL, "Final image in carousel is not viable: Result FAIL!");
            Assert.fail();
        } else {
            test.log(LogStatus.PASS, "Final image in carousel is viable: Result PASS!");
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