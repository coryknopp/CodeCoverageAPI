package data_model;

public interface CoverageData {

      void addTestMethod(String testMethod);
      void addLine(String testMethod, String className, Line line);
      void addBranch(String testMethod, String className, Branch branch);
      void addCondition(String testMethod, String className, Condition condition);
      Line getLine(String className, int lineNumber);
      Branch getBranch(String className, int lineNumber);
      Condition getCondition(String className, int lineNumber, int index);
      String getTestClass(String name);
      boolean getLineCoverage(int line, String className);
      boolean getBranchCoverage(int branch, String className);
      boolean getConditionCoverage(int line, int condition);
      boolean getTestClassCoverage(String testMethod);
}
