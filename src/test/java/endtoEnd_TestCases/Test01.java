package endtoEnd_TestCases;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import basePackage.BaseClass;

public class Test01 extends BaseClass{
	
	@Test(enabled =false)
	public void errorvalidation_OnPayloadfield() throws Exception {
		//Teststep for this method
		//open browser
		//Navigate to motorcyle accordion
		//click on capacity field. Enter the value -3000
		//verify error message
		
		home1stpage.clickonMotorcycle();
		
		mtrcyle1sttab.entervalueincylinderfield("2500");
		Thread.sleep(2000);
		test.log(Status.PASS, "Cylinder capacity field eneter the data in the UI:2500 ");
		String actualerrormsg = mtrcyle1sttab.geterrormsgonCylindercap();
		System.out.println(actualerrormsg);
		String expectederrormsg ="Must be a number between 1 and 2000";
		Assert.assertEquals( actualerrormsg, expectederrormsg,"Error message is not as expected");
		
	 
		System.out.println(driver.getTitle());
		
	}
 

	@Test(enabled =false)
	public void errorvalidation_OnPerformancefield() throws Exception {
		//Teststep for this method
		//open browser
		//Navigate to motorcyle accordion
		//click on capacity field. Enter the value -3000
		//verify error message
		
		home1stpage.clickonMotorcycle();
		
		mtrcyle1sttab.entervalueperformancefield("3500");
		Thread.sleep(2000);
		
		String actualerrormsg = mtrcyle1sttab.geterrormsgonCylindercap();
		System.out.println(actualerrormsg);
		String expectederrormsg ="Dummy";
		Assert.assertEquals( actualerrormsg, expectederrormsg,"Error message is not as expected");
	}

	
	@Test(enabled =true)
	public void selectvalufromdropdown() throws Exception {
		home1stpage.clickonMotorcycle();
		
	List<String> actualvaluesintheDD =mtrcyle1sttab.getdropdownlist();
	test.log(Status.INFO, "Actual values in the dropdown list: " +actualvaluesintheDD);
	
	
	//Craete object in List class. Dont want to add each value while using - expectedvalues.add(pleaseselect) instead of this 
	List<String> expectedvalues= Arrays.asList("– please select –", "Scooer", "Three-Wheeler","Moped","Motorcycle");
	test.log(Status.INFO, "Expected values in the dropdown list: " + expectedvalues);
	
	Assert.assertEquals(actualvaluesintheDD,expectedvalues,"Dropdown list is not listed as Expected");
		
	}
	
	
}
