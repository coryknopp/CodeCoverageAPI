package edu.umass.cs.data_model;

import java.util.ArrayList;

public class MethodCoverage {

    private String name;
    private ArrayList<Line> lines;
    private ArrayList<Branch> branches;
    private ArrayList<Condition> conditions;

    public MethodCoverage(String name) {
        this.name = name;
        lines = new ArrayList<>();
        branches = new ArrayList<>();
        conditions = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Line> getLines() {
        return lines;
    }

    public ArrayList<Branch> getBranches() {
        return branches;
    }

    public ArrayList<Condition> getConditions() {
        return conditions;
    }

    public void addLine(Line line) {
        lines.add(line);
    }

    public void addBranch(Branch branch) {
        branches.add(branch);
    }

    public void addCondition(Condition condition) {
        conditions.add(condition);
    }
}
