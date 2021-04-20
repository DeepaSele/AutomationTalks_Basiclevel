package commonUtilities;

import java.io.File;
 
import java.util.HashMap;

 
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelOperations {
	
/** This class created for Reading data from Excel and put in Hashmap
 * Location -where is Excel file. We can give location in properties file / or in the Method as well
 * Open the Excel file
 * Read data row by row
 * Put them in HashMap 	
 * @return 
 * @throws Exception 
 *  
 */
	
	
public HashMap<String,String> readdatafromExcel(int rownum) throws  Exception {
	//Give data where stored in the project
	
	String datapath ="C:\\Deepa\\EclipseWorkspace\\com.AutomationTalks_Project\\TestData\\TestData_Tricentis.xlsx";
    File testdatfile =new File(datapath);
	
//No Need to create workbook object instead of that creating object in workbookFactory. This class can take xlsx or hssf	
	Workbook wb =WorkbookFactory.create(testdatfile);
	Sheet sheet =wb.getSheet("InsurancePremium");//I can pass sheet name or index name
	
//Creating object in HashMap
	HashMap <String,String> hs =new HashMap<String,String>();
	
	
	for(int i=0; i<sheet.getRow(0).getLastCellNum(); i++) //getrow(0) this has header level
	{    
		//Convert cell value into String. If we have date in cell then it should convert into String
		sheet.getRow(rownum).getCell(i).setCellType(CellType.STRING);
		hs.put(sheet.getRow(0).getCell(i).toString(), sheet.getRow(rownum).getCell(i).toString());                                                      //put in hashmap
		         //This is KEY                      ,  This is VALUE
	}
	return hs;
	}
	
	
/**public static void main(String[] args) throws Exception {
	ExcelOperations obj =new ExcelOperations();
	System.out.println(obj.readdatafromExcel(1));
}
*/	
	
	
	
	

	
}
