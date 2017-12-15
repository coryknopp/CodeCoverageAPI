# CodeCoverageAPI

CodeCoverageAPI is a simple Java coverage analysis tool that provides an API for formatting and visualizing code coverage results.

By default, CodeCoverageAPI parses Cobertura coverage data but it can easily be extended to parse any coverage data files.

# Getting Started

Download `code-coverage-api-1.0.jar` and include it as a dependency in your Java project.

Initialize a `CoverageAnalyzer` object, including the path to your serialized data file as a parameter. Be sure that you use Cobertura version 2.0.3 to get your coverage information.

# API Methods

## isLineCovered

```
isLineCovered(String className, int lineNumber);
```

Checks if line in class is covered. Returns `true` if line is covered, otherwise `false`.

**Parameters:**

`String className` Name of class containing line.

`int lineNumber` Line number of line to be queried.

## isBranchCovered

```
isBranchCovered(String className, int lineNumber);
```

Checks if branch in class is covered. Returns `true` if branch is covered, otherwise `false`.

**Parameters:**

`String className` Name of class containing branch.

`int lineNumber` Line number of branch to be queried.

## isConditionCovered

```
isConditionCovered(String className, int lineNumber, int conditionIndex);
```

Checks if condition in class is covered. Returns `true` if condition is covered, otherwise `false`.

**Parameters:**

`String className` Name of class containing condition.

`int lineNumber` Line number of condition to be queried.

`int conditionIndex` Index of condition on line.

## totalLines

```
totalLines();
```
Returns number of lines (covered and not covered) in entire program.

## totalBranches

```
totalBranches();
```
Returns number of branches (covered and not covered) in entire program.

## totalConditions

```
totalConditions();
```
Returns number of conditions (covered and not covered) in entire program.

## totalLinesCovered

```
totalLinesCovered();
```
Returns number of lines covered in entire program.

## totalBranchesCovered

```
totalBranchesCovered();
```
Returns number of branches covered in entire program.

## totalConditionsCovered

```
totalConditionsCovered();
```
Returns number of conditions covered in entire program.

## linesCoveredInClass

```
linesCoveredInClass(String className);
```
Returns number of lines covered in class.

**Parameters:**

`String className` Name of class.

## totalLinesInClass

```
totalLinesInClass(String className);
```
Returns number of lines (covered and not covered) in class.

**Parameters:**

`String className` Name of class.

## branchesCoveredInClass

```
branchesCoveredInClass(String className);
```
Returns number of branches covered in class.

**Parameters:**

`String className` Name of class.

## totalBranchesInClass

```
totalBranchesInClass(String className);
```
Returns number of branches (covered and not covered) in class.

**Parameters:**

`String className` Name of class.

## conditionsCoveredInClass

```
conditionsCoveredInClass(String className);
```
Returns number of conditions covered in class.

**Parameters:**

`String className` Name of class.

## totalConditionsInClass

```
totalConditionsInClass(String className);
```
Returns number of conditions (covered and not covered) in class.

**Parameters:**

`String className` Name of class.

## linesInMethod

```
linesInMethod(String className, String methodName) ;
```
Returns number of lines in method.

**Parameters:**

`String className` Name of class.

`String methodName` Name of method.

## branchesInMethod

```
branchesInMethod(String className, String methodName);
```
Returns number of branches in method.

**Parameters:**

`String className` Name of class.

`String methodName Name of method.

## conditionsInMethod

```
conditionsInMethod(String className, String methodName);
```
Returns number of conditions in method.

**Parameters:**

`String className` Name of class.

`String methodName` Name of method.

## linesCoveredInMethod

```
linesCoveredInMethod(String className, String methodName);
```
Returns number of lines covered in method.

**Parameters:**

`String className` Name of class.

`String methodName` Name of method.

## branchesCoveredInMethod

```
branchesCoveredInMethod(String className, String methodName);
```
Returns number of branches covered in method.

**Parameters:**

`String className` Name of class.

`String methodName` Name of method.

## conditionsCoveredInMethod

```
conditionsCoveredInMethod(String className, String methodName);
```
Returns number of conditions covered in method.

**Parameters:**

`String className` Name of class.

`String methodName` Name of method.

## Limitations

By default, Cobertura defines branches the same as conditions. We chose to define branches differently: as boolean expressions composed of one or more conditions. In our current implementation, branch coverage information is limited to `if` and `else if` statements only because of the data provided by Cobertura. A future version could read the project source files to determine full branch coverage information manually.

A second limitation of CodeCoverageAPI is its inability to provide coverage data on a test method level. Ideally, users would be able to query coverage information for a specific test method or check what methods cover a particular line or project class. We are again limited by Cobertura's serialized data structure and the coverage information they choose to store. A future version could run Cobertura for each test method, thereby generating a separate coverage report for each test method. This would provide the desired level of granularity.