package data_model;

public class Condition {

    private Line line;
    private Branch branch;
    private int index;
    private boolean isCovered;

    public Condition(Line line, Branch branch, int index, boolean isCovered) {
        this.line = line;
        this.branch = branch;
        this.index = index;
        this.isCovered = isCovered;
    }

    public Line getLine() {
        return line;
    }

    public Branch getBranch() {
        return branch;
    }

    public int getIndex() {
        return index;
    }

    public boolean isCovered() {
        return isCovered;
    }
}
