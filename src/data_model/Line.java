package data_model;

public class Line {

    private String className;
    private int lineNumber;
    private boolean isCovered;
    private boolean isBranch;
    private ProjectMethod method;

    public Line(String className, int lineNumber, boolean isCovered, boolean isBranch) {
        this.className  = className;
        this.lineNumber = lineNumber;
        this.isCovered  = isCovered;
        this.isBranch   = isBranch;
    }

    public Line(int lineNumber, ProjectMethod method) {
        this.lineNumber = lineNumber;
        this.method = method;
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
        return isBranch;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public ProjectMethod method() {
        return method;
    }
}
