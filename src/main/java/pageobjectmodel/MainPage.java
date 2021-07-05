package pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MainPage {

    WebDriver driver;
    By cookie_accept = By.xpath("//button[text()='Accept all cookies' and @class='ui-button-primary ui-cookie-accept-all-medium-large']");
    By search_box = By.id("header-location");
    By search_button = By.xpath("//button[@data-testid='search-button']");
    By price_tag = By.xpath("//p[@size='6' and @class='css-6v9gpl-Text eczcs4p0']");
    By property_tab = By.xpath("//div[@class='css-wfndrn-StyledContent e2uk8e18']");
    By agent_link = By.xpath("//div[@class='css-1niyh5b-AgentHeader e11937k17']/a");
    By agent_name_property = By.xpath("//h3[@size='6' and @class='css-e13akx-Heading3-AgentHeading e11937k16' ]");
    By agent_name_property_anchor_tag = By.xpath("//h3[@size='6' and @class='css-e13akx-Heading3-AgentHeading e11937k16' ]/a");
    By agent_name_page = By.xpath("//div[@id='content']/div/h1/b");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnCookieAccept(){
        if(driver.findElement(cookie_accept).isDisplayed())
        driver.findElement(cookie_accept).click();
    }
    public WebElement enterOnSearchBox(){
        return driver.findElement(search_box);
    }
    public void clickOnSearch(){
        driver.findElement(search_button).click();
    }
    public List<WebElement> getAllPriceTags(){
        return driver.findElements(price_tag);
    }
    public List<WebElement> getPropertyTab(){
        return driver.findElements(property_tab);

    }
    public void clickOnAgentLink(){
        driver.findElement(agent_link).click();
    }

    public String getAgentNameFromPropertyPage(){
        String parent = driver.findElement(agent_name_property).getText();
        String child = driver.findElement(agent_name_property_anchor_tag).getText();
        return parent.replace(child,"").replace("\n","");

    }

    public String getAgentNameFromAgentPage(){
        return driver.findElement(agent_name_page).getText();
    }
}
