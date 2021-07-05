package pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MainPage {

    private WebDriver driver;
    private By cookie_accept = By.xpath("//button[text()='Accept all cookies' and @class='ui-button-primary ui-cookie-accept-all-medium-large']");
    private By search_box = By.id("header-location");
    private By search_button = By.xpath("//button[@data-testid='search-button']");


    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnCookieAccept() {
        if (driver.findElement(cookie_accept).isDisplayed())
            driver.findElement(cookie_accept).click();
    }

    public WebElement enterOnSearchBox() {
        return driver.findElement(search_box);
    }

    public PropertyPage clickOnSearch() {
        driver.findElement(search_button).click();
        return new PropertyPage(driver);
    }

}


