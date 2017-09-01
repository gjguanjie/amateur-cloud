package com.cloud.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

@EnableTransactionManagement
@Configuration
@EnableConfigurationProperties(value = MybatisDatasourceProperties.class)
public class MybatisDatasourceAutoConfiguration implements TransactionManagementConfigurer {

    @Autowired
    private MybatisDatasourceProperties mybatisDatasourceProperties;
    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager();
    }
}
