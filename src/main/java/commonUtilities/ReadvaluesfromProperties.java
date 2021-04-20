package commonUtilities;

import java.io.FileInputStream;
 
import java.util.Properties;

public class ReadvaluesfromProperties {
	
//Created Properties file. This class going to read value from property
//Load data fromproperty file
//location -now currently in my machine. 
//read data
//-----------------------------------------------------------------------------------
	
//Create obj in property class
static Properties prop = new Properties();
	
	public static String defineproaandfile(String Key) throws Exception {
	
	
	    String filepath ="C:\\Deepa\\EclipseWorkspace\\com.AutomationTalks_Project\\Properties\\Confi.properties";
		
		//Read a file. create obj in file Inputstream
		FileInputStream readingfile = new FileInputStream(filepath);
		prop.load(readingfile);
		
		//Read a data from File
		String value =prop.get(Key).toString(); //For ex:Passing parameter key as a = browser in the method. value of the browser will store in this line
		return value; 
 
	}
	

}
