package com.qa.selenium;


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
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;

import static java.lang.Thread.*;
import static org.testng.AssertJUnit.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BookingTicketsSeleniumTest {

    @LocalServerPort
    private int port;

    private WebDriver driver;
    static ExtentReports report;
    ExtentTest test;

    @BeforeClass
    public static void reportSetUp(){
        report = new ExtentReports("test-output" + File.separator + "Report.html", true);
        report
                .addSystemInfo("Host Name", "QA")
                .addSystemInfo("Environment", "Automated Testing")
                .addSystemInfo("User Name", "Nick");
        report.loadConfig(new File("extent-config.xml"));
    }

    @Before
    public void driverSetUp(){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        ChromeOptions opts = new ChromeOptions();
        this.driver = new ChromeDriver(opts);
    }

    @Test
    public void seleniumBookingTicketsTest() throws InterruptedException {
        test = report.startTest("Starting Selenium Test for BookingTickets");
        driver.manage().window().maximize();
        test.log(LogStatus.INFO, "Browser started");
        driver.get("http://localhost:" + port + "/homepage.html");
        BookingTicketsSeleniumElements command = PageFactory.initElements(driver, BookingTicketsSeleniumElements.class);
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.elementToBeClickable(command.getHeaderTicketsButton()));
        assertEquals(driver.getCurrentUrl(), "http://localhost:" + port + "/homepage.html");
        command.getHeaderTicketsButton().click();
        sleep(2000);
        test.log(LogStatus.INFO,"Starting to fill up information for booking tickets");
        command.getFname().sendKeys("Nick");
        command.getSname().sendKeys("Paloukos");
        command.getEmail().sendKeys("gmail@nick.com");
        command.getPhone().sendKeys("9182736450");
        command.getPostcode().sendKeys("WD4 0IS");
        command.getStd().isSelected();
        sleep(2000);
        command.getFilmsSelector().click();
        sleep(1000);
        command.getDateSelector().click();
        sleep(1000);
        command.getTimeSelector().click();
        sleep(1000);
        command.getInputOfAdults().clear();
        command.getInputOfAdults().sendKeys("1");
        command.getInputOfChildren().clear();
        command.getInputOfChildren().sendKeys("1");
        command.getInputOfConcession().clear();
        command.getInputOfConcession().sendKeys("1");

        command.getB01().click();
        command.getB02().click();
        command.getB03().click();
        command.getSubmitBtn().click();
        sleep(2000);

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
