package com.qa.selenium;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.File;

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


}
