package pageObjectModel;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePackage.BaseClass;

public class MotorCyclePE_02_EnterVehicleData01 extends BaseClass  {
	
	//creating constructor
	public MotorCyclePE_02_EnterVehicleData01() {
		PageFactory.initElements(driver,this);
	}
 
//After click on Motorcycle icon in the Page we will get 4 tabs along with Radio buttons and checkbox
//Elements objects are below

	@FindBy(xpath="//select[@id='make']") //Dropdown field.Created dynamic xpath put all values in the List Class
     WebElement makedropdown;
	
	@FindBy(xpath="//select[@name='Model']") //This dropdown have more values..Dynamic xpath have lot of elements 
	WebElement Modeldropdown;
	
	@FindBy(xpath="//input[@name='[kW]']")
	WebElement txt_Engineperformance;
	
	//I'm not creating for element Cylindermethod instead of that, creating webelement as PUBLIC
	//public WebElement txt_cylinder;
	@FindBy(xpath="//input[@id='cylindercapacity']")
	WebElement txt_cylinderfield;

	
	@FindBy(xpath="//input[@id='cylindercapacity']/following-sibling::span[@class='error'] ")//input[@id='cylindercapacity']/following-sibling::span[@class='error'] 
	WebElement errmsg;
	
	
	@FindBy(xpath="//input[@id='dateofmanufacture']")   
	WebElement txt_datefield;
	
	@FindBy(xpath="//select[@name='Number of Seats Motorcycle']") //dropdown
	WebElement drdo_NoofSeats;
	
	@FindBy(xpath="//input[@name='List Price']") 
	WebElement txt_Listprice;


	@FindBy(xpath="//input[@name='Annual Mileage']") 
	WebElement txt_Annualmileage;
 	
	@FindBy(xpath="//button[@name='Next (Enter Insurant Data)']") 
	WebElement btn_Next;

/*---------------------------------OBJECT DECLARATION------------------------------------------------*/
	
	public void entervalueincylinderfield(String cylindervalue) throws Exception {
		Thread.sleep(2000);
		txt_cylinderfield.sendKeys(cylindervalue);
		
	}
	
	public String geterrormsgonCylindercap() throws Exception {
		Thread.sleep(2000);
		return errmsg.getText();
	}

	public void entervalueperformancefield(String performancevalue) throws Exception {
		Thread.sleep(2000);
		txt_Engineperformance.sendKeys(performancevalue);
		
	}
    //Now call dropdown method here(Created in commonmethod class)
	public  List<String> getdropdownlist() {
		return comonmethod.selectDDvalue(Modeldropdown);
		
	}

	
	
 //Below method will Enterdata in all the fields in the vehciledata page 
    public void enterdatainvehiclefields(HashMap<String,String> testdata) throws Exception 
    {
    	comonmethod.selectvaluefromDD( makedropdown, testdata.get("Vehicle_Make"));
    	Thread.sleep(2000);
    	comonmethod.selectvaluefromDD( Modeldropdown,testdata.get("Vehicle_Model"));
    	Thread.sleep(2000);
    	txt_cylinderfield.sendKeys(testdata.get("Vehicle_CylinderCapacity"));
    	Thread.sleep(2000);
    	txt_Engineperformance.sendKeys(testdata.get("Vehicle_Enging Performance"));
    	Thread.sleep(2000);
    	txt_datefield.sendKeys(testdata.get("Vehicle_Date of Manufacture"));//For date I didnt created seperated method to pick. Directly entering the value
    	Thread.sleep(2000);
    	comonmethod.selectvaluefromDD(drdo_NoofSeats,testdata.get("Vehicle_No of Seats_motorcycle"));
    	Thread.sleep(2000);
    	txt_Listprice.sendKeys(testdata.get("Vehicle_List Price"));
    	Thread.sleep(2000);
    	txt_Annualmileage.sendKeys(testdata.get("Vehicle_Annual Mileage"));
    }

//Creating Next button(WebElement) in seperate method
    public void clickonNextbutton() {
    	btn_Next.click();
    }
























}
