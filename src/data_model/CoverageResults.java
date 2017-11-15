package data_model;
import net.sourceforge.cobertura.coveragedata.*;
import java.util.*;

public class CoverageResults implements CoverageData {

    // Holds info about line coverage. String is the class the line is in,
    // Integer is the line number, and Boolean is if it is covered or not.
    // <ClassName <LineNumber, isLineCovered>>
    public static Map<String, HashMap<Integer, Boolean>> lineCoverage;

    public CoverageResults() {
        lineCoverage = new HashMap<String, HashMap<Integer, Boolean>>();
    }

    public void addClassData(ClassData classData) {
      // Create a new Line object for each line in the class and add that data to the map.
      for(int i = 0; i < classData.getLines().size(); i++) {
        LineData lineData = classData.getLineData(i);
        Line line = new Line(classData.getName(), lineData.getLineNumber(), lineData.isCovered());
        addLine(line);
      }
    }

    // Not sure how to use this yet.
    public void addTestMethod(TestMethod testMethod){
    }

    public void addLine(Line line) {
      // If the class has not yet been added to the map, add it to the map.
      if(lineCoverage.get(line.className()) == null) {
        HashMap<Integer, Boolean> innerMap = new HashMap<Integer, Boolean>();
        innerMap.put(line.lineNumber(), line.isCovered());
        lineCoverage.put(line.className(), innerMap);
      }

      // Add the line data to the map.
      lineCoverage.get(line.className()).put(line.lineNumber(), line.isCovered());
    }

    public void addBranch(Branch branch) {
      // How do we identify a branch? Can we just use its line number?
      // If so we don't need to add anything to the data structure for this.
    }

    public void addCondition(Condition condition) {

    }

}
