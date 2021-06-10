package com.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestDemo {

    public static void main(String[] args) throws InterruptedException {
        /*System.setProperty("webdriver.chrome.driver",
                System.getProperty("user.dir")
                        + "\\Resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        List<Double> priceList=new ArrayList<>();
        List<Double> actPriceList=new ArrayList<>();

        driver.get("https://www.symphonylimited.com/products/commercial-cooler.html");
        List<WebElement> strPdtPrice=driver.findElements(By.xpath("//ol[@class='products list items product-items']/li//span[@class='special-price']//span[@class='price']"));
        for(WebElement ele: strPdtPrice){
            String strPrice=ele.getText();
            String strPriceFormated=strPrice.replace(String.valueOf(strPrice.charAt(0)),"").replace(",","");
            System.out.println(strPriceFormated);
            double dPrice=Double.valueOf(strPriceFormated);
            System.out.println("Double: "+dPrice);
            priceList.add(dPrice);


        }
        System.out.println("Unsorted List: "+priceList);
        Collections.sort(priceList);
        System.out.println("sorted List: "+priceList);
        Collections.sort(priceList,Collections.reverseOrder());
        System.out.println("Reverse sorted List: "+priceList);

        //Descending Order
        WebElement sortArrow=driver.findElement(By.xpath("//a[@data-value='desc']"));
        sortArrow.click();
        Thread.sleep(2000);
        List<WebElement> strPdtPrice1=driver.findElements(By.xpath("//ol[@class='products list items product-items']/li//span[@class='special-price']//span[@class='price']"));
        for(WebElement ele: strPdtPrice1){
            String strPrice=ele.getText();
            String strPriceFormated=strPrice.replace(String.valueOf(strPrice.charAt(0)),"").replace(",","");

            double dPrice=Double.valueOf(strPriceFormated);

            actPriceList.add(dPrice);
        }
        System.out.println("Desc Price list:"+actPriceList);
        if(priceList.equals(actPriceList))
            System.out.println("Pass");
        else
            System.out.println("Fail");

        driver.quit();*/

        sortByProductName();

    }

    public static void sortByProductName(){
        System.setProperty("webdriver.chrome.driver",
                System.getProperty("user.dir")
                        + "\\Resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        List<String> productList=new ArrayList<>();
        List<String> actproductList=new ArrayList<>();

        driver.get("https://www.symphonylimited.com/products/commercial-cooler.html");

        Select select=new Select(driver.findElement(By.xpath("//select[@id='sorter']")));
        String strOption=select.getFirstSelectedOption().getText().trim();
        System.out.println("Selected Value:: "+strOption);
        if(!strOption.equals("Product Name")){
            select.selectByVisibleText("Product Name");
        }
        List<WebElement> strPdtPrice=driver.findElements(By.xpath("//ol[@class='products list items product-items']/li//a[@class='product-item-link']"));
        for(WebElement ele: strPdtPrice){
            String strPrice=ele.getText().trim();
            System.out.println(strPrice);


            productList.add(strPrice);



        }

        System.out.println("Unsorted List: "+productList);
        Collections.sort(productList);
        System.out.println("sorted List: "+productList);
        Collections.sort(productList,Collections.reverseOrder());
        System.out.println("Reverse sorted List: "+productList);


       // driver.quit();

    }
}
