package formatter;

import analyzer.CoverageAnalyzer;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVFormatter {

    public static void drawOutput(CoverageAnalyzer analyzer) {
        String csvFile = "./coverageResults.csv";
        try {
            FileWriter writer = new FileWriter(csvFile);
            List<String> line = new ArrayList<>();
            // Get coverage results from analyzer and add to line
            CSVUtils.writeLine(writer, line);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
