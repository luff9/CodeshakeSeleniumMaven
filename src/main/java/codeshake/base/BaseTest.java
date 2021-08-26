package codeshake.base;

import codeshake.lib.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {


    public WebDriver driver = Driver.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, 30);


    @BeforeTest
    public void setUpTest() {
        //Actions before tests

    }

    @AfterTest
    public void tearDownTest() {
        driver.close();
        driver.quit();
    }


}
