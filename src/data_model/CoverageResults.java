package data_model;

import java.util.*;

public class CoverageResults implements CoverageData {

    // The data model is HashMap<String, HashMap<TestMethod, ArrayList<Object>[]>> .
    // The ArrayList<Object>[] holds three array lists of Lines, Branches, and Conditions.
    // The TestMethod is the test that hit those Lines, Branches and Conditions.
    // private HashMap<String, HashMap<String, ArrayList<Object>[]>> coverage;
    private HashMap<String, HashMap<String, Object[]>> coverage;
    // private HashMap<String, ClassData> coverage;
    private ArrayList<String> allTests = new ArrayList<>();

    public CoverageResults() {
        coverage = new HashMap<>();
        allTests = new ArrayList<>();
    }

    // Add the testMethod to the array with all test methods.
    public void addTestMethod(String testMethod) {
        allTests.add(testMethod);
    }

    public void addLine(String testMethod, String className, Line line) {
        addClassAndTest(testMethod, className);
        Object[] objectArray = coverage.get(className).get(testMethod);
        ArrayList<Line> lineList = ((ArrayList<Line>) objectArray[0]);
        lineList.add(line);
        objectArray[0] = lineList;
        coverage.get(className).put(testMethod, objectArray);
    }

    public void addBranch(String testMethod, String className, Branch branch) {
        addClassAndTest(testMethod, className);
        Object[] objectArray = coverage.get(className).get(testMethod);
        ArrayList<Branch> branchList = ((ArrayList<Branch>) objectArray[1]);
        branchList.add(branch);
        objectArray[1] = branchList;
        coverage.get(className).put(testMethod, objectArray);
    }

    public void addCondition(String testMethod, String className, Condition condition) {
        addClassAndTest(testMethod, className);
        Object[] objectArray = coverage.get(className).get(testMethod);
        ArrayList<Condition> conditionList = ((ArrayList<Condition>) objectArray[2]);
        conditionList.add(condition);
        objectArray[2] = conditionList;
        coverage.get(className).put(testMethod, objectArray);
    }

    public void addClassAndTest(String testMethod, String className) {
        if (coverage.get(className) == null) {
            HashMap<String, Object[]> innerMap = new HashMap<>();
            coverage.put(className, innerMap);
        }
        if (coverage.get(className).get(testMethod) == null) {
            Object[] objectArray = new Object[3];
            ArrayList<Line> lineArrayList = new ArrayList<>();
            ArrayList<Branch> branchArrayList = new ArrayList<>();
            ArrayList<Condition> conditionArrayList = new ArrayList<>();
            objectArray[0] = lineArrayList;
            objectArray[1] = branchArrayList;
            objectArray[2] = conditionArrayList;
            coverage.get(className).put(testMethod, objectArray);
        }
    }

    public Line getLine(int line) {
        return null;
    }

    public Branch getBranch(int line) {
        return null;
    }

    public Condition getCondition(int line, int condition) {
        return null;
    }

    public String getTestClass(String name) {
        return null;
    }

    public boolean getLineCoverage(int line, String className) {
        /*ArrayList<Object> lineList = coverage.get(className).get("Temporary test")[0];
        for (Object obj : lineList) {
            Line l = (Line) obj;
            if (line == l.getLineNumber()) {
                return true;
            }
        }
        return false;*/
        return false;
    }

    public boolean getBranchCoverage(int branch, String className) {
        return false;
    }

    public boolean getConditionCoverage(int line, int condition) {
        return false;
    }

    public boolean getTestClassCoverage(String testMethod) {
        return false;
    }
}
