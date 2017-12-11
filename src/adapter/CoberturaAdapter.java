package adapter;

import data_model.CoverageResults;
import data_model.*;
import net.sourceforge.cobertura.coveragedata.*;

import java.util.ArrayList;
import java.io.File;

public class CoberturaAdapter implements CoverageAdapter {

    private CoverageResults coverage;
    private String filepath;

    public CoberturaAdapter(String filepath) {
        this.filepath = filepath;
        coverage = new CoverageResults();
    }

    public CoverageResults getCoverageResults() {
        ProjectData project = CoverageDataFileHandler.loadCoverageData(new File(filepath));
        return parseData(project);
    }

    private CoverageResults parseData(ProjectData project) {
        for (Object obj : project.getClasses()) {
            ClassData classData = (ClassData) obj;
            addClassCoverage(classData);
        }
        return coverage;
    }

    private void addClassCoverage(ClassData classData) {
        ClassCoverage classCoverage = new ClassCoverage(classData.getName());
        MethodCoverage method = null;
        for (CoverageData c : classData.getLines()) {
            Integer l = Integer.parseInt(c.toString().split("@")[1], 16);
            LineData lineData = classData.getLineData(l);
            Line line;
            if (lineData != null) {
                if (method == null) {
                    method = new MethodCoverage(lineData.getMethodName());
                } else if (!method.getName().equals(lineData.getMethodName())) {
                    classCoverage.addMethodData(method);
                    method = new MethodCoverage(lineData.getMethodName());
                }
                // Parse line coverage
                if (lineData.isCovered() || lineData.getNumberOfCoveredBranches() > 0) {
                    line = new Line(l, true);
                } else {
                    line = new Line(l, false);
                }
                method.addLine(line);
                // Parse branch coverage
                if (lineData.hasBranch()) {
                    // Default
                    Branch branch = new Branch(line, lineData.isCovered());
                    method.addBranch(branch);
                }
                /*if (lineData.getNumberOfValidBranches() > 0) {
                    int coveredBranches = lineData.getNumberOfCoveredBranches();
                    int coveredBranchesCounted = 0;
                    for (int i = 0; i < lineData.getNumberOfValidBranches(); i++) {
                        Branch branch;
                        if (coveredBranchesCounted < coveredBranches) {
                            branch = new Branch(line, true);
                            coveredBranchesCounted++;
                        } else {
                            branch = new Branch(line, false);
                        }
                        method.addBranch(branch);
                    }
                }*/
                // Parse condition coverage
                int totalConditions = getConditionNumber(lineData);
                for (int i = 0; i < totalConditions; i++) {
                    Condition condition;
                    JumpData jumpData = (JumpData) lineData.getConditionData(i);
                    if (jumpData != null && jumpData.getBranchCoverageRate() == 1) {
                        condition = new Condition(line, i, true);
                    } else {
                        condition = new Condition(line, i, false);
                    }
                    method.addCondition(condition);
                }
            }
        }
        classCoverage.addMethodData(method);
        coverage.addClassCoverage(classCoverage);
    }

    private int getConditionNumber(LineData lineData) {
        int totalConditions = 0;
        String condition = lineData.getConditionCoverage();
        if (condition.contains("/")) {
            String s = condition.split("/")[1].split("\\)")[0];
            totalConditions = Integer.parseInt(s);
        }
        return totalConditions / 2;
    }
}
