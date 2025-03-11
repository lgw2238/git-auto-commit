package com.gw.gitautocommit.scheduler

import org.springframework.batch.core.Job
import org.springframework.batch.core.JobParametersBuilder
import org.springframework.batch.core.launch.JobLauncher
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@EnableScheduling
@Component
class BatchScheduler(
    private val jobLauncher: JobLauncher,
    private val gitCommitJob: Job
) {

//    @Scheduled(cron = "0 0 0 * * ?") // 매일 자정 실행
    @Scheduled(cron = "0 * * * * ?") // 매 1분마다 실행
    fun runJob() {
        val jobParameters = JobParametersBuilder()
            .addLong("timestamp", System.currentTimeMillis())
            .toJobParameters()
        jobLauncher.run(gitCommitJob, jobParameters)
    }
}