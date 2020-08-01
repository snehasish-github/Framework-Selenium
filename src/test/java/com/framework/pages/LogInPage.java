package com.framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {
    WebDriver webDriver;

    public LogInPage(WebDriver webDriver){
        this.webDriver=webDriver;
        PageFactory.initElements(webDriver,this);
    }
    @FindBy(how= How.XPATH,using = "//a[contains(text(),'Sign in')]")
    private WebElement btn_SignIn;

    @FindBy(how= How.CSS,using = "input#email")
    private WebElement txt_email;

    @FindBy(how= How.CSS,using = "input#passwd")
    private WebElement txt_password;

    @FindBy(how= How.CSS,using = "button#SubmitLogin")
    private WebElement btn_logIn;


    public WebElement getbtn_SignIn(){
        return btn_SignIn;
    }
    public WebElement getTxt_email() {
        return txt_email;
    }
    public WebElement getTxt_password() {
        return txt_password;
    }
    public WebElement getBtn_logIn() {
        return btn_logIn;
    }
}
