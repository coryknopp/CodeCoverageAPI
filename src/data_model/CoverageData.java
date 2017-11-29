package data_model;

import java.util.HashMap;

public interface CoverageData {

      void addProjectData(ProjectData projectData);
      HashMap<String, ProjectData> getProjectData();
}
