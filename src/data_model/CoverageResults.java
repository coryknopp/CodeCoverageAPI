package data_model;

import java.util.*;

public class CoverageResults implements CoverageData {

    private HashMap<String, ProjectData> projectData;

    public CoverageResults() {
        coverage = new HashMap<>();
    }

    public void addProjectData(ProjectData projectData) {
        coverage.put(projectData.getName(), projectData);
    }

    public HashMap<String, ProjectData> getProjectData() {
        return projectData;
    }

    public HashMap<String, MethodData> getMethodData(String projectClass) {
        return projectData.get(projectClass).getMethodData();
    }
    
}
