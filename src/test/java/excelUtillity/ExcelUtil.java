package excelUtillity;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import resources.Utils;


public class ExcelUtil {
	

	public static ExcelReader reader;
	Map<String,String> xl;


	public static List<Map<String, String>> getxlData(String SheetName) {

		reader = new ExcelReader();
		// ********* data from excel ********** //
		
		List<Map<String, String>> data = null;
		try {
			data = reader.getData(Utils.getGlobalValue("ExcelFilePath"), SheetName);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return data;
	}
	
    
	

}
