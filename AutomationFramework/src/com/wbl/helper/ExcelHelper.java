package com.wbl.helper;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelHelper {
	
	static Logger logger = LogManager.getLogger(ExcelHelper.class);
	public static Object[][] getData(String fileName){
		Object[][] data=null;
		XSSFWorkbook wb=null;
		try {
			//loading excel file into java XSSFWorkbook object
			wb = new XSSFWorkbook(new FileInputStream(Constants.PATH+fileName));
			
			//get required sheet from excel
			XSSFSheet sheet = wb.getSheet("login");
			
			int rows = sheet.getLastRowNum();//gives index value for last row
			data = new Object[rows][];
			System.out.println("no of rows:"+rows);
			for(int i=1;i<=rows;i++){
				XSSFRow row = sheet.getRow(i);
				int noOfcols = row.getLastCellNum();//giving no of cols
				
				String[] colData = new String[noOfcols];
				System.out.println("no of cols:"+noOfcols);
				for(int j=0;j<noOfcols;j++){
					System.out.println("col data::"+row.getCell(j).getStringCellValue());
					colData[j]=row.getCell(j).getStringCellValue();
				}
				
				data[i-1]= colData;
				
			}
			
			
			
		} catch (IOException e) {
			logger.error("There is an error in excel reading");
			e.printStackTrace();
		}finally{
			try {
				if(null!=wb){
				wb.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		return data;
		
	}

}
