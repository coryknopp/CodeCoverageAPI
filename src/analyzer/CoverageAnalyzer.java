package analyzer;

import java.util.*;

import adapter.CoberturaAdapter;
import data_model.*;
import formatter.CSVFormatter;

public class CoverageAnalyzer {

    private CoverageResults coverage;

    public CoverageAnalyzer(String serFilepath) {
        // STEP 1: Parse Cobertura's serialized data file
        CoberturaAdapter adapter = new CoberturaAdapter(serFilepath);
        // STEP 2: Output CoverageResults data structure
        coverage = adapter.getCoverageResults();
    }

    public CoverageAnalyzer(CoverageResults coverage) {
        this.coverage = coverage;
    }

    public boolean isLineCovered(String className, int lineNumber) {
      HashMap<String, MethodCoverage> methods;
      if (coverage.getMethodCoverage(className) == null)
        return false;
      else
        methods = coverage.getMethodCoverage(className);

      for(MethodCoverage method: methods.values()) {
        for(Line line: method.getLines()) {
          if (line.getLineNumber() == lineNumber)
            return line.isCovered();
        }
      }

      return false;
    }

    public boolean isBranchCovered(String className, int lineNumber) {
      HashMap<String, MethodCoverage> methods;
      if (coverage.getMethodCoverage(className) == null)
        return false;
      else
        methods = coverage.getMethodCoverage(className);

      for(MethodCoverage method: methods.values()) {
        for(Branch branch: method.getBranches()) {
          if (branch.getLine().getLineNumber() == lineNumber) {
            return branch.getLine().isCovered();
          }
        }
      }

      return false;
    }

