package data_model;

public class Branch {

  private String className;
  private int lineNumber;
  private boolean isCovered;

  public Branch(String className, int lineNumber, boolean isCovered) {
    this.className = className;
    this.lineNumber = lineNumber;
    this.isCovered = isCovered;
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


}
