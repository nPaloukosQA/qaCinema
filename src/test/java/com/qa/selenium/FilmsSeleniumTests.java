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

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import static org.testng.AssertJUnit.assertEquals;

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
        this.driver = new ChromeDriver(opts);
    }

    @Test
    public void filmsTest() throws InterruptedException {
        test = report.startTest("Start Selenium Test for Header");
        driver.manage().window().maximize();
        test.log(LogStatus.INFO, "Browser started");
        driver.get("http://localhost:"+ port +"/homepage.html");
        HeaderFooterSeleniumElements header = PageFactory.initElements(driver, HeaderFooterSeleniumElements.class);
        WebDriverWait wait = new WebDriverWait(driver, 2);

        
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