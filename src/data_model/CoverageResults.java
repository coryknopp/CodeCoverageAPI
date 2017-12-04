package data_model;

import java.util.*;

public class CoverageResults implements CoverageData {

    private HashMap<String, ProjectData> coverage;

    // private ArrayList<TestClass> allTests = new ArrayList<TestClass>();

    public CoverageResults() {
        coverage = new HashMap<String, ProjectData>();

        // allTests = new ArrayList<TestClass>();
    }

    public void addProjectData(ProjectData projectData) {
        coverage.put(projectData.getName(), projectData);
    }


    public void addTestMethod(String testClass) {
        // allTests.add(testClass);
    }

    public void addLine(String testClass, String className, Line line) {

    }

    public void addBranch(String testClass, String className, Branch branch) {

    }

    public void addCondition(String testClass, String className, Condition condition) {

    }

    public void addClassAndTest(String testClass, String className) {

    }

    public ProjectData get(String className) {
        return coverage.get(className);
    }

    public HashMap<String, MethodData> getMethodData(String projectClass) {
        return coverage.get(projectClass).getMethodData();
    }

    public HashMap<String, ProjectData> getCoverage() {
      return coverage;
    }

}
