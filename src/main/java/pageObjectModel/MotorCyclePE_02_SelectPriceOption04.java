package pageObjectModel;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePackage.BaseClass;

public class MotorCyclePE_02_SelectPriceOption04 extends BaseClass {

	
	@FindBy(xpath="//button[@name='Next (Send Quote)']")
	WebElement btn_next;
	
 
//Create Constructor
	public MotorCyclePE_02_SelectPriceOption04() {
		PageFactory.initElements(driver, this);
	}
	
/*There	are 5 rows 4 headers
	I want to get any one price value from gold,silver,platinum . 
	passing value as parameter in the method. My planname i can pass as either Gold/silver
	get value or text from that webelement pass into this method
*/	

	
public String getpricefromWebTable(String pricevalue) throws Exception {
	String dataxpath ="//table[@id='priceTable']//tr[1]//td[@data-label='"+ pricevalue +"']/span";
	WebElement planprice =driver.findElement(By.xpath(dataxpath));
	Thread.sleep(2000);
	return planprice.getText();
	
}
	

/*Ok Now i got value from either one plan, but i need to select any one plan.
 * Create dynamic xpath for that too. Below method have been written
 * 
 */
 public void selectoptionPlan(String planvalue) throws Exception {
	 String locator ="//input[@name='Select Option' and @value='"+planvalue+"']/parent::label";
	 driver.findElement(By.xpath(locator)).click();
	 Thread.sleep(2000);
 }

//click on next button
 public void clickonnextbutton() {
	 btn_next.click(); 
 }


}
