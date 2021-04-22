package com.sunday.everyonechurch.application.configuration.database


import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component
import java.sql.SQLException
import java.sql.Statement
import javax.sql.DataSource


/*
@Configuration
class DataSourceConfiguration {
    @Bean("dataSource")
    @ConfigurationProperties(prefix = "spring.datasource.h2")
    fun dataSource(): DataSource {
        return HikariDataSource()
    }
}
*/
@Component
class DatabaseConfig : ApplicationRunner {
    @Autowired
    var dataSource: DataSource? = null

    @Throws(SQLException::class)
    override fun run(args: ApplicationArguments?) {
        try {
            dataSource!!.connection.use { connection ->
                println(connection.metaData.url)
                println(connection.metaData.userName)
                val statement: Statement = connection.createStatement()
                val sql = "CREATE TABLE TESTTABLE(ID INTEGER NOT NULL, VALUE VARCHAR(255), PRIMARY KEY (ID) )"
                statement.executeUpdate(sql)
                val sql2 = "INSERT INTO TESTTABLE VALUES(1, 'value')"
                statement.execute(sql2)
            }
        } catch (e: Exception) {
            println(e)
        }
    }
}
