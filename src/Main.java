import adapter.CoberturaAdapter;
import analyzer.CoverageAnalyzer;
import data_model.CoverageResults;
import formatter.CSVFormatter;
import data_model.*;

public class Main {

    // 1. How are test methods/classes accessed from Cobertura?
            //      int[] linesCoveredByTest(Class<?> z);
            //      int[] branchesCoveredByTest(Class<?> z);
            //      int[] conditionsCoveredByTest(Class<?> z);

    // 2. How should the API be used at the end? From within Java code as an object?

    public static void main(String[] args) {
        String serFilepath = args[0];
        // STEP 1: Run Cobertura adapter and output CoverageResults
        CoberturaAdapter adapter = new CoberturaAdapter(serFilepath);
        CoverageResults coverage = adapter.getCoverageResults();
        // STEP 2: Analyze CoverageResults
        CoverageAnalyzer analyzer = new CoverageAnalyzer(coverage);
        //System.out.println(analyzer.lineCoveredCount("triangle.Triangle"));
        System.out.println("Total lines in triangle " + analyzer.lineCount("triangle.Triangle"));
        System.out.println("Lines covered in triangle " + analyzer.lineCoveredCount("triangle.Triangle"));
        System.out.println("Line 15 Covered? " + analyzer.isLineCovered("triangle.Triangle", 15));
        System.out.println("Lines in classify " + analyzer.linesInMethod("triangle.Triangle", "classify"));
        // STEP 3: Build simple CoverageResults visualizer
        CSVFormatter.drawOutput(analyzer);
    }
}
