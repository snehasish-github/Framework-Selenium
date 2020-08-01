package com.framework.base;

import org.openqa.selenium.WebElement;

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
    public void enterText(WebElement webElement,String text){
        try{
            webElement.clear();
            webElement.sendKeys(text);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

}
