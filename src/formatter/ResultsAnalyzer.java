package formatter;

import data_model.Branch;
import data_model.Condition;
import data_model.Line;
import data_model.TestMethod;

public interface ResultsAnalyzer {

    boolean isLineCovered(Line line);
    boolean isBranchCovered(Branch branch);
    boolean isConditionCovered(Condition condition);
    int lineCoveredCount(Line line);
    int branchCoveredCount(Branch branch);
    int conditionCoveredCount(Condition condition);
    int totalLines();
    int totalBranches();
    int totalConditions();
    int totalLinesCovered();
    int totalBranchesCovered();
    int totalConditionsCovered();
    int linesInMethod(TestMethod y);
    int branchesInMethod(TestMethod y);
    int conditionsInMethod(TestMethod y);
    int linesCoveredInMethodCount(TestMethod y);
    int branchesCoveredInMethodCount(TestMethod y);
    int conditionsCoveredInMethodCount(TestMethod y);
    int[] linesCoveredByTest(Class<?> z);
    int[] branchesCoveredByTest(Class<?> z);
    int[] conditionsCoveredByTest(Class<?> z);
}
