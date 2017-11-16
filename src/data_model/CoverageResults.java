package data_model;

import java.util.*;

public class CoverageResults implements CoverageData {

    // Data model:
    // HashMap<Class, HashMap<TestClass, ArrayList<Object>[]>>

    // Holds info about line coverage. String is the class the line is in,
    // Integer is the line number, and Boolean is if it is covered or not.
    // <ClassName <LineNumber, isLineCovered>>
    private static Map<String, HashMap<Integer, Line>> lineCoverage;
    private HashMap<Class, HashMap<TestClass, ArrayList<Object>[]>> coverage;

    public CoverageResults() {
        lineCoverage = new HashMap<>();
        coverage = new HashMap<>();
    }

    // Not sure how to use this yet.
    public void addTestMethod(TestClass testClass) {

    }

    public void addLine(Line line) {
        // If the class has not yet been added to the map, add it to the map.
        if(lineCoverage.get(line.className()) == null) {
            HashMap<Integer, Line> innerMap = new HashMap<>();
            innerMap.put(line.lineNumber(), line);
            lineCoverage.put(line.className(), innerMap);
        }

        // Add the line data to the map.
        lineCoverage.get(line.className()).put(line.lineNumber(), line);
    }

    public void addBranch(Branch branch) {
        // How do we identify a branch? Can we just use its line number?
        // If so we don't need to add anything to the data structure for this.
    }

    public void addCondition(Condition condition) {

    }
}
