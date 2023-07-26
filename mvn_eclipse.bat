@echo off
setlocal
echo.
@echo ^>^>^>^>^>^>^>     Eclipe Task   ^<^<^<^<^<^<^<

echo.
REM "Display maven version"
@echo ========== Maven version ==========
call mvnw.cmd --version

echo.
REM "Run eclipse task"
@echo ========== Run eclipse task ==========
rem -DdownloadSources -gs settings.xml 
call mvnw.cmd -B -U eclipse:clean eclipse:eclipse -T2.0C -DdownloadSources=true -Dwtpversion=2.0 %*

echo.
@echo ^>^>^>^> Finish! Press any key to exit....

PAUSE>NUL
endlocal
@echo on
