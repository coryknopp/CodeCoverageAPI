package analyzer;

import formatter.ResultsAnalyzer;

import java.lang.reflect.Method;

public class CoverageAnalyzer implements ResultsAnalyzer {

    public CoverageAnalyzer() {

    }

    @Override
    public boolean isLineCovered(int line) {
        return false;
    }

    @Override
    public boolean isBranchCovered(int branch) {
        return false;
    }

    @Override
    public boolean isConditionCovered(int line, int condition) {
        return false;
    }

    @Override
    public int lineCoveredCount(int line) {
        return 0;
    }

    @Override
    public int branchCoveredCount(int branch) {
        return 0;
    }

    @Override
    public int conditionCoveredCount(int line, int condition) {
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
    public int linesInMethod(Method y) {
        return 0;
    }

    @Override
    public int branchesInMethod(Method y) {
        return 0;
    }

    @Override
    public int conditionsInMethod(Method y) {
        return 0;
    }

    @Override
    public int linesCoveredInMethodCount(Method y) {
        return 0;
    }

    @Override
    public int branchesCoveredInMethodCount(Method y) {
        return 0;
    }

    @Override
    public int conditionsCoveredInMethodCount(Method y) {
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
