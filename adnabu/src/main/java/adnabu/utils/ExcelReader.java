package adnabu.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {


	/**
	 * This method is used to fetch the value of the cell.
	 * @param filePath
	 * @param sheetName
	 * @param rownum
	 * @param cellnum
	 * @return
	 * @throws IOException
	 */
	
	public String readDataFromExcel(String filePath,String sheetName ,int rownum ,int cellnum) throws IOException
	{

		File file = new File(filePath);
		String filepath = file.getAbsolutePath();
		FileInputStream fis = new FileInputStream(filepath);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		String celldata = sheet.getRow(rownum).getCell(cellnum).toString();
		return celldata;
	}
	
	
}
