package codeshake.test;

import codeshake.base.BaseTest;
import codeshake.pages.PageGatekeeperTest;
import org.testng.annotations.Test;

import java.util.Random;

public class FirstTask extends BaseTest {

    final String urlTest = "https://gatekeeper.codeshake.dev/test";


    @Test
    public void validateAddition() {
        PageGatekeeperTest pageGatekeeperTest = new PageGatekeeperTest(driver);

        driver.get(urlTest);

        Random rand = new Random();

        int randInt1 = rand.nextInt(100000);
        int randInt2 = rand.nextInt(100000);

        pageGatekeeperTest.setNumbers(randInt1, randInt2);
        pageGatekeeperTest.validateResult(randInt1, randInt2);
    }

    @Test
    public void validateSearch() {
        PageGatekeeperTest pageGatekeeperTest = new PageGatekeeperTest(driver);

        driver.get(urlTest);

        String unicornName = "bobi";
        pageGatekeeperTest.search(unicornName);
        pageGatekeeperTest.validateSearchResult(unicornName);

    }

    @Test
    public void validatePopup() {
        PageGatekeeperTest pageGatekeeperTest = new PageGatekeeperTest(driver);

        driver.get(urlTest);

        pageGatekeeperTest.openClosePopup();
    }

    @Test
    public void validateAddress() {
        PageGatekeeperTest pageGatekeeperTest = new PageGatekeeperTest(driver);

        driver.get(urlTest);

        pageGatekeeperTest.validateAddress();
    }


}
