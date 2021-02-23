# Alas d.o.o. Java developer test assignment

## How to run the application

1. Install Java 8: Go to https://adoptopenjdk.net/ and download version 8. If the Operating System is Windows: set the system environments for `JAVA_HOME` (jdk root folder) and `PATH` (jdk root folder\bin)
2. To start the backend run `mvnw spring-boot:run` command (control + c will kill the application)
3. Build the frontend: `cd src/frontend`, `yarn`. (install `yarn` and `node` if needed)
4. To start the frontend go to `src/frontend` and run `yarn start`. It will run on `localhost:3000`.

## How to run the tests
1. Start backend with `mvnw spring-boot:run` command
2. Go to `src/frontend` and run `yarn start`
3. Back to project folder and start tests with `mvnhttps://github.com/veca22/java_test_assignment/blob/main/README.mdw test` (This command will start all tests)
4. If you want to change browser with command line: `mvnw test -Dbrowser=chrome` (chrome,firefox,ie,edge)
5. Default browser for tests is Firefox
