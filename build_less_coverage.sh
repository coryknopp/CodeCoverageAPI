#!/bin/sh

echo
echo "=================================================================="
echo "Running Cobertura..."
echo "=================================================================="
echo
ant -buildfile coverage_less.xml coverage

echo
echo "=================================================================="
echo "Compiling coverage API..."
echo "=================================================================="
echo
ant -buildfile api_less.xml clean compile

echo
echo "=================================================================="
echo "Compiling coverage API tests..."
echo "=================================================================="
echo
ant -buildfile api_less.xml compile.tests

echo
echo "=================================================================="
echo "Running coverage API tests..."
echo "=================================================================="
echo
ant -buildfile api_less.xml test

echo
echo "=================================================================="
echo "Running coverage API..."
echo "=================================================================="
echo
ant -buildfile api_less.xml run
