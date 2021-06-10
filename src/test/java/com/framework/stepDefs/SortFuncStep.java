package com.framework.stepDefs;

import com.framework.base.DriverManager;
import com.framework.base.UiOperator;
import com.framework.pages.LogInPage;
import com.framework.pages.ProductPage;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import java.util.Collections;
import java.util.List;

public class SortFuncStep {
    private DriverManager driverManager;
    private UiOperator uiOperator;
    private Scenario scenario;
    ProductPage productPage;

    public SortFuncStep(DriverManager driverManager, UiOperator uiOperator)
    {
        this.driverManager=driverManager;
        this.uiOperator=uiOperator;
    }

    @Before

    public void before(Scenario scenario)
    {
        this.scenario=scenario;
        driverManager.getDriver(); //will change the method name to initDriver
        //System.out.println("Hashcode in step"+driverManager.hashCode());
        //String Url=driverManager.getProperty("appURL");
        //driverManager.driver.get(Url);

    }



    @Given("user nevigates to app url {string}")
    public void user_nevigates_to_app_url(String strUrl) {
        try{
            driverManager.driver.get(strUrl);
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

    @When("user apply sort on page with {string}")
    public void user_apply_sort_on_page_with(String strSortBy) {

        try{
            String sortOrder="ascending";
            productPage=new ProductPage(driverManager.driver,uiOperator);
            productPage.selectSortBy(strSortBy);
            List<String> expectedOrderedList=productPage.getProductName();
            System.out.println("expectedOrderedList::"+ expectedOrderedList);

            if(sortOrder.equalsIgnoreCase("ascending"))
                Collections.sort(expectedOrderedList);
            else if(sortOrder.equalsIgnoreCase("descending"))
                Collections.sort(expectedOrderedList,Collections.reverseOrder());


            String atrValue=productPage.getAttributeVale("data-value");
            if(sortOrder.equalsIgnoreCase("descending") && atrValue.equals("desc"))
                productPage.clickSortOrder();

            Thread.sleep(3000);


           /* logInPage=new LogInPage(driverManager.driver,uiOperator);
            logInPage.singIn(userName,password);

            Select select=new Select(driver.findElement(By.xpath("//select[@id='sorter']")));
            String strOption=select.getFirstSelectedOption().getText().trim();
            System.out.println("Selected Value:: "+strOption);
            if(!strOption.equals("Product Name")){
                select.selectByVisibleText("Product Name");
            }*/


        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

    @Then("user verify the product in sorted order")
    public void user_verify_the_product_in_sorted_order() {

    }

}
