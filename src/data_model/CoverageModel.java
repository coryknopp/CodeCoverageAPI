package data_model;

public interface CoverageModel {

      void addClassCoverage(ClassCoverage classCoverage);
      ClassCoverage get(String className);
      Object getMethodCoverage(String className);
      Object getCoverage();
}
