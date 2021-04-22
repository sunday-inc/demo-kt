tasks.getByName("bootJar") {
    version = System.getenv("VERSION") ?: project.version
    enabled = true
}

val applicationTest: SourceSetOutput = project(":everyonechurch-application").sourceSets["test"].output

dependencies {
    implementation(project(":everyonechurch-application"))

    implementation("io.springfox:springfox-swagger2")
    implementation("io.springfox:springfox-swagger-ui")
    implementation("org.springframework.boot:spring-boot-starter-web")

    testCompile(applicationTest)
    testImplementation("com.nhaarman.mockitokotlin2:mockito-kotlin:2.1.0")
    testImplementation("org.mockito:mockito-inline:2.21.0")
    testImplementation("io.kotest:kotest-runner-junit5-jvm:4.1.3")
    testImplementation("com.ninja-squad:springmockk:1.1.3")

    implementation("io.github.microutils:kotlin-logging:1.6.22")

    testApi("org.springframework.boot:spring-boot-starter-test") {
        exclude(module = "junit")
        exclude(module = "junit-vintage-engine")
    }
}

