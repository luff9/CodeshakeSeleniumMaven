package codeshake.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class PageAllCloudWisers {
    WebDriver driver;


    public PageAllCloudWisers(WebDriver driver) {
        this.driver = driver;

    }

    ArrayList<WebElement> getH3EmployeeNames() {
        return (ArrayList<WebElement>) driver.findElements(By.xpath("//div[contains(@class,'flip-box-front')]//h3"));
    }

    WebElement geth1DepartmentName() {
        return driver.findElement(By.xpath("//h1"));
    }

    public ArrayList<WebElement> getHrefDepartment() {
        return (ArrayList<WebElement>) driver.findElements(By.xpath("//div[contains(@class,'nectar-flip-box')]//a"));

    }

    public String getDepartmentName() {
        return geth1DepartmentName().getText();
    }

    public ArrayList<String> getEmployeeNames() {
        ArrayList<String> names = new ArrayList<>();
        for (WebElement el : getH3EmployeeNames()) {
            names.add(el.getText());
        }
        return names;
    }


}
