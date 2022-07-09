package com.stepdefinition;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.base.BaseClass;

import cucumber.api.Scenario;

public class HooksClass extends BaseClass{
	
	@Before
	public void beforeScenario() throws FileNotFoundException, IOException {
		browse(getPropertyFileInputValue("browserType"),getPropertyFileInputValue("url"));		
	}
@After
public void afterScenario(Scenario scenario) {
	TakesScreenshot screenshot=(TakesScreenshot)driver;
	byte[] as = screenshot.getScreenshotAs(OutputType.BYTES);
	scenario.embed(as, "Every Scenario");
	closeAllWindow();
	
}
	
		
	}


