@echo off
taskkill /F /IM javaw.exe

:: Closes minecraft log
powershell -Command "Get-Process | Where-Object { $_.MainWindowTitle -eq 'Minecraft game output' } | ForEach-Object { $_.CloseMainWindow() }"

:: VBScript to set focus to a window
echo Set objShell = WScript.CreateObject("WScript.Shell") > ActivateWindow.vbs
echo objShell.AppActivate "Minecraft Launcher" >> ActivateWindow.vbs
::ping localhost -n 5
:: Run the VBScript
cscript //nologo ActivateWindow.vbs

:: Delete the temporary VBScript file
del ActivateWindow.vbs
exit