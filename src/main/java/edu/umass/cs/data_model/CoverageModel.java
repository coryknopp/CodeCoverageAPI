package edu.umass.cs.data_model;

public interface CoverageModel {

      void addClassCoverage(ClassCoverage classCoverage);
      ClassCoverage getClassCoverage(String className);
      Object getMethodCoverage(String className);
      Object getCoverage();
}
