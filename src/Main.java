import adapter.CoberturaAdapter;
import analyzer.CoverageAnalyzer;
import data_model.CoverageResults;
import formatter.CSVFormatter;

public class Main {

    // 1. How are test methods/classes accessed from Cobertura?
    // 2. How should the API be used at the end? From within Java code as an object?

    public static void main(String[] args) {
        String serFilepath = args[0];
        // STEP 1: Run Cobertura adapter and output CoverageResults
        CoberturaAdapter adapter = new CoberturaAdapter(serFilepath);
        CoverageResults coverage = adapter.getCoverageResults();
        // STEP 2: Analyze CoverageResults
        CoverageAnalyzer analyzer = new CoverageAnalyzer(coverage);
        // STEP 3: Build simple CoverageResults visualizer
        CSVFormatter.drawOutput(analyzer);
    }
}
