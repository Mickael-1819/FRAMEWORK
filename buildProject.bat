@echo off
cls

REM classpath 
set CLASSPATH=%CLASSPATH%;C:\Users\itu\Documents\Mickael\Sprint15\Test-Framework\WEB-INF\lib\hh.jar


REM Déclaration des variables de chemin
REM nom du projet dans le deploiement
set "name=OK"

REM Compilation des fichiers de src vers le dossier classes avec l'option parameters dans Framework
 cd Test-Framework\src
javac -parameters -d . ..\src\*.java

javac  -d  "C:\Users\itu\Documents\Mickael\Sprint15\Test-Framework\WEB-INF\classes" *.java
cd ../../

REM chemin vers le repertoire webapps de tomcat
set "deploy=C:\apache-tomcat-10.0.22\webapps"

jar -cvf "%name%".war *

REM Copie du fichier .war dans le répertoire webapps de Tomcat
copy "%name%".war "%deploy%"

echo Deploiement effectue.

