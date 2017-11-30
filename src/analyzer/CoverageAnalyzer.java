package analyzer;

import data_model.*;
import formatter.ResultsAnalyzer;

public class CoverageAnalyzer {

    private CoverageResults coverage;
    private HashMap<String, ProjectData> projectData; 

    public CoverageAnalyzer(CoverageResults coverage) {
        this.coverage = coverage;
        this.projectData = coverage.getProjectData();
    }

    public boolean isLineCovered(String className, int line) {
        boolean con = false;
        if (lineCoveredCount(className, line) > 0) {
            con = true;
        }
        return con;
    }

    public boolean isBranchCovered(String className, int line) {
      return false;
    }


    public boolean isConditionCovered(String className, int line, int condition) {
        return false;
    }

    public int lineCoveredCount(String className, int line) {
        HashMap<String, MethodData> methodData = coverage.getMethodData(className);
        int count = 0;
        for (MethodData method : methodData.values()) {
            for (Line l : method.getLines()) {
                if (l.getLineNumber() == line) {
                    count++;
                }
            }
        }
        return count;
    }


    public int branchCoveredCount(Branch branch) {
        return 0;
    }


    public int conditionCoveredCount(Condition condition) {
        return 0;
    }


    public int totalLines() {
        return 0;
    }


    public int totalBranches() {
        return 0;
    }


    public int totalConditions() {
        return 0;
    }


    public int totalLinesCovered() {
        return 0;
    }


    public int totalBranchesCovered() {
        return 0;
    }


    public int totalConditionsCovered() {
        return 0;
    }


    public int linesInMethod(String y) {
        return 0;
    }


    public int branchesInMethod(String y) {
        return 0;
    }


    public int conditionsInMethod(String y) {
        return 0;
    }


    public int linesCoveredInMethodCount(String y) {
        return 0;
    }


    public int branchesCoveredInMethodCount(String y) {
        return 0;
    }


    public int conditionsCoveredInMethodCount(String y) {
        return 0;
    }


    public int[] linesCoveredByTest(Class<?> z) {
        return new int[0];
    }


    public int[] branchesCoveredByTest(Class<?> z) {
        return new int[0];
    }


    public int[] conditionsCoveredByTest(Class<?> z) {
        return new int[0];
    }
}
