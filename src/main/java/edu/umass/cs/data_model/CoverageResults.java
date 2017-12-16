package edu.umass.cs.data_model;

import java.util.*;

public class CoverageResults implements CoverageModel {

    private HashMap<String, ClassCoverage> coverage;

    public CoverageResults() {
        coverage = new HashMap<>();
    }

    public void addClassCoverage(ClassCoverage classCoverage) {
        coverage.put(classCoverage.getName(), classCoverage);
    }

    public ClassCoverage getClassCoverage(String className) {
        return coverage.get(className);
    }

    public HashMap<String, MethodCoverage> getMethodCoverage(String projectClass) {
        return coverage.get(projectClass).getMethodCoverage();
    }

    public HashMap<String, ClassCoverage> getCoverage() {
      return coverage;
    }
}
