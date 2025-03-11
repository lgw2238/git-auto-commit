package com.gw.gitautocommit.config

import com.gw.gitautocommit.batch.GitCommitTasklet
import org.springframework.batch.core.*
import org.springframework.batch.core.job.builder.JobBuilder
import org.springframework.batch.core.repository.JobRepository
import org.springframework.batch.core.step.builder.StepBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.transaction.PlatformTransactionManager

@Configuration
class GitCommitJobConfig(
    private val gitCommitTasklet: GitCommitTasklet
) {

    @Bean
    fun gitCommitJob(jobRepository: JobRepository, gitCommitStep: Step): Job {
        return JobBuilder("gitCommitJob", jobRepository)
            .start(gitCommitStep)
            .build()
    }

    @Bean
    fun gitCommitStep(jobRepository: JobRepository, transactionManager: PlatformTransactionManager): Step {
        return StepBuilder("gitCommitStep", jobRepository)
            .tasklet(gitCommitTasklet, transactionManager)
            .build()
    }
}