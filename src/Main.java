import analyzer.CoverageAnalyzer;
import formatter.CSVFormatter;

public class Main {

    public static void main(String[] args) {
        String serFilepath = args[0];
        CoverageAnalyzer analyzer = new CoverageAnalyzer(serFilepath);
        CSVFormatter.drawOutput(analyzer);
    }
}
