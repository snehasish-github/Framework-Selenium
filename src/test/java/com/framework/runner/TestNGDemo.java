package com.framework.runner;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestNGDemo {


    @Test
    public void Test(){
        SoftAssert softAssert=new SoftAssert();
        System.out.println("FirstTest");
        softAssert.fail();
        System.out.println("Before collecting softAssertion");
        softAssert.assertAll();
        System.out.println("After collecting softAssertion");
    }
    @Test(dependsOnMethods = {"Test"},alwaysRun = true)
    public void Test1(){
        System.out.println("SecondTest");

    }
    @BeforeMethod
    public void TestMetod(){
        System.out.println("Before  Method");
    }
    @BeforeTest()
    public void BeforeTest(){
        System.out.println("Before Test ");
    }

    @BeforeClass
    public void BeforeClass(){
        System.out.println("Before Class");
    }

}
