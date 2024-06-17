package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataReader {
	
	public static String Name;
	public static String E_Mail;
	public static String Phone_No;
	static XSSFCell f_name;
	static XSSFCell mail;
	static XSSFCell phone;
	

	public static void ExcelData() throws Exception {
		try {
			
			FileInputStream fs=new FileInputStream("C:\\Users\\2318570\\eclipse-workspace\\Hackthon\\testData\\ReadDataFile.xlsx");
			XSSFWorkbook workbook=new XSSFWorkbook(fs);
			XSSFSheet sheet=workbook.getSheetAt(0);
			XSSFRow row=sheet.getRow(1);
			
			Name=row.getCell(0).toString();
			E_Mail=row.getCell(1).toString();
			Phone_No=row.getCell(2).toString();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
