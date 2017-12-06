package data_model;

import java.util.*;

public class CoverageResults implements CoverageModel {

    private HashMap<String, ClassCoverage> coverage;

    public CoverageResults() {
        coverage = new HashMap<>();
    }

    public void addClassCoverage(ClassCoverage classCoverage) {
        coverage.put(classCoverage.getName(), classCoverage);
    }

    public ClassCoverage get(String className) {
        return coverage.get(className);
    }

    public HashMap<String, MethodCoverage> getMethodCoverage(String projectClass) {
        ClassCoverage cls = coverage.get(projectClass);
        HashMap<String, MethodCoverage> method = cls.getMethodCoverage();
        return method;
    }

    public HashMap<String, ClassCoverage> getCoverage() {
      return coverage;
    }

}
