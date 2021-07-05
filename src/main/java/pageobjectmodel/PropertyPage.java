package pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PropertyPage {

    private WebDriver driver;

    private By price_tag = By.xpath("//p[@size='6' and @class='css-6v9gpl-Text eczcs4p0']");
    private By property_tab = By.xpath("//div[@class='css-wfndrn-StyledContent e2uk8e18']");
    private By agent_name_property = By.xpath("//h3[@size='6' and @class='css-e13akx-Heading3-AgentHeading e11937k16' ]");
    private By agent_name_property_anchor_tag = By.xpath("//h3[@size='6' and @class='css-e13akx-Heading3-AgentHeading e11937k16' ]/a");
    private By agent_link = By.xpath("//div[@class='css-1niyh5b-AgentHeader e11937k17']/a");

    public PropertyPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getAllPriceTags(){
        return driver.findElements(price_tag);
    }
    public List<WebElement> getPropertyTab(){
        return driver.findElements(property_tab);

    }
    public AgentPage clickOnAgentLink(){
        driver.findElement(agent_link).click();
        return new AgentPage(driver);
    }

    public String getAgentNameFromPropertyPage(){
        String parent = driver.findElement(agent_name_property).getText();
        String child = driver.findElement(agent_name_property_anchor_tag).getText();
        return parent.replace(child,"").replace("\n","");

    }
}
