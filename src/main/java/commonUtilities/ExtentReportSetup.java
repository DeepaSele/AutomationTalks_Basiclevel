package commonUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import basePackage.InitializeObjectforAllPages;

public class ExtentReportSetup extends InitializeObjectforAllPages{
	
	
	public static ExtentReports setupextendreport() {
		
//This class mainly for the Report.Most of the real time Lead will code it
//-----------------------------------------------------------------------------		
 
		//We need some data format. so we are creating objects in the class in Dateformat class
		SimpleDateFormat formate = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
 	
		//Creating object in Date Class to get current date
		Date date = new Date();
		
		//ref -formate we need format method. I need date to be format so passing date as arugument
		String actualdate= formate.format(date);
 	
		
		//Given filepath name. If everytime run this report will be overridden. so Date Variable created
		String reportpath = "C:\\Deepa\\EclipseWorkspace\\com.AutomationTalks_Project\\Report\\ExecutionReport_" +actualdate +".html";
		
		//Give the Location in the below line
		ExtentSparkReporter sparkreport = new ExtentSparkReporter(reportpath);
		
		
		extent = new ExtentReports();
		extent.attachReporter(sparkreport);
		
		sparkreport.config().setDocumentTitle("Document Title");
		sparkreport.config().setTheme(Theme.DARK);
		sparkreport.config().setReportName("Report Name");
		
		return extent;
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	

}
