package analyzer;

import data_model.*;
import formatter.ResultsAnalyzer;

public class CoverageAnalyzer {

    private CoverageResults coverage;

    public CoverageAnalyzer(CoverageResults coverage) {
        this.coverage = coverage;
    }
 
    public boolean isLineCovered(String className, int line) {
        if (coverage.getLine(className, line) == null) {
            return false;
        }
        else {
            return true;
        }
    }

    public boolean isBranchCovered(String className, int line) {
        if (coverage.getBranch(className, line) == null) {
            return false;
        }
        else {
            return true;
        }
    }

    public boolean isConditionCovered(String className, int line, int condition) {
        if (coverage.getCondition(className, line, condition) == null) {
            return false;
        }
        else {
            return true;
        }
    }



    public int lineCoveredCount(String className, int line) {
        return 0;
    }


    public int branchCoveredCount(String className, int line) {
        return 0;
    }


    public int conditionCoveredCount(String className, int line, int condition) {
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
