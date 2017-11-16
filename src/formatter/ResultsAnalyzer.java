package formatter;

import data_model.Branch;
import data_model.Condition;
import data_model.Line;
import data_model.TestClass;

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
    int linesInMethod(TestClass y);
    int branchesInMethod(TestClass y);
    int conditionsInMethod(TestClass y);
    int linesCoveredInMethodCount(TestClass y);
    int branchesCoveredInMethodCount(TestClass y);
    int conditionsCoveredInMethodCount(TestClass y);
    int[] linesCoveredByTest(Class<?> z);
    int[] branchesCoveredByTest(Class<?> z);
    int[] conditionsCoveredByTest(Class<?> z);
}
