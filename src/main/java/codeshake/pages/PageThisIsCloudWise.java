package codeshake.pages;

import codeshake.lib.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageThisIsCloudWise {
    WebDriver driver;


    public PageThisIsCloudWise(WebDriver driver) {
        this.driver = driver;

    }

    WebElement getHrefAllCloudWise() {
        return driver.findElement(By.xpath("//a[@href='https://cloudwise.nl/alle-cloudwisers/']"));
    }

    public void scrollAndClickAllCloudWise() {
        Driver.scrollToWebElement(driver, getHrefAllCloudWise());
        getHrefAllCloudWise().click();

    }


}
