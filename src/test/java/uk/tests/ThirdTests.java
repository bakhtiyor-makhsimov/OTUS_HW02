package uk.tests;

        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.openqa.selenium.support.FindBy;
        import org.openqa.selenium.support.ui.ExpectedConditions;
        import org.openqa.selenium.support.ui.Select;
        import org.openqa.selenium.support.ui.WebDriverWait;
        import org.testng.Assert;
        import org.testng.annotations.*;
//import org.testng.annotations.DataProvider;

        import java.util.concurrent.TimeUnit;

        import static org.testng.Assert.assertEquals;
        import static org.testng.Assert.assertTrue;

@Listeners(TestListener.class)
public class ThirdTests {

    //Implementation of selenium.support annotation @FindBy
    @FindBy(xpath = "")
    WebElement element;

    WebDriver driver;
    WebDriverWait webDriverWait; // Declaration of Explicit Wait

    @BeforeClass
    public void beforeClass(){

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // Implicit Wait
        webDriverWait = new WebDriverWait(driver, 10); //Explicit Wait
    }

    @Test(enabled=true, groups = {"regression"}, dependsOnMethods = {"test2"}) //BM- Linking to Test Suites in texting.xml
    public void test1() throws InterruptedException {
//        driver = new ChromeDriver();
        driver.get("http://book.theautomatedtester.co.uk/");
        Thread.sleep(2000);


        WebElement firstLink = driver.findElement(By.xpath("//a[text()='Chapter1']"));
        firstLink.click();
        Thread.sleep(2000);

        WebElement radioButton = driver.findElement(By.id("radiobutton"));
        radioButton.click();

        Assert.assertTrue(radioButton.isDisplayed(), "Error Message");

//        driver.quit();

        /*
        check following website for more TestNG Assert functions:
        http://static.javadoc.io/org.testng/testng/6.11/org/testng/Assert.html
         */

    }
    @Test(enabled=true, groups = {"sanity", "regression"}) //dataProvider = "data_provider"
    public void test2() throws InterruptedException {
//        driver = new ChromeDriver();
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



//        driver.quit();

    }

    @Test
    public void test3() {

        driver.get("http://book.theautomatedtester.co.uk/");

        WebElement firstLink = driver.findElement(By.xpath("//a[text()='Chapter1']"));
        firstLink.click();

        WebElement selectElement = driver.findElement(By.id("selecttype"));
        Select select = new Select(selectElement);
        select.selectByValue("Selenium Grid");

        String expectedText = "The following text has been loaded from another page on this site. It has been loaded in an asynchronous fashion so that we can work through the AJAX section of this chapter";

        WebElement linkAjax = driver.findElement(By.id("loadajax"));
        linkAjax.click();

        WebElement textAreaAjax = driver.findElement(By.id("ajaxdiv"));
        assertTrue(textAreaAjax.isDisplayed());

        webDriverWait.until(ExpectedConditions.textToBePresentInElement(textAreaAjax, expectedText)); //Waits up to 10 seconds until element is not present
        assertEquals(textAreaAjax.getText(), expectedText);

    }
    @Test
    public void test4() throws InterruptedException {
        driver.get("http://book.theautomatedtester.co.uk/");

        WebElement secondLink = driver.findElement(By.xpath("//a[text()='Chapter2']"));
        secondLink.click();
        Thread.sleep(2000);

        WebElement siblingButton = driver.findElement(By.xpath("//*[@id='but1']/following-sibling::input"));
        siblingButton.click();
        assertTrue(siblingButton.isDisplayed());
        Thread.sleep(2000);




    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }

//    @DataProvider(name = "data_provider")
//    public Object[][] dataProvider(){
//        return new Object[][]{{"1","2"},{"2","3"}};
//    }
}
