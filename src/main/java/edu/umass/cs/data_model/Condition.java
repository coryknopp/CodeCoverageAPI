package edu.umass.cs.data_model;

public class Condition {

    private Line line;
    private int index;
    private boolean isCovered;

    public Condition(Line line, int index, boolean isCovered) {
        this.line = line;
        this.index = index;
        this.isCovered = isCovered;
    }

    public Line getLine() {
        return line;
    }

    public int getIndex() {
        return index;
    }

    public boolean isCovered() {
        return isCovered;
    }
}
