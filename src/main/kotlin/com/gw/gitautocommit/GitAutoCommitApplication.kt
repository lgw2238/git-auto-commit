package com.gw.gitautocommit

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class GitAutoCommitApplication

fun main(args: Array<String>) {
    runApplication<GitAutoCommitApplication>(*args)
}
