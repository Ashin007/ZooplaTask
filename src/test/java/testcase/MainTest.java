package testcase;

import base.Base;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pageobjectmodel.MainPage;

public class MainTest extends Base {

    WebDriver driver;

    @Test
    public void test(){

        driver = initialize();
        driver.get("https://www.zoopla.co.uk/");

        MainPage mainPage = new MainPage(driver);
        mainPage.clickOnCookieAccept();
        mainPage.enterOnSearchBox().sendKeys("London");
        mainPage.clickOnSearch();
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
