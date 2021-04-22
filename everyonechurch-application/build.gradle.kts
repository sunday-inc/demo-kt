tasks.getByName("jar") {
    enabled = true
}

tasks.getByName("bootJar") {
    enabled = false
}

dependencies {
    api("org.springframework.boot:spring-boot-starter-data-jpa")
    api("org.springframework.cloud:spring-cloud-starter")
    api("org.springframework.cloud:spring-cloud-starter-config")
    api("mysql:mysql-connector-java")
    api("org.codehaus.janino:janino")
    api("com.fasterxml.jackson.module:jackson-module-kotlin")
    api("org.springframework.boot:spring-boot-starter-web")
    api("org.springframework.boot:spring-boot-starter-webflux")
    // api("org.springframework.data:spring-data-redis")
    api("org.apache.poi:poi:3.11")
    api("org.apache.poi:poi-ooxml:3.11")
    api("com.amazonaws:aws-java-sdk-s3")
    api("com.amazonaws:aws-java-sdk-core")
    implementation("com.h2database:h2")

    implementation("org.springframework.boot:spring-boot-starter-cache")
    implementation("com.github.ben-manes.caffeine:caffeine")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-slf4j:1.3.7")
    implementation("net.ttddyy:datasource-proxy:1.7")

    testImplementation("com.ninja-squad:springmockk:1.1.3")
    // testImplementation("com.ninja-squad:springmockk:3.0.0")
    testImplementation("io.kotest:kotest-runner-junit5-jvm:4.1.3")
    // testImplementation("io.kotlintest:kotlintest-runner-junit5:3.4.2")

    testApi("org.springframework.boot:spring-boot-starter-test") {
        exclude(module = "junit")
        exclude(module = "junit-vintage-engine")
    }
}
