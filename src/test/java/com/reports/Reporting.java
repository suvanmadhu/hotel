package com.reports;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class Reporting {
	

		public static void geneeateJVMReport(String jsonFile ) {
			File file = new File("C:\\Users\\Rajesh\\eclipse-workspace\\AdactinOMRBranchAutomatoin\\target");
			Configuration Configuration= new Configuration(file, "Adactin Automatoin");
			
			Configuration.addClassifications("OS", "WIN10");
			Configuration.addClassifications("Browser", "Chrome");
			Configuration.addClassifications("version", "105.00.516");
			Configuration.addClassifications("sprint", "31");
			List<String> jsonFiles= new ArrayList<String>();
			jsonFiles.add(jsonFile);
			ReportBuilder builder=new ReportBuilder(jsonFiles,Configuration);
			
			builder.generateReports();
	}	
	
	
	
	}
	
	

