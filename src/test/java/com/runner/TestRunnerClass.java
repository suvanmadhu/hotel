package com.runner;

import org.junit.AfterClass;


import org.junit.runner.RunWith;

import com.reports.Reporting;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(tags =("@RunAll"),snippets=SnippetType.CAMELCASE,monochrome=false, strict = true, dryRun=false, 
plugin= { "pretty","json:target/cucumber.json"},features ="src\\test\\resources",glue="com.stepdefinition")
public class TestRunnerClass {
@AfterClass
public static void afterClass() {
	 
	Reporting.geneeateJVMReport(System.getProperty("user.dir") + "\\target\\cucumber.json");
}		
}
