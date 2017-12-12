# CodeCoverageAPI

To execute coverage API, run `sh build.sh`. This will run Cobertura to get coverage data and then run coverage API.

Alternatively, run `sh run.sh` to build the coverage API without running Cobertura first. This will only work if `cobertura.ser` already exists.

To run all coverage API JUnit tests, run `sh test.sh`.

# Getting Started

Download `code-coverage-1.0.jar` and include as a dependency in your Java project.

Initialize a `CoverageAnalyzer` object, including the path to your serialized data file as a parameter. Be sure that you use Cobertura version 2.0.3 to get your coverage information.

# API Methods

## isLineCovered

`isLineCovered(String className, int lineNumber);`

Checks if line in class is covered. Returns true if line is covered, otherwise false.

**Parameters:**

`String className` Name of class containing line.

`int lineNumber` Line number of line to be queried.

**Returns:** boolean

`true` if line is covered, otherwise `false`.

## isBranchCovered

`isBranchCovered(String className, int lineNumber);`

Checks if branch in class is covered.

**Parameters:**

`String className` Name of class containing branch.

`int lineNumber` Line number of branch to be queried.

**Returns:** boolean

`true` if branch is covered, otherwise `false`.

## isConditionCovered

`isConditionCovered(String className, int lineNumber, int conditionIndex);`

Checks if condition in class is covered. Returns true if condition is covered, otherwise false.

**Parameters:**

`String className` Name of class containing condition.

`int lineNumber` Line number of condition to be queried.

`int conditionIndex` Index of condition on line.

**Returns:** boolean

`true` if condition is covered, otherwise `false`.

## totalLines

`totalLines();`

## totalBranches

`totalBranches();`

## totalConditions

`totalConditions();`

## totalLinesCovered

`totalLinesCovered();`

## totalBranchesCovered

`totalBranchesCovered();`

## totalConditionsCovered

`totalConditionsCovered();`

## linesCoveredInClass

`linesCoveredInClass(String className);`

## totalLinesInClass

`totalLinesInClass(String className);`

## branchesCoveredInClass

`branchesCoveredInClass(String className);`

## totalBranchesInClass

`totalBranchesInClass(String className);`

## conditionsCoveredInClass

`conditionsCoveredInClass(String className);`

## totalConditionsInClass

`totalConditionsInClass(String className);`

## linesInMethod

`linesInMethod(String className, String methodName) ;`

## branchesInMethod

`branchesInMethod(String className, String methodName);`

## conditionsInMethod

`conditionsInMethod(String className, String methodName);`

## linesCoveredInMethod

`linesCoveredInMethod(String className, String methodName);`

## branchesCoveredInMethod

`branchesCoveredInMethod(String className, String methodName);`

## conditionsCoveredInMethod

`conditionsCoveredInMethod(String className, String methodName);`
