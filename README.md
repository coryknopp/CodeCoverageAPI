# CodeCoverageAPI

To execute coverage API, run `sh build.sh`. This will run Cobertura to get coverage data and then run coverage API.

Alternatively, run `sh run.sh` to build the coverage API without running Cobertura first. This will only work if `cobertura.ser` already exists.

To run all coverage API JUnit tests, run `sh test.sh`.

# Getting Started

Download `code-coverage-1.0.jar` and include as a dependency in your Java project.

Initialize a `CoverageAnalyzer` object, including the path to your serialized data file as a parameter. Be sure that you use Cobertura version 2.0.3 to get your coverage information.

# API Methods

`boolean isLineCovered(String className, int lineNumber)  throws IllegalArgumentException;`

`boolean isBranchCovered(String className, int lineNumber) throws IllegalArgumentException;`

`boolean isConditionCovered(String className, int lineNumber, int conditionIndex) throws IllegalArgumentException;`

`int totalLines();`

`int totalBranches();`

`int totalConditions();`

`int totalLinesCovered();`

`int totalBranchesCovered();`

`int totalConditionsCovered();`

`int linesCoveredInClass(String className) throws IllegalArgumentException;`

`int totalLinesInClass(String className) throws IllegalArgumentException;`

`int branchesCoveredInClass(String className) throws IllegalArgumentException;`

`int totalBranchesInClass(String className) throws IllegalArgumentException;`

`int conditionsCoveredInClass(String className) throws IllegalArgumentException;`

`int totalConditionsInClass(String className) throws IllegalArgumentException;`

`int linesInMethod(String className, String methodName) throws IllegalArgumentException;`

`int branchesInMethod(String className, String methodName) throws IllegalArgumentException;`

`int conditionsInMethod(String className, String methodName) throws IllegalArgumentException;`

`int linesCoveredInMethod(String className, String methodName) throws IllegalArgumentException;`

`int branchesCoveredInMethod(String className, String methodName) throws IllegalArgumentException;`

`int conditionsCoveredInMethod(String className, String methodName) throws IllegalArgumentException;`
