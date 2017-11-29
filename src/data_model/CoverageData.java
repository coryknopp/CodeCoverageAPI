package data_model;

import java.util.HashMap;

public interface CoverageData {

      void addMethod(String method);
      void addLine(String method, String className, Line line);
      void addBranch(String testMethod, String className, Branch branch);
      void addCondition(String testMethod, String className, Condition condition);
      HashMap<String, ProjectData> getProjectData();
}
