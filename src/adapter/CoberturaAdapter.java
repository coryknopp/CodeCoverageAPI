package adapter;

import data_model.CoverageResults;
import data_model.Line;
import net.sourceforge.cobertura.coveragedata.ClassData;
import net.sourceforge.cobertura.coveragedata.CoverageDataFileHandler;
import net.sourceforge.cobertura.coveragedata.LineData;
import net.sourceforge.cobertura.coveragedata.ProjectData;

import java.util.ArrayList;

import java.io.File;

public class CoberturaAdapter implements AdapterBuilder, CoverageAdapter {

    private CoverageResults coverage;
    private String filepath;
    private static ArrayList<ClassData> allClasses;

    public CoberturaAdapter() {
        coverage = new CoverageResults();
        allClasses = new ArrayList<>();
    }

    @Override
    public CoverageResults getCoverageResults() {
        ProjectData project = deserialize();
        return parseData(project);
    }

    @Override
    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    private ProjectData deserialize() {
        return CoverageDataFileHandler.loadCoverageData(new File(filepath));
    }

    private CoverageResults parseData(ProjectData project) {
        for (Object obj : project.getClasses()) {
            ClassData classData = (ClassData) obj;
            addClassData(classData);
            System.out.println(classData.getName());
        }
        return coverage;
    }

    private void addClassData(ClassData classData) {
        allClasses.add(classData);
        // Create a new Line object for each line in the class and add that data to the map.
        for (Integer i : classData.getBranches()) {
            LineData lineData = classData.getLineData(i);
            Line line = new Line(classData.getName(), lineData.getLineNumber(), lineData.isCovered());
            coverage.addLine(line);
        }
    }
}
