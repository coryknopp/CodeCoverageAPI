package data_model;

import java.util.HashMap;

public class ClassData {

    private String name;
    private HashMap<String, TestData> testData;

    public ClassData(String name) {
        this.name = name;
    }

    public void addTestData(TestData data) {

    }

    public HashMap<String, TestData> getTestData() {
        return testData;
    }

    public boolean isEmpty() {
        return true;
    }
}
