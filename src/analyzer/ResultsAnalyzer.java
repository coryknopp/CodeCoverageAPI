package analyzer;

public interface ResultsAnalyzer {

    boolean isLineCovered(String className, int lineNumber)  throws IllegalArgumentException;
    boolean isBranchCovered(String className, int lineNumber) throws IllegalArgumentException;
    boolean isConditionCovered(String className, int lineNumber, int conditionIndex) throws IllegalArgumentException;
    int totalLines();
    int totalBranches();
    int totalConditions();
    int totalLinesCovered();
    int totalBranchesCovered();
    int totalConditionsCovered();
    int linesCoveredInClass(String className) throws IllegalArgumentException;
    int totalLinesInClass(String className) throws IllegalArgumentException;
    int branchesCoveredInClass(String className) throws IllegalArgumentException;
    int totalBranchesInClass(String className) throws IllegalArgumentException;
    int conditionsCoveredInClass(String className) throws IllegalArgumentException;
    int totalConditionsInClass(String className) throws IllegalArgumentException;
    int linesInMethod(String className, String methodName) throws IllegalArgumentException;
    int branchesInMethod(String className, String methodName) throws IllegalArgumentException;
    int conditionsInMethod(String className, String methodName) throws IllegalArgumentException;
    int linesCoveredInMethod(String className, String methodName) throws IllegalArgumentException;
    int branchesCoveredInMethod(String className, String methodName) throws IllegalArgumentException;
    int conditionsCoveredInMethod(String className, String methodName) throws IllegalArgumentException;
}
