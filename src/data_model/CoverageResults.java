package data_model;

import java.util.*;

public class CoverageResults implements CoverageData {

    // The data model is HashMap<String, HashMap<TestMethod, ArrayList<Object>[]>> .
    // The ArrayList<Object>[] holds three array lists of Lines, Branches, and Conditions.
    // The TestMethod is the test that hit those Lines, Branches and Conditions.
    // private HashMap<String, HashMap<String, ArrayList<Object>[]>> coverage;
    private HashMap<String, HashMap<String, Object[]>> coverage;
    // private HashMap<String, ClassData> coverage;
    private ArrayList<String> allTests = new ArrayList<>();

    public CoverageResults() {
        coverage = new HashMap<>();
        allTests = new ArrayList<>();
    }

    // Add the testMethod to the array with all test methods.
    public void addTestMethod(String testMethod) {
        allTests.add(testMethod);
    }

    public void addLine(String testMethod, String className, Line line) {
        addClassAndTest(testMethod, className);
        Object[] objectArray = coverage.get(className).get(testMethod);
        ArrayList<Line> lineList = ((ArrayList<Line>) objectArray[0]);
        lineList.add(line);
        objectArray[0] = lineList;
        coverage.get(className).put(testMethod, objectArray);
    }

    public void addBranch(String testMethod, String className, Branch branch) {
        addClassAndTest(testMethod, className);
        Object[] objectArray = coverage.get(className).get(testMethod);
        ArrayList<Branch> branchList = ((ArrayList<Branch>) objectArray[1]);
        branchList.add(branch);
        objectArray[1] = branchList;
        coverage.get(className).put(testMethod, objectArray);
    }

    public void addCondition(String testMethod, String className, Condition condition) {
        addClassAndTest(testMethod, className);
        Object[] objectArray = coverage.get(className).get(testMethod);
        ArrayList<Condition> conditionList = ((ArrayList<Condition>) objectArray[2]);
        conditionList.add(condition);
        objectArray[2] = conditionList;
        coverage.get(className).put(testMethod, objectArray);
    }

    public void addClassAndTest(String testMethod, String className) {
        if (coverage.get(className) == null) {
            HashMap<String, Object[]> innerMap = new HashMap<>();
            coverage.put(className, innerMap);
        }
        if (coverage.get(className).get(testMethod) == null) {
            Object[] objectArray = new Object[3];
            ArrayList<Line> lineArrayList = new ArrayList<>();
            ArrayList<Branch> branchArrayList = new ArrayList<>();
            ArrayList<Condition> conditionArrayList = new ArrayList<>();
            objectArray[0] = lineArrayList;
            objectArray[1] = branchArrayList;
            objectArray[2] = conditionArrayList;
            coverage.get(className).put(testMethod, objectArray);
        }
    }

    public HashMap<String, HashMap<String, Object[]>> getCoverageData() {
        return coverage;
    }


    public Line getLine(String className, int lineNumber) {
       // Verify that there is class information for this class in the model.
       HashMap<String, Object[]> classCoverage;
       if (coverage.get(className) == null) {
         return null;
       }
       else {
         classCoverage = coverage.get(className);
       }

       // For each test of this class check which lines are covered by
       // the test. Return the line if it matches the line number you
       // are searching for.
       for (String test: classCoverage.keySet()) {
         ArrayList<Line> lines = ((ArrayList<Line>) classCoverage.get(test)[0]);
         for(Line line: lines) {
           if (line.getLineNumber() == lineNumber)
             return line;
         }
       }

       // No line matched this class and line number.
       return null;
   }


   public Branch getBranch(String className, int lineNumber) {
     // Verify that there is class information for this class in the model.
     HashMap<String, Object[]> classCoverage;
     if (coverage.get(className) == null) {
       return null;
     }
     else {
       classCoverage = coverage.get(className);
     }

     // For each test of this class check which branches are covered by
     // the test. Return the branch if it matches the line number you
     // are searching for.
     for (String test: classCoverage.keySet()) {
       ArrayList<Branch> branches = ((ArrayList<Branch>) classCoverage.get(test)[1]);
       for(Branch branch: branches) {
         if (branch.getLine().getLineNumber() == lineNumber)
           return branch;
       }
     }

     // No branch matched this class and line number.
     return null;
   }

   public Condition getCondition(String className, int lineNumber, int index) {
     // Verify that there is class information for this class in the model.
     HashMap<String, Object[]> classCoverage;
     if (coverage.get(className) == null) {
      return null;
     }
     else {
       classCoverage = coverage.get(className);
     }

     // For each test of this class check which branches are covered by
     // the test. Return the line if it matches the line number you
     // are searching for.
     for (String test: classCoverage.keySet()) {
       ArrayList<Condition> conditions = ((ArrayList<Condition>)classCoverage.get(test)[2]);
       for(Condition condition: conditions) {
         if (condition.getBranch().getLine().getLineNumber() == lineNumber &&
                 condition.getIndex() == index)
           return condition;
       }
     }

     // No condition matched this class and line number.
     return null;
   }

    public String getTestClass(String name) {
        return null;
    }

    public boolean getLineCoverage(int line, String className) {
        /*ArrayList<Object> lineList = coverage.get(className).get("Temporary test")[0];
        for (Object obj : lineList) {
            Line l = (Line) obj;
            if (line == l.getLineNumber()) {
                return true;
            }
        }
        return false;*/
        return false;
    }

    public boolean getBranchCoverage(int branch, String className) {
        return false;
    }

    public boolean getConditionCoverage(int line, int condition) {
        return false;
    }

    public boolean getTestClassCoverage(String testMethod) {
        return false;
    }
}
