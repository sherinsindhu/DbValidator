package com.abc.validator.xlshandler;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.abc.validator.pojo.TestCases;

public class ExcelUtility {

	 public static final String SAMPLE_XLSX_FILE_PATH = "C:\\Users\\wills\\Documents\\GitHub\\DbValidator\\DBValidator\\resources\\datasheet\\";
	 
	 public List<TestCases> readExcelData(String fileName) {
		
		List<TestCases> testData=new ArrayList<TestCases>();
		TestCases testCases = null;
		 try {
	     // Creating a Workbook from an Excel file (.xls or .xlsx)
	        Workbook workbook = WorkbookFactory.create(new File(SAMPLE_XLSX_FILE_PATH+fileName));
	     // Retrieving the number of sheets in the Workbook
	        System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets : ");
	        /*
	           =============================================================
	           Iterating over all the sheets in the workbook
	           =============================================================
	        */
	     // Create a DataFormatter to format and get each cell's value as String
	        DataFormatter dataFormatter = new DataFormatter();
	        for (int i=0;i<workbook.getNumberOfSheets();i++) {
	        Sheet sheet = workbook.getSheetAt(i);
	        String key ="";
	        HashMap<String, List<String>> tstdata =null;
             for (Row row: sheet) {
            	if(row.getRowNum()>0) {
            	for(Cell cell: row) {
	            	 String cellValue = dataFormatter.formatCellValue(cell);
	            	 
	            	if(cell.getColumnIndex()==0 && cellValue!=null){
	            		testCases =new TestCases();
	            		testCases.setTestNumber(cellValue);
	            		tstdata = new HashMap<String, List<String>>();
	            		testData.add(testCases);
	            	}else if(cell.getColumnIndex()==1) {
	            		key=cellValue;
	            		tstdata.put(key, new ArrayList<String>());
	            	}else {
	            		tstdata.get(key).add(cellValue);
	            	}
	               
	            }
	            testCases.setTestData(tstdata);
	           
            	}
	        }
             
	        }
	     // Closing the workbook
	        workbook.close();
	        System.out.print("Size******"+testData.size());
		 
		 }catch(IOException ioe){
			 ioe.printStackTrace();
		 }
		return testData;
		 
	 }



/*public static void main(String arg[]) {
	ExcelUtility e = new ExcelUtility();
	e.readExcelData("expectedResults.xlsx");
}*/
}