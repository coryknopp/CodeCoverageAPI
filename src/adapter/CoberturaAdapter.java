package adapter;

import data_model.CoverageResults;
import data_model.*;
import net.sourceforge.cobertura.coveragedata.ClassData;
import net.sourceforge.cobertura.coveragedata.CoverageDataFileHandler;
import net.sourceforge.cobertura.coveragedata.LineData;

import java.util.ArrayList;
import java.io.File;

public class CoberturaAdapter implements CoverageAdapter {

    private CoverageResults coverage;
    private String filepath;
    private static ArrayList<ClassData> allClasses;

    public CoberturaAdapter(String filepath) {
        this.filepath = filepath;
        coverage = new CoverageResults();
        allClasses = new ArrayList<>();
    }

    @Override
    public CoverageResults getCoverageResults() {
        net.sourceforge.cobertura.coveragedata.ProjectData project = deserialize();
        return parseData(project);
    }

    private net.sourceforge.cobertura.coveragedata.ProjectData deserialize() {
        return CoverageDataFileHandler.loadCoverageData(new File(filepath));
    }

    private CoverageResults parseData(net.sourceforge.cobertura.coveragedata.ProjectData project) {
        for (Object obj : project.getClasses()) {
            ClassData classData = (ClassData) obj;
            addClassData(classData);
        }
        return coverage;
    }

    /*private void _addClassData(ClassData classData) {
        // Add this class to the array list holding all class data.
        allClasses.add(classData);
        // Get the class name of this class.
        String className = classData.getName();
        // This is a placeholder.
        String testName = "Tempory test";
        coverage.addMethod(testName);
        // For each line in the class:
        for (net.sourceforge.cobertura.coveragedata.CoverageData c : classData.getLines()) {
            // CoverageData does not have a getLineNumber method. However, c.toString()
            // prints 'net.sourceforge.cobertura.coveragedata.LineData@<hexLineNumber>'
            // To get the line number, we can split this string on '@' and then convert
            // the hex line number to decimal.
            String s = c.toString().split("@")[1];
            Integer i = Integer.parseInt(s, 16);
            // Get the lineData at this lineNumber.
            LineData lineData = classData.getLineData(i);
            // Make a Line object and add it to the data model.
            Line line = new Line(lineData.getLineNumber());
            coverage.addLine(testName, className, line);
            // If the line is a branch, make a Branch object and add it to the data model.
            if (lineData.hasBranch()) {
                Branch branch = new Branch(line);
                coverage.addBranch(testName, className, branch);
                // For each condition for this branch, make a Condition object and add it to
                // the data model.
                for (int index = 0; index < lineData.getConditionSize(); index++) {
                    Condition condition = new Condition(line, branch, index);
                    coverage.addCondition(testName, className, condition);
                }
            }
        }
    }*/

    private void addClassData(ClassData classData) {
        allClasses.add(classData);
        ProjectData projectData = new ProjectData(classData.getName());
        int numberOfLines = classData.getLines().size();
        MethodData method = null;
        int linesFound = 0;
        int lineNumber = 0;
        while (linesFound != numberOfLines) {
            lineNumber++;
            LineData lineData = classData.getLineData(lineNumber);
            if(lineData != null) {
              linesFound++;
              Line line;
              if (lineData.isCovered()) {
                 System.out.println(lineData.getLineNumber());
                 line = new Line(lineNumber, true);
              }
              else {
                 line = new Line(lineNumber, false);
              }

              if (method == null || !method.getName().equals(lineData.getMethodName())) {
                  if (method != null) {
                      projectData.addMethodData(method);
                  }
                  method = new MethodData(lineData.getMethodName());

                System.out.println(method.getName());
                method.addLine(line);
                if (lineData.hasBranch()) {
                    Branch branch = new Branch(line);
                    method.addBranch(branch);
                    for (int i = 0; i < lineData.getConditionSize(); i++) {
                        Condition condition = new Condition(line, branch, i);
                        method.addCondition(condition);
                    }
                }
            }
          }
        }
    }
}
