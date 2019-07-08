package com.abc.validator.queryhandler;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.abc.validator.xlshandler.ExcelUtility;

public class QueryUtility {

	 public List<String> readValidtionQuery(String fileName){
		
		File file = new File(fileName);
		Scanner in = null;
		List<String> queryList = new ArrayList<>();
		try {
			in = new Scanner(file);
			while (in.hasNext()) {
				String line = in.nextLine();
				//System.out.println(line);
				queryList.add(line);
			}
		} catch (Exception e1) { // TODO Auto-generated catch block
			e1.printStackTrace();
			
		} 
      return queryList;
	}

	/* public static void main(String arg[]) {
		 QueryUtility e = new QueryUtility();
			e.readValidtionQuery("C:\\Users\\wills\\Desktop\\Sindhu\\plan\\projects\\workspace\\DBValidator\\src\\resources\\query\\validationQuery.txt");
		}*/
}
