package data_model;
import net.sourceforge.cobertura.coveragedata.*;
import java.util.*;

public class MapDataModel implements CoverageData {

  private HashMap<Integer, Boolean> lineCoverage;

  public MapDataModel() {
    lineCoverage = new HashMap<Integer, Boolean>();
  }

  public void addClassData(ClassData classData) {
    // Find out how many lines are in this class.
    SortedSet<net.sourceforge.cobertura.coveragedata.CoverageData> allLines = classData.getLines();
    // Create a new Line object for each line and add that info to the map.
    for(int i = 0; i < allLines.size(); i++) {
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
