package pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AgentPage {
    private WebDriver driver;

    private By agent_name_page = By.xpath("//div[@id='content']/div/h1/b");

    public AgentPage(WebDriver driver) {
        this.driver = driver;
    }


    public String getAgentNameFromAgentPage(){
        return driver.findElement(agent_name_page).getText();
    }
}
