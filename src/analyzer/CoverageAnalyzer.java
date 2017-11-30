package analyzer;

import data_model.*;
import formatter.ResultsAnalyzer;

public class CoverageAnalyzer implements ResultsAnalyzer {

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

    @Override
    public boolean isConditionCovered(String className, int line, int condition) {
        return false;
    }

    @Override
    public int lineCoveredCount(String className, int line) {
        HashMap<String, MethodData> methodData = projectData.getMethodData(className);
        int count = 0 
        for (MethodData method : methodData.values()) {
            lines = method.getLines();
            for (Line l : method.getLines) {
                if (l.getLineNumber() == line) {
                    count++;
                }
            }
        }
        return count;
    }

    @Override
    public int branchCoveredCount(Branch branch) {
        return 0;
    }

    @Override
    public int conditionCoveredCount(Condition condition) {
        return 0;
    }

    @Override
    public int totalLines() {
        return 0;
    }

    @Override
    public int totalBranches() {
        return 0;
    }

    @Override
    public int totalConditions() {
        return 0;
    }

    @Override
    public int totalLinesCovered() {
        return 0;
    }

    @Override
    public int totalBranchesCovered() {
        return 0;
    }

    @Override
    public int totalConditionsCovered() {
        return 0;
    }

    @Override
    public int linesInMethod(String y) {
        return 0;
    }

    @Override
    public int branchesInMethod(String y) {
        return 0;
    }

    @Override
    public int conditionsInMethod(String y) {
        return 0;
    }

    @Override
    public int linesCoveredInMethodCount(String y) {
        return 0;
    }

    @Override
    public int branchesCoveredInMethodCount(String y) {
        return 0;
    }

    @Override
    public int conditionsCoveredInMethodCount(String y) {
        return 0;
    }

    @Override
    public int[] linesCoveredByTest(Class<?> z) {
        return new int[0];
    }

    @Override
    public int[] branchesCoveredByTest(Class<?> z) {
        return new int[0];
    }

    @Override
    public int[] conditionsCoveredByTest(Class<?> z) {
        return new int[0];
    }
}
