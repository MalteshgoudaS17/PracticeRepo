package com.bussiness.OrangeHrm;

import java.awt.Desktop;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import com.aventstack.extentreports.ExtentReports;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class ExtentReporter 
{
	public void report(String reportName,String TestCaseName) throws IOException, URISyntaxException
	{
	ExtentReports extentReports = new ExtentReports();

	ExtentSparkReporter sparkReporter=new  ExtentSparkReporter("TestOmnify\\src\\test\\resources\\reports\\"+reportName+".html");
	extentReports.attachReporter(sparkReporter);
	
	extentReports.createTest(reportName, reportName);
	
	extentReports.flush();
	Desktop.getDesktop().browse(new URI(""+reportName+".html"));
 
	}
}
