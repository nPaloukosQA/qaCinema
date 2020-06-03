package com.qa.selenium;

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
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertFalse;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OpeningTimesSeleniumTest {

    private WebDriver driver;

    @LocalServerPort
    private int port;

    @Before
    public void init() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\dan\\intellij-workspace\\qaCinema\\chromedriver.exe");
        ChromeOptions opts = new ChromeOptions();
        //opts.setHeadless(true);
        this.driver = new ChromeDriver(opts);
    }

    @After
    public void teardown() {
        driver.quit();
    }

    @Test
    public void testOpeningTimesPage() {
        driver.manage().window().maximize();
        driver.get("http://localhost:" + port);
        OpeningTimesSeleniumElements openingTimes = PageFactory.initElements(driver, OpeningTimesSeleniumElements.class);

        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.textToBePresentInElement(openingTimes.getOpeningTimesTitle(), "Opening Times"));
        assertFalse(openingTimes.getOpeningTimesTitle().getText().isEmpty());
    }



}
