package analyzer;

import data_model.*;
import adapter.*;
import java.util.*;

public interface Analyzer {


	// implemented
	boolean isLineCovered(String className, int line);
	boolean isBranchCovered(String className, int line);
	boolean isConditionCovered(String className, int line, int condition);
	int lineCoveredCount(String className, int lineNumber);
	int branchCoveredCount(String className, int lineNumber);
	int conditionCoveredCount(String className, int lineNumber, int conditionIndex);
	int totalLinesCovered(String className);
	int totalBranchesCovered(String className);
	int totalConditions(String className);
	

	// TODO:
	int totalLines(String className);
	int totalBranches(String className);
	int totalConditionsCovered(String className);
	int linesInMethod(String className, String methodName);
	int branchesInMethod(String className, String methodName);
	int conditionsInMethod(String className, String methodName);
	int linesCoveredInMethodCount(String className, String methodName);
	int branchesCoveredInMethodCount(String className, String methodName);
	int conditionsCoveredInMethodCount(String className, String methodName);
	int[] linesCoveredByTest(String className, String testName);
	int[] branchesCoveredByTest(String className, String testName);
	int[] conditionsCoveredByTest(String className, String testName);

	
}