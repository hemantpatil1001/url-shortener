package com.urlytics.shorttrace_service.configuration;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import com.zaxxer.hikari.HikariConfig;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class DataSourceConfig {

        @Bean(name = "hikari-config")
        @ConfigurationProperties("spring.datasource")
        public HikariConfig hikariConfigPrimary() {
            return new HikariConfig();
        }

        @Bean
        public DataSource primaryDataSource(HikariConfig config) {
            return new HikariDataSource(config);
        }

        @Bean("jdbc-template")
        public NamedParameterJdbcTemplate masterJdbcTemplate(DataSource dsPrimary) {
            return new NamedParameterJdbcTemplate(dsPrimary);
        }
}
