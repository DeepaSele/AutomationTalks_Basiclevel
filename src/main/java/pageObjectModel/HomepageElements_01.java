package pageObjectModel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePackage.BaseClass;

public class HomepageElements_01 extends BaseClass{
	
	
	//Created page object model without Page Factory below are the Examples. In TWKS we are following without PageFactory
	
/* WebElement automobile =driver.findelement(By.xpath("//input[@id="nav_automobile"])).click(); 
 */

//For this Project We are following with PAGEFACTORY. 
	
	
	@FindBy(id="nav_automobile")
	WebElement automobileicon;
	
	@FindBy(id="nav_truck")
	WebElement truchicon;
	
	@FindBy(xpath= "//*[@id=\"nav_motorcycle\"]")
	WebElement motorcycleicon;
	
	@FindBy(id="nav_camper")
	WebElement campericon;
	
	//Need to create Constructor -to use IntiElem
	public HomepageElements_01() {
		PageFactory.initElements(driver,this);
	}

	
	public void clickonMotorcycle() throws Exception {
		Thread.sleep(2000);
		motorcycleicon.click();
		Thread.sleep(2000); 	
	}
	
	

}
