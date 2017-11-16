package data_model;

public class Line {

  private String className;
  private int lineNumber;
  private boolean isCovered;
  private boolean isBranch;

  public Line(String className, int lineNumber, boolean isCovered, boolean isBranch) {
    this.className  = className;
    this.lineNumber = lineNumber;
    this.isCovered  = isCovered;
    this.isBranch   = isBranch;
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
  
  public boolean isBranch(){
    return isBranch
  }

}
