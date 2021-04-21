package basePackage;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import commonUtilities.ReadvaluesfromProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjectModel.HomepageElements_01;
import pageObjectModel.MotorCyclePE_02_EnterInsurantData02;
import pageObjectModel.MotorCyclePE_02_EnterProductdata03;
import pageObjectModel.MotorCyclePE_02_EnterVehicleData01;
import pageObjectModel.MotorCyclePE_02_SelectPriceOption04;

public class BaseClass extends InitializeObjectforAllPages {
	
	public static WebDriver driver;
	
	
	//Launching Browser..Making this method Static
	
	public void browser() throws Exception {
		
		String browser = ReadvaluesfromProperties.defineproaandfile("browser");
		String url = ReadvaluesfromProperties.defineproaandfile("url");
	    
		
        //Why we are using webdriverManager instead of writing syatem.set property and downloading chrome/firefox driver and put into project level
		if (browser.equalsIgnoreCase("chrome")) {
	       WebDriverManager.chromedriver().setup();
		   driver = new ChromeDriver();
		   }else if (browser.equalsIgnoreCase("firefox")) {
		    WebDriverManager.firefoxdriver().setup();
		    driver = new FirefoxDriver();
		   }
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	    
	    driver.get(url);
	    Thread.sleep(2000);
		}
	
	public static void failedTC_takescreenshot(String testmethodname) {
		File srcfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destinationpath = "C:\\Deepa\\EclipseWorkspace\\com.AutomationTalks_Project\\Screenshot\\" + testmethodname + ".jpeg";
		File dstinationpath =new File(destinationpath);
	  
			try {
				FileUtils.copyFile(srcfile, dstinationpath);
			} catch (IOException e) {
				e.printStackTrace();
			}
		
	}
	
	@BeforeMethod
	public void setupmethod() throws Exception {
		browser();
		home1stpage = new HomepageElements_01();
		mtrcyle1sttab =new MotorCyclePE_02_EnterVehicleData01();
		mtrcyle2ndtab = new MotorCyclePE_02_EnterInsurantData02();
		mtrcyle3rdtab = new MotorCyclePE_02_EnterProductdata03();
		mtrcycle4thtab =new MotorCyclePE_02_SelectPriceOption04();
	}
	
	//Quit browser
	@AfterMethod
	public static void quitbrowser() {
		driver.quit();
	}
	

}
