@echo off
REM 
REM This script parses a heap dump.
REM
REM Usage: ParseHeapDump.sh <path/to/dump.hprof> [report]*
REM 
REM The leak report has the id org.eclipse.mat.api:suspects
REM 

./MemoryAnalyzer -application org.eclipse.mat.api.parse %1 %2 %3 %4 %5 %6 %7 %8 %9
	