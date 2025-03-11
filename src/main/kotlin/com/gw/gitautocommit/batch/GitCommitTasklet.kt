package com.gw.gitautocommit.batch

import com.gw.gitautocommit.service.GitService
import org.springframework.batch.core.StepContribution
import org.springframework.batch.core.scope.context.ChunkContext
import org.springframework.batch.repeat.RepeatStatus
import org.springframework.stereotype.Component

@Component
class GitCommitTasklet(
    private val gitService: GitService
) : org.springframework.batch.core.step.tasklet.Tasklet {
    override fun execute(contribution: StepContribution, chunkContext: ChunkContext): RepeatStatus {
        gitService.commitAndPush()
        return RepeatStatus.FINISHED
    }
}