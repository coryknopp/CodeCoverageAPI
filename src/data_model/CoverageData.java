package data_model;

public interface CoverageData {

      void addTestMethod(TestClass testClass);
      void addLine(TestClass testClass, String className, Line line);
      void addBranch(TestClass testClass, String className, Branch branch);
      void addCondition(TestClass testClass, String className, Condition condition);

}
