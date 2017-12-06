package analyzer;

import java.util.*;

import adapter.CoberturaAdapter;
import data_model.*;
import formatter.ResultsAnalyzer;

public class CoverageAnalyzer implements ResultsAnalyzer {

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

    public boolean isLineCovered(String className, int lineNumber) throws IllegalArgumentException {
        if (coverage.getMethodCoverage(className) == null) {
            throw new IllegalArgumentException("Class " + className + " does not exist");
        } else {
            HashMap<String, MethodCoverage> methods = coverage.getMethodCoverage(className);
            for (MethodCoverage method : methods.values()) {
                for (Line line : method.getLines()) {
                    if (line.getLineNumber() == lineNumber) {
                        return line.isCovered();
                    }
                }
            }
            throw new IllegalArgumentException("Line " + lineNumber + " does not exist in class " + className);
        }
    }

    public boolean isBranchCovered(String className, int lineNumber) throws IllegalArgumentException {
        if (coverage.getMethodCoverage(className) == null) {
            throw new IllegalArgumentException("Class " + className + " does not exist");
        } else {
            HashMap<String, MethodCoverage> methods = coverage.getMethodCoverage(className);
            for (MethodCoverage method : methods.values()) {
                for (Branch branch : method.getBranches()) {
                    if (branch.getLine().getLineNumber() == lineNumber) {
                        return branch.getLine().isCovered();
                    }
                }
            }
            throw new IllegalArgumentException("Line " + lineNumber + " is not a branch");
        }
    }

    public boolean isConditionCovered(String className, int lineNumber, int conditionIndex) throws IllegalArgumentException {
        if (coverage.getMethodCoverage(className) == null) {
            throw new IllegalArgumentException("Class " + className + " does not exist");
        } else {
            HashMap<String, MethodCoverage> methods = coverage.getMethodCoverage(className);
            for (MethodCoverage method : methods.values()) {
                for (Condition condition : method.getConditions()) {
                    if (condition.getLine().getLineNumber() == lineNumber && condition.getIndex() == conditionIndex) {
                        return condition.isCovered();
                    }
                }
            }
            throw new IllegalArgumentException("Condition " + conditionIndex + " is not a condition");
        }
    }

    public int totalLines() {
        int count = 0;
        for (String s: coverage.getCoverage().keySet()) {
            count += this.totalLinesInClass(s);
        }
        return count;
    }

    public int totalBranches() {
        int count = 0;
        for (String s: coverage.getCoverage().keySet()) {
            count += this.totalBranchesInClass(s);
        }
        return count;
    }

    public int totalConditions() {
        int count = 0;
        for (String s: coverage.getCoverage().keySet()) {
            count += this.totalConditionsInClass(s);
        }
        return count;
    }

    public int totalLinesCovered() {
        int count = 0;
        for (String s: coverage.getCoverage().keySet()) {
            count += this.linesCoveredInClass(s);
        }
        return count;
    }

    public int totalBranchesCovered() {
        int count = 0;
        for (String s: coverage.getCoverage().keySet()) {
            count += this.branchesCoveredInClass(s);
        }
        return count;
    }

    public int totalConditionsCovered() {
        int count = 0;
        for (String s: coverage.getCoverage().keySet()) {
            count += this.conditionsCoveredInClass(s);
        }
        return count;
    }

    // How many lines are covered in class 'className'
    public int linesCoveredInClass(String className) throws IllegalArgumentException {
        if (coverage.getMethodCoverage(className) == null) {
            throw new IllegalArgumentException("Class " + className + " does not exist");
        } else {
            HashMap<String, MethodCoverage> methods = coverage.getMethodCoverage(className);
            int count = 0;
            for (MethodCoverage method : methods.values()) {
                for (Line line : method.getLines()) {
                    if (line.isCovered()) {
                        count++;
                    }
                }
            }
            return count;
        }
    }

    // How many lines are in class 'className'
    public int totalLinesInClass(String className) throws IllegalArgumentException {
        if (coverage.getMethodCoverage(className) == null) {
            throw new IllegalArgumentException("Class " + className + " does not exist");
        } else {
            HashMap<String, MethodCoverage> methods = coverage.getMethodCoverage(className);
            int count = 0;
            // Make sure you don't cound the same line twice
            for (MethodCoverage method : methods.values()) {
                for (Line line : method.getLines()) {
                    count++;
                }
            }
            return count;
        }
    }

    // How many branches are covered in class 'className'
    public int branchesCoveredInClass(String className) throws IllegalArgumentException {
        if (coverage.getMethodCoverage(className) == null) {
            throw new IllegalArgumentException("Class " + className + " does not exist");
        } else {
            HashMap<String, MethodCoverage> methods = coverage.getMethodCoverage(className);

            int count = 0;
            for (MethodCoverage method : methods.values()) {
                for (Branch branch : method.getBranches()) {
                    if (branch.isCovered()) {
                        count++;
                    }
                }
            }
            return count;
        }
    }

    // How many branches are in class 'className'
    public int totalBranchesInClass(String className) throws IllegalArgumentException {
        if (coverage.getMethodCoverage(className) == null) {
            throw new IllegalArgumentException("Class " + className + " does not exist");
        } else {
            HashMap<String, MethodCoverage> methods = coverage.getMethodCoverage(className);
            int count = 0;
            for (MethodCoverage method : methods.values()) {
                for (Branch branch : method.getBranches()) {
                    count++;
                }
            }
            return count;
        }
    }

