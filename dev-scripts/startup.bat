@echo off
set JAVA_HOME=C:\Program Files\Java\jdk-11.0.13

IF [%1] == [main] (
    cd ../SpringBootTask
    mvn clean install
    docker build --tag springboottask .
    cd ..
    docker compose --env-file ./dev-scripts/.local.env up springboottask --build
)
IF [%1] == [client] (
    cd ../SpringFeignService
    mvn clean install
    docker build --tag springfeignservice .
    docker compose --env-file ./dev-scripts/.local.env up springfeignservice --build
) ELSE (
echo Invalid argument.
)