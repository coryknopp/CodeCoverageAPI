import org.junit.Test;
import org.junit.BeforeClass;
import org.junit.Assert;

import analyzer.*;

public class CoverageAnalyzerTests {

	public static CoverageAnalyzer analyzer;
	public static boolean complete;

	@BeforeClass
	public static void setup(){
		String serFilepath = "cobertura.ser";
		analyzer = new CoverageAnalyzer(serFilepath);
		complete = System.getProperty("isCompleteCoverage").equals("true");
		String a = complete ? "complete" : "incomplete";
		System.out.println("Testing on " + a + " test cases");
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
		boolean line20 = true; //line 20 is covered in both cases
		boolean line21 = complete ? true : false; //line 21 is covered in complete test case but not partial
		Assert.assertEquals(analyzer.isLineCovered("shapes.Triangle", 20), line20);
	  Assert.assertEquals(analyzer.isLineCovered("shapes.Triangle", 21), line21);
	}

	@Test
	public void testBranchCoverage(){
		boolean line27 = true;
		boolean line33 = true;
		boolean line34 = complete ? true : false;
		Assert.assertEquals(analyzer.isBranchCovered("shapes.Triangle", 27), line27);
		Assert.assertEquals(analyzer.isBranchCovered("shapes.Triangle", 33), line33);
		Assert.assertEquals(analyzer.isBranchCovered("shapes.Triangle", 34), line34);
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
		//line 28 is not a condition
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
		//boolean line20_0 = complete ? true : false;
		boolean line34_0 = complete ? true : false;
		boolean line27_0 = true;
		//Assert.assertEquals(analyzer.isConditionCovered("shapes.Triangle", 20, 0), line20_0);
		Assert.assertEquals(analyzer.isConditionCovered("shapes.Triangle", 34, 0), line34_0);
		Assert.assertEquals(analyzer.isConditionCovered("shapes.Triangle", 27, 0), line27_0);
	}

	@Test
	public void testTotalLines(){
		Assert.assertEquals(analyzer.totalLines(), 47);
	}

	@Test
	public void testTotalLineCount(){
		if (complete) {
			Assert.assertEquals(analyzer.totalLinesCovered(), 43);
		}else{
			Assert.assertEquals(analyzer.totalLinesCovered(), 37);
		}
	}

	@Test
	public void testTotalConditions(){
		Assert.assertEquals(analyzer.totalConditions(), 25);
	}

	@Test
	public void testTotalConditionsCovered(){
		int conditions_covered = complete ? 22 : 11;
		Assert.assertEquals(analyzer.totalConditionsCovered(),conditions_covered);
	}

	@Test
	public void testTotalBranches(){
		Assert.assertEquals(analyzer.totalBranches(), 18);
	}

	@Test
	public void testTotalBranchesCovered(){
		int branches_covered = complete ? 15 : 9;
		Assert.assertEquals(analyzer.totalBranchesCovered(), branches_covered);
	}

	@Test
	public void testLinesCoveredInClass(){
		int lines_covered = complete ? 25 : 19;
		Assert.assertEquals(analyzer.linesCoveredInClass("shapes.Triangle"), lines_covered);
		Assert.assertEquals(analyzer.linesCoveredInClass("shapes.Rectangle"), 18);
	}

	@Test
	public void testTotalLinesInClass(){
		Assert.assertEquals(analyzer.totalLinesInClass("shapes.Triangle"), 25);
		Assert.assertEquals(analyzer.totalLinesInClass("shapes.Rectangle"), 22);
	}

	@Test
	public void testConditionsCoveredInClass(){
		int conditions = complete ? 17 : 14;

	}
}
