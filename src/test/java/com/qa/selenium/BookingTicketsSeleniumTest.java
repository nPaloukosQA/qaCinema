package com.qa.selenium;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.junit.*;
import org.junit.platform.engine.TestExecutionResult;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.*;
import static org.testng.AssertJUnit.assertEquals;

/////////////////////////////////////////////////////////////////////////////////////

//  Test Ignored due to PayPal putting in measures to stop automatic testing

////////////////////////////////////////////////////////////////////////////////////

@Ignore
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
        command.getFilmsSelector().click();
        command.getDateSelector().click();
        command.getTimeSelector().click();
        command.getInputOfAdults().clear();
        command.getInputOfAdults().sendKeys("1");
        command.getInputOfChildren().clear();
        command.getInputOfChildren().sendKeys("0");
        command.getInputOfConcession().clear();
        command.getInputOfConcession().sendKeys("0");

//        seatPicker non clickable for some reason

//        sleep(3000);
//        command.getSeatPicker().click();
//        sleep(2000);
//        command.getB01().click();

        command.getPaypalButton().click();
        //sleep(6000);
//        List<String> tabs = new ArrayList<String>(driver.getWindowHandles());
//        driver.switchTo().window(tabs.get(1));

        assertEquals(driver.getCurrentUrl(), "http://localhost:" + port + "/bookingTickets.html");
        if (!(driver.getCurrentUrl().equals("http://localhost:" + port + "/bookingTickets.html"))){
            test.log(LogStatus.PASS, "Could not navigate external link Three: Result FAIL!");
            Assert.fail();
        } else {
            test.log(LogStatus.FAIL, "Successfully navigated using external link Three: Result PASS!");
        }

    }
//        option one - find xpath of email box to input email
//        driver.findElement(By.xpath("input#email.hasHelp.validate.validateEmpty")).click();

//        option two - try to make test realise there is content under iframe
//        WebElement myelement = driver.findElement(By.id("email"));
//        JavascriptExecutor jse2 = (JavascriptExecutor)driver;
//        jse2.executeScript("arguments[0].scrollIntoView()", myelement);
//
////        this click below is unreachable due to the IFrame
//
//        wait.until(ExpectedConditions.elementToBeClickable(command.getPayPalMail()));
//        command.getPayPalMail().click();
//        command.getPayPalMail().sendKeys("sb-myeb71983917@personal.example.com");
//        sleep(1000);
//        command.getPayPalPassword().sendKeys("16?+dnW!");
//        sleep(1000);
//        command.getPaymentBtn().click();
//        sleep(1000);

//      enter funtions to show payment recieved window pop-up to complete test

//    }

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
