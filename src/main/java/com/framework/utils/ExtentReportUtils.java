package com.framework.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


import java.io.File;

public class ExtentReportUtils {

    public

    ExtentReports extent=new ExtentReports();
    ExtentHtmlReporter htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")
             +File.separator+"src"+File.separator+"test"+File.separator+"resources"
             +File.separator+"report"+File.separator+"extentReport.html");

    public void extentReport(){
        extent.attachReporter(htmlReporter);

    }






}
