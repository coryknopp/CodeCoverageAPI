package data_model;

import java.util.HashMap;

public class TestData {

    private String name;
    private HashMap<Integer, Line> lineData;

    public TestData(String name) {
        this.name = name;
    }

    public void addLineData(Line line) {

    }

    public Line getLineData(int line) {
        return lineData.get(line);
    }
}
