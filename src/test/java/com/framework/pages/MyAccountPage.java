package com.framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
    private WebDriver webDriver;

    public MyAccountPage(WebDriver webDriver){
        this.webDriver=webDriver;
        PageFactory.initElements(this.webDriver,this);
    }

    @FindBy(how= How.XPATH,using = "//a[@title='My Store']/img")
    private WebElement img_logo;

    @FindBy(how= How.XPATH,using = "//span[text()='Order history and details']//parent::a")
    private WebElement link_orderHistoryAndDetails;
}
