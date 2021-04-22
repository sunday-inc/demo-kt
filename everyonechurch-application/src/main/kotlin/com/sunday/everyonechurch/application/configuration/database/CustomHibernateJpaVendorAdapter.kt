// package com.sunday.everyonechurch.application.configuration.database
//
// import org.springframework.orm.jpa.vendor.HibernateJpaDialect
// import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter
//
// class CustomHibernateJpaVendorAdapter : HibernateJpaVendorAdapter() {
//
//     private val jpaDialect: HibernateJpaDialect
//
//     init {
//         this.jpaDialect = HibernateJpaDialect()
//         jpaDialect.setPrepareConnection(false)
//     }
//
//     override fun getJpaDialect(): HibernateJpaDialect {
//         return this.jpaDialect
//     }
// }
