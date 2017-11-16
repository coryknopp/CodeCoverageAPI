package data_model;

public interface CoverageData {

    void addTestMethod(TestClass testClass);
    void addLine(Line line);
    void addBranch(Branch branch);
    void addCondition(Condition condition);

    /*void getLine(Line line);
    void getBranch(Line line);
    void getCondition(int line, int conditionIndex);*/
}
