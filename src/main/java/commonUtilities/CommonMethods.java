package commonUtilities;

import static org.testng.Assert.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CommonMethods {
	
//Below method creating for common dropdowns. Scenario 1 -comparing list of values in the dropdown with expected one
	
	public List<String> selectDDvalue(WebElement element) {
		//Created object in Select class
		Select selectclass = new Select(element);
		
		//getoptions will give you list of all options are available in the dropdowns. Need to store in the List objects
		List<WebElement> listofwebelements = selectclass.getOptions();
		
		//Create one class/ref for keeping list of webelements text
		List<String> valuesintheDD =new ArrayList<String>();
		
		//Here Using FOR-EACH loop to iterate each element
		for(WebElement elements:listofwebelements)
		{
			valuesintheDD.add(elements.getText());
		}		
		//Now return all the TEXT
		return valuesintheDD;
		
		
	}
	
//Scenario 2 - How to select values from dropdown. Creating own expection if the value is not present in the dropdown
 public void selectvaluefromDD(WebElement element, String value) throws Exception {
	 Select selectobj = new Select(element); 
	 try
	   {
		 selectobj.selectByVisibleText(value);	 
	   } catch (Exception e)
	   {
		 throw new Exception("Value is not present under the element " +element + "in the dropdown. Value is: "+value);
	   }
	 selectobj.selectByVisibleText(value); //Passing the Parameter for ex: Honda,Bmw
 }

 
 
 
//Below code from AutomationTalks for RadioButtons. Using for selecting optional products
	 public void selectoptionalorradioprods(List<WebElement> elements, String valuesofradio)
	 {
		 for(WebElement refs: elements)
		 {
			 if(refs.getText().equalsIgnoreCase(valuesofradio))
			 {
				 refs.click();
				 break;
		     }
	      }
	
      }
 
 
 
//For gender radiobutton  we will select only one option. But in the checkbox I may select 2 or 3 options.Below code
 public void selectmorevaluesfromCheckbox(List <WebElement> element, String valuesfromchkbox) throws Exception {
	 //In excel i gave checkbox value like ex: Speeding,others how this string will select. There is method called SPLIT
     //Have to store each value in String array
	 String[] valuesstoredinArrays = valuesfromchkbox.split(",");
	 	 
	 //Two for loops following 
	 
	 for(String stringvalues: valuesstoredinArrays)  //Args as Speeding, other
	 {	 
	    for(WebElement ele :element)
	    {
		  if( ele.getText().equalsIgnoreCase(stringvalues))
		    {
			  ele.click();
			  break; 
		    } 
	    }
	   
	  }
	 
 }
 


 
 

 
 
 
 
}
