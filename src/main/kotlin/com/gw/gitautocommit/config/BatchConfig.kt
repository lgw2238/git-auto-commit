package com.gw.gitautocommit.config

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jdbc.datasource.DataSourceTransactionManager
import javax.sql.DataSource

@Configuration
@EnableBatchProcessing
class BatchConfig {

    @Bean
    fun transactionManager(dataSource: DataSource) = DataSourceTransactionManager(dataSource)
}