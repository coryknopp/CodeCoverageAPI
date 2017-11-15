package adapter;

import data_model.CoverageResults;
import net.sourceforge.cobertura.coveragedata.ClassData;
import net.sourceforge.cobertura.coveragedata.CoverageDataFileHandler;
import net.sourceforge.cobertura.coveragedata.ProjectData;
import java.util.SortedSet;

import java.io.File;

public class CoberturaAdapter implements AdapterBuilder, CoverageAdapter {

    private String filepath;

    public CoberturaAdapter() {

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
        CoverageResults coverage = new CoverageResults();
        for (Object obj : project.getClasses()) {
            ClassData classData = (ClassData) obj;
            coverage.addClassData(classData);
            System.out.println(classData.getName());
        }
        return coverage;
    }
}
