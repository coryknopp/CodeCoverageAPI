import org.junit.Test;
import org.junit.BeforeClass;
import org.junit.Assert;

import analyzer.*;

public class CoverageAnalyzerTests {

	public static CoverageAnalyzer analyzer;

	@BeforeClass
	public static void setup(){
		String serFilepath = "cobertura.ser";
		analyzer = new CoverageAnalyzer(serFilepath);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testNullOnIsLineCovered(){
		analyzer.isLineCovered(null, 0);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testNullOnIsConditionCovered(){
		analyzer.isConditionCovered(null, 0, 0);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testNullOnIsBranchCovered(){
		analyzer.isBranchCovered(null, 0);
	}

	@Test
	public void testLineCoverage(){
		Assert.assertEquals(analyzer.isLineCovered("shapes.Triangle", 20), true);
	  Assert.assertEquals(analyzer.isLineCovered("shapes.Triangle", 21), false);
	}

	@Test
	public void testBranchCoverage(){
		Assert.assertEquals(analyzer.isBranchCovered("shapes.Triangle", 27), true);
		Assert.assertEquals(analyzer.isBranchCovered("shapes.Triangle", 33), true);
		Assert.assertEquals(analyzer.isBranchCovered("shapes.Triangle", 34), false);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testWrongLineOnLineCoverage(){
		Assert.assertEquals(analyzer.isLineCovered("shapes.Triangle", 55), false);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testWrongClassnameOnLineCoverage(){
		Assert.assertEquals(analyzer.isLineCovered("nothing", 0), false);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testWrongLineOnConditionCoverage(){
		Assert.assertEquals(analyzer.isConditionCovered("shapes.Triangle", 28, 0), false);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testWrongClassnameOnConditionCoverage(){
		Assert.assertEquals(analyzer.isConditionCovered("unicorn", 28, 0), false);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testWrongInputOnBranchCoverage(){
		Assert.assertEquals(analyzer.isBranchCovered("shapes.Triangle", 28), false);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testWrongClassOnBranchCoverage(){
		Assert.assertEquals(analyzer.isBranchCovered("iranoutofnames", 1), false);
	}

	@Test
	public void testConditionCoverage(){
		Assert.assertEquals(analyzer.isConditionCovered("shapes.Triangle", 34, 0), false);
		Assert.assertEquals(analyzer.isConditionCovered("shapes.Triangle", 27, 0), true);
	}

	@Test
	public void testTotalLines(){
		Assert.assertEquals(analyzer.totalLines(), 47);
	}

	@Test
	public void testTotalLineCount(){
			Assert.assertEquals(analyzer.totalLinesCovered(), 37);
	}

	@Test
	public void testTotalConditions(){
		Assert.assertEquals(analyzer.totalConditions(), 25);
	}

	@Test
	public void testTotalConditionsCovered(){
		Assert.assertEquals(analyzer.totalConditionsCovered(),11);
	}

	@Test
	public void testTotalBranches(){
		Assert.assertEquals(analyzer.totalBranches(), 18);
	}

	@Test
	public void testTotalBranchesCovered(){
		Assert.assertEquals(analyzer.totalBranchesCovered(), 9);
	}

	@Test
	public void testTotalLinesInClass(){
		Assert.assertEquals(analyzer.totalLinesInClass("shapes.Triangle"), 23);
		Assert.assertEquals(analyzer.totalLinesInClass("shapes.Rectangle"), 20);
	}

	@Test
	public void testLinesCoveredInClass(){
		Assert.assertEquals(analyzer.linesCoveredInClass("shapes.Triangle"), 17);
		Assert.assertEquals(analyzer.linesCoveredInClass("shapes.Rectangle"), 16);
	}

	@Test
	public void testTotalConditionsInClass(){
		Assert.assertEquals(analyzer.totalConditionsInClass("shapes.Triangle"), 17);
		Assert.assertEquals(analyzer.totalConditionsInClass("shapes.Rectangle"), 8);
	}

	@Test
	public void testConditionsCoveredInClass(){
		Assert.assertEquals(analyzer.conditionsCoveredInClass("shapes.Triangle"), 6);
		Assert.assertEquals(analyzer.conditionsCoveredInClass("shapes.Rectangle"), 5);
	}

	@Test
	public void testTotalBranchesInClass(){
		Assert.assertEquals(analyzer.totalBranchesInClass("shapes.Triangle"), 10);
		Assert.assertEquals(analyzer.totalBranchesInClass("shapes.Rectangle"), 8);
	}

	@Test
	public void testBranchesCoveredInClass(){
		Assert.assertEquals(analyzer.branchesCoveredInClass("shapes.Triangle"), 4);
		Assert.assertEquals(analyzer.branchesCoveredInClass("shapes.Rectangle"), 5);
	}

	@Test
	public void testLinesInMethod(){
		Assert.assertEquals(analyzer.linesInMethod("shapes.Triangle", "classify"), 22);
		Assert.assertEquals(analyzer.linesInMethod("shapes.Rectangle", "classify"), 5);
	}

	@Test
	public void testBranchesInMethod(){
		Assert.assertEquals(analyzer.branchesInMethod("shapes.Triangle", "classify"), 10);
		Assert.assertEquals(analyzer.branchesInMethod("shapes.Rectangle", "classify"), 2);
	}

	@Test
	public void testConditionsInMethod(){
		Assert.assertEquals(analyzer.conditionsCoveredInMethod("shapes.Triangle", "classify"), 6);
		Assert.assertEquals(analyzer.conditionsCoveredInMethod("shapes.Rectangle", "classify"), 2);
	}

	@Test
	public void testLinesCoveredInMethod(){
		Assert.assertEquals(analyzer.linesCoveredInMethod("shapes.Triangle", "classify"), 17);
		Assert.assertEquals(analyzer.linesCoveredInMethod("shapes.Rectangle", "classify"), 5);
	}

	@Test
	public void testBranchesCoveredInMethod(){
		Assert.assertEquals(analyzer.branchesCoveredInMethod("shapes.Triangle", "classify"), 9);
		Assert.assertEquals(analyzer.branchesCoveredInMethod("shapes.Rectangle", "classify"), 2);
	}
}
