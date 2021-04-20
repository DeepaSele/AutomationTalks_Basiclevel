package pageObjectModel;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePackage.BaseClass;

public class MotorCyclePE_02_EnterInsurantData02 extends BaseClass {
	
	//Created Constructor
	
	public MotorCyclePE_02_EnterInsurantData02() {
		PageFactory.initElements(driver,this);
	}
	
	
//Creating objects for below webelements
	@FindBy(xpath="//a[@id='enterinsurantdata']")
	WebElement tab_enterInsurantdata;
	
	@FindBy(xpath="//input[@name='First Name']")
	WebElement txt_firstname;
	
	@FindBy(xpath="//input[@name='Last Name']")
	WebElement txt_lastname;
	
	@FindBy(xpath="//input[@name='Gender']/parent::label") //Radiobuttons- Dynamic xpath -two values - Created List class
	List <WebElement> chkboxes_Gender;
	
	@FindBy(xpath="//input[@name='Date of Birth']")
	WebElement dateofbirth;

	
	@FindBy(xpath="//select[@name='Country']")
	WebElement country;
	
	@FindBy(xpath="//input[@name='Zip Code']")
	WebElement zipcode;
 
	@FindBy(xpath="//select[@name='Occupation']")
	WebElement occupation;

	//input[@name='Hobbies' or @type='checkbox']
	@FindBy(xpath="//input[@name='Hobbies']/parent::label") //Checkboxes- Dynamic xpath -More values - Created List class
	List <WebElement>  chk_hobbies;
	//input[@name='Hobbies']/parent::label
	
	
	@FindBy(xpath="//button[@name='Next (Enter Product Data)']")
	WebElement nextbutton;
/*------------------------OBJECT DECLARATION-------------------------------*/	
	
	
//Entering all data in EnterInsurantData page
	public void enterdatasinEnterInsurantpage(HashMap<String,String> testdata) throws Exception {
		Thread.sleep(2000);
		txt_firstname.sendKeys(testdata.get("Insurant_FirstName"));
		Thread.sleep(2000);
		txt_lastname.sendKeys(testdata.get("Insurant_LastName"));
		Thread.sleep(2000);
		dateofbirth.sendKeys(testdata.get("Insurant_birthdate"));
		Thread.sleep(2000);
		comonmethod.selectoptionalorradioprods(chkboxes_Gender,testdata.get("Insurant_gender"));
		Thread.sleep(2000);
		comonmethod.selectvaluefromDD(country,testdata.get("Insurant_country"));
		Thread.sleep(2000);
		zipcode.sendKeys(testdata.get("Insurant_zipcode"));
		Thread.sleep(2000);
		comonmethod.selectvaluefromDD(occupation ,testdata.get("Insurant_Occupation"));
		Thread.sleep(2000);
		comonmethod.selectmorevaluesfromCheckbox(chk_hobbies, testdata.get("Insurant_Hobby"));
		Thread.sleep(2000);
	}
	
	 public void clickonNextbutton() throws Exception {
		 nextbutton.click();
		 Thread.sleep(1000);
	    }	
	
	
	
	
	
	
	
}
