package pageObjectModel;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePackage.BaseClass;

public class MotorCyclePE_02_EnterProductdata03 extends BaseClass {

	
	public MotorCyclePE_02_EnterProductdata03() {
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(xpath="//input[@name='Start Date']")
	WebElement startdate;
	
	@FindBy(xpath="//select[@id='insurancesum']") //dropdown
	WebElement insurancesum;

	@FindBy(xpath="//select[@id='damageinsurance']") //dropdown
	WebElement damageinsurance;

	@FindBy(xpath="//input[@name='Optional Products[]']/parent::label")
	List <WebElement> optproducts;	

	@FindBy(xpath="//button[@id='nextselectpriceoption']")
	WebElement nextbutton;
	
//Enter the data into the webelement
	public void enterdatainProductpage(HashMap<String,String> testdata) throws Exception {
		startdate.sendKeys(testdata.get("Product_startdate"));
		Thread.sleep(1000);
		comonmethod.selectvaluefromDD(insurancesum,testdata.get("Product_insurancesum"));
		Thread.sleep(1000);
		comonmethod.selectvaluefromDD(damageinsurance,testdata.get("Product_damageinsurance"));
		Thread.sleep(1000);
		comonmethod.selectmorevaluesfromCheckbox(optproducts,testdata.get("Product_OptionalProducts"));
		Thread.sleep(1000);
	}
	
	
	 public void clickonNextbutton() {
		 nextbutton.click();
	    }
}
