package uk;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait webDriverWait; // Declaration of Explicit Wait
    int timeout =10;

    @org.testng.annotations.BeforeClass
    public void beforeClass() {

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS); // Implicit Wait
        webDriverWait = new WebDriverWait(driver, timeout); //Explicit Wait
        driver.get("http://book.theautomatedtester.co.uk/");
    }

    protected WebDriver getWebDriver(){
        return driver;
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }

}