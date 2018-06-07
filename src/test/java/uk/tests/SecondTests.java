package uk.tests;

import org.junit.*;
import org.junit.runners.Suite;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@Suite.SuiteClasses({SecondTests.class})
public class SecondTests {
    WebDriver driver;

    @BeforeClass
    public static void beforeClass(){
        //before class
    }

    @Before
    public void beforeTest(){
        //before test
    }

    @Test  //JUnit
    //@Ignore
    public void test1() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("http://book.theautomatedtester.co.uk/");
        Thread.sleep(2000);

        WebElement firstLink = driver.findElement(By.xpath("//a[text()='Chapter1']"));
        firstLink.click();
        Thread.sleep(2000);

        WebElement radioButton = driver.findElement(By.id("radiobutton"));
        radioButton.click();

        assertTrue("Error Message", radioButton.isDisplayed());

        /*
        check following website for more JUnit Assert functions:
        http://junit.sourceforge.net/javadoc/org/junit/Assert.html
         */

    }
    @Test  //JUnit
    public void test2() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("http://book.theautomatedtester.co.uk/");
        Thread.sleep(2000);

        WebElement firstLink = driver.findElement(By.xpath("//a[text()='Chapter1']"));
        firstLink.click();
        Thread.sleep(2000);

        WebElement homePageLink = driver.findElement(By.xpath("//a[text()='Home Page']"));
        homePageLink.click();
        Thread.sleep(2000);

        WebElement chapterLink = driver.findElement(By.linkText("Chapter1"));
        String chapterLinkText = chapterLink.getText();

        assertEquals("Error Message", chapterLinkText, "Chapter1");

    }

    @After
    public void afterTest(){
        driver.quit();
    }

    @AfterClass
    public static void afterClass(){
        //After class
    }

//    @org.testng.annotations.Test
//    public void test3(){
//
//        WebElement firstLink = driver.findElement(By.xpath("//a[text()='Chapter1']"));
//        firstLink.click();
//
//        WebElement selectElement = getWebDriver().findElement(By.id("selecttype"));
//        Select select = new Select(selectElement);
//        select.selectByValue("Selenium Grid");
//
//        String expectedText = "The following text has been loaded from another page on this site. It has been loaded in an asynchronous fashion so that we can work through the AJAX section of this chapter";
//
//        WebElement linkAjax = driver.findElement(By.id("loadajax"));
//        linkAjax.click();
//
//        WebElement textAreaAjax = driver.findElement(By.id("ajaxdiv"));
//        org.testng.Assert.assertTrue(textAreaAjax.isDisplayed());
//
//        webDriverWait.until(ExpectedConditions.textToBePresentInElement(textAreaAjax, expectedText)); //Waits up to 10 seconds until element is not present
//        assertEquals(textAreaAjax.getText(), expectedText);
//
//    }

}
