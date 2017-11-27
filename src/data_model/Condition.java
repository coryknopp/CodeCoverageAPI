package data_model;

public class Condition {

    private Line line;
    private Branch branch;
    private int index;

    public Condition(Line line, Branch branch, int index) {
        this.line = line;
        this.branch = branch;
        this.index = index;
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
}
