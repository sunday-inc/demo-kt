package com.sunday.everyonechurch.api.controller

import com.sunday.everyonechurch.api.facade.SampleApiImpl
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/sample")
class SampleController(private val sampleApi: SampleApiImpl) {

    @GetMapping("/{id}")
    fun getSample(@PathVariable id: Long) : String {
        return sampleApi.getSample(id)
    }
}
