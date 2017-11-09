package adapter;

import data_model.CoverageModel;

public class CoberturaAdapter implements AdapterBuilder, CoverageAdapter {

    public CoberturaAdapter() {

    }

    @Override
    public CoverageModel getCoverageModel() {
        return null;
    }

    @Override
    public void setTestClass(Class<?> testClass) {

    }
}
