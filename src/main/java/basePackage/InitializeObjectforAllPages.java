package basePackage;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import commonUtilities.CommonMethods;
import pageObjectModel.HomepageElements_01;
import pageObjectModel.MotorCyclePE_02_EnterInsurantData02;
import pageObjectModel.MotorCyclePE_02_EnterProductdata03;
import pageObjectModel.MotorCyclePE_02_EnterVehicleData01;
import pageObjectModel.MotorCyclePE_02_SelectPriceOption04;

public class InitializeObjectforAllPages {
	
	
/*Created POM objects under POM Model
 * This class we are going to create objects for all pages
 * This class got EXTENDED by BaseClass
 * 
 */
	
	public static ExtentReports extent; //for reporting
	public static ExtentTest test; // for reporting
	
	public static String destinationpath;
	
	//Creating object in the Commonmethod class
	public CommonMethods comonmethod =new CommonMethods();	
	public static HomepageElements_01 home1stpage;
	public static MotorCyclePE_02_EnterVehicleData01 mtrcyle1sttab;
    public static MotorCyclePE_02_EnterInsurantData02 mtrcyle2ndtab;
    public static MotorCyclePE_02_EnterProductdata03 mtrcyle3rdtab;
    public static MotorCyclePE_02_SelectPriceOption04 mtrcycle4thtab;
}


//public HomepageElements_01 home1stpage = new HomepageElements_01();
//Got Error while executing - Java Stack overflow
//I changed into below way
//public HomepageElements_01 home1stpage;
//In BeforeMethod - Create object for above line