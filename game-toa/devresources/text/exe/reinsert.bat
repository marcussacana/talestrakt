@echo off
call prepare.bat
dmd %TALESINCLIB% %TALESISOPATH% -run reinsert.d %*
