package com.framework.pages;

import com.framework.base.UiOperator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {
    WebDriver webDriver;
    UiOperator uiOperator;


    public LogInPage(WebDriver webDriver,UiOperator uiOperator){
        this.uiOperator=uiOperator;
        this.webDriver=webDriver;
        PageFactory.initElements(this.webDriver,this);
    }
    @FindBy(how= How.XPATH,using = "//a[contains(text(),'Sign in')]")
    private WebElement btn_SignIn;

    @FindBy(how= How.CSS,using = "input#email")
    private WebElement txt_email;

    @FindBy(how= How.XPATH,using = "//input[@id='email_create']")
    private WebElement txt_emailcenter;

    @FindBy(how= How.CSS,using = "input#passwd")
    private WebElement txt_password;

    @FindBy(how= How.CSS,using = "button#SubmitLogin")
    private WebElement btn_logIn;

    @FindBy(how= How.XPATH,using = "//button[@id='SubmitCreate']")
    private WebElement btn_createAnAccount;

    @FindBy(how= How.XPATH,using = "//input[@id='search_query_top']")
    private WebElement txt_searchBox;

    @FindBy(how= How.XPATH,using = "//button[@name='submit_search']")
    private WebElement btn_search;

    public void clickSignIn(){
        try{
            uiOperator.click(btn_SignIn);
        }
        catch(Exception e){

        }
    }

    public void singIn(String userName,String password){
        try{

            uiOperator.click(btn_SignIn);
            uiOperator.enterText(txt_email,userName);
            uiOperator.enterText(txt_password,password);
            uiOperator.click(btn_logIn);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void searchProduct(String productName){
        try{
            txt_searchBox.sendKeys(productName);
            btn_search.click();

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void createAccount(String emailId){
        uiOperator.enterText(txt_emailcenter,emailId);
        uiOperator.click(btn_createAnAccount);

    }



}
