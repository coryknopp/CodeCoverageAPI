#!/bin/sh

echo
echo "=================================================================="
echo "Running Cobertura..."
echo "=================================================================="
echo
ant -buildfile coverage_shapes.xml coverage

echo
echo "=================================================================="
echo "Compiling coverage API..."
echo "=================================================================="
echo
ant -buildfile api.xml clean compile

echo
echo "=================================================================="
echo "Compiling coverage API tests..."
echo "=================================================================="
echo
ant -buildfile api.xml compile.tests

echo
echo "=================================================================="
echo "Running coverage API tests..."
echo "=================================================================="
echo
ant -buildfile api.xml test

echo
echo "=================================================================="
echo "Running coverage API..."
echo "=================================================================="
echo
ant -buildfile api.xml run
