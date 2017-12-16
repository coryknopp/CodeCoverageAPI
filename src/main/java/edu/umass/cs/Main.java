package edu.umass.cs;

import edu.umass.cs.analyzer.CoverageAnalyzer;

public class Main {

    public static void main(String[] args) {
        String serFilepath = args[0];
        CoverageAnalyzer analyzer = new CoverageAnalyzer(serFilepath);
    }
}
