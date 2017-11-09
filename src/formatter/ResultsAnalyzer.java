package formatter;

import java.lang.reflect.Method;

public interface ResultsAnalyzer {
    boolean isLineCovered(int line);
    boolean isBranchCovered(int branch);
    boolean isConditionCovered(int line, int condition);
    int lineCoveredCount(int line);
    int branchCoveredCount(int branch);
    int conditionCoveredCount(int line, int condition);
    int totalLines();
    int totalBranches();
    int totalConditions();
    int totalLinesCovered();
    int totalBranchesCovered();
    int totalConditionsCovered();
    int linesInMethod(Method y);
    int branchesInMethod(Method y);
    int conditionsInMethod(Method y);
    int linesCoveredInMethodCount(Method y);
    int branchesCoveredInMethodCount(Method y);
    int conditionsCoveredInMethodCount(Method y);
    int[] linesCoveredByTest(Class<?> z);
    int[] branchesCoveredByTest(Class<?> z);
    int[] conditionsCoveredByTest(Class<?> z);
}
