@echo off
pushd ..\..\lib
call talesinclib.bat
popd
dmd btlcommon.d %TALESINCLIB% -run reinsert.d %*
