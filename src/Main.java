import analyzer.CoverageAnalyzer;

public class Main {

    public static void main(String[] args) {
        String serFilepath = args[0];
        CoverageAnalyzer analyzer = new CoverageAnalyzer(serFilepath);
        System.out.println("OUR RESULTS:");
        System.out.println("Total lines in triangle " + analyzer.lineCount("triangle.Triangle"));
        System.out.println("Lines covered in triangle " + analyzer.lineCoveredCount("triangle.Triangle"));
        System.out.println("Total branches in triangle " + analyzer.branchCount("triangle.Triangle"));
        System.out.println("Branches covered in triangle " + analyzer.branchCoveredCount("triangle.Triangle"));
        System.out.println("Total conditions in triangle " + analyzer.conditionCount("triangle.Triangle"));
        System.out.println("Conditions covered in triangle " + analyzer.conditionCoveredCount("triangle.Triangle"));
        System.out.println("Line 15 Covered " + analyzer.isLineCovered("triangle.Triangle", 15));
        System.out.println("Line 21 Covered " + analyzer.isLineCovered("triangle.Triangle", 21));
        System.out.println("Lines in classify " + analyzer.linesInMethod("triangle.Triangle", "classify"));
        System.out.println("Branches in classify " + analyzer.branchesInMethod("triangle.Triangle", "classify"));
        System.out.println("Conditions in classify " + analyzer.conditionsInMethod("triangle.Triangle", "classify"));
    }
}
