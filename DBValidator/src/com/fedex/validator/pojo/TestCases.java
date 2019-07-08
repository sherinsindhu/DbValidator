package com.fedex.validator.pojo;

import java.util.HashMap;
import java.util.List;

public class TestCases {

	String testNumber;
	HashMap<String, List<String>> testData;
	
	public String getTestNumber() {
		return testNumber;
	}
	public void setTestNumber(String testNumber) {
		this.testNumber = testNumber;
	}
	public HashMap<String, List<String>> getTestData() {
		return testData;
	}
	public void setTestData(HashMap<String, List<String>> testData) {
		this.testData = testData;
	}
	
}
