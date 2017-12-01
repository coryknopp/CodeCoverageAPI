package analyzer;

import java.util.*;
import data_model.*;
import formatter.ResultsAnalyzer;
import adapter.CoberturaAdapter;

public class CoverageAnalyzer implements Analyzer {

    private CoverageResults coverage;
    private HashMap<String, HashMap<String, Object[]>> coverageData;

    // public CoverageAnalyzer(CoverageResults coverage) {
    //     this.coverage = coverage;
    //     this.coverageData = coverage.getCoverageData();
    // }

    public CoverageAnalyzer(String serFilepath) {
        CoberturaAdapter adapter = new CoberturaAdapter(serFilepath);
        this.coverage = adapter.getCoverageResults();
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

    public int totalBranchesCovered(String className) {
        int count = 0;
        HashMap<String, Object[]> classCoverage;
        if (coverageData.get(className) == null) {
            return 0;
        }
        else {
            classCoverage = coverageData.get(className);
        }
        for (String test: classCoverage.keySet()) {   
            ArrayList<Branch> branches = ((ArrayList<Branch>) classCoverage.get(test)[1]);
            ArrayList<Branch> added = new ArrayList<Branch>();         
            for (Branch branch: branches) {
                boolean found = false;
                for(Branch addedBranch: added) {
                    if (addedBranch.getLine().getLineNumber() == branch.getLine().getLineNumber()) {
                        found = true;
                    }
                }   
                if (!found) {
                    added.add(branch);
                    count++;
                }
            }
        }
        return count;
    }

    public int totalConditionsCovered(String className) {
        int count = 0;
        HashMap<String, Object[]> classCoverage;
        if (coverageData.get(className) == null) {
            return 0;
        }
        else {
            classCoverage = coverageData.get(className);
        }
        for (String test: classCoverage.keySet()) {   
            ArrayList<Condition> conditions = ((ArrayList<Condition>) classCoverage.get(test)[1]);
            ArrayList<Condition> added = new ArrayList<Condition>();         
            for (Condition condition : conditions) {
                boolean found = false;
                for(Condition addedCondition: added) {
                    boolean con1 = addedCondition.getLine().getLineNumber() == condition.getLine().getLineNumber();
                    boolean con2 = addedCondition.getIndex() == condition.getIndex();
                    if (con1 && con2) {
                        found = true;
                    }
                }   
                if (!found) {
                    added.add(condition);
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


    public int totalConditions(String className) {
        return 0;
    }



    public int linesInMethod(String className, String methodName) {
        return 0;
    }

    public int branchesInMethod(String className, String methodName) {
        return 0;
    }

    public int conditionsInMethod(String className, String methodName) {
        return 0;
    }

    public int linesCoveredInMethodCount(String className, String methodName) {
        return 0;
    }

    public int branchesCoveredInMethodCount(String className, String methodName) {
        return 0;
    }

    public int conditionsCoveredInMethodCount(String className, String methodName) {
        return 0;
    }

    public int[] linesCoveredByTest(String className, String testName) {
        return new int[0];
    }

    public int[] branchesCoveredByTest(String className, String testName) {
        return new int[0];
    }

    public int[] conditionsCoveredByTest(String className, String testName) {
        return new int[0];
    }

}
