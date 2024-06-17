package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcel {
	
	public static FileInputStream fi;
	public static XSSFWorkbook xb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static void setCellData(String xlsheet,int rownum,int colnum,String data) throws IOException
	{
		String xlfile = System.getProperty("user.dir") + "\\testData\\outputfile.xlsx";
		fi = new FileInputStream(xlfile);
	    xb = new XSSFWorkbook(fi);
	    ws = xb.getSheet(xlsheet);
	    // Check if the row exists, and create one if it doesn't
	    row = ws.getRow(rownum);
	    if (row == null) {
	        row = ws.createRow(rownum);
	    }
	    // Create a cell in the row and set its value
	    cell = row.createCell(colnum);
	    cell.setCellValue(data);
	    // Write the changes back to the file
	    FileOutputStream fo = new FileOutputStream(xlfile);
	    xb.write(fo);
	    // Close all the resources to prevent memory leaks
	    xb.close();
	    fi.close();
	    fo.close();
	}
	public static void createExcel() throws IOException {
	    // Define the path to the Excel file
	    String file = System.getProperty("user.dir") + "\\testData\\outputfile.xlsx";
	    // Create a file output stream to write to the Excel file
	    FileOutputStream fo = new FileOutputStream(file);
	    // Create a new Excel workbook
	    XSSFWorkbook xb = new XSSFWorkbook();
	    // Create a new sheet named "profile"
	    XSSFSheet sheet1 = xb.createSheet("Health Insurance");
	    XSSFSheet sheet2 = xb.createSheet("Car Insurance");
	    XSSFSheet sheet3 = xb.createSheet("travel Insurance");
	    
	    Font font = xb.createFont();//creating
		font.setBold(true);//setting font as Bold
		CellStyle style = xb.createCellStyle();//creating cellStyle
		style.setFont(font);//Applying cell style as Bold
	    // Create the first row in the sheet
	    XSSFRow rowSheet1 = sheet1.createRow(0);
	    XSSFRow rowSheet2 = sheet2.createRow(0);
	    XSSFRow rowSheet3 = sheet3.createRow(0);
	  
	    // Create cells for "MenuItem" 
	    XSSFCell MenuItem = rowSheet1.createCell(0);
	    XSSFCell error = rowSheet2.createCell(0);
	    
	    XSSFCell plan=rowSheet3.createCell(0);
	    XSSFCell price=rowSheet3.createCell(1);
	   
	    MenuItem.setCellValue("HC_MenuLists");
	    MenuItem.setCellStyle(style);
	    
	    error.setCellValue("Error_Msg");
	    error.setCellStyle(style);
	    
	    plan.setCellValue("Plan");
	    plan.setCellStyle(style);
	    price.setCellValue("Price");
	    price.setCellStyle(style);
	   

	    // Write the workbook to the file output stream
	    xb.write(fo);
	    // Close the workbook and the file output stream
	    xb.close();
	    fo.close();
	}
}
