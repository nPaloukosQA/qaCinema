package com.qa.selenium;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static java.lang.Thread.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HeaderFooterSeleniumTests extends JUnitTestReporter {
    
    @LocalServerPort
    static String port;

    static WebDriver driver;

    
    @Before
    public void driverSetUp(){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        ChromeOptions opts = new ChromeOptions();
        driver = new ChromeDriver(opts);
        System.out.println("heya!");
    }

    @Test
	public void htmlsampleTest0() {
		assertTrue(1 < 2);
	}

    @Test
    public void seleniumHeaderTest() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("http://127.0.0.1:"+ port +"/src/main/resources/static/homepage.html");
        sleep(2000);
        WebElement burgerMenu = driver.findElement(By.id("headerBurgerMenu"));
        burgerMenu.click();
        sleep(2000);
        WebElement headerFilmsLink = driver.findElement(By.id("headerLinkFilms"));
        headerFilmsLink.click();
        sleep(3000);
        assertTrue(driver.getCurrentUrl().contentEquals("http:127.0.0.1:" + port + "/src/main/resources/static/filmsPage.html"));
        // WebElement headerLogoLink = driver.findElement(By.id("headerLogoLink"));
        // headerLogoLink.click();
        // sleep(3000);
        // burgerMenu = driver.findElement(By.id("headerBurgerMenu"));
        // burgerMenu.click();
        // sleep(2000);
        // WebElement headerScreensLink = driver.findElement(By.id("headerLinkScreen"));
        // headerScreensLink.click();
        // sleep(3000);
        // burgerMenu = driver.findElement(By.id("headerBurgerMenu"));
        // burgerMenu.click();
        // sleep(2000);
        // WebElement headerAboutLink = driver.findElement(By.id("headerLinkAbout"));
        // headerAboutLink.click();
        // sleep(3000);
    }

    // @Test
    // public void SeleniumFooterTest() throws InterruptedException {
    //     driver.manage().window().maximize();
    //     driver.get("http://127.0.0.1:5500/src/main/resources/static/homepage.html");
    //     sleep(2000);
    //     WebElement footerAboutUsLink = driver.findElement(By.id("footerLinkInformation"));
    //     footerAboutUsLink.click();
    //     sleep(3000);
    //     sleep(2000);
    //     WebElement footerLogoLink = driver.findElement(By.id("footerLinkLogo"));
    //     footerLogoLink.click();
    //     sleep(3000);
    // }
    
    @After
    public void getResult(){
        driver.close();
    }

}