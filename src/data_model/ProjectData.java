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
      if(data.get(methodData.getName()) == null)
    	 data.put(methodData.getName(), methodData);
      else {
       MethodData method = data.get(methodData.getName());
       for(Line line: methodData.getLines())
          method.addLine(line);
       for(Branch branch: methodData.getBranches())
          method.addBranch(branch);
       for(Condition condition: methodData.getConditions())
          method.addCondition(condition);
       data.put(methodData.getName(), method);
      }
    }

    public String getName() {
    	return name;
    }


    public HashMap<String, MethodData> getMethodData() {
    	return data;
    }

}
