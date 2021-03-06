#!/bin/sh

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
