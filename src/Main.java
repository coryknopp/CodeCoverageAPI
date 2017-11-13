import adapter.CoberturaAdapter;
import analyzer.CoverageAnalyzer;
import data_model.CoverageResults;

public class Main {

    public static void main(String[] args) {
        String serFilepath = "triangle/cobertura.ser";  // Just a placeholder for now, should eventually be '= args[0]'
        // STEP 1: Run Cobertura adapter and output CoverageResults
        CoberturaAdapter adapter = new CoberturaAdapter();
        adapter.setFilepath(serFilepath);
        CoverageResults coverage = adapter.getCoverageResults();
        // STEP 2: Analyze CoverageResults
        CoverageAnalyzer analyzer = new CoverageAnalyzer(coverage);
        // STEP 3: Build simple CoverageResults visualizer
    }
}
