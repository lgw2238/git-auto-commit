package com.gw.gitautocommit.service

import org.eclipse.jgit.api.Git
import org.eclipse.jgit.api.errors.GitAPIException
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.io.File
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Service
class GitService {
    private val logger = LoggerFactory.getLogger(GitService::class.java)

    private val repoPath = "localRepoPath"
    private val commitMessage = "Daily auto ${getCurrentDate()}"
    private val username = "gitName"
    private val password = "accessToken"

    fun commitAndPush() {
        logger.info("🚀 Commit and push start.")
        try {
            val git = Git.open(File(repoPath))
            git.add().addFilepattern(".").call()
            git.commit().setMessage(commitMessage).call()

            val credentials = UsernamePasswordCredentialsProvider(username, password)
            git.push().setCredentialsProvider(credentials).call()

            logger.info("✅ Commit and push success.")
        } catch (e: GitAPIException) {
            e.printStackTrace()
        }
    }

    private final fun getCurrentDate(): String {
        val currentDate = LocalDate.now()
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        return currentDate.format(formatter)
    }
}