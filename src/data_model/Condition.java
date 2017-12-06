package data_model;

public class Condition {

    private Line line;
    private Branch branch;
    private int index;
    private float coverageRate;

    public Condition(Line line, Branch branch, int index, float coverageRate) {
        this.line = line;
        this.branch = branch;
        this.index = index;
        this.coverageRate = coverageRate;
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

    public float getCoverageRate() {
        return coverageRate;
    }
}
