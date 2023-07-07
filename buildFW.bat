cls
@echo off
REM compilation de FW
cd Framework\build
REM javac -d . ..\src\Mapping.java
REM javac -d . ..\src\ModelView.java
REM javac -d . ..\src\Urls.java
REM javac -d . ..\src\Utils.java
REM javac -d . ..\src\FrontServlet.java

javac -parameters -d . ..\src\*.java

REM exportation en jar

jar -cvf ..\..\hh.jar .
cd ..\..\

REM copie vers le projet de test
copy hh.jar Test-Framework\WEB-INF\lib
set "gson=C:\Users\itu\Documents\Mickael\Sprint15\Test-Framework\WEB-INF\lib\gson-2.8.2.jar"


