package data_model;

import java.util.HashMap;

public class ClassData {

    private String name;
    private HashMap<String, TestData> data;

    public ClassData(String name) {
    	this.name = name;
    }

    public addTestData(TestData testData) {
    	data.put(testData.getName(), TestData);
    }

    public String getName() {
    	return name;
    }

    public getTestData() {
    	return data;
    }

}
