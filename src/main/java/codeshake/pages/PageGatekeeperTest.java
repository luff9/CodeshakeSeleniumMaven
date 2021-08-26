package codeshake.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PageGatekeeperTest {
    WebDriver driver;
    WebDriverWait wait;


    public PageGatekeeperTest(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }

    WebElement getInputFirst() {
        return driver.findElement(By.xpath("//input[@id='mat-input-0']"));
    }

    WebElement getInputSecond() {
        return driver.findElement(By.xpath("//input[@id='mat-input-1']"));
    }

    WebElement getInputResult() {
        return driver.findElement(By.xpath("//input[@id='mat-input-2']"));
    }

    WebElement getInputSearch() {
        return driver.findElement(By.xpath("//input[@id='mat-input-3']"));
    }

    WebElement getTextSearchResult() {
        return driver.findElement(By.xpath("(//i[contains(@class,'fa-unicorn')])[2]/.."));
    }

    WebElement getButtonLetBattleBegin() {
        return driver.findElement(By.xpath("//button[contains(@class,'mat-focus-indicator')]"));
    }

    WebElement getButtonActiveBullEye() {
        return driver.findElement(By.xpath("//div[@class='cdk-overlay-container']//*[@target-for-close-action]"));
    }

    WebElement getAddress() {
        return driver.findElement(By.xpath("//div[@class='content']/div[2]//span"));
    }

    WebElement getAddressFromIFrame() {
        switchToIframe();
        return driver.findElement(By.xpath("//div[@data-qodef-anchor='contact']//div[@class='wpb_wrapper']//p"));


    }

    void switchToIframe() {
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='iframe']")));
    }


    public void setNumbers(int number1, int number2) {

        getInputFirst().clear();
        getInputFirst().sendKeys(String.valueOf(number1));
        getInputSecond().clear();
        getInputSecond().sendKeys(String.valueOf(number2));
        getInputSecond().sendKeys(Keys.TAB);
    }

    public void validateResult(int number1, int number2) {
        String number1TextUI = getInputFirst().getAttribute("value");
        String number2TextUI = getInputSecond().getAttribute("value");
        String numberResultTextUI = getInputResult().getAttribute("value");


        Assert.assertEquals(number1, Integer.parseInt(number1TextUI), "First number check");
        Assert.assertEquals(number2, Integer.parseInt(number2TextUI), "Second number check");
        Assert.assertEquals(numberResultTextUI, String.valueOf(number1 + number2), "Result check");
    }


    public void search(String name) {
        getInputSearch().sendKeys(name);
        getInputSearch().sendKeys(Keys.ENTER);
    }

    public void validateSearchResult(String unicornName) {
        Assert.assertTrue(getTextSearchResult().getText().strip().toLowerCase().contains(unicornName.toLowerCase()), "Search result check");
    }

    public void openClosePopup() {
        getButtonLetBattleBegin().click();
        Assert.assertTrue(getButtonActiveBullEye().isDisplayed());
        getButtonActiveBullEye().click();

        wait.until(ExpectedConditions.stalenessOf(getButtonActiveBullEye()));
        boolean isBullEyeOnDOM = driver.findElements(By.xpath("//div[@class='cdk-overlay-container']//*[@target-for-close-action]")).isEmpty();
        Assert.assertTrue(isBullEyeOnDOM, "BullEye is not on the DOM");

    }

    public void validateAddress() {
        String address = getAddress().getText().strip();
        String addressFromIFrame = getAddressFromIFrame().getText().strip();

        Assert.assertEquals(addressFromIFrame, address, "Address check");
    }
}
