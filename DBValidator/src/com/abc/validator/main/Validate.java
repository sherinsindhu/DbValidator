package com.abc.validator.main;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;

import com.abc.validator.pojo.TestCases;
import com.abc.validator.queryhandler.IQueryHandler;
import com.abc.validator.queryhandler.QueryUtility;
import com.abc.validator.queryhandler.SimpleJDBCQueryHandle;
import com.abc.validator.xlshandler.ExcelUtility;

public class Validate {
	public static void main(String arg[]) {
		ExcelUtility excelUtility = new ExcelUtility();
		List<TestCases> testcases =excelUtility.readExcelData("expectedResults.xlsx");
		QueryUtility queryUtility = new QueryUtility();
		List<String> validationQuery =queryUtility.readValidtionQuery("C:\\Users\\wills\\Documents\\GitHub\\DbValidator\\DBValidator\\resources\\query\\validationQuery.txt");
		Validate validate = new Validate();
		validate.compareResults(testcases,validationQuery);
	}
	
	public void compareResults (List<TestCases> testCases,List<String> queryList) {
		int counter = 0 ;
		for(String query:queryList) {
			
			TestCases tc =testCases.get(counter);
				try {
					IQueryHandler oIQueryHandler = new SimpleJDBCQueryHandle();
					ResultSet rs =(ResultSet)oIQueryHandler.select(query);
					ResultSetMetaData rsmd=rs.getMetaData(); 
					List<String> data ;
					int cnt = 0;
					while (rs.next()) {
					for(int i=1;i<=rsmd.getColumnCount();i++) {
						String col =rsmd.getColumnName(i);
						data =tc.getTestData().get(col);
						if(data!=null && data.size()>0) {
							//System.out.println("***col*******"+col+"******data********"+data.size());
							//System.out.println("***(rs.getString(col)*******"+(rs.getString(col)+"******data.get(cnt)********"+data.get(cnt)));
						if(rs.getString(col).equalsIgnoreCase(data.get(cnt)))
								{
							     System.out.println(tc.getTestNumber()+"----------PASS");
								}
						else {
							     System.out.println(tc.getTestNumber()+"----------FAIL---"+"***MISMATCH DATA***"+rs.getString(col)+"---"+data.get(cnt));
								}
					}
						
					}
					cnt++;
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			counter++;
			
		}
		
	}
}
