package com.example.scheduler;

import javax.sql.DataSource;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.springframework.boot.autoconfigure.quartz.QuartzDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

@Configuration
public class ApplicationConfiguration {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource mainDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @QuartzDataSource
    @ConfigurationProperties(prefix = "spring.quartz.datasource")
    public DataSource quartzDataSource() {
        return DataSourceBuilder.create().build();
    }
}
