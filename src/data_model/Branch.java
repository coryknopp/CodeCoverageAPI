package data_model;

public class Branch {

  private String className;
  private int lineNumber;
  private boolean isCovered;
  private ArrayList<Boolean> conditions;

  public Branch(String className, int lineNumber, boolean isCovered, ArrayList<Boolean> conditions) {
    this.className = className;
    this.lineNumber = lineNumber;
    this.isCovered = isCovered;
    this.conditions = conditions;
  }

  public String className() {
    return className;
  }

  public int lineNumber() {
    return lineNumber;
  }

  public boolean isCovered() {
    return isCovered;
  }

  public ArrayList<Boolean> conditions() {
    return conditions;

  }


}
