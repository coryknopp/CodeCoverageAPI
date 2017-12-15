#!/bin/sh

echo
echo "=================================================================="
echo "Running Cobertura..."
echo "=================================================================="
echo
ant -buildfile demo.xml coverage

echo
echo "=================================================================="
echo "Running coverage API..."
echo "=================================================================="
echo
ant -buildfile demo.xml run
