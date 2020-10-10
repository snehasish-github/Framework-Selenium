package com.framework.runner;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGDemoTwo {
    @Test
    public void Test(){
        System.out.println("FirstTestTwo");
    }
    @Test
    public void Test1(){
        System.out.println("SecondTestTwo");
    }
    @BeforeMethod
    public void TestMetod(){
        System.out.println("Before  Method Two");
    }
    @BeforeTest
    public void BeforeTest(){
        System.out.println("Before Test Two");
    }
    @BeforeClass
    public void BeforeClass(){
        System.out.println("Before ClassTwo");
    }
}
