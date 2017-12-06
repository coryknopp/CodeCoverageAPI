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
		complete = System.getProperty("isCompleteCoverage").equals("true")
	}

	@Test
	public void testLineCoverage(){
		boolean line20 = true; //line 20 is covered in both cases
		boolean line21 = complete ? true : false; //line 21 is covered in complete test case but not partial
		Assert.assertEquals(analyzer.isLineCovered("classify", 20), line20);
	  Assert.assertEquals(analyzer.isLineCovered("classify", 21), line21);
	}

	@Test
	public void testBranchCoverage(){
		boolean line28 = true;
		boolean line34 = complete ? true : false;
		boolean line35 = complete ? true : false;
		Assert.assertEquals(analyzer.isBranchCovered("classify", 28), line28);
		Assert.assertEquals(analyzer.isBranchCovered("classify", 34), line34);
		Assert.assertEquals(analyzer.isBranchCovered("classify", 35), line35);
	}

	@Test
	public void testConditionCoverage(){
		boolean line20 = complete ? true : false;
		boolean line34 = complete ? true : false;
		boolean line27 = true;
		Assert.assertEquals(analyzer.isConditionCovered("classify", 20), line20);
		Assert.assertEquals(analyzer.isConditionCovered("classify", 34), line34);
		Assert.assertEquals(analyzer.isConditionCovered("classify", 27), line27);
	}

	@Test
	public void testLineCount(){
		int line20 = complete ? 66 : 4;
		int line21 = complete ? 17 : 0;
		int line34 = complete ? 23 : 0;
		int line39 = 0;
		Assert.assertEquals(analyzer.lineCoveredCount("classify", 20), line20);
		Assert.assertEquals(analyzer.lineCoveredCount("classify", 21), line21);
		Assert.assertEquals(analyzer.lineCoveredCount("classify", 34), line34);
		Assert.assertEquals(analyzer.lineCoveredCount("classify", 39), line39);
	}

}
