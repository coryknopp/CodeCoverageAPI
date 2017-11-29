package formatter;

import data_model.Branch;
import data_model.Condition;
import data_model.Line;

public interface ResultsAnalyzer {

    boolean isLineCovered(int line);
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
    int linesInMethod(String y);
    int branchesInMethod(String y);
    int conditionsInMethod(String y);
    int linesCoveredInMethodCount(String y);
    int branchesCoveredInMethodCount(String y);
    int conditionsCoveredInMethodCount(String y);
    int[] linesCoveredByTest(Class<?> z);
    int[] branchesCoveredByTest(Class<?> z);
    int[] conditionsCoveredByTest(Class<?> z);
}
