package com.sunday.everyonechurch.batch

import com.sunday.everyonechurch.Application
import com.sunday.everyonechurch.batch.job.BatchJob
import com.sunday.everyonechurch.batch.support.ThreadPoolWaitService
import org.slf4j.LoggerFactory
import org.springframework.boot.ExitCodeGenerator

import org.springframework.boot.SpringApplication
import org.springframework.boot.WebApplicationType
import org.springframework.boot.autoconfigure.SpringBootApplication
import kotlin.system.exitProcess

@SpringBootApplication(scanBasePackageClasses = [Application::class, BatchApplication::class])
class BatchApplication

val logger = LoggerFactory.getLogger(BatchApplication::class.java)

fun main(args: Array<String>) {
    if (args.isEmpty() || args.size < 2) {
        logger.error("profile and job name needed")
        return
    }

    val profile = args[0]
    val jobNameCharArray = args[1].toCharArray()
    jobNameCharArray[0] = Character.toLowerCase(jobNameCharArray[0])
    val jobName = String(jobNameCharArray)

    System.setProperty("spring.profiles.active", profile)

    val app = SpringApplication(BatchApplication::class.java)
    app.webApplicationType = WebApplicationType.NONE
    val ctx = app.run(*args)

    val job = ctx.getBean(jobName)

    try {
        if (job is BatchJob) {
            job.execute(args)
        }
    } catch (e: Exception) {
        logger.error("exception thrown", e)
    } finally {
        val threadPoolWaitService = ctx.getBean(ThreadPoolWaitService::class.java)
        threadPoolWaitService.waitUntilExecutorEnds()

        val returnCode = SpringApplication.exit(ctx, ExitCodeGenerator { 0 })
        logger.info("Shutdown batch job [name:{}, profile:{}, returnCode:{}]", jobName, profile, returnCode)

        exitProcess(returnCode)
    }
}
