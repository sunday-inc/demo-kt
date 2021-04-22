// package com.sunday.everyonechurch.application.configuration.database
//
// import org.springframework.beans.factory.ObjectProvider
// import org.springframework.boot.autoconfigure.orm.jpa.JpaBaseConfiguration
// import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties
// import org.springframework.context.annotation.Configuration
// import org.springframework.orm.jpa.vendor.AbstractJpaVendorAdapter
// import org.springframework.transaction.jta.JtaTransactionManager
// import javax.sql.DataSource
//
// @Configuration
// class CustomHibernateJpaAutoConfiguration(dataSource: DataSource,
//                                           jpaProperties: JpaProperties,
//                                           jtaTransactionManager: ObjectProvider<JtaTransactionManager>) : JpaBaseConfiguration(dataSource, jpaProperties, jtaTransactionManager) {
//
//     override fun createJpaVendorAdapter(): AbstractJpaVendorAdapter {
//         return CustomHibernateJpaVendorAdapter()
//     }
//
//     override fun getVendorProperties(): Map<String, Any> {
//         return emptyMap()
//     }
// }
