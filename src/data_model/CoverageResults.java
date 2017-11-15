package data_model;
import net.sourceforge.cobertura.coveragedata.*;
import java.util.*;

public class CoverageResults implements CoverageData {

    private HashMap<Integer, Boolean> lineCoverage;

    public CoverageResults() {
        lineCoverage = new HashMap<Integer, Boolean>();
    }

    public void addClassData(ClassData classData) {
      // Create a new Line object for each line and add that info to the map.
      for(int i = 0; i < classData.getLines().size(); i++) {
        LineData lineData = classData.getLineData(i);
        Line line = new Line(lineData.getLineNumber(), lineData.isCovered());
        addLine(line);
      }
    }

    public void addTestMethod(TestMethod testMethod){
    }

    public void addLine(Line line) {
      lineCoverage.put(line.lineNumber(), line.isCovered());
    }

    public void addBranch(Branch branch) {
    }

    public void addCondition(Condition condition) {
    }

}
