package formatter;

import edu.umass.cs.analyzer.CoverageAnalyzer;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CSVFormatter {

    public static void drawOutput(CoverageAnalyzer analyzer) {
        HashMap<String, String> coverage = getResults(analyzer);
        String csvFile = "./coverageResults.csv";
        try {
            FileWriter writer = new FileWriter(csvFile);
            for (String key : coverage.keySet()) {
                List<String> line = new ArrayList<>();
                line.add(key);
                line.add(coverage.get(key));
                CSVUtils.writeLine(writer, line);
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static HashMap<String, String> getResults(CoverageAnalyzer analyzer) {
        HashMap<String, String> coverage = new HashMap<>();
        coverage.put("Total lines in triangle",
                Integer.toString(analyzer.totalLinesInClass("triangle.Triangle")));
        coverage.put("Lines covered in triangle",
                Integer.toString(analyzer.linesCoveredInClass("triangle.Triangle")));
        coverage.put("Total branches in triangle",
                Integer.toString(analyzer.totalBranchesInClass("triangle.Triangle")));
        coverage.put("Branches covered in triangle",
                Integer.toString(analyzer.branchesCoveredInClass("triangle.Triangle")));
        coverage.put("Total conditions in triangle",
                Integer.toString(analyzer.totalConditionsInClass("triangle.Triangle")));
        coverage.put("Conditions covered in triangle",
                Integer.toString(analyzer.conditionsCoveredInClass("triangle.Triangle")));
        coverage.put("Line 15 Covered",
                Boolean.toString(analyzer.isLineCovered("triangle.Triangle", 15)));
        coverage.put("Line 21 Covered",
                Boolean.toString(analyzer.isLineCovered("triangle.Triangle", 21)));
        coverage.put("Lines in classify",
                Integer.toString(analyzer.linesInMethod("triangle.Triangle", "classify")));
        coverage.put("Branches in classify",
                Integer.toString(analyzer.branchesInMethod("triangle.Triangle", "classify")));
        coverage.put("Conditions in classify",
                Integer.toString(analyzer.conditionsInMethod("triangle.Triangle", "classify")));
        return coverage;
    }
}
