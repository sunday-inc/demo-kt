package com.sunday.everyonechurch.domain.model

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.transaction.annotation.Transactional

@Transactional
interface FooRepository : JpaRepository<Foo, Long>
