# UnnamedBookingServiceFree
Free service (microservice) for online booking

## Build
Run command `$ gradle wrapper` to download and use concrete gradle version specified for project build

To build fat jar with all the app dependecies exec `$ gradle bootRepackage` task

## Deploy the database
There are a few database variations for different environments.
`todo add description`
If you want to deploy specific environment use the special gradle task.
 * databaseDev - task for deploy the developers database. Executes a specific changelog. 
 Syntax: `$ gradle task databaseDev <liquibase command>`
 * databaseTest - 

Actually app uses <i>liquibase</i> as database deployer and there are a few tip for quick manage databases via gradle and liquibase
* use `$ gradle task <environmentName> update` to deploy the database
* use `$ gradle task <environmentName> rollback -PliquibaseCommandValue=<tagName>` to rollback database to tag defined in changelog.
* use `$ gradle task <environmentName> rollbackCount -PliquibaseCommandValue=<changeSetNumber>` to rollback database to changeset you want.

<i>provide parameters to liquibase commands using `-PliquibaseCommandValue=<paramValue>`</i>