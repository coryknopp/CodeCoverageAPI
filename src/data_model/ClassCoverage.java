package data_model;

import java.util.HashMap;

public class ClassCoverage {

    private String name;
    private HashMap<String, MethodCoverage> methods;

    public ClassCoverage(String name) {
    	this.name = name;
    	methods = new HashMap<>();
    }

    public void addMethodData(MethodCoverage methodCoverage) {
        methods.put(methodCoverage.getName(), methodCoverage);
    }

    String getName() {
    	return name;
    }

    HashMap<String, MethodCoverage> getMethodCoverage() {
    	return methods;
    }
}
