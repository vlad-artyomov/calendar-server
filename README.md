[![Build Status](https://travis-ci.org/vlad-artyomov/calendar-server.svg?branch=develop)](https://travis-ci.org/vlad-artyomov/calendar-server)

# Calendar-server

Calendar app REST backend.

# How to run in one step

```
mvn clean install

java -jar src/main/resources/payara/payara-micro-4.1.1.171.0.1.jar \
--deploy target/calendar-server.war \
--domainConfig src/main/resources/payara/domain.xml
```

# Running on Payara Full:

1. Put [MySQL Connector](http://central.maven.org/maven2/mysql/mysql-connector-java/5.1.41/mysql-connector-java-5.1.41.jar) to `$PAYARA_DIR/glassfish/domains/domain1/lib/ext/`

2. Create the connection pool (run from Payara root directory):

```
bin/asadmin create-jdbc-connection-pool \
--datasourceclassname com.mysql.jdbc.jdbc2.optional.MysqlDataSource \
--restype javax.sql.DataSource \
--property user=root:password=root:DatabaseName="calendar-server":ServerName=localhost:port=3306 \
calendar-server-pool
```

3. Test connection:

```
bin/asadmin ping-connection-pool calendar-server-pool
```
    
4. Create JDBC resource:

```
bin/asadmin create-jdbc-resource --connectionpoolid calendar-server-pool jdbc/calendar-server
```
