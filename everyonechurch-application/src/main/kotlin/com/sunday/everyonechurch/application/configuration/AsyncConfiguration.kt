package com.sunday.everyonechurch.application.configuration

import java.util.concurrent.Executor

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.AsyncConfigurer
import org.springframework.scheduling.annotation.EnableAsync
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor

@Configuration
@EnableAsync
class AsyncConfiguration : AsyncConfigurer {

    @Bean(name = ["asyncTaskExecutor"], destroyMethod = "shutdown")
    fun asyncTaskExecutor(): ThreadPoolTaskExecutor {
        return createTaskExecutor("asyncTask", Runtime.getRuntime().availableProcessors(), 100, 100000)
    }

    private fun createTaskExecutor(s: String, corePoolSize: Int, maxPoolSize: Int, queueSize: Int): ThreadPoolTaskExecutor {
        val waitTime = 3
        val executor = ThreadPoolTaskExecutor()
        executor.corePoolSize = corePoolSize
        executor.maxPoolSize = maxPoolSize
        executor.setThreadNamePrefix(s)
        executor.setQueueCapacity(queueSize)
        executor.setAwaitTerminationSeconds(waitTime)
        executor.setWaitForTasksToCompleteOnShutdown(true)
        executor.setTaskDecorator(MdcTaskDecorator())
        executor.initialize()
        return executor
    }

    override fun getAsyncExecutor(): Executor {
        return asyncTaskExecutor()
    }

    override fun getAsyncUncaughtExceptionHandler(): AsyncUncaughtExceptionHandler {
        return DefaultAsyncExceptionHandler()
    }
}
