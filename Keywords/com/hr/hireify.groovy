package com.hr

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable
import java.io.File;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import  org.apache.poi.hssf.usermodel.HSSFSheet;
import  org.apache.poi.hssf.usermodel.HSSFWorkbook;
import  org.apache.poi.hssf.usermodel.HSSFRow;

import java.io.File;

import java.io.FileInputStream;

import java.io.FileOutputStream;

import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.ss.usermodel.Cell;

import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.ss.usermodel.Workbook;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class hireify {

	@Keyword
	def WritetoExcelFile(ArrayList<String> Value, filename) {

		//String filename = "D:\\Hireify.co\\Hireify.co\\Unable to Find Jobs\\Unable to Find Jobs.xlsx";
		File f = new File(filename)
		String absolute = f.getAbsolutePath()
		System.out.println(absolute)
		filename = absolute;
		//creating an instance of HSSFWorkbook class
		HSSFWorkbook workbook = new HSSFWorkbook();
		//invoking creatSheet() method and passing the name of the sheet to be created
		HSSFSheet sheet = workbook.createSheet("NotFound");
		//creating the 0th row using the createRow() method
		//HSSFRow rowhead = sheet.createRow((short)0);
		//creating cell by using the createCell() method and setting the values to the cell by using the setCellValue() method

		for(def rowNum=0;rowNum<=Value.size();rowNum++) {
			HSSFRow rowhead = sheet.createRow((short)rowNum);
			rowhead.createCell(1).setCellValue(Value[rowNum]);
		}

		//				rowhead.createCell(1).setCellValue("Customer Name");
		//				rowhead.createCell(2).setCellValue("Account Number");
		//				rowhead.createCell(3).setCellValue("e-mail");
		//				rowhead.createCell(4).setCellValue("Balance");
		//				//creating the 1st row
		//				HSSFRow row = sheet.createRow((short)1);
		//				//inserting data in the first row
		//				row.createCell(0).setCellValue("1");
		//				row.createCell(1).setCellValue("John William");
		//				row.createCell(2).setCellValue("9999999");
		//				row.createCell(3).setCellValue("william.john@gmail.com");
		//				row.createCell(4).setCellValue("700000.00");
		//				//creating the 2nd row
		//				HSSFRow row1 = sheet.createRow((short)2);
		//				//inserting data in the second row
		//				row1.createCell(0).setCellValue("2");
		//				row1.createCell(1).setCellValue("Mathew Parker");
		//				row1.createCell(2).setCellValue("22222222");
		//				row1.createCell(3).setCellValue("parker.mathew@gmail.com");
		//				row1.createCell(4).setCellValue("200000.00");
		FileOutputStream fileOut = new FileOutputStream(filename);
		workbook.write(fileOut);
		//closing the Stream
		fileOut.close();
		//closing the workbook
		workbook.close();
		//prints the message on the console
		System.out.println("Excel file has been generated successfully.");
	}

	public void writeExcel(ArrayList<String> dataToWrite) throws IOException{

		//Create an object of File class to open xlsx file
		String filePath = "\\Hireify.co\\Hireify.co\\Jobs Keywords"
		String fileName = "Unable to Find Jobs.xlsx"
		String sheetName = "Not Found";

		File file =    new File(filePath+"\\"+fileName);
		File f = new File(file)
		String absolute = f.getAbsolutePath()
		System.out.println(absolute)
		file = absolute;
		//Create an object of FileInputStream class to read excel file

		FileInputStream inputStream = new FileInputStream(file);

		Workbook guru99Workbook = null;

		//Find the file extension by splitting  file name in substring and getting only extension name

		String fileExtensionName = fileName.substring(fileName.indexOf("."));

		//Check condition if the file is xlsx file

		if(fileExtensionName.equals(".xlsx")){

			//If it is xlsx file then create object of XSSFWorkbook class

			guru99Workbook = new XSSFWorkbook(inputStream);

		}

		//Check condition if the file is xls file

		else if(fileExtensionName.equals(".xls")){

			//If it is xls file then create object of XSSFWorkbook class

			guru99Workbook = new HSSFWorkbook(inputStream);

		}

		//Read excel sheet by sheet name

		Sheet sheet = guru99Workbook.getSheet(sheetName);

		//Get the current count of rows in excel file

		int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();

		//Get the first row from the sheet

		Row row = sheet.getRow(0);

		//Create a new row and append it at last of sheet

		Row newRow = sheet.createRow(rowCount+1);

		//Create a loop over the cell of newly created Row

		for(int j = 0; j < row.getLastCellNum(); j++){

			//Fill data in row

			Cell cell = newRow.createCell(j);

			cell.setCellValue(dataToWrite[j]);

		}

		//Close input stream

		inputStream.close();

		//Create an object of FileOutputStream class to create write data in excel file

		FileOutputStream outputStream = new FileOutputStream(file);

		//write data in the excel file

		guru99Workbook.write(outputStream);

		//close output stream

		outputStream.close();

	}
}
