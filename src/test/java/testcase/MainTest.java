package testcase;

import Utils.ConfigData;
import Utils.ExtentConfig;
import base.Base;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pageobjectmodel.AgentPage;
import pageobjectmodel.MainPage;
import pageobjectmodel.PropertyPage;

import java.io.IOException;
import java.util.*;

public class MainTest extends Base {

    WebDriver driver;
    Properties properties;

    MainPage mainPage;
    PropertyPage propertyPage;
    AgentPage agentPage;


    @Test
    public void test() throws IOException {
        //initializing web driver
        driver = initialize();

        properties = new Properties();

        driver.get(ConfigData.getPropertiesData("url"));


        mainPage = new MainPage(driver);
        mainPage.clickOnCookieAccept();
        mainPage.enterOnSearchBox().sendKeys("London");
        propertyPage = mainPage.clickOnSearch();

        List<WebElement> price_elements = propertyPage.getAllPriceTags();

        List<Integer> price_list = new ArrayList<Integer>();

        int price;

        for (WebElement element:price_elements){
            //converting price text -$20,458,21
            if((Integer.parseInt(element.getText().substring(1).replace(",","")))>0) {
               price = Integer.parseInt(element.getText().substring(1).replace(",", ""));
                price_list.add(price);
            }

        }
        //Sorting ascending order
        price_list.sort(Collections.reverseOrder());

        //printing price in ascending order - £500,000
        for (int amount: price_list){
            System.out.println("£"+amount);
        }

        //clicking on the 5th property list
        propertyPage.getPropertyTab().get(5-1).click();

        String agent_name_from_property_page = propertyPage.getAgentNameFromPropertyPage();


        agentPage = propertyPage.clickOnAgentLink();


        String agent_name_from_agent_page = agentPage.getAgentNameFromAgentPage();


        Assert.assertEquals(agent_name_from_property_page,agent_name_from_agent_page);


    }

    @AfterTest
    public void tearDown(){
       driver.quit();
    }
}
