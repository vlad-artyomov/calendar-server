[![Build Status](https://travis-ci.org/vlad-artyomov/calendar-server.svg?branch=develop)](https://travis-ci.org/vlad-artyomov/calendar-server)

# Calendar-server

Calendar app REST backend.

# Running on Payara Micro

```
mvn clean install

java -jar payara/payara-micro-4.1.1.171.0.1.jar \
--deploy target/calendar-server.war \
--domainConfig payara/domain.xml
```

> Note: app will use ClearDB MySQL database hosted on remote server. If you want to use local MySQL instance, please follow steps below.

# Running on Payara Full

1. Put [MySQL Connector](http://central.maven.org/maven2/mysql/mysql-connector-java/5.1.41/mysql-connector-java-5.1.41.jar) to `$PAYARA_DIR/glassfish/domains/domain1/lib/ext/`

2. Create the connection pool and JDBC resource ($PAYARA_DIR is Payara root directory).

    For local MySQL database:
    
    Create new schema in MySQL with following name: `calendar-server`, and then execute these commands:

    ```
    $PAYARA_DIR/bin/asadmin start-domain domain1
    
    $PAYARA_DIR/bin/asadmin create-jdbc-connection-pool \
    --datasourceclassname com.mysql.jdbc.jdbc2.optional.MysqlDataSource \
    --restype javax.sql.DataSource \
    --property user=root:password=root:DatabaseName="calendar-server":ServerName=localhost:port=3306 \
    calendar-server-pool
    
    $PAYARA_DIR/bin/asadmin ping-connection-pool calendar-server-pool
    
    $PAYARA_DIR/bin/asadmin create-jdbc-resource --connectionpoolid calendar-server-pool jdbc/calendar-server
    ```

    For ClearDB MySQL database hosted on Heroku:

    ```
    $PAYARA_DIR/bin/asadmin start-domain domain1
    
    $PAYARA_DIR/bin/asadmin create-jdbc-connection-pool \
    --datasourceclassname com.mysql.jdbc.jdbc2.optional.MysqlDataSource \
    --restype javax.sql.DataSource \
    --property user=b8319090ec8df5:password=3a7f277c:url=jdbc\\:mysql\\://eu-cdbr-west-01.cleardb.com/heroku_7c5fb08fbed7fb7 \
    calendar-server-pool
    
    $PAYARA_DIR/bin/asadmin ping-connection-pool calendar-server-pool
    
    $PAYARA_DIR/bin/asadmin create-jdbc-resource --connectionpoolid calendar-server-pool jdbc/calendar-server
    ```

3. Build and deploy app:

    ```
    mvn clean install
    
    cp target/calendar-server.war $PAYARA_DIR/glassfish/domains/domain1/autodeploy/
    ```
    
# Running using Docker

TODO