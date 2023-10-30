package com.learn.javaadvanced.configuration;

import com.learn.javaadvanced.configuration.datasource.DatasourceConfig;
import org.flywaydb.core.Flyway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DBConfig {

    @Bean
    public DataSource dataSource(DatasourceConfig datasourceConfig) {
        return datasourceConfig.setup();
    }

    @Bean
    public Flyway flyway(DataSource dataSource) {
        Flyway flyway = Flyway.configure()
                .dataSource(dataSource)
                .load();

        flyway.migrate();

        return flyway;
    }
}
