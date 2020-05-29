package com.qa.selenium;

import org.testng.ITestResult;
import org.testng.annotations.*;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
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
        sleep(2000);
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