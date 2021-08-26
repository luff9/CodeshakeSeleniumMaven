package codeshake.pages;

import codeshake.lib.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageHomeCodeShake {
    WebDriver driver;


    public PageHomeCodeShake(WebDriver driver) {
        this.driver = driver;
    }

    WebElement getButtonPayThemAVisit() {
        return driver.findElement(By.xpath("//span[contains(text(),'Pay them a visit')]"));
    }

    public void scrollAndClickButtonPayThemAVisit() {
        Driver.scrollToWebElement(driver, getButtonPayThemAVisit());
        getButtonPayThemAVisit().click();

    }
}
