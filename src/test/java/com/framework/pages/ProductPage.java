package com.framework.pages;

import com.framework.base.UiOperator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class ProductPage {

    WebDriver webDriver;
    UiOperator uiOperator;


    public ProductPage(WebDriver webDriver,UiOperator uiOperator){
        this.uiOperator=uiOperator;
        this.webDriver=webDriver;
        PageFactory.initElements(this.webDriver,this);
    }

    @FindBy(how= How.XPATH,using = "//select[@id='sorter']")
    private WebElement dpdn_sortBy;

    @FindBy(how= How.XPATH,using = "//ol[@class='products list items product-items']/li//a[@class='product-item-link']")
    private List<WebElement> list_productName;

    @FindBy(how= How.XPATH,using = "//div[@class='toolbar-sorter sorter']/a")
    private WebElement link_sortOrder;


    public void selectSortBy(String selectValue){
        try{
            String strSelectedValue= uiOperator.getSelectedOption(dpdn_sortBy);
            if(!selectValue.equals(strSelectedValue)){
                uiOperator.selectDropdown(dpdn_sortBy,"text",selectValue);
            }


        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public List<String> getProductName(){
        List<String> productList=new ArrayList<>();
        try{
            for(WebElement ele: list_productName){
                String strPrice=ele.getText().trim();
                productList.add(strPrice);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return productList;
    }

    public String getAttributeVale(String attrName){
        return uiOperator.getAttributeValue(link_sortOrder,attrName);
    }
    public void clickSortOrder(){
         uiOperator.click(link_sortOrder);
    }



}
