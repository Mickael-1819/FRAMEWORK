@echo off
REM compilation de FW
cd Framework\etu1819
javac -d . ..\src\Mapping.java
javac -d . ..\src\ModelView.java
javac -d . ..\src\Urls.java
javac -d . ..\src\Utils.java
javac -d . ..\src\FrontServlet.java

REM exportation en jar

jar -cvf ..\..\fw.jar .
cd ..\..\

REM copie vers le projet de test
copy fw.jar Test-Framework\WEB-INF\lib

REM compilation du projet de test
cd Test-Framework\WEB-INF\classes
set CLASSPATH=%CLASSPATH%;C:\Users\itu\Documents\Mickael\Sprint5\Test-Framework\WEB-INF\lib\fw.jar
javac -d . ../../src/*.java

Rem vers Test-Framework
cd ../../
REM creation de l'archive war
jar -cvf ../TFW.war .

Rem retour sur le repertoire principal
cd ../
REM copie vers le deploiment
copy TFW.war C:\apache-tomcat-10.0.22\webapps
 