    public boolean isConditionCovered(String className, int lineNumber, int conditionIndex) {
      HashMap<String, MethodCoverage> methods;
      if (coverage.getMethodCoverage(className) == null)
        return false;
      else
        methods = coverage.getMethodCoverage(className);

      for(MethodCoverage method: methods.values()) {
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
      HashMap<String, MethodCoverage> methods;
      if (coverage.getMethodCoverage(className) == null)
        return 0;
      else
        methods = coverage.getMethodCoverage(className);

      int count = 0;
      HashMap<Integer, Boolean> linesFound = new HashMap<Integer, Boolean>();
      for (MethodCoverage method: methods.values()) {
        for (Line line: method.getLines()) {
            if (line.isCovered() && linesFound.get(line.getLineNumber()) == null) {
              linesFound.put(line.getLineNumber(), true);
              count++;
            }
        }
      }
      return count;
    }

    // How many lines are in class 'className'
    public int lineCount(String className) {
      HashMap<String, MethodCoverage> methods;
      if (coverage.getMethodCoverage(className) == null)
        return 0;
      else
        methods = coverage.getMethodCoverage(className);

      int count = 0;
      // Make sure you don't cound the same line twice
      HashMap<Integer, Boolean> linesFound = new HashMap<>();
      for (MethodCoverage method: methods.values()) {
        for (Line line: method.getLines()) {
            if (linesFound.get(line.getLineNumber()) == null) {
              linesFound.put(line.getLineNumber(), true);
              count++;
            }
        }
      }
      return count;
    }

    // How many branches are covered in class 'className'
    public int branchCoveredCount(String className) {
      HashMap<String, MethodCoverage> methods;
      if (coverage.getMethodCoverage(className) == null)
        return 0;
      else
        methods = coverage.getMethodCoverage(className);

      int count = 0;
      for (MethodCoverage method: methods.values()) {
        for (Branch branch: method.getBranches()) {
            if (branch.isCovered()) {
              count++;
            }
        }
      }
      return count;
    }

    // How many branches are in class 'className'
    public int branchCount(String className) {
      HashMap<String, MethodCoverage> methods;
      if (coverage.getMethodCoverage(className) == null)
        return 0;
      else
        methods = coverage.getMethodCoverage(className);

      int count = 0;
      for (MethodCoverage method: methods.values()) {
        for (Branch branch: method.getBranches()) {
            count++;
        }
      }
      return count;
    }

    // How many conditions are covered in class 'className'
    public int conditionCoveredCount(String className) {
      HashMap<String, MethodCoverage> methods;
      if (coverage.getMethodCoverage(className) == null)
        return 0;
      else
        methods = coverage.getMethodCoverage(className);

      int count = 0;
      for (MethodCoverage method: methods.values()) {
        for (Condition condition: method.getConditions()) {
            if (condition.isCovered()) {
              count++;
            }
        }
      }
      return count;
    }

    // How many conditions are in in class 'className'
    public int conditionCount(String className) {
      HashMap<String, MethodCoverage> methods;
      if (coverage.getMethodCoverage(className) == null)
        return 0;
      else
        methods = coverage.getMethodCoverage(className);

      int count = 0;
      for (MethodCoverage method: methods.values()) {
        for (Condition condition: method.getConditions()) {
            count++;
        }
      }
      return count;
    }


    public int totalLines() {
      int count = 0;
      for(String s: coverage.getCoverage().keySet()) {
        count += this.lineCount(s);
      }
      return count;
    }


    public int totalBranches() {
      int count = 0;
      for(String s: coverage.getCoverage().keySet()) {
        count += this.branchCount(s);
      }
      return count;
    }


    public int totalConditions() {
      int count = 0;
      for(String s: coverage.getCoverage().keySet()) {
        count += this.conditionCount(s);
      }
      return count;
    }


    public int totalLinesCovered() {
      int count = 0;
      for(String s: coverage.getCoverage().keySet()) {
        count += this.lineCoveredCount(s);
      }
      return count;
    }


    public int totalBranchesCovered() {
      int count = 0;
      for(String s: coverage.getCoverage().keySet()) {
        count += this.branchCoveredCount(s);
      }
      return count;
    }


    public int totalConditionsCovered() {
      int count = 0;
      for(String s: coverage.getCoverage().keySet()) {
        count += this.conditionCoveredCount(s);
      }
      return count;
    }


    public int linesInMethod(String className, String methodName) {
      HashMap<String, MethodCoverage> methods;
      if (coverage.getMethodCoverage(className) == null)
        return 0;
      else
        methods = coverage.getMethodCoverage(className);

      int count = 0;
      for(MethodCoverage method: methods.values()) {
        if(method.getName().equals(methodName)) {
          for(Line line: method.getLines()) {
              count++;
          }
        }
      }
      return count;
    }


    public int branchesInMethod(String className, String methodName) {
      HashMap<String, MethodCoverage> methods;
      if (coverage.getMethodCoverage(className) == null)
        return 0;
      else
        methods = coverage.getMethodCoverage(className);

      int count = 0;
      for(MethodCoverage method: methods.values()) {
        if(method.getName().equals(methodName)) {
          for(Branch branch: method.getBranches()) {
              count++;
          }
        }
      }
      return count;
    }


    public int conditionsInMethod(String className, String methodName) {
      HashMap<String, MethodCoverage> methods;
      if (coverage.getMethodCoverage(className) == null)
        return 0;
      else
        methods = coverage.getMethodCoverage(className);

      int count = 0;
      for(MethodCoverage method: methods.values()) {
        if(method.getName().equals(methodName)) {
          for(Condition condition: method.getConditions()) {
              count++;
          }
        }
      }
      return count;
    }


    public int linesCoveredInMethodCount(String className, String methodName) {
      HashMap<String, MethodCoverage> methods;
      if (coverage.getMethodCoverage(className) == null)
        return 0;
      else
        methods = coverage.getMethodCoverage(className);

      int count = 0;
      for(MethodCoverage method: methods.values()) {
        if(method.getName().equals(methodName)) {
          for(Line line: method.getLines()) {
            if(line.isCovered())
              count++;
          }
        }
      }
      return count;
    }


    public int branchesCoveredInMethodCount(String className, String methodName) {
      HashMap<String, MethodCoverage> methods;
      if (coverage.getMethodCoverage(className) == null)
        return 0;
      else
        methods = coverage.getMethodCoverage(className);

      int count = 0;
      for(MethodCoverage method: methods.values()) {
        if(method.getName().equals(methodName)) {
          for(Branch branch: method.getBranches()) {
            if(branch.getLine().isCovered())
              count++;
          }
        }
      }
      return count;
    }


    public int conditionsCoveredInMethodCount(String className, String methodName) {
      HashMap<String, MethodCoverage> methods;
      if (coverage.getMethodCoverage(className) == null)
        return 0;
      else
        methods = coverage.getMethodCoverage(className);

      int count = 0;
      for(MethodCoverage method: methods.values()) {
        if(method.getName().equals(methodName)) {
          for(Condition condition: method.getConditions()) {
            if(condition.getBranch().getLine().isCovered())
              count++;
          }
        }
      }
      return count;
    }
}
