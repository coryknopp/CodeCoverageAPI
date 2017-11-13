package data_model;

public interface CoverageData {

    void addTestMethod(TestMethod testMethod);
    void addLine(TestMethod testMethod, Line line);
    void addBranch(TestMethod testMethod, Branch branch);
    void addCondition(TestMethod testMethod, Condition condition);
}
