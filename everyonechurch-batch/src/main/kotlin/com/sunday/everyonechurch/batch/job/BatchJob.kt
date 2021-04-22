package com.sunday.everyonechurch.batch.job

interface BatchJob {
    fun execute(args: Array<String>)
}
