# CodeCoverageAPI

To execute coverage API, run `sh build.sh`. This will run Cobertura to get coverage data and then run coverage API.

Alternatively, run `sh run.sh` to build the coverage API without running Cobertura first. This will only work if `cobertura.ser` already exists.

To run all coverage API JUnit tests, run `sh test.sh`.

# Getting Started

Download `code-coverage-1.0.jar` and include as a dependency in your Java project.

Initialize a `CoverageAnalyzer` object, including the path to your serialized data file as a parameter. Be sure that you use Cobertura version 2.0.3 to get your coverage information.

# API Methods

## isLineCovered

`boolean isLineCovered(String className, int lineNumber)  throws IllegalArgumentException;`

## isBranchCovered

`boolean isBranchCovered(String className, int lineNumber) throws IllegalArgumentException;`

## isConditionCovered

`boolean isConditionCovered(String className, int lineNumber, int conditionIndex) throws IllegalArgumentException;`

## totalLines

`int totalLines();`

## totalBranches

`int totalBranches();`

## totalConditions

`int totalConditions();`

## totalLinesCovered

`int totalLinesCovered();`

## totalBranchesCovered

`int totalBranchesCovered();`

## totalConditionsCovered

`int totalConditionsCovered();`

## linesCoveredInClass

`int linesCoveredInClass(String className) throws IllegalArgumentException;`

## totalLinesInClass

`int totalLinesInClass(String className) throws IllegalArgumentException;`

## branchesCoveredInClass

`int branchesCoveredInClass(String className) throws IllegalArgumentException;`

## totalBranchesInClass

`int totalBranchesInClass(String className) throws IllegalArgumentException;`

## conditionsCoveredInClass

`int conditionsCoveredInClass(String className) throws IllegalArgumentException;`

## totalConditionsInClass

`int totalConditionsInClass(String className) throws IllegalArgumentException;`

## linesInMethod

`int linesInMethod(String className, String methodName) throws IllegalArgumentException;`

## branchesInMethod

`int branchesInMethod(String className, String methodName) throws IllegalArgumentException;`

## conditionsInMethod

`int conditionsInMethod(String className, String methodName) throws IllegalArgumentException;`

## linesCoveredInMethod

`int linesCoveredInMethod(String className, String methodName) throws IllegalArgumentException;`

## branchesCoveredInMethod

`int branchesCoveredInMethod(String className, String methodName) throws IllegalArgumentException;`

## conditionsCoveredInMethod

`int conditionsCoveredInMethod(String className, String methodName) throws IllegalArgumentException;`
