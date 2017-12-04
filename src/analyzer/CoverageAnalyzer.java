package analyzer;

import java.util.*;

import data_model.*;
import formatter.ResultsAnalyzer;

public class CoverageAnalyzer {

    private CoverageResults coverage;

    public CoverageAnalyzer(CoverageResults coverage) {
        this.coverage = coverage;
    }

    public boolean isLineCovered(String className, int lineNumber) {
      HashMap<String, MethodData> methods;
      if (coverage.getMethodData(className) == null)
        return false;
      else
        methods = coverage.getMethodData(className);

      for(MethodData method: methods.values()) {
          for(Line line: method.getLines()) {
            if (line.getLineNumber() == lineNumber)
              return line.isCovered();
          }
        }

        return false;
    }

    public boolean isBranchCovered(String className, int lineNumber) {
      HashMap<String, MethodData> methods;
      if (coverage.getMethodData(className) == null)
        return false;
      else
        methods = coverage.getMethodData(className);

      for(MethodData method: methods.values()) {
        for(Branch branch: method.getBranches()) {
          if (branch.getLine().getLineNumber() == lineNumber) {
            return branch.getLine().isCovered();
          }
        }
      }

      return false;
    }

    public boolean isConditionCovered(String className, int lineNumber, int conditionIndex) {
      HashMap<String, MethodData> methods;
      if (coverage.getMethodData(className) == null)
        return false;
      else
        methods = coverage.getMethodData(className);

      for(MethodData method: methods.values()) {
        for(Condition condition: method.getConditions()) {
          if (condition.getBranch().getLine().getLineNumber() == lineNumber &&
                condition.getIndex() == conditionIndex) {
            return condition.getBranch().getLine().isCovered();
          }
        }
      }

      return false;
    }


    // How many lines are covered in class 'className'
    public int lineCoveredCount(String className) {
      HashMap<String, MethodData> methods;
      if (coverage.getMethodData(className) == null)
        return 0;
      else
        methods = coverage.getMethodData(className);

      int count = 0;
      HashMap<Integer, Boolean> linesFound = new HashMap<Integer, Boolean>();
      for(MethodData method: methods.values()) {
        for (Line line: method.getLines()) {
            if(line.isCovered() && linesFound.get(line.getLineNumber()) == null) {
              linesFound.put(line.getLineNumber(), true);
              count++;
            }
        }
      }
      return count;
    }

    // How many branches are covered in class 'className'
    public int branchCoveredCount(String className) {
      HashMap<String, MethodData> methods;
      if (coverage.getMethodData(className) == null)
        return 0;
      else
        methods = coverage.getMethodData(className);

      int count = 0;
      HashMap<Integer, Boolean> branchesFound = new HashMap<Integer, Boolean>();
      for(MethodData method: methods.values()) {
        for (Branch branch: method.getBranches()) {
            if(branch.getLine().isCovered() && branchesFound.get(branch.getLine().getLineNumber()) == null) {
              branchesFound.put(branch.getLine().getLineNumber(), true);
              count++;
            }
        }

      }
      return count;
    }

    // How many conditions are covered in class 'className'
    public int conditionCoveredCount(String className) {
      HashMap<String, MethodData> methods;
      if (coverage.getMethodData(className) == null)
        return 0;
      else
        methods = coverage.getMethodData(className);

      int count = 0;
      HashMap<Integer, Boolean> conditionsFound = new HashMap<Integer, Boolean>();
      for(MethodData method: methods.values()) {
        for (Condition condition: method.getConditions()) {
            if(condition.getBranch().getLine().isCovered() &&
                conditionsFound.get(condition.getBranch().getLine().getLineNumber()) == null) {
              conditionsFound.put(condition.getBranch().getLine().getLineNumber(), true);
              count++;
            }
        }

      }
      return count;
    }


    public int totalLines() {
        return 0;
    }


    public int totalBranches() {
        return 0;
    }


    public int totalConditions() {
        return 0;
    }


    public int totalLinesCovered() {
        return 0;
    }


    public int totalBranchesCovered() {
        return 0;
    }


    public int totalConditionsCovered() {
        return 0;
    }


    public int linesInMethod(String y) {
        return 0;
    }


    public int branchesInMethod(String y) {
        return 0;
    }


    public int conditionsInMethod(String y) {
        return 0;
    }


    public int linesCoveredInMethodCount(String y) {
        return 0;
    }


    public int branchesCoveredInMethodCount(String y) {
        return 0;
    }


    public int conditionsCoveredInMethodCount(String y) {
        return 0;
    }


    public int[] linesCoveredByTest(Class<?> z) {
        return new int[0];
    }


    public int[] branchesCoveredByTest(Class<?> z) {
        return new int[0];
    }


    public int[] conditionsCoveredByTest(Class<?> z) {
        return new int[0];
    }
}
