package testcase;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pageobjectmodel.MainPage;

import java.util.*;

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

        List<WebElement> price_elements = mainPage.getAllPriceTags();

        List<Integer> price_list = new ArrayList<Integer>();

        int price=0;

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
        mainPage.getPropertyTab().get(5-1).click();

        String agent_name_from_property_page = mainPage.getAgentNameFromPropertyPage();


        mainPage.clickOnAgentLink();


        String agent_name_from_agent_page = mainPage.getAgentNameFromAgentPage();


        Assert.assertEquals(agent_name_from_property_page,agent_name_from_agent_page);
    }

    @AfterTest
    public void tearDown(){
       driver.quit();
    }
}
