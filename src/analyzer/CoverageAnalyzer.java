package analyzer;

import data_model.*;
import formatter.ResultsAnalyzer;

public class CoverageAnalyzer implements ResultsAnalyzer {

    private CoverageResults coverage;

    public CoverageAnalyzer(CoverageResults coverage) {
        this.coverage = coverage;
    }

    // This should probably be something more like isLineCovered(String className, int lineNumber)
    @Override
    public boolean isLineCovered(Line line) {
        /*if(coverage.lineCoverage.get(line.className()).get(line.lineNumber()) == null)
            return false;
        else
            return coverage.lineCoverage.get(line.className()).get(line.lineNumber());*/
        return false;
    }

    @Override
    public boolean isBranchCovered(Branch branch) {
      return false;
    }

    @Override
    public boolean isConditionCovered(Condition condition) {
        return false;
    }

    @Override
    public int lineCoveredCount(Line line) {
        return 0;
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
    public int linesInMethod(TestClass y) {
        return 0;
    }

    @Override
    public int branchesInMethod(TestClass y) {
        return 0;
    }

    @Override
    public int conditionsInMethod(TestClass y) {
        return 0;
    }

    @Override
    public int linesCoveredInMethodCount(TestClass y) {
        return 0;
    }

    @Override
    public int branchesCoveredInMethodCount(TestClass y) {
        return 0;
    }

    @Override
    public int conditionsCoveredInMethodCount(TestClass y) {
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
