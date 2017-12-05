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
        /*if (methods.get(methodCoverage.getName()) == null) {
            methods.put(methodCoverage.getName(), methodCoverage);
        } else {
            MethodCoverage method = methods.get(methodCoverage.getName());
            for (Line line: methodCoverage.getLines()) {
                method.addLine(line);
            }
            for (Branch branch: methodCoverage.getBranches()) {
                method.addBranch(branch);
            }
            for (Condition condition: methodCoverage.getConditions()) {
                method.addCondition(condition);
                methods.put(methodCoverage.getName(), method);
            }
        }*/
    }

    public String getName() {
    	return name;
    }


    public HashMap<String, MethodCoverage> getMethodCoverage() {
    	return methods;
    }

}
