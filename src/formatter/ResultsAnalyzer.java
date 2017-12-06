package formatter;

public interface ResultsAnalyzer {

    boolean isLineCovered(String className, int lineNumber);
    boolean isBranchCovered(String className, int lineNumber);
    boolean isConditionCovered(String className, int lineNumber, int conditionIndex);
    int totalLines();
    int totalBranches();
    int totalConditions();
    int totalLinesCovered();
    int totalBranchesCovered();
    int totalConditionsCovered();
    int linesCoveredInClass(String className);
    int totalLinesInClass(String className);
    int branchesCoveredInClass(String className);
    int totalBranchesInClass(String className);
    int conditionsCoveredInClass(String className);
    int totalConditionsInClass(String className);
    int linesInMethod(String className, String methodName);
    int branchesInMethod(String className, String methodName);
    int conditionsInMethod(String className, String methodName);
    int linesCoveredInMethod(String className, String methodName);
    int branchesCoveredInMethod(String className, String methodName);
    int conditionsCoveredInMethod(String className, String methodName);
}
