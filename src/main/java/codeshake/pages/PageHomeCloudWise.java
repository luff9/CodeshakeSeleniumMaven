package codeshake.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageHomeCloudWise {
    WebDriver driver;
    WebDriverWait wait;


    public PageHomeCloudWise(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }

    WebElement getButtonAcceptCookies() {
        return driver.findElement(By.xpath("//a[@id='CybotCookiebotDialogBodyLevelButtonAccept']"));
    }

    WebElement getLinkThisIsCloudWise() {
        String xPathLink = "//nav//li//a[@class='sf-with-ul'][normalize-space()='This is Cloudwise']";
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(xPathLink))));
        return driver.findElement(By.xpath(xPathLink));
    }

    public void exceptsCookies() {
        getButtonAcceptCookies().click();

    }

    public void goToThisIsCloudWise() {

        getLinkThisIsCloudWise().click();
    }
}
