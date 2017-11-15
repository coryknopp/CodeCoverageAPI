package data_model;

public class Line {

  private int lineNumber;
  private boolean isCovered;

  public Line(int lineNumber, boolean isCovered) {
    this.lineNumber = lineNumber;
    this.isCovered = isCovered;
  }

  public int lineNumber() {
    return lineNumber;
  }

  public boolean isCovered() {
    return isCovered;
  }

}
