package com.sunday.everyonechurch.batch.support

import org.slf4j.Logger
import org.slf4j.LoggerFactory

import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.task.TaskExecutor
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor
import org.springframework.stereotype.Service

@Service
class ThreadPoolWaitService {
    val logger: Logger = LoggerFactory.getLogger(ThreadPoolWaitService::class.java)

    @Autowired
    private val taskExecutors: List<TaskExecutor>? = null

    fun waitUntilExecutorEnds() {
        logger.info("[ThreadPoolWaitService] taskExecutors 체크 시작")

        for (taskExecutor in taskExecutors!!) {
            if (taskExecutor is ThreadPoolTaskExecutor) {

                waitForSubmittedTaskFinishedOrTimeout(taskExecutor.threadPoolExecutor)
                logger.info("server active task is handled")

                taskExecutor.setAwaitTerminationSeconds(TIMEOUT_IN_SEC)
                taskExecutor.shutdown()
            }
        }
        logger.info("[ThreadPoolWaitService] taskExecutors 체크 종료")

        logger.info("[ThreadPoolWaitService] wait default time 시작")
        await(10)
        logger.info("[ThreadPoolWaitService] wait default time 종료")
    }

    private fun waitForSubmittedTaskFinishedOrTimeout(executor: ThreadPoolExecutor) {
        val timeoutMillis = TimeUnit.SECONDS.toMillis(ThreadPoolWaitService.TIMEOUT_IN_SEC.toLong())
        val start = System.currentTimeMillis()
        while (executor.activeCount > 0) {
            await(1)
            if (System.currentTimeMillis() - start > timeoutMillis) {
                logger.info("server active tasks is not finished")
                break
            }
        }
    }

    private fun await(waitSeconds: Long) {
        try {
            Thread.sleep(TimeUnit.SECONDS.toMillis(waitSeconds))
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }

    }

    companion object {
        private val TIMEOUT_IN_SEC = 10
    }
}
