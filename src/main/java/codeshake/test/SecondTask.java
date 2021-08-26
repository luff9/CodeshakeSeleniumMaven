package codeshake.test;

import codeshake.base.BaseTest;
import codeshake.lib.Driver;
import codeshake.pages.PageAllCloudWisers;
import codeshake.pages.PageHomeCloudWise;
import codeshake.pages.PageHomeCodeShake;
import codeshake.pages.PageThisIsCloudWise;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class SecondTask extends BaseTest {

    final String  urlHomePage = "https://codeshake.io/";


    @Test
    public void getUsers() {

        driver.get(urlHomePage);


        PageHomeCodeShake homePage = new PageHomeCodeShake(driver);
        PageHomeCloudWise pageHomeCloudwise = new PageHomeCloudWise(driver);
        PageThisIsCloudWise pageThisIsCloudwise = new PageThisIsCloudWise(driver);
        PageAllCloudWisers pageAllCloudWise = new PageAllCloudWisers(driver);

        homePage.scrollAndClickButtonPayThemAVisit();

        ArrayList<String> tabsArr = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabsArr.get(1));


        pageHomeCloudwise.exceptsCookies();
        pageHomeCloudwise.goToThisIsCloudWise();

        pageThisIsCloudwise.scrollAndClickAllCloudWise();

        ArrayList<WebElement> elDepartmentsArr = pageAllCloudWise.getHrefDepartment();
        ArrayList<ArrayList<String>> namesArrArr = new ArrayList<>();

        for (WebElement el : elDepartmentsArr) {

            String selectLinkOpenInNewTab = Keys.chord(Keys.CONTROL, Keys.RETURN);
            Driver.scrollToWebElement(driver, el);
            el.sendKeys(selectLinkOpenInNewTab);

            tabsArr = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabsArr.get(2));

            ArrayList<String> names = pageAllCloudWise.getEmployeeNames();
            namesArrArr.add(names);

            printTitle(pageAllCloudWise.getDepartmentName());

            for (String name : names) {
                System.out.println(name);
            }

            driver.close();
            driver.switchTo().window(tabsArr.get(1));


        }

        ArrayList<String> repeatedNames = new ArrayList<>();

        printTitle("Repeating Names");
        for (ArrayList<String> namesList : namesArrArr) {
            for (String name : namesList) {
                int count = 0;
                boolean print = true;

                for (ArrayList<String> namesList2 : namesArrArr) {
                    for (String name2 : namesList2) {
                        if (name.equals(name2)) {
                            count++;

                        }
                    }
                }


                if (count > 1) {
                    for (String repeatedName : repeatedNames) {
                        if (name.equals(repeatedName)) {
                            print = false;
                            break;

                        }
                    }
                    if (print) {
                        System.out.println(name + " repeats " + count + " times");
                        repeatedNames.add(name);
                    }

                }
            }
        }


    }

    private void printTitle(String title) {
        System.out.println("*******************************************************************");
        System.out.println("*****************   "+ title +"   *****************");
        System.out.println("*******************************************************************");
    }


}
