package com.framework.base;

import io.cucumber.core.api.Scenario;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class UiOperator {
    private DriverManager driverManager;

    public UiOperator(DriverManager driverManager){
        this.driverManager=driverManager;
    }

    public void click(WebElement webElement){
        try{
            webElement.click();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public String  getSelectedOption(WebElement webElement){
        String strOption="";
        try{
            Select select=new Select(webElement);
            select.getFirstSelectedOption().getText().trim();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return strOption;
    }


    public void selectDropdown(WebElement webElement, String selectType, String  value){
        try{
            Select select =new Select (webElement);
            if(selectType.equalsIgnoreCase("index"))
                select.selectByIndex(Integer.parseInt(value));
            else if(selectType.equalsIgnoreCase("value"))
                select.selectByValue(value);
            else
                select.selectByVisibleText(value);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }


    public void enterText(WebElement webElement,String text){
        try{
            webElement.clear();
            webElement.sendKeys(text);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public String getAttributeValue(WebElement webElement,String attributeName){
        String attrValue="";
        try{
            attrValue=webElement.getAttribute(attributeName);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return attrValue;
    }

    public void takeScreenshot(Scenario scenario){
        try{
            final byte[] screenshot = ((TakesScreenshot) driverManager.driver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot,"image/png");
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }


}
