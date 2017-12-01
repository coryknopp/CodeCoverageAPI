package analyzer;

import java.util.*;

import data_model.*;
import formatter.ResultsAnalyzer;


public class CoverageAnalyzer {

    private CoverageResults coverage;
    private HashMap<String, HashMap<String, Object[]>> coverageData;

    public CoverageAnalyzer(CoverageResults coverage) {
        this.coverage = coverage;
        this.coverageData = coverage.getCoverageData();
    }
 
    public boolean isLineCovered(String className, int line) {
        if (coverage.getLine(className, line) == null) {
            return false;
        }
        else {
            return true;
        }
    }

    public boolean isBranchCovered(String className, int line) {
        if (coverage.getBranch(className, line) == null) {
            return false;
        }
        else {
            return true;
        }
    }

    public boolean isConditionCovered(String className, int line, int condition) {
        if (coverage.getCondition(className, line, condition) == null) {
            return false;
        }
        else {
            return true;
        }
    }

    public int lineCoveredCount(String className, int lineNumber) {
        int count = 0;
        // Verify that there is class information for this class in the model.
       HashMap<String, Object[]> classCoverage;
       if (coverageData.get(className) == null) {
         return 0;
       }
       else {
         classCoverage = coverageData.get(className);
       }
       // For each test of this className check all lines
        for (String test: classCoverage.keySet()) {
            ArrayList<Line> lines = ((ArrayList<Line>) classCoverage.get(test)[0]);
            for (Line line: lines) {
                if (line.getLineNumber() == lineNumber)
                    count++;
                }
       }
       return count;
    }

    public int branchCoveredCount(String className, int lineNumber) {
        int count = 0;
        HashMap<String, Object[]> classCoverage;
        if (coverageData.get(className) == null) {
            return 0;
        }
        else {
            classCoverage = coverageData.get(className);
        }
        for (String test: classCoverage.keySet()) {
            ArrayList<Branch> branches = (ArrayList<Branch>)classCoverage.get(test)[1];
            for (Branch branch: branches) {
                if (branch.getLine().getLineNumber() == lineNumber) {
                    count++;
                }
            }
        }
        return count;
    }

    public int conditionCoveredCount(String className, int lineNumber, int conditionIndex) {
        int count = 0;
        HashMap<String, Object[]> classCoverage;
        if (coverageData.get(className) == null) {
            return 0;
        }
        else {
            classCoverage = coverageData.get(className);
        }
        for (String test: classCoverage.keySet()) {
            ArrayList<Condition> conditions = (ArrayList<Condition>)classCoverage.get(test)[2];
            for (Condition condition: conditions) {
                boolean con1 = condition.getLine().getLineNumber() == lineNumber;
                boolean con2 = condition.getIndex() == conditionIndex;
                if (con1 && con2) {
                    count++;
                }
            }
        }
        return count;
    }


    public int totalLines(String className) {
        return 0;
    }


    public int totalBranches(String className) {
        return 0;
    }


    public int totalConditions() {
        return 0;
    }


    public int totalLinesCovered(String className) {
        int count = 0;
        HashMap<String, Object[]> classCoverage;
        if (coverageData.get(className) == null) {
            return 0;
        }
        else {
            classCoverage = coverageData.get(className);
        }
        for (String test: classCoverage.keySet()) {   
            ArrayList<Line> lines = ((ArrayList<Line>) classCoverage.get(test)[0]);
            ArrayList<Line> added = new ArrayList<Line>();         
            for (Line line: lines) {
                boolean found = false;
                for(Line addedLine: added) {
                    if (addedLine.getLineNumber() == line.getLineNumber()) {
                        found = true;
                    }
                }   
                if (!found) {
                    added.add(line);
                    count++;
                }
            }
        }
        return count;
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


    public int branchesCoveredInMethodCount() {
        return 0;
    }


    public int conditionsCoveredInMethodCount() {
        return 0;
    }


    public int[] linesCoveredByTest() {
        return new int[0];
    }


    public int[] branchesCoveredByTest() {
        return new int[0];
    }


    public int[] conditionsCoveredByTest() {
        return new int[0];
    }
}