    // How many conditions are covered in class 'className'
    public int conditionsCoveredInClass(String className) throws IllegalArgumentException {
        if (coverage.getMethodCoverage(className) == null) {
            throw new IllegalArgumentException("Class " + className + " does not exist");
        } else {
            HashMap<String, MethodCoverage> methods = coverage.getMethodCoverage(className);
            int count = 0;
            for (MethodCoverage method : methods.values()) {
                for (Condition condition : method.getConditions()) {
                    if (condition.isCovered()) {
                        count++;
                    }
                }
            }
            return count;
        }
    }

    // How many conditions are in in class 'className'
    public int totalConditionsInClass(String className) throws IllegalArgumentException {
        if (coverage.getMethodCoverage(className) == null) {
            throw new IllegalArgumentException("Class " + className + " does not exist");
        } else {
            HashMap<String, MethodCoverage> methods = coverage.getMethodCoverage(className);
            int count = 0;
            for (MethodCoverage method : methods.values()) {
                for (Condition condition : method.getConditions()) {
                    count++;
                }
            }
            return count;
        }
    }

    public int linesInMethod(String className, String methodName) throws IllegalArgumentException {
        if (coverage.getMethodCoverage(className) == null) {
            throw new IllegalArgumentException("Class " + className + " does not exist");
        } else {
            HashMap<String, MethodCoverage> methods = coverage.getMethodCoverage(className);
            int count = 0;
            boolean methodExists = false;
            for (MethodCoverage method : methods.values()) {
                if (method.getName().equals(methodName)) {
                    methodExists = true;
                    for (Line line : method.getLines()) {
                        count++;
                    }
                }
            }
            if (!methodExists) {
                throw new IllegalArgumentException("Method " + methodName + " does not exist");
            }
            return count;
        }
    }

    public int branchesInMethod(String className, String methodName) throws IllegalArgumentException {
        if (coverage.getMethodCoverage(className) == null) {
            throw new IllegalArgumentException("Class " + className + " does not exist");
        } else {
            HashMap<String, MethodCoverage> methods = coverage.getMethodCoverage(className);
            int count = 0;
            boolean methodExists = false;
            for (MethodCoverage method : methods.values()) {
                if (method.getName().equals(methodName)) {
                    methodExists = true;
                    for (Branch branch : method.getBranches()) {
                        count++;
                    }
                }
            }
            if (!methodExists) {
                throw new IllegalArgumentException("Method " + methodName + " does not exist");
            }
            return count;
        }
    }

    public int conditionsInMethod(String className, String methodName) throws IllegalArgumentException {
        if (coverage.getMethodCoverage(className) == null) {
            throw new IllegalArgumentException("Class " + className + " does not exist");
        } else {
            HashMap<String, MethodCoverage> methods = coverage.getMethodCoverage(className);
            int count = 0;
            boolean methodExists = false;
            for (MethodCoverage method : methods.values()) {
                if (method.getName().equals(methodName)) {
                    methodExists = true;
                    for (Condition condition : method.getConditions()) {
                        count++;
                    }
                }
            }
            if (!methodExists) {
                throw new IllegalArgumentException("Method " + methodName + " does not exist");
            }
            return count;
        }
    }

    public int linesCoveredInMethod(String className, String methodName) throws IllegalArgumentException {
        if (coverage.getMethodCoverage(className) == null) {
            throw new IllegalArgumentException("Class " + className + " does not exist");
        } else {
            HashMap<String, MethodCoverage> methods = coverage.getMethodCoverage(className);
            int count = 0;
            boolean methodExists = false;
            for (MethodCoverage method : methods.values()) {
                if (method.getName().equals(methodName)) {
                    methodExists = true;
                    for (Line line : method.getLines()) {
                        if (line.isCovered()) {
                            count++;
                        }
                    }
                }
            }
            if (!methodExists) {
                throw new IllegalArgumentException("Method " + methodName + " does not exist");
            }
            return count;
        }
    }

    public int branchesCoveredInMethod(String className, String methodName) throws IllegalArgumentException {
        if (coverage.getMethodCoverage(className) == null) {
            throw new IllegalArgumentException("Class " + className + " does not exist");
        } else {
            HashMap<String, MethodCoverage> methods = coverage.getMethodCoverage(className);
            int count = 0;
            boolean methodExists = false;
            for (MethodCoverage method : methods.values()) {
                if (method.getName().equals(methodName)) {
                    methodExists = true;
                    for (Branch branch : method.getBranches()) {
                        if (branch.getLine().isCovered()) {
                            count++;
                        }
                    }
                }
            }
            if (!methodExists) {
                throw new IllegalArgumentException("Method " + methodName + " does not exist");
            }
            return count;
        }
    }

    public int conditionsCoveredInMethod(String className, String methodName) throws IllegalArgumentException {
        if (coverage.getMethodCoverage(className) == null) {
            throw new IllegalArgumentException("Class " + className + " does not exist");
        } else {
            HashMap<String, MethodCoverage> methods = coverage.getMethodCoverage(className);
            int count = 0;
            boolean methodExists = false;
            for (MethodCoverage method : methods.values()) {
                if (method.getName().equals(methodName)) {
                    methodExists = true;
                    for (Condition condition : method.getConditions()) {
                        if (condition.isCovered()) {
                            count++;
                        }
                    }
                }
            }
            if (!methodExists) {
                throw new IllegalArgumentException("Method " + methodName + " does not exist");
            }
            return count;
        }
    }
}
