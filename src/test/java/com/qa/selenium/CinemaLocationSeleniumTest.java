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
import com.qa.selenium.CinemaLocationSeleniumElements;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CinemaLocationSeleniumTest {

    private WebDriver driver;

    @LocalServerPort
    private int port;

    @Before
    public void init() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\dunna\\IdeaProjects\\qaCinema\\chromedriver");
        ChromeOptions opts = new ChromeOptions();
//        opts.setHeadless(true);
        this.driver = new ChromeDriver(opts);
    }

    @After
    public void tearDown() {
        driver.quit();
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

