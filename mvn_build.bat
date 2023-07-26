@echo off
setlocal
echo.
@echo ^>^>^>^>^>^>^>     Build Task   ^<^<^<^<^<^<^<

echo.
REM "Display maven version"
@echo ========== Maven version ==========
call mvnw.cmd --version

echo.
REM "Run eclipse task"
@echo ========== Run build task ==========
rem -DdownloadSources -gs settings.xml
set MAX_DEVICE=4
set MODULE_LIST="1,2,3"
call mvnw.cmd -B -U clean package -T2.0C -Dmaven.javadoc.skip=true -Dmaven.test.skip=true %*

echo.
@echo ^>^>^>^> Finish! Press any key to exit....

PAUSE>NUL
endlocal
@echo on
