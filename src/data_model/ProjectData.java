package data_model;

import java.util.HashMap;

public class ProjectData {

    private String name;
    private HashMap<String, MethodData> data;

    public ProjectData(String name) {
    	this.name = name;
    	data = new HashMap<>();
    }

    public void addMethodData(MethodData methodData) {
    	data.put(methodData.getName(), methodData);
    }

    public String getName() {
    	return name;
    }

    public HashMap<String, MethodData> getMethodData() {
    	return data;
    }

}
