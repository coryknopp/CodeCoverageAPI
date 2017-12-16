package edu.umass.cs;

import org.junit.Test;
import org.junit.BeforeClass;
import org.junit.Assert;

import edu.umass.cs.data_model.*;
import edu.umass.cs.analyzer.*;

public class CoverageModelTests{

  private MethodCoverage method;
  private ClassCoverage classCov;

  @Test(expected=NullPointerException.class)
  public void testCreateCoverageResults(){
    CoverageResults cr = new CoverageResults();
    Assert.assertEquals(cr.getClassCoverage("someclass").getName(), null);
  }

  private void setup(){
    method = new MethodCoverage("random");
    Line line_1 = new Line(10, true);
    Line line_2 = new Line(3, true);
    method.addLine(new Line(1, true));
    method.addBranch(new Branch(line_1, true));
    method.addBranch(new Branch(line_1, false));
    method.addCondition(new Condition(line_2, 0, true));
    method.addCondition(new Condition(line_2, 1, false));
  }

  private void setup2(){
    setup();
    classCov = new ClassCoverage("test");
    classCov.addMethodData(method);
  }

  @Test
  public void testGetters(){
    setup();
    Assert.assertEquals(method.getLines().size(), 1);
    Assert.assertEquals(method.getBranches().size(), 2);
    Assert.assertEquals(method.getConditions().size(), 2);
  }

  @Test
  public void testClassCoverage(){
    setup();
    setup2();
    Assert.assertEquals((MethodCoverage)(classCov.getMethodCoverage().get("random")), method);
  }

  @Test
  public void testCoverageResults(){
    setup();
    setup2();
    CoverageResults cov = new CoverageResults();
    cov.addClassCoverage(classCov);
    CoverageAnalyzer analyzer = new CoverageAnalyzer(cov);
    Assert.assertEquals(analyzer.linesCoveredInMethod("test", "random"), 1);
    Assert.assertEquals(analyzer.branchesCoveredInMethod("test", "random"), 2);
    Assert.assertEquals(analyzer.conditionsCoveredInMethod("test", "random"), 1);
  }

}
