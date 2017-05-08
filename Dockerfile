FROM payara/server-full:171

RUN wget -P $PAYARA_PATH/glassfish/domains/domain1/lib/ext/ \
    http://central.maven.org/maven2/mysql/mysql-connector-java/5.1.41/mysql-connector-java-5.1.41.jar

RUN \
    $PAYARA_PATH/bin/asadmin start-domain && \

    $PAYARA_PATH/bin/asadmin --passwordfile=/opt/pwdfile \
    create-jdbc-connection-pool \
    --datasourceclassname com.mysql.jdbc.jdbc2.optional.MysqlDataSource \
    --restype javax.sql.DataSource \
    --property user=root:password=root:DatabaseName="calendar-server":ServerName=db:port=3306 \
    calendar-server-pool && \

    $PAYARA_PATH/bin/asadmin --passwordfile=/opt/pwdfile \
    create-jdbc-resource --connectionpoolid calendar-server-pool jdbc/calendar-server
