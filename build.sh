#!/bin/sh

echo
echo "=================================================================="
echo "Running Cobertura..."
echo "=================================================================="
echo
ant -buildfile coverage.xml coverage

echo
echo "=================================================================="
echo "Compiling coverage API..."
echo "=================================================================="
echo
ant -buildfile api.xml clean compile

echo
echo "=================================================================="
echo "Running coverage API..."
echo "=================================================================="
echo
ant -buildfile api.xml run
