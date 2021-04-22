package com.sunday.everyonechurch.batch.job

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class TestBatchJob: BatchJob {
    val logger: Logger = LoggerFactory.getLogger(TestBatchJob::class.java)

    override fun execute(args: Array<String>) {
        logger.info("test job executed.")
    }

}
