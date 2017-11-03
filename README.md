# spring-boot-quartz-cluster-environment
- A demo project to execute jobs in a clustering environment with Quartz Scheduler, based on https://github.com/davidkiss/spring-boot-quartz-demo
- Quartz should be able to load balancing:
> "Never run clustering on separate machines, unless their clocks are synchronized using some form of time-sync service (daemon) that runs very regularly (the clocks must be within a second of each other). See http://www.boulder.nist.gov/timefreq/service/its.htm if you are unfamiliar with how to do this." (from documentation)

### Stack:
- Spring Boot
- Quartz
- MySQL (try docker: https://hub.docker.com/_/mysql/)

### Run
- Apply resources/db/changelog/sql/quartz_tables_mysql.sql to your database
- Run two or more instances:
```sh
$ mvn spring-boot:run
```

### Configuration (Optional)
- Quartz: *quartz.properties*
- Cron strategy: samplejob.frequency=0 * * * * ? (on application.properties)

### Quartz documentation
- http://www.quartz-scheduler.org/documentation/quartz-2.x/configuration/ConfigJDBCJobStoreClustering.html