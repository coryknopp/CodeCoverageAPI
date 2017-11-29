package data_model;

public interface CoverageData {

      void addTestMethod(String testMethod);
      void addLine(String testMethod, String className, Line line);
      void addBranch(String testMethod, String className, Branch branch);
      void addCondition(String testMethod, String className, Condition condition);
      Line getLine(int line);
      Branch getBranch(int line);
      Condition getCondition(int line, int condition);
      String getTestClass(String name);
      boolean getLineCoverage(int line, String className);
      boolean getBranchCoverage(int branch, String className);
      boolean getConditionCoverage(int line, int condition);
      boolean getTestClassCoverage(String testMethod);
}
