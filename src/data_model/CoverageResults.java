package data_model;

import java.util.*;

public class CoverageResults implements CoverageData {

    // The data model is HashMap<String, HashMap<TestMethod, Object[]>> .
    // The Object[] holds three array lists of Lines, Branches, and Conditions.
    // The TestMethod is the test that hit those Lines, Branches and Conditions.
    private HashMap<String, HashMap<TestClass, Object[]>> coverage;
    private ArrayList<TestClass> allTests = new ArrayList<TestClass>();

    public CoverageResults() {
        coverage = new HashMap<String, HashMap<TestClass, Object[]>>();
        allTests = new ArrayList<TestClass>();
    }

    // Add the testMethod to the array with all test methods.
    public void addTestMethod(TestClass testClass) {
        allTests.add(testClass);
    }

    @SuppressWarnings("unchecked")
    public void addLine(TestClass testClass, String className, Line line) {
        addClassAndTest(testClass, className);
        Object[] objectArray = coverage.get(className).get(testClass);
        ArrayList<Line> lineList = ((ArrayList<Line>)objectArray[0]);
        lineList.add(line);
        objectArray[0] = lineList;
        coverage.get(className).put(testClass, objectArray);
    }

    @SuppressWarnings("unchecked")
    public void addBranch(TestClass testClass, String className, Branch branch) {
        addClassAndTest(testClass, className);
        Object[] objectArray = coverage.get(className).get(testClass);
        ArrayList<Branch> branchList = ((ArrayList<Branch>)objectArray[1]);
        branchList.add(branch);
        objectArray[1] = branchList;
        coverage.get(className).put(testClass, objectArray);
    }

    @SuppressWarnings("unchecked")
    public void addCondition(TestClass testClass, String className, Condition condition) {
        addClassAndTest(testClass, className);
        Object[] objectArray = coverage.get(className).get(testClass);
        ArrayList<Condition> conditionList = ((ArrayList<Condition>)objectArray[2]);
        conditionList.add(condition);
        objectArray[2] = conditionList;
        coverage.get(className).put(testClass, objectArray);
    }

    // Add the class and test to the map.
    public void addClassAndTest(TestClass testClass, String className) {
        if (coverage.get(className) == null) {
            HashMap<TestClass, Object[]> innerMap = new HashMap<TestClass,  Object[]>();
            coverage.put(className, innerMap);
        }
        if (coverage.get(className).get(testClass) == null) {
            Object[] objectArray = new Object[3];
            ArrayList<Line> lineArrayList = new ArrayList<Line>();
            ArrayList<Branch> branchArrayList = new ArrayList<Branch>();
            ArrayList<Condition> conditionArrayList = new ArrayList<Condition>();
            objectArray[0] = lineArrayList;
            objectArray[1] = branchArrayList;
            objectArray[2] = conditionArrayList;
            coverage.get(className).put(testClass, objectArray);
        }
    }
}
