package com.qa.selenium;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
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
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ContactUsSeleniumTest {

    @LocalServerPort
    private int port;

    private WebDriver driver;
    static ExtentReports report;
    ExtentTest test;

    @BeforeClass
    public static void reportSetup(){
        report = new ExtentReports ("test-output" + File.separator + "Report/Matt.html", true);
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
    public void SendEmailSeleniumTest() throws InterruptedException{
        test = report.startTest("Start Selenium Test for sending an email");
        driver.manage().window().maximize();
        test.log(LogStatus.INFO, "Browser started");
        driver.get("http://localhost:"+ port +"/contactUs.html");
        ContactUsSeleniumElements contactUsPage = PageFactory.initElements(driver, ContactUsSeleniumElements.class);
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.elementToBeClickable(contactUsPage.getEmailAdress()));
        assertEquals(driver.getCurrentUrl(), "http://localhost:" + port + "/contactUs.html");
        contactUsPage.sendEmail("dunnagebay103@gmail.com", "first name", "last name",
                "this is a selenium test");
        sleep(3000);
        assertNotEquals(driver.getCurrentUrl(), "http://localhost:" + port + "/contactUs.html");
        contactUsPage.getFormSpreeLink().click();
        sleep(2000);
        assertEquals(driver.getCurrentUrl(), "http://localhost:" + port + "/contactUs.html");
        if (!(driver.getCurrentUrl().equals("http://localhost:" + port + "/contactUs.html"))){
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
