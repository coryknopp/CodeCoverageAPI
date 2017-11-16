package data_model;

public class TestMethod {

    private final Class<?> testClass;
    private final String name;

    public TestMethod(Class<?> testClass, String name) {
        this.testClass = testClass;
        this.name = name;
    }

    public Class<?> getTestClass() {
        return this.testClass;
    }

    public String getName() {
        return this.name;
    }
}
