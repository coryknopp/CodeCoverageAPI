package data_model;

public class Line {

  private int lineNumber;
  private String methodName;

  public Line(int lineNumber, String methodName) {
      this.lineNumber = lineNumber;
      this.methodName = methodName;
  }

  public int getLineNumber() {
    return lineNumber;
  }

  public String getMethodName() {
    return methodName;
  }

}
