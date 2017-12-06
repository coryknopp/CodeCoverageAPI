package data_model;

public class Branch {

    private Line line;
    private boolean isCovered;

    public Branch(Line line, boolean isCovered) {
        this.line = line;
        this.isCovered = isCovered;
    }

    public Line getLine() {
    return line;
  }

    public boolean isCovered() {
        return isCovered;
    }
}
