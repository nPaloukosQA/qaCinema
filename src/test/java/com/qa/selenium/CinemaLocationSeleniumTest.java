package com.qa.selenium;

import static org.junit.Assert.assertFalse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
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

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CinemaLocationSeleniumTest extends JUnitTestReporter {

    private WebDriver driver;

    @LocalServerPort
    private String port;

    @Before
    public void init() {
       System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        ChromeOptions opts = new ChromeOptions();
        driver = new ChromeDriver(opts);
        System.out.println("heya!");
    }

    @After
    public void driverClose() {
        driver.close();
    }

    @Test
    public void testOldTraffordLink() {
        driver.manage().window().maximize();
        driver.get("http:localhost:" + port);
        CinemaLocationSeleniumElements locationPage = PageFactory.initElements(driver, CinemaLocationSeleniumElements.class);

        locationPage.clickOldTraffordLink();

        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.urlMatches("https://www.manutd.com/en/visit-old-trafford") );
        assertFalse(driver.getCurrentUrl().contentEquals("http:localhost:\" + port"));
    }

}

