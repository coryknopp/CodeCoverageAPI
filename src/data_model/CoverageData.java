package data_model;

public interface CoverageData {

      void addTestMethod(TestClass testClass);
      void addLine(TestClass testClass, String className, Line line);
      void addBranch(TestClass testClass, String className, Branch branch);
      void addCondition(TestClass testClass, String className, Condition condition);
      Line getLine(int line);
      Branch getBranch(Line line);
      Condition getCondition(Line line, int condition);
      TestClass getTestClass(String name);
      boolean getLineCoverage(Line line);
      boolean getBranchCoverage(Branch branch);
      boolean getConditionCoverage(Condition condition);
      boolean getTestClassCoverage(TestClass testClass);
}
