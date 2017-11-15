package data_model;

public interface CoverageData {

    void addTestMethod(TestMethod testMethod);
    void addLine(Line line);
    void addBranch(Branch branch);
    void addCondition(Condition condition);
}
